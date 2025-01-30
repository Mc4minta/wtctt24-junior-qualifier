package com.google.gson.u.o;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: UnsafeReflectionAccessor.java */
/* loaded from: classes2.dex */
final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private static Class f9681b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f9682c = d();

    /* renamed from: d  reason: collision with root package name */
    private final Field f9683d = c();

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f9681b = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.u.o.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    boolean e(AccessibleObject accessibleObject) {
        if (this.f9682c != null && this.f9683d != null) {
            try {
                f9681b.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f9682c, accessibleObject, Long.valueOf(((Long) f9681b.getMethod("objectFieldOffset", Field.class).invoke(this.f9682c, this.f9683d)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}