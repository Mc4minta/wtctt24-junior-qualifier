package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public final class PackageFragmentProviderKt {
    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider packageFragmentProvider, FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        m.g(packageFragmentProvider, "<this>");
        m.g(fqName, "fqName");
        m.g(packageFragments, "packageFragments");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(fqName, packageFragments);
        } else {
            packageFragments.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        m.g(packageFragmentProvider, "<this>");
        m.g(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, arrayList);
        return arrayList;
    }
}