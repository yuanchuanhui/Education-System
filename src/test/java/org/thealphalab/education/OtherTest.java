package org.thealphalab.education;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.thealphalab.education.chartdata.LineChartData;
import org.thealphalab.education.dataimporter.GradeDataImporter;
import org.thealphalab.education.dataimporter.XiaofeiDataImporter;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.mapper.GradeMapper;
import org.thealphalab.education.mapper.JieshuMapper;
import org.thealphalab.education.mapper.StudentMapper;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.model.Group;
import org.thealphalab.education.model.School;
import org.thealphalab.education.model.Student;
import org.thealphalab.education.others.Utils;
import org.thealphalab.education.service.JieshuService;

import java.text.ParseException;
import java.util.*;

@MybatisTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE )
public class OtherTest {

    @Autowired
    private XiaofeiMapper xiaofeiMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private JieshuMapper jieshuMapper;
    @Autowired
    private SqlSession sqlSession;

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
    public void testSelectSumMoneyPerMonthByStuidAndMonths() {
        List<Integer> data = xiaofeiMapper.selectSumMoneyPerMonthByStuidAndMonths(
                false,
                201519420,
                Utils.formatDateFromString("2019-04-20"),
                Utils.formatDateFromString("2019-04-30")
        );
        int[] allData = new int[data.size()];
        for (int i = 0; i < allData.length; i++) {
            allData[i] = data.get(i);
        }
        LineChartData lineChartData = new LineChartData(null, new int[][]{allData}, null, null);
    }

    @Test
    public void testSelectRatioMoneyByStuidAndXfaddressInAllPlaces(){

    }

    @Test
    @Rollback(false)
    public void testInsertXiaofei() throws ParseException {
        new XiaofeiDataImporter(xiaofeiMapper).storeXiaofeisFromCSVFile();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Xiaofei xiaofei = new Xiaofei();
//        xiaofei.setXftime(simpleDateFormat.parse("2019/04/27 15:24:38.000000000"));
//        xiaofeiMapper.insert(xiaofei);
    }

    @Test
    @Rollback(false)
    public void testUpdateGrade(){
        new GradeDataImporter(gradeMapper).updateGradeByGterm();
    }

    @Test
    @Rollback(false)
    public void deleteXiaofei() throws InterruptedException {
        List<Student> students = studentMapper.selectAll();
        System.out.println(students.get(0).getSchool().getId());
    }

    /**
      * 一个非常神奇的地方，学号为201579044的学生竟然在16级的班里，
      * 特殊情况暂时不予考虑，通过匹配学号和班级创建时间来将其排除
      */
    @Test
    @Rollback(false)
    public void testGradeMapper(){
        String groupId = "300_2014_*";
        String start = "2017-01-01";
        String end = "2017-12-31";
        GroupResult group = Group.parseGroupId(groupId);
        System.err.println(
                Utils.object2Json(
                    gradeMapper.selectGradeEntropyByGroupId(
                        group.getStuschool(),
                        group.getIntyear(),
                        group.getStuclass(),
                        start,
                        end
                    )
            )
        );
    }

    @Test
    public void testJieshuMapper(){
        String groupId = "*_*_*";
        System.err.println(Utils.object2Json(new JieshuService(jieshuMapper).getTop10BorrowedTushuByGroupId(
                groupId, "2017-01-01", "2017-12-31"
        )));
    }

    /**
      * 熵=-sum(p*logp)
      */
    @Test
    public void entropyTest(){
        int[] data = {88, 76, 74, 82, 77, 88, 60, 83, 73, 78, 0, 68, 95, 85, 80, 83, 89, 72, 85, 80, 84, 85, 81, 77, 63, 66, 70, 65, 85, 71, 49, 73, 65, 85, 60, 78, 66, 60, 60, 91, 85, 72, 80, 67, 85, 72, 73, 62, 60, 60, 91, 76, 85, 75, 70, 90, 86, 72, 77, 65, 89, 91, 80, 73, 93, 75, 85, 68, 78, 73, 84, 94, 81, 76, 90, 74, 85, 63, 69, 60, 60, 48, 63, 51, 80, 0, 84, 83, 91, 86, 86, 79, 76, 85, 77, 67, 75, 82, 89, 83, 71, 72, 76, 85, 75, 75, 75, 67, 81, 60, 83, 72, 73, 51, 70, 65, 83, 49, 67, 61, 72, 60, 75, 90, 78, 86, 85, 76, 90, 89, 86, 84, 65, 81, 80, 66, 79, 79, 60, 66, 60, 0};
        System.err.println(Utils.computeEntropy(data));
    }

//    @Test
//    public void distanceTest(){
//        int[] data = {85, 78, 94, 83, 80, 83, 91, 63, 80, 86, 88, 90, 92, 91, 95, 86, 90,
//                89, 73, 82, 86, 95, 68, 88, 80, 93, 83, 94, 87, 92, 89, 85, 96, 86, 86};
//        for (int i = 0; i < data.length - 1; i++) {
//
//        }
//    }

    @Test
    public void test() throws InterruptedException {

    }

}
