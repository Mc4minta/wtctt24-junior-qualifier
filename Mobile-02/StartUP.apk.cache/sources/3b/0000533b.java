package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.a;
import kotlin.j0.d;
import kotlin.j0.m;
import kotlin.j0.q;
import kotlin.j0.r;
import kotlin.j0.u;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.k0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: KTypeParameterImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010!\u001a\u00020\r8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R#\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/j0/r;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "toKClassImpl", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "Ljava/lang/Class;", "getContainerClass", "(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;)Ljava/lang/Class;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "Lkotlin/j0/u;", "getVariance", "()Lkotlin/j0/u;", "variance", "getName", ApiConstants.NAME, "isReified", "()Z", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "", "Lkotlin/j0/q;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getUpperBounds", "()Ljava/util/List;", "upperBounds", "<init>", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KTypeParameterImpl implements r, KClassifierImpl {
    static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    private final KTypeParameterOwnerImpl container;
    private final TypeParameterDescriptor descriptor;
    private final ReflectProperties.LazySoftVal upperBounds$delegate;

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

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor descriptor) {
        KClassImpl<?> kClassImpl;
        Object accept;
        kotlin.jvm.internal.m.g(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.upperBounds$delegate = ReflectProperties.lazySoft(new KTypeParameterImpl$upperBounds$2(this));
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            kotlin.jvm.internal.m.f(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                accept = toKClassImpl((ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof CallableMemberDescriptor) {
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                kotlin.jvm.internal.m.f(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = toKClassImpl((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) (!(containingDeclaration instanceof DeserializedMemberDescriptor) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor != null) {
                        d e2 = a.e(getContainerClass(deserializedMemberDescriptor));
                        Objects.requireNonNull(e2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        kClassImpl = (KClassImpl) e2;
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                }
                accept = containingDeclaration.accept(new CreateKCallableVisitor(kClassImpl), kotlin.x.a);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
            }
            kotlin.jvm.internal.m.f(accept, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) accept;
        }
        this.container = kTypeParameterOwnerImpl;
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> klass;
        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        if (!(containerSource instanceof JvmPackagePartSource)) {
            containerSource = null;
        }
        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
        ReflectKotlinClass reflectKotlinClass = knownJvmBinaryClass instanceof ReflectKotlinClass ? knownJvmBinaryClass : null;
        if (reflectKotlinClass == null || (klass = reflectKotlinClass.getKlass()) == null) {
            throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
        }
        return klass;
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor classDescriptor) {
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? a.e(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration());
    }

    public boolean equals(Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            if (kotlin.jvm.internal.m.c(this.container, kTypeParameterImpl.container) && kotlin.jvm.internal.m.c(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.j0.r
    public String getName() {
        String asString = getDescriptor().getName().asString();
        kotlin.jvm.internal.m.f(asString, "descriptor.name.asString()");
        return asString;
    }

    @Override // kotlin.j0.r
    public List<q> getUpperBounds() {
        return (List) this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.j0.r
    public u getVariance() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return u.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return u.IN;
        }
        return u.INVARIANT;
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public boolean isReified() {
        return getDescriptor().isReified();
    }

    public String toString() {
        return k0.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }
}