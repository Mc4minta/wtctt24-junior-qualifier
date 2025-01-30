package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.s0;
import kotlin.e0.c.a;
import kotlin.j0.m;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), e0.h(new x(e0.b(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), e0.h(new x(e0.b(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    private final NotNullLazyValue cloneableType$delegate;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes3.dex */
    public enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static JDKMemberStatus[] valuesCustom() {
            JDKMemberStatus[] valuesCustom = values();
            JDKMemberStatus[] jDKMemberStatusArr = new JDKMemberStatus[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, jDKMemberStatusArr, 0, valuesCustom.length);
            return jDKMemberStatusArr;
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.valuesCustom().length];
            iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
            iArr[JDKMemberStatus.DROP.ordinal()] = 3;
            iArr[JDKMemberStatus.VISIBLE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor moduleDescriptor, StorageManager storageManager, a<JvmBuiltIns.Settings> settingsComputation) {
        kotlin.jvm.internal.m.g(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.m.g(storageManager, "storageManager");
        kotlin.jvm.internal.m.g(settingsComputation, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = storageManager.createLazyValue(settingsComputation);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, storageManager));
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(DescriptorVisibilities.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        kotlin.jvm.internal.m.e(build);
        return build;
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager storageManager) {
        List b2;
        Set<ClassConstructorDescriptor> b3;
        PackageFragmentDescriptorImpl packageFragmentDescriptorImpl = new PackageFragmentDescriptorImpl(this.moduleDescriptor, new FqName("java.io")) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
        };
        b2 = q.b(new LazyWrappedType(storageManager, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this)));
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(packageFragmentDescriptorImpl, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, b2, SourceElement.NO_SOURCE, false, storageManager);
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        b3 = s0.b();
        classDescriptorImpl.initialize(empty, b3, null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        kotlin.jvm.internal.m.f(defaultType, "mockSerializableClass.defaultType");
        return defaultType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e7, code lost:
        if (isMutabilityViolation(r3, r10) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getAdditionalFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10, kotlin.e0.c.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> r11) {
        /*
            r9 = this;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r0 = r9.getJavaAnalogue(r10)
            if (r0 != 0) goto Lb
            java.util.List r10 = kotlin.a0.p.g()
            return r10
        Lb:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r1 = r9.j2kClassMapper
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns$Companion r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Companion
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r3 = r3.getInstance()
            java.util.Collection r1 = r1.mapPlatformClass(r2, r3)
            java.lang.Object r2 = kotlin.a0.p.k0(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            if (r2 != 0) goto L28
            java.util.List r10 = kotlin.a0.p.g()
            return r10
        L28:
            kotlin.reflect.jvm.internal.impl.utils.SmartSet$Companion r3 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.a0.p.r(r1, r5)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r5)
            r4.add(r5)
            goto L39
        L4d:
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r1 = r3.create(r4)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r3 = r9.j2kClassMapper
            boolean r10 = r3.isMutable(r10)
            kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r3 = r9.javaAnalogueClassesWithCustomSupertypeCache
            kotlin.reflect.jvm.internal.impl.name.FqName r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 r5 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1
            r5.<init>(r0, r2)
            java.lang.Object r0 = r3.computeIfAbsent(r4, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getUnsubstitutedMemberScope()
            java.lang.String r2 = "fakeJavaClassDescriptor.unsubstitutedMemberScope"
            kotlin.jvm.internal.m.f(r0, r2)
            java.lang.Object r11 = r11.invoke(r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L80:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto Lef
            java.lang.Object r2 = r11.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r5 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L99
        L97:
            r6 = r7
            goto Le9
        L99:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = r3.getVisibility()
            boolean r4 = r4.isPublicAPI()
            if (r4 != 0) goto La4
            goto L97
        La4:
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDeprecated(r3)
            if (r4 == 0) goto Lab
            goto L97
        Lab:
            java.util.Collection r4 = r3.getOverriddenDescriptors()
            java.lang.String r5 = "analogueMember.overriddenDescriptors"
            kotlin.jvm.internal.m.f(r4, r5)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto Lbc
        Lba:
            r4 = r7
            goto Le0
        Lbc:
            java.util.Iterator r4 = r4.iterator()
        Lc0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lba
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            java.lang.String r8 = "it.containingDeclaration"
            kotlin.jvm.internal.m.f(r5, r8)
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r5)
            boolean r5 = r1.contains(r5)
            if (r5 == 0) goto Lc0
            r4 = r6
        Le0:
            if (r4 == 0) goto Le3
            goto L97
        Le3:
            boolean r3 = r9.isMutabilityViolation(r3, r10)
            if (r3 != 0) goto L97
        Le9:
            if (r6 == 0) goto L80
            r0.add(r2)
            goto L80
        Lef:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getAdditionalFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.e0.c.l):java.util.Collection");
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[1]);
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor constructorDescriptor, TypeSubstitutor typeSubstitutor, ConstructorDescriptor constructorDescriptor2) {
        return OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor classDescriptor) {
        if (!KotlinBuiltIns.isAny(classDescriptor) && KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
            if (fqNameUnsafe.isSafe()) {
                ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe);
                FqName asSingleFqName = mapKotlinToJava == null ? null : mapKotlinToJava.asSingleFqName();
                if (asSingleFqName == null) {
                    return null;
                }
                ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), asSingleFqName, NoLookupLocation.FROM_BUILTINS);
                if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
                    return (LazyJavaClassDescriptor) resolveClassByFqName;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor functionDescriptor) {
        List b2;
        final String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
        final d0 d0Var = new d0();
        b2 = q.b((ClassDescriptor) functionDescriptor.getContainingDeclaration());
        Object dfs = DFS.dfs(b2, new DFS.Neighbors<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
                Collection<KotlinType> mo2215getSupertypes = classDescriptor.getTypeConstructor().mo2215getSupertypes();
                kotlin.jvm.internal.m.f(mo2215getSupertypes, "it.typeConstructor.supertypes");
                JvmBuiltInsCustomizer jvmBuiltInsCustomizer = JvmBuiltInsCustomizer.this;
                ArrayList arrayList = new ArrayList();
                for (KotlinType kotlinType : mo2215getSupertypes) {
                    ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
                    ClassifierDescriptor original = mo2214getDeclarationDescriptor == null ? null : mo2214getDeclarationDescriptor.getOriginal();
                    ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
                    LazyJavaClassDescriptor javaAnalogue = classDescriptor2 != null ? jvmBuiltInsCustomizer.getJavaAnalogue(classDescriptor2) : null;
                    if (javaAnalogue != null) {
                        arrayList.add(javaAnalogue);
                    }
                }
                return arrayList;
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$2
            /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(ClassDescriptor javaClassDescriptor) {
                kotlin.jvm.internal.m.g(javaClassDescriptor, "javaClassDescriptor");
                String signature = MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaClassDescriptor, computeJvmDescriptor$default);
                JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
                if (jvmBuiltInsSignatures.getHIDDEN_METHOD_SIGNATURES().contains(signature)) {
                    d0Var.a = JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN;
                } else if (jvmBuiltInsSignatures.getVISIBLE_METHOD_SIGNATURES().contains(signature)) {
                    d0Var.a = JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE;
                } else if (jvmBuiltInsSignatures.getDROP_LIST_METHOD_SIGNATURES().contains(signature)) {
                    d0Var.a = JvmBuiltInsCustomizer.JDKMemberStatus.DROP;
                }
                return d0Var.a == null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public JvmBuiltInsCustomizer.JDKMemberStatus result() {
                JvmBuiltInsCustomizer.JDKMemberStatus jDKMemberStatus = d0Var.a;
                return jDKMemberStatus == null ? JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
            }
        });
        kotlin.jvm.internal.m.f(dfs, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
        return (JDKMemberStatus) dfs;
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        List b2;
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        if (z ^ JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) simpleFunctionDescriptor.getContainingDeclaration(), computeJvmDescriptor$default))) {
            return true;
        }
        b2 = q.b(simpleFunctionDescriptor);
        Boolean ifAny = DFS.ifAny(b2, new DFS.Neighbors<CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$isMutabilityViolation$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
            }
        }, new JvmBuiltInsCustomizer$isMutabilityViolation$2(this));
        kotlin.jvm.internal.m.f(ifAny, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
        return ifAny.booleanValue();
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            kotlin.jvm.internal.m.f(valueParameters, "valueParameters");
            ClassifierDescriptor mo2214getDeclarationDescriptor = ((ValueParameterDescriptor) p.x0(valueParameters)).getType().getConstructor().mo2214getDeclarationDescriptor();
            if (kotlin.jvm.internal.m.c(mo2214getDeclarationDescriptor == null ? null : DescriptorUtilsKt.getFqNameUnsafe(mo2214getDeclarationDescriptor), DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        List g2;
        int r;
        boolean z;
        List g3;
        List g4;
        kotlin.jvm.internal.m.g(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() == ClassKind.CLASS && getSettings().isAdditionalBuiltInsFeatureSupported()) {
            LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
            if (javaAnalogue == null) {
                g4 = r.g();
                return g4;
            }
            ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
            if (mapJavaToKotlin$default == null) {
                g3 = r.g();
                return g3;
            }
            TypeSubstitutor buildSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution(mapJavaToKotlin$default, javaAnalogue).buildSubstitutor();
            List<ClassConstructorDescriptor> constructors = javaAnalogue.getConstructors();
            ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
            Iterator<T> it = constructors.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) next;
                if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                    Collection<ClassConstructorDescriptor> constructors2 = mapJavaToKotlin$default.getConstructors();
                    kotlin.jvm.internal.m.f(constructors2, "defaultKotlinVersion.constructors");
                    if (!constructors2.isEmpty()) {
                        for (ClassConstructorDescriptor it2 : constructors2) {
                            kotlin.jvm.internal.m.f(it2, "it");
                            if (getConstructors$isEffectivelyTheSameAs(it2, buildSubstitutor, classConstructorDescriptor)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z && !isTrivialCopyConstructorFor(classConstructorDescriptor, classDescriptor) && !KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogue, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, null)))) {
                        z2 = true;
                    }
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            r = s.r(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (ClassConstructorDescriptor classConstructorDescriptor2 : arrayList) {
                FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor2.newCopyBuilder();
                newCopyBuilder.setOwner(classDescriptor);
                newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                newCopyBuilder.setPreserveSourceElement();
                newCopyBuilder.setSubstitution(buildSubstitutor.getSubstitution());
                if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogue, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor2, false, false, 3, null)))) {
                    newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
                }
                FunctionDescriptor build = newCopyBuilder.build();
                Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((ClassConstructorDescriptor) build);
            }
            return arrayList2;
        }
        g2 = r.g();
        return g2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f7, code lost:
        if (r2 != 3) goto L44;
     */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name r7, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        List g2;
        List b2;
        List j2;
        kotlin.jvm.internal.m.g(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
        if (jvmBuiltInsSignatures.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            SimpleType cloneableType = getCloneableType();
            kotlin.jvm.internal.m.f(cloneableType, "cloneableType");
            j2 = r.j(cloneableType, this.mockSerializableType);
            return j2;
        } else if (jvmBuiltInsSignatures.isSerializableInJava(fqNameUnsafe)) {
            b2 = q.b(this.mockSerializableType);
            return b2;
        } else {
            g2 = r.g();
            return g2;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.m.g(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.m.g(functionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue != null && functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            if (getSettings().isAdditionalBuiltInsFeatureSupported()) {
                String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
                LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
                Name name = functionDescriptor.getName();
                kotlin.jvm.internal.m.f(name, "functionDescriptor.name");
                Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
                if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
                    for (SimpleFunctionDescriptor simpleFunctionDescriptor : contributedFunctions) {
                        if (kotlin.jvm.internal.m.c(MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null), computeJvmDescriptor$default)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
        Set<Name> b2;
        LazyJavaClassMemberScope unsubstitutedMemberScope;
        Set<Name> b3;
        kotlin.jvm.internal.m.g(classDescriptor, "classDescriptor");
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            b3 = s0.b();
            return b3;
        }
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        Set<Name> set = null;
        if (javaAnalogue != null && (unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope()) != null) {
            set = unsubstitutedMemberScope.getFunctionNames();
        }
        if (set == null) {
            b2 = s0.b();
            return b2;
        }
        return set;
    }
}