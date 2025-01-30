package com.coinbase.wallet.wallets.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
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

/* compiled from: FiatCurrencyJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/wallets/models/FiatCurrencyJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/wallets/models/FiatCurrency;)V", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodeAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "intAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiatCurrencyJsonAdapter extends JsonAdapter<FiatCurrency> {
    private final JsonAdapter<CurrencyCode> currencyCodeAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public FiatCurrencyJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "code", ApiConstants.NAME, "decimals");
        m.f(of, "of(\"id\", \"code\", \"name\", \"decimals\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<CurrencyCode> adapter2 = moshi.adapter(CurrencyCode.class, b3, "code");
        m.f(adapter2, "moshi.adapter(CurrencyCode::class.java, emptySet(), \"code\")");
        this.currencyCodeAdapter = adapter2;
        Class cls = Integer.TYPE;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(cls, b4, "decimals");
        m.f(adapter3, "moshi.adapter(Int::class.java, emptySet(), \"decimals\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("FiatCurrency");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public FiatCurrency fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        CurrencyCode currencyCode = null;
        String str2 = null;
        Integer num = null;
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
                currencyCode = this.currencyCodeAdapter.fromJson(reader);
                if (currencyCode == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("code", "code", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"code\",\n            \"code\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (num = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("decimals", "decimals", reader);
                m.f(unexpectedNull4, "unexpectedNull(\"decimals\",\n            \"decimals\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
            m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (currencyCode == null) {
            JsonDataException missingProperty2 = Util.missingProperty("code", "code", reader);
            m.f(missingProperty2, "missingProperty(\"code\", \"code\", reader)");
            throw missingProperty2;
        } else if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            m.f(missingProperty3, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty3;
        } else if (num != null) {
            return new FiatCurrency(str, currencyCode, str2, num.intValue());
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("decimals", "decimals", reader);
            m.f(missingProperty4, "missingProperty(\"decimals\", \"decimals\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, FiatCurrency fiatCurrency) {
        m.g(writer, "writer");
        Objects.requireNonNull(fiatCurrency, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) fiatCurrency.getId());
        writer.name("code");
        this.currencyCodeAdapter.toJson(writer, (JsonWriter) fiatCurrency.getCode());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) fiatCurrency.getName());
        writer.name("decimals");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(fiatCurrency.getDecimals()));
        writer.endObject();
    }
}