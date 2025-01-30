package com.coinbase.wallet.consumer.models;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;

/* compiled from: ConsumerWebViewConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "proto", "baseUrl", ClientCookie.PORT_ATTR, "host", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProto", "getHost", "getBaseUrl", "Ljava/lang/Integer;", "getPort", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerWebViewConfig {
    private final String baseUrl;
    private final String host;
    private final Integer port;
    private final String proto;

    public ConsumerWebViewConfig(String proto, String baseUrl, Integer num, String host) {
        m.g(proto, "proto");
        m.g(baseUrl, "baseUrl");
        m.g(host, "host");
        this.proto = proto;
        this.baseUrl = baseUrl;
        this.port = num;
        this.host = host;
    }

    public static /* synthetic */ ConsumerWebViewConfig copy$default(ConsumerWebViewConfig consumerWebViewConfig, String str, String str2, Integer num, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerWebViewConfig.proto;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerWebViewConfig.baseUrl;
        }
        if ((i2 & 4) != 0) {
            num = consumerWebViewConfig.port;
        }
        if ((i2 & 8) != 0) {
            str3 = consumerWebViewConfig.host;
        }
        return consumerWebViewConfig.copy(str, str2, num, str3);
    }

    public final String component1() {
        return this.proto;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final Integer component3() {
        return this.port;
    }

    public final String component4() {
        return this.host;
    }

    public final ConsumerWebViewConfig copy(String proto, String baseUrl, Integer num, String host) {
        m.g(proto, "proto");
        m.g(baseUrl, "baseUrl");
        m.g(host, "host");
        return new ConsumerWebViewConfig(proto, baseUrl, num, host);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerWebViewConfig) {
            ConsumerWebViewConfig consumerWebViewConfig = (ConsumerWebViewConfig) obj;
            return m.c(this.proto, consumerWebViewConfig.proto) && m.c(this.baseUrl, consumerWebViewConfig.baseUrl) && m.c(this.port, consumerWebViewConfig.port) && m.c(this.host, consumerWebViewConfig.host);
        }
        return false;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getHost() {
        return this.host;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final String getProto() {
        return this.proto;
    }

    public int hashCode() {
        int hashCode = ((this.proto.hashCode() * 31) + this.baseUrl.hashCode()) * 31;
        Integer num = this.port;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.host.hashCode();
    }

    public String toString() {
        return "ConsumerWebViewConfig(proto=" + this.proto + ", baseUrl=" + this.baseUrl + ", port=" + this.port + ", host=" + this.host + ')';
    }

    public /* synthetic */ ConsumerWebViewConfig(String str, String str2, Integer num, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : num, str3);
    }
}