package org.thealphalab.education.others;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.recognition.StopWord;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 词频统计
 * @author 杨尚川
 */
public class CustomWordFrequencyStatistics {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordSegmenter.class);
    private String resultPath = "CustomWordFrequencyStatistics-Result.txt";
    private Segmentation segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.MaxNgramScore);
    private Map<String, AtomicInteger> statisticsMap = new ConcurrentHashMap<>();
    private boolean removeStopWord = false;

    /**
     * 默认构造函数
     * 不指定算法则默认使用：最大Ngram分值算法
     * 不指定词频统计结果保存路径默认使用当前路径下的：CustomWordFrequencyStatistics-Result.txt
     */
    public CustomWordFrequencyStatistics(){}
    /**
     * 构造函数
     * 不指定算法则默认使用：最大Ngram分值算法
     * @param resultPath 词频统计结果保存路径
     */
    public CustomWordFrequencyStatistics(String resultPath){
        this.resultPath = resultPath;
    }

    /**
     * 构造函数
     * @param resultPath 词频统计结果保存路径
     * @param segmentationAlgorithm 分词算法
     */
    public CustomWordFrequencyStatistics(String resultPath, SegmentationAlgorithm segmentationAlgorithm){
        this.resultPath = resultPath;
        this.segmentation = SegmentationFactory.getSegmentation(segmentationAlgorithm);
    }

    /**
     * 构造函数
     * @param resultPath 词频统计结果保存路径
     * @param segmentationAlgorithm 分词算法，要符合 org.apdplat.word.segmentation.SegmentationAlgorithm 中的定义
     */
    public CustomWordFrequencyStatistics(String resultPath, String segmentationAlgorithm){
        this.resultPath = resultPath;
        this.segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.valueOf(segmentationAlgorithm));
    }

    /**
     * 设置是否移除停用词
     * @param removeStopWord 是否移除停用词
     */
    public void setRemoveStopWord(boolean removeStopWord) {
        this.removeStopWord = removeStopWord;
    }

    /**
     * 是否移除停用词
     * @return
     */
    public boolean isRemoveStopWord() {
        return removeStopWord;
    }

    /**
     * 获取词频统计结果保存路径
     * @return 词频统计结果保存路径
     */
    public String getResultPath() {
        return resultPath;
    }

    /**
     * 设置词频统计结果保存路径
     * @param resultPath 词频统计结果保存路径
     */
    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    /**
     * 获取分词算法
     * @return 分词算法
     */
    public SegmentationAlgorithm getSegmentationAlgorithm() {
        return segmentation.getSegmentationAlgorithm();
    }

    /**
     * 设置分词算法
     * @param segmentationAlgorithm 分词算法
     */
    public void setSegmentationAlgorithm(SegmentationAlgorithm segmentationAlgorithm) {
        this.segmentation = SegmentationFactory.getSegmentation(segmentationAlgorithm);
    }

    /**
     * 对文本进行分词
     * @param text 文本
     */
    public void seg(String text){
        segmentation.seg(text).parallelStream().forEach(word -> {
            //停用词过滤
            if(isRemoveStopWord() && StopWord.is(word.getText())){
                return;
            }
            statistics(word, 1, statisticsMap);
        });
    }

    /**
     * 对文件进行分词
     * @param input 待分词的文本文件
     * @param output 分词结果保存的文本文件
     * @throws Exception
     */
    public void seg(File input, File output) throws Exception{
        Utils.seg(input, output, isRemoveStopWord(), segmentation.getSegmentationAlgorithm(), word -> statistics(word, 1, statisticsMap));
    }

    /**
     * 统计词频
     * @param word 词
     * @param times 词频
     * @param container 内存中保存词频的数据结构
     */
    private void statistics(String word, int times, Map<String, AtomicInteger> container){
        container.putIfAbsent(word, new AtomicInteger());
        container.get(word).addAndGet(times);
    }

    /**
     * 统计词频
     * @param word 词
     * @param times 词频
     * @param container 内存中保存词频的数据结构
     */
    private void statistics(Word word, int times, Map<String, AtomicInteger> container){
        statistics(word.getText(), times, container);
    }

    /**
     * 返回词频统计结果
     */
    public List<String> dump(){
        return dump(this.statisticsMap, this.resultPath);
    }

    /**
     * 将内存中的词频统计结果写到文件
     * @param map 内存中的词频统计结果
     * @param path 词频统计结果文件保存路径
     */
    private List<String> dump(Map<String, AtomicInteger> map, String path){
        List<String> list = null;
        try{
            //按分值排序
            list = map.entrySet().parallelStream().sorted((a,b)->new Integer(b.getValue().get()).compareTo(a.getValue().intValue())).map(entry->entry.getKey()+" "+entry.getValue().get()).collect(Collectors.toList());
        }catch (Exception e){
            LOGGER.error("dump error!", e);
        }
        return list;
    }

    /**
     * 将多个词频统计结果文件进行合并
     * @param mergeResultPath 合并结果文件路径
     * @param resultPaths 多个词频统计结果文件路径
     */
    public void merge(String mergeResultPath, String... resultPaths){
        try{
            Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
            for(String resultPath : resultPaths) {
                Files.lines(Paths.get(resultPath)).forEach(line -> {
                    String[] attrs = line.split("\\s+");
                    if (attrs != null && attrs.length == 2) {
                        statistics(attrs[0], Integer.parseInt(attrs[1]), map);
                    }
                });
            }
            dump(map, mergeResultPath);
        }catch (Exception e){
            LOGGER.error("merge error!", e);
        }
    }

    /**
     * 清除之前的统计结果
     */
    public void reset(){
        this.statisticsMap.clear();
    }

}
