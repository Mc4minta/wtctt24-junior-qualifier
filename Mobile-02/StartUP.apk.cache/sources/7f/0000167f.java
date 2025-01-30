package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerPaymentMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJj\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0005J\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020 HÖ\u0001¢\u0006\u0004\b'\u0010\"J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 HÖ\u0001¢\u0006\u0004\b,\u0010-R\u001c\u0010\u0018\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\rR\u001c\u0010\u001a\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b0\u0010\rR\u001c\u0010\u0014\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\b2\u0010\u0005R\u001c\u0010\u0017\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b4\u0010\nR\u001c\u0010\u001b\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b6\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b7\u0010\rR\u001c\u0010\u0016\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00101\u001a\u0004\b8\u0010\u0005R\u001c\u0010\u001c\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b9\u0010\rR\u001c\u0010\u0015\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b:\u0010\u0005¨\u0006="}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component4", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component5", "()Z", "component6", "component7", "Ljava/math/BigDecimal;", "component8", "()Ljava/math/BigDecimal;", "component9", "id", "type", ApiConstants.NAME, AppsFlyerProperties.CURRENCY_CODE, "allowBuy", "allowSell", "instantBuy", "buyLimit", "verified", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZZZLjava/math/BigDecimal;Z)Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getAllowBuy", "getInstantBuy", "Ljava/lang/String;", "getId", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/math/BigDecimal;", "getBuyLimit", "getAllowSell", "getName", "getVerified", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZZZLjava/math/BigDecimal;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerPaymentMethod implements Parcelable, DatabaseModelObject {
    public static final Parcelable.Creator<ConsumerPaymentMethod> CREATOR = new Creator();
    private final boolean allowBuy;
    private final boolean allowSell;
    private final BigDecimal buyLimit;
    private final CurrencyCode currencyCode;
    private final String id;
    private final boolean instantBuy;
    private final String name;
    private final String type;
    private final boolean verified;

    /* compiled from: ConsumerPaymentMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ConsumerPaymentMethod> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerPaymentMethod createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ConsumerPaymentMethod(parcel.readString(), parcel.readString(), parcel.readString(), (CurrencyCode) parcel.readParcelable(ConsumerPaymentMethod.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (BigDecimal) parcel.readSerializable(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerPaymentMethod[] newArray(int i2) {
            return new ConsumerPaymentMethod[i2];
        }
    }

    public ConsumerPaymentMethod(String id, String type, String name, CurrencyCode currencyCode, boolean z, boolean z2, boolean z3, BigDecimal buyLimit, boolean z4) {
        m.g(id, "id");
        m.g(type, "type");
        m.g(name, "name");
        m.g(currencyCode, "currencyCode");
        m.g(buyLimit, "buyLimit");
        this.id = id;
        this.type = type;
        this.name = name;
        this.currencyCode = currencyCode;
        this.allowBuy = z;
        this.allowSell = z2;
        this.instantBuy = z3;
        this.buyLimit = buyLimit;
        this.verified = z4;
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.name;
    }

    public final CurrencyCode component4() {
        return this.currencyCode;
    }

    public final boolean component5() {
        return this.allowBuy;
    }

    public final boolean component6() {
        return this.allowSell;
    }

    public final boolean component7() {
        return this.instantBuy;
    }

    public final BigDecimal component8() {
        return this.buyLimit;
    }

    public final boolean component9() {
        return this.verified;
    }

    public final ConsumerPaymentMethod copy(String id, String type, String name, CurrencyCode currencyCode, boolean z, boolean z2, boolean z3, BigDecimal buyLimit, boolean z4) {
        m.g(id, "id");
        m.g(type, "type");
        m.g(name, "name");
        m.g(currencyCode, "currencyCode");
        m.g(buyLimit, "buyLimit");
        return new ConsumerPaymentMethod(id, type, name, currencyCode, z, z2, z3, buyLimit, z4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerPaymentMethod) {
            ConsumerPaymentMethod consumerPaymentMethod = (ConsumerPaymentMethod) obj;
            return m.c(getId(), consumerPaymentMethod.getId()) && m.c(this.type, consumerPaymentMethod.type) && m.c(this.name, consumerPaymentMethod.name) && m.c(this.currencyCode, consumerPaymentMethod.currencyCode) && this.allowBuy == consumerPaymentMethod.allowBuy && this.allowSell == consumerPaymentMethod.allowSell && this.instantBuy == consumerPaymentMethod.instantBuy && m.c(this.buyLimit, consumerPaymentMethod.buyLimit) && this.verified == consumerPaymentMethod.verified;
        }
        return false;
    }

    public final boolean getAllowBuy() {
        return this.allowBuy;
    }

    public final boolean getAllowSell() {
        return this.allowSell;
    }

    public final BigDecimal getBuyLimit() {
        return this.buyLimit;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final boolean getInstantBuy() {
        return this.instantBuy;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getVerified() {
        return this.verified;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((getId().hashCode() * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        boolean z = this.allowBuy;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.allowSell;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.instantBuy;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int hashCode2 = (((i5 + i6) * 31) + this.buyLimit.hashCode()) * 31;
        boolean z4 = this.verified;
        return hashCode2 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        return "ConsumerPaymentMethod(id=" + getId() + ", type=" + this.type + ", name=" + this.name + ", currencyCode=" + this.currencyCode + ", allowBuy=" + this.allowBuy + ", allowSell=" + this.allowSell + ", instantBuy=" + this.instantBuy + ", buyLimit=" + this.buyLimit + ", verified=" + this.verified + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeString(this.type);
        out.writeString(this.name);
        out.writeParcelable(this.currencyCode, i2);
        out.writeInt(this.allowBuy ? 1 : 0);
        out.writeInt(this.allowSell ? 1 : 0);
        out.writeInt(this.instantBuy ? 1 : 0);
        out.writeSerializable(this.buyLimit);
        out.writeInt(this.verified ? 1 : 0);
    }
}