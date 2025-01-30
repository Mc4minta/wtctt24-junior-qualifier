package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: CompanionObjectMappingUtils.kt */
/* loaded from: classes3.dex */
public final class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping companionObjectMapping, ClassDescriptor classDescriptor) {
        boolean O;
        m.g(companionObjectMapping, "<this>");
        m.g(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set<ClassId> classIds = companionObjectMapping.getClassIds();
            ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
            O = z.O(classIds, classId == null ? null : classId.getOuterClassId());
            if (O) {
                return true;
            }
        }
        return false;
    }
}