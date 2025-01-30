package com.coinbase.wallet.blockchains.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: UnsignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\bR\u0016\u0010\u001e\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0016\u0010 \u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "()Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadata", "()Ljava/util/Map;", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "getTransferValue", "()Ljava/math/BigInteger;", "transferValue", "", "getFromAddress", "()Ljava/lang/String;", "fromAddress", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "getFeeCurrencyCode", "feeCurrencyCode", "getEstimatedFee", "estimatedFee", "getRecipientAddress", SendConfirmationArgs.recipientAddressKey, "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface UnsignedTx {
    Blockchain getBlockchain();

    CurrencyCode getCurrencyCode();

    BigInteger getEstimatedFee();

    CurrencyCode getFeeCurrencyCode();

    String getFromAddress();

    Map<TxMetadataKey, Object> getMetadata();

    Network getNetwork();

    String getRecipientAddress();

    BigInteger getTransferValue();
}