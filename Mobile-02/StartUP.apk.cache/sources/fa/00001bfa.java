package com.coinbase.wallet.ethereum.dtos;

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
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559ResultJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559ResultJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559ResultJsonAdapter extends JsonAdapter<AdjustableMinerFee1559Result> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonReader.Options options;

    public AdjustableMinerFee1559ResultJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("fastPriorityFee", "normalPriorityFee", "slowPriorityFee", "baseFee", "slowMaxFeePerGas", "normalMaxFeePerGas", "fastMaxFeePerGas");
        m.f(of, "of(\"fastPriorityFee\",\n      \"normalPriorityFee\", \"slowPriorityFee\", \"baseFee\", \"slowMaxFeePerGas\", \"normalMaxFeePerGas\",\n      \"fastMaxFeePerGas\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<BigInteger> adapter = moshi.adapter(BigInteger.class, b2, "fastPriorityFee");
        m.f(adapter, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"fastPriorityFee\")");
        this.bigIntegerAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(50);
        sb.append("GeneratedJsonAdapter(");
        sb.append("AdjustableMinerFee1559Result");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public AdjustableMinerFee1559Result fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = null;
        BigInteger bigInteger5 = null;
        BigInteger bigInteger6 = null;
        BigInteger bigInteger7 = null;
        while (true) {
            BigInteger bigInteger8 = bigInteger7;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        break;
                    case 0:
                        bigInteger = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("fastPriorityFee", "fastPriorityFee", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"fastPriorityFee\", \"fastPriorityFee\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        bigInteger2 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("normalPriorityFee", "normalPriorityFee", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"normalPriorityFee\", \"normalPriorityFee\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        bigInteger3 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("slowPriorityFee", "slowPriorityFee", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"slowPriorityFee\", \"slowPriorityFee\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        bigInteger4 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("baseFee", "baseFee", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"baseFee\",\n            \"baseFee\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        bigInteger5 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("slowMaxFeePerGas", "slowMaxFeePerGas", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"slowMaxFeePerGas\", \"slowMaxFeePerGas\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        bigInteger6 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("normalMaxFeePerGas", "normalMaxFeePerGas", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"normalMaxFeePerGas\", \"normalMaxFeePerGas\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        bigInteger7 = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger7 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("fastMaxFeePerGas", "fastMaxFeePerGas", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"fastMaxFeePerGas\", \"fastMaxFeePerGas\", reader)");
                            throw unexpectedNull7;
                        }
                        continue;
                }
                bigInteger7 = bigInteger8;
            } else {
                reader.endObject();
                if (bigInteger == null) {
                    JsonDataException missingProperty = Util.missingProperty("fastPriorityFee", "fastPriorityFee", reader);
                    m.f(missingProperty, "missingProperty(\"fastPriorityFee\",\n            \"fastPriorityFee\", reader)");
                    throw missingProperty;
                } else if (bigInteger2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("normalPriorityFee", "normalPriorityFee", reader);
                    m.f(missingProperty2, "missingProperty(\"normalPriorityFee\",\n            \"normalPriorityFee\", reader)");
                    throw missingProperty2;
                } else if (bigInteger3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("slowPriorityFee", "slowPriorityFee", reader);
                    m.f(missingProperty3, "missingProperty(\"slowPriorityFee\",\n            \"slowPriorityFee\", reader)");
                    throw missingProperty3;
                } else if (bigInteger4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("baseFee", "baseFee", reader);
                    m.f(missingProperty4, "missingProperty(\"baseFee\", \"baseFee\", reader)");
                    throw missingProperty4;
                } else if (bigInteger5 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("slowMaxFeePerGas", "slowMaxFeePerGas", reader);
                    m.f(missingProperty5, "missingProperty(\"slowMaxFeePerGas\",\n            \"slowMaxFeePerGas\", reader)");
                    throw missingProperty5;
                } else if (bigInteger6 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("normalMaxFeePerGas", "normalMaxFeePerGas", reader);
                    m.f(missingProperty6, "missingProperty(\"normalMaxFeePerGas\",\n            \"normalMaxFeePerGas\", reader)");
                    throw missingProperty6;
                } else if (bigInteger8 != null) {
                    return new AdjustableMinerFee1559Result(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bigInteger6, bigInteger8);
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("fastMaxFeePerGas", "fastMaxFeePerGas", reader);
                    m.f(missingProperty7, "missingProperty(\"fastMaxFeePerGas\",\n            \"fastMaxFeePerGas\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, AdjustableMinerFee1559Result adjustableMinerFee1559Result) {
        m.g(writer, "writer");
        Objects.requireNonNull(adjustableMinerFee1559Result, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("fastPriorityFee");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getFastPriorityFee());
        writer.name("normalPriorityFee");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getNormalPriorityFee());
        writer.name("slowPriorityFee");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getSlowPriorityFee());
        writer.name("baseFee");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getBaseFee());
        writer.name("slowMaxFeePerGas");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getSlowMaxFeePerGas());
        writer.name("normalMaxFeePerGas");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getNormalMaxFeePerGas());
        writer.name("fastMaxFeePerGas");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFee1559Result.getFastMaxFeePerGas());
        writer.endObject();
    }
}