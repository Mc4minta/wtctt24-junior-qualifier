package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.models.ConsumerAmountPickerViewState;
import kotlin.Metadata;

/* compiled from: ConsumerAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lh/c/s;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel$stateObservable$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<ConsumerAmountPickerViewState>> {
    final /* synthetic */ ConsumerAmountPickerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerViewModel$stateObservable$2(ConsumerAmountPickerViewModel consumerAmountPickerViewModel) {
        super(0);
        this.this$0 = consumerAmountPickerViewModel;
    }

    public static /* synthetic */ void a(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, h.c.k0.b bVar) {
        m978invoke$lambda0(consumerAmountPickerViewModel, bVar);
    }

    public static /* synthetic */ void b(ConsumerAmountPickerViewModel consumerAmountPickerViewModel) {
        m979invoke$lambda1(consumerAmountPickerViewModel);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m978invoke$lambda0(ConsumerAmountPickerViewModel this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.observeAmountUpdates();
    }

    /* renamed from: invoke$lambda-1 */
    public static final void m979invoke$lambda1(ConsumerAmountPickerViewModel this$0) {
        h.c.k0.a aVar;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        aVar = this$0.amountUpdateDisposable;
        aVar.d();
    }

    @Override // kotlin.e0.c.a
    public final h.c.s<ConsumerAmountPickerViewState> invoke() {
        h.c.v0.b bVar;
        bVar = this.this$0.stateSubject;
        h.c.s<T> hide = bVar.hide();
        final ConsumerAmountPickerViewModel consumerAmountPickerViewModel = this.this$0;
        h.c.s doOnSubscribe = hide.doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.a0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerAmountPickerViewModel$stateObservable$2.a(ConsumerAmountPickerViewModel.this, (h.c.k0.b) obj);
            }
        });
        final ConsumerAmountPickerViewModel consumerAmountPickerViewModel2 = this.this$0;
        return doOnSubscribe.doOnDispose(new h.c.m0.a() { // from class: com.coinbase.wallet.consumer.viewmodels.b0
            @Override // h.c.m0.a
            public final void run() {
                ConsumerAmountPickerViewModel$stateObservable$2.b(ConsumerAmountPickerViewModel.this);
            }
        });
    }
}