package com.coinbase.walletlink.apis;

import com.coinbase.walletlink.models.EventType;
import com.coinbase.walletlink.models.Session;
import kotlin.Metadata;

/* compiled from: WalletLinkConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "", "it", "Lh/c/h0;", "kotlin.jvm.PlatformType", "<anonymous>", "(Z)Lh/c/h0;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkConnection$submitWeb3Response$2<T, R> implements h.c.m0.n {
    final /* synthetic */ String $encryptedString;
    final /* synthetic */ Session $session;
    final /* synthetic */ WalletLinkConnection this$0;

    public WalletLinkConnection$submitWeb3Response$2(WalletLinkConnection walletLinkConnection, String str, Session session) {
        this.this$0 = walletLinkConnection;
        this.$encryptedString = str;
        this.$session = session;
    }

    @Override // h.c.m0.n
    public final h.c.h0<? extends Boolean> apply(Boolean it) {
        WalletLinkWebSocket walletLinkWebSocket;
        kotlin.jvm.internal.m.g(it, "it");
        walletLinkWebSocket = this.this$0.socket;
        return walletLinkWebSocket.publishEvent(EventType.Web3Response, this.$encryptedString, this.$session.getId());
    }
}