package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.e0.c.l;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: StaticScopeForKotlinEnum.kt */
/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final ClassDescriptor containingClass;
    private final NotNullLazyValue functions$delegate;

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor containingClass) {
        kotlin.jvm.internal.m.g(storageManager, "storageManager");
        kotlin.jvm.internal.m.g(containingClass, "containingClass");
        this.containingClass = containingClass;
        containingClass.getKind();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.functions$delegate = storageManager.createLazyValue(new StaticScopeForKotlinEnum$functions$2(this));
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List) StorageKt.getValue(this.functions$delegate, this, $$delegatedProperties[0]);
    }

    public Void getContributedClassifier(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation lookupLocation) {
        return (ClassifierDescriptor) getContributedClassifier(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, l lVar) {
        return getContributedDescriptors(descriptorKindFilter, (l<? super Name, Boolean>) lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<SimpleFunctionDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter) {
        kotlin.jvm.internal.m.g(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.g(nameFilter, "nameFilter");
        return getFunctions();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        List<SimpleFunctionDescriptor> functions = getFunctions();
        SmartList<SimpleFunctionDescriptor> smartList = new SmartList<>();
        for (Object obj : functions) {
            if (kotlin.jvm.internal.m.c(((SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}