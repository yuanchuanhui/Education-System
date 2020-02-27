package org.thealphalab.education.test;

public class PermissionTest {

    private static String parsePermission(){
        String permission = "g_software_2019_03:select";
        String[] words = permission.split("[_:]");
        return String.format("%s学院%s级学生%s班", words[1], words[2], words[3]);
    }

    public static void main(String[] args) {
        String requirePermission = "城市学院_2018_1";
        String userPermission = "城市学院_2015_1";
    }

}