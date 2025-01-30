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

/* compiled from: ConsumerNetworkAmountDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;)V", "", "nullableIntAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerNetworkAmountDTOJsonAdapter extends JsonAdapter<ConsumerNetworkAmountDTO> {
    private volatile Constructor<ConsumerNetworkAmountDTO> constructorRef;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerNetworkAmountDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("amount", ApiConstants.CURRENCY, "scale");
        m.f(of, "of(\"amount\", \"currency\", \"scale\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "amount");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"amount\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, b3, "scale");
        m.f(adapter2, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"scale\")");
        this.nullableIntAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(46);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerNetworkAmountDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerNetworkAmountDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str = null;
        String str2 = null;
        Integer num = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("amount", "amount", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"amount\",\n            \"amount\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"currency\",\n            \"currency\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.nullableIntAdapter.fromJson(reader);
                i2 &= -5;
            }
        }
        reader.endObject();
        if (i2 == -5) {
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty("amount", "amount", reader);
                m.f(missingProperty, "missingProperty(\"amount\", \"amount\", reader)");
                throw missingProperty;
            } else if (str2 != null) {
                return new ConsumerNetworkAmountDTO(str, str2, num);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                m.f(missingProperty2, "missingProperty(\"currency\", \"currency\", reader)");
                throw missingProperty2;
            }
        }
        Constructor<ConsumerNetworkAmountDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ConsumerNetworkAmountDTO.class.getDeclaredConstructor(String.class, String.class, Integer.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerNetworkAmountDTO::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, Int::class.javaObjectType, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("amount", "amount", reader);
            m.f(missingProperty3, "missingProperty(\"amount\", \"amount\", reader)");
            throw missingProperty3;
        }
        objArr[0] = str;
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
            m.f(missingProperty4, "missingProperty(\"currency\", \"currency\", reader)");
            throw missingProperty4;
        }
        objArr[1] = str2;
        objArr[2] = num;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = null;
        ConsumerNetworkAmountDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          amount ?: throw Util.missingProperty(\"amount\", \"amount\", reader),\n          currency ?: throw Util.missingProperty(\"currency\", \"currency\", reader),\n          scale,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerNetworkAmountDTO consumerNetworkAmountDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerNetworkAmountDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("amount");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkAmountDTO.getAmount());
        writer.name(ApiConstants.CURRENCY);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkAmountDTO.getCurrency());
        writer.name("scale");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) consumerNetworkAmountDTO.getScale());
        writer.endObject();
    }
}