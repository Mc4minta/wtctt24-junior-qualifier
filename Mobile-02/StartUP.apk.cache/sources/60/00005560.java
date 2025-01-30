package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor$scopeHolder$1 extends o implements l<KotlinTypeRefiner, LazyJavaClassMemberScope> {
    final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(1);
        this.this$0 = lazyJavaClassDescriptor;
    }

    @Override // kotlin.e0.c.l
    public final LazyJavaClassMemberScope invoke(KotlinTypeRefiner it) {
        LazyJavaClassMemberScope lazyJavaClassMemberScope;
        m.g(it, "it");
        LazyJavaResolverContext lazyJavaResolverContext = this.this$0.f17397c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        JavaClass jClass = lazyJavaClassDescriptor.getJClass();
        boolean z = this.this$0.additionalSupertypeClassDescriptor != null;
        lazyJavaClassMemberScope = this.this$0.unsubstitutedMemberScope;
        return new LazyJavaClassMemberScope(lazyJavaResolverContext, lazyJavaClassDescriptor, jClass, z, lazyJavaClassMemberScope);
    }
}