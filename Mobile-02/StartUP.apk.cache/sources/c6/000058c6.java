package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends o implements l<TypeConstructor, Iterable<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // kotlin.e0.c.l
    public final Iterable<KotlinType> invoke(TypeConstructor it) {
        Collection computeNeighbours;
        m.g(it, "it");
        computeNeighbours = this.this$0.computeNeighbours(it, false);
        return computeNeighbours;
    }
}