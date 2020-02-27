package org.thealphalab.education.test;

import org.thealphalab.education.others.Utils;
import org.thealphalab.education.model.Yujing;

public class YuJingTest {

    public static void main(String[] args) {
        System.out.println(Utils.object2Json(Yujing.getDemoInstance()));
    }

}
