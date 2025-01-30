package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerBuyOrderRequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;)V", "", "nullableBooleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "booleanAdapter", "nullableStringAdapter", "stringAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyOrderRequestDTOJsonAdapter extends JsonAdapter<ConsumerBuyOrderRequestDTO> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<ConsumerBuyOrderRequestDTO> constructorRef;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerBuyOrderRequestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.CURRENCY, ApiConstants.COMMIT, ApiConstants.QUOTE, "amount", ApiConstants.TOTAL, "payment_method", "recurring_period");
        m.f(of, "of(\"currency\", \"commit\", \"quote\",\n      \"amount\", \"total\", \"payment_method\", \"recurring_period\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.CURRENCY);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"currency\")");
        this.stringAdapter = adapter;
        Class cls = Boolean.TYPE;
        b3 = s0.b();
        JsonAdapter<Boolean> adapter2 = moshi.adapter(cls, b3, ApiConstants.COMMIT);
        m.f(adapter2, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"commit\")");
        this.booleanAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, b4, ApiConstants.QUOTE);
        m.f(adapter3, "moshi.adapter(Boolean::class.javaObjectType, emptySet(), \"quote\")");
        this.nullableBooleanAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, b5, "amount");
        m.f(adapter4, "moshi.adapter(String::class.java,\n      emptySet(), \"amount\")");
        this.nullableStringAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(48);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerBuyOrderRequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerBuyOrderRequestDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        Boolean bool = Boolean.FALSE;
        reader.beginObject();
        int i2 = -1;
        String str = null;
        Boolean bool2 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                        m.f(unexpectedNull, "unexpectedNull(\"currency\",\n            \"currency\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    bool = this.booleanAdapter.fromJson(reader);
                    if (bool == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.COMMIT, ApiConstants.COMMIT, reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"commit\", \"commit\",\n              reader)");
                        throw unexpectedNull2;
                    }
                    i2 &= -3;
                    break;
                case 2:
                    bool2 = this.nullableBooleanAdapter.fromJson(reader);
                    i2 &= -5;
                    break;
                case 3:
                    str2 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -9;
                    break;
                case 4:
                    str3 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -17;
                    break;
                case 5:
                    str4 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -33;
                    break;
                case 6:
                    str5 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -65;
                    break;
            }
        }
        reader.endObject();
        if (i2 == -127) {
            if (str != null) {
                return new ConsumerBuyOrderRequestDTO(str, bool.booleanValue(), bool2, str2, str3, str4, str5);
            }
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
            m.f(missingProperty, "missingProperty(\"currency\", \"currency\", reader)");
            throw missingProperty;
        }
        Constructor<ConsumerBuyOrderRequestDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ConsumerBuyOrderRequestDTO.class.getDeclaredConstructor(String.class, Boolean.TYPE, Boolean.class, String.class, String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerBuyOrderRequestDTO::class.java.getDeclaredConstructor(String::class.java,\n          Boolean::class.javaPrimitiveType, Boolean::class.javaObjectType, String::class.java,\n          String::class.java, String::class.java, String::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[9];
        if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
            m.f(missingProperty2, "missingProperty(\"currency\", \"currency\", reader)");
            throw missingProperty2;
        }
        objArr[0] = str;
        objArr[1] = bool;
        objArr[2] = bool2;
        objArr[3] = str2;
        objArr[4] = str3;
        objArr[5] = str4;
        objArr[6] = str5;
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = null;
        ConsumerBuyOrderRequestDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          currency ?: throw Util.missingProperty(\"currency\", \"currency\", reader),\n          commit,\n          quote,\n          amount,\n          total,\n          paymentMethod,\n          recurringPeriod,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerBuyOrderRequestDTO consumerBuyOrderRequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerBuyOrderRequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.CURRENCY);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderRequestDTO.getCurrency());
        writer.name(ApiConstants.COMMIT);
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerBuyOrderRequestDTO.getCommit()));
        writer.name(ApiConstants.QUOTE);
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) consumerBuyOrderRequestDTO.getQuote());
        writer.name("amount");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderRequestDTO.getAmount());
        writer.name(ApiConstants.TOTAL);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderRequestDTO.getTotal());
        writer.name("payment_method");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderRequestDTO.getPaymentMethod());
        writer.name("recurring_period");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderRequestDTO.getRecurringPeriod());
        writer.endObject();
    }
}