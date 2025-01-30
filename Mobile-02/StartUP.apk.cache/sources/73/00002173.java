package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.walletlink.models.HostRequestId;
import java.net.URL;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/net/URL;", "<anonymous>", "()Ljava/net/URL;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$imageUrl$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<URL> {
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$imageUrl$2(TxSignerViewModel txSignerViewModel) {
        super(0);
        this.this$0 = txSignerViewModel;
    }

    @Override // kotlin.e0.c.a
    public final URL invoke() {
        HostRequestId hostRequestId = this.this$0.getViewState().getHostRequestId();
        if (hostRequestId == null) {
            return null;
        }
        return hostRequestId.getDappImageURL();
    }
}