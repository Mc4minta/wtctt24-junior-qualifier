package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.a0.n;
import kotlin.a0.r;
import kotlin.a0.s0;
import kotlin.a0.w;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: ChainedMemberScope.kt */
/* loaded from: classes3.dex */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = new Companion(null);
    private final String debugName;
    private final MemberScope[] scopes;

    /* compiled from: ChainedMemberScope.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope create(String debugName, Iterable<? extends MemberScope> scopes) {
            m.g(debugName, "debugName");
            m.g(scopes, "scopes");
            SmartList smartList = new SmartList();
            for (MemberScope memberScope : scopes) {
                if (memberScope != MemberScope.Empty.INSTANCE) {
                    if (memberScope instanceof ChainedMemberScope) {
                        w.z(smartList, ((ChainedMemberScope) memberScope).scopes);
                    } else {
                        smartList.add(memberScope);
                    }
                }
            }
            return createOrSingle$descriptors(debugName, smartList);
        }

        public final MemberScope createOrSingle$descriptors(String debugName, List<? extends MemberScope> scopes) {
            m.g(debugName, "debugName");
            m.g(scopes, "scopes");
            int size = scopes.size();
            if (size != 0) {
                if (size != 1) {
                    Object[] array = scopes.toArray(new MemberScope[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return new ChainedMemberScope(debugName, (MemberScope[]) array, null);
                }
                return scopes.get(0);
            }
            return MemberScope.Empty.INSTANCE;
        }
    }

    private ChainedMemberScope(String str, MemberScope[] memberScopeArr) {
        this.debugName = str;
        this.scopes = memberScopeArr;
    }

    public /* synthetic */ ChainedMemberScope(String str, MemberScope[] memberScopeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScopeArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Iterable r;
        r = n.r(this.scopes);
        return MemberScopeKt.flatMapClassifierNamesOrNull(r);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i2 = 0;
        while (i2 < length) {
            MemberScope memberScope = memberScopeArr[i2];
            i2++;
            ClassifierDescriptor mo2216getContributedClassifier = memberScope.mo2216getContributedClassifier(name, location);
            if (mo2216getContributedClassifier != null) {
                if (!(mo2216getContributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) mo2216getContributedClassifier).isExpect()) {
                    return mo2216getContributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = mo2216getContributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter) {
        List g2;
        Set b2;
        m.g(kindFilter, "kindFilter");
        m.g(nameFilter, "nameFilter");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        }
        int i2 = 0;
        if (length != 1) {
            Collection<DeclarationDescriptor> collection = null;
            int length2 = memberScopeArr.length;
            while (i2 < length2) {
                MemberScope memberScope = memberScopeArr[i2];
                i2++;
                collection = ScopeUtilsKt.concat(collection, memberScope.getContributedDescriptors(kindFilter, nameFilter));
            }
            if (collection == null) {
                b2 = s0.b();
                return b2;
            }
            return collection;
        }
        return memberScopeArr[0].getContributedDescriptors(kindFilter, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        List g2;
        Set b2;
        m.g(name, "name");
        m.g(location, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        }
        int i2 = 0;
        if (length != 1) {
            Collection<SimpleFunctionDescriptor> collection = null;
            int length2 = memberScopeArr.length;
            while (i2 < length2) {
                MemberScope memberScope = memberScopeArr[i2];
                i2++;
                collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, location));
            }
            if (collection == null) {
                b2 = s0.b();
                return b2;
            }
            return collection;
        }
        return memberScopeArr[0].getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        List g2;
        Set b2;
        m.g(name, "name");
        m.g(location, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        }
        int i2 = 0;
        if (length != 1) {
            Collection<PropertyDescriptor> collection = null;
            int length2 = memberScopeArr.length;
            while (i2 < length2) {
                MemberScope memberScope = memberScopeArr[i2];
                i2++;
                collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, location));
            }
            if (collection == null) {
                b2 = s0.b();
                return b2;
            }
            return collection;
        }
        return memberScopeArr[0].getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            w.y(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            w.y(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        for (MemberScope memberScope : this.scopes) {
            memberScope.recordLookup(name, location);
        }
    }

    public String toString() {
        return this.debugName;
    }
}