package com.coinbase.ciphercore;

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

/* compiled from: SerializedParsedEthereumTransactionJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/coinbase/ciphercore/SerializedParsedEthereumTransactionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/ciphercore/SerializedParsedEthereumTransaction;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/ciphercore/SerializedParsedEthereumTransaction;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/ciphercore/SerializedParsedEthereumTransaction;)V", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SerializedParsedEthereumTransactionJsonAdapter extends JsonAdapter<SerializedParsedEthereumTransaction> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SerializedParsedEthereumTransactionJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "hash");
        kotlin.jvm.internal.m.f(of, "of(\"fromAddress\", \"toAddress\",\n      \"weiValue\", \"data\", \"nonce\", \"gasPriceInWei\", \"maxFeePerGas\", \"maxPriorityFeePerGas\",\n      \"gasLimit\", \"chainId\", \"hash\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "fromAddress");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"fromAddress\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "toAddress");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(String::class.java,\n      emptySet(), \"toAddress\")");
        this.nullableStringAdapter = adapter2;
        Class cls = Integer.TYPE;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(cls, b4, AdjustableMinerFeeArgs.NONCE);
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(Int::class.java, emptySet(), \"nonce\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(57);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SerializedParsedEthereumTransaction");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SerializedParsedEthereumTransaction fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        Integer num2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        while (true) {
            String str10 = str2;
            String str11 = str9;
            Integer num3 = num2;
            String str12 = str8;
            String str13 = str7;
            String str14 = str6;
            String str15 = str5;
            Integer num4 = num;
            String str16 = str4;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("fromAddress", "fromAddress", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"fromAddress\", \"fromAddress\", reader)");
                            throw unexpectedNull;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 1:
                        str2 = this.nullableStringAdapter.fromJson(reader);
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("weiValue", "weiValue", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"weiValue\",\n            \"weiValue\", reader)");
                            throw unexpectedNull2;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("data_", "data", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        continue;
                    case 4:
                        num = this.intAdapter.fromJson(reader);
                        if (num == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(AdjustableMinerFeeArgs.NONCE, AdjustableMinerFeeArgs.NONCE, reader);
                            kotlin.jvm.internal.m.f(unexpectedNull4, "unexpectedNull(\"nonce\", \"nonce\",\n            reader)");
                            throw unexpectedNull4;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        break;
                    case 5:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("gasPriceInWei", "gasPriceInWei", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull5, "unexpectedNull(\"gasPriceInWei\", \"gasPriceInWei\", reader)");
                            throw unexpectedNull5;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        num = num4;
                        break;
                    case 6:
                        str6 = this.stringAdapter.fromJson(reader);
                        if (str6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("maxFeePerGas", "maxFeePerGas", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull6, "unexpectedNull(\"maxFeePerGas\", \"maxFeePerGas\", reader)");
                            throw unexpectedNull6;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str5 = str15;
                        num = num4;
                        break;
                    case 7:
                        str7 = this.stringAdapter.fromJson(reader);
                        if (str7 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("maxPriorityFeePerGas", "maxPriorityFeePerGas", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull7, "unexpectedNull(\"maxPriorityFeePerGas\", \"maxPriorityFeePerGas\", reader)");
                            throw unexpectedNull7;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 8:
                        str8 = this.stringAdapter.fromJson(reader);
                        if (str8 == null) {
                            JsonDataException unexpectedNull8 = Util.unexpectedNull("gasLimit", "gasLimit", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull8, "unexpectedNull(\"gasLimit\",\n            \"gasLimit\", reader)");
                            throw unexpectedNull8;
                        }
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 9:
                        num2 = this.intAdapter.fromJson(reader);
                        if (num2 == null) {
                            JsonDataException unexpectedNull9 = Util.unexpectedNull(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                            kotlin.jvm.internal.m.f(unexpectedNull9, "unexpectedNull(\"chainId\",\n            \"chainId\", reader)");
                            throw unexpectedNull9;
                        }
                        str2 = str10;
                        str9 = str11;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    case 10:
                        str9 = this.stringAdapter.fromJson(reader);
                        if (str9 == null) {
                            JsonDataException unexpectedNull10 = Util.unexpectedNull("hash", "hash", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull10, "unexpectedNull(\"hash\", \"hash\",\n            reader)");
                            throw unexpectedNull10;
                        }
                        str2 = str10;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                    default:
                        str2 = str10;
                        str9 = str11;
                        num2 = num3;
                        str8 = str12;
                        str7 = str13;
                        str6 = str14;
                        str5 = str15;
                        num = num4;
                        break;
                }
                str4 = str16;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("fromAddress", "fromAddress", reader);
                    kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"fromAddress\", \"fromAddress\",\n            reader)");
                    throw missingProperty;
                } else if (str3 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("weiValue", "weiValue", reader);
                    kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"weiValue\", \"weiValue\", reader)");
                    throw missingProperty2;
                } else if (str16 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("data_", "data", reader);
                    kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"data_\", \"data\", reader)");
                    throw missingProperty3;
                } else if (num4 != null) {
                    int intValue = num4.intValue();
                    if (str15 == null) {
                        JsonDataException missingProperty4 = Util.missingProperty("gasPriceInWei", "gasPriceInWei", reader);
                        kotlin.jvm.internal.m.f(missingProperty4, "missingProperty(\"gasPriceInWei\",\n            \"gasPriceInWei\", reader)");
                        throw missingProperty4;
                    } else if (str14 == null) {
                        JsonDataException missingProperty5 = Util.missingProperty("maxFeePerGas", "maxFeePerGas", reader);
                        kotlin.jvm.internal.m.f(missingProperty5, "missingProperty(\"maxFeePerGas\", \"maxFeePerGas\",\n            reader)");
                        throw missingProperty5;
                    } else if (str13 == null) {
                        JsonDataException missingProperty6 = Util.missingProperty("maxPriorityFeePerGas", "maxPriorityFeePerGas", reader);
                        kotlin.jvm.internal.m.f(missingProperty6, "missingProperty(\"maxPriorityFeePerGas\", \"maxPriorityFeePerGas\", reader)");
                        throw missingProperty6;
                    } else if (str12 == null) {
                        JsonDataException missingProperty7 = Util.missingProperty("gasLimit", "gasLimit", reader);
                        kotlin.jvm.internal.m.f(missingProperty7, "missingProperty(\"gasLimit\", \"gasLimit\", reader)");
                        throw missingProperty7;
                    } else if (num3 != null) {
                        int intValue2 = num3.intValue();
                        if (str11 != null) {
                            return new SerializedParsedEthereumTransaction(str, str10, str3, str16, intValue, str15, str14, str13, str12, intValue2, str11);
                        }
                        JsonDataException missingProperty8 = Util.missingProperty("hash", "hash", reader);
                        kotlin.jvm.internal.m.f(missingProperty8, "missingProperty(\"hash\", \"hash\", reader)");
                        throw missingProperty8;
                    } else {
                        JsonDataException missingProperty9 = Util.missingProperty(RouteActionKey.RouteActionKeys.CHAIN_ID, RouteActionKey.RouteActionKeys.CHAIN_ID, reader);
                        kotlin.jvm.internal.m.f(missingProperty9, "missingProperty(\"chainId\", \"chainId\", reader)");
                        throw missingProperty9;
                    }
                } else {
                    JsonDataException missingProperty10 = Util.missingProperty(AdjustableMinerFeeArgs.NONCE, AdjustableMinerFeeArgs.NONCE, reader);
                    kotlin.jvm.internal.m.f(missingProperty10, "missingProperty(\"nonce\", \"nonce\", reader)");
                    throw missingProperty10;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SerializedParsedEthereumTransaction serializedParsedEthereumTransaction) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(serializedParsedEthereumTransaction, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("fromAddress");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getFromAddress());
        writer.name("toAddress");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getToAddress());
        writer.name("weiValue");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getWeiValue());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getData());
        writer.name(AdjustableMinerFeeArgs.NONCE);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(serializedParsedEthereumTransaction.getNonce()));
        writer.name("gasPriceInWei");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getGasPriceInWei());
        writer.name("maxFeePerGas");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getMaxFeePerGas());
        writer.name("maxPriorityFeePerGas");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getMaxPriorityFeePerGas());
        writer.name("gasLimit");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getGasLimit());
        writer.name(RouteActionKey.RouteActionKeys.CHAIN_ID);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(serializedParsedEthereumTransaction.getChainId()));
        writer.name("hash");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedParsedEthereumTransaction.getHash());
        writer.endObject();
    }
}