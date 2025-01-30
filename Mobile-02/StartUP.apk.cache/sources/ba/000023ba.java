package com.coinbase.wallet.http.connectivity;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Internet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "kotlin.jvm.PlatformType", "connectionStatus", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Internet$startMonitoring$3 extends o implements l<ConnectionStatus, x> {
    public static final Internet$startMonitoring$3 INSTANCE = new Internet$startMonitoring$3();

    Internet$startMonitoring$3() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(ConnectionStatus connectionStatus) {
        invoke2(connectionStatus);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConnectionStatus connectionStatus) {
        h.c.v0.a aVar;
        Internet internet = Internet.INSTANCE;
        m.f(connectionStatus, "connectionStatus");
        Internet.status = connectionStatus;
        aVar = Internet.changes;
        aVar.onNext(connectionStatus);
    }
}