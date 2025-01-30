package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: LazyScopeAdapter.kt */
/* loaded from: classes3.dex */
final class LazyScopeAdapter$lazyScope$1 extends o implements a<MemberScope> {
    final /* synthetic */ a<MemberScope> $getScope;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter$lazyScope$1(a<? extends MemberScope> aVar) {
        super(0);
        this.$getScope = aVar;
    }

    @Override // kotlin.e0.c.a
    public final MemberScope invoke() {
        MemberScope invoke = this.$getScope.invoke();
        return invoke instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) invoke).getActualScope() : invoke;
    }
}