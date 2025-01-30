package com.coinbase.cipherwebview.models;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CipherWebViewConfiguration.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/coinbase/cipherwebview/models/CipherWebViewConfiguration;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "appName", "appVersion", "address", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/cipherwebview/models/CipherWebViewConfiguration;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppVersion", "getAppName", "getAddress", "I", "getChainId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CipherWebViewConfiguration {
    public static final Companion Companion = new Companion(null);
    private static final CipherWebViewConfigurationJsonAdapter jsonAdapter;
    @Json(name = "address")
    private final String address;
    @Json(name = "appName")
    private final String appName;
    @Json(name = "appVersion")
    private final String appVersion;
    @Json(name = RouteActionKey.RouteActionKeys.CHAIN_ID)
    private final int chainId;

    /* compiled from: CipherWebViewConfiguration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/cipherwebview/models/CipherWebViewConfiguration$Companion;", "", "Lcom/coinbase/cipherwebview/models/CipherWebViewConfigurationJsonAdapter;", "jsonAdapter", "Lcom/coinbase/cipherwebview/models/CipherWebViewConfigurationJsonAdapter;", "getJsonAdapter$cipher_webview_release", "()Lcom/coinbase/cipherwebview/models/CipherWebViewConfigurationJsonAdapter;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CipherWebViewConfigurationJsonAdapter getJsonAdapter$cipher_webview_release() {
            return CipherWebViewConfiguration.jsonAdapter;
        }
    }

    static {
        Moshi moshi = MoshiKt.getMoshi();
        m.f(moshi, "moshi");
        jsonAdapter = new CipherWebViewConfigurationJsonAdapter(moshi);
    }

    public CipherWebViewConfiguration(String appName, String appVersion, String str, int i2) {
        m.g(appName, "appName");
        m.g(appVersion, "appVersion");
        this.appName = appName;
        this.appVersion = appVersion;
        this.address = str;
        this.chainId = i2;
    }

    public static /* synthetic */ CipherWebViewConfiguration copy$default(CipherWebViewConfiguration cipherWebViewConfiguration, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cipherWebViewConfiguration.appName;
        }
        if ((i3 & 2) != 0) {
            str2 = cipherWebViewConfiguration.appVersion;
        }
        if ((i3 & 4) != 0) {
            str3 = cipherWebViewConfiguration.address;
        }
        if ((i3 & 8) != 0) {
            i2 = cipherWebViewConfiguration.chainId;
        }
        return cipherWebViewConfiguration.copy(str, str2, str3, i2);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.appVersion;
    }

    public final String component3() {
        return this.address;
    }

    public final int component4() {
        return this.chainId;
    }

    public final CipherWebViewConfiguration copy(String appName, String appVersion, String str, int i2) {
        m.g(appName, "appName");
        m.g(appVersion, "appVersion");
        return new CipherWebViewConfiguration(appName, appVersion, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CipherWebViewConfiguration) {
            CipherWebViewConfiguration cipherWebViewConfiguration = (CipherWebViewConfiguration) obj;
            return m.c(this.appName, cipherWebViewConfiguration.appName) && m.c(this.appVersion, cipherWebViewConfiguration.appVersion) && m.c(this.address, cipherWebViewConfiguration.address) && this.chainId == cipherWebViewConfiguration.chainId;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public int hashCode() {
        int hashCode = ((this.appName.hashCode() * 31) + this.appVersion.hashCode()) * 31;
        String str = this.address;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.chainId;
    }

    public String toString() {
        return "CipherWebViewConfiguration(appName=" + this.appName + ", appVersion=" + this.appVersion + ", address=" + ((Object) this.address) + ", chainId=" + this.chainId + ')';
    }
}