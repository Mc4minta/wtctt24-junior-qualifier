package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.s0;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    protected DeserializationComponents components;
    private final KotlinMetadataFinder finder;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    private final ModuleDescriptor moduleDescriptor;
    private final StorageManager storageManager;

    public AbstractDeserializedPackageFragmentProvider(StorageManager storageManager, KotlinMetadataFinder finder, ModuleDescriptor moduleDescriptor) {
        m.g(storageManager, "storageManager");
        m.g(finder, "finder");
        m.g(moduleDescriptor, "moduleDescriptor");
        this.storageManager = storageManager;
        this.finder = finder;
        this.moduleDescriptor = moduleDescriptor;
        this.fragments = storageManager.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> packageFragments) {
        m.g(fqName, "fqName");
        m.g(packageFragments, "packageFragments");
        CollectionsKt.addIfNotNull(packageFragments, this.fragments.invoke(fqName));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract DeserializedPackageFragment findPackage(FqName fqName);

    /* JADX INFO: Access modifiers changed from: protected */
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        m.w("components");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        List<PackageFragmentDescriptor> k2;
        m.g(fqName, "fqName");
        k2 = r.k(this.fragments.invoke(fqName));
        return k2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, l<? super Name, Boolean> nameFilter) {
        Set b2;
        m.g(fqName, "fqName");
        m.g(nameFilter, "nameFilter");
        b2 = s0.b();
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setComponents(DeserializationComponents deserializationComponents) {
        m.g(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }
}