package com.coinbase.wallet.swap.models;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Aggregator.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/swap/models/Aggregator;", "", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/net/URL;", "component3", "()Ljava/net/URL;", "", "component4", "()Z", "id", ApiConstants.NAME, "url", "toSwapEnabled", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Z)Lcom/coinbase/wallet/swap/models/Aggregator;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Ljava/net/URL;", "getUrl", "getName", "Z", "getToSwapEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Z)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Aggregator {
    private final String id;
    private final String name;
    private final boolean toSwapEnabled;
    private final URL url;

    public Aggregator(String id, String name, URL url, boolean z) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(url, "url");
        this.id = id;
        this.name = name;
        this.url = url;
        this.toSwapEnabled = z;
    }

    public static /* synthetic */ Aggregator copy$default(Aggregator aggregator, String str, String str2, URL url, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aggregator.id;
        }
        if ((i2 & 2) != 0) {
            str2 = aggregator.name;
        }
        if ((i2 & 4) != 0) {
            url = aggregator.url;
        }
        if ((i2 & 8) != 0) {
            z = aggregator.toSwapEnabled;
        }
        return aggregator.copy(str, str2, url, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final URL component3() {
        return this.url;
    }

    public final boolean component4() {
        return this.toSwapEnabled;
    }

    public final Aggregator copy(String id, String name, URL url, boolean z) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(url, "url");
        return new Aggregator(id, name, url, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Aggregator) {
            Aggregator aggregator = (Aggregator) obj;
            return m.c(this.id, aggregator.id) && m.c(this.name, aggregator.name) && m.c(this.url, aggregator.url) && this.toSwapEnabled == aggregator.toSwapEnabled;
        }
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getToSwapEnabled() {
        return this.toSwapEnabled;
    }

    public final URL getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.url.hashCode()) * 31;
        boolean z = this.toSwapEnabled;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "Aggregator(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", toSwapEnabled=" + this.toSwapEnabled + ')';
    }
}