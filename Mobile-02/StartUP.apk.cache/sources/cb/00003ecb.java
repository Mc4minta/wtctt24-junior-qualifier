package com.reactnativecommunity.netinfo;

import android.content.Context;

/* compiled from: NetInfoUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static boolean a(Context context) {
        return androidx.core.content.a.a(context, "android.permission.ACCESS_WIFI_STATE") == 0;
    }

    public static void b(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[(bArr.length - i2) - 1];
            bArr[(bArr.length - i2) - 1] = b2;
        }
    }
}