package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
/* loaded from: classes3.dex */
public abstract class DelegatingSimpleType extends SimpleType {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    protected abstract SimpleType getDelegate();

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract DelegatingSimpleType replaceDelegate(SimpleType simpleType);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return replaceDelegate((SimpleType) kotlinTypeRefiner.refineType(getDelegate()));
    }
}