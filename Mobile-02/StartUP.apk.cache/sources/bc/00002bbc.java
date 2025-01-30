package com.coinbase.walletlink.dtos;

import android.net.Uri;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: Web3RequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013¨\u0006!"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestDTOJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/Web3RequestDTO;)V", "Lcom/coinbase/walletlink/dtos/Web3Request;", "web3RequestOfTNullableAnyAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Landroid/net/Uri;", "uriAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "", "Ljava/lang/reflect/Type;", "types", "<init>", "(Lcom/squareup/moshi/Moshi;[Ljava/lang/reflect/Type;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3RequestDTOJsonAdapter<T> extends JsonAdapter<Web3RequestDTO<T>> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<Uri> uriAdapter;
    private final JsonAdapter<Web3Request<T>> web3RequestOfTNullableAnyAdapter;

    public Web3RequestDTOJsonAdapter(Moshi moshi, Type[] types) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        m.g(types, "types");
        if (types.length == 1) {
            JsonReader.Options of = JsonReader.Options.of("id", "origin", "request");
            m.f(of, "of(\"id\", \"origin\", \"request\")");
            this.options = of;
            b2 = s0.b();
            JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
            m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
            this.stringAdapter = adapter;
            b3 = s0.b();
            JsonAdapter<Uri> adapter2 = moshi.adapter(Uri.class, b3, "origin");
            m.f(adapter2, "moshi.adapter(Uri::class.java, emptySet(), \"origin\")");
            this.uriAdapter = adapter2;
            ParameterizedType newParameterizedType = Types.newParameterizedType(Web3Request.class, types[0]);
            b4 = s0.b();
            JsonAdapter<Web3Request<T>> adapter3 = moshi.adapter(newParameterizedType, b4, "request");
            m.f(adapter3, "moshi.adapter(Types.newParameterizedType(Web3Request::class.java, types[0]), emptySet(),\n      \"request\")");
            this.web3RequestOfTNullableAnyAdapter = adapter3;
            return;
        }
        String str = "TypeVariable mismatch: Expecting 1 type for generic type variables [T], but received " + types.length;
        m.f(str, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalArgumentException(str.toString());
    }

    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
        toJson(jsonWriter, (Web3RequestDTO) ((Web3RequestDTO) obj));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Web3RequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Web3RequestDTO<T> fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        Uri uri = null;
        Web3Request<T> web3Request = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                uri = this.uriAdapter.fromJson(reader);
                if (uri == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("origin", "origin", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"origin\", \"origin\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (web3Request = this.web3RequestOfTNullableAnyAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("request", "request", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"request\", \"request\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
            m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (uri == null) {
            JsonDataException missingProperty2 = Util.missingProperty("origin", "origin", reader);
            m.f(missingProperty2, "missingProperty(\"origin\", \"origin\", reader)");
            throw missingProperty2;
        } else if (web3Request != null) {
            return new Web3RequestDTO<>(str, uri, web3Request);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("request", "request", reader);
            m.f(missingProperty3, "missingProperty(\"request\", \"request\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter writer, Web3RequestDTO<T> web3RequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(web3RequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) web3RequestDTO.getId());
        writer.name("origin");
        this.uriAdapter.toJson(writer, (JsonWriter) web3RequestDTO.getOrigin());
        writer.name("request");
        this.web3RequestOfTNullableAnyAdapter.toJson(writer, (JsonWriter) web3RequestDTO.getRequest());
        writer.endObject();
    }
}