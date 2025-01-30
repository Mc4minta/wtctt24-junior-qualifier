package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MessageSignerViewModel$reject$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, x> {
    final /* synthetic */ MessageSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSignerViewModel$reject$1(MessageSignerViewModel messageSignerViewModel) {
        super(1);
        this.this$0 = messageSignerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Throwable th) {
        invoke2(th);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable it) {
        h.c.v0.b signatureRequestEventSubject;
        kotlin.jvm.internal.m.g(it, "it");
        signatureRequestEventSubject = this.this$0.getSignatureRequestEventSubject();
        signatureRequestEventSubject.onNext(new SigningSessionEvent.Cancelled(this.this$0.getViewState().getUuid()));
    }
}