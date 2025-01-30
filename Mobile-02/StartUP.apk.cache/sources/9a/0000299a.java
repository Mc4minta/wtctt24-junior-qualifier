package com.coinbase.wallet.wallets.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
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

/* compiled from: ExchangeRateJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/wallets/models/ExchangeRateJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/wallets/models/ExchangeRate;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/math/BigDecimal;", "bigDecimalAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "", "nullableIntAdapter", "nullableStringAdapter", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodeAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ExchangeRateJsonAdapter extends JsonAdapter<ExchangeRate> {
    private final JsonAdapter<BigDecimal> bigDecimalAdapter;
    private final JsonAdapter<CurrencyCode> currencyCodeAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ExchangeRateJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", AppsFlyerProperties.CURRENCY_CODE, "rate", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID, ApiConstants.NAME);
        m.f(of, "of(\"id\", \"currencyCode\", \"rate\",\n      \"contractAddress\", \"chainId\", \"name\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<CurrencyCode> adapter2 = moshi.adapter(CurrencyCode.class, b3, AppsFlyerProperties.CURRENCY_CODE);
        m.f(adapter2, "moshi.adapter(CurrencyCode::class.java, emptySet(), \"currencyCode\")");
        this.currencyCodeAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<BigDecimal> adapter3 = moshi.adapter(BigDecimal.class, b4, "rate");
        m.f(adapter3, "moshi.adapter(BigDecimal::class.java,\n      emptySet(), \"rate\")");
        this.bigDecimalAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, b5, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        m.f(adapter4, "moshi.adapter(String::class.java,\n      emptySet(), \"contractAddress\")");
        this.nullableStringAdapter = adapter4;
        b6 = s0.b();
        JsonAdapter<Integer> adapter5 = moshi.adapter(Integer.class, b6, RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(adapter5, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"chainId\")");
        this.nullableIntAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ExchangeRate");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ExchangeRate fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        CurrencyCode currencyCode = null;
        BigDecimal bigDecimal = null;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        while (reader.hasNext()) {
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
                    currencyCode = this.currencyCodeAdapter.fromJson(reader);
                    if (currencyCode == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"currencyCode\", \"currencyCode\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    bigDecimal = this.bigDecimalAdapter.fromJson(reader);
                    if (bigDecimal == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("rate", "rate", reader);
                        m.f(unexpectedNull3, "unexpectedNull(\"rate\", \"rate\",\n            reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    str2 = this.nullableStringAdapter.fromJson(reader);
                    break;
                case 4:
                    num = this.nullableIntAdapter.fromJson(reader);
                    break;
                case 5:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                        m.f(unexpectedNull4, "unexpectedNull(\"name\", \"name\",\n            reader)");
                        throw unexpectedNull4;
                    }
                    break;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
            m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (currencyCode == null) {
            JsonDataException missingProperty2 = Util.missingProperty(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
            m.f(missingProperty2, "missingProperty(\"currencyCode\", \"currencyCode\",\n            reader)");
            throw missingProperty2;
        } else if (bigDecimal == null) {
            JsonDataException missingProperty3 = Util.missingProperty("rate", "rate", reader);
            m.f(missingProperty3, "missingProperty(\"rate\", \"rate\", reader)");
            throw missingProperty3;
        } else if (str3 != null) {
            return new ExchangeRate(str, currencyCode, bigDecimal, str2, num, str3);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            m.f(missingProperty4, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ExchangeRate exchangeRate) {
        m.g(writer, "writer");
        Objects.requireNonNull(exchangeRate, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) exchangeRate.getId());
        writer.name(AppsFlyerProperties.CURRENCY_CODE);
        this.currencyCodeAdapter.toJson(writer, (JsonWriter) exchangeRate.getCurrencyCode());
        writer.name("rate");
        this.bigDecimalAdapter.toJson(writer, (JsonWriter) exchangeRate.getRate());
        writer.name(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) exchangeRate.getContractAddress());
        writer.name(RouteActionKey.RouteActionKeys.CHAIN_ID);
        this.nullableIntAdapter.toJson(writer, (JsonWriter) exchangeRate.getChainId());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) exchangeRate.getName());
        writer.endObject();
    }
}