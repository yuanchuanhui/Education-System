package org.thealphalab.education.store2db;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.thealphalab.education.mapper.*;
import org.thealphalab.education.model.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.util.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
public class DataStorage {

    /**
     * 查看表和数据的对应关系 python
     * def demoData(path):
     *      file = open(path)
     *      one = file.readline().split(',')
     *      two = file.readline().split(',')
     *      for attr in zip(one, two):
     *          print(attr)
     * 由于数据库中表存在的外键约束，要导入数据的话下面几个方法要顺序执行。
      */

    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private Class_Mapper class_Mapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private XiaofeiMapper xiaofeiMapper;
    @Autowired
    private TushuMapper tushuMapper;
    @Autowired
    private JieshuMapper jieshuMapper;

    @Test
    @Rollback(false)
    /**
      * 向数据库中插入由学籍表导出的学院信息.
      */
    public void storeSchool2DB() throws IOException, InvalidFormatException {
        Map<Integer, YxshAndSzbh> map = DataConverter.getYxshAndSzbh();
        Set<School> schools = new HashSet<>();
        for (YxshAndSzbh value : map.values()) {
            School school = new School(value.getYxsh());
            schools.add(school);
        }
        List<School> schoolList = new ArrayList<>(schools);
        System.out.println("插入了" + schoolMapper.insertAll(schoolList) + "行！");
    }

    /**
     * 向数据库中插入由学籍表导出的班级信息.
     */
    @Test
    @Rollback(false)
    public void storeClass2DB() throws IOException, InvalidFormatException {
        Map<Integer, YxshAndSzbh> map = DataConverter.getYxshAndSzbh();
        Set<Class_> classSet = new HashSet<>();
        for (YxshAndSzbh value : map.values()) {
            Class_ class_ = new Class_(
                    value.getSzbh(),
                    value.getYear(),
                    new School(value.getYxsh()));
            classSet.add(class_);
        }
        List<Class_> classList = new ArrayList<>(classSet);
        System.out.println("插入了" + class_Mapper.insertAll(classList) + "行！");
    }

    /**
     * 向数据库中插入由学生表导出的学生信息.
     */
    @Test
    @Rollback(false)
    public void storeStudent2DB() throws IOException, ParseException, InvalidFormatException {
        DataConverter dataConverter = new DataConverter();
        List<Student> students = dataConverter.convertCsv2Students();
        Map<Integer, YxshAndSzbh> map = DataConverter.getYxshAndSzbh();
        int i =0;
        for (Student student : students) {
            YxshAndSzbh yxshAndSzbh = map.get(student.getStuid());
            if(yxshAndSzbh == null){
                System.out.println(student.getStuid() + "学生的信息为空");
            }else {
                School school = new School(yxshAndSzbh.getYxsh());
                student.setStuschool(school);
                student.setStuclass(new Class_(yxshAndSzbh.getSzbh(), school));
                try {
                    studentMapper.insert(student);
                }catch (DataIntegrityViolationException e){
                    System.out.println(student.getStuid() + "外键错误");
                }
                i++;
            }
        }
        System.out.println("共插入" + i + "行");
    }

    /**
     * 向数据库中插入课程信息.
     */
    @Test
    @Rollback(false)
    public void storeCourse2DB() throws IOException, InvalidFormatException {
        DataConverter dataConverter = new DataConverter();
        List<Course> courses = dataConverter.convertCsv2Courses();
        int i =0;
        for (Course course: courses) {
            try {
                courseMapper.insert(course);
            }catch (DuplicateFormatFlagsException e){
                e.printStackTrace();
                System.out.println(course.getCid() + "重复");
            }catch (DataIntegrityViolationException e){
                e.printStackTrace();
                System.err.println(course + "重复");
            }
            i++;
        }
        System.out.println("共插入" + i + "行");
    }

    /**
     * 向数据库中插入成绩信息.
     */
    @Test
    @Rollback(false)
    public void storeGrade2DB() throws IOException {
        List<Grade> grades = DataConverter.getGrades();
        int success = 0;
        int fail = 0;
        int i = 0;
        for (Grade grade: grades) {
            i++;
            try {
                gradeMapper.insert(grade);
                success++;
            }catch (DuplicateFormatFlagsException | DataIntegrityViolationException e){
                fail++;
//                System.err.println(grade);
            }
            grade = null;
            if(i % 1000 == 0){
                System.out.println("成功插入" + success + "行，" + "失败" + fail + "行！");
            }
        }
    }

    @Test
    @Rollback(false)
    public void storeXiaofei2DB() throws IOException {
        String path = "/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/一卡通消费日志3/";
        File dic = new File(path);
        if (dic.isDirectory()) {
            int count = 0;
            File[] files = dic.listFiles();
            for (File file : files) {
                long start = System.currentTimeMillis();
                List<Xiaofei> xiaofeis = DataConverter.getXiaofeis(path, file.getName());
                for (Xiaofei xiaofei : xiaofeis) {
//                    try {
//                        xiaofeiMapper.insert(xiaofei);
//                        count++;
//                    }catch (Exception e){
////                        e.printStackTrace();
////                        System.out.println(xiaofei);
//                    }
//                    xiaofei = null;
//                }
                    try {
                        count = xiaofeiMapper.insertAll(xiaofeis);
                    } catch (SQLIntegrityConstraintViolationException | DataIntegrityViolationException e) {
                        e.printStackTrace();
                    }
                    System.out.println("成功插入" + count + "条");
                    System.out.println("用了" + (System.currentTimeMillis() - start) + "ms");
                }
            }
        }
    }

    /**
      * 未测试
      */
    @Test
    @Rollback(false)
    public void storeTushu2DB() throws IOException {
        List<Tushu> tushus = DataConverter.getTushus("/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/", 
                "图书基本信息.csv");
        for (int i = 0; i < tushus.size(); i += 500) {
            try {
                tushuMapper.insertAll(tushus.subList(i, i + 500));
                System.out.println("已插入" + i + "条记录，共" + tushus.size() + "条记录");
            }catch (SQLIntegrityConstraintViolationException e){
                System.out.println("重复key");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    @Rollback(false)
    public void storeJieshu2DB() throws IOException {
        List<Jieshu> jieshus = DataConverter.getJieshus("/home/ych/文档/docs/postgraduate/AI Education/大工数据/数据/",
                "读者借阅日志.csv");
        for (int i = 0; i < jieshus.size(); i++) {
            try {
                jieshuMapper.insertAll(jieshus.subList(i, i + 200));
//                jieshuMapper.insert(jieshus.get(i));
                if(i % 1000 == 0){
                    System.out.println("已插入" + i + "条记录，共" + jieshus.size() + "条记录");
                }
            }catch (SQLIntegrityConstraintViolationException e){
                System.out.println("重复key");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
