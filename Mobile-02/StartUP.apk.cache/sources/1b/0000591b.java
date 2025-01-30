package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
/* loaded from: classes3.dex */
public final class UnresolvedType extends ErrorType {
    private final String presentableName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnresolvedType(String presentableName, TypeConstructor constructor, MemberScope memberScope, List<? extends TypeProjection> arguments, boolean z) {
        super(constructor, memberScope, arguments, z, null, 16, null);
        m.g(presentableName, "presentableName");
        m.g(constructor, "constructor");
        m.g(memberScope, "memberScope");
        m.g(arguments, "arguments");
        this.presentableName = presentableName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType
    public String getPresentableName() {
        return this.presentableName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public UnresolvedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return new UnresolvedType(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z);
    }
}