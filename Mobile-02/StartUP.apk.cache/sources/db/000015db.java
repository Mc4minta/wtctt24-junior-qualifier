package com.coinbase.wallet.consumer.dtos;

import com.appsflyer.internal.referrer.Payload;
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

/* compiled from: ConsumerBuyOrderResponseDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u001e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u001e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "nullableConsumerNetworkAmountDTOAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "nullableIntAdapter", "Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "nullableSecure3DVerificationDTOAdapter", "stringAdapter", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;", "nullableConsumerWBLInfoDTOAdapter", "consumerNetworkAmountDTOAdapter", "", "nullableBooleanAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyOrderResponseDTOJsonAdapter extends JsonAdapter<ConsumerBuyOrderResponseDTO> {
    private volatile Constructor<ConsumerBuyOrderResponseDTO> constructorRef;
    private final JsonAdapter<ConsumerNetworkAmountDTO> consumerNetworkAmountDTOAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<ConsumerNetworkAmountDTO> nullableConsumerNetworkAmountDTOAdapter;
    private final JsonAdapter<ConsumerWBLInfoDTO> nullableConsumerWBLInfoDTOAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<Secure3DVerificationDTO> nullableSecure3DVerificationDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerBuyOrderResponseDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        Set<? extends Annotation> b7;
        Set<? extends Annotation> b8;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "amount", "subtotal", ApiConstants.TOTAL, ApiConstants.FEE, "default_fee", Payload.INSTANT, "payout_at", "payment_method_fee", "unit_price", "hold_days", "resource", "requires_completion_step", "is_first_buy", "secure3d_verification", "wbl_ux_data");
        m.f(of, "of(\"id\", \"amount\", \"subtotal\",\n      \"total\", \"fee\", \"default_fee\", \"instant\", \"payout_at\", \"payment_method_fee\", \"unit_price\",\n      \"hold_days\", \"resource\", \"requires_completion_step\", \"is_first_buy\", \"secure3d_verification\",\n      \"wbl_ux_data\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<ConsumerNetworkAmountDTO> adapter2 = moshi.adapter(ConsumerNetworkAmountDTO.class, b3, "amount");
        m.f(adapter2, "moshi.adapter(ConsumerNetworkAmountDTO::class.java, emptySet(), \"amount\")");
        this.consumerNetworkAmountDTOAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<ConsumerNetworkAmountDTO> adapter3 = moshi.adapter(ConsumerNetworkAmountDTO.class, b4, ApiConstants.FEE);
        m.f(adapter3, "moshi.adapter(ConsumerNetworkAmountDTO::class.java, emptySet(), \"fee\")");
        this.nullableConsumerNetworkAmountDTOAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<Boolean> adapter4 = moshi.adapter(Boolean.class, b5, Payload.INSTANT);
        m.f(adapter4, "moshi.adapter(Boolean::class.javaObjectType, emptySet(), \"instant\")");
        this.nullableBooleanAdapter = adapter4;
        b6 = s0.b();
        JsonAdapter<Integer> adapter5 = moshi.adapter(Integer.class, b6, "holdDays");
        m.f(adapter5, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"holdDays\")");
        this.nullableIntAdapter = adapter5;
        b7 = s0.b();
        JsonAdapter<Secure3DVerificationDTO> adapter6 = moshi.adapter(Secure3DVerificationDTO.class, b7, "secure3DVerification");
        m.f(adapter6, "moshi.adapter(Secure3DVerificationDTO::class.java, emptySet(), \"secure3DVerification\")");
        this.nullableSecure3DVerificationDTOAdapter = adapter6;
        b8 = s0.b();
        JsonAdapter<ConsumerWBLInfoDTO> adapter7 = moshi.adapter(ConsumerWBLInfoDTO.class, b8, "wblInfo");
        m.f(adapter7, "moshi.adapter(ConsumerWBLInfoDTO::class.java, emptySet(), \"wblInfo\")");
        this.nullableConsumerWBLInfoDTOAdapter = adapter7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(49);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerBuyOrderResponseDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerBuyOrderResponseDTO fromJson(JsonReader reader) {
        String str;
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        Class<ConsumerNetworkAmountDTO> cls3 = ConsumerNetworkAmountDTO.class;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO2 = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO3 = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO4 = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO5 = null;
        Boolean bool = null;
        String str3 = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO6 = null;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO7 = null;
        Integer num = null;
        String str4 = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Secure3DVerificationDTO secure3DVerificationDTO = null;
        ConsumerWBLInfoDTO consumerWBLInfoDTO = null;
        while (true) {
            Class<Boolean> cls4 = cls;
            Class<ConsumerNetworkAmountDTO> cls5 = cls3;
            Class<String> cls6 = cls2;
            Boolean bool4 = bool;
            ConsumerNetworkAmountDTO consumerNetworkAmountDTO8 = consumerNetworkAmountDTO5;
            ConsumerNetworkAmountDTO consumerNetworkAmountDTO9 = consumerNetworkAmountDTO4;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 0:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                            throw unexpectedNull;
                        }
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 1:
                        consumerNetworkAmountDTO = this.consumerNetworkAmountDTOAdapter.fromJson(reader);
                        if (consumerNetworkAmountDTO == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("amount", "amount", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"amount\", \"amount\", reader)");
                            throw unexpectedNull2;
                        }
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 2:
                        consumerNetworkAmountDTO2 = this.consumerNetworkAmountDTOAdapter.fromJson(reader);
                        if (consumerNetworkAmountDTO2 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("subtotal", "subtotal", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"subtotal\", \"subtotal\", reader)");
                            throw unexpectedNull3;
                        }
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 3:
                        consumerNetworkAmountDTO3 = this.consumerNetworkAmountDTOAdapter.fromJson(reader);
                        if (consumerNetworkAmountDTO3 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull(ApiConstants.TOTAL, ApiConstants.TOTAL, reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"total\", \"total\", reader)");
                            throw unexpectedNull4;
                        }
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 4:
                        consumerNetworkAmountDTO4 = this.nullableConsumerNetworkAmountDTOAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        continue;
                    case 5:
                        consumerNetworkAmountDTO5 = this.nullableConsumerNetworkAmountDTOAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        break;
                    case 6:
                        bool = this.nullableBooleanAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 7:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("payoutAt", "payout_at", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"payoutAt\",\n            \"payout_at\", reader)");
                            throw unexpectedNull5;
                        }
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 8:
                        consumerNetworkAmountDTO6 = this.nullableConsumerNetworkAmountDTOAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 9:
                        consumerNetworkAmountDTO7 = this.nullableConsumerNetworkAmountDTOAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 10:
                        num = this.nullableIntAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 11:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("resource", "resource", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"resource\",\n            \"resource\", reader)");
                            throw unexpectedNull6;
                        }
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 12:
                        bool2 = this.nullableBooleanAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 13:
                        bool3 = this.nullableBooleanAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 14:
                        secure3DVerificationDTO = this.nullableSecure3DVerificationDTOAdapter.fromJson(reader);
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    case 15:
                        consumerWBLInfoDTO = this.nullableConsumerWBLInfoDTOAdapter.fromJson(reader);
                        i2 &= -32769;
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                    default:
                        cls = cls4;
                        cls3 = cls5;
                        cls2 = cls6;
                        bool = bool4;
                        consumerNetworkAmountDTO5 = consumerNetworkAmountDTO8;
                        break;
                }
                consumerNetworkAmountDTO4 = consumerNetworkAmountDTO9;
            } else {
                reader.endObject();
                if (i2 == -32769) {
                    if (str2 == null) {
                        JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                        m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                        throw missingProperty;
                    } else if (consumerNetworkAmountDTO == null) {
                        JsonDataException missingProperty2 = Util.missingProperty("amount", "amount", reader);
                        m.f(missingProperty2, "missingProperty(\"amount\", \"amount\", reader)");
                        throw missingProperty2;
                    } else if (consumerNetworkAmountDTO2 == null) {
                        JsonDataException missingProperty3 = Util.missingProperty("subtotal", "subtotal", reader);
                        m.f(missingProperty3, "missingProperty(\"subtotal\", \"subtotal\", reader)");
                        throw missingProperty3;
                    } else if (consumerNetworkAmountDTO3 == null) {
                        JsonDataException missingProperty4 = Util.missingProperty(ApiConstants.TOTAL, ApiConstants.TOTAL, reader);
                        m.f(missingProperty4, "missingProperty(\"total\", \"total\", reader)");
                        throw missingProperty4;
                    } else if (str3 == null) {
                        JsonDataException missingProperty5 = Util.missingProperty("payoutAt", "payout_at", reader);
                        m.f(missingProperty5, "missingProperty(\"payoutAt\", \"payout_at\", reader)");
                        throw missingProperty5;
                    } else if (str4 != null) {
                        return new ConsumerBuyOrderResponseDTO(str2, consumerNetworkAmountDTO, consumerNetworkAmountDTO2, consumerNetworkAmountDTO3, consumerNetworkAmountDTO9, consumerNetworkAmountDTO8, bool4, str3, consumerNetworkAmountDTO6, consumerNetworkAmountDTO7, num, str4, bool2, bool3, secure3DVerificationDTO, consumerWBLInfoDTO);
                    } else {
                        JsonDataException missingProperty6 = Util.missingProperty("resource", "resource", reader);
                        m.f(missingProperty6, "missingProperty(\"resource\", \"resource\", reader)");
                        throw missingProperty6;
                    }
                }
                Constructor<ConsumerBuyOrderResponseDTO> constructor = this.constructorRef;
                if (constructor == null) {
                    str = "amount";
                    constructor = ConsumerBuyOrderResponseDTO.class.getDeclaredConstructor(cls6, cls5, cls5, cls5, cls5, cls5, cls4, cls6, cls5, cls5, Integer.class, cls6, cls4, cls4, Secure3DVerificationDTO.class, ConsumerWBLInfoDTO.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = constructor;
                    m.f(constructor, "ConsumerBuyOrderResponseDTO::class.java.getDeclaredConstructor(String::class.java,\n          ConsumerNetworkAmountDTO::class.java, ConsumerNetworkAmountDTO::class.java,\n          ConsumerNetworkAmountDTO::class.java, ConsumerNetworkAmountDTO::class.java,\n          ConsumerNetworkAmountDTO::class.java, Boolean::class.javaObjectType, String::class.java,\n          ConsumerNetworkAmountDTO::class.java, ConsumerNetworkAmountDTO::class.java,\n          Int::class.javaObjectType, String::class.java, Boolean::class.javaObjectType,\n          Boolean::class.javaObjectType, Secure3DVerificationDTO::class.java,\n          ConsumerWBLInfoDTO::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
                } else {
                    str = "amount";
                }
                Object[] objArr = new Object[18];
                if (str2 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("id", "id", reader);
                    m.f(missingProperty7, "missingProperty(\"id\", \"id\", reader)");
                    throw missingProperty7;
                }
                objArr[0] = str2;
                if (consumerNetworkAmountDTO == null) {
                    String str5 = str;
                    JsonDataException missingProperty8 = Util.missingProperty(str5, str5, reader);
                    m.f(missingProperty8, "missingProperty(\"amount\", \"amount\", reader)");
                    throw missingProperty8;
                }
                objArr[1] = consumerNetworkAmountDTO;
                if (consumerNetworkAmountDTO2 == null) {
                    JsonDataException missingProperty9 = Util.missingProperty("subtotal", "subtotal", reader);
                    m.f(missingProperty9, "missingProperty(\"subtotal\", \"subtotal\", reader)");
                    throw missingProperty9;
                }
                objArr[2] = consumerNetworkAmountDTO2;
                if (consumerNetworkAmountDTO3 == null) {
                    JsonDataException missingProperty10 = Util.missingProperty(ApiConstants.TOTAL, ApiConstants.TOTAL, reader);
                    m.f(missingProperty10, "missingProperty(\"total\", \"total\", reader)");
                    throw missingProperty10;
                }
                objArr[3] = consumerNetworkAmountDTO3;
                objArr[4] = consumerNetworkAmountDTO9;
                objArr[5] = consumerNetworkAmountDTO8;
                objArr[6] = bool4;
                if (str3 == null) {
                    JsonDataException missingProperty11 = Util.missingProperty("payoutAt", "payout_at", reader);
                    m.f(missingProperty11, "missingProperty(\"payoutAt\", \"payout_at\", reader)");
                    throw missingProperty11;
                }
                objArr[7] = str3;
                objArr[8] = consumerNetworkAmountDTO6;
                objArr[9] = consumerNetworkAmountDTO7;
                objArr[10] = num;
                if (str4 == null) {
                    JsonDataException missingProperty12 = Util.missingProperty("resource", "resource", reader);
                    m.f(missingProperty12, "missingProperty(\"resource\", \"resource\", reader)");
                    throw missingProperty12;
                }
                objArr[11] = str4;
                objArr[12] = bool2;
                objArr[13] = bool3;
                objArr[14] = secure3DVerificationDTO;
                objArr[15] = consumerWBLInfoDTO;
                objArr[16] = Integer.valueOf(i2);
                objArr[17] = null;
                ConsumerBuyOrderResponseDTO newInstance = constructor.newInstance(objArr);
                m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          amount ?: throw Util.missingProperty(\"amount\", \"amount\", reader),\n          subtotal ?: throw Util.missingProperty(\"subtotal\", \"subtotal\", reader),\n          total ?: throw Util.missingProperty(\"total\", \"total\", reader),\n          fee,\n          defaultFee,\n          instant,\n          payoutAt ?: throw Util.missingProperty(\"payoutAt\", \"payout_at\", reader),\n          paymentMethodFee,\n          unitPrice,\n          holdDays,\n          resource ?: throw Util.missingProperty(\"resource\", \"resource\", reader),\n          requiresCompletionStep,\n          isFirstBuy,\n          secure3DVerification,\n          wblInfo,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
                return newInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerBuyOrderResponseDTO consumerBuyOrderResponseDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerBuyOrderResponseDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getId());
        writer.name("amount");
        this.consumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getAmount());
        writer.name("subtotal");
        this.consumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getSubtotal());
        writer.name(ApiConstants.TOTAL);
        this.consumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getTotal());
        writer.name(ApiConstants.FEE);
        this.nullableConsumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getFee());
        writer.name("default_fee");
        this.nullableConsumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getDefaultFee());
        writer.name(Payload.INSTANT);
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getInstant());
        writer.name("payout_at");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getPayoutAt());
        writer.name("payment_method_fee");
        this.nullableConsumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getPaymentMethodFee());
        writer.name("unit_price");
        this.nullableConsumerNetworkAmountDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getUnitPrice());
        writer.name("hold_days");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getHoldDays());
        writer.name("resource");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getResource());
        writer.name("requires_completion_step");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getRequiresCompletionStep());
        writer.name("is_first_buy");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.isFirstBuy());
        writer.name("secure3d_verification");
        this.nullableSecure3DVerificationDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getSecure3DVerification());
        writer.name("wbl_ux_data");
        this.nullableConsumerWBLInfoDTOAdapter.toJson(writer, (JsonWriter) consumerBuyOrderResponseDTO.getWblInfo());
        writer.endObject();
    }
}