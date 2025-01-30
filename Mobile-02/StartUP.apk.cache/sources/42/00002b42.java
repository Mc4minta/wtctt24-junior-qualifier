package com.coinbase.walletlink;

import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.apis.WalletLinkConnection;
import com.coinbase.walletlink.models.Session;
import com.coinbase.walletlink.repositories.LinkRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", WalletLinkPushNotification.sessionIdKey, "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLink$observeConnection$6 extends o implements l<String, x> {
    final /* synthetic */ WalletLinkConnection $conn;
    final /* synthetic */ WalletLink this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLink$observeConnection$6(WalletLink walletLink, WalletLinkConnection walletLinkConnection) {
        super(1);
        this.this$0 = walletLink;
        this.$conn = walletLinkConnection;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(String str) {
        invoke2(str);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String sessionId) {
        LinkRepository linkRepository;
        LinkRepository linkRepository2;
        m.g(sessionId, "sessionId");
        linkRepository = this.this$0.linkRepository;
        linkRepository.delete(this.$conn.getUrl(), sessionId);
        List<Session> sessions = this.this$0.sessions();
        WalletLink walletLink = this.this$0;
        for (Session session : sessions) {
            if (m.c(sessionId, session.getParentSessionId())) {
                linkRepository2 = walletLink.linkRepository;
                linkRepository2.delete(session.getUrl(), session.getId());
            }
        }
    }
}