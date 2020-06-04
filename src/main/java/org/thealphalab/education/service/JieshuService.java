package org.thealphalab.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.mapper.JieshuMapper;
import org.thealphalab.education.model.Group;
import org.thealphalab.education.others.CustomWordFrequencyStatistics;
import org.thealphalab.education.others.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JieshuService {

    @Autowired
    private JieshuMapper jieshuMapper;

    public JieshuService(JieshuMapper jieshuMapper) {
        this.jieshuMapper = jieshuMapper;
    }

    public Map<String, Integer> getWordCloudByGroupId(String groupId, String start, String end){
        GroupResult group = Group.parseGroupId(groupId);
        CustomWordFrequencyStatistics frequencyStatistics = Utils.getFrequencyStatistics();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> result = new HashMap<>();
        List<String> tsnames = jieshuMapper.selectAllTushuNameNotEmptyByGroupId(
                group.getStuschool(),
                group.getIntyear(),
                group.getStuclass(),
                start,
                end
        );
        for (String tsname : tsnames) {
            sb.append(tsname);
        }
        frequencyStatistics.seg(sb.toString());
        List<String> words = frequencyStatistics.dump();
        for (int i = 0; i < Math.max(50, words.size()); i++) {
            String[] keyVal = words.get(i).split(" ");
            result.put(keyVal[0], Integer.parseInt(keyVal[1]));
        }
        return result;
    }

    public Map<String, Integer> getTop10BorrowedTushuByGroupId(String groupId, String start, String end){
        GroupResult group = Group.parseGroupId(groupId);
        Map<String, Integer> result = new HashMap<>();
        List<Map<String, Object>> maps = jieshuMapper.selectTsnameAndNumByGroupId(
                group.getStuschool(),
                group.getIntyear(),
                group.getStuclass(),
                start,
                end
        );
        for (Map<String, Object> map : maps) {
            result.put((String)map.get("tsname"), Integer.valueOf(String.valueOf(map.get("num"))));
        }
        return result;
    }

}
