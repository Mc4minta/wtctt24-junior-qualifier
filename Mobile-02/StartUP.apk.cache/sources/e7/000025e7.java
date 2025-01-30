package com.coinbase.wallet.routing.models;

import android.os.Bundle;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SendDestinationPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/routing/models/SendDestinationPickerArgs;", "", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "transferValue", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "", "address", SendArgs.METADATA_VALUE, "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", SendArgs.STELLAR_MEMO_TYPE, "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/TransferValue;Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;)Landroid/os/Bundle;", "ADDRESS", "Ljava/lang/String;", "SEND_AMOUNT", "WALLET", "METADATA_VALUE", "STELLAR_MEMO_TYPE", "<init>", "()V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SendDestinationPickerArgs {
    public static final String ADDRESS = "Address";
    public static final SendDestinationPickerArgs INSTANCE = new SendDestinationPickerArgs();
    public static final String METADATA_VALUE = "MetadataValue";
    public static final String SEND_AMOUNT = "SendAmount";
    public static final String STELLAR_MEMO_TYPE = "StellarMemoType";
    public static final String WALLET = "Wallet";

    private SendDestinationPickerArgs() {
    }

    public final Bundle createArguments(TransferValue transferValue, Wallet wallet, String str, String str2, TxMetadataKey txMetadataKey) {
        m.g(transferValue, "transferValue");
        m.g(wallet, "wallet");
        Bundle bundle = new Bundle();
        bundle.putParcelable(SEND_AMOUNT, transferValue);
        bundle.putParcelable(WALLET, wallet);
        bundle.putString(ADDRESS, str);
        bundle.putString(METADATA_VALUE, str2);
        bundle.putParcelable(STELLAR_MEMO_TYPE, txMetadataKey);
        return bundle;
    }
}