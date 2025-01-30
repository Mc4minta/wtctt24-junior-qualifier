package kotlin.reflect.jvm.internal.impl.types;

import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: classes3.dex */
public final class StarProjectionImpl extends TypeProjectionBase {
    private final h _type$delegate;
    private final TypeParameterDescriptor typeParameter;

    public StarProjectionImpl(TypeParameterDescriptor typeParameter) {
        h a;
        m.g(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
        a = k.a(kotlin.m.PUBLICATION, new StarProjectionImpl$_type$2(this));
        this._type$delegate = a;
    }

    private final KotlinType get_type() {
        return (KotlinType) this._type$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        return get_type();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}