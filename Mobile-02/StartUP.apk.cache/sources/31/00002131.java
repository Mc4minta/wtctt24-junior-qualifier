package com.coinbase.wallet.features.signer.interfaces;

import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import h.c.m0.n;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StackedRequestItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "R", "Lh/c/s;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lh/c/s;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StackedRequestItem$signatureRequestEvents$2 extends o implements kotlin.e0.c.a<s<SigningSessionEvent>> {
    final /* synthetic */ StackedRequestItem<R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackedRequestItem$signatureRequestEvents$2(StackedRequestItem<R> stackedRequestItem) {
        super(0);
        this.this$0 = stackedRequestItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final SigningSessionEvent m1424invoke$lambda0(StackedRequestItem this$0, Throwable it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return new SigningSessionEvent.Failure(this$0.getUuid(), it);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final s<SigningSessionEvent> invoke() {
        s<SigningSessionEvent> hide = this.this$0.getSignatureRequestEventSubject().hide();
        final StackedRequestItem<R> stackedRequestItem = this.this$0;
        return hide.onErrorReturn(new n() { // from class: com.coinbase.wallet.features.signer.interfaces.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                SigningSessionEvent m1424invoke$lambda0;
                m1424invoke$lambda0 = StackedRequestItem$signatureRequestEvents$2.m1424invoke$lambda0(StackedRequestItem.this, (Throwable) obj);
                return m1424invoke$lambda0;
            }
        });
    }
}