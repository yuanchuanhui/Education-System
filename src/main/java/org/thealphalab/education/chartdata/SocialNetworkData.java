package org.thealphalab.education.chartdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SocialNetworkData {

    private int[][] data;

    public SocialNetworkData(int[][] data) {
        this.data = data;
    }

    public static Object[] getInstance(String className){
        int[][] networkData = new int[1000][2];
        for (int i = 0; i < 1000; i++) {
            networkData[i][0] = i;
            networkData[i][1] = (int)(Math.random() * 1000);
        }
        Object[] objects = new Object[2];
        objects[0] = className;
        objects[1] = new SocialNetworkData(networkData);
        return objects;
    }

    public int[][] getData() {
        return data;
    }
}
