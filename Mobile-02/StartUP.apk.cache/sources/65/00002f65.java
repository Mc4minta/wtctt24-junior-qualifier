package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.uimanager.z0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ViewManagerPropertyUpdater.java */
/* loaded from: classes2.dex */
public class x0 {
    private static final Map<Class<?>, f<?, ?>> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, e<?>> f5270b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagerPropertyUpdater.java */
    /* loaded from: classes2.dex */
    public static class b<T extends y> implements e<T> {
        private final Map<String, z0.l> a;

        @Override // com.facebook.react.uimanager.x0.d
        public void a(Map<String, String> map) {
            for (z0.l lVar : this.a.values()) {
                map.put(lVar.a(), lVar.b());
            }
        }

        @Override // com.facebook.react.uimanager.x0.e
        public void c(y yVar, String str, Object obj) {
            z0.l lVar = this.a.get(str);
            if (lVar != null) {
                lVar.d(yVar, obj);
            }
        }

        private b(Class<? extends y> cls) {
            this.a = z0.f(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagerPropertyUpdater.java */
    /* loaded from: classes2.dex */
    public static class c<T extends ViewManager, V extends View> implements f<T, V> {
        private final Map<String, z0.l> a;

        @Override // com.facebook.react.uimanager.x0.d
        public void a(Map<String, String> map) {
            for (z0.l lVar : this.a.values()) {
                map.put(lVar.a(), lVar.b());
            }
        }

        @Override // com.facebook.react.uimanager.x0.f
        public void b(T t, V v, String str, Object obj) {
            z0.l lVar = this.a.get(str);
            if (lVar != null) {
                lVar.e(t, v, obj);
            }
        }

        private c(Class<? extends ViewManager> cls) {
            this.a = z0.g(cls);
        }
    }

    /* compiled from: ViewManagerPropertyUpdater.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(Map<String, String> map);
    }

    /* compiled from: ViewManagerPropertyUpdater.java */
    /* loaded from: classes2.dex */
    public interface e<T extends y> extends d {
        void c(T t, String str, Object obj);
    }

    /* compiled from: ViewManagerPropertyUpdater.java */
    /* loaded from: classes2.dex */
    public interface f<T extends ViewManager, V extends View> extends d {
        void b(T t, V v, String str, Object obj);
    }

    public static void a() {
        z0.a();
        a.clear();
        f5270b.clear();
    }

    private static <T> T b(Class<?> cls) {
        String name = cls.getName();
        try {
            return (T) Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            e.f.d.d.a.A("ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        }
    }

    private static <T extends ViewManager, V extends View> f<T, V> c(Class<? extends ViewManager> cls) {
        Map<Class<?>, f<?, ?>> map = a;
        f<?, ?> fVar = map.get(cls);
        if (fVar == null) {
            fVar = (f) b(cls);
            if (fVar == null) {
                fVar = new c<>(cls);
            }
            map.put(cls, fVar);
        }
        return fVar;
    }

    private static <T extends y> e<T> d(Class<? extends y> cls) {
        Map<Class<?>, e<?>> map = f5270b;
        e<?> eVar = map.get(cls);
        if (eVar == null) {
            eVar = (e) b(cls);
            if (eVar == null) {
                eVar = new b<>(cls);
            }
            map.put(cls, eVar);
        }
        return eVar;
    }

    public static Map<String, String> e(Class<? extends ViewManager> cls, Class<? extends y> cls2) {
        HashMap hashMap = new HashMap();
        c(cls).a(hashMap);
        d(cls2).a(hashMap);
        return hashMap;
    }

    public static <T extends y> void f(T t, a0 a0Var) {
        e d2 = d(t.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = a0Var.a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            d2.c(t, next.getKey(), next.getValue());
        }
    }

    public static <T extends ViewManager, V extends View> void g(T t, V v, a0 a0Var) {
        f c2 = c(t.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = a0Var.a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            c2.b(t, v, next.getKey(), next.getValue());
        }
    }

    public static <T extends w0<V>, V extends View> void h(T t, V v, a0 a0Var) {
        Iterator<Map.Entry<String, Object>> entryIterator = a0Var.a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            t.a(v, next.getKey(), next.getValue());
        }
    }
}