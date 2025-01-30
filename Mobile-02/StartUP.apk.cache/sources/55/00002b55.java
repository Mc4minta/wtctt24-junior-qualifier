package com.coinbase.walletlink.apis;

import com.coinbase.walletlink.models.HostRequest;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/walletlink/models/HostRequest;", "kotlin.jvm.PlatformType", "requests", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkConnection$fetchPendingRequests$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends HostRequest>, kotlin.x> {
    final /* synthetic */ WalletLinkConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkConnection$fetchPendingRequests$3(WalletLinkConnection walletLinkConnection) {
        super(1);
        this.this$0 = walletLinkConnection;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends HostRequest> list) {
        invoke2(list);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends HostRequest> requests) {
        h.c.v0.b bVar;
        kotlin.jvm.internal.m.f(requests, "requests");
        WalletLinkConnection walletLinkConnection = this.this$0;
        for (HostRequest hostRequest : requests) {
            bVar = walletLinkConnection.requestsSubject;
            bVar.onNext(hostRequest);
        }
    }
}