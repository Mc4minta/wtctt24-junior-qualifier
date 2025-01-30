package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: context.kt */
/* loaded from: classes3.dex */
public final class ContextKt$copyWithNewDefaultTypeQualifiers$1 extends o implements a<JavaTypeQualifiersByElementType> {
    final /* synthetic */ Annotations $additionalAnnotations;
    final /* synthetic */ LazyJavaResolverContext $this_copyWithNewDefaultTypeQualifiers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextKt$copyWithNewDefaultTypeQualifiers$1(LazyJavaResolverContext lazyJavaResolverContext, Annotations annotations) {
        super(0);
        this.$this_copyWithNewDefaultTypeQualifiers = lazyJavaResolverContext;
        this.$additionalAnnotations = annotations;
    }

    @Override // kotlin.e0.c.a
    public final JavaTypeQualifiersByElementType invoke() {
        return ContextKt.computeNewDefaultTypeQualifiers(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
    }
}