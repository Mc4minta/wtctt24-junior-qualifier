package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotFoundClasses.kt */
/* loaded from: classes3.dex */
public final class NotFoundClasses$packageFragments$1 extends o implements l<FqName, PackageFragmentDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotFoundClasses$packageFragments$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    @Override // kotlin.e0.c.l
    public final PackageFragmentDescriptor invoke(FqName fqName) {
        ModuleDescriptor moduleDescriptor;
        m.g(fqName, "fqName");
        moduleDescriptor = this.this$0.module;
        return new EmptyPackageFragmentDescriptor(moduleDescriptor, fqName);
    }
}