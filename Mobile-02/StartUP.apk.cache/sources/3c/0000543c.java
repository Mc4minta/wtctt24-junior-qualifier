package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.coinbase.ApiConstants;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.u;

/* compiled from: annotationUtil.kt */
/* loaded from: classes3.dex */
public final class AnnotationUtilKt {
    private static final Name DEPRECATED_LEVEL_NAME;
    private static final Name DEPRECATED_MESSAGE_NAME;
    private static final Name DEPRECATED_REPLACE_WITH_NAME;
    private static final Name REPLACE_WITH_EXPRESSION_NAME;
    private static final Name REPLACE_WITH_IMPORTS_NAME;

    static {
        Name identifier = Name.identifier(ApiConstants.MESSAGE);
        m.f(identifier, "identifier(\"message\")");
        DEPRECATED_MESSAGE_NAME = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        m.f(identifier2, "identifier(\"replaceWith\")");
        DEPRECATED_REPLACE_WITH_NAME = identifier2;
        Name identifier3 = Name.identifier("level");
        m.f(identifier3, "identifier(\"level\")");
        DEPRECATED_LEVEL_NAME = identifier3;
        Name identifier4 = Name.identifier("expression");
        m.f(identifier4, "identifier(\"expression\")");
        REPLACE_WITH_EXPRESSION_NAME = identifier4;
        Name identifier5 = Name.identifier("imports");
        m.f(identifier5, "identifier(\"imports\")");
        REPLACE_WITH_IMPORTS_NAME = identifier5;
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(KotlinBuiltIns kotlinBuiltIns, String message, String replaceWith, String level) {
        List g2;
        Map l2;
        Map l3;
        m.g(kotlinBuiltIns, "<this>");
        m.g(message, "message");
        m.g(replaceWith, "replaceWith");
        m.g(level, "level");
        FqName fqName = StandardNames.FqNames.replaceWith;
        Name name = REPLACE_WITH_IMPORTS_NAME;
        g2 = r.g();
        l2 = m0.l(u.a(REPLACE_WITH_EXPRESSION_NAME, new StringValue(replaceWith)), u.a(name, new ArrayValue(g2, new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(kotlinBuiltIns))));
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, l2);
        FqName fqName2 = StandardNames.FqNames.deprecated;
        Name name2 = DEPRECATED_LEVEL_NAME;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        m.f(classId, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name identifier = Name.identifier(level);
        m.f(identifier, "identifier(level)");
        l3 = m0.l(u.a(DEPRECATED_MESSAGE_NAME, new StringValue(message)), u.a(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(builtInAnnotationDescriptor)), u.a(name2, new EnumValue(classId, identifier)));
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName2, l3);
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }
}