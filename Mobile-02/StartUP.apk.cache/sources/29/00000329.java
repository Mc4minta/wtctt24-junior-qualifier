package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling.java */
/* loaded from: classes.dex */
public class r {
    private static Map<Class<?>, Integer> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends g>>> f1799b = new HashMap();

    private static g a(Constructor<? extends g> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends g> b(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c2 = c(canonicalName);
            if (!name.isEmpty()) {
                c2 = name + "." + c2;
            }
            Constructor declaredConstructor = Class.forName(c2).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class<?> cls) {
        Integer num = a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g2 = g(cls);
        a.put(cls, Integer.valueOf(g2));
        return g2;
    }

    private static boolean e(Class<?> cls) {
        return cls != null && n.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m f(Object obj) {
        boolean z = obj instanceof m;
        boolean z2 = obj instanceof f;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((f) obj, (m) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((f) obj, null);
        }
        if (z) {
            return (m) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) == 2) {
            List<Constructor<? extends g>> list = f1799b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
            }
            g[] gVarArr = new g[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                gVarArr[i2] = a(list.get(i2), obj);
            }
            return new CompositeGeneratedAdaptersObserver(gVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static int g(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends g> b2 = b(cls);
        if (b2 != null) {
            f1799b.put(cls, Collections.singletonList(b2));
            return 2;
        } else if (c.a.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (e(superclass)) {
                if (d(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f1799b.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (e(cls2)) {
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f1799b.get(cls2));
                }
            }
            if (arrayList != null) {
                f1799b.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }
}