package org.thealphalab.education;

import org.thealphalab.education.controller.ChartDataController;
import org.thealphalab.education.model.User;
import org.thealphalab.education.others.Utils;
import org.thealphalab.education.chartdata.*;

public class ChartDataTest {

    public static void main(String[] args) {
        System.out.println(Utils.object2Json(new ChartDataController().consumption()));
//        System.out.println(Utils.object2Json(new User("hello")));
    }

}
