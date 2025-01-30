package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* loaded from: classes3.dex */
final class LazyPackageViewDescriptorImpl$memberScope$1 extends o implements a<MemberScope> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // kotlin.e0.c.a
    public final MemberScope invoke() {
        int r;
        List u0;
        if (this.this$0.getFragments().isEmpty()) {
            return MemberScope.Empty.INSTANCE;
        }
        List<PackageFragmentDescriptor> fragments = this.this$0.getFragments();
        r = s.r(fragments, 10);
        ArrayList arrayList = new ArrayList(r);
        for (PackageFragmentDescriptor packageFragmentDescriptor : fragments) {
            arrayList.add(packageFragmentDescriptor.getMemberScope());
        }
        u0 = z.u0(arrayList, new SubpackagesScope(this.this$0.getModule(), this.this$0.getFqName()));
        ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
        return companion.create("package view scope for " + this.this$0.getFqName() + " in " + this.this$0.getModule().getName(), u0);
    }
}