package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Secure3DVerification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "url", "paReq", "redirectURL", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getPaReq", "getUrl", "getRedirectURL", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Secure3DVerification implements Parcelable {
    public static final Parcelable.Creator<Secure3DVerification> CREATOR = new Creator();
    private final String paReq;
    private final String redirectURL;
    private final String url;

    /* compiled from: Secure3DVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Secure3DVerification> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Secure3DVerification createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new Secure3DVerification(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Secure3DVerification[] newArray(int i2) {
            return new Secure3DVerification[i2];
        }
    }

    public Secure3DVerification(String url, String paReq, String redirectURL) {
        m.g(url, "url");
        m.g(paReq, "paReq");
        m.g(redirectURL, "redirectURL");
        this.url = url;
        this.paReq = paReq;
        this.redirectURL = redirectURL;
    }

    public static /* synthetic */ Secure3DVerification copy$default(Secure3DVerification secure3DVerification, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = secure3DVerification.url;
        }
        if ((i2 & 2) != 0) {
            str2 = secure3DVerification.paReq;
        }
        if ((i2 & 4) != 0) {
            str3 = secure3DVerification.redirectURL;
        }
        return secure3DVerification.copy(str, str2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.paReq;
    }

    public final String component3() {
        return this.redirectURL;
    }

    public final Secure3DVerification copy(String url, String paReq, String redirectURL) {
        m.g(url, "url");
        m.g(paReq, "paReq");
        m.g(redirectURL, "redirectURL");
        return new Secure3DVerification(url, paReq, redirectURL);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Secure3DVerification) {
            Secure3DVerification secure3DVerification = (Secure3DVerification) obj;
            return m.c(this.url, secure3DVerification.url) && m.c(this.paReq, secure3DVerification.paReq) && m.c(this.redirectURL, secure3DVerification.redirectURL);
        }
        return false;
    }

    public final String getPaReq() {
        return this.paReq;
    }

    public final String getRedirectURL() {
        return this.redirectURL;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.paReq.hashCode()) * 31) + this.redirectURL.hashCode();
    }

    public String toString() {
        return "Secure3DVerification(url=" + this.url + ", paReq=" + this.paReq + ", redirectURL=" + this.redirectURL + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.url);
        out.writeString(this.paReq);
        out.writeString(this.redirectURL);
    }
}