package com.coinbase.wallet.routing.models;

import android.os.Bundle;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: SendArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JQ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/routing/models/SendArgs;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "", "recipient", SendArgs.METADATA_VALUE, "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", SendArgs.STELLAR_MEMO_TYPE, "Lkotlin/o;", "Ljava/lang/Class;", "viewModelKey", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Lkotlin/o;)Landroid/os/Bundle;", "METADATA_VALUE", "Ljava/lang/String;", "RECIPIENT", "WALLET", "STELLAR_MEMO_TYPE", "<init>", "()V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SendArgs {
    public static final SendArgs INSTANCE = new SendArgs();
    public static final String METADATA_VALUE = "metadataValue";
    public static final String RECIPIENT = "recipient";
    public static final String STELLAR_MEMO_TYPE = "stellarMemoType";
    public static final String WALLET = "wallet";

    private SendArgs() {
    }

    public final Bundle createArguments(Wallet wallet, String str, String str2, TxMetadataKey txMetadataKey, o<String, ? extends Class<?>> viewModelKey) {
        m.g(wallet, "wallet");
        m.g(viewModelKey, "viewModelKey");
        Bundle bundle = new Bundle();
        bundle.putParcelable("wallet", wallet);
        bundle.putString("recipient", str);
        bundle.putString(METADATA_VALUE, str2);
        bundle.putParcelable(STELLAR_MEMO_TYPE, txMetadataKey);
        bundle.putSerializable(viewModelKey.c(), viewModelKey.d());
        return bundle;
    }
}