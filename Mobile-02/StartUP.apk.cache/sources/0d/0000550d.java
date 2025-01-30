package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* compiled from: propertiesConventionUtil.kt */
/* loaded from: classes3.dex */
public final class PropertiesConventionUtilKt {
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        List<Name> k2;
        m.g(name, "name");
        String asString = name.asString();
        m.f(asString, "name.asString()");
        JvmAbi jvmAbi = JvmAbi.INSTANCE;
        if (JvmAbi.isGetterName(asString)) {
            k2 = r.k(propertyNameByGetMethodName(name));
            return k2;
        } else if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        } else {
            return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
        }
    }

    public static final Name propertyNameByGetMethodName(Name methodName) {
        m.g(methodName, "methodName");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        return propertyNameFromAccessorMethodName$default == null ? propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null) : propertyNameFromAccessorMethodName$default;
    }

    public static final Name propertyNameBySetMethodName(Name methodName, boolean z) {
        m.g(methodName, "methodName");
        return propertyNameFromAccessorMethodName$default(methodName, "set", false, z ? "is" : null, 4, null);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z, String str2) {
        boolean Q;
        String A0;
        String A02;
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        m.f(identifier, "methodName.identifier");
        boolean z2 = false;
        Q = x.Q(identifier, str, false, 2, null);
        if (Q && identifier.length() != str.length()) {
            char charAt = identifier.charAt(str.length());
            if ('a' <= charAt && charAt <= 'z') {
                z2 = true;
            }
            if (z2) {
                return null;
            }
            if (str2 != null) {
                A02 = y.A0(identifier, str);
                return Name.identifier(m.o(str2, A02));
            } else if (z) {
                A0 = y.A0(identifier, str);
                String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(A0, true);
                if (Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                    return Name.identifier(decapitalizeSmartForCompiler);
                }
                return null;
            } else {
                return name;
            }
        }
        return null;
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z, str2);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name methodName) {
        List<Name> l2;
        m.g(methodName, "methodName");
        l2 = r.l(propertyNameBySetMethodName(methodName, false), propertyNameBySetMethodName(methodName, true));
        return l2;
    }
}