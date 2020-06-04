package org.thealphalab.education;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import org.thealphalab.education.mapper.XiaofeiMapper;

import java.util.*;

@MybatisTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE )
public class NetworkTest {

    @Autowired
    private XiaofeiMapper xiaofeiMapper;

    @Test
    public void main() {
        Random random = new Random(0);
        int testSize = 10000;
        int studentSize = 50;
        int timeSize = 1000;
        int interval = 1;
        int threshold = 10;
        // 时间-学号
        int[][] timeLine = new int[testSize][2];
        // 学号-时间线上的索引列表
        ArrayList<ArrayList<Integer>> students = new ArrayList<>();
        for (int i = 0; i < studentSize; i++) {
            students.add(new ArrayList<>());
        }
        for (int i = 0; i < testSize; i++) {
            timeLine[i][0] = random.nextInt(timeSize);
            timeLine[i][1] = random.nextInt(studentSize);
        }
        Arrays.sort(timeLine, Comparator.comparingInt(time -> time[0]));
        for (int i = 0; i < testSize; i++) {
            students.get(timeLine[i][1]).add(i);
        }
    }

    public List<int[]> getNetworkByXiaofei(List<Map<String, Object>> timeLine, int interval, int threshold){
        ArrayList<int[]> res = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> dates = new HashMap<>();
        // 时间线索引
        for (int j = 0; j < timeLine.size(); j++) {
            // 向左扫描
            for (int k = j - 1; k >= 0; k--) {
                if(((Date)timeLine.get(j).get("xftime")).getTime() - ((Date)timeLine.get(k).get("xftime")).getTime() > interval){
                    break;
                }
                if (!timeLine.get(j).get("stuid").equals(timeLine.get(k).get("stuid"))){
                    int jid = (int) timeLine.get(j).get("stuid"), kid = (int) timeLine.get(k).get("stuid");
                    dates.putIfAbsent(jid, new HashMap<>());
                    dates.putIfAbsent(kid, new HashMap<>());
                    dates.get(jid).put(kid, dates.get(jid).getOrDefault(kid, 0) + 1);
                }
            }
            // 向右扫描
            for (int k = j - 1; k >= 0; k--) {
                if(((Date)timeLine.get(k).get("xftime")).getTime() - ((Date)timeLine.get(j).get("xftime")).getTime() > interval){
                    break;
                }
                if (!timeLine.get(j).get("stuid").equals(timeLine.get(k).get("stuid"))){
                    int jid = (int) timeLine.get(j).get("stuid"), kid = (int) timeLine.get(k).get("stuid");
                    dates.putIfAbsent(jid, new HashMap<>());
                    dates.putIfAbsent(kid, new HashMap<>());
                    dates.get(jid).put(kid, dates.get(jid).getOrDefault(kid, 0) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : dates.entrySet()) {
            for (Map.Entry<Integer, Integer> integerEntry : entry.getValue().entrySet()) {
                if(integerEntry.getValue() >= threshold){
                    res.add(new int[]{entry.getKey(), integerEntry.getKey()});
                }
            }
        }
        return res;
    }

    @Test
    public void selectData(){
        List<Map<String, Object>> timeLine = xiaofeiMapper.selectSocialRelationDataFromXiaofeiByGroupAndTime(
                300,
                2014,
                "国际软1401",
                "开发区校区食堂",
                "2018-1-1",
                "2018-12-31");
        List<int[]> network = getNetworkByXiaofei(timeLine, 300000, 10);
        System.out.println(network);
    }

}
