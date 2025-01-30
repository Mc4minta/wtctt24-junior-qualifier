package e.g.b.a.d;

import com.coinbase.wallet.core.extensions.Strings;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Data.java */
/* loaded from: classes2.dex */
public class j {
    public static final Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f13424b;

    /* renamed from: c  reason: collision with root package name */
    public static final Character f13425c;

    /* renamed from: d  reason: collision with root package name */
    public static final Byte f13426d;

    /* renamed from: e  reason: collision with root package name */
    public static final Short f13427e;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f13428f;

    /* renamed from: g  reason: collision with root package name */
    public static final Float f13429g;

    /* renamed from: h  reason: collision with root package name */
    public static final Long f13430h;

    /* renamed from: i  reason: collision with root package name */
    public static final Double f13431i;

    /* renamed from: j  reason: collision with root package name */
    public static final BigInteger f13432j;

    /* renamed from: k  reason: collision with root package name */
    public static final BigDecimal f13433k;

    /* renamed from: l  reason: collision with root package name */
    public static final l f13434l;
    private static final ConcurrentHashMap<Class<?>, Object> m;

    static {
        Boolean bool = new Boolean(true);
        a = bool;
        String str = new String();
        f13424b = str;
        Character ch = new Character((char) 0);
        f13425c = ch;
        Byte b2 = new Byte((byte) 0);
        f13426d = b2;
        Short sh = new Short((short) 0);
        f13427e = sh;
        Integer num = new Integer(0);
        f13428f = num;
        Float f2 = new Float(0.0f);
        f13429g = f2;
        Long l2 = new Long(0L);
        f13430h = l2;
        Double d2 = new Double(0.0d);
        f13431i = d2;
        BigInteger bigInteger = new BigInteger(Strings.zero);
        f13432j = bigInteger;
        BigDecimal bigDecimal = new BigDecimal(Strings.zero);
        f13433k = bigDecimal;
        l lVar = new l(0L);
        f13434l = lVar;
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        m = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, bool);
        concurrentHashMap.put(String.class, str);
        concurrentHashMap.put(Character.class, ch);
        concurrentHashMap.put(Byte.class, b2);
        concurrentHashMap.put(Short.class, sh);
        concurrentHashMap.put(Integer.class, num);
        concurrentHashMap.put(Float.class, f2);
        concurrentHashMap.put(Long.class, l2);
        concurrentHashMap.put(Double.class, d2);
        concurrentHashMap.put(BigInteger.class, bigInteger);
        concurrentHashMap.put(BigDecimal.class, bigDecimal);
        concurrentHashMap.put(l.class, lVar);
    }

    public static <T> T a(T t) {
        T t2;
        if (t == null || d(t.getClass())) {
            return t;
        }
        if (t instanceof n) {
            return (T) ((n) t).clone();
        }
        Class<?> cls = t.getClass();
        if (cls.isArray()) {
            t2 = (T) Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof a) {
            t2 = (T) ((a) t).clone();
        } else if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
            Object[] array = ((List) t).toArray();
            b(array, array);
            return (T) Arrays.asList(array);
        } else {
            t2 = (T) f0.m(cls);
        }
        b(t, t2);
        return t2;
    }

    public static void b(Object obj, Object obj2) {
        i f2;
        Class<?> cls = obj.getClass();
        int i2 = 0;
        y.a(cls == obj2.getClass());
        if (cls.isArray()) {
            y.a(Array.getLength(obj) == Array.getLength(obj2));
            for (Object obj3 : f0.l(obj)) {
                Array.set(obj2, i2, a(obj3));
                i2++;
            }
        } else if (Collection.class.isAssignableFrom(cls)) {
            Collection<Object> collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            for (Object obj4 : collection) {
                collection2.add(a(obj4));
            }
        } else {
            boolean isAssignableFrom = n.class.isAssignableFrom(cls);
            if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
                if (a.class.isAssignableFrom(cls)) {
                    a aVar = (a) obj2;
                    a aVar2 = (a) obj;
                    int size = aVar2.size();
                    while (i2 < size) {
                        aVar.o(i2, a(aVar2.k(i2)));
                        i2++;
                    }
                    return;
                }
                Map map = (Map) obj2;
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue()));
                }
                return;
            }
            if (isAssignableFrom) {
                f2 = ((n) obj).classInfo;
            } else {
                f2 = i.f(cls);
            }
            for (String str : f2.f13423f) {
                m b2 = f2.b(str);
                if (!b2.h() && (!isAssignableFrom || !b2.i())) {
                    Object g2 = b2.g(obj);
                    if (g2 != null) {
                        b2.m(obj2, a(g2));
                    }
                }
            }
        }
    }

    public static boolean c(Object obj) {
        return obj != null && obj == m.get(obj.getClass());
    }

    public static boolean d(Type type) {
        if (type instanceof WildcardType) {
            type = f0.c((WildcardType) type);
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == l.class || cls == Boolean.class;
        }
        return false;
    }

    public static boolean e(Object obj) {
        return obj == null || d(obj.getClass());
    }

    public static Map<String, Object> f(Object obj) {
        if (obj != null && !c(obj)) {
            if (obj instanceof Map) {
                return (Map) obj;
            }
            return new k(obj, false);
        }
        return Collections.emptyMap();
    }

    public static Collection<Object> g(Type type) {
        if (type instanceof WildcardType) {
            type = f0.c((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls != null) {
            if (cls.isAssignableFrom(HashSet.class)) {
                return new HashSet();
            }
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            return (Collection) f0.m(cls);
        }
        throw new IllegalArgumentException("unable to create new instance of type: " + type);
    }

    public static Map<String, Object> h(Class<?> cls) {
        if (cls != null && !cls.isAssignableFrom(a.class)) {
            if (cls.isAssignableFrom(TreeMap.class)) {
                return new TreeMap();
            }
            return (Map) f0.m(cls);
        }
        return a.c();
    }

    public static <T> T i(Class<?> cls) {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = m;
        T t = (T) concurrentHashMap.get(cls);
        if (t == null) {
            synchronized (concurrentHashMap) {
                t = concurrentHashMap.get(cls);
                if (t == null) {
                    int i2 = 0;
                    if (cls.isArray()) {
                        Class<?> cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i2++;
                        } while (cls2.isArray());
                        t = (T) Array.newInstance(cls2, new int[i2]);
                    } else if (cls.isEnum()) {
                        m b2 = i.f(cls).b(null);
                        y.f(b2, "enum missing constant with @NullValue annotation: %s", cls);
                        t = b2.a();
                    } else {
                        t = f0.m(cls);
                    }
                    m.put(cls, t);
                }
            }
        }
        return t;
    }

    public static Object j(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls != Character.class && cls != Character.TYPE) {
                if (cls != Boolean.class && cls != Boolean.TYPE) {
                    if (cls != Byte.class && cls != Byte.TYPE) {
                        if (cls != Short.class && cls != Short.TYPE) {
                            if (cls != Integer.class && cls != Integer.TYPE) {
                                if (cls != Long.class && cls != Long.TYPE) {
                                    if (cls != Float.class && cls != Float.TYPE) {
                                        if (cls != Double.class && cls != Double.TYPE) {
                                            if (cls == l.class) {
                                                return l.b(str);
                                            }
                                            if (cls == BigInteger.class) {
                                                return new BigInteger(str);
                                            }
                                            if (cls == BigDecimal.class) {
                                                return new BigDecimal(str);
                                            }
                                            if (cls.isEnum()) {
                                                if (i.f(cls).f13423f.contains(str)) {
                                                    return i.f(cls).b(str).a();
                                                }
                                                throw new IllegalArgumentException(String.format("given enum name %s not part of enumeration", str));
                                            }
                                        } else {
                                            return Double.valueOf(str);
                                        }
                                    } else {
                                        return Float.valueOf(str);
                                    }
                                } else {
                                    return Long.valueOf(str);
                                }
                            } else {
                                return Integer.valueOf(str);
                            }
                        } else {
                            return Short.valueOf(str);
                        }
                    } else {
                        return Byte.valueOf(str);
                    }
                } else {
                    return Boolean.valueOf(str);
                }
            } else if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            } else {
                throw new IllegalArgumentException("expected type Character/char but got " + cls);
            }
        }
        throw new IllegalArgumentException("expected primitive class, but got: " + type);
    }

    public static Type k(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = f0.c((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type n = f0.n(list, (TypeVariable) type);
            if (n != null) {
                type = n;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }
}