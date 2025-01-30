package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: JavaDescriptorUtil.kt */
/* loaded from: classes3.dex */
public final class JavaDescriptorUtilKt {
    public static final boolean isJavaField(PropertyDescriptor propertyDescriptor) {
        m.g(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }
}