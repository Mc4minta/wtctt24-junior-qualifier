package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: context.kt */
/* loaded from: classes3.dex */
public final class ContextKt$childForClassOrPackage$1 extends o implements a<JavaTypeQualifiersByElementType> {
    final /* synthetic */ ClassOrPackageFragmentDescriptor $containingDeclaration;
    final /* synthetic */ LazyJavaResolverContext $this_childForClassOrPackage;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextKt$childForClassOrPackage$1(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        super(0);
        this.$this_childForClassOrPackage = lazyJavaResolverContext;
        this.$containingDeclaration = classOrPackageFragmentDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final JavaTypeQualifiersByElementType invoke() {
        return ContextKt.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
    }
}