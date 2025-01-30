package kotlin.reflect.jvm.internal.impl.types;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpecialTypes.kt */
/* loaded from: classes3.dex */
public final class LazyWrappedType$refine$1 extends o implements a<KotlinType> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    final /* synthetic */ LazyWrappedType this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyWrappedType$refine$1(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
        super(0);
        this.$kotlinTypeRefiner = kotlinTypeRefiner;
        this.this$0 = lazyWrappedType;
    }

    @Override // kotlin.e0.c.a
    public final KotlinType invoke() {
        a aVar;
        KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
        aVar = this.this$0.computation;
        return kotlinTypeRefiner.refineType((KotlinType) aVar.invoke());
    }
}