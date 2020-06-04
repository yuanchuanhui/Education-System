package org.thealphalab.education.dataimporter;

import org.apache.commons.csv.CSVRecord;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.stereotype.Component;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.model.Student;
import org.thealphalab.education.model.Xiaofei;
import org.thealphalab.education.model.Xiaofeileixing;
import org.thealphalab.education.others.Utils;

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
    public void storeXiaofeisFromCSVFile(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (int i = 1; i <= 3; i++) {
            Iterable<CSVRecord> records = Utils.readCsvFile(
                    "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/", "一卡通消费日志" + i + ".txt", ';', false);
            System.out.println("当前文件" + i);
            // 跳过表头
            records.iterator().next();
            List<Xiaofei> xiaofeis = new ArrayList<>(16384);
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
                if (record.getRecordNumber() % 10000 == 0){
                    System.out.println(record.getRecordNumber());
                    try{
                        xiaofeiMapper.insertAll(xiaofeis);
                    }catch (Exception e){
                        System.out.println(e.getClass().getName());
                        e.printStackTrace();
                        continue;
                    }
                    xiaofeis.clear();
                }
            }
        }
    }

}
