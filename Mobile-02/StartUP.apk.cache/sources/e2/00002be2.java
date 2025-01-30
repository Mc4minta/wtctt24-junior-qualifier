package com.coinbase.walletlink.models;

import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Dapp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#B%\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b!\u0010\u0004¨\u0006%"}, d2 = {"Lcom/coinbase/walletlink/models/Dapp;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "component3", "Ljava/net/URL;", "component4", "()Ljava/net/URL;", "id", "url", ApiConstants.NAME, "logoURL", "copy", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/net/URL;)Lcom/coinbase/walletlink/models/Dapp;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Landroid/net/Uri;", "getUrl", "Ljava/net/URL;", "getLogoURL", "getId", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/net/URL;)V", "(Landroid/net/Uri;Ljava/lang/String;Ljava/net/URL;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Dapp implements DatabaseModelObject {
    private final String id;
    private final URL logoURL;
    private final String name;
    private final Uri url;

    public Dapp(String id, Uri url, String str, URL url2) {
        m.g(id, "id");
        m.g(url, "url");
        this.id = id;
        this.url = url;
        this.name = str;
        this.logoURL = url2;
    }

    public static /* synthetic */ Dapp copy$default(Dapp dapp, String str, Uri uri, String str2, URL url, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dapp.getId();
        }
        if ((i2 & 2) != 0) {
            uri = dapp.url;
        }
        if ((i2 & 4) != 0) {
            str2 = dapp.name;
        }
        if ((i2 & 8) != 0) {
            url = dapp.logoURL;
        }
        return dapp.copy(str, uri, str2, url);
    }

    public final String component1() {
        return getId();
    }

    public final Uri component2() {
        return this.url;
    }

    public final String component3() {
        return this.name;
    }

    public final URL component4() {
        return this.logoURL;
    }

    public final Dapp copy(String id, Uri url, String str, URL url2) {
        m.g(id, "id");
        m.g(url, "url");
        return new Dapp(id, url, str, url2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Dapp) {
            Dapp dapp = (Dapp) obj;
            return m.c(getId(), dapp.getId()) && m.c(this.url, dapp.url) && m.c(this.name, dapp.name) && m.c(this.logoURL, dapp.logoURL);
        }
        return false;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final URL getLogoURL() {
        return this.logoURL;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((getId().hashCode() * 31) + this.url.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        URL url = this.logoURL;
        return hashCode2 + (url != null ? url.hashCode() : 0);
    }

    public String toString() {
        return "Dapp(id=" + getId() + ", url=" + this.url + ", name=" + ((Object) this.name) + ", logoURL=" + this.logoURL + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Dapp(android.net.Uri r4, java.lang.String r5, java.net.URL r6) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = com.coinbase.walletlink.extensions.URI_WalletLinkKt.getDomain(r4)
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "US"
            kotlin.jvm.internal.m.f(r1, r2)
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r2)
            java.lang.String r0 = r0.toUpperCase(r1)
            java.lang.String r1 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.m.f(r0, r1)
            r3.<init>(r0, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.walletlink.models.Dapp.<init>(android.net.Uri, java.lang.String, java.net.URL):void");
    }
}