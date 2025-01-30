package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.j0.l;
import kotlin.j0.m;
import kotlin.j0.q;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: KParameterImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020&0/¢\u0006\u0004\b1\u00102J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u001c\u0010#\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\tR\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/j0/l;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getAnnotations", "()Ljava/util/List;", "annotations", "isOptional", "()Z", "isVararg", "Lkotlin/j0/l$a;", "kind", "Lkotlin/j0/l$a;", "getKind", "()Lkotlin/j0/l$a;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "getName", ApiConstants.NAME, "index", "I", "getIndex", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "descriptor$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor", "Lkotlin/j0/q;", "getType", "()Lkotlin/j0/q;", "type", "Lkotlin/Function0;", "computeDescriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/j0/l$a;Lkotlin/e0/c/a;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KParameterImpl implements l {
    static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), e0.h(new x(e0.b(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final ReflectProperties.LazySoftVal annotations$delegate;
    private final KCallableImpl<?> callable;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final int index;
    private final l.a kind;

    public KParameterImpl(KCallableImpl<?> callable, int i2, l.a kind, a<? extends ParameterDescriptor> computeDescriptor) {
        kotlin.jvm.internal.m.g(callable, "callable");
        kotlin.jvm.internal.m.g(kind, "kind");
        kotlin.jvm.internal.m.g(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i2;
        this.kind = kind;
        this.descriptor$delegate = ReflectProperties.lazySoft(computeDescriptor);
        this.annotations$delegate = ReflectProperties.lazySoft(new KParameterImpl$annotations$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParameterDescriptor getDescriptor() {
        return (ParameterDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (kotlin.jvm.internal.m.c(this.callable, kParameterImpl.callable) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        return (List) this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override // kotlin.j0.l
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.j0.l
    public l.a getKind() {
        return this.kind;
    }

    @Override // kotlin.j0.l
    public String getName() {
        ParameterDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof ValueParameterDescriptor)) {
            descriptor = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) descriptor;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        kotlin.jvm.internal.m.f(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // kotlin.j0.l
    public q getType() {
        KotlinType type = getDescriptor().getType();
        kotlin.jvm.internal.m.f(type, "descriptor.type");
        return new KTypeImpl(type, new KParameterImpl$type$1(this));
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    @Override // kotlin.j0.l
    public boolean isOptional() {
        ParameterDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof ValueParameterDescriptor)) {
            descriptor = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) descriptor;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.j0.l
    public boolean isVararg() {
        ParameterDescriptor descriptor = getDescriptor();
        return (descriptor instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) descriptor).getVarargElementType() != null;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}