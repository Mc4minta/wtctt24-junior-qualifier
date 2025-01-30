package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerNetworkConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Z", "baseApiURL", "baseApiV3URL", "oAuthApiURL", "clientId", "clientSecret", "apiVersion", "pinCertificates", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getOAuthApiURL", "getBaseApiURL", "getBaseApiV3URL", "Z", "getPinCertificates", "getClientSecret", "getClientId", "getApiVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerNetworkConfig implements Parcelable {
    public static final Parcelable.Creator<ConsumerNetworkConfig> CREATOR = new Creator();
    private final String apiVersion;
    private final String baseApiURL;
    private final String baseApiV3URL;
    private final String clientId;
    private final String clientSecret;
    private final String oAuthApiURL;
    private final boolean pinCertificates;

    /* compiled from: ConsumerNetworkConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ConsumerNetworkConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerNetworkConfig createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ConsumerNetworkConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerNetworkConfig[] newArray(int i2) {
            return new ConsumerNetworkConfig[i2];
        }
    }

    public ConsumerNetworkConfig(String baseApiURL, String baseApiV3URL, String oAuthApiURL, String clientId, String clientSecret, String apiVersion, boolean z) {
        m.g(baseApiURL, "baseApiURL");
        m.g(baseApiV3URL, "baseApiV3URL");
        m.g(oAuthApiURL, "oAuthApiURL");
        m.g(clientId, "clientId");
        m.g(clientSecret, "clientSecret");
        m.g(apiVersion, "apiVersion");
        this.baseApiURL = baseApiURL;
        this.baseApiV3URL = baseApiV3URL;
        this.oAuthApiURL = oAuthApiURL;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.apiVersion = apiVersion;
        this.pinCertificates = z;
    }

    public static /* synthetic */ ConsumerNetworkConfig copy$default(ConsumerNetworkConfig consumerNetworkConfig, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerNetworkConfig.baseApiURL;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerNetworkConfig.baseApiV3URL;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = consumerNetworkConfig.oAuthApiURL;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = consumerNetworkConfig.clientId;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = consumerNetworkConfig.clientSecret;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = consumerNetworkConfig.apiVersion;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            z = consumerNetworkConfig.pinCertificates;
        }
        return consumerNetworkConfig.copy(str, str7, str8, str9, str10, str11, z);
    }

    public final String component1() {
        return this.baseApiURL;
    }

    public final String component2() {
        return this.baseApiV3URL;
    }

    public final String component3() {
        return this.oAuthApiURL;
    }

    public final String component4() {
        return this.clientId;
    }

    public final String component5() {
        return this.clientSecret;
    }

    public final String component6() {
        return this.apiVersion;
    }

    public final boolean component7() {
        return this.pinCertificates;
    }

    public final ConsumerNetworkConfig copy(String baseApiURL, String baseApiV3URL, String oAuthApiURL, String clientId, String clientSecret, String apiVersion, boolean z) {
        m.g(baseApiURL, "baseApiURL");
        m.g(baseApiV3URL, "baseApiV3URL");
        m.g(oAuthApiURL, "oAuthApiURL");
        m.g(clientId, "clientId");
        m.g(clientSecret, "clientSecret");
        m.g(apiVersion, "apiVersion");
        return new ConsumerNetworkConfig(baseApiURL, baseApiV3URL, oAuthApiURL, clientId, clientSecret, apiVersion, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerNetworkConfig) {
            ConsumerNetworkConfig consumerNetworkConfig = (ConsumerNetworkConfig) obj;
            return m.c(this.baseApiURL, consumerNetworkConfig.baseApiURL) && m.c(this.baseApiV3URL, consumerNetworkConfig.baseApiV3URL) && m.c(this.oAuthApiURL, consumerNetworkConfig.oAuthApiURL) && m.c(this.clientId, consumerNetworkConfig.clientId) && m.c(this.clientSecret, consumerNetworkConfig.clientSecret) && m.c(this.apiVersion, consumerNetworkConfig.apiVersion) && this.pinCertificates == consumerNetworkConfig.pinCertificates;
        }
        return false;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final String getBaseApiURL() {
        return this.baseApiURL;
    }

    public final String getBaseApiV3URL() {
        return this.baseApiV3URL;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getOAuthApiURL() {
        return this.oAuthApiURL;
    }

    public final boolean getPinCertificates() {
        return this.pinCertificates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.baseApiURL.hashCode() * 31) + this.baseApiV3URL.hashCode()) * 31) + this.oAuthApiURL.hashCode()) * 31) + this.clientId.hashCode()) * 31) + this.clientSecret.hashCode()) * 31) + this.apiVersion.hashCode()) * 31;
        boolean z = this.pinCertificates;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ConsumerNetworkConfig(baseApiURL=" + this.baseApiURL + ", baseApiV3URL=" + this.baseApiV3URL + ", oAuthApiURL=" + this.oAuthApiURL + ", clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ", apiVersion=" + this.apiVersion + ", pinCertificates=" + this.pinCertificates + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.baseApiURL);
        out.writeString(this.baseApiV3URL);
        out.writeString(this.oAuthApiURL);
        out.writeString(this.clientId);
        out.writeString(this.clientSecret);
        out.writeString(this.apiVersion);
        out.writeInt(this.pinCertificates ? 1 : 0);
    }

    public /* synthetic */ ConsumerNetworkConfig(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i2 & 64) != 0 ? true : z);
    }
}