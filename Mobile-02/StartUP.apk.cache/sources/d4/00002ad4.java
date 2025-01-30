package com.coinbase.walletengine.services.litecoin;

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
import kotlin.UInt;
import kotlin.a0.s0;

/* compiled from: TransactionResultJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/coinbase/walletengine/services/litecoin/TransactionResultJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/litecoin/TransactionResult;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/litecoin/TransactionResult;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/litecoin/TransactionResult;)V", "Lkotlin/UInt;", "nullableUIntAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/walletengine/services/litecoin/TransactionStatus;", "transactionStatusAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TransactionResultJsonAdapter extends JsonAdapter<TransactionResult> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<UInt> nullableUIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<TransactionStatus> transactionStatusAdapter;

    public TransactionResultJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("status", "blockNumber", "blockHash");
        kotlin.jvm.internal.m.f(of, "of(\"status\", \"blockNumber\",\n      \"blockHash\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<TransactionStatus> adapter = moshi.adapter(TransactionStatus.class, b2, "status");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(TransactionStatus::class.java, emptySet(), \"status\")");
        this.transactionStatusAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<UInt> adapter2 = moshi.adapter(UInt.class, b3, "blockNumber");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(UInt::class.java, emptySet(),\n      \"blockNumber\")");
        this.nullableUIntAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "blockHash");
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"blockHash\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(");
        sb.append("TransactionResult");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public TransactionResult fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        TransactionStatus transactionStatus = null;
        UInt uInt = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                transactionStatus = this.transactionStatusAdapter.fromJson(reader);
                if (transactionStatus == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("status", "status", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"status\", \"status\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                uInt = this.nullableUIntAdapter.fromJson(reader);
            } else if (selectName == 2) {
                str = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (transactionStatus != null) {
            return new TransactionResult(transactionStatus, uInt, str, null);
        }
        JsonDataException missingProperty = Util.missingProperty("status", "status", reader);
        kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"status\", \"status\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, TransactionResult transactionResult) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(transactionResult, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("status");
        this.transactionStatusAdapter.toJson(writer, (JsonWriter) transactionResult.getStatus());
        writer.name("blockNumber");
        this.nullableUIntAdapter.toJson(writer, (JsonWriter) transactionResult.m2064getBlockNumber0hXNFcg());
        writer.name("blockHash");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) transactionResult.getBlockHash());
        writer.endObject();
    }
}