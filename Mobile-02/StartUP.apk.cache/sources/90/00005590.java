package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
/* loaded from: classes3.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaAnnotations annotations;

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f17400c;
    private final JavaTypeParameter javaTypeParameter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext c2, JavaTypeParameter javaTypeParameter, int i2, DeclarationDescriptor containingDeclaration) {
        super(c2.getStorageManager(), containingDeclaration, javaTypeParameter.getName(), Variance.INVARIANT, false, i2, SourceElement.NO_SOURCE, c2.getComponents().getSupertypeLoopChecker());
        m.g(c2, "c");
        m.g(javaTypeParameter, "javaTypeParameter");
        m.g(containingDeclaration, "containingDeclaration");
        this.f17400c = c2;
        this.javaTypeParameter = javaTypeParameter;
        this.annotations = new LazyJavaAnnotations(c2, javaTypeParameter, false, 4, null);
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        int r;
        List<KotlinType> b2;
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType anyType = this.f17400c.getModule().getBuiltIns().getAnyType();
            m.f(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.f17400c.getModule().getBuiltIns().getNullableAnyType();
            m.f(nullableAnyType, "c.module.builtIns.nullableAnyType");
            b2 = q.b(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
            return b2;
        }
        r = s.r(upperBounds, 10);
        ArrayList arrayList = new ArrayList(r);
        for (JavaClassifierType javaClassifierType : upperBounds) {
            arrayList.add(this.f17400c.getTypeResolver().transformJavaType(javaClassifierType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> bounds) {
        m.g(bounds, "bounds");
        return this.f17400c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, bounds, this.f17400c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* renamed from: reportSupertypeLoopError */
    protected void mo2217reportSupertypeLoopError(KotlinType type) {
        m.g(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public LazyJavaAnnotations getAnnotations() {
        return this.annotations;
    }
}