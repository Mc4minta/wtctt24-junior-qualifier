package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class d0 {
    private final b a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f1783b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class a extends d {
        private static a a;

        /* renamed from: b  reason: collision with root package name */
        private Application f1784b;

        public a(Application application) {
            this.f1784b = application;
        }

        public static a a(Application application) {
            if (a == null) {
                a = new a(application);
            }
            return a;
        }

        @Override // androidx.lifecycle.d0.d, androidx.lifecycle.d0.b
        public <T extends b0> T create(Class<T> cls) {
            if (androidx.lifecycle.b.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.f1784b);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e5);
                }
            }
            return (T) super.create(cls);
        }
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface b {
        <T extends b0> T create(Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static abstract class c extends e implements b {
        public <T extends b0> T create(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends b0> T create(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class d implements b {
        private static d sInstance;

        static d getInstance() {
            if (sInstance == null) {
                sInstance = new d();
            }
            return sInstance;
        }

        @Override // androidx.lifecycle.d0.b
        public <T extends b0> T create(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class e {
        e() {
        }

        void onRequery(b0 b0Var) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public d0(androidx.lifecycle.g0 r3) {
        /*
            r2 = this;
            androidx.lifecycle.f0 r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.h
            if (r1 == 0) goto Lf
            androidx.lifecycle.h r3 = (androidx.lifecycle.h) r3
            androidx.lifecycle.d0$b r3 = r3.getDefaultViewModelProviderFactory()
            goto L13
        Lf:
            androidx.lifecycle.d0$d r3 = androidx.lifecycle.d0.d.getInstance()
        L13:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.d0.<init>(androidx.lifecycle.g0):void");
    }

    public <T extends b0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends b0> T b(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.f1783b.b(str);
        if (cls.isInstance(t2)) {
            b bVar = this.a;
            if (bVar instanceof e) {
                ((e) bVar).onRequery(t2);
            }
            return t2;
        }
        b bVar2 = this.a;
        if (bVar2 instanceof c) {
            t = (T) ((c) bVar2).create(str, cls);
        } else {
            t = (T) bVar2.create(cls);
        }
        this.f1783b.d(str, t);
        return t;
    }

    public d0(g0 g0Var, b bVar) {
        this(g0Var.getViewModelStore(), bVar);
    }

    public d0(f0 f0Var, b bVar) {
        this.a = bVar;
        this.f1783b = f0Var;
    }
}