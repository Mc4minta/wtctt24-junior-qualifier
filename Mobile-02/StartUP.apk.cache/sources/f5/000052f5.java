package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KClassImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KClassImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e \u0004*\u000e\u0018\u00010\u0002R\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002R\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$data$1 extends o implements a<KClassImpl<T>.Data> {
    final /* synthetic */ KClassImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$data$1(KClassImpl kClassImpl) {
        super(0);
        this.this$0 = kClassImpl;
    }

    @Override // kotlin.e0.c.a
    public final KClassImpl<T>.Data invoke() {
        return new KClassImpl.Data();
    }
}