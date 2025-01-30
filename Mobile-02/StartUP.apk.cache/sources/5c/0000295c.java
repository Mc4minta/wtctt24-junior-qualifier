package com.coinbase.wallet.wallets.dtos;

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

/* compiled from: CryptoCurrencyElementDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/CryptoCurrencyElementDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/wallets/dtos/CryptoCurrencyElementDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/wallets/dtos/CryptoCurrencyElementDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/wallets/dtos/CryptoCurrencyElementDTO;)V", "nullableStringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "doubleAdapter", "", "intAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CryptoCurrencyElementDTOJsonAdapter extends JsonAdapter<CryptoCurrencyElementDTO> {
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CryptoCurrencyElementDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.NAME, "code", "imageUrl", "decimals", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "marketCap");
        m.f(of, "of(\"name\", \"code\", \"imageUrl\",\n      \"decimals\", \"blockchain\", \"marketCap\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.NAME);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"name\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "imageUrl");
        m.f(adapter2, "moshi.adapter(String::class.java,\n      emptySet(), \"imageUrl\")");
        this.nullableStringAdapter = adapter2;
        Class cls = Integer.TYPE;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(cls, b4, "decimals");
        m.f(adapter3, "moshi.adapter(Int::class.java, emptySet(), \"decimals\")");
        this.intAdapter = adapter3;
        Class cls2 = Double.TYPE;
        b5 = s0.b();
        JsonAdapter<Double> adapter4 = moshi.adapter(cls2, b5, "marketCap");
        m.f(adapter4, "moshi.adapter(Double::class.java, emptySet(),\n      \"marketCap\")");
        this.doubleAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(46);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CryptoCurrencyElementDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CryptoCurrencyElementDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        Double d2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                        m.f(unexpectedNull, "unexpectedNull(\"name\", \"name\",\n            reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("code", "code", reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"code\", \"code\",\n            reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    str3 = this.nullableStringAdapter.fromJson(reader);
                    break;
                case 3:
                    num = this.intAdapter.fromJson(reader);
                    if (num == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("decimals", "decimals", reader);
                        m.f(unexpectedNull3, "unexpectedNull(\"decimals\",\n            \"decimals\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 4:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.BLOCKCHAIN, RouteActionKey.RouteActionKeys.BLOCKCHAIN, reader);
                        m.f(unexpectedNull4, "unexpectedNull(\"blockchain\",\n            \"blockchain\", reader)");
                        throw unexpectedNull4;
                    }
                    break;
                case 5:
                    d2 = this.doubleAdapter.fromJson(reader);
                    if (d2 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("marketCap", "marketCap", reader);
                        m.f(unexpectedNull5, "unexpectedNull(\"marketCap\",\n            \"marketCap\", reader)");
                        throw unexpectedNull5;
                    }
                    break;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            m.f(missingProperty, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("code", "code", reader);
            m.f(missingProperty2, "missingProperty(\"code\", \"code\", reader)");
            throw missingProperty2;
        } else if (num != null) {
            int intValue = num.intValue();
            if (str4 == null) {
                JsonDataException missingProperty3 = Util.missingProperty(RouteActionKey.RouteActionKeys.BLOCKCHAIN, RouteActionKey.RouteActionKeys.BLOCKCHAIN, reader);
                m.f(missingProperty3, "missingProperty(\"blockchain\", \"blockchain\", reader)");
                throw missingProperty3;
            } else if (d2 != null) {
                return new CryptoCurrencyElementDTO(str, str2, str3, intValue, str4, d2.doubleValue());
            } else {
                JsonDataException missingProperty4 = Util.missingProperty("marketCap", "marketCap", reader);
                m.f(missingProperty4, "missingProperty(\"marketCap\", \"marketCap\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("decimals", "decimals", reader);
            m.f(missingProperty5, "missingProperty(\"decimals\", \"decimals\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CryptoCurrencyElementDTO cryptoCurrencyElementDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(cryptoCurrencyElementDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) cryptoCurrencyElementDTO.getName());
        writer.name("code");
        this.stringAdapter.toJson(writer, (JsonWriter) cryptoCurrencyElementDTO.getCode());
        writer.name("imageUrl");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) cryptoCurrencyElementDTO.getImageUrl());
        writer.name("decimals");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(cryptoCurrencyElementDTO.getDecimals()));
        writer.name(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        this.stringAdapter.toJson(writer, (JsonWriter) cryptoCurrencyElementDTO.getBlockchain());
        writer.name("marketCap");
        this.doubleAdapter.toJson(writer, (JsonWriter) Double.valueOf(cryptoCurrencyElementDTO.getMarketCap()));
        writer.endObject();
    }
}