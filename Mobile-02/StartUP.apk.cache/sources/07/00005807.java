package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: TypeIntersectionScope.kt */
/* loaded from: classes3.dex */
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion Companion = new Companion(null);
    private final String debugName;
    private final MemberScope workerScope;

    /* compiled from: TypeIntersectionScope.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope create(String message, Collection<? extends KotlinType> types) {
            int r;
            m.g(message, "message");
            m.g(types, "types");
            r = s.r(types, 10);
            ArrayList arrayList = new ArrayList(r);
            for (KotlinType kotlinType : types) {
                arrayList.add(kotlinType.getMemberScope());
            }
            SmartList<MemberScope> listOfNonEmptyScopes = ScopeUtilsKt.listOfNonEmptyScopes(arrayList);
            MemberScope createOrSingle$descriptors = ChainedMemberScope.Companion.createOrSingle$descriptors(message, listOfNonEmptyScopes);
            return listOfNonEmptyScopes.size() <= 1 ? createOrSingle$descriptors : new TypeIntersectionScope(message, createOrSingle$descriptors, null);
        }
    }

    private TypeIntersectionScope(String str, MemberScope memberScope) {
        this.debugName = str;
        this.workerScope = memberScope;
    }

    public /* synthetic */ TypeIntersectionScope(String str, MemberScope memberScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScope);
    }

    public static final MemberScope create(String str, Collection<? extends KotlinType> collection) {
        return Companion.create(str, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter) {
        List t0;
        m.g(kindFilter, "kindFilter");
        m.g(nameFilter, "nameFilter");
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((DeclarationDescriptor) obj) instanceof CallableDescriptor) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        o oVar = new o(arrayList, arrayList2);
        t0 = z.t0(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup((List) oVar.a(), TypeIntersectionScope$getContributedDescriptors$2.INSTANCE), (List) oVar.b());
        return t0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, location), TypeIntersectionScope$getContributedFunctions$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, location), TypeIntersectionScope$getContributedVariables$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.workerScope;
    }
}