package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.k;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: DescriptorUtils.kt */
/* loaded from: classes3.dex */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME;

    static {
        Name identifier = Name.identifier("value");
        m.f(identifier, "identifier(\"value\")");
        RETENTION_PARAMETER_NAME = identifier;
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor valueParameterDescriptor) {
        List b2;
        m.g(valueParameterDescriptor, "<this>");
        b2 = q.b(valueParameterDescriptor);
        Boolean ifAny = DFS.ifAny(b2, new DFS.Neighbors<ValueParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor2) {
                int r;
                Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor2.getOverriddenDescriptors();
                r = s.r(overriddenDescriptors, 10);
                ArrayList arrayList = new ArrayList(r);
                for (ValueParameterDescriptor valueParameterDescriptor3 : overriddenDescriptors) {
                    arrayList.add(valueParameterDescriptor3.getOriginal());
                }
                return arrayList;
            }
        }, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        m.f(ifAny, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return ifAny.booleanValue();
    }

    public static final ConstantValue<?> firstArgument(AnnotationDescriptor annotationDescriptor) {
        m.g(annotationDescriptor, "<this>");
        return (ConstantValue) p.Z(annotationDescriptor.getAllValueArguments().values());
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor callableMemberDescriptor, final boolean z, final l<? super CallableMemberDescriptor, Boolean> predicate) {
        List b2;
        m.g(callableMemberDescriptor, "<this>");
        m.g(predicate, "predicate");
        final d0 d0Var = new d0();
        b2 = q.b(callableMemberDescriptor);
        return (CallableMemberDescriptor) DFS.dfs(b2, new DFS.Neighbors<CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$firstOverridden$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor2) {
                List g2;
                if (z) {
                    callableMemberDescriptor2 = callableMemberDescriptor2 == null ? null : callableMemberDescriptor2.getOriginal();
                }
                Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor2 != null ? callableMemberDescriptor2.getOverriddenDescriptors() : null;
                if (overriddenDescriptors == null) {
                    g2 = r.g();
                    return g2;
                }
                return overriddenDescriptors;
            }
        }, new DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$firstOverridden$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public void afterChildren(CallableMemberDescriptor current) {
                m.g(current, "current");
                if (d0Var.a == null && predicate.invoke(current).booleanValue()) {
                    d0Var.a = current;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(CallableMemberDescriptor current) {
                m.g(current, "current");
                return d0Var.a == null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public CallableMemberDescriptor result() {
                return d0Var.a;
            }
        });
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return firstOverridden(callableMemberDescriptor, z, lVar);
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor annotationDescriptor) {
        m.g(annotationDescriptor, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = annotationDescriptor.getType().getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo2214getDeclarationDescriptor;
        }
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new ClassId(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(classifierDescriptor.getName());
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        m.f(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        m.f(fqName, "getFqName(this)");
        return fqName;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor moduleDescriptor) {
        m.g(moduleDescriptor, "<this>");
        Ref ref = (Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        KotlinTypeRefiner kotlinTypeRefiner = ref == null ? null : (KotlinTypeRefiner) ref.getValue();
        return kotlinTypeRefiner == null ? KotlinTypeRefiner.Default.INSTANCE : kotlinTypeRefiner;
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        ModuleDescriptor containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        m.f(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    public static final h<DeclarationDescriptor> getParents(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        return k.l(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final h<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        return k.g(declarationDescriptor, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor callableMemberDescriptor) {
        m.g(callableMemberDescriptor, "<this>");
        if (callableMemberDescriptor instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
            m.f(correspondingProperty, "correspondingProperty");
            return correspondingProperty;
        }
        return callableMemberDescriptor;
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor classDescriptor) {
        m.g(classDescriptor, "<this>");
        for (KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().mo2215getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(mo2214getDeclarationDescriptor)) {
                    Objects.requireNonNull(mo2214getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) mo2214getDeclarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor moduleDescriptor) {
        m.g(moduleDescriptor, "<this>");
        Ref ref = (Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        return (ref == null ? null : (KotlinTypeRefiner) ref.getValue()) != null;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor moduleDescriptor, FqName topLevelClassFqName, LookupLocation location) {
        m.g(moduleDescriptor, "<this>");
        m.g(topLevelClassFqName, "topLevelClassFqName");
        m.g(location, "location");
        topLevelClassFqName.isRoot();
        FqName parent = topLevelClassFqName.parent();
        m.f(parent, "topLevelClassFqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = topLevelClassFqName.shortName();
        m.f(shortName, "topLevelClassFqName.shortName()");
        ClassifierDescriptor mo2216getContributedClassifier = memberScope.mo2216getContributedClassifier(shortName, location);
        if (mo2216getContributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) mo2216getContributedClassifier;
        }
        return null;
    }
}