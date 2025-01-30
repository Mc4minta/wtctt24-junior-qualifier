package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class g {
    private static final String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b  reason: collision with root package name */
    private static DropBoxManager f6322b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6323c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f6324d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static int f6325e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f6326f = 0;

    public static boolean a(Context context, Throwable th) {
        return b(context, th, PKIFailureInfo.duplicateCertReq);
    }

    private static boolean b(Context context, Throwable th, int i2) {
        try {
            com.google.android.gms.common.internal.t.k(context);
            com.google.android.gms.common.internal.t.k(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}