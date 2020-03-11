package org.thealphalab.education;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.thealphalab.education.chartdata.base.LineChartData;
import org.thealphalab.education.dataimporter.XiaofeiDataImporter;
import org.thealphalab.education.mapper.GradeMapper;
import org.thealphalab.education.mapper.StudentMapper;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.model.School;
import org.thealphalab.education.model.Student;
import org.thealphalab.education.others.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        LineChartData lineChartData = new LineChartData(new int[][]{allData});
//        System.out.println(Utils.object2Json(lineChartData));
    }

    @Test
    public void testSelectRatioMoneyByStuidAndXfaddressInAllPlaces(){

    }

    @Test
    @Rollback(false)
    public void testInsertXiaofei(){
        new XiaofeiDataImporter(xiaofeiMapper).storeXiaofeisFromCSVFile();
    }

    @Test
    @Rollback(false)
    public void deleteXiaofei() throws InterruptedException {
        List<Student> students = studentMapper.selectAll();
        System.out.println(students.get(0).getSchool().getId());
    }

    @Test
    @Rollback(false)
    public void testGradeMapper(){
        // 班 数量
        List<Map<String, Integer>> map1 = gradeMapper.selectRequireCourseFailedNumInDiffClassBySchoolId(300, 2015);
        for (Map<String, Integer> map : map1) {
            System.out.println(map.get("stuclass") + "\t" + map.get("num"));
        }
        // 年级 数量
        List<Map<String, Integer>> map2 = gradeMapper.selectRequireCourseFailedNumInDiffYearBySchoolId(300);
        for (Map<String, Integer> map : map2) {
            System.out.println(map.get("year") + "\t" + map.get("num"));
        }
    }

}
