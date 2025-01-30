package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.a0.p;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* loaded from: classes3.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
    final /* synthetic */ ClassDescriptor $annotationClass;
    final /* synthetic */ List<AnnotationDescriptor> $result;
    final /* synthetic */ SourceElement $source;
    private final HashMap<Name, ConstantValue<?>> arguments = new HashMap<>();
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

    public BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(ClassDescriptor classDescriptor, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, List<AnnotationDescriptor> list, SourceElement sourceElement) {
        this.$annotationClass = classDescriptor;
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl;
        this.$result = list;
        this.$source = sourceElement;
    }

    public static final /* synthetic */ ConstantValue access$createConstant(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1, Name name, Object obj) {
        return binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.createConstant(name, obj);
    }

    public static final /* synthetic */ HashMap access$getArguments$p(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1) {
        return binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.arguments;
    }

    public final ConstantValue<?> createConstant(Name name, Object obj) {
        ConstantValue<?> createConstantValue = ConstantValueFactory.INSTANCE.createConstantValue(obj);
        return createConstantValue == null ? ErrorValue.Companion.create(m.o("Unsupported annotation argument: ", name)) : createConstantValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visit(Name name, Object obj) {
        if (name != null) {
            this.arguments.put(name, createConstant(name, obj));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
        m.g(name, "name");
        m.g(classId, "classId");
        ArrayList arrayList = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.this$0;
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        m.f(NO_SOURCE, "NO_SOURCE");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, NO_SOURCE, arrayList);
        m.e(loadAnnotation);
        return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, name, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitAnnotation$1
            private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
            final /* synthetic */ ArrayList<AnnotationDescriptor> $list;
            final /* synthetic */ Name $name;
            final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
                this.$name = name;
                this.$list = arrayList;
                this.$$delegate_0 = KotlinJvmBinaryClass.AnnotationArgumentVisitor.this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visit(Name name2, Object obj) {
                this.$$delegate_0.visit(name2, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name2, ClassId classId2) {
                m.g(name2, "name");
                m.g(classId2, "classId");
                return this.$$delegate_0.visitAnnotation(name2, classId2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name2) {
                m.g(name2, "name");
                return this.$$delegate_0.visitArray(name2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitClassLiteral(Name name2, ClassLiteralValue value) {
                m.g(name2, "name");
                m.g(value, "value");
                this.$$delegate_0.visitClassLiteral(name2, value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                KotlinJvmBinaryClass.AnnotationArgumentVisitor.this.visitEnd();
                BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.access$getArguments$p(this.this$0).put(this.$name, new AnnotationValue((AnnotationDescriptor) p.x0(this.$list)));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnum(Name name2, ClassId enumClassId, Name enumEntryName) {
                m.g(name2, "name");
                m.g(enumClassId, "enumClassId");
                m.g(enumEntryName, "enumEntryName");
                this.$$delegate_0.visitEnum(name2, enumClassId, enumEntryName);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(final Name name) {
        m.g(name, "name");
        final ClassDescriptor classDescriptor = this.$annotationClass;
        return new KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1
            private final ArrayList<ConstantValue<?>> elements = new ArrayList<>();

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visit(Object obj) {
                this.elements.add(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.access$createConstant(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.this, name, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitClassLiteral(ClassLiteralValue value) {
                m.g(value, "value");
                this.elements.add(new KClassValue(value));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnd() {
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, classDescriptor);
                if (annotationParameterByName != null) {
                    HashMap access$getArguments$p = BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.access$getArguments$p(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1.this);
                    Name name2 = name;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<? extends ConstantValue<?>> compact = CollectionsKt.compact(this.elements);
                    KotlinType type = annotationParameterByName.getType();
                    m.f(type, "parameter.type");
                    access$getArguments$p.put(name2, constantValueFactory.createArrayValue(compact, type));
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnum(ClassId enumClassId, Name enumEntryName) {
                m.g(enumClassId, "enumClassId");
                m.g(enumEntryName, "enumEntryName");
                this.elements.add(new EnumValue(enumClassId, enumEntryName));
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitClassLiteral(Name name, ClassLiteralValue value) {
        m.g(name, "name");
        m.g(value, "value");
        this.arguments.put(name, new KClassValue(value));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitEnd() {
        this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), this.arguments, this.$source));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitEnum(Name name, ClassId enumClassId, Name enumEntryName) {
        m.g(name, "name");
        m.g(enumClassId, "enumClassId");
        m.g(enumEntryName, "enumEntryName");
        this.arguments.put(name, new EnumValue(enumClassId, enumEntryName));
    }
}