package com.example.hasancan.firstandroidtry.bluetooth_module;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import com.example.hasancan.firstandroidtry.interfaces.IBluetooth;

/**
 * Created by HasanCan on 1/16/2018.
 */

public class BTManager implements IBluetooth{

    private Activity MyMainActivity;
    private BluetoothAdapter myBluetooth = BluetoothAdapter.getDefaultAdapter();

    /*
    *Default constructor
     */
    public BTManager (Activity callingActivity) {
        super();
        this.MyMainActivity = callingActivity;
    }
    //checks if bluetooth is already on
    public Boolean checkBluetooth() {
        return myBluetooth.isEnabled();
    }

    public String setupBluetooth (Activity setupActivity){

        //Turn on the Bluetooth
        if (myBluetooth == null){
            return "Device has no bluetooth";
        }
        try {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            MyMainActivity.startActivityForResult(enableBtIntent,2);
        } catch (Exception e){
            //TODO : exception?
            return e.toString();
        }
        return "Bluetooth enabled";
    }

    //Disable Bluetooth
    public void disableBluetooth(){

        try {
            if (myBluetooth.isEnabled()){
                myBluetooth.disable();
            }
        } catch (Exception e){
            //TODO exception
        }
    }

}
