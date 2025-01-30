package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
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

/* compiled from: ConsumerBuyLimitDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitTotalDTO;", "consumerBuyLimitTotalDTOAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyLimitRemainingDTO;", "consumerBuyLimitRemainingDTOAdapter", "", "intAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyLimitDTOJsonAdapter extends JsonAdapter<ConsumerBuyLimitDTO> {
    private final JsonAdapter<ConsumerBuyLimitRemainingDTO> consumerBuyLimitRemainingDTOAdapter;
    private final JsonAdapter<ConsumerBuyLimitTotalDTO> consumerBuyLimitTotalDTOAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerBuyLimitDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.DESCRIPTION, "label", "period_in_days", "remaining", ApiConstants.TOTAL);
        m.f(of, "of(\"description\", \"label\",\n      \"period_in_days\", \"remaining\", \"total\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.DESCRIPTION);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"description\")");
        this.stringAdapter = adapter;
        Class cls = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls, b3, "period_in_days");
        m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(),\n      \"period_in_days\")");
        this.intAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<ConsumerBuyLimitRemainingDTO> adapter3 = moshi.adapter(ConsumerBuyLimitRemainingDTO.class, b4, "remaining");
        m.f(adapter3, "moshi.adapter(ConsumerBuyLimitRemainingDTO::class.java, emptySet(), \"remaining\")");
        this.consumerBuyLimitRemainingDTOAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<ConsumerBuyLimitTotalDTO> adapter4 = moshi.adapter(ConsumerBuyLimitTotalDTO.class, b5, ApiConstants.TOTAL);
        m.f(adapter4, "moshi.adapter(ConsumerBuyLimitTotalDTO::class.java, emptySet(), \"total\")");
        this.consumerBuyLimitTotalDTOAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerBuyLimitDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerBuyLimitDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        String str = null;
        String str2 = null;
        ConsumerBuyLimitRemainingDTO consumerBuyLimitRemainingDTO = null;
        ConsumerBuyLimitTotalDTO consumerBuyLimitTotalDTO = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.DESCRIPTION, ApiConstants.DESCRIPTION, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"description\", \"description\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("label", "label", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"label\", \"label\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("period_in_days", "period_in_days", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"period_in_days\", \"period_in_days\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                consumerBuyLimitRemainingDTO = this.consumerBuyLimitRemainingDTOAdapter.fromJson(reader);
                if (consumerBuyLimitRemainingDTO == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("remaining", "remaining", reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"remaining\", \"remaining\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (consumerBuyLimitTotalDTO = this.consumerBuyLimitTotalDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull(ApiConstants.TOTAL, ApiConstants.TOTAL, reader);
                m.f(unexpectedNull5, "unexpectedNull(\"total\", \"total\", reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.DESCRIPTION, ApiConstants.DESCRIPTION, reader);
            m.f(missingProperty, "missingProperty(\"description\", \"description\",\n            reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("label", "label", reader);
            m.f(missingProperty2, "missingProperty(\"label\", \"label\", reader)");
            throw missingProperty2;
        } else if (num != null) {
            int intValue = num.intValue();
            if (consumerBuyLimitRemainingDTO == null) {
                JsonDataException missingProperty3 = Util.missingProperty("remaining", "remaining", reader);
                m.f(missingProperty3, "missingProperty(\"remaining\", \"remaining\", reader)");
                throw missingProperty3;
            } else if (consumerBuyLimitTotalDTO != null) {
                return new ConsumerBuyLimitDTO(str, str2, intValue, consumerBuyLimitRemainingDTO, consumerBuyLimitTotalDTO);
            } else {
                JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.TOTAL, ApiConstants.TOTAL, reader);
                m.f(missingProperty4, "missingProperty(\"total\", \"total\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("period_in_days", "period_in_days", reader);
            m.f(missingProperty5, "missingProperty(\"period_in_days\",\n            \"period_in_days\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerBuyLimitDTO consumerBuyLimitDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerBuyLimitDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.DESCRIPTION);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerBuyLimitDTO.getDescription());
        writer.name("label");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerBuyLimitDTO.getLabel());
        writer.name("period_in_days");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(consumerBuyLimitDTO.getPeriod_in_days()));
        writer.name("remaining");
        this.consumerBuyLimitRemainingDTOAdapter.toJson(writer, (JsonWriter) consumerBuyLimitDTO.getRemaining());
        writer.name(ApiConstants.TOTAL);
        this.consumerBuyLimitTotalDTOAdapter.toJson(writer, (JsonWriter) consumerBuyLimitDTO.getTotal());
        writer.endObject();
    }
}