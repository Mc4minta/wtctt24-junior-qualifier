package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProviderImpl.kt */
/* loaded from: classes3.dex */
final class PackageFragmentProviderImpl$getSubPackagesOf$2 extends o implements l<FqName, Boolean> {
    final /* synthetic */ FqName $fqName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackageFragmentProviderImpl$getSubPackagesOf$2(FqName fqName) {
        super(1);
        this.$fqName = fqName;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(FqName fqName) {
        return Boolean.valueOf(invoke2(fqName));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(FqName it) {
        m.g(it, "it");
        return !it.isRoot() && m.c(it.parent(), this.$fqName);
    }
}