package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeParameterUtils.kt */
/* loaded from: classes3.dex */
public final class PossiblyInnerType {
    private final List<TypeProjection> arguments;
    private final ClassifierDescriptorWithTypeParameters classifierDescriptor;
    private final PossiblyInnerType outerType;

    /* JADX WARN: Multi-variable type inference failed */
    public PossiblyInnerType(ClassifierDescriptorWithTypeParameters classifierDescriptor, List<? extends TypeProjection> arguments, PossiblyInnerType possiblyInnerType) {
        m.g(classifierDescriptor, "classifierDescriptor");
        m.g(arguments, "arguments");
        this.classifierDescriptor = classifierDescriptor;
        this.arguments = arguments;
        this.outerType = possiblyInnerType;
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.classifierDescriptor;
    }

    public final PossiblyInnerType getOuterType() {
        return this.outerType;
    }
}