package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 extends j implements l<ValueParameterDescriptor, Boolean> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$2();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "declaresDefaultValue";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(ValueParameterDescriptor.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor valueParameterDescriptor) {
        return Boolean.valueOf(invoke2(valueParameterDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(ValueParameterDescriptor p0) {
        m.g(p0, "p0");
        return p0.declaresDefaultValue();
    }
}