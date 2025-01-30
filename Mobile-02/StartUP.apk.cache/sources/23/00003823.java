package com.google.api.client.http;

import org.apache.http.HttpStatus;

/* compiled from: HttpStatusCodes.java */
/* loaded from: classes2.dex */
public class t {
    public static boolean a(int i2) {
        if (i2 != 307) {
            switch (i2) {
                case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
                case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
                case HttpStatus.SC_SEE_OTHER /* 303 */:
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean b(int i2) {
        return i2 >= 200 && i2 < 300;
    }
}