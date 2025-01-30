package com.coinbase.wallet.ethereum.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EthereumUnsignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b3\u00104R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0004R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\bR\u0016\u0010-\u001a\u00020*8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0004R\u0018\u00102\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0001\u000256¨\u00067"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "Ljava/math/BigInteger;", "getGasLimit", "()Ljava/math/BigInteger;", "gasLimit", "", "getFromAddress", "()Ljava/lang/String;", "fromAddress", "", "getData", "()[B", "data", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "()Lcom/coinbase/wallet/blockchains/models/Network;", "network", "getWeiValue", "weiValue", "", "getWalletIndex", "()I", "walletIndex", "getToAddress", "toAddress", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "getFeeCurrencyCode", "feeCurrencyCode", "getTransferValue", "transferValue", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", "getMetadata", "()Ljava/util/Map;", SendConfirmationArgs.metadataKey, "getRecipientAddress", SendConfirmationArgs.recipientAddressKey, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "getErc20Value", "erc20Value", "getNonce", "()Ljava/lang/Integer;", AdjustableMinerFeeArgs.NONCE, "<init>", "()V", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class EthereumUnsignedTx implements UnsignedTx {
    private EthereumUnsignedTx() {
    }

    public /* synthetic */ EthereumUnsignedTx(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract Blockchain getBlockchain();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract CurrencyCode getCurrencyCode();

    public abstract byte[] getData();

    public abstract BigInteger getErc20Value();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract CurrencyCode getFeeCurrencyCode();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract String getFromAddress();

    public abstract BigInteger getGasLimit();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract Map<TxMetadataKey, Object> getMetadata();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract Network getNetwork();

    public abstract Integer getNonce();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract String getRecipientAddress();

    public abstract String getToAddress();

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public abstract BigInteger getTransferValue();

    public abstract int getWalletIndex();

    public abstract BigInteger getWeiValue();
}