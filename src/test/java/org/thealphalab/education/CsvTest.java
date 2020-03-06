package org.thealphalab.education;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvTest {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(
                "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/学生基本数据信息（本科生）.csv");
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(',').withFirstRecordAsHeader().parse(reader);
        int i = 0;
        for (CSVRecord record : records) {
            System.out.println(record.get(1));
            i++;
            if(i == 10){
                break;
            }
        }
    }

}
