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

/* compiled from: Web3RequestJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/Web3Request;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/Web3Request;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/Web3Request;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "tNullableAnyAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/models/RequestMethod;", "requestMethodAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "", "Ljava/lang/reflect/Type;", "types", "<init>", "(Lcom/squareup/moshi/Moshi;[Ljava/lang/reflect/Type;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3RequestJsonAdapter<T> extends JsonAdapter<Web3Request<T>> {
    private final JsonReader.Options options;
    private final JsonAdapter<RequestMethod> requestMethodAdapter;
    private final JsonAdapter<T> tNullableAnyAdapter;

    public Web3RequestJsonAdapter(Moshi moshi, Type[] types) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        m.g(types, "types");
        if (types.length == 1) {
            JsonReader.Options of = JsonReader.Options.of("method", "params");
            m.f(of, "of(\"method\", \"params\")");
            this.options = of;
            b2 = s0.b();
            JsonAdapter<RequestMethod> adapter = moshi.adapter(RequestMethod.class, b2, "method");
            m.f(adapter, "moshi.adapter(RequestMethod::class.java, emptySet(), \"method\")");
            this.requestMethodAdapter = adapter;
            Type type = types[0];
            b3 = s0.b();
            JsonAdapter<T> adapter2 = moshi.adapter(type, b3, "params");
            m.f(adapter2, "moshi.adapter(types[0], emptySet(), \"params\")");
            this.tNullableAnyAdapter = adapter2;
            return;
        }
        String str = "TypeVariable mismatch: Expecting 1 type for generic type variables [T], but received " + types.length;
        m.f(str, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalArgumentException(str.toString());
    }

    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
        toJson(jsonWriter, (Web3Request) ((Web3Request) obj));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Web3Request");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Web3Request<T> fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        RequestMethod requestMethod = null;
        T t = null;
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
            } else if (selectName == 1 && (t = this.tNullableAnyAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("params", "params", reader);
                m.f(unexpectedNull2, "unexpectedNull(\"params\",\n            \"params\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (requestMethod == null) {
            JsonDataException missingProperty = Util.missingProperty("method", "method", reader);
            m.f(missingProperty, "missingProperty(\"method\", \"method\", reader)");
            throw missingProperty;
        } else if (t != null) {
            return new Web3Request<>(requestMethod, t);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("params", "params", reader);
            m.f(missingProperty2, "missingProperty(\"params\", \"params\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter writer, Web3Request<T> web3Request) {
        m.g(writer, "writer");
        Objects.requireNonNull(web3Request, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("method");
        this.requestMethodAdapter.toJson(writer, (JsonWriter) web3Request.getMethod());
        writer.name("params");
        this.tNullableAnyAdapter.toJson(writer, (JsonWriter) web3Request.getParams());
        writer.endObject();
    }
}