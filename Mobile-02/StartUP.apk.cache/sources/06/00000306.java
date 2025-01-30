package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* compiled from: SavedStateViewModelFactory.java */
/* loaded from: classes.dex */
public final class a0 extends d0.c {
    private static final Class<?>[] a = {Application.class, z.class};

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f1770b = {z.class};

    /* renamed from: c  reason: collision with root package name */
    private final Application f1771c;

    /* renamed from: d  reason: collision with root package name */
    private final d0.a f1772d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f1773e;

    /* renamed from: f  reason: collision with root package name */
    private final i f1774f;

    /* renamed from: g  reason: collision with root package name */
    private final SavedStateRegistry f1775g;

    @SuppressLint({"LambdaLast"})
    public a0(Application application, androidx.savedstate.b bVar, Bundle bundle) {
        this.f1775g = bVar.getSavedStateRegistry();
        this.f1774f = bVar.getLifecycle();
        this.f1773e = bundle;
        this.f1771c = application;
        this.f1772d = d0.a.a(application);
    }

    private static <T> Constructor<T> a(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.d0.c
    public <T extends b0> T create(String str, Class<T> cls) {
        Constructor a2;
        boolean isAssignableFrom = b.class.isAssignableFrom(cls);
        if (isAssignableFrom) {
            a2 = a(cls, a);
        } else {
            a2 = a(cls, f1770b);
        }
        if (a2 == null) {
            return (T) this.f1772d.create(cls);
        }
        SavedStateHandleController j2 = SavedStateHandleController.j(this.f1775g, this.f1774f, str, this.f1773e);
        try {
            T t = isAssignableFrom ? (T) a2.newInstance(this.f1771c, j2.k()) : (T) a2.newInstance(j2.k());
            t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", j2);
            return t;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to access " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
        }
    }

    @Override // androidx.lifecycle.d0.e
    void onRequery(b0 b0Var) {
        SavedStateHandleController.h(b0Var, this.f1775g, this.f1774f);
    }

    @Override // androidx.lifecycle.d0.c, androidx.lifecycle.d0.b
    public <T extends b0> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}