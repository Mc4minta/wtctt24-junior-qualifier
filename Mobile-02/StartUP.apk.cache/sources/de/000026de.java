package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapFee.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapFee;", "Landroid/os/Parcelable;", "Ljava/math/BigDecimal;", "component1", "()Ljava/math/BigDecimal;", "", "component2", "()Ljava/lang/String;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "component3", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "amount", "displayPercentage", "baseAsset", "copy", "(Ljava/math/BigDecimal;Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapAsset;)Lcom/coinbase/wallet/swap/models/SwapFee;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigDecimal;", "getAmount", "Ljava/lang/String;", "getDisplayPercentage", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getBaseAsset", "<init>", "(Ljava/math/BigDecimal;Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapFee implements Parcelable {
    public static final Parcelable.Creator<SwapFee> CREATOR = new Creator();
    private final BigDecimal amount;
    private final SwapAsset baseAsset;
    private final String displayPercentage;

    /* compiled from: SwapFee.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SwapFee> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapFee createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new SwapFee((BigDecimal) parcel.readSerializable(), parcel.readString(), SwapAsset.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapFee[] newArray(int i2) {
            return new SwapFee[i2];
        }
    }

    public SwapFee(BigDecimal amount, @Json(name = "percentage") String displayPercentage, SwapAsset baseAsset) {
        m.g(amount, "amount");
        m.g(displayPercentage, "displayPercentage");
        m.g(baseAsset, "baseAsset");
        this.amount = amount;
        this.displayPercentage = displayPercentage;
        this.baseAsset = baseAsset;
    }

    public static /* synthetic */ SwapFee copy$default(SwapFee swapFee, BigDecimal bigDecimal, String str, SwapAsset swapAsset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigDecimal = swapFee.amount;
        }
        if ((i2 & 2) != 0) {
            str = swapFee.displayPercentage;
        }
        if ((i2 & 4) != 0) {
            swapAsset = swapFee.baseAsset;
        }
        return swapFee.copy(bigDecimal, str, swapAsset);
    }

    public final BigDecimal component1() {
        return this.amount;
    }

    public final String component2() {
        return this.displayPercentage;
    }

    public final SwapAsset component3() {
        return this.baseAsset;
    }

    public final SwapFee copy(BigDecimal amount, @Json(name = "percentage") String displayPercentage, SwapAsset baseAsset) {
        m.g(amount, "amount");
        m.g(displayPercentage, "displayPercentage");
        m.g(baseAsset, "baseAsset");
        return new SwapFee(amount, displayPercentage, baseAsset);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapFee) {
            SwapFee swapFee = (SwapFee) obj;
            return m.c(this.amount, swapFee.amount) && m.c(this.displayPercentage, swapFee.displayPercentage) && m.c(this.baseAsset, swapFee.baseAsset);
        }
        return false;
    }

    public final BigDecimal getAmount() {
        return this.amount;
    }

    public final SwapAsset getBaseAsset() {
        return this.baseAsset;
    }

    public final String getDisplayPercentage() {
        return this.displayPercentage;
    }

    public int hashCode() {
        return (((this.amount.hashCode() * 31) + this.displayPercentage.hashCode()) * 31) + this.baseAsset.hashCode();
    }

    public String toString() {
        return "SwapFee(amount=" + this.amount + ", displayPercentage=" + this.displayPercentage + ", baseAsset=" + this.baseAsset + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeSerializable(this.amount);
        out.writeString(this.displayPercentage);
        this.baseAsset.writeToParcel(out, i2);
    }
}