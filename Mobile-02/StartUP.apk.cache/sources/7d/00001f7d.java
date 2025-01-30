package com.coinbase.wallet.features.send.dtos;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeResultDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeResultDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeResultDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeResultDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeResultDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;", "listOfAdjustableMinerFeeWaitTimeDTOAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeResultDTOJsonAdapter extends JsonAdapter<AdjustableMinerFeeResultDTO> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonAdapter<List<AdjustableMinerFeeWaitTimeDTO>> listOfAdjustableMinerFeeWaitTimeDTOAdapter;
    private final JsonReader.Options options;

    public AdjustableMinerFeeResultDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("slow", "normal", "fast", "blockNum", "waitTimes");
        m.f(of, "of(\"slow\", \"normal\", \"fast\",\n      \"blockNum\", \"waitTimes\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<BigInteger> adapter = moshi.adapter(BigInteger.class, b2, "slow");
        m.f(adapter, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"slow\")");
        this.bigIntegerAdapter = adapter;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, AdjustableMinerFeeWaitTimeDTO.class);
        b3 = s0.b();
        JsonAdapter<List<AdjustableMinerFeeWaitTimeDTO>> adapter2 = moshi.adapter(newParameterizedType, b3, "waitTimes");
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java,\n      AdjustableMinerFeeWaitTimeDTO::class.java), emptySet(), \"waitTimes\")");
        this.listOfAdjustableMinerFeeWaitTimeDTOAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(49);
        sb.append("GeneratedJsonAdapter(");
        sb.append("AdjustableMinerFeeResultDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public AdjustableMinerFeeResultDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = null;
        List<AdjustableMinerFeeWaitTimeDTO> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bigInteger = this.bigIntegerAdapter.fromJson(reader);
                if (bigInteger == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("slow", "slow", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"slow\", \"slow\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                bigInteger2 = this.bigIntegerAdapter.fromJson(reader);
                if (bigInteger2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("normal", "normal", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"normal\",\n            \"normal\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                bigInteger3 = this.bigIntegerAdapter.fromJson(reader);
                if (bigInteger3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("fast", "fast", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"fast\", \"fast\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                bigInteger4 = this.bigIntegerAdapter.fromJson(reader);
                if (bigInteger4 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("blockNum", "blockNum", reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"blockNum\",\n            \"blockNum\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (list = this.listOfAdjustableMinerFeeWaitTimeDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("waitTimes", "waitTimes", reader);
                m.f(unexpectedNull5, "unexpectedNull(\"waitTimes\", \"waitTimes\", reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (bigInteger == null) {
            JsonDataException missingProperty = Util.missingProperty("slow", "slow", reader);
            m.f(missingProperty, "missingProperty(\"slow\", \"slow\", reader)");
            throw missingProperty;
        } else if (bigInteger2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("normal", "normal", reader);
            m.f(missingProperty2, "missingProperty(\"normal\", \"normal\", reader)");
            throw missingProperty2;
        } else if (bigInteger3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("fast", "fast", reader);
            m.f(missingProperty3, "missingProperty(\"fast\", \"fast\", reader)");
            throw missingProperty3;
        } else if (bigInteger4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("blockNum", "blockNum", reader);
            m.f(missingProperty4, "missingProperty(\"blockNum\", \"blockNum\", reader)");
            throw missingProperty4;
        } else if (list != null) {
            return new AdjustableMinerFeeResultDTO(bigInteger, bigInteger2, bigInteger3, bigInteger4, list);
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("waitTimes", "waitTimes", reader);
            m.f(missingProperty5, "missingProperty(\"waitTimes\", \"waitTimes\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, AdjustableMinerFeeResultDTO adjustableMinerFeeResultDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(adjustableMinerFeeResultDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("slow");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeResultDTO.getSlow());
        writer.name("normal");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeResultDTO.getNormal());
        writer.name("fast");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeResultDTO.getFast());
        writer.name("blockNum");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeResultDTO.getBlockNum());
        writer.name("waitTimes");
        this.listOfAdjustableMinerFeeWaitTimeDTOAdapter.toJson(writer, (JsonWriter) adjustableMinerFeeResultDTO.getWaitTimes());
        writer.endObject();
    }
}