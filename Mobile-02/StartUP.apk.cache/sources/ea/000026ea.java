package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapTx.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÀ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b&\u0010'R\u001c\u0010\u0014\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b+\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b.\u0010\u0004¨\u00061"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapTx;", "Landroid/os/Parcelable;", "", "component1$swap_release", "()Ljava/lang/String;", "component1", "component2$swap_release", "component2", "component3$swap_release", "component3", "component4$swap_release", "component4", "component5$swap_release", "component5", "component6$swap_release", "component6", ApiConstants.FROM, ApiConstants.TO, "gas", "gasPrice", "data", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/swap/models/SwapTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getData$swap_release", "getTo$swap_release", "getFrom$swap_release", "getValue$swap_release", "getGasPrice$swap_release", "getGas$swap_release", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapTx implements Parcelable {
    public static final Parcelable.Creator<SwapTx> CREATOR = new Creator();
    private final String data;
    private final String from;
    private final String gas;
    private final String gasPrice;
    private final String to;
    private final String value;

    /* compiled from: SwapTx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SwapTx> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapTx createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new SwapTx(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapTx[] newArray(int i2) {
            return new SwapTx[i2];
        }
    }

    public SwapTx(String from, String to, String gas, String gasPrice, String data, String str) {
        m.g(from, "from");
        m.g(to, "to");
        m.g(gas, "gas");
        m.g(gasPrice, "gasPrice");
        m.g(data, "data");
        this.from = from;
        this.to = to;
        this.gas = gas;
        this.gasPrice = gasPrice;
        this.data = data;
        this.value = str;
    }

    public static /* synthetic */ SwapTx copy$default(SwapTx swapTx, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = swapTx.from;
        }
        if ((i2 & 2) != 0) {
            str2 = swapTx.to;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = swapTx.gas;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = swapTx.gasPrice;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = swapTx.data;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = swapTx.value;
        }
        return swapTx.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1$swap_release() {
        return this.from;
    }

    public final String component2$swap_release() {
        return this.to;
    }

    public final String component3$swap_release() {
        return this.gas;
    }

    public final String component4$swap_release() {
        return this.gasPrice;
    }

    public final String component5$swap_release() {
        return this.data;
    }

    public final String component6$swap_release() {
        return this.value;
    }

    public final SwapTx copy(String from, String to, String gas, String gasPrice, String data, String str) {
        m.g(from, "from");
        m.g(to, "to");
        m.g(gas, "gas");
        m.g(gasPrice, "gasPrice");
        m.g(data, "data");
        return new SwapTx(from, to, gas, gasPrice, data, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapTx) {
            SwapTx swapTx = (SwapTx) obj;
            return m.c(this.from, swapTx.from) && m.c(this.to, swapTx.to) && m.c(this.gas, swapTx.gas) && m.c(this.gasPrice, swapTx.gasPrice) && m.c(this.data, swapTx.data) && m.c(this.value, swapTx.value);
        }
        return false;
    }

    public final String getData$swap_release() {
        return this.data;
    }

    public final String getFrom$swap_release() {
        return this.from;
    }

    public final String getGas$swap_release() {
        return this.gas;
    }

    public final String getGasPrice$swap_release() {
        return this.gasPrice;
    }

    public final String getTo$swap_release() {
        return this.to;
    }

    public final String getValue$swap_release() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((((((((this.from.hashCode() * 31) + this.to.hashCode()) * 31) + this.gas.hashCode()) * 31) + this.gasPrice.hashCode()) * 31) + this.data.hashCode()) * 31;
        String str = this.value;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SwapTx(from=" + this.from + ", to=" + this.to + ", gas=" + this.gas + ", gasPrice=" + this.gasPrice + ", data=" + this.data + ", value=" + ((Object) this.value) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.from);
        out.writeString(this.to);
        out.writeString(this.gas);
        out.writeString(this.gasPrice);
        out.writeString(this.data);
        out.writeString(this.value);
    }
}