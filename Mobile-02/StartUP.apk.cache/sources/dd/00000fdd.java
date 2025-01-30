package com.coinbase.ciphercore;

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

/* compiled from: SerializedEthereumTransactionReceiptJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coinbase/ciphercore/SerializedEthereumTransactionReceiptJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/ciphercore/SerializedEthereumTransactionReceipt;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/ciphercore/SerializedEthereumTransactionReceipt;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/ciphercore/SerializedEthereumTransactionReceipt;)V", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "intAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableStringAdapter", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SerializedEthereumTransactionReceiptJsonAdapter extends JsonAdapter<SerializedEthereumTransactionReceipt> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SerializedEthereumTransactionReceiptJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("isSuccessful", "blockNumber", "blockHash", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "gasUsed");
        kotlin.jvm.internal.m.f(of, "of(\"isSuccessful\", \"blockNumber\",\n      \"blockHash\", \"contractAddress\", \"gasUsed\")");
        this.options = of;
        Class cls = Boolean.TYPE;
        b2 = s0.b();
        JsonAdapter<Boolean> adapter = moshi.adapter(cls, b2, "isSuccessful");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"isSuccessful\")");
        this.booleanAdapter = adapter;
        Class cls2 = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls2, b3, "blockNumber");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(),\n      \"blockNumber\")");
        this.intAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "blockHash");
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(String::class.java, emptySet(),\n      \"blockHash\")");
        this.stringAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, b5, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        kotlin.jvm.internal.m.f(adapter4, "moshi.adapter(String::class.java,\n      emptySet(), \"contractAddress\")");
        this.nullableStringAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(58);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SerializedEthereumTransactionReceipt");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SerializedEthereumTransactionReceipt fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("isSuccessful", "isSuccessful", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"isSuccessful\", \"isSuccessful\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("blockNumber", "blockNumber", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"blockNumber\",\n            \"blockNumber\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("blockHash", "blockHash", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"blockHash\",\n            \"blockHash\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str2 = this.nullableStringAdapter.fromJson(reader);
            } else if (selectName == 4 && (str3 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("gasUsed", "gasUsed", reader);
                kotlin.jvm.internal.m.f(unexpectedNull4, "unexpectedNull(\"gasUsed\",\n            \"gasUsed\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (num != null) {
                int intValue = num.intValue();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("blockHash", "blockHash", reader);
                    kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"blockHash\", \"blockHash\", reader)");
                    throw missingProperty;
                } else if (str3 != null) {
                    return new SerializedEthereumTransactionReceipt(booleanValue, intValue, str, str2, str3);
                } else {
                    JsonDataException missingProperty2 = Util.missingProperty("gasUsed", "gasUsed", reader);
                    kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"gasUsed\", \"gasUsed\", reader)");
                    throw missingProperty2;
                }
            }
            JsonDataException missingProperty3 = Util.missingProperty("blockNumber", "blockNumber", reader);
            kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"blockNumber\", \"blockNumber\",\n            reader)");
            throw missingProperty3;
        }
        JsonDataException missingProperty4 = Util.missingProperty("isSuccessful", "isSuccessful", reader);
        kotlin.jvm.internal.m.f(missingProperty4, "missingProperty(\"isSuccessful\", \"isSuccessful\",\n            reader)");
        throw missingProperty4;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SerializedEthereumTransactionReceipt serializedEthereumTransactionReceipt) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(serializedEthereumTransactionReceipt, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("isSuccessful");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(serializedEthereumTransactionReceipt.isSuccessful()));
        writer.name("blockNumber");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(serializedEthereumTransactionReceipt.getBlockNumber()));
        writer.name("blockHash");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedEthereumTransactionReceipt.getBlockHash());
        writer.name(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) serializedEthereumTransactionReceipt.getContractAddress());
        writer.name("gasUsed");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedEthereumTransactionReceipt.getGasUsed());
        writer.endObject();
    }
}