package com.coinbase.walletengine.models;

import com.coinbase.wallet.qr.models.WalletConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: WalletEngineConfigJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006 "}, d2 = {"Lcom/coinbase/walletengine/models/WalletEngineConfigJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/WalletEngineConfig;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/models/WalletEngineConfig;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/models/WalletEngineConfig;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/walletengine/models/ResolverServiceConfig;", "resolverServiceConfigAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "bTCLikeServiceConfigAdapter", "Lcom/coinbase/walletengine/models/XRPServiceConfig;", "xRPServiceConfigAdapter", "Lcom/coinbase/walletengine/models/StellarServiceConfig;", "stellarServiceConfigAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletEngineConfigJsonAdapter extends JsonAdapter<WalletEngineConfig> {
    private final JsonAdapter<BTCLikeServiceConfig> bTCLikeServiceConfigAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<ResolverServiceConfig> resolverServiceConfigAdapter;
    private final JsonAdapter<StellarServiceConfig> stellarServiceConfigAdapter;
    private final JsonAdapter<XRPServiceConfig> xRPServiceConfigAdapter;

    public WalletEngineConfigJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("bitcoin", WalletConstants.URIPrefixes.BCH, "litecoin", "dogecoin", WalletConstants.URIPrefixes.XRP_ALT, WalletConstants.URIPrefixes.XLM_ALT, "resolver");
        m.f(of, "of(\"bitcoin\", \"bitcoincash\",\n      \"litecoin\", \"dogecoin\", \"xrp\", \"stellar\", \"resolver\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<BTCLikeServiceConfig> adapter = moshi.adapter(BTCLikeServiceConfig.class, b2, "bitcoin");
        m.f(adapter, "moshi.adapter(BTCLikeServiceConfig::class.java, emptySet(), \"bitcoin\")");
        this.bTCLikeServiceConfigAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<XRPServiceConfig> adapter2 = moshi.adapter(XRPServiceConfig.class, b3, WalletConstants.URIPrefixes.XRP_ALT);
        m.f(adapter2, "moshi.adapter(XRPServiceConfig::class.java, emptySet(), \"xrp\")");
        this.xRPServiceConfigAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<StellarServiceConfig> adapter3 = moshi.adapter(StellarServiceConfig.class, b4, WalletConstants.URIPrefixes.XLM_ALT);
        m.f(adapter3, "moshi.adapter(StellarServiceConfig::class.java, emptySet(), \"stellar\")");
        this.stellarServiceConfigAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<ResolverServiceConfig> adapter4 = moshi.adapter(ResolverServiceConfig.class, b5, "resolver");
        m.f(adapter4, "moshi.adapter(ResolverServiceConfig::class.java, emptySet(), \"resolver\")");
        this.resolverServiceConfigAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(");
        sb.append("WalletEngineConfig");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public WalletEngineConfig fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        BTCLikeServiceConfig bTCLikeServiceConfig = null;
        BTCLikeServiceConfig bTCLikeServiceConfig2 = null;
        BTCLikeServiceConfig bTCLikeServiceConfig3 = null;
        BTCLikeServiceConfig bTCLikeServiceConfig4 = null;
        XRPServiceConfig xRPServiceConfig = null;
        StellarServiceConfig stellarServiceConfig = null;
        ResolverServiceConfig resolverServiceConfig = null;
        while (true) {
            ResolverServiceConfig resolverServiceConfig2 = resolverServiceConfig;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        break;
                    case 0:
                        bTCLikeServiceConfig = this.bTCLikeServiceConfigAdapter.fromJson(reader);
                        if (bTCLikeServiceConfig == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("bitcoin", "bitcoin", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"bitcoin\", \"bitcoin\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        bTCLikeServiceConfig2 = this.bTCLikeServiceConfigAdapter.fromJson(reader);
                        if (bTCLikeServiceConfig2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull(WalletConstants.URIPrefixes.BCH, WalletConstants.URIPrefixes.BCH, reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"bitcoincash\", \"bitcoincash\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        bTCLikeServiceConfig3 = this.bTCLikeServiceConfigAdapter.fromJson(reader);
                        if (bTCLikeServiceConfig3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("litecoin", "litecoin", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"litecoin\", \"litecoin\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        bTCLikeServiceConfig4 = this.bTCLikeServiceConfigAdapter.fromJson(reader);
                        if (bTCLikeServiceConfig4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("dogecoin", "dogecoin", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"dogecoin\", \"dogecoin\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        xRPServiceConfig = this.xRPServiceConfigAdapter.fromJson(reader);
                        if (xRPServiceConfig == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull(WalletConstants.URIPrefixes.XRP_ALT, WalletConstants.URIPrefixes.XRP_ALT, reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"xrp\",\n            \"xrp\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        stellarServiceConfig = this.stellarServiceConfigAdapter.fromJson(reader);
                        if (stellarServiceConfig == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull(WalletConstants.URIPrefixes.XLM_ALT, WalletConstants.URIPrefixes.XLM_ALT, reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"stellar\", \"stellar\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        resolverServiceConfig = this.resolverServiceConfigAdapter.fromJson(reader);
                        if (resolverServiceConfig == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("resolver", "resolver", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"resolver\", \"resolver\", reader)");
                            throw unexpectedNull7;
                        }
                        continue;
                }
                resolverServiceConfig = resolverServiceConfig2;
            } else {
                reader.endObject();
                if (bTCLikeServiceConfig == null) {
                    JsonDataException missingProperty = Util.missingProperty("bitcoin", "bitcoin", reader);
                    m.f(missingProperty, "missingProperty(\"bitcoin\", \"bitcoin\", reader)");
                    throw missingProperty;
                } else if (bTCLikeServiceConfig2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty(WalletConstants.URIPrefixes.BCH, WalletConstants.URIPrefixes.BCH, reader);
                    m.f(missingProperty2, "missingProperty(\"bitcoincash\", \"bitcoincash\",\n            reader)");
                    throw missingProperty2;
                } else if (bTCLikeServiceConfig3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("litecoin", "litecoin", reader);
                    m.f(missingProperty3, "missingProperty(\"litecoin\", \"litecoin\", reader)");
                    throw missingProperty3;
                } else if (bTCLikeServiceConfig4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("dogecoin", "dogecoin", reader);
                    m.f(missingProperty4, "missingProperty(\"dogecoin\", \"dogecoin\", reader)");
                    throw missingProperty4;
                } else if (xRPServiceConfig == null) {
                    JsonDataException missingProperty5 = Util.missingProperty(WalletConstants.URIPrefixes.XRP_ALT, WalletConstants.URIPrefixes.XRP_ALT, reader);
                    m.f(missingProperty5, "missingProperty(\"xrp\", \"xrp\", reader)");
                    throw missingProperty5;
                } else if (stellarServiceConfig == null) {
                    JsonDataException missingProperty6 = Util.missingProperty(WalletConstants.URIPrefixes.XLM_ALT, WalletConstants.URIPrefixes.XLM_ALT, reader);
                    m.f(missingProperty6, "missingProperty(\"stellar\", \"stellar\", reader)");
                    throw missingProperty6;
                } else if (resolverServiceConfig2 != null) {
                    return new WalletEngineConfig(bTCLikeServiceConfig, bTCLikeServiceConfig2, bTCLikeServiceConfig3, bTCLikeServiceConfig4, xRPServiceConfig, stellarServiceConfig, resolverServiceConfig2);
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("resolver", "resolver", reader);
                    m.f(missingProperty7, "missingProperty(\"resolver\", \"resolver\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, WalletEngineConfig walletEngineConfig) {
        m.g(writer, "writer");
        Objects.requireNonNull(walletEngineConfig, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("bitcoin");
        this.bTCLikeServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getBitcoin());
        writer.name(WalletConstants.URIPrefixes.BCH);
        this.bTCLikeServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getBitcoincash());
        writer.name("litecoin");
        this.bTCLikeServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getLitecoin());
        writer.name("dogecoin");
        this.bTCLikeServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getDogecoin());
        writer.name(WalletConstants.URIPrefixes.XRP_ALT);
        this.xRPServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getXrp());
        writer.name(WalletConstants.URIPrefixes.XLM_ALT);
        this.stellarServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getStellar());
        writer.name("resolver");
        this.resolverServiceConfigAdapter.toJson(writer, (JsonWriter) walletEngineConfig.getResolver());
        writer.endObject();
    }
}