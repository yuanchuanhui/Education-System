package org.thealphalab.education.dataimporter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.model.Student;
import org.thealphalab.education.model.Xiaofei;
import org.thealphalab.education.model.Xiaofeileixing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class XiaofeiDataImporter {

    private XiaofeiMapper xiaofeiMapper;

    public XiaofeiDataImporter(XiaofeiMapper xiaofeiMapper) {
        this.xiaofeiMapper = xiaofeiMapper;
    }

    /**
     * xfid
     * stuid				xh	    0
     * xflxname				jylx	1
     * xftime				jysj	4
     * xfadress				jydd	5
     * xfmoney				jyje	2
      */



    public Iterable<CSVRecord> readCsvFile(String path, String fileName, char sep){
        Reader reader = null;
        Iterable<CSVRecord> records = null;
        try {
            reader = new FileReader(path + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到，请检查文件位置。");
            return null;
        }
        try {
            records = CSVFormat.newFormat(sep).parse(reader);
        } catch (IOException e) {
            System.out.println("CSV文件格式错误");
            return null;
        }
        return records;
    }

    /**
     * xfid
     * stuid				xh	    0
     * xflxname				jylx	1
     * xftime				jysj	4
     * xfadress				jydd	5
     * xfmoney				jyje	2
     */

    public void storeXiaofeisFromCSVFile(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        for (int i = 1; i <= 3; i++) {
            Iterable<CSVRecord> records = readCsvFile(
                    "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/", "一卡通消费日志" + i + ".txt", ';');
            System.out.println("当前文件" + i);
            // 跳过表头
            records.iterator().next();
            List<Xiaofei> xiaofeis = new ArrayList<>(512);
            for (CSVRecord record : records) {
                int stuid = 0;
                try {
                    stuid = Integer.parseInt(record.get(0));
                }catch (NumberFormatException e){
                    System.out.println("学号解析错误，当前学号为" + record.get(0));
                    continue;
                }
                String xflxname = record.get(1);
                Date xftime = null;
                try {
                    xftime = simpleDateFormat.parse(record.get(4));
                } catch (ParseException e) {
                    System.out.println("日期解析错误，当前日期为" + record.get(4));
                    continue;
                }
                String xfaddress = record.get(5);
                float xfmoney = Float.parseFloat(record.get(2));
                Xiaofei xiaofei = new Xiaofei();
                xiaofei.setStudent(new Student(stuid));
                Xiaofeileixing xiaofeileixing = new Xiaofeileixing(xflxname);
                xiaofei.setXflx(xiaofeileixing);
                xiaofei.setXftime(xftime);
                xiaofei.setXfaddress(xfaddress);
                xiaofei.setXfmoney(xfmoney);
                xiaofeis.add(xiaofei);
                if (record.getRecordNumber() % 1000 == 0){
                    System.out.println(record.getRecordNumber());
                    try{
                        xiaofeiMapper.insertAll(xiaofeis);
                    }catch (Exception e){
                        System.out.println(e.getClass().getName());
                        continue;
                    }
                    xiaofeis.clear();
                }
            }
        }
    }

}
