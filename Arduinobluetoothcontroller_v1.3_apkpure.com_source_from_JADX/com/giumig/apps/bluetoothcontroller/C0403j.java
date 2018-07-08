package com.giumig.apps.bluetoothcontroller;

import android.bluetooth.BluetoothClass;

public class C0403j {
    public static boolean m5337a(BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return false;
        }
        int deviceClass = bluetoothClass.getDeviceClass();
        return deviceClass == 516 || deviceClass == 520 || deviceClass == 532 || deviceClass == 528 || deviceClass == 524 || deviceClass == 512;
    }

    public static boolean m5338b(BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return false;
        }
        int deviceClass = bluetoothClass.getDeviceClass();
        return deviceClass == 260 || deviceClass == 268 || deviceClass == 272 || deviceClass == 276 || deviceClass == 264 || deviceClass == 256 || deviceClass == 280;
    }
}
