package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 extends o implements a<List<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor this$0;
    final /* synthetic */ AbstractTypeConstructor this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = moduleViewTypeConstructor;
        this.this$1 = abstractTypeConstructor;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends KotlinType> invoke() {
        KotlinTypeRefiner kotlinTypeRefiner;
        kotlinTypeRefiner = this.this$0.kotlinTypeRefiner;
        return KotlinTypeRefinerKt.refineTypes(kotlinTypeRefiner, this.this$1.mo2215getSupertypes());
    }
}