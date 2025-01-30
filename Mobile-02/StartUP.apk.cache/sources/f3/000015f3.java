package com.coinbase.wallet.consumer.dtos;

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

/* compiled from: ConsumerSendFeeEstimateDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeEstimateDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeEstimateDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeEstimateDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeEstimateDTO;)V", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeDTO;", "consumerSendFeeDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendFeeEstimateDTOJsonAdapter extends JsonAdapter<ConsumerSendFeeEstimateDTO> {
    private final JsonAdapter<ConsumerSendFeeDTO> consumerSendFeeDTOAdapter;
    private final JsonReader.Options options;

    public ConsumerSendFeeEstimateDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("user_fee");
        m.f(of, "of(\"user_fee\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<ConsumerSendFeeDTO> adapter = moshi.adapter(ConsumerSendFeeDTO.class, b2, "userFee");
        m.f(adapter, "moshi.adapter(ConsumerSendFeeDTO::class.java, emptySet(), \"userFee\")");
        this.consumerSendFeeDTOAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(48);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerSendFeeEstimateDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerSendFeeEstimateDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        ConsumerSendFeeDTO consumerSendFeeDTO = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (consumerSendFeeDTO = this.consumerSendFeeDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("userFee", "user_fee", reader);
                m.f(unexpectedNull, "unexpectedNull(\"userFee\", \"user_fee\", reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (consumerSendFeeDTO != null) {
            return new ConsumerSendFeeEstimateDTO(consumerSendFeeDTO);
        }
        JsonDataException missingProperty = Util.missingProperty("userFee", "user_fee", reader);
        m.f(missingProperty, "missingProperty(\"userFee\", \"user_fee\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerSendFeeEstimateDTO consumerSendFeeEstimateDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerSendFeeEstimateDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("user_fee");
        this.consumerSendFeeDTOAdapter.toJson(writer, (JsonWriter) consumerSendFeeEstimateDTO.getUserFee());
        writer.endObject();
    }
}