package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends o implements a<Set<? extends String>> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$knownClassNamesInPackage$1(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
        super(0);
        this.$c = lazyJavaResolverContext;
        this.this$0 = lazyJavaPackageScope;
    }

    @Override // kotlin.e0.c.a
    public final Set<? extends String> invoke() {
        return this.$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.getOwnerDescriptor().getFqName());
    }
}