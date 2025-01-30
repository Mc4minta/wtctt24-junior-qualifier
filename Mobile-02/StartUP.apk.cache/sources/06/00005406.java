package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProviderImpl.kt */
/* loaded from: classes3.dex */
final class PackageFragmentProviderImpl$getSubPackagesOf$1 extends o implements l<PackageFragmentDescriptor, FqName> {
    public static final PackageFragmentProviderImpl$getSubPackagesOf$1 INSTANCE = new PackageFragmentProviderImpl$getSubPackagesOf$1();

    PackageFragmentProviderImpl$getSubPackagesOf$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final FqName invoke(PackageFragmentDescriptor it) {
        m.g(it, "it");
        return it.getFqName();
    }
}