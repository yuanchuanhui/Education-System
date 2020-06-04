package org.thealphalab.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.thealphalab.education.entity.GroupCourseResult;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.mapper.GradeMapper;
import org.thealphalab.education.model.Group;
import java.util.List;

public class GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    /**
      * 返回一个map，其key为groupid, value为挂科率
      */
    public List<GroupResult> selectFailedCourseRatioByGroupId(String groupId, String start, String end, int courseType){
        GroupResult group = Group.parseGroupId(groupId);
        return gradeMapper.selectFailedCourseRatioByGroupId(
                group.getStuschool(),
                group.getIntyear(),
                group.getStuclass(),
                start,
                end,
                courseType);
    }

    /**
     * 返回一个map，其key为groupid课程名, value为挂科率
     */
    public List<GroupCourseResult> selectFailedCourseRationByGroupIdAndCourseName(String groupId, String start, String end,
                                                                               int courseType){
        GroupResult group = Group.parseGroupId(groupId);
        return gradeMapper.selectFailedCourseRationByGroupIdAndCourseName(
                group.getStuschool(),
                group.getIntyear(),
                group.getStuclass(),
                start,
                end,
                courseType
        );
    }

}
