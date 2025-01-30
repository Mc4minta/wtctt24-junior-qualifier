package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.ApiConstants;
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

/* compiled from: SignEthereumMessageCallParamsJsonJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallParamsJsonJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallParamsJson;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallParamsJson;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallParamsJson;)V", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignEthereumMessageCallParamsJsonJsonAdapter extends JsonAdapter<SignEthereumMessageCallParamsJson> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SignEthereumMessageCallParamsJsonJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.MESSAGE, "address", "addPrefix", "typedDataJson");
        m.f(of, "of(\"message\", \"address\", \"addPrefix\",\n      \"typedDataJson\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.MESSAGE);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"message\")");
        this.stringAdapter = adapter;
        Class cls = Boolean.TYPE;
        b3 = s0.b();
        JsonAdapter<Boolean> adapter2 = moshi.adapter(cls, b3, "addPrefix");
        m.f(adapter2, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"addPrefix\")");
        this.booleanAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "typedDataJson");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"typedDataJson\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SignEthereumMessageCallParamsJson");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SignEthereumMessageCallParamsJson fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        Boolean bool = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"message\",\n            \"message\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("address", "address", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"address\",\n            \"address\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("addPrefix", "addPrefix", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"addPrefix\",\n            \"addPrefix\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
            m.f(missingProperty, "missingProperty(\"message\", \"message\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("address", "address", reader);
            m.f(missingProperty2, "missingProperty(\"address\", \"address\", reader)");
            throw missingProperty2;
        } else if (bool != null) {
            return new SignEthereumMessageCallParamsJson(str, str2, bool.booleanValue(), str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("addPrefix", "addPrefix", reader);
            m.f(missingProperty3, "missingProperty(\"addPrefix\", \"addPrefix\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SignEthereumMessageCallParamsJson signEthereumMessageCallParamsJson) {
        m.g(writer, "writer");
        Objects.requireNonNull(signEthereumMessageCallParamsJson, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.MESSAGE);
        this.stringAdapter.toJson(writer, (JsonWriter) signEthereumMessageCallParamsJson.getMessage());
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) signEthereumMessageCallParamsJson.getAddress());
        writer.name("addPrefix");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(signEthereumMessageCallParamsJson.getAddPrefix()));
        writer.name("typedDataJson");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) signEthereumMessageCallParamsJson.getTypedDataJson());
        writer.endObject();
    }
}