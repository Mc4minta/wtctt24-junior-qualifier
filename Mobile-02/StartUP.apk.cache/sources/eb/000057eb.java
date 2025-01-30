package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: AbstractScopeAdapter.kt */
/* loaded from: classes3.dex */
public abstract class AbstractScopeAdapter implements MemberScope {
    public final MemberScope getActualScope() {
        if (getWorkerScope() instanceof AbstractScopeAdapter) {
            return ((AbstractScopeAdapter) getWorkerScope()).getActualScope();
        }
        return getWorkerScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getWorkerScope().getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return getWorkerScope().mo2216getContributedClassifier(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter) {
        m.g(kindFilter, "kindFilter");
        m.g(nameFilter, "nameFilter");
        return getWorkerScope().getContributedDescriptors(kindFilter, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return getWorkerScope().getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return getWorkerScope().getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getWorkerScope().getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getWorkerScope().getVariableNames();
    }

    protected abstract MemberScope getWorkerScope();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        getWorkerScope().recordLookup(name, location);
    }
}