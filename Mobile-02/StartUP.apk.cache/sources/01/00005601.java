package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    private final KotlinClassFinder kotlinClassFinder;
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, Storage<A, C>> storage;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: classes3.dex */
    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PropertyRelatedElement[] valuesCustom() {
            PropertyRelatedElement[] valuesCustom = values();
            PropertyRelatedElement[] propertyRelatedElementArr = new PropertyRelatedElement[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, propertyRelatedElementArr, 0, valuesCustom.length);
            return propertyRelatedElementArr;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: classes3.dex */
    public static final class Storage<A, C> {
        private final Map<MemberSignature, List<A>> memberAnnotations;
        private final Map<MemberSignature, C> propertyConstants;

        /* JADX WARN: Multi-variable type inference failed */
        public Storage(Map<MemberSignature, ? extends List<? extends A>> memberAnnotations, Map<MemberSignature, ? extends C> propertyConstants) {
            m.g(memberAnnotations, "memberAnnotations");
            m.g(propertyConstants, "propertyConstants");
            this.memberAnnotations = memberAnnotations;
            this.propertyConstants = propertyConstants;
        }

        public final Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        m.g(storageManager, "storageManager");
        m.g(kotlinClassFinder, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder;
        this.storage = storageManager.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    public static final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor access$loadAnnotationIfNotSpecial(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ClassId classId, SourceElement sourceElement, List list) {
        return abstractBinaryClassAnnotationAndConstantLoader.loadAnnotationIfNotSpecial(classId, sourceElement, list);
    }

    private final int computeJvmParameterIndexShift(ProtoContainer protoContainer, MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf.Function) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Property) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Constructor) {
            ProtoContainer.Class r4 = (ProtoContainer.Class) protoContainer;
            if (r4.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (r4.isInner()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException(m.o("Unsupported message: ", messageLite.getClass()));
        }
        return 0;
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3) {
        List<A> g2;
        List<A> g3;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, z, z2, bool, z3));
        if (findClassWithAnnotationsAndInitializers == null) {
            g3 = r.g();
            return g3;
        }
        List<A> list = this.storage.invoke(findClassWithAnnotationsAndInitializers).getMemberAnnotations().get(memberSignature);
        if (list == null) {
            g2 = r.g();
            return g2;
        }
        return list;
    }

    static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer protoContainer, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        if (protoContainer instanceof ProtoContainer.Class) {
            return toBinaryClass((ProtoContainer.Class) protoContainer);
        }
        return null;
    }

    private final MemberSignature getCallableSignature(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        if (messageLite instanceof ProtoBuf.Constructor) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        } else if (messageLite instanceof ProtoBuf.Function) {
            MemberSignature.Companion companion2 = MemberSignature.Companion;
            JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        } else if (messageLite instanceof ProtoBuf.Property) {
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
            m.f(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) messageLite, propertySignature);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i2 == 1) {
                if (jvmPropertySignature.hasGetter()) {
                    MemberSignature.Companion companion3 = MemberSignature.Companion;
                    JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                    m.f(getter, "signature.getter");
                    return companion3.fromMethod(nameResolver, getter);
                }
                return null;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return getPropertySignature((ProtoBuf.Property) messageLite, nameResolver, typeTable, true, true, z);
            } else if (jvmPropertySignature.hasSetter()) {
                MemberSignature.Companion companion4 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                m.f(setter, "signature.setter");
                return companion4.fromMethod(nameResolver, setter);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 16) != 0) {
                z = false;
            }
            return abstractBinaryClassAnnotationAndConstantLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final MemberSignature getPropertySignature(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3) {
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        m.f(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            JvmMemberSignature.Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(property, nameResolver, typeTable, z3);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
        } else if (z2 && jvmPropertySignature.hasSyntheticMethod()) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
            m.f(syntheticMethod, "signature.syntheticMethod");
            return companion.fromMethod(nameResolver, syntheticMethod);
        } else {
            return null;
        }
    }

    static /* synthetic */ MemberSignature getPropertySignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.getPropertySignature(property, nameResolver, typeTable, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer protoContainer, boolean z, boolean z2, Boolean bool, boolean z3) {
        ProtoContainer.Class outerClass;
        String J;
        if (z) {
            if (bool != null) {
                if (protoContainer instanceof ProtoContainer.Class) {
                    ProtoContainer.Class r8 = (ProtoContainer.Class) protoContainer;
                    if (r8.getKind() == ProtoBuf.Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder = this.kotlinClassFinder;
                        ClassId createNestedClassId = r8.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                        m.f(createNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, createNestedClassId);
                    }
                }
                if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.Package)) {
                    SourceElement source = protoContainer.getSource();
                    JvmPackagePartSource jvmPackagePartSource = source instanceof JvmPackagePartSource ? (JvmPackagePartSource) source : null;
                    JvmClassName facadeClassName = jvmPackagePartSource == null ? null : jvmPackagePartSource.getFacadeClassName();
                    if (facadeClassName != null) {
                        KotlinClassFinder kotlinClassFinder2 = this.kotlinClassFinder;
                        String internalName = facadeClassName.getInternalName();
                        m.f(internalName, "facadeClassName.internalName");
                        J = x.J(internalName, '/', '.', false, 4, null);
                        ClassId classId = ClassId.topLevel(new FqName(J));
                        m.f(classId, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder2, classId);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
        }
        if (z2 && (protoContainer instanceof ProtoContainer.Class)) {
            ProtoContainer.Class r82 = (ProtoContainer.Class) protoContainer;
            if (r82.getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = r82.getOuterClass()) != null && (outerClass.getKind() == ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS || (z3 && (outerClass.getKind() == ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return toBinaryClass(outerClass);
            }
        }
        if ((protoContainer instanceof ProtoContainer.Package) && (protoContainer.getSource() instanceof JvmPackagePartSource)) {
            SourceElement source2 = protoContainer.getSource();
            Objects.requireNonNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
            KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
            return knownJvmBinaryClass == null ? KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, jvmPackagePartSource2.getClassId()) : knownJvmBinaryClass;
        }
        return null;
    }

    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId classId, SourceElement sourceElement, List<A> list) {
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(classId)) {
            return null;
        }
        return loadAnnotation(classId, sourceElement, list);
    }

    public final Storage<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new KotlinJvmBinaryClass.MemberVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
            /* loaded from: classes3.dex */
            public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnnotationVisitorForMethod(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0, MemberSignature signature) {
                    super(this$0, signature);
                    m.g(this$0, "this$0");
                    m.g(signature, "signature");
                    this.this$0 = this$0;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i2, ClassId classId, SourceElement source) {
                    m.g(classId, "classId");
                    m.g(source, "source");
                    MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i2);
                    List list = (List) hashMap.get(fromMethodSignatureAndParameterIndex);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(fromMethodSignatureAndParameterIndex, list);
                    }
                    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, classId, source, list);
                }
            }

            /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
            /* loaded from: classes3.dex */
            public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
                private final ArrayList<A> result;
                private final MemberSignature signature;
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

                public MemberAnnotationVisitor(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0, MemberSignature signature) {
                    m.g(this$0, "this$0");
                    m.g(signature, "signature");
                    this.this$0 = this$0;
                    this.signature = signature;
                    this.result = new ArrayList<>();
                }

                protected final MemberSignature getSignature() {
                    return this.signature;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement source) {
                    m.g(classId, "classId");
                    m.g(source, "source");
                    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, classId, source, this.result);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                    if (!this.result.isEmpty()) {
                        hashMap.put(this.signature, this.result);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public KotlinJvmBinaryClass.AnnotationVisitor visitField(Name name, String desc, Object obj) {
                Object loadConstant;
                m.g(name, "name");
                m.g(desc, "desc");
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                m.f(asString, "name.asString()");
                MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, desc);
                if (obj != null && (loadConstant = this.this$0.loadConstant(desc, obj)) != null) {
                    hashMap2.put(fromFieldNameAndDesc, loadConstant);
                }
                return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(Name name, String desc) {
                m.g(name, "name");
                m.g(desc, "desc");
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                m.f(asString, "name.asString()");
                return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, desc));
            }
        }, getCachedFileContent(kotlinJvmBinaryClass));
        return new Storage<>(hashMap, hashMap2);
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property, PropertyRelatedElement propertyRelatedElement) {
        boolean V;
        List<A> g2;
        List<A> g3;
        List<A> g4;
        Boolean bool = Flags.IS_CONST.get(property.getFlags());
        m.f(bool, "IS_CONST.get(proto.flags)");
        boolean booleanValue = bool.booleanValue();
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            MemberSignature propertySignature$default = getPropertySignature$default(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            if (propertySignature$default == null) {
                g4 = r.g();
                return g4;
            }
            return findClassAndLoadMemberAnnotations$default(this, protoContainer, propertySignature$default, true, false, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature propertySignature$default2 = getPropertySignature$default(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (propertySignature$default2 == null) {
            g3 = r.g();
            return g3;
        }
        V = y.V(propertySignature$default2.getSignature(), "$delegate", false, 2, null);
        if (V != (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD)) {
            g2 = r.g();
            return g2;
        }
        return findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion);
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r3) {
        SourceElement source = r3.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.getBinaryClass();
    }

    protected byte[] getCachedFileContent(KotlinJvmBinaryClass kotlinClass) {
        m.g(kotlinClass, "kotlinClass");
        return null;
    }

    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId classId, SourceElement sourceElement, List<A> list);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadCallableAnnotations(ProtoContainer container, MessageLite proto, AnnotatedCallableKind kind) {
        List<A> g2;
        m.g(container, "container");
        m.g(proto, "proto");
        m.g(kind, "kind");
        if (kind == AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(container, (ProtoBuf.Property) proto, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature callableSignature$default = getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default == null) {
            g2 = r.g();
            return g2;
        }
        return findClassAndLoadMemberAnnotations$default(this, container, callableSignature$default, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class container) {
        m.g(container, "container");
        KotlinJvmBinaryClass binaryClass = toBinaryClass(container);
        if (binaryClass != null) {
            final ArrayList arrayList = new ArrayList(1);
            binaryClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement source) {
                    m.g(classId, "classId");
                    m.g(source, "source");
                    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0, classId, source, arrayList);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                }
            }, getCachedFileContent(binaryClass));
            return arrayList;
        }
        throw new IllegalStateException(m.o("Class for loading annotations is not found: ", container.debugFqName()).toString());
    }

    public abstract C loadConstant(String str, Object obj);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer container, ProtoBuf.EnumEntry proto) {
        m.g(container, "container");
        m.g(proto, "proto");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String string = container.getNameResolver().getString(proto.getName());
        ClassMapperLite classMapperLite = ClassMapperLite.INSTANCE;
        String asString = ((ProtoContainer.Class) container).getClassId().asString();
        m.f(asString, "container as ProtoContainer.Class).classId.asString()");
        return findClassAndLoadMemberAnnotations$default(this, container, companion.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(asString)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer container, MessageLite proto, AnnotatedCallableKind kind) {
        List<A> g2;
        m.g(container, "container");
        m.g(proto, "proto");
        m.g(kind, "kind");
        MemberSignature callableSignature$default = getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, container, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, 0), false, false, null, false, 60, null);
        }
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer container, ProtoBuf.Property proto) {
        m.g(container, "container");
        m.g(proto, "proto");
        return loadPropertyAnnotations(container, proto, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer container, ProtoBuf.Property proto, KotlinType expectedType) {
        C c2;
        m.g(container, "container");
        m.g(proto, "proto");
        m.g(expectedType, "expectedType");
        Boolean bool = Flags.IS_CONST.get(proto.getFlags());
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(container, getSpecialCaseContainerClass(container, true, true, bool, JvmProtoBufUtil.isMovedFromInterfaceCompanion(proto)));
        if (findClassWithAnnotationsAndInitializers == null) {
            return null;
        }
        MemberSignature callableSignature = getCallableSignature(proto, container.getNameResolver(), container.getTypeTable(), AnnotatedCallableKind.PROPERTY, findClassWithAnnotationsAndInitializers.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (callableSignature == null || (c2 = this.storage.invoke(findClassWithAnnotationsAndInitializers).getPropertyConstants().get(callableSignature)) == null) {
            return null;
        }
        UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
        return UnsignedTypes.isUnsignedType(expectedType) ? transformToUnsignedConstant(c2) : c2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer container, ProtoBuf.Property proto) {
        m.g(container, "container");
        m.g(proto, "proto");
        return loadPropertyAnnotations(container, proto, PropertyRelatedElement.DELEGATE_FIELD);
    }

    protected abstract A loadTypeAnnotation(ProtoBuf.Annotation annotation, NameResolver nameResolver);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type proto, NameResolver nameResolver) {
        int r;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.typeAnnotation);
        m.f(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        r = s.r(iterable, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation it : iterable) {
            m.f(it, "it");
            arrayList.add(loadTypeAnnotation(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter proto, NameResolver nameResolver) {
        int r;
        m.g(proto, "proto");
        m.g(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.typeParameterAnnotation);
        m.f(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        r = s.r(iterable, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation it : iterable) {
            m.f(it, "it");
            arrayList.add(loadTypeAnnotation(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer container, MessageLite callableProto, AnnotatedCallableKind kind, int i2, ProtoBuf.ValueParameter proto) {
        List<A> g2;
        m.g(container, "container");
        m.g(callableProto, "callableProto");
        m.g(kind, "kind");
        m.g(proto, "proto");
        MemberSignature callableSignature$default = getCallableSignature$default(this, callableProto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, container, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, i2 + computeJvmParameterIndexShift(container, callableProto)), false, false, null, false, 60, null);
        }
        g2 = r.g();
        return g2;
    }

    protected abstract C transformToUnsignedConstant(C c2);
}