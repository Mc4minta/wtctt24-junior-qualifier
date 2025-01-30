package com.coinbase.wallet.bip44wallets.extensions;

import com.coinbase.wallet.http.models.HTTPService;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: HTTPService+BIP44Wallets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPService$Companion;", "Lcom/coinbase/wallet/http/models/HTTPService;", "batchBalance$delegate", "Lkotlin/h;", "getBatchBalance", "(Lcom/coinbase/wallet/http/models/HTTPService$Companion;)Lcom/coinbase/wallet/http/models/HTTPService;", "batchBalance", "bip44wallets_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HTTPService_BIP44WalletsKt {
    private static final h batchBalance$delegate;

    static {
        h b2;
        b2 = k.b(HTTPService_BIP44WalletsKt$batchBalance$2.INSTANCE);
        batchBalance$delegate = b2;
    }

    public static final HTTPService getBatchBalance(HTTPService.Companion companion) {
        m.g(companion, "<this>");
        return (HTTPService) batchBalance$delegate.getValue();
    }
}