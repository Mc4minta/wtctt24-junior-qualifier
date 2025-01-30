package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.m;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations first, Annotations second) {
        m.g(first, "first");
        m.g(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new CompositeAnnotations(first, second);
    }
}