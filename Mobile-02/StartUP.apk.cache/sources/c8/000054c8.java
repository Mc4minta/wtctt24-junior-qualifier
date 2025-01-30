package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaClassObjectAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaClassObjectAnnotationArgument {
    private final Class<?> klass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaClassObjectAnnotationArgument(Name name, Class<?> klass) {
        super(name);
        m.g(klass, "klass");
        this.klass = klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument
    public JavaType getReferencedType() {
        return ReflectJavaType.Factory.create(this.klass);
    }
}