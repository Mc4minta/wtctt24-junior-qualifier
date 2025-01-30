package com.coinbase.walletengine.services.xrp;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: TransactionJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/TransactionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/xrp/Transaction;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/xrp/Transaction;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/xrp/Transaction;)V", "Lkotlin/UInt;", "nullableUIntAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TransactionJsonAdapter extends JsonAdapter<Transaction> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonAdapter<UInt> nullableUIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public TransactionJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("txHash", "address", "destination", ApiConstants.FEE, "amount", "destinationTag", "timestamp");
        m.f(of, "of(\"txHash\", \"address\",\n      \"destination\", \"fee\", \"amount\", \"destinationTag\", \"timestamp\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "txHash");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"txHash\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<BigInteger> adapter2 = moshi.adapter(BigInteger.class, b3, ApiConstants.FEE);
        m.f(adapter2, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"fee\")");
        this.bigIntegerAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<UInt> adapter3 = moshi.adapter(UInt.class, b4, "destinationTag");
        m.f(adapter3, "moshi.adapter(UInt::class.java, emptySet(),\n      \"destinationTag\")");
        this.nullableUIntAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Transaction");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Transaction fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        UInt uInt = null;
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
                        JsonDataException unexpectedNull = Util.unexpectedNull("txHash", "txHash", reader);
                        m.f(unexpectedNull, "unexpectedNull(\"txHash\",\n            \"txHash\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("address", "address", reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"address\",\n            \"address\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("destination", "destination", reader);
                        m.f(unexpectedNull3, "unexpectedNull(\"destination\", \"destination\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    bigInteger = this.bigIntegerAdapter.fromJson(reader);
                    if (bigInteger == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(ApiConstants.FEE, ApiConstants.FEE, reader);
                        m.f(unexpectedNull4, "unexpectedNull(\"fee\", \"fee\",\n            reader)");
                        throw unexpectedNull4;
                    }
                    break;
                case 4:
                    bigInteger2 = this.bigIntegerAdapter.fromJson(reader);
                    if (bigInteger2 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("amount", "amount", reader);
                        m.f(unexpectedNull5, "unexpectedNull(\"amount\",\n            \"amount\", reader)");
                        throw unexpectedNull5;
                    }
                    break;
                case 5:
                    uInt = this.nullableUIntAdapter.fromJson(reader);
                    break;
                case 6:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("timestamp", "timestamp", reader);
                        m.f(unexpectedNull6, "unexpectedNull(\"timestamp\",\n            \"timestamp\", reader)");
                        throw unexpectedNull6;
                    }
                    break;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("txHash", "txHash", reader);
            m.f(missingProperty, "missingProperty(\"txHash\", \"txHash\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("address", "address", reader);
            m.f(missingProperty2, "missingProperty(\"address\", \"address\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("destination", "destination", reader);
            m.f(missingProperty3, "missingProperty(\"destination\", \"destination\",\n            reader)");
            throw missingProperty3;
        } else if (bigInteger == null) {
            JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.FEE, ApiConstants.FEE, reader);
            m.f(missingProperty4, "missingProperty(\"fee\", \"fee\", reader)");
            throw missingProperty4;
        } else if (bigInteger2 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("amount", "amount", reader);
            m.f(missingProperty5, "missingProperty(\"amount\", \"amount\", reader)");
            throw missingProperty5;
        } else if (str4 != null) {
            return new Transaction(str, str2, str3, bigInteger, bigInteger2, uInt, str4, null);
        } else {
            JsonDataException missingProperty6 = Util.missingProperty("timestamp", "timestamp", reader);
            m.f(missingProperty6, "missingProperty(\"timestamp\", \"timestamp\", reader)");
            throw missingProperty6;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Transaction transaction) {
        m.g(writer, "writer");
        Objects.requireNonNull(transaction, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("txHash");
        this.stringAdapter.toJson(writer, (JsonWriter) transaction.getTxHash());
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) transaction.getAddress());
        writer.name("destination");
        this.stringAdapter.toJson(writer, (JsonWriter) transaction.getDestination());
        writer.name(ApiConstants.FEE);
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) transaction.getFee());
        writer.name("amount");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) transaction.getAmount());
        writer.name("destinationTag");
        this.nullableUIntAdapter.toJson(writer, (JsonWriter) transaction.m2101getDestinationTag0hXNFcg());
        writer.name("timestamp");
        this.stringAdapter.toJson(writer, (JsonWriter) transaction.getTimestamp());
        writer.endObject();
    }
}