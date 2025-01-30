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

/* compiled from: ConsumerSendRequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendRequestDTOJsonAdapter extends JsonAdapter<ConsumerSendRequestDTO> {
    private volatile Constructor<ConsumerSendRequestDTO> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerSendRequestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("amount", ApiConstants.FEE, ApiConstants.IDEM, ApiConstants.DESCRIPTION, ApiConstants.CURRENCY, ApiConstants.TO, "type");
        m.f(of, "of(\"amount\", \"fee\", \"idem\",\n      \"description\", \"currency\", \"to\", \"type\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "amount");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"amount\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerSendRequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerSendRequestDTO fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("amount", "amount", reader);
                        m.f(unexpectedNull, "unexpectedNull(\"amount\",\n            \"amount\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.FEE, ApiConstants.FEE, reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"fee\", \"fee\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.IDEM, ApiConstants.IDEM, reader);
                        m.f(unexpectedNull3, "unexpectedNull(\"idem\", \"idem\", reader)");
                        throw unexpectedNull3;
                    }
                    i2 &= -5;
                    break;
                case 3:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(ApiConstants.DESCRIPTION, ApiConstants.DESCRIPTION, reader);
                        m.f(unexpectedNull4, "unexpectedNull(\"description\",\n              \"description\", reader)");
                        throw unexpectedNull4;
                    }
                    i2 &= -9;
                    break;
                case 4:
                    str6 = this.stringAdapter.fromJson(reader);
                    if (str6 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                        m.f(unexpectedNull5, "unexpectedNull(\"currency\",\n            \"currency\", reader)");
                        throw unexpectedNull5;
                    }
                    break;
                case 5:
                    str7 = this.stringAdapter.fromJson(reader);
                    if (str7 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull(ApiConstants.TO, ApiConstants.TO, reader);
                        m.f(unexpectedNull6, "unexpectedNull(\"to\", \"to\", reader)");
                        throw unexpectedNull6;
                    }
                    break;
                case 6:
                    str8 = this.stringAdapter.fromJson(reader);
                    if (str8 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("type", "type", reader);
                        m.f(unexpectedNull7, "unexpectedNull(\"type\", \"type\", reader)");
                        throw unexpectedNull7;
                    }
                    i2 &= -65;
                    break;
            }
        }
        reader.endObject();
        if (i2 == -77) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("amount", "amount", reader);
                m.f(missingProperty, "missingProperty(\"amount\", \"amount\", reader)");
                throw missingProperty;
            } else if (str3 != null) {
                Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.String");
                Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.String");
                if (str6 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                    m.f(missingProperty2, "missingProperty(\"currency\", \"currency\", reader)");
                    throw missingProperty2;
                } else if (str7 != null) {
                    Objects.requireNonNull(str8, "null cannot be cast to non-null type kotlin.String");
                    return new ConsumerSendRequestDTO(str2, str3, str4, str5, str6, str7, str8);
                } else {
                    JsonDataException missingProperty3 = Util.missingProperty(ApiConstants.TO, ApiConstants.TO, reader);
                    m.f(missingProperty3, "missingProperty(\"to\", \"to\", reader)");
                    throw missingProperty3;
                }
            } else {
                JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.FEE, ApiConstants.FEE, reader);
                m.f(missingProperty4, "missingProperty(\"fee\", \"fee\", reader)");
                throw missingProperty4;
            }
        }
        Constructor<ConsumerSendRequestDTO> constructor = this.constructorRef;
        if (constructor == null) {
            str = "missingProperty(\"fee\", \"fee\", reader)";
            constructor = ConsumerSendRequestDTO.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerSendRequestDTO::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, String::class.java, String::class.java, String::class.java,\n          String::class.java, String::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        } else {
            str = "missingProperty(\"fee\", \"fee\", reader)";
        }
        Object[] objArr = new Object[9];
        if (str2 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("amount", "amount", reader);
            m.f(missingProperty5, "missingProperty(\"amount\", \"amount\", reader)");
            throw missingProperty5;
        }
        objArr[0] = str2;
        if (str3 == null) {
            JsonDataException missingProperty6 = Util.missingProperty(ApiConstants.FEE, ApiConstants.FEE, reader);
            m.f(missingProperty6, str);
            throw missingProperty6;
        }
        objArr[1] = str3;
        objArr[2] = str4;
        objArr[3] = str5;
        if (str6 == null) {
            JsonDataException missingProperty7 = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
            m.f(missingProperty7, "missingProperty(\"currency\", \"currency\", reader)");
            throw missingProperty7;
        }
        objArr[4] = str6;
        if (str7 == null) {
            JsonDataException missingProperty8 = Util.missingProperty(ApiConstants.TO, ApiConstants.TO, reader);
            m.f(missingProperty8, "missingProperty(\"to\", \"to\", reader)");
            throw missingProperty8;
        }
        objArr[5] = str7;
        objArr[6] = str8;
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = null;
        ConsumerSendRequestDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          amount ?: throw Util.missingProperty(\"amount\", \"amount\", reader),\n          fee ?: throw Util.missingProperty(\"fee\", \"fee\", reader),\n          idem,\n          description,\n          currency ?: throw Util.missingProperty(\"currency\", \"currency\", reader),\n          to ?: throw Util.missingProperty(\"to\", \"to\", reader),\n          type,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerSendRequestDTO consumerSendRequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerSendRequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("amount");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getAmount());
        writer.name(ApiConstants.FEE);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getFee());
        writer.name(ApiConstants.IDEM);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getIdem());
        writer.name(ApiConstants.DESCRIPTION);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getDescription());
        writer.name(ApiConstants.CURRENCY);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getCurrency());
        writer.name(ApiConstants.TO);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getTo());
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerSendRequestDTO.getType());
        writer.endObject();
    }
}