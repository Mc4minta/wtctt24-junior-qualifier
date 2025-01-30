package com.coinbase.wallet.txhistory.extensions;

import com.coinbase.wallet.application.model.Production;
import com.coinbase.wallet.http.models.HTTPService;
import java.net.URL;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: HTTPService+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPService;", "<anonymous>", "()Lcom/coinbase/wallet/http/models/HTTPService;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class HTTPService_TxHistoryKt$txHistory$2 extends o implements a<HTTPService> {
    public static final HTTPService_TxHistoryKt$txHistory$2 INSTANCE = new HTTPService_TxHistoryKt$txHistory$2();

    HTTPService_TxHistoryKt$txHistory$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final HTTPService invoke() {
        return new HTTPService(new URL(Production.walletBlockchain));
    }
}