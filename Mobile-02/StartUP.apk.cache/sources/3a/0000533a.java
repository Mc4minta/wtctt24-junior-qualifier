package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.j0.e;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KTypeImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/j0/e;", "invoke", "()Lkotlin/j0/e;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$classifier$2 extends o implements a<e> {
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$classifier$2(KTypeImpl kTypeImpl) {
        super(0);
        this.this$0 = kTypeImpl;
    }

    @Override // kotlin.e0.c.a
    public final e invoke() {
        e convert;
        KTypeImpl kTypeImpl = this.this$0;
        convert = kTypeImpl.convert(kTypeImpl.getType());
        return convert;
    }
}