package kotlin.e0;

import java.lang.annotation.Annotation;
import java.util.Objects;
import kotlin.j0.d;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: JvmClassMapping.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final <T extends Annotation> d<? extends T> a(T annotationClass) {
        m.g(annotationClass, "$this$annotationClass");
        Class<? extends Annotation> annotationType = annotationClass.annotationType();
        m.f(annotationType, "(this as java.lang.annot…otation).annotationType()");
        d<? extends T> e2 = e(annotationType);
        Objects.requireNonNull(e2, "null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return e2;
    }

    public static final <T> Class<T> b(d<T> java) {
        m.g(java, "$this$java");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.d) java).getJClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }

    public static final <T> Class<T> c(d<T> javaObjectType) {
        m.g(javaObjectType, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.d) javaObjectType).getJClass();
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    return name.equals("double") ? Double.class : cls;
                case 104431:
                    return name.equals("int") ? Integer.class : cls;
                case 3039496:
                    return name.equals("byte") ? Byte.class : cls;
                case 3052374:
                    return name.equals("char") ? Character.class : cls;
                case 3327612:
                    return name.equals("long") ? Long.class : cls;
                case 3625364:
                    return name.equals("void") ? Void.class : cls;
                case 64711720:
                    return name.equals("boolean") ? Boolean.class : cls;
                case 97526364:
                    return name.equals("float") ? Float.class : cls;
                case 109413500:
                    return name.equals("short") ? Short.class : cls;
                default:
                    return cls;
            }
        }
        return cls;
    }

    public static final <T> Class<T> d(d<T> javaPrimitiveType) {
        m.g(javaPrimitiveType, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.d) javaPrimitiveType).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                break;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                break;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                break;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                break;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                break;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                break;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                break;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                break;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                break;
        }
        return null;
    }

    public static final <T> d<T> e(Class<T> kotlin2) {
        m.g(kotlin2, "$this$kotlin");
        return e0.b(kotlin2);
    }
}