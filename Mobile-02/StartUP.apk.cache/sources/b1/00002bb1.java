package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
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

/* compiled from: SignEthereumTransactionParamsJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/coinbase/walletlink/dtos/SignEthereumTransactionParamsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/SignEthereumTransactionParams;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/SignEthereumTransactionParams;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/SignEthereumTransactionParams;)V", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "", "booleanAdapter", "stringAdapter", "nullableIntAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignEthereumTransactionParamsJsonAdapter extends JsonAdapter<SignEthereumTransactionParams> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SignEthereumTransactionParamsJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "shouldSubmit");
        m.f(of, "of(\"fromAddress\", \"toAddress\",\n      \"weiValue\", \"data\", \"nonce\", \"gasPriceInWei\", \"maxFeePerGas\", \"maxPriorityFeePerGas\",\n      \"gasLimit\", \"chainId\", \"shouldSubmit\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "fromAddress");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"fromAddress\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "toAddress");
        m.f(adapter2, "moshi.adapter(String::class.java,\n      emptySet(), \"toAddress\")");
        this.nullableStringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.class, b4, AdjustableMinerFeeArgs.NONCE);
        m.f(adapter3, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"nonce\")");
        this.nullableIntAdapter = adapter3;
        Class cls = Integer.TYPE;
        b5 = s0.b();
        JsonAdapter<Integer> adapter4 = moshi.adapter(cls, b5, RouteActionKey.RouteActionKeys.CHAIN_ID);
        m.f(adapter4, "moshi.adapter(Int::class.java, emptySet(), \"chainId\")");
        this.intAdapter = adapter4;
        Class cls2 = Boolean.TYPE;
        b6 = s0.b();
        JsonAdapter<Boolean> adapter5 = moshi.adapter(cls2, b6, "shouldSubmit");
        m.f(adapter5, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"shouldSubmit\")");
        this.booleanAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(51);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SignEthereumTransactionParams");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SignEthereumTransactionParams fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        Boolean bool = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Integer num2 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (true) {
            String str9 = str8;
            String str10 = str7;
            String str11 = str6;
            String str12 = str5;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("fromAddress", "fromAddress", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"fromAddress\", \"fromAddress\", reader)");
                            throw unexpectedNull;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 1:
                        str2 = this.nullableStringAdapter.fromJson(reader);
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("weiValue", "weiValue", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"weiValue\",\n            \"weiValue\", reader)");
                            throw unexpectedNull2;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("data_", "data", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 4:
                        num2 = this.nullableIntAdapter.fromJson(reader);
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 5:
                        str5 = this.nullableStringAdapter.fromJson(reader);
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        continue;
                    case 6:
                        str6 = this.nullableStringAdapter.fromJson(reader);
                        str8 = str9;
                        str7 = str10;
                        break;
                    case 7:
                        str7 = this.nullableStringAdapter.fromJson(reader);
                        str8 = str9;
                        str6 = str11;
                        break;
                    case 8:
                        str8 = this.nullableStringAdapter.fromJson(reader);
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 9:
                        num = this.intAdapter.fromJson(reader);
                        if (num == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"chainId\",\n            \"chainId\", reader)");
                            throw unexpectedNull4;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    case 10:
                        bool = this.booleanAdapter.fromJson(reader);
                        if (bool == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("shouldSubmit", "shouldSubmit", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"shouldSubmit\", \"shouldSubmit\", reader)");
                            throw unexpectedNull5;
                        }
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                    default:
                        str8 = str9;
                        str7 = str10;
                        str6 = str11;
                        break;
                }
                str5 = str12;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("fromAddress", "fromAddress", reader);
                    m.f(missingProperty, "missingProperty(\"fromAddress\", \"fromAddress\",\n            reader)");
                    throw missingProperty;
                } else if (str3 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("weiValue", "weiValue", reader);
                    m.f(missingProperty2, "missingProperty(\"weiValue\", \"weiValue\", reader)");
                    throw missingProperty2;
                } else if (str4 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("data_", "data", reader);
                    m.f(missingProperty3, "missingProperty(\"data_\", \"data\", reader)");
                    throw missingProperty3;
                } else if (num != null) {
                    int intValue = num.intValue();
                    if (bool != null) {
                        return new SignEthereumTransactionParams(str, str2, str3, str4, num2, str12, str11, str10, str9, intValue, bool.booleanValue());
                    }
                    JsonDataException missingProperty4 = Util.missingProperty("shouldSubmit", "shouldSubmit", reader);
                    m.f(missingProperty4, "missingProperty(\"shouldSubmit\", \"shouldSubmit\",\n            reader)");
                    throw missingProperty4;
                } else {
                    JsonDataException missingProperty5 = Util.missingProperty(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                    m.f(missingProperty5, "missingProperty(\"chainId\", \"chainId\", reader)");
                    throw missingProperty5;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SignEthereumTransactionParams signEthereumTransactionParams) {
        m.g(writer, "writer");
        Objects.requireNonNull(signEthereumTransactionParams, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("fromAddress");
        this.stringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getFromAddress());
        writer.name("toAddress");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getToAddress());
        writer.name("weiValue");
        this.stringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getWeiValue());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getData());
        writer.name(AdjustableMinerFeeArgs.NONCE);
        this.nullableIntAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getNonce());
        writer.name("gasPriceInWei");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getGasPriceInWei());
        writer.name("maxFeePerGas");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getMaxFeePerGas());
        writer.name("maxPriorityFeePerGas");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getMaxPriorityFeePerGas());
        writer.name("gasLimit");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) signEthereumTransactionParams.getGasLimit());
        writer.name(RouteActionKey.RouteActionKeys.CHAIN_ID);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(signEthereumTransactionParams.getChainId()));
        writer.name("shouldSubmit");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(signEthereumTransactionParams.getShouldSubmit()));
        writer.endObject();
    }
}