package com.google.gson.u.o;

import com.google.gson.u.e;
import java.lang.reflect.AccessibleObject;

/* compiled from: ReflectionAccessor.java */
/* loaded from: classes2.dex */
public abstract class b {
    private static final b a;

    static {
        a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}