package org.thealphalab.education;

import org.junit.Test;
import org.thealphalab.education.others.CustomWordFrequencyStatistics;

public class WordCloudTest {

    @Test
    public void initTest() throws Exception {
        CustomWordFrequencyStatistics wordFrequencyStatistics = new CustomWordFrequencyStatistics();
        wordFrequencyStatistics.setRemoveStopWord(true);
        long start = System.currentTimeMillis();
        wordFrequencyStatistics.seg("明天下雨，结合成分子，明天有关于分子和原子的课程，下雨了也要去听课");
        System.out.println(wordFrequencyStatistics.dump());
        System.err.println(System.currentTimeMillis() - start);
        wordFrequencyStatistics.seg("我们的大中国呀，啊好大的一个家，永远哪个永远，我要伴随她");
        System.out.println(wordFrequencyStatistics.dump());
        System.err.println(System.currentTimeMillis() - start);
    }

}
