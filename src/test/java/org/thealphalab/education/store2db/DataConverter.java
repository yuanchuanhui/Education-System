package org.thealphalab.education.store2db;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.thealphalab.education.model.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataConverter {

    public List<Student> convertCsv2Students() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm");
        Reader reader = new FileReader(
                "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/学生基本数据信息（本科生）.csv");
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(',').withFirstRecordAsHeader().parse(reader);
        List<Student> students = new ArrayList<>();
        for (CSVRecord record : records) {
            Student student = null;
            try {
                student = new Student(
                        Integer.parseInt(record.get(0).replace("\"", "")),
                        record.get(1).replace("\"", ""),
                        record.get(2).replace("\"", "").equals("男"),
                        simpleDateFormat.parse(record.get(3).replace("\"", "")),
                        record.get(9).replace("\"", "")
                );
            } catch (ParseException e) {
                System.out.println(record.get(3).replace("\"", "") + "作为日期解析错误");
                e.printStackTrace();
                continue;
            }
            students.add(student);
        }
        return students;
    }

    public static Map<Integer, YxshAndSzbh> getYxshAndSzbh() throws IOException, InvalidFormatException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Map<Integer, YxshAndSzbh> map = new HashMap<>();
        File xlsFile = new File("/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/学籍基本数据信息（本科生）.xls");
        // 获得工作簿
        Workbook workbook = WorkbookFactory.create(xlsFile);
        Sheet sheet = workbook.getSheetAt(0);
        // 获得行数
        int rowNum = sheet.getLastRowNum() + 1;
        // 获得列数，先获得一行，在得到改行列数
        int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
        // 读取数据
        for (int row = 1; row < rowNum; row++)
        {
            Row r = sheet.getRow(row);
            try {
                YxshAndSzbh yxshAndSzbh = new YxshAndSzbh(
                        Integer.parseInt(r.getCell(1).getStringCellValue()),
                        r.getCell(11).getStringCellValue(),
                        simpleDateFormat.parse(r.getCell(0).getStringCellValue().substring(0, 4))
                );
                map.put(Integer.parseInt(r.getCell(0).getStringCellValue()), yxshAndSzbh);
            }catch (IllegalStateException e) {
                System.out.println(r.getCell(0).getStringCellValue() + "失败");
            }catch (NullPointerException e){
                System.out.println("空指针");
            } catch (ParseException e) {
                System.out.println("日期转换错误");
                e.printStackTrace();
            }
        }
        return map;
    }

    public List<Course> convertCsv2Courses() throws IOException {
        Reader reader = new FileReader(
                "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/课程数据信息（本科生）.csv");
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(',').withFirstRecordAsHeader().parse(reader);
        List<Course> courses = new ArrayList<>();
        for (CSVRecord record : records) {
            Course course = null;
            try {
                course = new Course(record.get(0).replace("\"", ""),
                        record.get(1).replace("\"", ""));
            }catch (ArrayIndexOutOfBoundsException e){
                continue;
            }catch (Exception e){
                System.out.println(record.get(13).replace("\"", "") + e.getClass().getName());
            }
            courses.add(course);
        }
        return courses;
    }

    public static List<Grade> getGrades() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
        Reader reader = new FileReader(
                "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/本科生成绩信息.csv");
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(',').withFirstRecordAsHeader().parse(reader);
        List<Grade> grades = new ArrayList<>();
        int i = 0;
        for (CSVRecord record : records) {
            Grade grade = null;
            try {
                Course course = new Course(record.get(4));
                Student student = new Student(Integer.parseInt(record.get(0)));
                Date gtime = simpleDateFormat.parse(record.get(3));
                int score = Integer.parseInt(record.get(10));
                float credit = Float.parseFloat(record.get(14));
                int courseType = Integer.parseInt(record.get(18));
                grade = new Grade(
                        course,
                        student,
                        gtime,
                        score,
                        credit,
                        courseType
                );
            }catch (Exception e){
                i++;
            }
            grades.add(grade);
        }
        System.out.println(i + "条信息出现异常");
        System.out.println(grades.get(0));
        return grades;
    }

    public static List<Xiaofei> getXiaofeis(String path, String fileName) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Reader reader = new FileReader(
                path + fileName);
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(';').parse(reader);
        List<Xiaofei> xiaofeis = new ArrayList<>();
        int i = 0;
        for (CSVRecord record : records) {
            Xiaofei xiaofei = null;
            try {
                Student student = new Student(Integer.parseInt(record.get(0)));
                Xiaofeileixing xflx = new Xiaofeileixing(record.get(1));
                Date xftime = simpleDateFormat.parse(record.get(4));
                String xfaddress = record.get(5);
                float xfmoney = Float.parseFloat(record.get(2));
                xiaofei = new Xiaofei(
                        student,
                        xflx,
                        xftime,
                        xfaddress,
                        xfmoney
                );
            }catch (NumberFormatException e){
                i++;
            }catch (Exception e){
                e.printStackTrace();
                i++;
            }
            record = null;
            xiaofeis.add(xiaofei);
        }
        System.out.println("共" + i + "条信息出现异常");
        return xiaofeis;
    }

    public static List<Tushu> getTushus(String path, String fileName) throws IOException {
        Reader reader = new FileReader(
                path + fileName);
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(';').withFirstRecordAsHeader().parse(reader);
        List<Tushu> tushus = new ArrayList<>();
        int i = 0;
        for (CSVRecord record : records) {
            Tushu tushu = null;
            try {
                String tsid = record.get(11);
                String isbn = record.get(19);
                String tsname = record.get(6);
                String tssort = record.get(7);
                String tsauthor = record.get(2);
                tushu = new Tushu(
                    tsid, isbn, tsname, tssort, tsauthor
                );
                tushus.add(tushu);
            }catch (Exception e){
                e.printStackTrace();
                i++;
            }
            record = null;
        }
        System.out.println("共" + i + "条信息出现异常");
        return tushus;
    }

    public static List<Jieshu> getJieshus(String path, String fileName) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Reader reader = new FileReader(
                path + fileName);
        Iterable<CSVRecord> records =
                CSVFormat.newFormat(';').withFirstRecordAsHeader().parse(reader);
        List<Jieshu> jieshus = new ArrayList<>();
        int i = 0;
        for (CSVRecord record : records) {
            Jieshu jieshu = null;
            try {
                Student student = new Student(Integer.parseInt(record.get(0)));
                Tushu tushu = new Tushu(record.get(1));
                Date jydate = simpleDateFormat.parse(record.get(4));
                Date jsyhdate = null;
                if(!record.get(5).trim().equals("")){
                    jsyhdate = simpleDateFormat.parse(record.get(5));
                }
                jieshu = new Jieshu(
                        student, tushu, jydate, jsyhdate
                );
                jieshus.add(jieshu);
            }catch (Exception e){
                i++;
            }
            record = null;
        }
        System.out.println("共" + i + "条信息出现异常");
        return jieshus;
    }
    
}
