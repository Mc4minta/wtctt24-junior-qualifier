package com.facebook.react.uimanager;

/* compiled from: YogaNodePool.java */
/* loaded from: classes2.dex */
public class b1 {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static com.facebook.react.common.a<com.facebook.yoga.p> f5047b;

    public static com.facebook.react.common.a<com.facebook.yoga.p> a() {
        com.facebook.react.common.a<com.facebook.yoga.p> aVar;
        com.facebook.react.common.a<com.facebook.yoga.p> aVar2 = f5047b;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a) {
            if (f5047b == null) {
                f5047b = new com.facebook.react.common.a<>(1024);
            }
            aVar = f5047b;
        }
        return aVar;
    }
}