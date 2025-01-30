package kotlin.reflect.jvm.internal.impl.types;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends o implements l<KotlinType, x> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(KotlinType kotlinType) {
        invoke2(kotlinType);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(KotlinType it) {
        m.g(it, "it");
        this.this$0.reportSupertypeLoopError(it);
    }
}