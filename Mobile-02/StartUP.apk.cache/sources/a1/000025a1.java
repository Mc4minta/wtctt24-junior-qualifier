package com.coinbase.wallet.ripple.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.ripple.extensions.CurrencyCode_RippleKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: XRPUnsignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0016\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JT\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0016\u001a\u00020\u000eHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0004R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001e0%8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010+\u001a\u00020*8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b/\u0010\u0004R$\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b1\u0010\fR\u001c\u0010\u0013\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u00102\u001a\u0004\b3\u0010\bR\u001c\u0010\u0016\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\b5\u0010\u0010R\u001c\u00106\u001a\u00020*8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R\u001c\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u00102\u001a\u0004\b8\u0010\bR\u001c\u0010:\u001a\u0002098\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/ripple/models/XRPUnsignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "component4", "Lkotlin/UInt;", "component5-0hXNFcg", "()Lkotlin/UInt;", "component5", "Lcom/coinbase/wallet/blockchains/models/Network;", "component6", "()Lcom/coinbase/wallet/blockchains/models/Network;", "fromAddress", SendConfirmationArgs.recipientAddressKey, "transferValue", "estimatedFee", "destinationTag", "network", "copy-xKlDIQ0", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Lkotlin/UInt;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/ripple/models/XRPUnsignedTx;", "copy", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFromAddress", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadata", "()Ljava/util/Map;", SendConfirmationArgs.metadataKey, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getRecipientAddress", "Lkotlin/UInt;", "getDestinationTag-0hXNFcg", "Ljava/math/BigInteger;", "getTransferValue", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "feeCurrencyCode", "getFeeCurrencyCode", "getEstimatedFee", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Lkotlin/UInt;Lcom/coinbase/wallet/blockchains/models/Network;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPUnsignedTx implements UnsignedTx {
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final UInt destinationTag;
    private final BigInteger estimatedFee;
    private final CurrencyCode feeCurrencyCode;
    private final String fromAddress;
    private final Network network;
    private final String recipientAddress;
    private final BigInteger transferValue;

    private XRPUnsignedTx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, UInt uInt, Network network) {
        this.fromAddress = str;
        this.recipientAddress = str2;
        this.transferValue = bigInteger;
        this.estimatedFee = bigInteger2;
        this.destinationTag = uInt;
        this.network = network;
        CurrencyCode.Companion companion = CurrencyCode.Companion;
        this.currencyCode = CurrencyCode_RippleKt.getXRP(companion);
        this.feeCurrencyCode = CurrencyCode_RippleKt.getXRP(companion);
        this.blockchain = Blockchain_RippleKt.getXRP(Blockchain.Companion);
    }

    public /* synthetic */ XRPUnsignedTx(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, UInt uInt, Network network, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bigInteger, bigInteger2, uInt, network);
    }

    /* renamed from: copy-xKlDIQ0$default  reason: not valid java name */
    public static /* synthetic */ XRPUnsignedTx m1657copyxKlDIQ0$default(XRPUnsignedTx xRPUnsignedTx, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, UInt uInt, Network network, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = xRPUnsignedTx.getFromAddress();
        }
        if ((i2 & 2) != 0) {
            str2 = xRPUnsignedTx.getRecipientAddress();
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            bigInteger = xRPUnsignedTx.getTransferValue();
        }
        BigInteger bigInteger3 = bigInteger;
        if ((i2 & 8) != 0) {
            bigInteger2 = xRPUnsignedTx.getEstimatedFee();
        }
        BigInteger bigInteger4 = bigInteger2;
        if ((i2 & 16) != 0) {
            uInt = xRPUnsignedTx.destinationTag;
        }
        UInt uInt2 = uInt;
        if ((i2 & 32) != 0) {
            network = xRPUnsignedTx.getNetwork();
        }
        return xRPUnsignedTx.m1659copyxKlDIQ0(str, str3, bigInteger3, bigInteger4, uInt2, network);
    }

    public final String component1() {
        return getFromAddress();
    }

    public final String component2() {
        return getRecipientAddress();
    }

    public final BigInteger component3() {
        return getTransferValue();
    }

    public final BigInteger component4() {
        return getEstimatedFee();
    }

    /* renamed from: component5-0hXNFcg  reason: not valid java name */
    public final UInt m1658component50hXNFcg() {
        return this.destinationTag;
    }

    public final Network component6() {
        return getNetwork();
    }

    /* renamed from: copy-xKlDIQ0  reason: not valid java name */
    public final XRPUnsignedTx m1659copyxKlDIQ0(String fromAddress, String recipientAddress, BigInteger transferValue, BigInteger estimatedFee, UInt uInt, Network network) {
        m.g(fromAddress, "fromAddress");
        m.g(recipientAddress, "recipientAddress");
        m.g(transferValue, "transferValue");
        m.g(estimatedFee, "estimatedFee");
        m.g(network, "network");
        return new XRPUnsignedTx(fromAddress, recipientAddress, transferValue, estimatedFee, uInt, network, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XRPUnsignedTx) {
            XRPUnsignedTx xRPUnsignedTx = (XRPUnsignedTx) obj;
            return m.c(getFromAddress(), xRPUnsignedTx.getFromAddress()) && m.c(getRecipientAddress(), xRPUnsignedTx.getRecipientAddress()) && m.c(getTransferValue(), xRPUnsignedTx.getTransferValue()) && m.c(getEstimatedFee(), xRPUnsignedTx.getEstimatedFee()) && m.c(this.destinationTag, xRPUnsignedTx.destinationTag) && m.c(getNetwork(), xRPUnsignedTx.getNetwork());
        }
        return false;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    /* renamed from: getDestinationTag-0hXNFcg  reason: not valid java name */
    public final UInt m1660getDestinationTag0hXNFcg() {
        return this.destinationTag;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public BigInteger getEstimatedFee() {
        return this.estimatedFee;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public CurrencyCode getFeeCurrencyCode() {
        return this.feeCurrencyCode;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public String getFromAddress() {
        return this.fromAddress;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Map<TxMetadataKey, Object> getMetadata() {
        Map<TxMetadataKey, Object> e2;
        Map<TxMetadataKey, Object> i2;
        if (m1660getDestinationTag0hXNFcg() == null) {
            i2 = m0.i();
            return i2;
        }
        e2 = l0.e(new o(TxMetadataKey_RippleKt.getDestinationTag(TxMetadataKey.Companion), m1660getDestinationTag0hXNFcg()));
        return e2;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Network getNetwork() {
        return this.network;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public BigInteger getTransferValue() {
        return this.transferValue;
    }

    public int hashCode() {
        int hashCode = ((((((getFromAddress().hashCode() * 31) + getRecipientAddress().hashCode()) * 31) + getTransferValue().hashCode()) * 31) + getEstimatedFee().hashCode()) * 31;
        UInt uInt = this.destinationTag;
        return ((hashCode + (uInt == null ? 0 : UInt.z(uInt.B()))) * 31) + getNetwork().hashCode();
    }

    public String toString() {
        return "XRPUnsignedTx(fromAddress=" + getFromAddress() + ", recipientAddress=" + getRecipientAddress() + ", transferValue=" + getTransferValue() + ", estimatedFee=" + getEstimatedFee() + ", destinationTag=" + this.destinationTag + ", network=" + getNetwork() + ')';
    }
}