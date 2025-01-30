package e.g.b.a.d;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: FieldInfo.java */
/* loaded from: classes2.dex */
public class m {
    private static final Map<Field, m> a = new WeakHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13448b;

    /* renamed from: c  reason: collision with root package name */
    private final Field f13449c;

    /* renamed from: d  reason: collision with root package name */
    private final String f13450d;

    m(Field field, String str) {
        this.f13449c = field;
        this.f13450d = str == null ? null : str.intern();
        this.f13448b = j.d(f());
    }

    public static Object c(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static m j(Enum<?> r5) {
        try {
            m k2 = k(r5.getClass().getField(r5.name()));
            y.c(k2 != null, "enum constant missing @Value or @NullValue annotation: %s", r5);
            return k2;
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static m k(Field field) {
        String str = null;
        if (field == null) {
            return null;
        }
        Map<Field, m> map = a;
        synchronized (map) {
            m mVar = map.get(field);
            boolean isEnumConstant = field.isEnumConstant();
            if (mVar == null && (isEnumConstant || !Modifier.isStatic(field.getModifiers()))) {
                if (isEnumConstant) {
                    g0 g0Var = (g0) field.getAnnotation(g0.class);
                    if (g0Var != null) {
                        str = g0Var.value();
                    } else if (((v) field.getAnnotation(v.class)) == null) {
                        return null;
                    }
                } else {
                    q qVar = (q) field.getAnnotation(q.class);
                    if (qVar == null) {
                        return null;
                    }
                    str = qVar.value();
                    field.setAccessible(true);
                }
                if ("##default".equals(str)) {
                    str = field.getName();
                }
                mVar = new m(field, str);
                map.put(field, mVar);
            }
            return mVar;
        }
    }

    public static void l(Field field, Object obj, Object obj2) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object c2 = c(field, obj);
            if (obj2 == null) {
                if (c2 == null) {
                    return;
                }
            } else if (obj2.equals(c2)) {
                return;
            }
            throw new IllegalArgumentException("expected final value <" + c2 + "> but was <" + obj2 + "> on " + field.getName() + " field in " + obj.getClass().getName());
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        } catch (SecurityException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public <T extends Enum<T>> T a() {
        return (T) Enum.valueOf(this.f13449c.getDeclaringClass(), this.f13449c.getName());
    }

    public Field b() {
        return this.f13449c;
    }

    public Type d() {
        return this.f13449c.getGenericType();
    }

    public String e() {
        return this.f13450d;
    }

    public Class<?> f() {
        return this.f13449c.getType();
    }

    public Object g(Object obj) {
        return c(this.f13449c, obj);
    }

    public boolean h() {
        return Modifier.isFinal(this.f13449c.getModifiers());
    }

    public boolean i() {
        return this.f13448b;
    }

    public void m(Object obj, Object obj2) {
        l(this.f13449c, obj, obj2);
    }
}