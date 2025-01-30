package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.s0;
import kotlin.a0.w;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k0.h;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.x;

/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    private final JavaClass jClass;
    private final LazyJavaClassDescriptor ownerDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(LazyJavaResolverContext c2, JavaClass jClass, LazyJavaClassDescriptor ownerDescriptor) {
        super(c2);
        m.g(c2, "c");
        m.g(jClass, "jClass");
        m.g(ownerDescriptor, "ownerDescriptor");
        this.jClass = jClass;
        this.ownerDescriptor = ownerDescriptor;
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(final ClassDescriptor classDescriptor, final Set<R> set, final l<? super MemberScope, ? extends Collection<? extends R>> lVar) {
        List b2;
        b2 = q.b(classDescriptor);
        DFS.dfs(b2, new DFS.Neighbors<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: LazyJavaStaticClassScope.kt */
            /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends o implements l<KotlinType, ClassDescriptor> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.e0.c.l
                public final ClassDescriptor invoke(KotlinType kotlinType) {
                    ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
                    if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
                        return (ClassDescriptor) mo2214getDeclarationDescriptor;
                    }
                    return null;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor2) {
                h M;
                h w;
                Iterable<ClassDescriptor> j2;
                Collection<KotlinType> mo2215getSupertypes = classDescriptor2.getTypeConstructor().mo2215getSupertypes();
                m.f(mo2215getSupertypes, "it.typeConstructor.supertypes");
                M = z.M(mo2215getSupertypes);
                w = p.w(M, AnonymousClass1.INSTANCE);
                j2 = p.j(w);
                return j2;
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, x>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public /* bridge */ /* synthetic */ Object result() {
                m2210result();
                return x.a;
            }

            /* renamed from: result  reason: collision with other method in class */
            public void m2210result() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(ClassDescriptor current) {
                m.g(current, "current");
                if (current == ClassDescriptor.this) {
                    return true;
                }
                MemberScope staticScope = current.getStaticScope();
                m.f(staticScope, "current.staticScope");
                if (staticScope instanceof LazyJavaStaticScope) {
                    set.addAll((Collection) lVar.invoke(staticScope));
                    return false;
                }
                return true;
            }
        });
        return set;
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor propertyDescriptor) {
        int r;
        List P;
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        m.f(overriddenDescriptors, "this.overriddenDescriptors");
        r = s.r(overriddenDescriptors, 10);
        ArrayList arrayList = new ArrayList(r);
        for (PropertyDescriptor it : overriddenDescriptors) {
            m.f(it, "it");
            arrayList.add(getRealOriginal(it));
        }
        P = z.P(arrayList);
        return (PropertyDescriptor) kotlin.a0.p.x0(P);
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name name, ClassDescriptor classDescriptor) {
        Set<SimpleFunctionDescriptor> M0;
        Set<SimpleFunctionDescriptor> b2;
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(classDescriptor);
        if (parentJavaStaticClassScope == null) {
            b2 = s0.b();
            return b2;
        }
        M0 = z.M0(parentJavaStaticClassScope.getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        return M0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter kindFilter, l<? super Name, Boolean> lVar) {
        Set<Name> b2;
        m.g(kindFilter, "kindFilter");
        b2 = s0.b();
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeFunctionNames(DescriptorKindFilter kindFilter, l<? super Name, Boolean> lVar) {
        Set<Name> L0;
        List j2;
        m.g(kindFilter, "kindFilter");
        L0 = z.L0(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getMethodNames());
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        Set<Name> functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = s0.b();
        }
        L0.addAll(functionNames);
        if (this.jClass.isEnum()) {
            j2 = r.j(StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES);
            L0.addAll(j2);
        }
        return L0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        m.g(result, "result");
        m.g(name, "name");
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, getStaticFunctionsFromJavaSuperClasses(name, getOwnerDescriptor()), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        m.f(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        result.addAll(resolveOverridesForStaticMembers);
        if (this.jClass.isEnum()) {
            if (m.c(name, StandardNames.ENUM_VALUE_OF)) {
                SimpleFunctionDescriptor createEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
                m.f(createEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
                result.add(createEnumValueOfMethod);
            } else if (m.c(name, StandardNames.ENUM_VALUES)) {
                SimpleFunctionDescriptor createEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
                m.f(createEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
                result.add(createEnumValuesMethod);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> result) {
        m.g(name, "name");
        m.g(result, "result");
        Set flatMapJavaStaticSupertypesScopes = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(name));
        if (!result.isEmpty()) {
            Collection<? extends PropertyDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, flatMapJavaStaticSupertypesScopes, result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            m.f(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            result.addAll(resolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : flatMapJavaStaticSupertypesScopes) {
            PropertyDescriptor realOriginal = getRealOriginal((PropertyDescriptor) obj);
            Object obj2 = linkedHashMap.get(realOriginal);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(realOriginal, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Collection resolveOverridesForStaticMembers2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) entry.getValue(), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            m.f(resolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            w.y(arrayList, resolveOverridesForStaticMembers2);
        }
        result.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter kindFilter, l<? super Name, Boolean> lVar) {
        Set<Name> L0;
        m.g(kindFilter, "kindFilter");
        L0 = z.L0(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), L0, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        return L0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation location) {
        m.g(name, "name");
        m.g(location, "location");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaStaticClassScope$computeMemberIndex$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}