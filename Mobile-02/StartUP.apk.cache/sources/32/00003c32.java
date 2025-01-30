package com.google.gson.u;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: UnsafeAllocator.java */
/* loaded from: classes2.dex */
public abstract class m {

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    static class a extends m {
        final /* synthetic */ Method a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f9621b;

        a(Method method, Object obj) {
            this.a = method;
            this.f9621b = obj;
        }

        @Override // com.google.gson.u.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.a.invoke(this.f9621b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    static class b extends m {
        final /* synthetic */ Method a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9622b;

        b(Method method, int i2) {
            this.a = method;
            this.f9622b = i2;
        }

        @Override // com.google.gson.u.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.f9622b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    static class c extends m {
        final /* synthetic */ Method a;

        c(Method method) {
            this.a = method;
        }

        @Override // com.google.gson.u.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    static class d extends m {
        d() {
        }

        @Override // com.google.gson.u.m
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static m b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}