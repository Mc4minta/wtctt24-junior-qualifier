package com.coinbase.wallet.features.signer.viewmodel;

import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestEthereumAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/Uri;", "<anonymous>", "()Landroid/net/Uri;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RequestEthereumAccountsViewModel$dappUrl$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Uri> {
    final /* synthetic */ RequestEthereumAccountsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestEthereumAccountsViewModel$dappUrl$2(RequestEthereumAccountsViewModel requestEthereumAccountsViewModel) {
        super(0);
        this.this$0 = requestEthereumAccountsViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final Uri invoke() {
        return this.this$0.getViewState().getHostRequestId().getDappURL();
    }
}