package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewManagersPropertyCache.java */
/* loaded from: classes2.dex */
public class z0 {
    private static final Map<Class, Map<String, l>> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, l> f5282b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class b extends l {
        public b(com.facebook.react.uimanager.c1.a aVar, Method method) {
            super(aVar, "Array", method);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return (ReadableArray) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class c extends l {

        /* renamed from: i  reason: collision with root package name */
        private final boolean f5283i;

        public c(com.facebook.react.uimanager.c1.a aVar, Method method, boolean z) {
            super(aVar, "boolean", method);
            this.f5283i = z;
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return obj == null ? this.f5283i : ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class d extends l {
        public d(com.facebook.react.uimanager.c1.a aVar, Method method) {
            super(aVar, "boolean", method);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            if (obj != null) {
                return ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class e extends l {
        public e(com.facebook.react.uimanager.c1.a aVar, Method method) {
            super(aVar, "number", method);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            if (obj != null) {
                if (obj instanceof Double) {
                    return Integer.valueOf(((Double) obj).intValue());
                }
                return (Integer) obj;
            }
            return null;
        }

        public e(com.facebook.react.uimanager.c1.b bVar, Method method, int i2) {
            super(bVar, "number", method, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class f extends l {

        /* renamed from: i  reason: collision with root package name */
        private final int f5284i;

        public f(com.facebook.react.uimanager.c1.a aVar, Method method) {
            this(aVar, method, 0);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            if (obj == null) {
                return Integer.valueOf(this.f5284i);
            }
            return ColorPropConverter.getColor(obj, context);
        }

        public f(com.facebook.react.uimanager.c1.a aVar, Method method, int i2) {
            super(aVar, "mixed", method);
            this.f5284i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class h extends l {
        public h(com.facebook.react.uimanager.c1.a aVar, Method method) {
            super(aVar, "mixed", method);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return obj instanceof Dynamic ? obj : new DynamicFromObject(obj);
        }

        public h(com.facebook.react.uimanager.c1.b bVar, Method method, int i2) {
            super(bVar, "mixed", method, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class k extends l {
        public k(com.facebook.react.uimanager.c1.a aVar, Method method) {
            super(aVar, "Map", method);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return (ReadableMap) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class m extends l {
        public m(com.facebook.react.uimanager.c1.a aVar, Method method) {
            super(aVar, "String", method);
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return (String) obj;
        }
    }

    public static void a() {
        a.clear();
        f5282b.clear();
    }

    private static l b(com.facebook.react.uimanager.c1.a aVar, Method method, Class<?> cls) {
        if (cls == Dynamic.class) {
            return new h(aVar, method);
        }
        if (cls == Boolean.TYPE) {
            return new c(aVar, method, aVar.defaultBoolean());
        }
        if (cls == Integer.TYPE) {
            if ("Color".equals(aVar.customType())) {
                return new f(aVar, method, aVar.defaultInt());
            }
            return new j(aVar, method, aVar.defaultInt());
        } else if (cls == Float.TYPE) {
            return new i(aVar, method, aVar.defaultFloat());
        } else {
            if (cls == Double.TYPE) {
                return new g(aVar, method, aVar.defaultDouble());
            }
            if (cls == String.class) {
                return new m(aVar, method);
            }
            if (cls == Boolean.class) {
                return new d(aVar, method);
            }
            if (cls == Integer.class) {
                if ("Color".equals(aVar.customType())) {
                    return new f(aVar, method);
                }
                return new e(aVar, method);
            } else if (cls == ReadableArray.class) {
                return new b(aVar, method);
            } else {
                if (cls == ReadableMap.class) {
                    return new k(aVar, method);
                }
                throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
            }
        }
    }

    private static void c(com.facebook.react.uimanager.c1.b bVar, Method method, Class<?> cls, Map<String, l> map) {
        String[] names = bVar.names();
        int i2 = 0;
        if (cls == Dynamic.class) {
            while (i2 < names.length) {
                map.put(names[i2], new h(bVar, method, i2));
                i2++;
            }
        } else if (cls == Integer.TYPE) {
            while (i2 < names.length) {
                map.put(names[i2], new j(bVar, method, i2, bVar.defaultInt()));
                i2++;
            }
        } else if (cls == Float.TYPE) {
            while (i2 < names.length) {
                map.put(names[i2], new i(bVar, method, i2, bVar.defaultFloat()));
                i2++;
            }
        } else if (cls == Double.TYPE) {
            while (i2 < names.length) {
                map.put(names[i2], new g(bVar, method, i2, bVar.defaultDouble()));
                i2++;
            }
        } else if (cls == Integer.class) {
            while (i2 < names.length) {
                map.put(names[i2], new e(bVar, method, i2));
                i2++;
            }
        } else {
            throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
        }
    }

    private static void d(Class<? extends y> cls, Map<String, l> map) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            com.facebook.react.uimanager.c1.a aVar = (com.facebook.react.uimanager.c1.a) method.getAnnotation(com.facebook.react.uimanager.c1.a.class);
            if (aVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    map.put(aVar.name(), b(aVar, method, parameterTypes[0]));
                } else {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
            }
            com.facebook.react.uimanager.c1.b bVar = (com.facebook.react.uimanager.c1.b) method.getAnnotation(com.facebook.react.uimanager.c1.b.class);
            if (bVar != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length == 2) {
                    if (parameterTypes2[0] == Integer.TYPE) {
                        c(bVar, method, parameterTypes2[1], map);
                    } else {
                        throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                    }
                } else {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
            }
        }
    }

    private static void e(Class<? extends ViewManager> cls, Map<String, l> map) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            com.facebook.react.uimanager.c1.a aVar = (com.facebook.react.uimanager.c1.a) method.getAnnotation(com.facebook.react.uimanager.c1.a.class);
            if (aVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2) {
                    if (View.class.isAssignableFrom(parameterTypes[0])) {
                        map.put(aVar.name(), b(aVar, method, parameterTypes[1]));
                    } else {
                        throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                    }
                } else {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
            }
            com.facebook.react.uimanager.c1.b bVar = (com.facebook.react.uimanager.c1.b) method.getAnnotation(com.facebook.react.uimanager.c1.b.class);
            if (bVar != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length == 3) {
                    if (View.class.isAssignableFrom(parameterTypes2[0])) {
                        if (parameterTypes2[1] == Integer.TYPE) {
                            c(bVar, method, parameterTypes2[2], map);
                        } else {
                            throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                        }
                    } else {
                        throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                    }
                } else {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, l> f(Class<? extends y> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (cls2 == y.class) {
                return f5282b;
            }
        }
        Map<Class, Map<String, l>> map = a;
        Map<String, l> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap(f(cls.getSuperclass()));
        d(cls, hashMap);
        map.put(cls, hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, l> g(Class<? extends ViewManager> cls) {
        if (cls == ViewManager.class) {
            return f5282b;
        }
        Map<Class, Map<String, l>> map = a;
        Map<String, l> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap(g(cls.getSuperclass()));
        e(cls, hashMap);
        map.put(cls, hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class g extends l {

        /* renamed from: i  reason: collision with root package name */
        private final double f5285i;

        public g(com.facebook.react.uimanager.c1.a aVar, Method method, double d2) {
            super(aVar, "number", method);
            this.f5285i = d2;
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return Double.valueOf(obj == null ? this.f5285i : ((Double) obj).doubleValue());
        }

        public g(com.facebook.react.uimanager.c1.b bVar, Method method, int i2, double d2) {
            super(bVar, "number", method, i2);
            this.f5285i = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class i extends l {

        /* renamed from: i  reason: collision with root package name */
        private final float f5286i;

        public i(com.facebook.react.uimanager.c1.a aVar, Method method, float f2) {
            super(aVar, "number", method);
            this.f5286i = f2;
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return Float.valueOf(obj == null ? this.f5286i : Float.valueOf(((Double) obj).floatValue()).floatValue());
        }

        public i(com.facebook.react.uimanager.c1.b bVar, Method method, int i2, float f2) {
            super(bVar, "number", method, i2);
            this.f5286i = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static class j extends l {

        /* renamed from: i  reason: collision with root package name */
        private final int f5287i;

        public j(com.facebook.react.uimanager.c1.a aVar, Method method, int i2) {
            super(aVar, "number", method);
            this.f5287i = i2;
        }

        @Override // com.facebook.react.uimanager.z0.l
        protected Object c(Object obj, Context context) {
            return Integer.valueOf(obj == null ? this.f5287i : Integer.valueOf(((Double) obj).intValue()).intValue());
        }

        public j(com.facebook.react.uimanager.c1.b bVar, Method method, int i2, int i3) {
            super(bVar, "number", method, i2);
            this.f5287i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewManagersPropertyCache.java */
    /* loaded from: classes2.dex */
    public static abstract class l {
        private static final Object[] a = new Object[2];

        /* renamed from: b  reason: collision with root package name */
        private static final Object[] f5288b = new Object[3];

        /* renamed from: c  reason: collision with root package name */
        private static final Object[] f5289c = new Object[1];

        /* renamed from: d  reason: collision with root package name */
        private static final Object[] f5290d = new Object[2];

        /* renamed from: e  reason: collision with root package name */
        protected final String f5291e;

        /* renamed from: f  reason: collision with root package name */
        protected final String f5292f;

        /* renamed from: g  reason: collision with root package name */
        protected final Method f5293g;

        /* renamed from: h  reason: collision with root package name */
        protected final Integer f5294h;

        public String a() {
            return this.f5291e;
        }

        public String b() {
            return this.f5292f;
        }

        protected abstract Object c(Object obj, Context context);

        public void d(y yVar, Object obj) {
            try {
                Integer num = this.f5294h;
                if (num == null) {
                    Object[] objArr = f5289c;
                    objArr[0] = c(obj, yVar.F());
                    this.f5293g.invoke(yVar, objArr);
                    Arrays.fill(objArr, (Object) null);
                    return;
                }
                Object[] objArr2 = f5290d;
                objArr2[0] = num;
                objArr2[1] = c(obj, yVar.F());
                this.f5293g.invoke(yVar, objArr2);
                Arrays.fill(objArr2, (Object) null);
            } catch (Throwable th) {
                e.f.d.d.a.f(ViewManager.class, "Error while updating prop " + this.f5291e, th);
                throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.f5291e + "' in shadow node of type: " + yVar.L(), th);
            }
        }

        public void e(ViewManager viewManager, View view, Object obj) {
            try {
                Integer num = this.f5294h;
                if (num == null) {
                    Object[] objArr = a;
                    objArr[0] = view;
                    objArr[1] = c(obj, view.getContext());
                    this.f5293g.invoke(viewManager, objArr);
                    Arrays.fill(objArr, (Object) null);
                    return;
                }
                Object[] objArr2 = f5288b;
                objArr2[0] = view;
                objArr2[1] = num;
                objArr2[2] = c(obj, view.getContext());
                this.f5293g.invoke(viewManager, objArr2);
                Arrays.fill(objArr2, (Object) null);
            } catch (Throwable th) {
                e.f.d.d.a.f(ViewManager.class, "Error while updating prop " + this.f5291e, th);
                throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.f5291e + "' of a view managed by: " + viewManager.getName(), th);
            }
        }

        private l(com.facebook.react.uimanager.c1.a aVar, String str, Method method) {
            this.f5291e = aVar.name();
            this.f5292f = "__default_type__".equals(aVar.customType()) ? str : aVar.customType();
            this.f5293g = method;
            this.f5294h = null;
        }

        private l(com.facebook.react.uimanager.c1.b bVar, String str, Method method, int i2) {
            this.f5291e = bVar.names()[i2];
            this.f5292f = "__default_type__".equals(bVar.customType()) ? str : bVar.customType();
            this.f5293g = method;
            this.f5294h = Integer.valueOf(i2);
        }
    }
}