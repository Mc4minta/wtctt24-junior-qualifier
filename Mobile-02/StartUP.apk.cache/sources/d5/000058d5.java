package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
/* loaded from: classes3.dex */
public class ErrorType extends SimpleType {
    private final List<TypeProjection> arguments;
    private final TypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final MemberScope memberScope;
    private final String presentableName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorType(TypeConstructor constructor, MemberScope memberScope) {
        this(constructor, memberScope, null, false, null, 28, null);
        m.g(constructor, "constructor");
        m.g(memberScope, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorType(TypeConstructor constructor, MemberScope memberScope, List<? extends TypeProjection> arguments, boolean z) {
        this(constructor, memberScope, arguments, z, null, 16, null);
        m.g(constructor, "constructor");
        m.g(memberScope, "memberScope");
        m.g(arguments, "arguments");
    }

    public /* synthetic */ ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List list, boolean z, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "???" : str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public String getPresentableName() {
        return this.presentableName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAnnotations(Annotations newAnnotations) {
        m.g(newAnnotations, "newAnnotations");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor());
        sb.append(getArguments().isEmpty() ? "" : z.g0(getArguments(), ", ", "<", ">", -1, "...", null));
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return new ErrorType(getConstructor(), getMemberScope(), getArguments(), z, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorType(TypeConstructor constructor, MemberScope memberScope, List<? extends TypeProjection> arguments, boolean z, String presentableName) {
        m.g(constructor, "constructor");
        m.g(memberScope, "memberScope");
        m.g(arguments, "arguments");
        m.g(presentableName, "presentableName");
        this.constructor = constructor;
        this.memberScope = memberScope;
        this.arguments = arguments;
        this.isMarkedNullable = z;
        this.presentableName = presentableName;
    }
}