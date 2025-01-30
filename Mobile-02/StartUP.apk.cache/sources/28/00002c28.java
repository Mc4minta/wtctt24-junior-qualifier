package com.facebook.common.references;

import e.f.d.c.i;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SharedReference<T> {
    private static final Map<Object, Integer> a = new IdentityHashMap();

    /* renamed from: b  reason: collision with root package name */
    private T f4493b;

    /* renamed from: c  reason: collision with root package name */
    private int f4494c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final c<T> f4495d;

    /* loaded from: classes2.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, c<T> cVar) {
        this.f4493b = (T) i.g(t);
        this.f4495d = (c) i.g(cVar);
        a(t);
    }

    private static void a(Object obj) {
        Map<Object, Integer> map = a;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private synchronized int c() {
        int i2;
        e();
        i.b(this.f4494c > 0);
        i2 = this.f4494c - 1;
        this.f4494c = i2;
        return i2;
    }

    private void e() {
        if (!h(this)) {
            throw new NullReferenceException();
        }
    }

    public static boolean h(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.g();
    }

    private static void i(Object obj) {
        Map<Object, Integer> map = a;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                e.f.d.d.a.H("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                map.remove(obj);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized void b() {
        e();
        this.f4494c++;
    }

    public void d() {
        T t;
        if (c() == 0) {
            synchronized (this) {
                t = this.f4493b;
                this.f4493b = null;
            }
            this.f4495d.release(t);
            i(t);
        }
    }

    public synchronized T f() {
        return this.f4493b;
    }

    public synchronized boolean g() {
        return this.f4494c > 0;
    }
}