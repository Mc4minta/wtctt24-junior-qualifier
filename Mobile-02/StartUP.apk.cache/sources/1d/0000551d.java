package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaAnnotationDescriptor$type$2 extends o implements a<SimpleType> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationDescriptor$type$2(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        super(0);
        this.$c = lazyJavaResolverContext;
        this.this$0 = javaAnnotationDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final SimpleType invoke() {
        SimpleType defaultType = this.$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
        m.f(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
        return defaultType;
    }
}