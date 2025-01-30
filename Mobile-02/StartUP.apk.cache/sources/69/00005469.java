package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: CompositePackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final List<PackageFragmentProvider> providers;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> providers) {
        Set M0;
        m.g(providers, "providers");
        this.providers = providers;
        providers.size();
        M0 = z.M0(providers);
        M0.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        m.g(fqName, "fqName");
        m.g(packageFragments, "packageFragments");
        for (PackageFragmentProvider packageFragmentProvider : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, packageFragments);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        List<PackageFragmentDescriptor> I0;
        m.g(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider packageFragmentProvider : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, arrayList);
        }
        I0 = z.I0(arrayList);
        return I0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, l<? super Name, Boolean> nameFilter) {
        m.g(fqName, "fqName");
        m.g(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider packageFragmentProvider : this.providers) {
            hashSet.addAll(packageFragmentProvider.getSubPackagesOf(fqName, nameFilter));
        }
        return hashSet;
    }
}