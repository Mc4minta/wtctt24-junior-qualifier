package com.coinbase.wallet.ethereum.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: EthereumUnsigned1559Tx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u0000 b2\u00020\u0001:\u0001bB«\u0001\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010+\u001a\u00020\u000b\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010-\u001a\u00020\u000f\u0012\u0006\u0010.\u001a\u00020\u000b\u0012\u0006\u0010/\u001a\u00020\u000b\u0012\u0006\u00100\u001a\u00020\u000b\u0012\u0006\u00101\u001a\u00020\u000b\u0012\u0006\u00102\u001a\u00020\u0016\u0012\u0006\u00103\u001a\u00020\u0019\u0012\u0006\u00104\u001a\u00020\u001c\u0012\u0006\u00105\u001a\u00020\u000b\u0012\u0006\u00106\u001a\u00020\u0019\u0012\u0006\u00107\u001a\u00020\u0002\u0012\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"¢\u0006\u0004\b`\u0010aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"HÆ\u0003¢\u0006\u0004\b%\u0010&JÖ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010+\u001a\u00020\u000b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020\u00162\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u001c2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00022\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"HÆ\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b;\u0010\u0004J\u0010\u0010<\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b<\u0010\bJ\u001a\u0010?\u001a\u00020>2\b\u0010=\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b?\u0010@R(\u00108\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u0010A\u001a\u0004\bB\u0010&R\u0019\u0010C\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\rR\u001e\u0010'\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010F\u001a\u0004\bG\u0010\u0004R\u001c\u00106\u001a\u00020\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u0010H\u001a\u0004\bI\u0010\u001bR\u001c\u00102\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u0010J\u001a\u0004\bK\u0010\u0018R\u0019\u00100\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010D\u001a\u0004\bL\u0010\rR\u001e\u0010,\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010D\u001a\u0004\bM\u0010\rR\u0019\u0010.\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010D\u001a\u0004\bN\u0010\rR\u001c\u0010+\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010D\u001a\u0004\bO\u0010\rR\u0019\u0010/\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010D\u001a\u0004\bP\u0010\rR\u001c\u00105\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u0010D\u001a\u0004\bQ\u0010\rR\u001c\u00103\u001a\u00020\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u0010H\u001a\u0004\bR\u0010\u001bR\u001c\u00107\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u0010F\u001a\u0004\bS\u0010\u0004R\u001c\u0010T\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bT\u0010D\u001a\u0004\bU\u0010\rR\u001c\u0010)\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010V\u001a\u0004\bW\u0010\bR\u001c\u00101\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u0010D\u001a\u0004\bX\u0010\rR\u001c\u0010-\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010Y\u001a\u0004\bZ\u0010\u0011R\u001c\u00104\u001a\u00020\u001c8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u0010[\u001a\u0004\b\\\u0010\u001eR\u001e\u0010*\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010]\u001a\u0004\b^\u0010\nR\u001c\u0010(\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010F\u001a\u0004\b_\u0010\u0004¨\u0006c"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "()Ljava/lang/Integer;", "Ljava/math/BigInteger;", "component5", "()Ljava/math/BigInteger;", "component6", "", "component7", "()[B", "component8", "component9", "component10", "component11", "Lcom/coinbase/wallet/blockchains/models/Network;", "component12", "()Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component13", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component14", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component15", "component16", "component17", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", "component18", "()Ljava/util/Map;", "toAddress", "fromAddress", "walletIndex", AdjustableMinerFeeArgs.NONCE, "weiValue", "erc20Value", "data", "maxFeePerGas", "baseFeePerGas", "maxPriorityFeePerGas", "gasLimit", "network", AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.BLOCKCHAIN, "transferValue", "feeCurrencyCode", SendConfirmationArgs.recipientAddressKey, SendConfirmationArgs.metadataKey, "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;[BLjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/util/Map;)Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getMetadata", "lowerBoundFee", "Ljava/math/BigInteger;", "getLowerBoundFee", "Ljava/lang/String;", "getToAddress", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getFeeCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "getMaxPriorityFeePerGas", "getErc20Value", "getMaxFeePerGas", "getWeiValue", "getBaseFeePerGas", "getTransferValue", "getCurrencyCode", "getRecipientAddress", "estimatedFee", "getEstimatedFee", "I", "getWalletIndex", "getGasLimit", "[B", "getData", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Ljava/lang/Integer;", "getNonce", "getFromAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;[BLjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/util/Map;)V", "Companion", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumUnsigned1559Tx extends EthereumUnsignedTx {
    public static final Companion Companion = new Companion(null);
    private final BigInteger baseFeePerGas;
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final byte[] data;
    private final BigInteger erc20Value;
    private final BigInteger estimatedFee;
    private final CurrencyCode feeCurrencyCode;
    private final String fromAddress;
    private final BigInteger gasLimit;
    private final BigInteger lowerBoundFee;
    private final BigInteger maxFeePerGas;
    private final BigInteger maxPriorityFeePerGas;
    private final Map<TxMetadataKey, Object> metadata;
    private final Network network;
    private final Integer nonce;
    private final String recipientAddress;
    private final String toAddress;
    private final BigInteger transferValue;
    private final int walletIndex;
    private final BigInteger weiValue;

    /* compiled from: EthereumUnsigned1559Tx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0097\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0089\u0001\u0010 \u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx$Companion;", "", "", "fromAddress", "", "walletIndex", "toAddress", AdjustableMinerFeeArgs.NONCE, "Ljava/math/BigInteger;", "weiValue", "", "data", "maxFeePerGas", "baseFeePerGas", "maxPriorityFeePerGas", "gasLimit", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "feeCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", SendConfirmationArgs.metadataKey, "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "createEtherTx", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/math/BigInteger;[BLjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/util/Map;)Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, SendConfirmationArgs.recipientAddressKey, "erc20Value", "createERC20Tx", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigInteger;[BLjava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EthereumUnsigned1559Tx createERC20Tx(String fromAddress, int i2, String contractAddress, String recipientAddress, Integer num, BigInteger erc20Value, byte[] data, BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, Network network, CurrencyCode currencyCode, CurrencyCode feeCurrencyCode, Blockchain blockchain) {
            m.g(fromAddress, "fromAddress");
            m.g(contractAddress, "contractAddress");
            m.g(recipientAddress, "recipientAddress");
            m.g(erc20Value, "erc20Value");
            m.g(data, "data");
            m.g(maxFeePerGas, "maxFeePerGas");
            m.g(baseFeePerGas, "baseFeePerGas");
            m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
            m.g(gasLimit, "gasLimit");
            m.g(network, "network");
            m.g(currencyCode, "currencyCode");
            m.g(feeCurrencyCode, "feeCurrencyCode");
            m.g(blockchain, "blockchain");
            BigInteger ZERO = BigInteger.ZERO;
            m.f(ZERO, "ZERO");
            return new EthereumUnsigned1559Tx(contractAddress, fromAddress, i2, num, ZERO, erc20Value, data, maxFeePerGas, baseFeePerGas, maxPriorityFeePerGas, gasLimit, network, currencyCode, blockchain, erc20Value, feeCurrencyCode, recipientAddress, null, PKIFailureInfo.unsupportedVersion, null);
        }

        public final EthereumUnsigned1559Tx createEtherTx(String fromAddress, int i2, String str, Integer num, BigInteger weiValue, byte[] data, BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, Network network, CurrencyCode currencyCode, CurrencyCode feeCurrencyCode, Blockchain blockchain, Map<TxMetadataKey, ? extends Object> metadata) {
            m.g(fromAddress, "fromAddress");
            m.g(weiValue, "weiValue");
            m.g(data, "data");
            m.g(maxFeePerGas, "maxFeePerGas");
            m.g(baseFeePerGas, "baseFeePerGas");
            m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
            m.g(gasLimit, "gasLimit");
            m.g(network, "network");
            m.g(currencyCode, "currencyCode");
            m.g(feeCurrencyCode, "feeCurrencyCode");
            m.g(blockchain, "blockchain");
            m.g(metadata, "metadata");
            return new EthereumUnsigned1559Tx(str, fromAddress, i2, num, weiValue, null, data, maxFeePerGas, baseFeePerGas, maxPriorityFeePerGas, gasLimit, network, currencyCode, blockchain, weiValue, feeCurrencyCode, str == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, metadata);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ EthereumUnsigned1559Tx(java.lang.String r21, java.lang.String r22, int r23, java.lang.Integer r24, java.math.BigInteger r25, java.math.BigInteger r26, byte[] r27, java.math.BigInteger r28, java.math.BigInteger r29, java.math.BigInteger r30, java.math.BigInteger r31, com.coinbase.wallet.blockchains.models.Network r32, com.coinbase.wallet.blockchains.models.CurrencyCode r33, com.coinbase.wallet.blockchains.models.Blockchain r34, java.math.BigInteger r35, com.coinbase.wallet.blockchains.models.CurrencyCode r36, java.lang.String r37, java.util.Map r38, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r20 = this;
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r39 & r0
            if (r0 == 0) goto Ld
            java.util.Map r0 = kotlin.a0.j0.i()
            r19 = r0
            goto Lf
        Ld:
            r19 = r38
        Lf:
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r34
            r16 = r35
            r17 = r36
            r18 = r37
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, java.math.BigInteger, java.math.BigInteger, byte[], java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, com.coinbase.wallet.blockchains.models.Network, com.coinbase.wallet.blockchains.models.CurrencyCode, com.coinbase.wallet.blockchains.models.Blockchain, java.math.BigInteger, com.coinbase.wallet.blockchains.models.CurrencyCode, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String component1() {
        return getToAddress();
    }

    public final BigInteger component10() {
        return this.maxPriorityFeePerGas;
    }

    public final BigInteger component11() {
        return getGasLimit();
    }

    public final Network component12() {
        return getNetwork();
    }

    public final CurrencyCode component13() {
        return getCurrencyCode();
    }

    public final Blockchain component14() {
        return getBlockchain();
    }

    public final BigInteger component15() {
        return getTransferValue();
    }

    public final CurrencyCode component16() {
        return getFeeCurrencyCode();
    }

    public final String component17() {
        return getRecipientAddress();
    }

    public final Map<TxMetadataKey, Object> component18() {
        return getMetadata();
    }

    public final String component2() {
        return getFromAddress();
    }

    public final int component3() {
        return getWalletIndex();
    }

    public final Integer component4() {
        return getNonce();
    }

    public final BigInteger component5() {
        return getWeiValue();
    }

    public final BigInteger component6() {
        return getErc20Value();
    }

    public final byte[] component7() {
        return getData();
    }

    public final BigInteger component8() {
        return this.maxFeePerGas;
    }

    public final BigInteger component9() {
        return this.baseFeePerGas;
    }

    public final EthereumUnsigned1559Tx copy(String str, String fromAddress, int i2, Integer num, BigInteger weiValue, BigInteger bigInteger, byte[] data, BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, Network network, CurrencyCode currencyCode, Blockchain blockchain, BigInteger transferValue, CurrencyCode feeCurrencyCode, String recipientAddress, Map<TxMetadataKey, ? extends Object> metadata) {
        m.g(fromAddress, "fromAddress");
        m.g(weiValue, "weiValue");
        m.g(data, "data");
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        m.g(gasLimit, "gasLimit");
        m.g(network, "network");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        m.g(transferValue, "transferValue");
        m.g(feeCurrencyCode, "feeCurrencyCode");
        m.g(recipientAddress, "recipientAddress");
        m.g(metadata, "metadata");
        return new EthereumUnsigned1559Tx(str, fromAddress, i2, num, weiValue, bigInteger, data, maxFeePerGas, baseFeePerGas, maxPriorityFeePerGas, gasLimit, network, currencyCode, blockchain, transferValue, feeCurrencyCode, recipientAddress, metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumUnsigned1559Tx) {
            EthereumUnsigned1559Tx ethereumUnsigned1559Tx = (EthereumUnsigned1559Tx) obj;
            return m.c(getToAddress(), ethereumUnsigned1559Tx.getToAddress()) && m.c(getFromAddress(), ethereumUnsigned1559Tx.getFromAddress()) && getWalletIndex() == ethereumUnsigned1559Tx.getWalletIndex() && m.c(getNonce(), ethereumUnsigned1559Tx.getNonce()) && m.c(getWeiValue(), ethereumUnsigned1559Tx.getWeiValue()) && m.c(getErc20Value(), ethereumUnsigned1559Tx.getErc20Value()) && m.c(getData(), ethereumUnsigned1559Tx.getData()) && m.c(this.maxFeePerGas, ethereumUnsigned1559Tx.maxFeePerGas) && m.c(this.baseFeePerGas, ethereumUnsigned1559Tx.baseFeePerGas) && m.c(this.maxPriorityFeePerGas, ethereumUnsigned1559Tx.maxPriorityFeePerGas) && m.c(getGasLimit(), ethereumUnsigned1559Tx.getGasLimit()) && m.c(getNetwork(), ethereumUnsigned1559Tx.getNetwork()) && m.c(getCurrencyCode(), ethereumUnsigned1559Tx.getCurrencyCode()) && m.c(getBlockchain(), ethereumUnsigned1559Tx.getBlockchain()) && m.c(getTransferValue(), ethereumUnsigned1559Tx.getTransferValue()) && m.c(getFeeCurrencyCode(), ethereumUnsigned1559Tx.getFeeCurrencyCode()) && m.c(getRecipientAddress(), ethereumUnsigned1559Tx.getRecipientAddress()) && m.c(getMetadata(), ethereumUnsigned1559Tx.getMetadata());
        }
        return false;
    }

    public final BigInteger getBaseFeePerGas() {
        return this.baseFeePerGas;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public byte[] getData() {
        return this.data;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public BigInteger getErc20Value() {
        return this.erc20Value;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public BigInteger getEstimatedFee() {
        return this.estimatedFee;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public CurrencyCode getFeeCurrencyCode() {
        return this.feeCurrencyCode;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public String getFromAddress() {
        return this.fromAddress;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public BigInteger getGasLimit() {
        return this.gasLimit;
    }

    public final BigInteger getLowerBoundFee() {
        return this.lowerBoundFee;
    }

    public final BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final BigInteger getMaxPriorityFeePerGas() {
        return this.maxPriorityFeePerGas;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Map<TxMetadataKey, Object> getMetadata() {
        return this.metadata;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Network getNetwork() {
        return this.network;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public Integer getNonce() {
        return this.nonce;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public String getToAddress() {
        return this.toAddress;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx, com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public BigInteger getTransferValue() {
        return this.transferValue;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public int getWalletIndex() {
        return this.walletIndex;
    }

    @Override // com.coinbase.wallet.ethereum.models.EthereumUnsignedTx
    public BigInteger getWeiValue() {
        return this.weiValue;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((getToAddress() == null ? 0 : getToAddress().hashCode()) * 31) + getFromAddress().hashCode()) * 31) + getWalletIndex()) * 31) + (getNonce() == null ? 0 : getNonce().hashCode())) * 31) + getWeiValue().hashCode()) * 31) + (getErc20Value() != null ? getErc20Value().hashCode() : 0)) * 31) + Arrays.hashCode(getData())) * 31) + this.maxFeePerGas.hashCode()) * 31) + this.baseFeePerGas.hashCode()) * 31) + this.maxPriorityFeePerGas.hashCode()) * 31) + getGasLimit().hashCode()) * 31) + getNetwork().hashCode()) * 31) + getCurrencyCode().hashCode()) * 31) + getBlockchain().hashCode()) * 31) + getTransferValue().hashCode()) * 31) + getFeeCurrencyCode().hashCode()) * 31) + getRecipientAddress().hashCode()) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "EthereumUnsigned1559Tx(toAddress=" + ((Object) getToAddress()) + ", fromAddress=" + getFromAddress() + ", walletIndex=" + getWalletIndex() + ", nonce=" + getNonce() + ", weiValue=" + getWeiValue() + ", erc20Value=" + getErc20Value() + ", data=" + Arrays.toString(getData()) + ", maxFeePerGas=" + this.maxFeePerGas + ", baseFeePerGas=" + this.baseFeePerGas + ", maxPriorityFeePerGas=" + this.maxPriorityFeePerGas + ", gasLimit=" + getGasLimit() + ", network=" + getNetwork() + ", currencyCode=" + getCurrencyCode() + ", blockchain=" + getBlockchain() + ", transferValue=" + getTransferValue() + ", feeCurrencyCode=" + getFeeCurrencyCode() + ", recipientAddress=" + getRecipientAddress() + ", metadata=" + getMetadata() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EthereumUnsigned1559Tx(String str, String fromAddress, int i2, Integer num, BigInteger weiValue, BigInteger bigInteger, byte[] data, BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger maxPriorityFeePerGas, BigInteger gasLimit, Network network, CurrencyCode currencyCode, Blockchain blockchain, BigInteger transferValue, CurrencyCode feeCurrencyCode, String recipientAddress, Map<TxMetadataKey, ? extends Object> metadata) {
        super(null);
        m.g(fromAddress, "fromAddress");
        m.g(weiValue, "weiValue");
        m.g(data, "data");
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        m.g(maxPriorityFeePerGas, "maxPriorityFeePerGas");
        m.g(gasLimit, "gasLimit");
        m.g(network, "network");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        m.g(transferValue, "transferValue");
        m.g(feeCurrencyCode, "feeCurrencyCode");
        m.g(recipientAddress, "recipientAddress");
        m.g(metadata, "metadata");
        this.toAddress = str;
        this.fromAddress = fromAddress;
        this.walletIndex = i2;
        this.nonce = num;
        this.weiValue = weiValue;
        this.erc20Value = bigInteger;
        this.data = data;
        this.maxFeePerGas = maxFeePerGas;
        this.baseFeePerGas = baseFeePerGas;
        this.maxPriorityFeePerGas = maxPriorityFeePerGas;
        this.gasLimit = gasLimit;
        this.network = network;
        this.currencyCode = currencyCode;
        this.blockchain = blockchain;
        this.transferValue = transferValue;
        this.feeCurrencyCode = feeCurrencyCode;
        this.recipientAddress = recipientAddress;
        this.metadata = metadata;
        BigInteger multiply = maxFeePerGas.multiply(getGasLimit());
        m.f(multiply, "this.multiply(other)");
        this.estimatedFee = multiply;
        BigInteger add = baseFeePerGas.add(maxPriorityFeePerGas);
        m.f(add, "this.add(other)");
        BigInteger multiply2 = add.multiply(getGasLimit());
        m.f(multiply2, "this.multiply(other)");
        this.lowerBoundFee = multiply2;
    }
}