package com.example.hasancan.firstandroidtry.interfaces;

import android.app.Activity;

/**
 * Created by HasanCan on 1/16/2018.
 */

public interface IBluetooth {
    Boolean checkBluetooth();
    String setupBluetooth(Activity setupActivity);
    void disableBluetooth();
}
