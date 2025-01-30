package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: SubstitutingScope.kt */
/* loaded from: classes3.dex */
public final class SubstitutingScope implements MemberScope {
    private final h _allDescriptors$delegate;
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final TypeSubstitutor substitutor;
    private final MemberScope workerScope;

    public SubstitutingScope(MemberScope workerScope, TypeSubstitutor givenSubstitutor) {
        h b2;
        m.g(workerScope, "workerScope");
        m.g(givenSubstitutor, "givenSubstitutor");
        this.workerScope = workerScope;
        TypeSubstitution substitution = givenSubstitutor.getSubstitution();
        m.f(substitution, "givenSubstitutor.substitution");
        this.substitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        b2 = k.b(new SubstitutingScope$_allDescriptors$2(this));
        this._allDescriptors$delegate = b2;
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D d2) {
        if (this.substitutor.isEmpty()) {
            return d2;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.substitutedDescriptors;
        m.e(map);
        DeclarationDescriptor declarationDescriptor = map.get(d2);
        if (declarationDescriptor == null) {
            if (!(d2 instanceof Substitutable)) {
                throw new IllegalStateException(m.o("Unknown descriptor in scope: ", d2).toString());
            }
            declarationDescriptor = ((Substitutable) d2).substitute(this.substitutor);
            if (declarationDescriptor != null) {
                map.put(d2, declarationDescriptor);
            } else {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d2 + " substitution fails");
            }
        }
        return (D) declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        ClassifierDescriptor mo2216getContributedClassifier = this.workerScope.mo2216getContributedClassifier(name, location);
        if (mo2216getContributedClassifier == null) {
            return null;
        }
        return (ClassifierDescriptor) substitute((SubstitutingScope) mo2216getContributedClassifier);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter) {
        m.g(kindFilter, "kindFilter");
        m.g(nameFilter, "nameFilter");
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return substitute(this.workerScope.getContributedFunctions(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return substitute(this.workerScope.getContributedVariables(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name name, LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> collection) {
        if (this.substitutor.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet newLinkedHashSetWithExpectedSize = CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            newLinkedHashSetWithExpectedSize.add(substitute((SubstitutingScope) ((DeclarationDescriptor) it.next())));
        }
        return newLinkedHashSetWithExpectedSize;
    }
}