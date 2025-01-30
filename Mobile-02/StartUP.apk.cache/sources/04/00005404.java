package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.e0.c.l;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: PackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public interface PackageFragmentProvider {
    List<PackageFragmentDescriptor> getPackageFragments(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, l<? super Name, Boolean> lVar);
}