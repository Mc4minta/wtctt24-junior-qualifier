package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: PackageFragmentProviderImpl.kt */
/* loaded from: classes3.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    private final Collection<PackageFragmentDescriptor> packageFragments;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> packageFragments) {
        m.g(packageFragments, "packageFragments");
        this.packageFragments = packageFragments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        m.g(fqName, "fqName");
        m.g(packageFragments, "packageFragments");
        for (Object obj : this.packageFragments) {
            if (m.c(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        m.g(fqName, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.packageFragments;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (m.c(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, l<? super Name, Boolean> nameFilter) {
        h M;
        h v;
        h m;
        List B;
        m.g(fqName, "fqName");
        m.g(nameFilter, "nameFilter");
        M = z.M(this.packageFragments);
        v = p.v(M, PackageFragmentProviderImpl$getSubPackagesOf$1.INSTANCE);
        m = p.m(v, new PackageFragmentProviderImpl$getSubPackagesOf$2(fqName));
        B = p.B(m);
        return B;
    }
}