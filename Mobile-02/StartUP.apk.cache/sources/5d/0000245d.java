package com.coinbase.wallet.lending.models;

import com.appsflyer.AppsFlyerProperties;
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

/* compiled from: TxParamsJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/lending/models/TxParamsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/lending/models/TxParams;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/lending/models/TxParams;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/lending/models/TxParams;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableStringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxParamsJsonAdapter extends JsonAdapter<TxParams> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public TxParamsJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("lendTokenId", "toAddress", AppsFlyerProperties.CURRENCY_CODE, "weiValue", "transferValue", "data", "gasLimit", "gasPrice", "gasBaseFee", "gasPriorityFee");
        m.f(of, "of(\"lendTokenId\", \"toAddress\",\n      \"currencyCode\", \"weiValue\", \"transferValue\", \"data\", \"gasLimit\", \"gasPrice\", \"gasBaseFee\",\n      \"gasPriorityFee\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "lendTokenId");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"lendTokenId\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "toAddress");
        m.f(adapter2, "moshi.adapter(String::class.java,\n      emptySet(), \"toAddress\")");
        this.nullableStringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("GeneratedJsonAdapter(");
        sb.append("TxParams");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public TxParams fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        while (true) {
            String str11 = str2;
            String str12 = str10;
            String str13 = str9;
            String str14 = str8;
            String str15 = str7;
            String str16 = str6;
            String str17 = str5;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("lendTokenId", "lendTokenId", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"lendTokenId\", \"lendTokenId\", reader)");
                            throw unexpectedNull;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 1:
                        str2 = this.nullableStringAdapter.fromJson(reader);
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"currencyCode\", \"currencyCode\", reader)");
                            throw unexpectedNull2;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("weiValue", "weiValue", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"weiValue\",\n            \"weiValue\", reader)");
                            throw unexpectedNull3;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 4:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("transferValue", "transferValue", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"transferValue\", \"transferValue\", reader)");
                            throw unexpectedNull4;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        continue;
                    case 5:
                        str6 = this.stringAdapter.fromJson(reader);
                        if (str6 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("data_", "data", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        break;
                    case 6:
                        str7 = this.stringAdapter.fromJson(reader);
                        if (str7 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("gasLimit", "gasLimit", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"gasLimit\",\n            \"gasLimit\", reader)");
                            throw unexpectedNull6;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str6 = str16;
                        break;
                    case 7:
                        str8 = this.stringAdapter.fromJson(reader);
                        if (str8 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("gasPrice", "gasPrice", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"gasPrice\",\n            \"gasPrice\", reader)");
                            throw unexpectedNull7;
                        }
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 8:
                        str9 = this.stringAdapter.fromJson(reader);
                        if (str9 == null) {
                            JsonDataException unexpectedNull8 = Util.unexpectedNull("gasBaseFee", "gasBaseFee", reader);
                            m.f(unexpectedNull8, "unexpectedNull(\"gasBaseFee\",\n            \"gasBaseFee\", reader)");
                            throw unexpectedNull8;
                        }
                        str2 = str11;
                        str10 = str12;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    case 9:
                        str10 = this.stringAdapter.fromJson(reader);
                        if (str10 == null) {
                            JsonDataException unexpectedNull9 = Util.unexpectedNull("gasPriorityFee", "gasPriorityFee", reader);
                            m.f(unexpectedNull9, "unexpectedNull(\"gasPriorityFee\", \"gasPriorityFee\", reader)");
                            throw unexpectedNull9;
                        }
                        str2 = str11;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                    default:
                        str2 = str11;
                        str10 = str12;
                        str9 = str13;
                        str8 = str14;
                        str7 = str15;
                        str6 = str16;
                        break;
                }
                str5 = str17;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("lendTokenId", "lendTokenId", reader);
                    m.f(missingProperty, "missingProperty(\"lendTokenId\", \"lendTokenId\",\n            reader)");
                    throw missingProperty;
                } else if (str3 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
                    m.f(missingProperty2, "missingProperty(\"currencyCode\", \"currencyCode\",\n            reader)");
                    throw missingProperty2;
                } else if (str4 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("weiValue", "weiValue", reader);
                    m.f(missingProperty3, "missingProperty(\"weiValue\", \"weiValue\", reader)");
                    throw missingProperty3;
                } else if (str17 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("transferValue", "transferValue", reader);
                    m.f(missingProperty4, "missingProperty(\"transferValue\",\n            \"transferValue\", reader)");
                    throw missingProperty4;
                } else if (str16 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("data_", "data", reader);
                    m.f(missingProperty5, "missingProperty(\"data_\", \"data\", reader)");
                    throw missingProperty5;
                } else if (str15 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("gasLimit", "gasLimit", reader);
                    m.f(missingProperty6, "missingProperty(\"gasLimit\", \"gasLimit\", reader)");
                    throw missingProperty6;
                } else if (str14 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("gasPrice", "gasPrice", reader);
                    m.f(missingProperty7, "missingProperty(\"gasPrice\", \"gasPrice\", reader)");
                    throw missingProperty7;
                } else if (str13 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("gasBaseFee", "gasBaseFee", reader);
                    m.f(missingProperty8, "missingProperty(\"gasBaseFee\", \"gasBaseFee\", reader)");
                    throw missingProperty8;
                } else if (str12 != null) {
                    return new TxParams(str, str11, str3, str4, str17, str16, str15, str14, str13, str12);
                } else {
                    JsonDataException missingProperty9 = Util.missingProperty("gasPriorityFee", "gasPriorityFee", reader);
                    m.f(missingProperty9, "missingProperty(\"gasPriorityFee\",\n            \"gasPriorityFee\", reader)");
                    throw missingProperty9;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, TxParams txParams) {
        m.g(writer, "writer");
        Objects.requireNonNull(txParams, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("lendTokenId");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getLendTokenId());
        writer.name("toAddress");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) txParams.getToAddress());
        writer.name(AppsFlyerProperties.CURRENCY_CODE);
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getCurrencyCode());
        writer.name("weiValue");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getWeiValue());
        writer.name("transferValue");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getTransferValue());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getData());
        writer.name("gasLimit");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getGasLimit());
        writer.name("gasPrice");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getGasPrice());
        writer.name("gasBaseFee");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getGasBaseFee());
        writer.name("gasPriorityFee");
        this.stringAdapter.toJson(writer, (JsonWriter) txParams.getGasPriorityFee());
        writer.endObject();
    }
}