package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: methodSignatureBuildingUtils.kt */
/* loaded from: classes3.dex */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents signatureBuildingComponents, ClassDescriptor classDescriptor, String jvmDescriptor) {
        m.g(signatureBuildingComponents, "<this>");
        m.g(classDescriptor, "classDescriptor");
        m.g(jvmDescriptor, "jvmDescriptor");
        return signatureBuildingComponents.signature(MethodSignatureMappingKt.getInternalName(classDescriptor), jvmDescriptor);
    }
}