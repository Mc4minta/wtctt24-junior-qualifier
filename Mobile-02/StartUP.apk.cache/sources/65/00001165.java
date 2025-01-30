package com.coinbase.wallet.application;

import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.toshi.view.custom.NetworkStatusView;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "kotlin.jvm.PlatformType", "connectionStatus", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$setupObservers$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConnectionStatus, x> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$setupObservers$4(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(ConnectionStatus connectionStatus) {
        invoke2(connectionStatus);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConnectionStatus connectionStatus) {
        if (connectionStatus instanceof ConnectionStatus.Connected ? true : kotlin.jvm.internal.m.c(connectionStatus, ConnectionStatus.Unknown.INSTANCE)) {
            NetworkStatusView networkStatusView = (NetworkStatusView) this.this$0.findViewById(e.j.a.networkStatusView);
            kotlin.jvm.internal.m.f(networkStatusView, "networkStatusView");
            networkStatusView.setVisibility(8);
        } else if (connectionStatus instanceof ConnectionStatus.Offline) {
            this.this$0.showNetworkUnavailable();
        }
    }
}