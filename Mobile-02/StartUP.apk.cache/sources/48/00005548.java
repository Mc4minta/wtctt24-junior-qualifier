package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider$getPackageFragment$1 extends o implements a<LazyJavaPackageFragment> {
    final /* synthetic */ JavaPackage $jPackage;
    final /* synthetic */ LazyJavaPackageFragmentProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragmentProvider$getPackageFragment$1(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaPackage javaPackage) {
        super(0);
        this.this$0 = lazyJavaPackageFragmentProvider;
        this.$jPackage = javaPackage;
    }

    @Override // kotlin.e0.c.a
    public final LazyJavaPackageFragment invoke() {
        LazyJavaResolverContext lazyJavaResolverContext;
        lazyJavaResolverContext = this.this$0.f17393c;
        return new LazyJavaPackageFragment(lazyJavaResolverContext, this.$jPackage);
    }
}