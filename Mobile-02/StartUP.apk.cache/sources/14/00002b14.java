package com.coinbase.walletengine.services.xrp;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: XRPService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BD\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J^\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0002HÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b$\u0010\u0004R'\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\rR\u001c\u0010\u0014\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\tR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b+\u0010\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Lcom/coinbase/walletengine/services/xrp/Transaction;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "component5", "Lkotlin/UInt;", "component6-0hXNFcg", "()Lkotlin/UInt;", "component6", "component7", "txHash", "address", "destination", ApiConstants.FEE, "amount", "destinationTag", "timestamp", "copy-hmdoAho", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Lkotlin/UInt;Ljava/lang/String;)Lcom/coinbase/walletengine/services/xrp/Transaction;", "copy", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTimestamp", "getDestination", "Lkotlin/UInt;", "getDestinationTag-0hXNFcg", "Ljava/math/BigInteger;", "getAmount", "getAddress", "getTxHash", "getFee", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Lkotlin/UInt;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Transaction {
    @Json(name = "address")
    private final String address;
    @Json(name = "amount")
    private final BigInteger amount;
    @Json(name = "destination")
    private final String destination;
    @Json(name = "destinationTag")
    private final UInt destinationTag;
    @Json(name = ApiConstants.FEE)
    private final BigInteger fee;
    @Json(name = "timestamp")
    private final String timestamp;
    @Json(name = "txHash")
    private final String txHash;

    private Transaction(String str, String str2, String str3, BigInteger bigInteger, BigInteger bigInteger2, UInt uInt, String str4) {
        this.txHash = str;
        this.address = str2;
        this.destination = str3;
        this.fee = bigInteger;
        this.amount = bigInteger2;
        this.destinationTag = uInt;
        this.timestamp = str4;
    }

    public /* synthetic */ Transaction(String str, String str2, String str3, BigInteger bigInteger, BigInteger bigInteger2, UInt uInt, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, bigInteger, bigInteger2, uInt, str4);
    }

    /* renamed from: copy-hmdoAho$default  reason: not valid java name */
    public static /* synthetic */ Transaction m2098copyhmdoAho$default(Transaction transaction, String str, String str2, String str3, BigInteger bigInteger, BigInteger bigInteger2, UInt uInt, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = transaction.txHash;
        }
        if ((i2 & 2) != 0) {
            str2 = transaction.address;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = transaction.destination;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            bigInteger = transaction.fee;
        }
        BigInteger bigInteger3 = bigInteger;
        if ((i2 & 16) != 0) {
            bigInteger2 = transaction.amount;
        }
        BigInteger bigInteger4 = bigInteger2;
        if ((i2 & 32) != 0) {
            uInt = transaction.destinationTag;
        }
        UInt uInt2 = uInt;
        if ((i2 & 64) != 0) {
            str4 = transaction.timestamp;
        }
        return transaction.m2100copyhmdoAho(str, str5, str6, bigInteger3, bigInteger4, uInt2, str4);
    }

    public final String component1() {
        return this.txHash;
    }

    public final String component2() {
        return this.address;
    }

    public final String component3() {
        return this.destination;
    }

    public final BigInteger component4() {
        return this.fee;
    }

    public final BigInteger component5() {
        return this.amount;
    }

    /* renamed from: component6-0hXNFcg  reason: not valid java name */
    public final UInt m2099component60hXNFcg() {
        return this.destinationTag;
    }

    public final String component7() {
        return this.timestamp;
    }

    /* renamed from: copy-hmdoAho  reason: not valid java name */
    public final Transaction m2100copyhmdoAho(String txHash, String address, String destination, BigInteger fee, BigInteger amount, UInt uInt, String timestamp) {
        m.g(txHash, "txHash");
        m.g(address, "address");
        m.g(destination, "destination");
        m.g(fee, "fee");
        m.g(amount, "amount");
        m.g(timestamp, "timestamp");
        return new Transaction(txHash, address, destination, fee, amount, uInt, timestamp, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Transaction) {
            Transaction transaction = (Transaction) obj;
            return m.c(this.txHash, transaction.txHash) && m.c(this.address, transaction.address) && m.c(this.destination, transaction.destination) && m.c(this.fee, transaction.fee) && m.c(this.amount, transaction.amount) && m.c(this.destinationTag, transaction.destinationTag) && m.c(this.timestamp, transaction.timestamp);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final BigInteger getAmount() {
        return this.amount;
    }

    public final String getDestination() {
        return this.destination;
    }

    /* renamed from: getDestinationTag-0hXNFcg  reason: not valid java name */
    public final UInt m2101getDestinationTag0hXNFcg() {
        return this.destinationTag;
    }

    public final BigInteger getFee() {
        return this.fee;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getTxHash() {
        return this.txHash;
    }

    public int hashCode() {
        int hashCode = ((((((((this.txHash.hashCode() * 31) + this.address.hashCode()) * 31) + this.destination.hashCode()) * 31) + this.fee.hashCode()) * 31) + this.amount.hashCode()) * 31;
        UInt uInt = this.destinationTag;
        return ((hashCode + (uInt == null ? 0 : UInt.z(uInt.B()))) * 31) + this.timestamp.hashCode();
    }

    public String toString() {
        return "Transaction(txHash=" + this.txHash + ", address=" + this.address + ", destination=" + this.destination + ", fee=" + this.fee + ", amount=" + this.amount + ", destinationTag=" + this.destinationTag + ", timestamp=" + this.timestamp + ')';
    }
}