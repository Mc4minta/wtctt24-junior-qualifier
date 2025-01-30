package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* loaded from: classes3.dex */
final class LazyPackageViewDescriptorImpl$fragments$2 extends o implements a<List<? extends PackageFragmentDescriptor>> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends PackageFragmentDescriptor> invoke() {
        return PackageFragmentProviderKt.packageFragments(this.this$0.getModule().getPackageFragmentProvider(), this.this$0.getFqName());
    }
}