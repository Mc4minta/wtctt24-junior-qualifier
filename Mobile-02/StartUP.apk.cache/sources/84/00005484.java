package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.m0;
import kotlin.a0.n;
import kotlin.a0.r;
import kotlin.a0.s0;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;

/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    private final KotlinBuiltIns builtIns;
    private final Map<ModuleCapability<?>, Object> capabilities;
    private ModuleDependencies dependencies;
    private boolean isValid;
    private PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final h packageFragmentProviderForWholeModuleWithDependencies$delegate;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    private final TargetPlatform platform;
    private final Name stableName;
    private final StorageManager storageManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name moduleName, StorageManager storageManager, KotlinBuiltIns builtIns, TargetPlatform targetPlatform) {
        this(moduleName, storageManager, builtIns, targetPlatform, null, null, 48, null);
        m.g(moduleName, "moduleName");
        m.g(storageManager, "storageManager");
        m.g(builtIns, "builtIns");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name r10, kotlin.reflect.jvm.internal.impl.storage.StorageManager r11, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r12, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform r13, java.util.Map r14, kotlin.reflect.jvm.internal.impl.name.Name r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L7
            r6 = r1
            goto L8
        L7:
            r6 = r13
        L8:
            r0 = r16 & 16
            if (r0 == 0) goto L12
            java.util.Map r0 = kotlin.a0.j0.i()
            r7 = r0
            goto L13
        L12:
            r7 = r14
        L13:
            r0 = r16 & 32
            if (r0 == 0) goto L19
            r8 = r1
            goto L1a
        L19:
            r8 = r15
        L1a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform, java.util.Map, kotlin.reflect.jvm.internal.impl.name.Name, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getId() {
        String name = getName().toString();
        m.f(name, "name.toString()");
        return name;
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d2);
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(m.o("Accessing invalid module descriptor ", this));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(ModuleCapability<T> capability) {
        m.g(capability, "capability");
        return (T) this.capabilities.get(capability);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName fqName) {
        m.g(fqName, "fqName");
        assertValid();
        return this.packages.invoke(fqName);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName fqName, l<? super Name, Boolean> nameFilter) {
        m.g(fqName, "fqName");
        m.g(nameFilter, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, nameFilter);
    }

    public final void initialize(PackageFragmentProvider providerForModuleContent) {
        m.g(providerForModuleContent, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = providerForModuleContent;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public final void setDependencies(ModuleDependencies dependencies) {
        m.g(dependencies, "dependencies");
        ModuleDependencies moduleDependencies = this.dependencies;
        this.dependencies = dependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor targetModule) {
        boolean O;
        m.g(targetModule, "targetModule");
        if (m.c(this, targetModule)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        m.e(moduleDependencies);
        O = z.O(moduleDependencies.getModulesWhoseInternalsAreVisible(), targetModule);
        return O || getExpectedByModules().contains(targetModule) || targetModule.getExpectedByModules().contains(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name moduleName, StorageManager storageManager, KotlinBuiltIns builtIns, TargetPlatform targetPlatform, Map<ModuleCapability<?>, ? extends Object> capabilities, Name name) {
        super(Annotations.Companion.getEMPTY(), moduleName);
        Map<ModuleCapability<?>, Object> v;
        h b2;
        m.g(moduleName, "moduleName");
        m.g(storageManager, "storageManager");
        m.g(builtIns, "builtIns");
        m.g(capabilities, "capabilities");
        this.storageManager = storageManager;
        this.builtIns = builtIns;
        this.platform = targetPlatform;
        this.stableName = name;
        if (moduleName.isSpecial()) {
            v = m0.v(capabilities);
            this.capabilities = v;
            v.put(KotlinTypeRefinerKt.getREFINER_CAPABILITY(), new Ref(null));
            this.isValid = true;
            this.packages = storageManager.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
            b2 = k.b(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
            this.packageFragmentProviderForWholeModuleWithDependencies$delegate = b2;
            return;
        }
        throw new IllegalArgumentException(m.o("Module name must be special: ", moduleName));
    }

    public final void setDependencies(ModuleDescriptorImpl... descriptors) {
        List<ModuleDescriptorImpl> e0;
        m.g(descriptors, "descriptors");
        e0 = n.e0(descriptors);
        setDependencies(e0);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> descriptors) {
        Set<ModuleDescriptorImpl> b2;
        m.g(descriptors, "descriptors");
        b2 = s0.b();
        setDependencies(descriptors, b2);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> descriptors, Set<ModuleDescriptorImpl> friends) {
        List g2;
        Set b2;
        m.g(descriptors, "descriptors");
        m.g(friends, "friends");
        g2 = r.g();
        b2 = s0.b();
        setDependencies(new ModuleDependenciesImpl(descriptors, friends, g2, b2));
    }
}