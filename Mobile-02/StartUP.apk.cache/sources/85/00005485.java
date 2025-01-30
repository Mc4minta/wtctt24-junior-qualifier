package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends o implements a<CompositePackageFragmentProvider> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // kotlin.e0.c.a
    public final CompositePackageFragmentProvider invoke() {
        ModuleDependencies moduleDependencies;
        String id;
        int r;
        PackageFragmentProvider packageFragmentProvider;
        moduleDependencies = this.this$0.dependencies;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        if (moduleDependencies != null) {
            List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
            allDependencies.contains(this.this$0);
            for (ModuleDescriptorImpl moduleDescriptorImpl2 : allDependencies) {
                moduleDescriptorImpl2.isInitialized();
            }
            r = s.r(allDependencies, 10);
            ArrayList arrayList = new ArrayList(r);
            for (ModuleDescriptorImpl moduleDescriptorImpl3 : allDependencies) {
                packageFragmentProvider = moduleDescriptorImpl3.packageFragmentProviderForModuleContent;
                m.e(packageFragmentProvider);
                arrayList.add(packageFragmentProvider);
            }
            return new CompositePackageFragmentProvider(arrayList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Dependencies of module ");
        id = moduleDescriptorImpl.getId();
        sb.append(id);
        sb.append(" were not set before querying module content");
        throw new AssertionError(sb.toString());
    }
}