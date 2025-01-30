package com.coinbase.walletlink.dtos;

import com.coinbase.walletlink.models.RequestMethod;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: Web3ResponseJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006 "}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3ResponseJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/Web3Response;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/Web3Response;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/Web3Response;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/walletlink/models/RequestMethod;", "requestMethodAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "nullableTNullableAnyAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "", "Ljava/lang/reflect/Type;", "types", "<init>", "(Lcom/squareup/moshi/Moshi;[Ljava/lang/reflect/Type;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3ResponseJsonAdapter<T> extends JsonAdapter<Web3Response<T>> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<T> nullableTNullableAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<RequestMethod> requestMethodAdapter;

    public Web3ResponseJsonAdapter(Moshi moshi, Type[] types) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        m.g(types, "types");
        if (types.length == 1) {
            JsonReader.Options of = JsonReader.Options.of("method", "result", "errorMessage");
            m.f(of, "of(\"method\", \"result\",\n      \"errorMessage\")");
            this.options = of;
            b2 = s0.b();
            JsonAdapter<RequestMethod> adapter = moshi.adapter(RequestMethod.class, b2, "method");
            m.f(adapter, "moshi.adapter(RequestMethod::class.java, emptySet(), \"method\")");
            this.requestMethodAdapter = adapter;
            Type type = types[0];
            b3 = s0.b();
            JsonAdapter<T> adapter2 = moshi.adapter(type, b3, "result");
            m.f(adapter2, "moshi.adapter(types[0], emptySet(),\n      \"result\")");
            this.nullableTNullableAnyAdapter = adapter2;
            b4 = s0.b();
            JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "errorMessage");
            m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"errorMessage\")");
            this.nullableStringAdapter = adapter3;
            return;
        }
        String str = "TypeVariable mismatch: Expecting 1 type for generic type variables [T], but received " + types.length;
        m.f(str, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalArgumentException(str.toString());
    }

    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
        toJson(jsonWriter, (Web3Response) ((Web3Response) obj));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Web3Response");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Web3Response<T> fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        RequestMethod requestMethod = null;
        T t = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                requestMethod = this.requestMethodAdapter.fromJson(reader);
                if (requestMethod == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("method", "method", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"method\",\n            \"method\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                t = this.nullableTNullableAnyAdapter.fromJson(reader);
            } else if (selectName == 2) {
                str = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (requestMethod != null) {
            return new Web3Response<>(requestMethod, t, str);
        }
        JsonDataException missingProperty = Util.missingProperty("method", "method", reader);
        m.f(missingProperty, "missingProperty(\"method\", \"method\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter writer, Web3Response<T> web3Response) {
        m.g(writer, "writer");
        Objects.requireNonNull(web3Response, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("method");
        this.requestMethodAdapter.toJson(writer, (JsonWriter) web3Response.getMethod());
        writer.name("result");
        this.nullableTNullableAnyAdapter.toJson(writer, (JsonWriter) web3Response.getResult());
        writer.name("errorMessage");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) web3Response.getErrorMessage());
        writer.endObject();
    }
}