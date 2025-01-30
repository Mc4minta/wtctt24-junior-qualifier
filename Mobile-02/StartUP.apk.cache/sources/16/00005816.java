package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* loaded from: classes3.dex */
final class AbstractDeserializedPackageFragmentProvider$fragments$1 extends o implements l<FqName, PackageFragmentDescriptor> {
    final /* synthetic */ AbstractDeserializedPackageFragmentProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        super(1);
        this.this$0 = abstractDeserializedPackageFragmentProvider;
    }

    @Override // kotlin.e0.c.l
    public final PackageFragmentDescriptor invoke(FqName fqName) {
        m.g(fqName, "fqName");
        DeserializedPackageFragment findPackage = this.this$0.findPackage(fqName);
        if (findPackage == null) {
            return null;
        }
        findPackage.initialize(this.this$0.getComponents());
        return findPackage;
    }
}