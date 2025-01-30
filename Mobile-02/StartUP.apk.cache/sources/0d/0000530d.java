package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;

/* JADX INFO: Add missing generic type declarations: [D, E, V] */
/* compiled from: KProperty2Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0004*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"D", "E", "V", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class KMutableProperty2Impl$_setter$1<D, E, V> extends o implements a<KMutableProperty2Impl.Setter<D, E, V>> {
    final /* synthetic */ KMutableProperty2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl$_setter$1(KMutableProperty2Impl kMutableProperty2Impl) {
        super(0);
        this.this$0 = kMutableProperty2Impl;
    }

    @Override // kotlin.e0.c.a
    public final KMutableProperty2Impl.Setter<D, E, V> invoke() {
        return new KMutableProperty2Impl.Setter<>(this.this$0);
    }
}