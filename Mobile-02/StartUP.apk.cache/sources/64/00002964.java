package com.coinbase.wallet.wallets.dtos;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: GetCryptoExchangeRatesDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesDTO;)V", "", "Lcom/coinbase/wallet/wallets/dtos/GetCryptoPriceDTO;", "mapOfStringGetCryptoPriceDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetCryptoExchangeRatesDTOJsonAdapter extends JsonAdapter<GetCryptoExchangeRatesDTO> {
    private final JsonAdapter<Map<String, GetCryptoPriceDTO>> mapOfStringGetCryptoPriceDTOAdapter;
    private final JsonReader.Options options;

    public GetCryptoExchangeRatesDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("rates");
        m.f(of, "of(\"rates\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, String.class, GetCryptoPriceDTO.class);
        b2 = s0.b();
        JsonAdapter<Map<String, GetCryptoPriceDTO>> adapter = moshi.adapter(newParameterizedType, b2, "rates");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(Map::class.java, String::class.java,\n      GetCryptoPriceDTO::class.java), emptySet(), \"rates\")");
        this.mapOfStringGetCryptoPriceDTOAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(47);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetCryptoExchangeRatesDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetCryptoExchangeRatesDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Map<String, GetCryptoPriceDTO> map = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (map = this.mapOfStringGetCryptoPriceDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("rates", "rates", reader);
                m.f(unexpectedNull, "unexpectedNull(\"rates\", \"rates\", reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (map != null) {
            return new GetCryptoExchangeRatesDTO(map);
        }
        JsonDataException missingProperty = Util.missingProperty("rates", "rates", reader);
        m.f(missingProperty, "missingProperty(\"rates\", \"rates\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetCryptoExchangeRatesDTO getCryptoExchangeRatesDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getCryptoExchangeRatesDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("rates");
        this.mapOfStringGetCryptoPriceDTOAdapter.toJson(writer, (JsonWriter) getCryptoExchangeRatesDTO.getRates());
        writer.endObject();
    }
}