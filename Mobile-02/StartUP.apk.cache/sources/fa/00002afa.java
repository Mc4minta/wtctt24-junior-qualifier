package com.coinbase.walletengine.services.stellar;

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

/* compiled from: TransactionResultJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/walletengine/services/stellar/TransactionResultJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/stellar/TransactionResult;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/stellar/TransactionResult;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/stellar/TransactionResult;)V", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lkotlin/UInt;", "uIntAdapter", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TransactionResultJsonAdapter extends JsonAdapter<TransactionResult> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<UInt> uIntAdapter;

    public TransactionResultJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("successful", "ledgerSequence", "feePaid");
        m.f(of, "of(\"successful\", \"ledgerSequence\",\n      \"feePaid\")");
        this.options = of;
        Class cls = Boolean.TYPE;
        b2 = s0.b();
        JsonAdapter<Boolean> adapter = moshi.adapter(cls, b2, "successful");
        m.f(adapter, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"successful\")");
        this.booleanAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<UInt> adapter2 = moshi.adapter(UInt.class, b3, "ledgerSequence");
        m.f(adapter2, "moshi.adapter(UInt::class.java, emptySet(),\n      \"ledgerSequence\")");
        this.uIntAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<BigInteger> adapter3 = moshi.adapter(BigInteger.class, b4, "feePaid");
        m.f(adapter3, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"feePaid\")");
        this.bigIntegerAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(");
        sb.append("TransactionResult");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public TransactionResult fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        UInt uInt = null;
        BigInteger bigInteger = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("successful", "successful", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"successful\",\n            \"successful\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                uInt = this.uIntAdapter.fromJson(reader);
                if (uInt == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("ledgerSequence", "ledgerSequence", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"ledgerSequence\", \"ledgerSequence\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (bigInteger = this.bigIntegerAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("feePaid", "feePaid", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"feePaid\",\n            \"feePaid\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (uInt != null) {
                int B = uInt.B();
                if (bigInteger != null) {
                    return new TransactionResult(booleanValue, B, bigInteger, null);
                }
                JsonDataException missingProperty = Util.missingProperty("feePaid", "feePaid", reader);
                m.f(missingProperty, "missingProperty(\"feePaid\", \"feePaid\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("ledgerSequence", "ledgerSequence", reader);
            m.f(missingProperty2, "missingProperty(\"ledgerSequence\",\n            \"ledgerSequence\", reader)");
            throw missingProperty2;
        }
        JsonDataException missingProperty3 = Util.missingProperty("successful", "successful", reader);
        m.f(missingProperty3, "missingProperty(\"successful\", \"successful\", reader)");
        throw missingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, TransactionResult transactionResult) {
        m.g(writer, "writer");
        Objects.requireNonNull(transactionResult, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("successful");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(transactionResult.getSuccessful()));
        writer.name("ledgerSequence");
        this.uIntAdapter.toJson(writer, (JsonWriter) UInt.h(transactionResult.m2087getLedgerSequencepVg5ArA()));
        writer.name("feePaid");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) transactionResult.getFeePaid());
        writer.endObject();
    }
}