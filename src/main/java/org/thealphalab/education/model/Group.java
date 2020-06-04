package org.thealphalab.education.model;

import lombok.Data;
import org.thealphalab.education.entity.GroupResult;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {

    private String groupId;
    private int groupLevel;
    private String groupName;
    private List<Group> subGroups;
    private boolean hasPermit;

    public Group(String groupId, int groupLevel, String groupName) {
        this.groupId = groupId;
        this.groupLevel = groupLevel;
        this.groupName = groupName;
    }

    public void setSubGroups(List<Group> subGroups) {
        this.subGroups = subGroups;
    }

    public void setHasPermit(boolean hasPermit) {
        this.hasPermit = hasPermit;
    }

    public boolean isHasPermit() {
        return hasPermit;
    }

    /**
      * 根据权限，创建群组实例。
      */
    public static Group build(String permission) {
        String[] words = permission.split("_");
        Group group = Group.getInstance();
        List<Group> groupList = group.getSubGroups();
        for (Group group1 : groupList) {
            if(words[0].equals("*") || group1.getGroupName().equals(words[0])){
                group1.setHasPermit(true);
            }else {
                continue;
            }
            List<Group> group1List = group1.getSubGroups();
            for (Group group2 : group1List) {
                if(group1.isHasPermit() && ((words[1].equals("*") || group2.getGroupName().equals(words[1])))){
                    group2.setHasPermit(true);
                }else {
                    continue;
                }
                List<Group> group2List = group2.getSubGroups();
                for (Group group3 : group2List) {
                    if(group2.isHasPermit() && (words[2].equals("*") || group3.getGroupName().equals(words[2]))){
                        group3.setHasPermit(true);
                    }
                }
            }
        }
        return group;
    }

    /**
      * 根据数据库中的数据，得到所有群组的实例。
      */
    public static Group getInstance(){
        String[] softwares = {"化工与环境生命学部", "机械工程与材料能源学部",
                "电子信息与电气工程学部", "建设工程学部", "运载工程与力学学部",
                "人文与社会科学学部", "经济管理学院", "建筑与艺术学院",
                "马克思主义学院", "外国语学院", "物理学院", "数学科学学院",
                "光电工程与仪器科学学院", "张大煜学院", "体育与健康学院",
                "国际教育学院（留学生办公室）", "创新创业学院", "大连理工大学白俄罗斯国立大学联合学院",
                "国防教育学院", "远程与继续教育学院", "城市学院",
                "高等教育研究院", "能源研究院", "北京研究院"};
        Group group = new Group("*_*_*", 0, "全校");
        List<Group> groupList = new ArrayList<>();
        group.setSubGroups(groupList);
        for (int i = 0; i < softwares.length; i++) {
            Group group1 = new Group(String.format("%s_*_*", i), 1, softwares[i]);
            groupList.add(group1);
            List<Group> group1List = new ArrayList<>();
            group1.setSubGroups(group1List);
            for (int j = 2015; j < 2019; j++) {
                Group group2 = new Group(String.format("%d_%d_*", i, j), 2, String.valueOf(j));
                group1List.add(group2);
                List<Group> group2List = new ArrayList<>();
                group2.setSubGroups(group2List);
                for (int k = 0; k < 4; k++) {
                    Group group3 = new Group(String.format("%d_%d_%d", i, j, k), 3, String.valueOf(k));
                    group2List.add(group3);
                }
            }
        }
        return group;
    }

    public static String buildGroupId(int school, int year, String class_){
        StringBuilder sb = new StringBuilder();
        if(school != -1){
            sb.append(school);
            if(year != -1){
                sb.append("_").append(year);
                if(class_ != null){
                    return sb.append("_").append(class_).toString();
                }else {
                    return sb.append("_*").toString();
                }
            }else {
                return sb.append("_*_*").toString();
            }
        }else {
            return "*_*_*";
        }
    }

    public static GroupResult parseGroupId(String groupId){
        String[] args = groupId.split("_");
        return new GroupResult(
                Integer.parseInt(args[0].equals("*")? "-1" : args[0]),
                Integer.parseInt(args[1].equals("*")? "-1" : args[1]),
                args[2].equals("*")? null : args[2]);
    }

}
