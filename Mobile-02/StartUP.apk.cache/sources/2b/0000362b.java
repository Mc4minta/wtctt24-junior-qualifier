package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.f0;
import com.google.android.gms.internal.measurement.h0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class da {
    static final /* synthetic */ int[] a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ int[] f7544b;

    static {
        int[] iArr = new int[f0.b.values().length];
        f7544b = iArr;
        try {
            iArr[f0.b.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7544b[f0.b.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7544b[f0.b.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7544b[f0.b.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[h0.a.values().length];
        a = iArr2;
        try {
            iArr2[h0.a.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[h0.a.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[h0.a.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[h0.a.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[h0.a.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[h0.a.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}