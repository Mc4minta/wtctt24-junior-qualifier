package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a0.n;
import kotlin.a0.s0;
import kotlin.a0.w;
import kotlin.e0.c.l;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: JvmPackageScope.kt */
/* loaded from: classes3.dex */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f17395c;
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(LazyJavaResolverContext c2, JavaPackage jPackage, LazyJavaPackageFragment packageFragment) {
        kotlin.jvm.internal.m.g(c2, "c");
        kotlin.jvm.internal.m.g(jPackage, "jPackage");
        kotlin.jvm.internal.m.g(packageFragment, "packageFragment");
        this.f17395c = c2;
        this.packageFragment = packageFragment;
        this.javaScope = new LazyJavaPackageScope(c2, jPackage, packageFragment);
        this.kotlinScopes$delegate = c2.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Iterable r;
        r = n.r(getKotlinScopes());
        Set<Name> flatMapClassifierNamesOrNull = MemberScopeKt.flatMapClassifierNamesOrNull(r);
        if (flatMapClassifierNamesOrNull == null) {
            return null;
        }
        flatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return flatMapClassifierNamesOrNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        recordLookup(name, location);
        ClassDescriptor mo2216getContributedClassifier = this.javaScope.mo2216getContributedClassifier(name, location);
        if (mo2216getContributedClassifier != null) {
            return mo2216getContributedClassifier;
        }
        MemberScope[] kotlinScopes = getKotlinScopes();
        ClassifierDescriptor classifierDescriptor = null;
        int i2 = 0;
        int length = kotlinScopes.length;
        while (i2 < length) {
            MemberScope memberScope = kotlinScopes[i2];
            i2++;
            ClassifierDescriptor mo2216getContributedClassifier2 = memberScope.mo2216getContributedClassifier(name, location);
            if (mo2216getContributedClassifier2 != null) {
                if (!(mo2216getContributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) mo2216getContributedClassifier2).isExpect()) {
                    return mo2216getContributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = mo2216getContributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter) {
        Set b2;
        kotlin.jvm.internal.m.g(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.g(nameFilter, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(kindFilter, nameFilter);
        int length = kotlinScopes.length;
        int i2 = 0;
        while (i2 < length) {
            MemberScope memberScope = kotlinScopes[i2];
            i2++;
            contributedDescriptors = ScopeUtilsKt.concat(contributedDescriptors, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        if (contributedDescriptors == null) {
            b2 = s0.b();
            return b2;
        }
        return contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        Set b2;
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        recordLookup(name, location);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, location);
        int length = kotlinScopes.length;
        int i2 = 0;
        Collection collection = contributedFunctions;
        while (i2 < length) {
            MemberScope memberScope = kotlinScopes[i2];
            i2++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, location));
        }
        if (collection == null) {
            b2 = s0.b();
            return b2;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        Set b2;
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        recordLookup(name, location);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(name, location);
        int length = kotlinScopes.length;
        int i2 = 0;
        Collection collection = contributedVariables;
        while (i2 < length) {
            MemberScope memberScope = kotlinScopes[i2];
            i2++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, location));
        }
        if (collection == null) {
            b2 = s0.b();
            return b2;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : kotlinScopes) {
            w.y(linkedHashSet, memberScope.getFunctionNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return linkedHashSet;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : kotlinScopes) {
            w.y(linkedHashSet, memberScope.getVariableNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        UtilsKt.record(this.f17395c.getComponents().getLookupTracker(), location, this.packageFragment, name);
    }
}