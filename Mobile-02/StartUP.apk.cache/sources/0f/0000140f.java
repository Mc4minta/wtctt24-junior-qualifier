package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.extensions.TxMetadataKey_BlockchainsKt;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Transaction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B\u0093\u0001\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010(\u001a\u00020\n\u0012\u0006\u0010)\u001a\u00020\r\u0012\u0006\u0010*\u001a\u00020\r\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010-\u001a\u00020\u0013\u0012\u0006\u0010.\u001a\u00020\u0013\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u00100\u001a\u00020\u0018\u0012\u0006\u00101\u001a\u00020\u001b\u0012\u0006\u00102\u001a\u00020\u001e\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00104\u001a\u00020\"¢\u0006\u0004\b^\u0010_J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\u0005J\u0010\u0010#\u001a\u00020\"HÆ\u0003¢\u0006\u0004\b#\u0010$Jº\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u001b2\b\b\u0002\u00102\u001a\u00020\u001e2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00104\u001a\u00020\"HÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b7\u0010\u0005J\u0010\u00109\u001a\u000208HÖ\u0001¢\u0006\u0004\b9\u0010:J\u001a\u0010=\u001a\u00020\"2\b\u0010<\u001a\u0004\u0018\u00010;HÖ\u0003¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u000208HÖ\u0001¢\u0006\u0004\b?\u0010:J \u0010D\u001a\u00020C2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u000208HÖ\u0001¢\u0006\u0004\bD\u0010ER\u001e\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010F\u001a\u0004\bG\u0010\u0005R\u001c\u00104\u001a\u00020\"8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010H\u001a\u0004\b4\u0010$R\u001e\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010F\u001a\u0004\bI\u0010\u0005R\u001c\u0010*\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bK\u0010\u000fR\u001c\u0010&\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010L\u001a\u0004\bM\u0010\bR\u001e\u0010/\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010N\u001a\u0004\bO\u0010\u0015R\u001c\u0010(\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010P\u001a\u0004\bQ\u0010\fR\u001c\u00102\u001a\u00020\u001e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010R\u001a\u0004\bS\u0010 R\u001c\u0010-\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010N\u001a\u0004\bT\u0010\u0015R\u001c\u0010%\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b%\u0010F\u001a\u0004\bU\u0010\u0005R\u001c\u0010.\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010N\u001a\u0004\bV\u0010\u0015R\u001c\u00101\u001a\u00020\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010W\u001a\u0004\bX\u0010\u001dR\u001c\u0010)\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010J\u001a\u0004\bY\u0010\u000fR\u001e\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010F\u001a\u0004\bZ\u0010\u0005R\u001c\u00100\u001a\u00020\u00188\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010[\u001a\u0004\b\\\u0010\u001aR\u001e\u0010'\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010L\u001a\u0004\b]\u0010\b¨\u0006a"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Transaction;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Ljava/util/Date;", "component2", "()Ljava/util/Date;", "component3", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component4", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component6", "component7", "component8", "Ljava/math/BigInteger;", "component9", "()Ljava/math/BigInteger;", "component10", "component11", "Lcom/coinbase/wallet/blockchains/models/TxState;", "component12", "()Lcom/coinbase/wallet/blockchains/models/TxState;", "Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "component13", "()Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "Lcom/coinbase/wallet/blockchains/models/Network;", "component14", "()Lcom/coinbase/wallet/blockchains/models/Network;", "component15", "", "component16", "()Z", "id", "createdAt", "confirmedAt", RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "feeCurrencyCode", "toAddress", "fromAddress", "amount", ApiConstants.FEE, "lowerBoundFee", ApiConstants.STATE, SendConfirmationArgs.metadataKey, "network", "txHash", "isSent", "copy", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/TxState;Lcom/coinbase/wallet/blockchains/models/TxMetadata;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Z)Lcom/coinbase/wallet/blockchains/models/Transaction;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFromAddress", "Z", "getTxHash", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getFeeCurrencyCode", "Ljava/util/Date;", "getCreatedAt", "Ljava/math/BigInteger;", "getLowerBoundFee", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "getAmount", "getId", "getFee", "Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "getMetadata", "getCurrencyCode", "getToAddress", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getState", "getConfirmedAt", "<init>", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/TxState;Lcom/coinbase/wallet/blockchains/models/TxMetadata;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Z)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Transaction implements DatabaseModelObject, Parcelable {
    private final BigInteger amount;
    private final Blockchain blockchain;
    private final Date confirmedAt;
    private final Date createdAt;
    private final CurrencyCode currencyCode;
    private final BigInteger fee;
    private final CurrencyCode feeCurrencyCode;
    private final String fromAddress;
    private final String id;
    private final boolean isSent;
    private final BigInteger lowerBoundFee;
    private final TxMetadata metadata;
    private final Network network;
    private final TxState state;
    private final String toAddress;
    private final String txHash;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Transaction> CREATOR = new Creator();

    /* compiled from: Transaction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Transaction$Companion;", "", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signedTx", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "createSubmittedTx", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;)Lcom/coinbase/wallet/blockchains/models/Transaction;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Transaction createSubmittedTx(UnsignedTx unsignedTx, SignedTx signedTx) {
            Map v;
            m.g(unsignedTx, "unsignedTx");
            m.g(signedTx, "signedTx");
            v = m0.v(unsignedTx.getMetadata());
            v.put(TxMetadataKey_BlockchainsKt.getHasRecordedConfirmEvent(TxMetadataKey.Companion), Boolean.FALSE);
            String uuid = UUID.randomUUID().toString();
            Date date = new Date();
            Blockchain blockchain = unsignedTx.getBlockchain();
            CurrencyCode currencyCode = unsignedTx.getCurrencyCode();
            CurrencyCode feeCurrencyCode = unsignedTx.getFeeCurrencyCode();
            String recipientAddress = unsignedTx.getRecipientAddress();
            String fromAddress = unsignedTx.getFromAddress();
            BigInteger transferValue = unsignedTx.getTransferValue();
            BigInteger estimatedFee = unsignedTx.getEstimatedFee();
            TxMetadata txMetadata = new TxMetadata(v);
            TxState txState = TxState.PENDING;
            Network network = unsignedTx.getNetwork();
            String txHash = signedTx.getTxHash();
            m.f(uuid, "toString()");
            return new Transaction(uuid, date, null, blockchain, currencyCode, feeCurrencyCode, recipientAddress, fromAddress, transferValue, estimatedFee, null, txState, txMetadata, network, txHash, true);
        }
    }

    /* compiled from: Transaction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Transaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            String readString = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Blockchain createFromParcel = Blockchain.CREATOR.createFromParcel(parcel);
            Parcelable.Creator<CurrencyCode> creator = CurrencyCode.CREATOR;
            return new Transaction(readString, date, date2, createFromParcel, creator.createFromParcel(parcel), creator.createFromParcel(parcel), parcel.readString(), parcel.readString(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), TxState.valueOf(parcel.readString()), TxMetadata.CREATOR.createFromParcel(parcel), Network.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction[] newArray(int i2) {
            return new Transaction[i2];
        }
    }

    public Transaction(String id, Date createdAt, Date date, Blockchain blockchain, CurrencyCode currencyCode, CurrencyCode feeCurrencyCode, String str, String str2, BigInteger amount, BigInteger fee, BigInteger bigInteger, TxState state, TxMetadata metadata, Network network, String str3, boolean z) {
        m.g(id, "id");
        m.g(createdAt, "createdAt");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(feeCurrencyCode, "feeCurrencyCode");
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(state, "state");
        m.g(metadata, "metadata");
        m.g(network, "network");
        this.id = id;
        this.createdAt = createdAt;
        this.confirmedAt = date;
        this.blockchain = blockchain;
        this.currencyCode = currencyCode;
        this.feeCurrencyCode = feeCurrencyCode;
        this.toAddress = str;
        this.fromAddress = str2;
        this.amount = amount;
        this.fee = fee;
        this.lowerBoundFee = bigInteger;
        this.state = state;
        this.metadata = metadata;
        this.network = network;
        this.txHash = str3;
        this.isSent = z;
    }

    public final String component1() {
        return getId();
    }

    public final BigInteger component10() {
        return this.fee;
    }

    public final BigInteger component11() {
        return this.lowerBoundFee;
    }

    public final TxState component12() {
        return this.state;
    }

    public final TxMetadata component13() {
        return this.metadata;
    }

    public final Network component14() {
        return this.network;
    }

    public final String component15() {
        return this.txHash;
    }

    public final boolean component16() {
        return this.isSent;
    }

    public final Date component2() {
        return this.createdAt;
    }

    public final Date component3() {
        return this.confirmedAt;
    }

    public final Blockchain component4() {
        return this.blockchain;
    }

    public final CurrencyCode component5() {
        return this.currencyCode;
    }

    public final CurrencyCode component6() {
        return this.feeCurrencyCode;
    }

    public final String component7() {
        return this.toAddress;
    }

    public final String component8() {
        return this.fromAddress;
    }

    public final BigInteger component9() {
        return this.amount;
    }

    public final Transaction copy(String id, Date createdAt, Date date, Blockchain blockchain, CurrencyCode currencyCode, CurrencyCode feeCurrencyCode, String str, String str2, BigInteger amount, BigInteger fee, BigInteger bigInteger, TxState state, TxMetadata metadata, Network network, String str3, boolean z) {
        m.g(id, "id");
        m.g(createdAt, "createdAt");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(feeCurrencyCode, "feeCurrencyCode");
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(state, "state");
        m.g(metadata, "metadata");
        m.g(network, "network");
        return new Transaction(id, createdAt, date, blockchain, currencyCode, feeCurrencyCode, str, str2, amount, fee, bigInteger, state, metadata, network, str3, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Transaction) {
            Transaction transaction = (Transaction) obj;
            return m.c(getId(), transaction.getId()) && m.c(this.createdAt, transaction.createdAt) && m.c(this.confirmedAt, transaction.confirmedAt) && m.c(this.blockchain, transaction.blockchain) && m.c(this.currencyCode, transaction.currencyCode) && m.c(this.feeCurrencyCode, transaction.feeCurrencyCode) && m.c(this.toAddress, transaction.toAddress) && m.c(this.fromAddress, transaction.fromAddress) && m.c(this.amount, transaction.amount) && m.c(this.fee, transaction.fee) && m.c(this.lowerBoundFee, transaction.lowerBoundFee) && this.state == transaction.state && m.c(this.metadata, transaction.metadata) && m.c(this.network, transaction.network) && m.c(this.txHash, transaction.txHash) && this.isSent == transaction.isSent;
        }
        return false;
    }

    public final BigInteger getAmount() {
        return this.amount;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final Date getConfirmedAt() {
        return this.confirmedAt;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final BigInteger getFee() {
        return this.fee;
    }

    public final CurrencyCode getFeeCurrencyCode() {
        return this.feeCurrencyCode;
    }

    public final String getFromAddress() {
        return this.fromAddress;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final BigInteger getLowerBoundFee() {
        return this.lowerBoundFee;
    }

    public final TxMetadata getMetadata() {
        return this.metadata;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final TxState getState() {
        return this.state;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public final String getTxHash() {
        return this.txHash;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((getId().hashCode() * 31) + this.createdAt.hashCode()) * 31;
        Date date = this.confirmedAt;
        int hashCode2 = (((((((hashCode + (date == null ? 0 : date.hashCode())) * 31) + this.blockchain.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.feeCurrencyCode.hashCode()) * 31;
        String str = this.toAddress;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fromAddress;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.amount.hashCode()) * 31) + this.fee.hashCode()) * 31;
        BigInteger bigInteger = this.lowerBoundFee;
        int hashCode5 = (((((((hashCode4 + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31) + this.state.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.network.hashCode()) * 31;
        String str3 = this.txHash;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.isSent;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode6 + i2;
    }

    public final boolean isSent() {
        return this.isSent;
    }

    public String toString() {
        return "Transaction(id=" + getId() + ", createdAt=" + this.createdAt + ", confirmedAt=" + this.confirmedAt + ", blockchain=" + this.blockchain + ", currencyCode=" + this.currencyCode + ", feeCurrencyCode=" + this.feeCurrencyCode + ", toAddress=" + ((Object) this.toAddress) + ", fromAddress=" + ((Object) this.fromAddress) + ", amount=" + this.amount + ", fee=" + this.fee + ", lowerBoundFee=" + this.lowerBoundFee + ", state=" + this.state + ", metadata=" + this.metadata + ", network=" + this.network + ", txHash=" + ((Object) this.txHash) + ", isSent=" + this.isSent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeSerializable(this.createdAt);
        out.writeSerializable(this.confirmedAt);
        this.blockchain.writeToParcel(out, i2);
        this.currencyCode.writeToParcel(out, i2);
        this.feeCurrencyCode.writeToParcel(out, i2);
        out.writeString(this.toAddress);
        out.writeString(this.fromAddress);
        out.writeSerializable(this.amount);
        out.writeSerializable(this.fee);
        out.writeSerializable(this.lowerBoundFee);
        out.writeString(this.state.name());
        this.metadata.writeToParcel(out, i2);
        this.network.writeToParcel(out, i2);
        out.writeString(this.txHash);
        out.writeInt(this.isSent ? 1 : 0);
    }

    public /* synthetic */ Transaction(String str, Date date, Date date2, Blockchain blockchain, CurrencyCode currencyCode, CurrencyCode currencyCode2, String str2, String str3, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, TxState txState, TxMetadata txMetadata, Network network, String str4, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, date2, blockchain, currencyCode, currencyCode2, str2, str3, bigInteger, bigInteger2, (i2 & 1024) != 0 ? null : bigInteger3, txState, txMetadata, network, str4, z);
    }
}