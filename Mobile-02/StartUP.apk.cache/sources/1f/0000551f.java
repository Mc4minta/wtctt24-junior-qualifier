package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.a0.s0;
import kotlin.a0.w;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.u;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaAnnotationTargetMapper {
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    private static final Map<String, KotlinRetention> retentionNameList;
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists;

    static {
        Map<String, EnumSet<KotlinTarget>> l2;
        Map<String, KotlinRetention> l3;
        l2 = m0.l(u.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), u.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), u.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), u.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), u.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), u.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), u.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), u.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), u.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), u.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
        targetNameLists = l2;
        l3 = m0.l(u.a("RUNTIME", KotlinRetention.RUNTIME), u.a("CLASS", KotlinRetention.BINARY), u.a("SOURCE", KotlinRetention.SOURCE));
        retentionNameList = l3;
    }

    private JavaAnnotationTargetMapper() {
    }

    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationArgument javaAnnotationArgument) {
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument ? (JavaEnumValueAnnotationArgument) javaAnnotationArgument : null;
        if (javaEnumValueAnnotationArgument == null) {
            return null;
        }
        Map<String, KotlinRetention> map = retentionNameList;
        Name entryName = javaEnumValueAnnotationArgument.getEntryName();
        KotlinRetention kotlinRetention = map.get(entryName == null ? null : entryName.asString());
        if (kotlinRetention == null) {
            return null;
        }
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.annotationRetention);
        m.f(classId, "topLevel(StandardNames.FqNames.annotationRetention)");
        Name identifier = Name.identifier(kotlinRetention.name());
        m.f(identifier, "identifier(retention.name)");
        return new EnumValue(classId, identifier);
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String str) {
        Set<KotlinTarget> b2;
        EnumSet<KotlinTarget> enumSet = targetNameLists.get(str);
        if (enumSet == null) {
            b2 = s0.b();
            return b2;
        }
        return enumSet;
    }

    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(List<? extends JavaAnnotationArgument> arguments) {
        int r;
        m.g(arguments, "arguments");
        ArrayList<JavaEnumValueAnnotationArgument> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument : arrayList) {
            Name entryName = javaEnumValueAnnotationArgument.getEntryName();
            w.y(arrayList2, mapJavaTargetArgumentByName(entryName == null ? null : entryName.asString()));
        }
        r = s.r(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(r);
        for (KotlinTarget kotlinTarget : arrayList2) {
            ClassId classId = ClassId.topLevel(StandardNames.FqNames.annotationTarget);
            m.f(classId, "topLevel(StandardNames.FqNames.annotationTarget)");
            Name identifier = Name.identifier(kotlinTarget.name());
            m.f(identifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new EnumValue(classId, identifier));
        }
        return new ArrayValue(arrayList3, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }
}