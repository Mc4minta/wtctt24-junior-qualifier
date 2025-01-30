package com.coinbase.ciphercore;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;

/* compiled from: EthereumConfigJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/ciphercore/EthereumConfigJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/ciphercore/EthereumConfig;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/ciphercore/EthereumConfig;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/ciphercore/EthereumConfig;)V", "", "", "Lcom/coinbase/ciphercore/EthereumNetworkConfig;", "mutableMapOfIntEthereumNetworkConfigAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumConfigJsonAdapter extends JsonAdapter<EthereumConfig> {
    private final JsonAdapter<Map<Integer, EthereumNetworkConfig>> mutableMapOfIntEthereumNetworkConfigAdapter;
    private final JsonReader.Options options;

    public EthereumConfigJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("networks");
        kotlin.jvm.internal.m.f(of, "of(\"networks\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, Integer.class, EthereumNetworkConfig.class);
        b2 = s0.b();
        JsonAdapter<Map<Integer, EthereumNetworkConfig>> adapter = moshi.adapter(newParameterizedType, b2, "networks");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(Types.newParameterizedType(MutableMap::class.java,\n      Int::class.javaObjectType, EthereumNetworkConfig::class.java), emptySet(), \"networks\")");
        this.mutableMapOfIntEthereumNetworkConfigAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("EthereumConfig");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public EthereumConfig fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        Map<Integer, EthereumNetworkConfig> map = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (map = this.mutableMapOfIntEthereumNetworkConfigAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("networks", "networks", reader);
                kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"networks\", \"networks\", reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (map != null) {
            return new EthereumConfig(map);
        }
        JsonDataException missingProperty = Util.missingProperty("networks", "networks", reader);
        kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"networks\", \"networks\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, EthereumConfig ethereumConfig) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(ethereumConfig, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("networks");
        this.mutableMapOfIntEthereumNetworkConfigAdapter.toJson(writer, (JsonWriter) ethereumConfig.getNetworks());
        writer.endObject();
    }
}