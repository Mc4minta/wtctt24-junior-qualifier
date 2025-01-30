package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
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

/* compiled from: ConsumerAssetDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTO;)V", "nullableStringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAssetDTOJsonAdapter extends JsonAdapter<ConsumerAssetDTO> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerAssetDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "symbol", ApiConstants.NAME, "color", "exponent", "image_url", "contract_address");
        m.f(of, "of(\"id\", \"symbol\", \"name\", \"color\",\n      \"exponent\", \"image_url\", \"contract_address\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        Class cls = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls, b3, "exponent");
        m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(), \"exponent\")");
        this.intAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"contractAddress\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerAssetDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerAssetDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (true) {
            String str7 = str6;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("symbol", "symbol", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"symbol\",\n            \"symbol\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"name\", \"name\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("color", "color", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"color\", \"color\",\n            reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        num = this.intAdapter.fromJson(reader);
                        if (num == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("exponent", "exponent", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"exponent\",\n            \"exponent\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("imageUrl", "image_url", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"imageUrl\",\n            \"image_url\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        str6 = this.nullableStringAdapter.fromJson(reader);
                        continue;
                }
                str6 = str7;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                    m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("symbol", "symbol", reader);
                    m.f(missingProperty2, "missingProperty(\"symbol\", \"symbol\", reader)");
                    throw missingProperty2;
                } else if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(missingProperty3, "missingProperty(\"name\", \"name\", reader)");
                    throw missingProperty3;
                } else if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("color", "color", reader);
                    m.f(missingProperty4, "missingProperty(\"color\", \"color\", reader)");
                    throw missingProperty4;
                } else if (num != null) {
                    int intValue = num.intValue();
                    if (str5 != null) {
                        return new ConsumerAssetDTO(str, str2, str3, str4, intValue, str5, str7);
                    }
                    JsonDataException missingProperty5 = Util.missingProperty("imageUrl", "image_url", reader);
                    m.f(missingProperty5, "missingProperty(\"imageUrl\", \"image_url\", reader)");
                    throw missingProperty5;
                } else {
                    JsonDataException missingProperty6 = Util.missingProperty("exponent", "exponent", reader);
                    m.f(missingProperty6, "missingProperty(\"exponent\", \"exponent\", reader)");
                    throw missingProperty6;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerAssetDTO consumerAssetDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerAssetDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAssetDTO.getId());
        writer.name("symbol");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAssetDTO.getSymbol());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAssetDTO.getName());
        writer.name("color");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAssetDTO.getColor());
        writer.name("exponent");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(consumerAssetDTO.getExponent()));
        writer.name("image_url");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAssetDTO.getImageUrl());
        writer.name("contract_address");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerAssetDTO.getContractAddress());
        writer.endObject();
    }
}