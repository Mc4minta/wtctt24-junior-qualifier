package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAvailablePaymentMethodDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0012¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTO;)V", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyingPowerDTO;", "nullableConsumerBuyingPowerDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "stringAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "nullableListOfStringAdapter", "", "nullableBooleanAdapter", "booleanAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodDTOJsonAdapter extends JsonAdapter<ConsumerAvailablePaymentMethodDTO> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<ConsumerAvailablePaymentMethodDTO> constructorRef;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<ConsumerBuyingPowerDTO> nullableConsumerBuyingPowerDTOAdapter;
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerAvailablePaymentMethodDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        Set<? extends Annotation> b7;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "requirements", "verify_requirements", ApiConstants.NAME, ApiConstants.DESCRIPTION, "additional_fees", "recommended", "buying_power", "instant_withdraw", "add_text", "buy_time", "supports");
        m.f(of, "of(\"type\", \"requirements\",\n      \"verify_requirements\", \"name\", \"description\", \"additional_fees\", \"recommended\",\n      \"buying_power\", \"instant_withdraw\", \"add_text\", \"buy_time\", \"supports\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "type");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"type\")");
        this.stringAdapter = adapter;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b3 = s0.b();
        JsonAdapter<List<String>> adapter2 = moshi.adapter(newParameterizedType, b3, "requirements");
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"requirements\")");
        this.nullableListOfStringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, ApiConstants.NAME);
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<Boolean> adapter4 = moshi.adapter(Boolean.class, b5, "recommended");
        m.f(adapter4, "moshi.adapter(Boolean::class.javaObjectType, emptySet(), \"recommended\")");
        this.nullableBooleanAdapter = adapter4;
        b6 = s0.b();
        JsonAdapter<ConsumerBuyingPowerDTO> adapter5 = moshi.adapter(ConsumerBuyingPowerDTO.class, b6, "buyingPower");
        m.f(adapter5, "moshi.adapter(ConsumerBuyingPowerDTO::class.java, emptySet(), \"buyingPower\")");
        this.nullableConsumerBuyingPowerDTOAdapter = adapter5;
        Class cls = Boolean.TYPE;
        b7 = s0.b();
        JsonAdapter<Boolean> adapter6 = moshi.adapter(cls, b7, "instantWithdraw");
        m.f(adapter6, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"instantWithdraw\")");
        this.booleanAdapter = adapter6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerAvailablePaymentMethodDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerAvailablePaymentMethodDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        Boolean bool = Boolean.FALSE;
        reader.beginObject();
        int i2 = -1;
        String str = null;
        List<String> list = null;
        List<String> list2 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Boolean bool2 = null;
        ConsumerBuyingPowerDTO consumerBuyingPowerDTO = null;
        String str5 = null;
        String str6 = null;
        List<String> list3 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                        m.f(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    list = this.nullableListOfStringAdapter.fromJson(reader);
                    i2 &= -3;
                    break;
                case 2:
                    list2 = this.nullableListOfStringAdapter.fromJson(reader);
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
                    bool2 = this.nullableBooleanAdapter.fromJson(reader);
                    i2 &= -65;
                    break;
                case 7:
                    consumerBuyingPowerDTO = this.nullableConsumerBuyingPowerDTOAdapter.fromJson(reader);
                    i2 &= -129;
                    break;
                case 8:
                    bool = this.booleanAdapter.fromJson(reader);
                    if (bool == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("instantWithdraw", "instant_withdraw", reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"instantWithdraw\", \"instant_withdraw\", reader)");
                        throw unexpectedNull2;
                    }
                    i2 &= -257;
                    break;
                case 9:
                    str5 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -513;
                    break;
                case 10:
                    str6 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -1025;
                    break;
                case 11:
                    list3 = this.nullableListOfStringAdapter.fromJson(reader);
                    i2 &= -2049;
                    break;
            }
        }
        reader.endObject();
        if (i2 == -4095) {
            if (str != null) {
                return new ConsumerAvailablePaymentMethodDTO(str, list, list2, str2, str3, str4, bool2, consumerBuyingPowerDTO, bool.booleanValue(), str5, str6, list3);
            }
            JsonDataException missingProperty = Util.missingProperty("type", "type", reader);
            m.f(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        }
        Constructor<ConsumerAvailablePaymentMethodDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ConsumerAvailablePaymentMethodDTO.class.getDeclaredConstructor(String.class, List.class, List.class, String.class, String.class, String.class, Boolean.class, ConsumerBuyingPowerDTO.class, Boolean.TYPE, String.class, String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerAvailablePaymentMethodDTO::class.java.getDeclaredConstructor(String::class.java,\n          List::class.java, List::class.java, String::class.java, String::class.java,\n          String::class.java, Boolean::class.javaObjectType, ConsumerBuyingPowerDTO::class.java,\n          Boolean::class.javaPrimitiveType, String::class.java, String::class.java,\n          List::class.java, Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        }
        Object[] objArr = new Object[14];
        if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("type", "type", reader);
            m.f(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty2;
        }
        objArr[0] = str;
        objArr[1] = list;
        objArr[2] = list2;
        objArr[3] = str2;
        objArr[4] = str3;
        objArr[5] = str4;
        objArr[6] = bool2;
        objArr[7] = consumerBuyingPowerDTO;
        objArr[8] = bool;
        objArr[9] = str5;
        objArr[10] = str6;
        objArr[11] = list3;
        objArr[12] = Integer.valueOf(i2);
        objArr[13] = null;
        ConsumerAvailablePaymentMethodDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          type ?: throw Util.missingProperty(\"type\", \"type\", reader),\n          requirements,\n          verifyRequirements,\n          name,\n          description,\n          additionalFees,\n          recommended,\n          buyingPower,\n          instantWithdraw,\n          addText,\n          buyTime,\n          supports,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerAvailablePaymentMethodDTO consumerAvailablePaymentMethodDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerAvailablePaymentMethodDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getType());
        writer.name("requirements");
        this.nullableListOfStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getRequirements());
        writer.name("verify_requirements");
        this.nullableListOfStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getVerifyRequirements());
        writer.name(ApiConstants.NAME);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getName());
        writer.name(ApiConstants.DESCRIPTION);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getDescription());
        writer.name("additional_fees");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getAdditionalFees());
        writer.name("recommended");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getRecommended());
        writer.name("buying_power");
        this.nullableConsumerBuyingPowerDTOAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getBuyingPower());
        writer.name("instant_withdraw");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerAvailablePaymentMethodDTO.getInstantWithdraw()));
        writer.name("add_text");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getAddText());
        writer.name("buy_time");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getBuyTime());
        writer.name("supports");
        this.nullableListOfStringAdapter.toJson(writer, (JsonWriter) consumerAvailablePaymentMethodDTO.getSupports());
        writer.endObject();
    }
}