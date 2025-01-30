package com.coinbase.wallet.txhistory.dtos;

import com.coinbase.ApiConstants;
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
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: EtherscanApiResponseDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTOJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "listOfTNullableAnyAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "", "Ljava/lang/reflect/Type;", "types", "<init>", "(Lcom/squareup/moshi/Moshi;[Ljava/lang/reflect/Type;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EtherscanApiResponseDTOJsonAdapter<T> extends JsonAdapter<EtherscanApiResponseDTO<T>> {
    private final JsonAdapter<List<T>> listOfTNullableAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public EtherscanApiResponseDTOJsonAdapter(Moshi moshi, Type[] types) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        m.g(types, "types");
        if (types.length == 1) {
            JsonReader.Options of = JsonReader.Options.of("status", ApiConstants.MESSAGE, "result");
            m.f(of, "of(\"status\", \"message\", \"result\")");
            this.options = of;
            b2 = s0.b();
            JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "status");
            m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"status\")");
            this.stringAdapter = adapter;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, types[0]);
            b3 = s0.b();
            JsonAdapter<List<T>> adapter2 = moshi.adapter(newParameterizedType, b3, "result");
            m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java, types[0]), emptySet(), \"result\")");
            this.listOfTNullableAnyAdapter = adapter2;
            return;
        }
        String str = "TypeVariable mismatch: Expecting 1 type for generic type variables [T], but received " + types.length;
        m.f(str, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalArgumentException(str.toString());
    }

    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
        toJson(jsonWriter, (EtherscanApiResponseDTO) ((EtherscanApiResponseDTO) obj));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(45);
        sb.append("GeneratedJsonAdapter(");
        sb.append("EtherscanApiResponseDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public EtherscanApiResponseDTO<T> fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        List<T> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("status", "status", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"status\",\n            \"status\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"message\",\n            \"message\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (list = this.listOfTNullableAnyAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("result", "result", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"result\", \"result\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("status", "status", reader);
            m.f(missingProperty, "missingProperty(\"status\", \"status\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
            m.f(missingProperty2, "missingProperty(\"message\", \"message\", reader)");
            throw missingProperty2;
        } else if (list != null) {
            return new EtherscanApiResponseDTO<>(str, str2, list);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("result", "result", reader);
            m.f(missingProperty3, "missingProperty(\"result\", \"result\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter writer, EtherscanApiResponseDTO<T> etherscanApiResponseDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(etherscanApiResponseDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("status");
        this.stringAdapter.toJson(writer, (JsonWriter) etherscanApiResponseDTO.getStatus());
        writer.name(ApiConstants.MESSAGE);
        this.stringAdapter.toJson(writer, (JsonWriter) etherscanApiResponseDTO.getMessage());
        writer.name("result");
        this.listOfTNullableAnyAdapter.toJson(writer, (JsonWriter) etherscanApiResponseDTO.getResult());
        writer.endObject();
    }
}