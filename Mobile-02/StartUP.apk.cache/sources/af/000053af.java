package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.r0;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: JavaToKotlinClassMapper.kt */
/* loaded from: classes3.dex */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = new JavaToKotlinClassMapper();

    private JavaToKotlinClassMapper() {
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor mutable) {
        m.g(mutable, "mutable");
        FqName mutableToReadOnly = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(mutable));
        if (mutableToReadOnly != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(mutable).getBuiltInClassByFqName(mutableToReadOnly);
            m.f(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor readOnly) {
        m.g(readOnly, "readOnly");
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(readOnly));
        if (readOnlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(readOnly).getBuiltInClassByFqName(readOnlyToMutable);
            m.f(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean isMutable(ClassDescriptor mutable) {
        m.g(mutable, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(mutable));
    }

    public final boolean isReadOnly(ClassDescriptor readOnly) {
        m.g(readOnly, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(readOnly));
    }

    public final ClassDescriptor mapJavaToKotlin(FqName fqName, KotlinBuiltIns builtIns, Integer num) {
        ClassId mapJavaToKotlin;
        m.g(fqName, "fqName");
        m.g(builtIns, "builtIns");
        if (num == null || !m.c(fqName, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            mapJavaToKotlin = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
        } else {
            StandardNames standardNames = StandardNames.INSTANCE;
            mapJavaToKotlin = StandardNames.getFunctionClassId(num.intValue());
        }
        if (mapJavaToKotlin != null) {
            return builtIns.getBuiltInClassByFqName(mapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName fqName, KotlinBuiltIns builtIns) {
        List j2;
        Set a;
        Set b2;
        m.g(fqName, "fqName");
        m.g(builtIns, "builtIns");
        ClassDescriptor mapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, builtIns, null, 4, null);
        if (mapJavaToKotlin$default == null) {
            b2 = s0.b();
            return b2;
        }
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(mapJavaToKotlin$default));
        if (readOnlyToMutable == null) {
            a = r0.a(mapJavaToKotlin$default);
            return a;
        }
        ClassDescriptor builtInClassByFqName = builtIns.getBuiltInClassByFqName(readOnlyToMutable);
        m.f(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        j2 = r.j(mapJavaToKotlin$default, builtInClassByFqName);
        return j2;
    }

    public final boolean isMutable(KotlinType type) {
        m.g(type, "type");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(type);
        return classDescriptor != null && isMutable(classDescriptor);
    }

    public final boolean isReadOnly(KotlinType type) {
        m.g(type, "type");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(type);
        return classDescriptor != null && isReadOnly(classDescriptor);
    }
}