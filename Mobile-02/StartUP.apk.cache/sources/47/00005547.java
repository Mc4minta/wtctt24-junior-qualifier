package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.a0.r;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f17393c;
    private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents components) {
        h c2;
        m.g(components, "components");
        TypeParameterResolver.EMPTY empty = TypeParameterResolver.EMPTY.INSTANCE;
        c2 = l.c(null);
        LazyJavaResolverContext lazyJavaResolverContext = new LazyJavaResolverContext(components, empty, c2);
        this.f17393c = lazyJavaResolverContext;
        this.packageFragments = lazyJavaResolverContext.getStorageManager().createCacheWithNotNullValues();
    }

    private final LazyJavaPackageFragment getPackageFragment(FqName fqName) {
        JavaPackage findPackage = this.f17393c.getComponents().getFinder().findPackage(fqName);
        if (findPackage == null) {
            return null;
        }
        return this.packageFragments.computeIfAbsent(fqName, new LazyJavaPackageFragmentProvider$getPackageFragment$1(this, findPackage));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        m.g(fqName, "fqName");
        m.g(packageFragments, "packageFragments");
        CollectionsKt.addIfNotNull(packageFragments, getPackageFragment(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<LazyJavaPackageFragment> getPackageFragments(FqName fqName) {
        List<LazyJavaPackageFragment> k2;
        m.g(fqName, "fqName");
        k2 = r.k(getPackageFragment(fqName));
        return k2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName fqName, kotlin.e0.c.l lVar) {
        return getSubPackagesOf(fqName, (kotlin.e0.c.l<? super Name, Boolean>) lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName fqName, kotlin.e0.c.l<? super Name, Boolean> nameFilter) {
        List<FqName> g2;
        m.g(fqName, "fqName");
        m.g(nameFilter, "nameFilter");
        LazyJavaPackageFragment packageFragment = getPackageFragment(fqName);
        List<FqName> subPackageFqNames$descriptors_jvm = packageFragment == null ? null : packageFragment.getSubPackageFqNames$descriptors_jvm();
        if (subPackageFqNames$descriptors_jvm != null) {
            return subPackageFqNames$descriptors_jvm;
        }
        g2 = r.g();
        return g2;
    }
}