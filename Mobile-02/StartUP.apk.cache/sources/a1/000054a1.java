package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;

/* compiled from: ReflectAnnotationSource.kt */
/* loaded from: classes3.dex */
public final class ReflectAnnotationSource implements SourceElement {
    private final Annotation annotation;

    public ReflectAnnotationSource(Annotation annotation) {
        m.g(annotation, "annotation");
        this.annotation = annotation;
    }

    public final Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
        m.f(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }
}