package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* compiled from: StubType.kt */
/* loaded from: classes3.dex */
public final class StubType extends AbstractStubType implements StubTypeMarker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StubType(TypeConstructor originalTypeVariable, boolean z, TypeConstructor constructor, MemberScope memberScope) {
        super(originalTypeVariable, z, constructor, memberScope);
        m.g(originalTypeVariable, "originalTypeVariable");
        m.g(constructor, "constructor");
        m.g(memberScope, "memberScope");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType
    public AbstractStubType materialize(boolean z) {
        return new StubType(getOriginalTypeVariable(), z, getConstructor(), getMemberScope());
    }
}