package com.facebook.react.modules.network;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.net.SocketTimeoutException;

/* compiled from: ResponseUtil.java */
/* loaded from: classes2.dex */
public class n {
    public static void a(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, WritableMap writableMap) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushMap(writableMap);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didReceiveNetworkData", createArray);
        }
    }

    public static void b(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, String str) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushString(str);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didReceiveNetworkData", createArray);
        }
    }

    public static void c(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, long j2, long j3) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushInt((int) j2);
        createArray.pushInt((int) j3);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didReceiveNetworkDataProgress", createArray);
        }
    }

    public static void d(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, long j2, long j3) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushInt((int) j2);
        createArray.pushInt((int) j3);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didSendNetworkData", createArray);
        }
    }

    public static void e(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, String str, long j2, long j3) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushString(str);
        createArray.pushInt((int) j2);
        createArray.pushInt((int) j3);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didReceiveNetworkIncrementalData", createArray);
        }
    }

    public static void f(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, String str, Throwable th) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushString(str);
        if (th != null && th.getClass() == SocketTimeoutException.class) {
            createArray.pushBoolean(true);
        }
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didCompleteNetworkResponse", createArray);
        }
    }

    public static void g(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushNull();
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didCompleteNetworkResponse", createArray);
        }
    }

    public static void h(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, int i3, WritableMap writableMap, String str) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        createArray.pushInt(i3);
        createArray.pushMap(writableMap);
        createArray.pushString(str);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didReceiveNetworkResponse", createArray);
        }
    }
}