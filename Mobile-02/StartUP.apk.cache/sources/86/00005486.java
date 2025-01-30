package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl$packages$1 extends o implements l<FqName, PackageViewDescriptor> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(1);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // kotlin.e0.c.l
    public final PackageViewDescriptor invoke(FqName fqName) {
        StorageManager storageManager;
        m.g(fqName, "fqName");
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        storageManager = moduleDescriptorImpl.storageManager;
        return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, fqName, storageManager);
    }
}