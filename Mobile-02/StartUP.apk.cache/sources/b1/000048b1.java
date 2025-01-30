package e.g.b.a.c;

import e.g.b.a.c.g;
import e.g.b.a.d.f0;
import e.g.b.a.d.j;
import e.g.b.a.d.m;
import e.g.b.a.d.n;
import e.g.b.a.d.y;
import e.g.b.a.d.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: JsonParser.java */
/* loaded from: classes2.dex */
public abstract class f {
    private static WeakHashMap<Class<?>, Field> a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Lock f13383b = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonParser.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.END_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.END_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[i.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[i.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[i.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[i.VALUE_NUMBER_INT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[i.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[i.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private i B() throws IOException {
        i f2 = f();
        if (f2 == null) {
            f2 = o();
        }
        y.b(f2 != null, "no JSON input found");
        return f2;
    }

    private i C() throws IOException {
        i B = B();
        int i2 = a.a[B.ordinal()];
        boolean z = true;
        if (i2 != 1) {
            return i2 != 2 ? B : o();
        }
        i o = o();
        if (o != i.FIELD_NAME && o != i.END_OBJECT) {
            z = false;
        }
        y.b(z, o);
        return o;
    }

    private static Field d(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        Lock lock = f13383b;
        lock.lock();
        try {
            if (a.containsKey(cls)) {
                Field field2 = a.get(cls);
                lock.unlock();
                return field2;
            }
            for (m mVar : e.g.b.a.d.i.f(cls).c()) {
                Field b2 = mVar.b();
                g gVar = (g) b2.getAnnotation(g.class);
                if (gVar != null) {
                    y.c(field == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    y.c(j.d(b2.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, b2.getType());
                    g.a[] typeDefinitions = gVar.typeDefinitions();
                    HashSet a2 = z.a();
                    y.b(typeDefinitions.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (g.a aVar : typeDefinitions) {
                        y.c(a2.add(aVar.key()), "Class contains two @TypeDef annotations with identical key: %s", aVar.key());
                    }
                    field = b2;
                }
            }
            a.put(cls, field);
            return field;
        } finally {
            f13383b.unlock();
        }
    }

    private void s(ArrayList<Type> arrayList, Object obj, e.g.b.a.c.a aVar) throws IOException {
        if (obj instanceof b) {
            ((b) obj).setFactory(i());
        }
        i C = C();
        Class<?> cls = obj.getClass();
        e.g.b.a.d.i f2 = e.g.b.a.d.i.f(cls);
        boolean isAssignableFrom = n.class.isAssignableFrom(cls);
        if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
            w(null, (Map) obj, f0.e(cls), arrayList, aVar);
            return;
        }
        while (C == i.FIELD_NAME) {
            String n = n();
            o();
            if (aVar == null) {
                m b2 = f2.b(n);
                if (b2 != null) {
                    if (b2.h() && !b2.i()) {
                        throw new IllegalArgumentException("final array/object fields are not supported");
                    }
                    Field b3 = b2.b();
                    int size = arrayList.size();
                    arrayList.add(b3.getGenericType());
                    Object x = x(b3, b2.d(), arrayList, obj, aVar, true);
                    arrayList.remove(size);
                    b2.m(obj, x);
                } else if (isAssignableFrom) {
                    ((n) obj).set(n, x(null, null, arrayList, obj, aVar, true));
                } else if (aVar == null) {
                    y();
                } else {
                    throw null;
                }
                C = o();
            } else {
                throw null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void v(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, e.g.b.a.c.a aVar) throws IOException {
        i C = C();
        while (C != i.END_ARRAY) {
            collection.add(x(field, type, arrayList, collection, aVar, true));
            C = o();
        }
    }

    private void w(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, e.g.b.a.c.a aVar) throws IOException {
        i C = C();
        while (C == i.FIELD_NAME) {
            String n = n();
            o();
            if (aVar == null) {
                map.put(n, x(field, type, arrayList, map, aVar, true));
                C = o();
            } else {
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01b0 A[Catch: IllegalArgumentException -> 0x0316, TryCatch #1 {IllegalArgumentException -> 0x0316, blocks: (B:14:0x002f, B:21:0x0047, B:24:0x004e, B:26:0x0055, B:28:0x005d, B:30:0x0065, B:32:0x0072, B:34:0x007a, B:36:0x0087, B:38:0x0090, B:41:0x00a4, B:51:0x00c4, B:54:0x00ce, B:57:0x00d7, B:58:0x00dc, B:44:0x00aa, B:46:0x00b2, B:48:0x00ba, B:61:0x00e7, B:64:0x00f0, B:66:0x00f7, B:71:0x0105, B:74:0x010c, B:79:0x0116, B:83:0x011d, B:88:0x0126, B:93:0x012f, B:98:0x0138, B:101:0x013d, B:102:0x0153, B:103:0x0154, B:105:0x015d, B:107:0x0166, B:109:0x016f, B:111:0x0178, B:113:0x0181, B:115:0x018a, B:118:0x0191, B:121:0x0197, B:126:0x01a3, B:128:0x01b0, B:129:0x01b3, B:131:0x01b6, B:135:0x01c0, B:140:0x01cc, B:145:0x01db, B:147:0x01e1, B:152:0x01f4, B:154:0x0205, B:149:0x01e8, B:151:0x01f0, B:157:0x020f, B:161:0x0218, B:163:0x0223, B:171:0x0231, B:176:0x023e, B:182:0x0252, B:184:0x0258, B:186:0x025d, B:188:0x0265, B:190:0x026d, B:193:0x0276, B:180:0x0249, B:181:0x024e), top: B:232:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b3 A[Catch: IllegalArgumentException -> 0x0316, TryCatch #1 {IllegalArgumentException -> 0x0316, blocks: (B:14:0x002f, B:21:0x0047, B:24:0x004e, B:26:0x0055, B:28:0x005d, B:30:0x0065, B:32:0x0072, B:34:0x007a, B:36:0x0087, B:38:0x0090, B:41:0x00a4, B:51:0x00c4, B:54:0x00ce, B:57:0x00d7, B:58:0x00dc, B:44:0x00aa, B:46:0x00b2, B:48:0x00ba, B:61:0x00e7, B:64:0x00f0, B:66:0x00f7, B:71:0x0105, B:74:0x010c, B:79:0x0116, B:83:0x011d, B:88:0x0126, B:93:0x012f, B:98:0x0138, B:101:0x013d, B:102:0x0153, B:103:0x0154, B:105:0x015d, B:107:0x0166, B:109:0x016f, B:111:0x0178, B:113:0x0181, B:115:0x018a, B:118:0x0191, B:121:0x0197, B:126:0x01a3, B:128:0x01b0, B:129:0x01b3, B:131:0x01b6, B:135:0x01c0, B:140:0x01cc, B:145:0x01db, B:147:0x01e1, B:152:0x01f4, B:154:0x0205, B:149:0x01e8, B:151:0x01f0, B:157:0x020f, B:161:0x0218, B:163:0x0223, B:171:0x0231, B:176:0x023e, B:182:0x0252, B:184:0x0258, B:186:0x025d, B:188:0x0265, B:190:0x026d, B:193:0x0276, B:180:0x0249, B:181:0x024e), top: B:232:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e1 A[Catch: IllegalArgumentException -> 0x0316, TryCatch #1 {IllegalArgumentException -> 0x0316, blocks: (B:14:0x002f, B:21:0x0047, B:24:0x004e, B:26:0x0055, B:28:0x005d, B:30:0x0065, B:32:0x0072, B:34:0x007a, B:36:0x0087, B:38:0x0090, B:41:0x00a4, B:51:0x00c4, B:54:0x00ce, B:57:0x00d7, B:58:0x00dc, B:44:0x00aa, B:46:0x00b2, B:48:0x00ba, B:61:0x00e7, B:64:0x00f0, B:66:0x00f7, B:71:0x0105, B:74:0x010c, B:79:0x0116, B:83:0x011d, B:88:0x0126, B:93:0x012f, B:98:0x0138, B:101:0x013d, B:102:0x0153, B:103:0x0154, B:105:0x015d, B:107:0x0166, B:109:0x016f, B:111:0x0178, B:113:0x0181, B:115:0x018a, B:118:0x0191, B:121:0x0197, B:126:0x01a3, B:128:0x01b0, B:129:0x01b3, B:131:0x01b6, B:135:0x01c0, B:140:0x01cc, B:145:0x01db, B:147:0x01e1, B:152:0x01f4, B:154:0x0205, B:149:0x01e8, B:151:0x01f0, B:157:0x020f, B:161:0x0218, B:163:0x0223, B:171:0x0231, B:176:0x023e, B:182:0x0252, B:184:0x0258, B:186:0x025d, B:188:0x0265, B:190:0x026d, B:193:0x0276, B:180:0x0249, B:181:0x024e), top: B:232:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0205 A[Catch: IllegalArgumentException -> 0x0316, TryCatch #1 {IllegalArgumentException -> 0x0316, blocks: (B:14:0x002f, B:21:0x0047, B:24:0x004e, B:26:0x0055, B:28:0x005d, B:30:0x0065, B:32:0x0072, B:34:0x007a, B:36:0x0087, B:38:0x0090, B:41:0x00a4, B:51:0x00c4, B:54:0x00ce, B:57:0x00d7, B:58:0x00dc, B:44:0x00aa, B:46:0x00b2, B:48:0x00ba, B:61:0x00e7, B:64:0x00f0, B:66:0x00f7, B:71:0x0105, B:74:0x010c, B:79:0x0116, B:83:0x011d, B:88:0x0126, B:93:0x012f, B:98:0x0138, B:101:0x013d, B:102:0x0153, B:103:0x0154, B:105:0x015d, B:107:0x0166, B:109:0x016f, B:111:0x0178, B:113:0x0181, B:115:0x018a, B:118:0x0191, B:121:0x0197, B:126:0x01a3, B:128:0x01b0, B:129:0x01b3, B:131:0x01b6, B:135:0x01c0, B:140:0x01cc, B:145:0x01db, B:147:0x01e1, B:152:0x01f4, B:154:0x0205, B:149:0x01e8, B:151:0x01f0, B:157:0x020f, B:161:0x0218, B:163:0x0223, B:171:0x0231, B:176:0x023e, B:182:0x0252, B:184:0x0258, B:186:0x025d, B:188:0x0265, B:190:0x026d, B:193:0x0276, B:180:0x0249, B:181:0x024e), top: B:232:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x020e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object x(java.lang.reflect.Field r14, java.lang.reflect.Type r15, java.util.ArrayList<java.lang.reflect.Type> r16, java.lang.Object r17, e.g.b.a.c.a r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 864
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.a.c.f.x(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, e.g.b.a.c.a, boolean):java.lang.Object");
    }

    public final void A(String str) throws IOException {
        z(Collections.singleton(str));
    }

    public abstract void a() throws IOException;

    public abstract BigInteger b() throws IOException;

    public abstract byte c() throws IOException;

    public abstract String e() throws IOException;

    public abstract i f();

    public abstract BigDecimal g() throws IOException;

    public abstract double h() throws IOException;

    public abstract c i();

    public abstract float j() throws IOException;

    public abstract int k() throws IOException;

    public abstract long l() throws IOException;

    public abstract short m() throws IOException;

    public abstract String n() throws IOException;

    public abstract i o() throws IOException;

    public final <T> T p(Class<T> cls, e.g.b.a.c.a aVar) throws IOException {
        return (T) r(cls, false, aVar);
    }

    public Object q(Type type, boolean z) throws IOException {
        return r(type, z, null);
    }

    public Object r(Type type, boolean z, e.g.b.a.c.a aVar) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                B();
            }
            return x(null, type, new ArrayList<>(), null, aVar, true);
        } finally {
            if (z) {
                a();
            }
        }
    }

    public final <T> T t(Class<T> cls) throws IOException {
        return (T) u(cls, null);
    }

    public final <T> T u(Class<T> cls, e.g.b.a.c.a aVar) throws IOException {
        try {
            return (T) p(cls, aVar);
        } finally {
            a();
        }
    }

    public abstract f y() throws IOException;

    public final String z(Set<String> set) throws IOException {
        i C = C();
        while (C == i.FIELD_NAME) {
            String n = n();
            o();
            if (set.contains(n)) {
                return n;
            }
            y();
            C = o();
        }
        return null;
    }
}