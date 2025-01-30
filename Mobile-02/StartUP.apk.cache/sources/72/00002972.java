package com.coinbase.wallet.wallets.dtos;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: GetL2CryptoPriceDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "intAdapter", "nullableStringAdapter", "Ljava/math/BigDecimal;", "bigDecimalAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetL2CryptoPriceDTOJsonAdapter extends JsonAdapter<GetL2CryptoPriceDTO> {
    private final JsonAdapter<BigDecimal> bigDecimalAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GetL2CryptoPriceDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.PRICE, "symbol", ApiConstants.NAME, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(of, "of(\"price\", \"symbol\", \"name\",\n      \"contractAddress\", \"chainId\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<BigDecimal> adapter = moshi.adapter(BigDecimal.class, b2, ApiConstants.PRICE);
        m.f(adapter, "moshi.adapter(BigDecimal::class.java,\n      emptySet(), \"price\")");
        this.bigDecimalAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, AppsFlyerProperties.CURRENCY_CODE);
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"currencyCode\")");
        this.stringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"contractAddress\")");
        this.nullableStringAdapter = adapter3;
        Class cls = Integer.TYPE;
        b5 = s0.b();
        JsonAdapter<Integer> adapter4 = moshi.adapter(cls, b5, RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(adapter4, "moshi.adapter(Int::class.java, emptySet(), \"chainId\")");
        this.intAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(");
        sb.append("GetL2CryptoPriceDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GetL2CryptoPriceDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        BigDecimal bigDecimal = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bigDecimal = this.bigDecimalAdapter.fromJson(reader);
                if (bigDecimal == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.PRICE, ApiConstants.PRICE, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"price\",\n            \"price\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(AppsFlyerProperties.CURRENCY_CODE, "symbol", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"currencyCode\", \"symbol\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(reader);
            } else if (selectName == 4 && (num = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                m.f(unexpectedNull4, "unexpectedNull(\"chainId\",\n            \"chainId\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (bigDecimal == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.PRICE, ApiConstants.PRICE, reader);
            m.f(missingProperty, "missingProperty(\"price\", \"price\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty(AppsFlyerProperties.CURRENCY_CODE, "symbol", reader);
            m.f(missingProperty2, "missingProperty(\"currencyCode\", \"symbol\", reader)");
            throw missingProperty2;
        } else if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            m.f(missingProperty3, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty3;
        } else if (num != null) {
            return new GetL2CryptoPriceDTO(bigDecimal, str, str2, str3, num.intValue());
        } else {
            JsonDataException missingProperty4 = Util.missingProperty(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
            m.f(missingProperty4, "missingProperty(\"chainId\", \"chainId\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GetL2CryptoPriceDTO getL2CryptoPriceDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(getL2CryptoPriceDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.PRICE);
        this.bigDecimalAdapter.toJson(writer, (JsonWriter) getL2CryptoPriceDTO.getPrice());
        writer.name("symbol");
        this.stringAdapter.toJson(writer, (JsonWriter) getL2CryptoPriceDTO.getCurrencyCode());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) getL2CryptoPriceDTO.getName());
        writer.name(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) getL2CryptoPriceDTO.getContractAddress());
        writer.name(RouteActionKey.RouteActionKeys.CHAIN_ID);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(getL2CryptoPriceDTO.getChainId()));
        writer.endObject();
    }
}