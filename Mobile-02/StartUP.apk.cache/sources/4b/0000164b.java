package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAccount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB]\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0005Jz\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\u0005J\u0010\u0010\"\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\"\u0010\u0010J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b(\u0010\u0010J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b-\u0010.R\u001c\u0010\u0016\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u0010\u0005R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b1\u0010\u0005R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b2\u0010\u0005R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b3\u0010\u0005R\u001c\u0010\u0017\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00104\u001a\u0004\b5\u0010\tR\u001c\u0010\u0019\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b6\u0010\u0005R\u0019\u0010:\u001a\u00020\u000e8F@\u0006¢\u0006\f\u0012\u0004\b8\u00109\u001a\u0004\b7\u0010\u0010R\u001c\u0010\u001a\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010;\u001a\u0004\b<\u0010\u0010R\u001c\u0010\u001b\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b=\u0010\u0005R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b>\u0010\u0005R\u001c\u0010\u0018\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b@\u0010\f¨\u0006D"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component4", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "", "component6", "()I", "component7", "component8", "component9", "component10", "id", ApiConstants.NAME, "balance", AppsFlyerProperties.CURRENCY_CODE, "currencyName", "decimals", "type", "imageUrl", "destinationTagName", "assetId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "getDestinationTagName", "getAssetId", "getId", "Ljava/math/BigInteger;", "getBalance", "getCurrencyName", "getTransferDecimals", "getTransferDecimals$annotations", "()V", "transferDecimals", "I", "getDecimals", "getType", "getImageUrl", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccount implements Parcelable, DatabaseModelObject {
    public static final String TYPE_FIAT = "fiat";
    public static final String TYPE_VAULT = "vault";
    public static final String TYPE_WALLET = "wallet";
    private final String assetId;
    private final BigInteger balance;
    private final CurrencyCode currencyCode;
    private final String currencyName;
    private final int decimals;
    private final String destinationTagName;
    private final String id;
    private final String imageUrl;
    private final String name;
    private final String type;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ConsumerAccount> CREATOR = new Creator();

    /* compiled from: ConsumerAccount.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccount$Companion;", "", "", "TYPE_FIAT", "Ljava/lang/String;", "TYPE_VAULT", "TYPE_WALLET", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConsumerAccount.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ConsumerAccount> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerAccount createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ConsumerAccount(parcel.readString(), parcel.readString(), (BigInteger) parcel.readSerializable(), (CurrencyCode) parcel.readParcelable(ConsumerAccount.class.getClassLoader()), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerAccount[] newArray(int i2) {
            return new ConsumerAccount[i2];
        }
    }

    public ConsumerAccount(String id, String name, BigInteger balance, CurrencyCode currencyCode, String currencyName, int i2, String type, String str, String str2, String str3) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(balance, "balance");
        m.g(currencyCode, "currencyCode");
        m.g(currencyName, "currencyName");
        m.g(type, "type");
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.decimals = i2;
        this.type = type;
        this.imageUrl = str;
        this.destinationTagName = str2;
        this.assetId = str3;
    }

    public static /* synthetic */ void getTransferDecimals$annotations() {
    }

    public final String component1() {
        return getId();
    }

    public final String component10() {
        return this.assetId;
    }

    public final String component2() {
        return this.name;
    }

    public final BigInteger component3() {
        return this.balance;
    }

    public final CurrencyCode component4() {
        return this.currencyCode;
    }

    public final String component5() {
        return this.currencyName;
    }

    public final int component6() {
        return this.decimals;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.imageUrl;
    }

    public final String component9() {
        return this.destinationTagName;
    }

    public final ConsumerAccount copy(String id, String name, BigInteger balance, CurrencyCode currencyCode, String currencyName, int i2, String type, String str, String str2, String str3) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(balance, "balance");
        m.g(currencyCode, "currencyCode");
        m.g(currencyName, "currencyName");
        m.g(type, "type");
        return new ConsumerAccount(id, name, balance, currencyCode, currencyName, i2, type, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAccount) {
            ConsumerAccount consumerAccount = (ConsumerAccount) obj;
            return m.c(getId(), consumerAccount.getId()) && m.c(this.name, consumerAccount.name) && m.c(this.balance, consumerAccount.balance) && m.c(this.currencyCode, consumerAccount.currencyCode) && m.c(this.currencyName, consumerAccount.currencyName) && this.decimals == consumerAccount.decimals && m.c(this.type, consumerAccount.type) && m.c(this.imageUrl, consumerAccount.imageUrl) && m.c(this.destinationTagName, consumerAccount.destinationTagName) && m.c(this.assetId, consumerAccount.assetId);
        }
        return false;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final BigInteger getBalance() {
        return this.balance;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getCurrencyName() {
        return this.currencyName;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getDestinationTagName() {
        return this.destinationTagName;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTransferDecimals() {
        if (m.c(this.currencyCode, CurrencyCode.Companion.getUSDC())) {
            return 2;
        }
        return Math.min(this.decimals, 8);
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((((((((getId().hashCode() * 31) + this.name.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.currencyName.hashCode()) * 31) + this.decimals) * 31) + this.type.hashCode()) * 31;
        String str = this.imageUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.destinationTagName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.assetId;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ConsumerAccount(id=" + getId() + ", name=" + this.name + ", balance=" + this.balance + ", currencyCode=" + this.currencyCode + ", currencyName=" + this.currencyName + ", decimals=" + this.decimals + ", type=" + this.type + ", imageUrl=" + ((Object) this.imageUrl) + ", destinationTagName=" + ((Object) this.destinationTagName) + ", assetId=" + ((Object) this.assetId) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeString(this.name);
        out.writeSerializable(this.balance);
        out.writeParcelable(this.currencyCode, i2);
        out.writeString(this.currencyName);
        out.writeInt(this.decimals);
        out.writeString(this.type);
        out.writeString(this.imageUrl);
        out.writeString(this.destinationTagName);
        out.writeString(this.assetId);
    }
}