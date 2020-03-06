package org.thealphalab.education;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.thealphalab.education.model.*;
import org.thealphalab.education.store2db.DataConverter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.*;

public class OtherTest {

    @Test
    public void setTest(){
        Set<School> schools = new HashSet<>();
        schools.add(new School(1));
        schools.add(new School(1));
        System.out.println(schools.size());
    }

    @Test
    public void testParseInt(){
        System.out.println((int)Double.parseDouble("52.0"));
    }

    @Test
    public void test() throws Exception{
        System.out.println(DataConverter.getJieshus("/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/",
                "读者借阅日志.txt").size() + "大小");
    }

}
