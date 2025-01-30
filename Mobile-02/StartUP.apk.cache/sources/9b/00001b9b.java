package com.coinbase.wallet.dogecoin.extensions;

import com.coinbase.wallet.blockchains.models.NetworkSetting;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: NetworkSetting+Dogecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSetting$Companion;", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "DOGE$delegate", "Lkotlin/h;", "getDOGE", "(Lcom/coinbase/wallet/blockchains/models/NetworkSetting$Companion;)Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "DOGE", "dogecoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NetworkSetting_DogecoinKt {
    private static final h DOGE$delegate;

    static {
        h b2;
        b2 = k.b(NetworkSetting_DogecoinKt$DOGE$2.INSTANCE);
        DOGE$delegate = b2;
    }

    public static final NetworkSetting getDOGE(NetworkSetting.Companion companion) {
        m.g(companion, "<this>");
        return (NetworkSetting) DOGE$delegate.getValue();
    }
}