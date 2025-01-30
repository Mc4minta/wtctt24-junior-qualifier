package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.a;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SwapQuote.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0019\u001a\u00020\t\u0012\b\b\u0001\u0010\u001a\u001a\u00020\t\u0012\b\b\u0001\u0010\u001b\u001a\u00020\r\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0003\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jb\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0003\u0010\u0017\u001a\u00020\u00052\b\b\u0003\u0010\u0018\u001a\u00020\u00052\b\b\u0003\u0010\u0019\u001a\u00020\t2\b\b\u0003\u0010\u001a\u001a\u00020\t2\b\b\u0003\u0010\u001b\u001a\u00020\r2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u001d\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b!\u0010\u0015J\u001a\u0010$\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b&\u0010\u0015J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0019\u0010\u001d\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0012R\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u000fR\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00103\u001a\u0004\b4\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b5\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00106\u001a\u0004\b7\u0010\u000bR\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00106\u001a\u0004\b8\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\b:\u0010\u0004R\u0015\u0010>\u001a\u0004\u0018\u00010;8F@\u0006¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0013\u0010A\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapQuote;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "component2", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "component3", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "component5", "", "component6", "()D", "", "component7", "()Ljava/lang/Boolean;", "", "component8", "()I", "aggregatorID", "fromAsset", "toAsset", "fromAmount", "toAmount", "priceImpact", "_highPriceImpact", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Ljava/math/BigInteger;DLjava/lang/Boolean;I)Lcom/coinbase/wallet/swap/models/SwapQuote;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getChainId", "Ljava/lang/Boolean;", "get_highPriceImpact", "D", "getPriceImpact", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getToAsset", "getFromAsset", "Ljava/math/BigInteger;", "getToAmount", "getFromAmount", "Ljava/lang/String;", "getAggregatorID", "Ljava/math/BigDecimal;", "getExchangeRate", "()Ljava/math/BigDecimal;", "exchangeRate", "getHighPriceImpact", "()Z", "highPriceImpact", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Ljava/math/BigInteger;DLjava/lang/Boolean;I)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapQuote implements Parcelable {
    public static final Parcelable.Creator<SwapQuote> CREATOR = new Creator();
    private final Boolean _highPriceImpact;
    private final String aggregatorID;
    private final int chainId;
    private final BigInteger fromAmount;
    private final SwapAsset fromAsset;
    private final double priceImpact;
    private final BigInteger toAmount;
    private final SwapAsset toAsset;

    /* compiled from: SwapQuote.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SwapQuote> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapQuote createFromParcel(Parcel parcel) {
            Boolean valueOf;
            m.g(parcel, "parcel");
            String readString = parcel.readString();
            Parcelable.Creator<SwapAsset> creator = SwapAsset.CREATOR;
            SwapAsset createFromParcel = creator.createFromParcel(parcel);
            SwapAsset createFromParcel2 = creator.createFromParcel(parcel);
            BigInteger bigInteger = (BigInteger) parcel.readSerializable();
            BigInteger bigInteger2 = (BigInteger) parcel.readSerializable();
            double readDouble = parcel.readDouble();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SwapQuote(readString, createFromParcel, createFromParcel2, bigInteger, bigInteger2, readDouble, valueOf, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapQuote[] newArray(int i2) {
            return new SwapQuote[i2];
        }
    }

    public SwapQuote(String aggregatorID, @Json(name = "fromAsset") SwapAsset fromAsset, @Json(name = "toAsset") SwapAsset toAsset, @Json(name = "fromAmount") BigInteger fromAmount, @Json(name = "toAmount") BigInteger toAmount, @Json(name = "priceImpact") double d2, @Json(name = "highPriceImpact") Boolean bool, @Json(name = "chainId") int i2) {
        m.g(aggregatorID, "aggregatorID");
        m.g(fromAsset, "fromAsset");
        m.g(toAsset, "toAsset");
        m.g(fromAmount, "fromAmount");
        m.g(toAmount, "toAmount");
        this.aggregatorID = aggregatorID;
        this.fromAsset = fromAsset;
        this.toAsset = toAsset;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.priceImpact = d2;
        this._highPriceImpact = bool;
        this.chainId = i2;
    }

    public final String component1() {
        return this.aggregatorID;
    }

    public final SwapAsset component2() {
        return this.fromAsset;
    }

    public final SwapAsset component3() {
        return this.toAsset;
    }

    public final BigInteger component4() {
        return this.fromAmount;
    }

    public final BigInteger component5() {
        return this.toAmount;
    }

    public final double component6() {
        return this.priceImpact;
    }

    public final Boolean component7() {
        return this._highPriceImpact;
    }

    public final int component8() {
        return this.chainId;
    }

    public final SwapQuote copy(String aggregatorID, @Json(name = "fromAsset") SwapAsset fromAsset, @Json(name = "toAsset") SwapAsset toAsset, @Json(name = "fromAmount") BigInteger fromAmount, @Json(name = "toAmount") BigInteger toAmount, @Json(name = "priceImpact") double d2, @Json(name = "highPriceImpact") Boolean bool, @Json(name = "chainId") int i2) {
        m.g(aggregatorID, "aggregatorID");
        m.g(fromAsset, "fromAsset");
        m.g(toAsset, "toAsset");
        m.g(fromAmount, "fromAmount");
        m.g(toAmount, "toAmount");
        return new SwapQuote(aggregatorID, fromAsset, toAsset, fromAmount, toAmount, d2, bool, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapQuote) {
            SwapQuote swapQuote = (SwapQuote) obj;
            return m.c(this.aggregatorID, swapQuote.aggregatorID) && m.c(this.fromAsset, swapQuote.fromAsset) && m.c(this.toAsset, swapQuote.toAsset) && m.c(this.fromAmount, swapQuote.fromAmount) && m.c(this.toAmount, swapQuote.toAmount) && m.c(Double.valueOf(this.priceImpact), Double.valueOf(swapQuote.priceImpact)) && m.c(this._highPriceImpact, swapQuote._highPriceImpact) && this.chainId == swapQuote.chainId;
        }
        return false;
    }

    public final String getAggregatorID() {
        return this.aggregatorID;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final BigDecimal getExchangeRate() {
        if (m.c(this.fromAmount, BigInteger.ZERO)) {
            return null;
        }
        BigDecimal divide = new BigDecimal(this.toAmount).divide(new BigDecimal(this.fromAmount), RoundingMode.HALF_EVEN);
        m.f(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    public final BigInteger getFromAmount() {
        return this.fromAmount;
    }

    public final SwapAsset getFromAsset() {
        return this.fromAsset;
    }

    public final boolean getHighPriceImpact() {
        Boolean bool = this._highPriceImpact;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final double getPriceImpact() {
        return this.priceImpact;
    }

    public final BigInteger getToAmount() {
        return this.toAmount;
    }

    public final SwapAsset getToAsset() {
        return this.toAsset;
    }

    public final Boolean get_highPriceImpact() {
        return this._highPriceImpact;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.aggregatorID.hashCode() * 31) + this.fromAsset.hashCode()) * 31) + this.toAsset.hashCode()) * 31) + this.fromAmount.hashCode()) * 31) + this.toAmount.hashCode()) * 31) + a.a(this.priceImpact)) * 31;
        Boolean bool = this._highPriceImpact;
        return ((hashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.chainId;
    }

    public String toString() {
        return "SwapQuote(aggregatorID=" + this.aggregatorID + ", fromAsset=" + this.fromAsset + ", toAsset=" + this.toAsset + ", fromAmount=" + this.fromAmount + ", toAmount=" + this.toAmount + ", priceImpact=" + this.priceImpact + ", _highPriceImpact=" + this._highPriceImpact + ", chainId=" + this.chainId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        int i3;
        m.g(out, "out");
        out.writeString(this.aggregatorID);
        this.fromAsset.writeToParcel(out, i2);
        this.toAsset.writeToParcel(out, i2);
        out.writeSerializable(this.fromAmount);
        out.writeSerializable(this.toAmount);
        out.writeDouble(this.priceImpact);
        Boolean bool = this._highPriceImpact;
        if (bool == null) {
            i3 = 0;
        } else {
            out.writeInt(1);
            i3 = bool.booleanValue();
        }
        out.writeInt(i3);
        out.writeInt(this.chainId);
    }

    public /* synthetic */ SwapQuote(String str, SwapAsset swapAsset, SwapAsset swapAsset2, BigInteger bigInteger, BigInteger bigInteger2, double d2, Boolean bool, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, swapAsset, swapAsset2, bigInteger, bigInteger2, d2, bool, (i3 & 128) != 0 ? 1 : i2);
    }
}