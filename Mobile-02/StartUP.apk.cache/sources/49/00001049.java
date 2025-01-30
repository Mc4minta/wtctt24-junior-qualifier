package com.coinbase.cipherwebview.models.web3.json;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: EthereumAddressFromSignedMessageCallJsonJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006 "}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJsonJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;)V", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "intAdapter", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;", "ethereumAddressFromSignedMessageCallParamsJsonAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumAddressFromSignedMessageCallJsonJsonAdapter extends JsonAdapter<EthereumAddressFromSignedMessageCallJson> {
    private volatile Constructor<EthereumAddressFromSignedMessageCallJson> constructorRef;
    private final JsonAdapter<EthereumAddressFromSignedMessageCallParamsJson> ethereumAddressFromSignedMessageCallParamsJsonAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public EthereumAddressFromSignedMessageCallJsonJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "method", "params");
        m.f(of, "of(\"id\", \"method\", \"params\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "id");
        m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "method");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"method\")");
        this.stringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<EthereumAddressFromSignedMessageCallParamsJson> adapter3 = moshi.adapter(EthereumAddressFromSignedMessageCallParamsJson.class, b4, "params");
        m.f(adapter3, "moshi.adapter(EthereumAddressFromSignedMessageCallParamsJson::class.java, emptySet(),\n      \"params\")");
        this.ethereumAddressFromSignedMessageCallParamsJsonAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(62);
        sb.append("GeneratedJsonAdapter(");
        sb.append("EthereumAddressFromSignedMessageCallJson");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public EthereumAddressFromSignedMessageCallJson fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        Integer num = null;
        String str = null;
        EthereumAddressFromSignedMessageCallParamsJson ethereumAddressFromSignedMessageCallParamsJson = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("method", "method", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"method\", \"method\",\n              reader)");
                    throw unexpectedNull2;
                }
                i2 &= -3;
            } else if (selectName == 2 && (ethereumAddressFromSignedMessageCallParamsJson = this.ethereumAddressFromSignedMessageCallParamsJsonAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("params", "params", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"params\", \"params\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (i2 == -3) {
            if (num != null) {
                int intValue = num.intValue();
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
                if (ethereumAddressFromSignedMessageCallParamsJson != null) {
                    return new EthereumAddressFromSignedMessageCallJson(intValue, str, ethereumAddressFromSignedMessageCallParamsJson);
                }
                JsonDataException missingProperty = Util.missingProperty("params", "params", reader);
                m.f(missingProperty, "missingProperty(\"params\", \"params\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty2, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty2;
        }
        Constructor<EthereumAddressFromSignedMessageCallJson> constructor = this.constructorRef;
        if (constructor == null) {
            Class cls = Integer.TYPE;
            constructor = EthereumAddressFromSignedMessageCallJson.class.getDeclaredConstructor(cls, String.class, EthereumAddressFromSignedMessageCallParamsJson.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "EthereumAddressFromSignedMessageCallJson::class.java.getDeclaredConstructor(Int::class.javaPrimitiveType,\n          String::class.java, EthereumAddressFromSignedMessageCallParamsJson::class.java,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        if (num != null) {
            objArr[0] = Integer.valueOf(num.intValue());
            objArr[1] = str;
            if (ethereumAddressFromSignedMessageCallParamsJson == null) {
                JsonDataException missingProperty3 = Util.missingProperty("params", "params", reader);
                m.f(missingProperty3, "missingProperty(\"params\", \"params\", reader)");
                throw missingProperty3;
            }
            objArr[2] = ethereumAddressFromSignedMessageCallParamsJson;
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = null;
            EthereumAddressFromSignedMessageCallJson newInstance = constructor.newInstance(objArr);
            m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          method,\n          params ?: throw Util.missingProperty(\"params\", \"params\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
            return newInstance;
        }
        JsonDataException missingProperty4 = Util.missingProperty("id", "id", reader);
        m.f(missingProperty4, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty4;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, EthereumAddressFromSignedMessageCallJson ethereumAddressFromSignedMessageCallJson) {
        m.g(writer, "writer");
        Objects.requireNonNull(ethereumAddressFromSignedMessageCallJson, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(ethereumAddressFromSignedMessageCallJson.getId()));
        writer.name("method");
        this.stringAdapter.toJson(writer, (JsonWriter) ethereumAddressFromSignedMessageCallJson.getMethod());
        writer.name("params");
        this.ethereumAddressFromSignedMessageCallParamsJsonAdapter.toJson(writer, (JsonWriter) ethereumAddressFromSignedMessageCallJson.getParams());
        writer.endObject();
    }
}