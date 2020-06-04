package org.thealphalab.education.dataimporter;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.thealphalab.education.mapper.GradeMapper;
import org.thealphalab.education.others.Utils;

public class GradeDataImporter {

    private GradeMapper gradeMapper;

    public GradeDataImporter(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    public void updateGradeByGterm(){
        Iterable<CSVRecord> records = Utils.readCsvFile(
                "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/",
                "本科生成绩信息.csv", ',', true);
        assert records != null;
        records.forEach(record ->{
            String stuid = record.get(0);
            String cid = record.get(4);
            // 1学期代表上学期，即9月-2月这个学期
            String gterm = record.get(1).split("-")[0] + record.get(2);
            try {
                gradeMapper.updateByPrimaryKey(stuid, cid, gterm);
            }catch (Exception e){
                System.err.println("更新失败，数据行为\t" + stuid + "\t" + cid + "\t错误为" + e.getClass().getName());
            }
            if(record.getRecordNumber() % 10000 == 0){
                System.err.println(record.getRecordNumber());
            }
        });
    }

}
