package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPropertyImpl$Setter$caller$2 extends o implements a<Caller<?>> {
    final /* synthetic */ KPropertyImpl.Setter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$Setter$caller$2(KPropertyImpl.Setter setter) {
        super(0);
        this.this$0 = setter;
    }

    @Override // kotlin.e0.c.a
    public final Caller<?> invoke() {
        return KPropertyImplKt.access$computeCallerForAccessor(this.this$0, false);
    }
}