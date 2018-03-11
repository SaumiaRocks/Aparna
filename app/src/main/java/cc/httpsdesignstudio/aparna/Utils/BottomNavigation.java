package cc.httpsdesignstudio.aparna.Utils;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Saumia Singhal on 3/11/2018.
 */

public class BottomNavigation {

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
}
