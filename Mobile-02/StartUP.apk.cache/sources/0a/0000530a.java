package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;

/* JADX INFO: Add missing generic type declarations: [T, V] */
/* compiled from: KProperty1Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "V", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class KMutableProperty1Impl$_setter$1<T, V> extends o implements a<KMutableProperty1Impl.Setter<T, V>> {
    final /* synthetic */ KMutableProperty1Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl$_setter$1(KMutableProperty1Impl kMutableProperty1Impl) {
        super(0);
        this.this$0 = kMutableProperty1Impl;
    }

    @Override // kotlin.e0.c.a
    public final KMutableProperty1Impl.Setter<T, V> invoke() {
        return new KMutableProperty1Impl.Setter<>(this.this$0);
    }
}