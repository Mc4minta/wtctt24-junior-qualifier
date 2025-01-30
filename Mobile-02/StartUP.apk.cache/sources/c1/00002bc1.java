package com.coinbase.walletlink.dtos;

import com.appsflyer.internal.referrer.Payload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: Web3ResponseDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b \u0010!J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3ResponseDTOJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;)V", "Lcom/coinbase/walletlink/dtos/Web3Response;", "web3ResponseOfTNullableAnyAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "", "Ljava/lang/reflect/Type;", "types", "<init>", "(Lcom/squareup/moshi/Moshi;[Ljava/lang/reflect/Type;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3ResponseDTOJsonAdapter<T> extends JsonAdapter<Web3ResponseDTO<T>> {
    private volatile Constructor<Web3ResponseDTO<T>> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<Web3Response<T>> web3ResponseOfTNullableAnyAdapter;

    public Web3ResponseDTOJsonAdapter(Moshi moshi, Type[] types) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        m.g(types, "types");
        if (types.length == 1) {
            JsonReader.Options of = JsonReader.Options.of("type", "id", Payload.RESPONSE);
            m.f(of, "of(\"type\", \"id\", \"response\")");
            this.options = of;
            b2 = s0.b();
            JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "type");
            m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"type\")");
            this.stringAdapter = adapter;
            ParameterizedType newParameterizedType = Types.newParameterizedType(Web3Response.class, types[0]);
            b3 = s0.b();
            JsonAdapter<Web3Response<T>> adapter2 = moshi.adapter(newParameterizedType, b3, Payload.RESPONSE);
            m.f(adapter2, "moshi.adapter(Types.newParameterizedType(Web3Response::class.java, types[0]), emptySet(),\n      \"response\")");
            this.web3ResponseOfTNullableAnyAdapter = adapter2;
            return;
        }
        String str = "TypeVariable mismatch: Expecting 1 type for generic type variables [T], but received " + types.length;
        m.f(str, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalArgumentException(str.toString());
    }

    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
        toJson(jsonWriter, (Web3ResponseDTO) ((Web3ResponseDTO) obj));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Web3ResponseDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Web3ResponseDTO<T> fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str = null;
        String str2 = null;
        Web3Response<T> web3Response = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"type\", \"type\", reader)");
                    throw unexpectedNull;
                }
                i2 &= -2;
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (web3Response = this.web3ResponseOfTNullableAnyAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull(Payload.RESPONSE, Payload.RESPONSE, reader);
                m.f(unexpectedNull3, "unexpectedNull(\"response\", \"response\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (i2 == -2) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            } else if (web3Response != null) {
                return new Web3ResponseDTO<>(str, str2, web3Response);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty(Payload.RESPONSE, Payload.RESPONSE, reader);
                m.f(missingProperty2, "missingProperty(\"response\", \"response\", reader)");
                throw missingProperty2;
            }
        }
        Constructor<Web3ResponseDTO<T>> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = Web3ResponseDTO.class.getDeclaredConstructor(String.class, String.class, Web3Response.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            Objects.requireNonNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<com.coinbase.walletlink.dtos.Web3ResponseDTO<T of com.coinbase.walletlink.dtos.Web3ResponseDTOJsonAdapter>>");
            this.constructorRef = constructor;
        }
        Object[] objArr = new Object[5];
        objArr[0] = str;
        if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty3, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty3;
        }
        objArr[1] = str2;
        if (web3Response == null) {
            JsonDataException missingProperty4 = Util.missingProperty(Payload.RESPONSE, Payload.RESPONSE, reader);
            m.f(missingProperty4, "missingProperty(\"response\", \"response\", reader)");
            throw missingProperty4;
        }
        objArr[2] = web3Response;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = null;
        Web3ResponseDTO<T> newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          type,\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          response ?: throw Util.missingProperty(\"response\", \"response\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(JsonWriter writer, Web3ResponseDTO<T> web3ResponseDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(web3ResponseDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) web3ResponseDTO.getType());
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) web3ResponseDTO.getId());
        writer.name(Payload.RESPONSE);
        this.web3ResponseOfTNullableAnyAdapter.toJson(writer, (JsonWriter) web3ResponseDTO.getResponse());
        writer.endObject();
    }
}