package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.e0.c.a;
import kotlin.j0.b0.b;
import kotlin.j0.e;
import kotlin.j0.m;
import kotlin.j0.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: KTypeImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020 \u0018\u000101¢\u0006\u0004\b2\u00103J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001f\u0010(\u001a\u0004\u0018\u00010\u00048V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R#\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u00168V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010\u0019R$\u0010.\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010-8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b.\u0010%\u0012\u0004\b/\u00100¨\u00064"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/n;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", "Lkotlin/j0/e;", "convert", "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/j0/e;", "", "nullable", "makeNullableAsSpecified$kotlin_reflection", "(Z)Lkotlin/reflect/jvm/internal/KTypeImpl;", "makeNullableAsSpecified", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "isMarkedNullable", "()Z", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Ljava/lang/reflect/Type;", "getJavaType", "()Ljava/lang/reflect/Type;", "javaType", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getClassifier", "()Lkotlin/j0/e;", "classifier", "Lkotlin/j0/s;", "arguments$delegate", "getArguments", "arguments", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "computeJavaType", "getComputeJavaType$annotations", "()V", "Lkotlin/Function0;", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/e0/c/a;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl implements n {
    static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), e0.h(new x(e0.b(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    private final ReflectProperties.LazySoftVal arguments$delegate;
    private final ReflectProperties.LazySoftVal classifier$delegate;
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    private final KotlinType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.valuesCustom().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
        }
    }

    public KTypeImpl(KotlinType type, a<? extends Type> aVar) {
        kotlin.jvm.internal.m.g(type, "type");
        this.type = type;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal2 = (ReflectProperties.LazySoftVal) (!(aVar instanceof ReflectProperties.LazySoftVal) ? null : aVar);
        if (lazySoftVal2 != null) {
            lazySoftVal = lazySoftVal2;
        } else if (aVar != null) {
            lazySoftVal = ReflectProperties.lazySoft(aVar);
        }
        this.computeJavaType = lazySoftVal;
        this.classifier$delegate = ReflectProperties.lazySoft(new KTypeImpl$classifier$2(this));
        this.arguments$delegate = ReflectProperties.lazySoft(new KTypeImpl$arguments$2(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e convert(KotlinType kotlinType) {
        KotlinType type;
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo2214getDeclarationDescriptor);
            if (javaClass != null) {
                if (javaClass.isArray()) {
                    TypeProjection typeProjection = (TypeProjection) p.z0(kotlinType.getArguments());
                    if (typeProjection != null && (type = typeProjection.getType()) != null) {
                        kotlin.jvm.internal.m.f(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
                        e convert = convert(type);
                        if (convert != null) {
                            return new KClassImpl(ReflectClassUtilKt.createArrayType(kotlin.e0.a.b(b.a(convert))));
                        }
                        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                    }
                    return new KClassImpl(javaClass);
                } else if (!TypeUtils.isNullableType(kotlinType)) {
                    Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                    if (primitiveByWrapper != null) {
                        javaClass = primitiveByWrapper;
                    }
                    return new KClassImpl(javaClass);
                } else {
                    return new KClassImpl(javaClass);
                }
            }
            return null;
        } else if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) mo2214getDeclarationDescriptor);
        } else {
            if (mo2214getDeclarationDescriptor instanceof TypeAliasDescriptor) {
                throw new kotlin.n("An operation is not implemented: Type alias classifiers are not yet supported");
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof KTypeImpl) && kotlin.jvm.internal.m.c(this.type, ((KTypeImpl) obj).type);
    }

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    @Override // kotlin.j0.q
    public List<s> getArguments() {
        return (List) this.arguments$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override // kotlin.j0.q
    public e getClassifier() {
        return (e) this.classifier$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.jvm.internal.n
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    public final KotlinType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    @Override // kotlin.j0.q
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    public final KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean z) {
        if (FlexibleTypesKt.isFlexible(this.type) || isMarkedNullable() != z) {
            KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.type, z);
            kotlin.jvm.internal.m.f(makeNullableAsSpecified, "TypeUtils.makeNullableAsSpecified(type, nullable)");
            return new KTypeImpl(makeNullableAsSpecified, this.computeJavaType);
        }
        return this;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, a aVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i2 & 2) != 0 ? null : aVar);
    }
}