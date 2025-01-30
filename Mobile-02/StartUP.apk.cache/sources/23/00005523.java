package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaPropertyInitializerEvaluator.kt */
/* loaded from: classes3.dex */
public interface JavaPropertyInitializerEvaluator {

    /* compiled from: JavaPropertyInitializerEvaluator.kt */
    /* loaded from: classes3.dex */
    public static final class DoNothing implements JavaPropertyInitializerEvaluator {
        public static final DoNothing INSTANCE = new DoNothing();

        private DoNothing() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
        public ConstantValue<?> getInitializerConstant(JavaField field, PropertyDescriptor descriptor) {
            m.g(field, "field");
            m.g(descriptor, "descriptor");
            return null;
        }
    }

    ConstantValue<?> getInitializerConstant(JavaField javaField, PropertyDescriptor propertyDescriptor);
}