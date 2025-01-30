package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum AnnotationArgumentsRenderingPolicy {
    NO_ARGUMENTS(false, false, 3, null),
    UNLESS_EMPTY(true, false, 2, null),
    ALWAYS_PARENTHESIZED(true, true);
    
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    AnnotationArgumentsRenderingPolicy(boolean z, boolean z2) {
        this.includeAnnotationArguments = z;
        this.includeEmptyAnnotationArguments = z2;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static AnnotationArgumentsRenderingPolicy[] valuesCustom() {
        AnnotationArgumentsRenderingPolicy[] valuesCustom = values();
        AnnotationArgumentsRenderingPolicy[] annotationArgumentsRenderingPolicyArr = new AnnotationArgumentsRenderingPolicy[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, annotationArgumentsRenderingPolicyArr, 0, valuesCustom.length);
        return annotationArgumentsRenderingPolicyArr;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    /* synthetic */ AnnotationArgumentsRenderingPolicy(boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2);
    }
}