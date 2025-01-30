package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* compiled from: ModalityUtils.kt */
/* loaded from: classes3.dex */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor classDescriptor) {
        m.g(classDescriptor, "<this>");
        return classDescriptor.getModality() == Modality.FINAL && classDescriptor.getKind() != ClassKind.ENUM_CLASS;
    }
}