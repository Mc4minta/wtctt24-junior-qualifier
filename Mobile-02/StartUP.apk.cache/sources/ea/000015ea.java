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

/* compiled from: ConsumerPaymentMethodDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodDTO;)V", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerMinimumPurchaseAmountDTO;", "consumerMinimumPurchaseAmountDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "booleanAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/coinbase/wallet/consumer/dtos/ConsumerLimitsDTO;", "nullableConsumerLimitsDTOAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerPaymentMethodDTOJsonAdapter extends JsonAdapter<ConsumerPaymentMethodDTO> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<ConsumerPaymentMethodDTO> constructorRef;
    private final JsonAdapter<ConsumerMinimumPurchaseAmountDTO> consumerMinimumPurchaseAmountDTOAdapter;
    private final JsonAdapter<ConsumerLimitsDTO> nullableConsumerLimitsDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerPaymentMethodDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("allow_buy", "allow_sell", ApiConstants.CURRENCY, "id", "instant_buy", "limits", "minimum_purchase_amount", ApiConstants.NAME, "type", "verified");
        m.f(of, "of(\"allow_buy\", \"allow_sell\",\n      \"currency\", \"id\", \"instant_buy\", \"limits\", \"minimum_purchase_amount\", \"name\", \"type\",\n      \"verified\")");
        this.options = of;
        Class cls = Boolean.TYPE;
        b2 = s0.b();
        JsonAdapter<Boolean> adapter = moshi.adapter(cls, b2, "allow_buy");
        m.f(adapter, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"allow_buy\")");
        this.booleanAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, ApiConstants.CURRENCY);
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"currency\")");
        this.stringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<ConsumerLimitsDTO> adapter3 = moshi.adapter(ConsumerLimitsDTO.class, b4, "limits");
        m.f(adapter3, "moshi.adapter(ConsumerLimitsDTO::class.java, emptySet(), \"limits\")");
        this.nullableConsumerLimitsDTOAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<ConsumerMinimumPurchaseAmountDTO> adapter4 = moshi.adapter(ConsumerMinimumPurchaseAmountDTO.class, b5, "minimum_purchase_amount");
        m.f(adapter4, "moshi.adapter(ConsumerMinimumPurchaseAmountDTO::class.java, emptySet(),\n      \"minimum_purchase_amount\")");
        this.consumerMinimumPurchaseAmountDTOAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(46);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerPaymentMethodDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerPaymentMethodDTO fromJson(JsonReader reader) {
        String str;
        Class<String> cls = String.class;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        String str2 = null;
        String str3 = null;
        ConsumerLimitsDTO consumerLimitsDTO = null;
        ConsumerMinimumPurchaseAmountDTO consumerMinimumPurchaseAmountDTO = null;
        String str4 = null;
        String str5 = null;
        while (true) {
            Class<String> cls2 = cls;
            ConsumerLimitsDTO consumerLimitsDTO2 = consumerLimitsDTO;
            Boolean bool5 = bool4;
            String str6 = str4;
            ConsumerMinimumPurchaseAmountDTO consumerMinimumPurchaseAmountDTO2 = consumerMinimumPurchaseAmountDTO;
            Boolean bool6 = bool3;
            String str7 = str3;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 0:
                        bool = this.booleanAdapter.fromJson(reader);
                        if (bool == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("allow_buy", "allow_buy", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"allow_buy\",\n            \"allow_buy\", reader)");
                            throw unexpectedNull;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 1:
                        bool2 = this.booleanAdapter.fromJson(reader);
                        if (bool2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("allow_sell", "allow_sell", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"allow_sell\",\n            \"allow_sell\", reader)");
                            throw unexpectedNull2;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 2:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"currency\",\n            \"currency\", reader)");
                            throw unexpectedNull3;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 3:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("id", "id", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"id\", \"id\", reader)");
                            throw unexpectedNull4;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        continue;
                    case 4:
                        bool3 = this.booleanAdapter.fromJson(reader);
                        if (bool3 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("instant_buy", "instant_buy", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"instant_buy\", \"instant_buy\", reader)");
                            throw unexpectedNull5;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        break;
                    case 5:
                        consumerLimitsDTO = this.nullableConsumerLimitsDTOAdapter.fromJson(reader);
                        i2 &= -33;
                        cls = cls2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 6:
                        consumerMinimumPurchaseAmountDTO = this.consumerMinimumPurchaseAmountDTOAdapter.fromJson(reader);
                        if (consumerMinimumPurchaseAmountDTO == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("minimum_purchase_amount", "minimum_purchase_amount", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"minimum_purchase_amount\", \"minimum_purchase_amount\", reader)");
                            throw unexpectedNull6;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        bool3 = bool6;
                        break;
                    case 7:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"name\", \"name\",\n            reader)");
                            throw unexpectedNull7;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 8:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull8 = Util.unexpectedNull("type", "type", reader);
                            m.f(unexpectedNull8, "unexpectedNull(\"type\", \"type\",\n            reader)");
                            throw unexpectedNull8;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    case 9:
                        bool4 = this.booleanAdapter.fromJson(reader);
                        if (bool4 == null) {
                            JsonDataException unexpectedNull9 = Util.unexpectedNull("verified", "verified", reader);
                            m.f(unexpectedNull9, "unexpectedNull(\"verified\",\n            \"verified\", reader)");
                            throw unexpectedNull9;
                        }
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                    default:
                        cls = cls2;
                        consumerLimitsDTO = consumerLimitsDTO2;
                        bool4 = bool5;
                        str4 = str6;
                        consumerMinimumPurchaseAmountDTO = consumerMinimumPurchaseAmountDTO2;
                        bool3 = bool6;
                        break;
                }
                str3 = str7;
            } else {
                reader.endObject();
                if (i2 == -33) {
                    if (bool != null) {
                        boolean booleanValue = bool.booleanValue();
                        if (bool2 != null) {
                            boolean booleanValue2 = bool2.booleanValue();
                            if (str2 == null) {
                                JsonDataException missingProperty = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                                m.f(missingProperty, "missingProperty(\"currency\", \"currency\", reader)");
                                throw missingProperty;
                            } else if (str7 == null) {
                                JsonDataException missingProperty2 = Util.missingProperty("id", "id", reader);
                                m.f(missingProperty2, "missingProperty(\"id\", \"id\", reader)");
                                throw missingProperty2;
                            } else if (bool6 != null) {
                                boolean booleanValue3 = bool6.booleanValue();
                                if (consumerMinimumPurchaseAmountDTO2 == null) {
                                    JsonDataException missingProperty3 = Util.missingProperty("minimum_purchase_amount", "minimum_purchase_amount", reader);
                                    m.f(missingProperty3, "missingProperty(\"minimum_purchase_amount\", \"minimum_purchase_amount\",\n              reader)");
                                    throw missingProperty3;
                                } else if (str6 == null) {
                                    JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
                                    m.f(missingProperty4, "missingProperty(\"name\", \"name\", reader)");
                                    throw missingProperty4;
                                } else if (str5 == null) {
                                    JsonDataException missingProperty5 = Util.missingProperty("type", "type", reader);
                                    m.f(missingProperty5, "missingProperty(\"type\", \"type\", reader)");
                                    throw missingProperty5;
                                } else if (bool5 != null) {
                                    return new ConsumerPaymentMethodDTO(booleanValue, booleanValue2, str2, str7, booleanValue3, consumerLimitsDTO2, consumerMinimumPurchaseAmountDTO2, str6, str5, bool5.booleanValue());
                                } else {
                                    JsonDataException missingProperty6 = Util.missingProperty("verified", "verified", reader);
                                    m.f(missingProperty6, "missingProperty(\"verified\", \"verified\", reader)");
                                    throw missingProperty6;
                                }
                            } else {
                                JsonDataException missingProperty7 = Util.missingProperty("instant_buy", "instant_buy", reader);
                                m.f(missingProperty7, "missingProperty(\"instant_buy\", \"instant_buy\",\n              reader)");
                                throw missingProperty7;
                            }
                        }
                        JsonDataException missingProperty8 = Util.missingProperty("allow_sell", "allow_sell", reader);
                        m.f(missingProperty8, "missingProperty(\"allow_sell\", \"allow_sell\", reader)");
                        throw missingProperty8;
                    }
                    JsonDataException missingProperty9 = Util.missingProperty("allow_buy", "allow_buy", reader);
                    m.f(missingProperty9, "missingProperty(\"allow_buy\", \"allow_buy\", reader)");
                    throw missingProperty9;
                }
                Constructor<ConsumerPaymentMethodDTO> constructor = this.constructorRef;
                if (constructor == null) {
                    str = "allow_sell";
                    Class cls3 = Boolean.TYPE;
                    constructor = ConsumerPaymentMethodDTO.class.getDeclaredConstructor(cls3, cls3, cls2, cls2, cls3, ConsumerLimitsDTO.class, ConsumerMinimumPurchaseAmountDTO.class, cls2, cls2, cls3, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = constructor;
                    m.f(constructor, "ConsumerPaymentMethodDTO::class.java.getDeclaredConstructor(Boolean::class.javaPrimitiveType,\n          Boolean::class.javaPrimitiveType, String::class.java, String::class.java,\n          Boolean::class.javaPrimitiveType, ConsumerLimitsDTO::class.java,\n          ConsumerMinimumPurchaseAmountDTO::class.java, String::class.java, String::class.java,\n          Boolean::class.javaPrimitiveType, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
                } else {
                    str = "allow_sell";
                }
                Object[] objArr = new Object[12];
                if (bool != null) {
                    objArr[0] = Boolean.valueOf(bool.booleanValue());
                    if (bool2 != null) {
                        objArr[1] = Boolean.valueOf(bool2.booleanValue());
                        if (str2 == null) {
                            JsonDataException missingProperty10 = Util.missingProperty(ApiConstants.CURRENCY, ApiConstants.CURRENCY, reader);
                            m.f(missingProperty10, "missingProperty(\"currency\", \"currency\", reader)");
                            throw missingProperty10;
                        }
                        objArr[2] = str2;
                        if (str7 == null) {
                            JsonDataException missingProperty11 = Util.missingProperty("id", "id", reader);
                            m.f(missingProperty11, "missingProperty(\"id\", \"id\", reader)");
                            throw missingProperty11;
                        }
                        objArr[3] = str7;
                        if (bool6 != null) {
                            objArr[4] = Boolean.valueOf(bool6.booleanValue());
                            objArr[5] = consumerLimitsDTO2;
                            if (consumerMinimumPurchaseAmountDTO2 == null) {
                                JsonDataException missingProperty12 = Util.missingProperty("minimum_purchase_amount", "minimum_purchase_amount", reader);
                                m.f(missingProperty12, "missingProperty(\"minimum_purchase_amount\",\n              \"minimum_purchase_amount\", reader)");
                                throw missingProperty12;
                            }
                            objArr[6] = consumerMinimumPurchaseAmountDTO2;
                            if (str6 == null) {
                                JsonDataException missingProperty13 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
                                m.f(missingProperty13, "missingProperty(\"name\", \"name\", reader)");
                                throw missingProperty13;
                            }
                            objArr[7] = str6;
                            if (str5 == null) {
                                JsonDataException missingProperty14 = Util.missingProperty("type", "type", reader);
                                m.f(missingProperty14, "missingProperty(\"type\", \"type\", reader)");
                                throw missingProperty14;
                            }
                            objArr[8] = str5;
                            if (bool5 == null) {
                                JsonDataException missingProperty15 = Util.missingProperty("verified", "verified", reader);
                                m.f(missingProperty15, "missingProperty(\"verified\", \"verified\", reader)");
                                throw missingProperty15;
                            }
                            objArr[9] = Boolean.valueOf(bool5.booleanValue());
                            objArr[10] = Integer.valueOf(i2);
                            objArr[11] = null;
                            ConsumerPaymentMethodDTO newInstance = constructor.newInstance(objArr);
                            m.f(newInstance, "localConstructor.newInstance(\n          allow_buy ?: throw Util.missingProperty(\"allow_buy\", \"allow_buy\", reader),\n          allow_sell ?: throw Util.missingProperty(\"allow_sell\", \"allow_sell\", reader),\n          currency ?: throw Util.missingProperty(\"currency\", \"currency\", reader),\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          instant_buy ?: throw Util.missingProperty(\"instant_buy\", \"instant_buy\", reader),\n          limits,\n          minimum_purchase_amount ?: throw Util.missingProperty(\"minimum_purchase_amount\",\n              \"minimum_purchase_amount\", reader),\n          name ?: throw Util.missingProperty(\"name\", \"name\", reader),\n          type ?: throw Util.missingProperty(\"type\", \"type\", reader),\n          verified ?: throw Util.missingProperty(\"verified\", \"verified\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
                            return newInstance;
                        }
                        JsonDataException missingProperty16 = Util.missingProperty("instant_buy", "instant_buy", reader);
                        m.f(missingProperty16, "missingProperty(\"instant_buy\", \"instant_buy\", reader)");
                        throw missingProperty16;
                    }
                    String str8 = str;
                    JsonDataException missingProperty17 = Util.missingProperty(str8, str8, reader);
                    m.f(missingProperty17, "missingProperty(\"allow_sell\", \"allow_sell\", reader)");
                    throw missingProperty17;
                }
                JsonDataException missingProperty18 = Util.missingProperty("allow_buy", "allow_buy", reader);
                m.f(missingProperty18, "missingProperty(\"allow_buy\", \"allow_buy\", reader)");
                throw missingProperty18;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerPaymentMethodDTO consumerPaymentMethodDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerPaymentMethodDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("allow_buy");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerPaymentMethodDTO.getAllow_buy()));
        writer.name("allow_sell");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerPaymentMethodDTO.getAllow_sell()));
        writer.name(ApiConstants.CURRENCY);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerPaymentMethodDTO.getCurrency());
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerPaymentMethodDTO.getId());
        writer.name("instant_buy");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerPaymentMethodDTO.getInstant_buy()));
        writer.name("limits");
        this.nullableConsumerLimitsDTOAdapter.toJson(writer, (JsonWriter) consumerPaymentMethodDTO.getLimits());
        writer.name("minimum_purchase_amount");
        this.consumerMinimumPurchaseAmountDTOAdapter.toJson(writer, (JsonWriter) consumerPaymentMethodDTO.getMinimum_purchase_amount());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) consumerPaymentMethodDTO.getName());
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerPaymentMethodDTO.getType());
        writer.name("verified");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerPaymentMethodDTO.getVerified()));
        writer.endObject();
    }
}