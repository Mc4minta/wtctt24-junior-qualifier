package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.a0.t0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
final class LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1 extends o implements a<Set<? extends Name>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final Set<? extends Name> invoke() {
        Set<? extends Name> h2;
        h2 = t0.h(this.this$0.getFunctionNames(), this.this$0.getVariableNames());
        return h2;
    }
}