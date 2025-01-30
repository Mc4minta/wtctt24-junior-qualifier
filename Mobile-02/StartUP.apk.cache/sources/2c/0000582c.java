package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragment.kt */
/* loaded from: classes3.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final StorageManager storageManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragment(FqName fqName, StorageManager storageManager, ModuleDescriptor module) {
        super(module, fqName);
        m.g(fqName, "fqName");
        m.g(storageManager, "storageManager");
        m.g(module, "module");
        this.storageManager = storageManager;
    }

    public abstract ClassDataFinder getClassDataFinder();

    public boolean hasTopLevelClass(Name name) {
        m.g(name, "name");
        MemberScope memberScope = getMemberScope();
        return (memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).getClassNames$deserialization().contains(name);
    }

    public abstract void initialize(DeserializationComponents deserializationComponents);
}