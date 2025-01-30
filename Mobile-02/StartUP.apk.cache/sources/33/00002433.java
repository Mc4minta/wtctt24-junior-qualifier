package com.coinbase.wallet.lending.dtos;

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

/* compiled from: OptionalRateDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/OptionalRateDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/lending/dtos/OptionalRateDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/lending/dtos/OptionalRateDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/lending/dtos/OptionalRateDTO;)V", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OptionalRateDTOJsonAdapter extends JsonAdapter<OptionalRateDTO> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public OptionalRateDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("isApplicable", "value");
        m.f(of, "of(\"isApplicable\", \"value\")");
        this.options = of;
        Class cls = Boolean.TYPE;
        b2 = s0.b();
        JsonAdapter<Boolean> adapter = moshi.adapter(cls, b2, "isApplicable");
        m.f(adapter, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"isApplicable\")");
        this.booleanAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "value");
        m.f(adapter2, "moshi.adapter(String::class.java,\n      emptySet(), \"value\")");
        this.nullableStringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("OptionalRateDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public OptionalRateDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("isApplicable", "isApplicable", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"isApplicable\", \"isApplicable\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (bool != null) {
            return new OptionalRateDTO(bool.booleanValue(), str);
        }
        JsonDataException missingProperty = Util.missingProperty("isApplicable", "isApplicable", reader);
        m.f(missingProperty, "missingProperty(\"isApplicable\", \"isApplicable\",\n            reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, OptionalRateDTO optionalRateDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(optionalRateDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("isApplicable");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(optionalRateDTO.isApplicable()));
        writer.name("value");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) optionalRateDTO.getValue());
        writer.endObject();
    }
}