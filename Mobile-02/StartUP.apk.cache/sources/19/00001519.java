package com.coinbase.wallet.compoundfinance.dtos;

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

/* compiled from: CompoundExchangeRateResponseDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/dtos/CompoundExchangeRateResponseDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/compoundfinance/dtos/CompoundExchangeRateResponseDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/compoundfinance/dtos/CompoundExchangeRateResponseDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/compoundfinance/dtos/CompoundExchangeRateResponseDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompoundExchangeRateResponseDTOJsonAdapter extends JsonAdapter<CompoundExchangeRateResponseDTO> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CompoundExchangeRateResponseDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("jsonrpc", "id", "result");
        m.f(of, "of(\"jsonrpc\", \"id\", \"result\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "jsonrpc");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"jsonrpc\")");
        this.stringAdapter = adapter;
        Class cls = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls, b3, "id");
        m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(53);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CompoundExchangeRateResponseDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CompoundExchangeRateResponseDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        Integer num = null;
        String str2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("jsonrpc", "jsonrpc", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"jsonrpc\",\n            \"jsonrpc\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (str2 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("result", "result", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"result\",\n            \"result\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("jsonrpc", "jsonrpc", reader);
            m.f(missingProperty, "missingProperty(\"jsonrpc\", \"jsonrpc\", reader)");
            throw missingProperty;
        } else if (num != null) {
            int intValue = num.intValue();
            if (str2 != null) {
                return new CompoundExchangeRateResponseDTO(str, intValue, str2);
            }
            JsonDataException missingProperty2 = Util.missingProperty("result", "result", reader);
            m.f(missingProperty2, "missingProperty(\"result\", \"result\", reader)");
            throw missingProperty2;
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty3, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CompoundExchangeRateResponseDTO compoundExchangeRateResponseDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(compoundExchangeRateResponseDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("jsonrpc");
        this.stringAdapter.toJson(writer, (JsonWriter) compoundExchangeRateResponseDTO.getJsonrpc());
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(compoundExchangeRateResponseDTO.getId()));
        writer.name("result");
        this.stringAdapter.toJson(writer, (JsonWriter) compoundExchangeRateResponseDTO.getResult());
        writer.endObject();
    }
}