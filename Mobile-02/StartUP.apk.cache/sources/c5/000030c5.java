package com.google.android.datatransport.cct.b;

import android.util.SparseArray;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public final class p {
    public static final p a;

    /* renamed from: b  reason: collision with root package name */
    public static final p f5797b;

    /* renamed from: c  reason: collision with root package name */
    public static final p f5798c;

    /* renamed from: d  reason: collision with root package name */
    public static final p f5799d;

    /* renamed from: e  reason: collision with root package name */
    public static final p f5800e;

    /* renamed from: f  reason: collision with root package name */
    public static final p f5801f;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseArray<p> f5802g;

    static {
        p pVar = new p("DEFAULT", 0, 0);
        a = pVar;
        p pVar2 = new p("UNMETERED_ONLY", 1, 1);
        f5797b = pVar2;
        p pVar3 = new p("UNMETERED_OR_DAILY", 2, 2);
        f5798c = pVar3;
        p pVar4 = new p("FAST_IF_RADIO_AWAKE", 3, 3);
        f5799d = pVar4;
        p pVar5 = new p("NEVER", 4, 4);
        f5800e = pVar5;
        p pVar6 = new p("UNRECOGNIZED", 5, -1);
        f5801f = pVar6;
        SparseArray<p> sparseArray = new SparseArray<>();
        f5802g = sparseArray;
        sparseArray.put(0, pVar);
        sparseArray.put(1, pVar2);
        sparseArray.put(2, pVar3);
        sparseArray.put(3, pVar4);
        sparseArray.put(4, pVar5);
        sparseArray.put(-1, pVar6);
    }

    private p(String str, int i2, int i3) {
    }
}