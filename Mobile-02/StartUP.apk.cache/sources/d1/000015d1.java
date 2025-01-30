package com.coinbase.wallet.consumer.dtos;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAvailablePaymentMethodsDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodsDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodsDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodsDTO;)V", "", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTO;", "listOfConsumerAvailablePaymentMethodDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsDTOJsonAdapter extends JsonAdapter<ConsumerAvailablePaymentMethodsDTO> {
    private final JsonAdapter<List<ConsumerAvailablePaymentMethodDTO>> listOfConsumerAvailablePaymentMethodDTOAdapter;
    private final JsonReader.Options options;

    public ConsumerAvailablePaymentMethodsDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("available_payment_methods");
        m.f(of, "of(\"available_payment_methods\")");
        this.options = of;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, ConsumerAvailablePaymentMethodDTO.class);
        b2 = s0.b();
        JsonAdapter<List<ConsumerAvailablePaymentMethodDTO>> adapter = moshi.adapter(newParameterizedType, b2, "availablePaymentMethods");
        m.f(adapter, "moshi.adapter(Types.newParameterizedType(List::class.java,\n      ConsumerAvailablePaymentMethodDTO::class.java), emptySet(), \"availablePaymentMethods\")");
        this.listOfConsumerAvailablePaymentMethodDTOAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(56);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerAvailablePaymentMethodsDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerAvailablePaymentMethodsDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        List<ConsumerAvailablePaymentMethodDTO> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (list = this.listOfConsumerAvailablePaymentMethodDTOAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("availablePaymentMethods", "available_payment_methods", reader);
                m.f(unexpectedNull, "unexpectedNull(\"availablePaymentMethods\", \"available_payment_methods\",\n            reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (list != null) {
            return new ConsumerAvailablePaymentMethodsDTO(list);
        }
        JsonDataException missingProperty = Util.missingProperty("availablePaymentMethods", "available_payment_methods", reader);
        m.f(missingProperty, "missingProperty(\"availablePaymentMethods\", \"available_payment_methods\",\n            reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerAvailablePaymentMethodsDTO consumerAvailablePaymentMethodsDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerAvailablePaymentMethodsDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("available_payment_methods");
        this.listOfConsumerAvailablePaymentMethodDTOAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodsDTO.getAvailablePaymentMethods());
        writer.endObject();
    }
}