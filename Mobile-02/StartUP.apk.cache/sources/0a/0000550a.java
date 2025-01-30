package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* compiled from: JvmAbi.kt */
/* loaded from: classes3.dex */
public final class JvmAbi {
    public static final JvmAbi INSTANCE = new JvmAbi();
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmField");
    private static final ClassId REFLECTION_FACTORY_IMPL;

    static {
        ClassId classId = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        m.f(classId, "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
        REFLECTION_FACTORY_IMPL = classId;
    }

    private JvmAbi() {
    }

    public static final String getterName(String propertyName) {
        m.g(propertyName, "propertyName");
        return startsWithIsPrefix(propertyName) ? propertyName : m.o("get", CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName));
    }

    public static final boolean isGetterName(String name) {
        boolean Q;
        boolean Q2;
        m.g(name, "name");
        Q = x.Q(name, "get", false, 2, null);
        if (!Q) {
            Q2 = x.Q(name, "is", false, 2, null);
            if (!Q2) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isSetterName(String name) {
        boolean Q;
        m.g(name, "name");
        Q = x.Q(name, "set", false, 2, null);
        return Q;
    }

    public static final String setterName(String propertyName) {
        String capitalizeAsciiOnly;
        m.g(propertyName, "propertyName");
        if (startsWithIsPrefix(propertyName)) {
            capitalizeAsciiOnly = propertyName.substring(2);
            m.f(capitalizeAsciiOnly, "(this as java.lang.String).substring(startIndex)");
        } else {
            capitalizeAsciiOnly = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
        }
        return m.o("set", capitalizeAsciiOnly);
    }

    public static final boolean startsWithIsPrefix(String name) {
        boolean Q;
        m.g(name, "name");
        Q = x.Q(name, "is", false, 2, null);
        if (Q && name.length() != 2) {
            char charAt = name.charAt(2);
            return m.i(97, charAt) > 0 || m.i(charAt, 122) > 0;
        }
        return false;
    }
}