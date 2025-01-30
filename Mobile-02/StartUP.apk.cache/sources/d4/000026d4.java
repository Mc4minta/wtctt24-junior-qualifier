package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ApproveTx.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\f\u0010\u0004JB\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001c\u0010\u000f\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/swap/models/ApproveTx;", "Landroid/os/Parcelable;", "", "component1$swap_release", "()Ljava/lang/String;", "component1", "component2$swap_release", "component2", "component3$swap_release", "component3", "component4$swap_release", "component4", "component5$swap_release", "component5", ApiConstants.FROM, ApiConstants.TO, "gas", "gasPrice", "data", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/swap/models/ApproveTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTo$swap_release", "getGas$swap_release", "getGasPrice$swap_release", "getFrom$swap_release", "getData$swap_release", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ApproveTx implements Parcelable {
    public static final Parcelable.Creator<ApproveTx> CREATOR = new Creator();
    private final String data;
    private final String from;
    private final String gas;
    private final String gasPrice;
    private final String to;

    /* compiled from: ApproveTx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ApproveTx> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ApproveTx createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ApproveTx(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ApproveTx[] newArray(int i2) {
            return new ApproveTx[i2];
        }
    }

    public ApproveTx(String from, String to, String gas, String gasPrice, String data) {
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
    }

    public static /* synthetic */ ApproveTx copy$default(ApproveTx approveTx, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = approveTx.from;
        }
        if ((i2 & 2) != 0) {
            str2 = approveTx.to;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = approveTx.gas;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = approveTx.gasPrice;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = approveTx.data;
        }
        return approveTx.copy(str, str6, str7, str8, str5);
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

    public final ApproveTx copy(String from, String to, String gas, String gasPrice, String data) {
        m.g(from, "from");
        m.g(to, "to");
        m.g(gas, "gas");
        m.g(gasPrice, "gasPrice");
        m.g(data, "data");
        return new ApproveTx(from, to, gas, gasPrice, data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApproveTx) {
            ApproveTx approveTx = (ApproveTx) obj;
            return m.c(this.from, approveTx.from) && m.c(this.to, approveTx.to) && m.c(this.gas, approveTx.gas) && m.c(this.gasPrice, approveTx.gasPrice) && m.c(this.data, approveTx.data);
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

    public int hashCode() {
        return (((((((this.from.hashCode() * 31) + this.to.hashCode()) * 31) + this.gas.hashCode()) * 31) + this.gasPrice.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "ApproveTx(from=" + this.from + ", to=" + this.to + ", gas=" + this.gas + ", gasPrice=" + this.gasPrice + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.from);
        out.writeString(this.to);
        out.writeString(this.gas);
        out.writeString(this.gasPrice);
        out.writeString(this.data);
    }
}