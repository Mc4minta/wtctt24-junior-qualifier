package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: KProperty0Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class KMutableProperty0Impl$_setter$1<V> extends o implements a<KMutableProperty0Impl.Setter<V>> {
    final /* synthetic */ KMutableProperty0Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl$_setter$1(KMutableProperty0Impl kMutableProperty0Impl) {
        super(0);
        this.this$0 = kMutableProperty0Impl;
    }

    @Override // kotlin.e0.c.a
    public final KMutableProperty0Impl.Setter<V> invoke() {
        return new KMutableProperty0Impl.Setter<>(this.this$0);
    }
}