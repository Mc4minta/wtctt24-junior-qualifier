package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;

/* compiled from: RuntimeSourceElementFactory.kt */
/* loaded from: classes3.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory INSTANCE = new RuntimeSourceElementFactory();

    /* compiled from: RuntimeSourceElementFactory.kt */
    /* loaded from: classes3.dex */
    public static final class RuntimeSourceElement implements JavaSourceElement {
        private final ReflectJavaElement javaElement;

        public RuntimeSourceElement(ReflectJavaElement javaElement) {
            m.g(javaElement, "javaElement");
            this.javaElement = javaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        public SourceFile getContainingFile() {
            SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
            m.f(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        public ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public String toString() {
            return RuntimeSourceElement.class.getName() + ": " + getJavaElement();
        }
    }

    private RuntimeSourceElementFactory() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    public JavaSourceElement source(JavaElement javaElement) {
        m.g(javaElement, "javaElement");
        return new RuntimeSourceElement((ReflectJavaElement) javaElement);
    }
}