package androidx.lifecycle;

import androidx.lifecycle.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
class c {
    static c a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, a> f1776b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f1777c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class a {
        final Map<i.a, List<b>> a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, i.a> f1778b;

        a(Map<b, i.a> map) {
            this.f1778b = map;
            for (Map.Entry<b, i.a> entry : map.entrySet()) {
                i.a value = entry.getValue();
                List<b> list = this.a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, o oVar, i.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(oVar, aVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(o oVar, i.a aVar, Object obj) {
            b(this.a.get(aVar), oVar, aVar, obj);
            b(this.a.get(i.a.ON_ANY), oVar, aVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class b {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final Method f1779b;

        b(int i2, Method method) {
            this.a = i2;
            this.f1779b = method;
            method.setAccessible(true);
        }

        void a(o oVar, i.a aVar, Object obj) {
            try {
                int i2 = this.a;
                if (i2 == 0) {
                    this.f1779b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f1779b.invoke(obj, oVar);
                } else if (i2 != 2) {
                } else {
                    this.f1779b.invoke(obj, oVar, aVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.f1779b.getName().equals(bVar.f1779b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.f1779b.getName().hashCode();
        }
    }

    c() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i2;
        a c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c2 = c(superclass)) != null) {
            hashMap.putAll(c2.f1778b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, i.a> entry : c(cls2).f1778b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            w wVar = (w) method.getAnnotation(w.class);
            if (wVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (!parameterTypes[0].isAssignableFrom(o.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i2 = 1;
                }
                i.a value = wVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(i.a.class)) {
                        if (value != i.a.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f1776b.put(cls, aVar);
        this.f1777c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<b, i.a> map, b bVar, i.a aVar, Class<?> cls) {
        i.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f1779b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c(Class<?> cls) {
        a aVar = this.f1776b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f1777c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((w) method.getAnnotation(w.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f1777c.put(cls, Boolean.FALSE);
        return false;
    }
}