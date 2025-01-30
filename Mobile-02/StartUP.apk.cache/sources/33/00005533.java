package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: JavaForKotlinOverridePropertyDescriptor.kt */
/* loaded from: classes3.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaForKotlinOverridePropertyDescriptor(ClassDescriptor ownerDescriptor, SimpleFunctionDescriptor getterMethod, SimpleFunctionDescriptor simpleFunctionDescriptor, PropertyDescriptor overriddenProperty) {
        super(ownerDescriptor, Annotations.Companion.getEMPTY(), getterMethod.getModality(), getterMethod.getVisibility(), simpleFunctionDescriptor != null, overriddenProperty.getName(), getterMethod.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        m.g(ownerDescriptor, "ownerDescriptor");
        m.g(getterMethod, "getterMethod");
        m.g(overriddenProperty, "overriddenProperty");
    }
}