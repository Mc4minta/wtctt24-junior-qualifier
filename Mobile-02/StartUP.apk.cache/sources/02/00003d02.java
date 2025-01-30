package com.google.zxing.p.a.l.b;

import android.hardware.Camera;
import android.util.Log;

/* compiled from: OpenCameraInterface.java */
/* loaded from: classes2.dex */
public final class a {
    private static final String a = "com.google.zxing.p.a.l.b.a";

    public static int a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(a, "No cameras!");
            return -1;
        }
        boolean z = i2 >= 0;
        if (!z) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        }
        return i2 < numberOfCameras ? i2 : z ? -1 : 0;
    }

    public static Camera b(int i2) {
        int a2 = a(i2);
        if (a2 == -1) {
            return null;
        }
        return Camera.open(a2);
    }
}