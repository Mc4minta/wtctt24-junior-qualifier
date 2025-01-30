package com.coinbase.wallet.features.send.dtos;

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
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeWaitTimeDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeWaitTimeDTOJsonAdapter extends JsonAdapter<AdjustableMinerFeeWaitTimeDTO> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonReader.Options options;

    public AdjustableMinerFeeWaitTimeDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.PRICE, "waitTime");
        m.f(of, "of(\"price\", \"waitTime\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<BigInteger> adapter = moshi.adapter(BigInteger.class, b2, ApiConstants.PRICE);
        m.f(adapter, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"price\")");
        this.bigIntegerAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(51);
        sb.append("GeneratedJsonAdapter(");
        sb.append("AdjustableMinerFeeWaitTimeDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public AdjustableMinerFeeWaitTimeDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bigInteger = this.bigIntegerAdapter.fromJson(reader);
                if (bigInteger == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.PRICE, ApiConstants.PRICE, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"price\",\n            \"price\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (bigInteger2 = this.bigIntegerAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("waitTime", "waitTime", reader);
                m.f(unexpectedNull2, "unexpectedNull(\"waitTime\",\n            \"waitTime\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (bigInteger == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.PRICE, ApiConstants.PRICE, reader);
            m.f(missingProperty, "missingProperty(\"price\", \"price\", reader)");
            throw missingProperty;
        } else if (bigInteger2 != null) {
            return new AdjustableMinerFeeWaitTimeDTO(bigInteger, bigInteger2);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("waitTime", "waitTime", reader);
            m.f(missingProperty2, "missingProperty(\"waitTime\", \"waitTime\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, AdjustableMinerFeeWaitTimeDTO adjustableMinerFeeWaitTimeDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(adjustableMinerFeeWaitTimeDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.PRICE);
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeWaitTimeDTO.getPrice());
        writer.name("waitTime");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeWaitTimeDTO.getWaitTime());
        writer.endObject();
    }
}