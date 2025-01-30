package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: FieldDescriptorImpl.kt */
/* loaded from: classes3.dex */
public final class FieldDescriptorImpl extends AnnotatedImpl implements FieldDescriptor {
    private final PropertyDescriptor correspondingProperty;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldDescriptorImpl(Annotations annotations, PropertyDescriptor correspondingProperty) {
        super(annotations);
        m.g(annotations, "annotations");
        m.g(correspondingProperty, "correspondingProperty");
        this.correspondingProperty = correspondingProperty;
    }
}