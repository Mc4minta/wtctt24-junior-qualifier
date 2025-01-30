package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: MakeEthereumJSONRPCRequestCallParamsJsonJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R$\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00140\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallParamsJsonJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallParamsJson;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallParamsJson;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallParamsJson;)V", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "", "", "listOfNullableAnyAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MakeEthereumJSONRPCRequestCallParamsJsonJsonAdapter extends JsonAdapter<MakeEthereumJSONRPCRequestCallParamsJson> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<Object>> listOfNullableAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MakeEthereumJSONRPCRequestCallParamsJsonJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("rpcMethod", "rpcParams", RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(of, "of(\"rpcMethod\", \"rpcParams\",\n      \"chainId\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "rpcMethod");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"rpcMethod\")");
        this.stringAdapter = adapter;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Object.class);
        b3 = s0.b();
        JsonAdapter<List<Object>> adapter2 = moshi.adapter(newParameterizedType, b3, "rpcParams");
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java, Any::class.java), emptySet(),\n      \"rpcParams\")");
        this.listOfNullableAnyAdapter = adapter2;
        Class cls = Integer.TYPE;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(cls, b4, RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(adapter3, "moshi.adapter(Int::class.java, emptySet(), \"chainId\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(62);
        sb.append("GeneratedJsonAdapter(");
        sb.append("MakeEthereumJSONRPCRequestCallParamsJson");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public MakeEthereumJSONRPCRequestCallParamsJson fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        List<Object> list = null;
        Integer num = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("rpcMethod", "rpcMethod", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"rpcMethod\",\n            \"rpcMethod\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list = this.listOfNullableAnyAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("rpcParams", "rpcParams", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"rpcParams\", \"rpcParams\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (num = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                m.f(unexpectedNull3, "unexpectedNull(\"chainId\",\n            \"chainId\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("rpcMethod", "rpcMethod", reader);
            m.f(missingProperty, "missingProperty(\"rpcMethod\", \"rpcMethod\", reader)");
            throw missingProperty;
        } else if (list == null) {
            JsonDataException missingProperty2 = Util.missingProperty("rpcParams", "rpcParams", reader);
            m.f(missingProperty2, "missingProperty(\"rpcParams\", \"rpcParams\", reader)");
            throw missingProperty2;
        } else if (num != null) {
            return new MakeEthereumJSONRPCRequestCallParamsJson(str, list, num.intValue());
        } else {
            JsonDataException missingProperty3 = Util.missingProperty(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
            m.f(missingProperty3, "missingProperty(\"chainId\", \"chainId\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, MakeEthereumJSONRPCRequestCallParamsJson makeEthereumJSONRPCRequestCallParamsJson) {
        m.g(writer, "writer");
        Objects.requireNonNull(makeEthereumJSONRPCRequestCallParamsJson, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("rpcMethod");
        this.stringAdapter.toJson(writer, (JsonWriter) makeEthereumJSONRPCRequestCallParamsJson.getRpcMethod());
        writer.name("rpcParams");
        this.listOfNullableAnyAdapter.toJson(writer, (JsonWriter) makeEthereumJSONRPCRequestCallParamsJson.getRpcParams());
        writer.name(RouteActionKey.RouteActionKeys.CHAIN_ID);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(makeEthereumJSONRPCRequestCallParamsJson.getChainId()));
        writer.endObject();
    }
}