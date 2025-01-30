package com.coinbase.wallet.txhistory.views;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.extensions.Blockchain_TxHistoryKt;
import com.coinbase.wallet.txhistory.models.TxHistoryDetail;
import java.net.URL;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxHistoryDetailViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;", "txInfo", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDetailViewModel$didTapViewButton$1 extends o implements l<TxHistoryDetail, x> {
    final /* synthetic */ TxHistoryDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryDetailViewModel$didTapViewButton$1(TxHistoryDetailViewModel txHistoryDetailViewModel) {
        super(1);
        this.this$0 = txHistoryDetailViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(TxHistoryDetail txHistoryDetail) {
        invoke2(txHistoryDetail);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TxHistoryDetail txInfo) {
        Blockchain blockchain;
        h.c.v0.b bVar;
        m.g(txInfo, "txInfo");
        String txHash = txInfo.getTxHash();
        if (txHash == null) {
            return;
        }
        blockchain = this.this$0.blockchain;
        if (blockchain == null) {
            m.w(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
            throw null;
        }
        URL blockExplorerUrl = Blockchain_TxHistoryKt.blockExplorerUrl(blockchain, txHash, txInfo.getNetwork());
        if (blockExplorerUrl == null) {
            return;
        }
        bVar = this.this$0.presentViewSubject;
        bVar.onNext(blockExplorerUrl);
    }
}