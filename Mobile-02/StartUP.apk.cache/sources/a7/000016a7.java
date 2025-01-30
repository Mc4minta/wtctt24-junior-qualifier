package com.coinbase.wallet.consumer.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerUserJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerUserJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/models/ConsumerUser;)V", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/math/BigDecimal;", "bigDecimalAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodeAdapter", "", "listOfStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUserJsonAdapter extends JsonAdapter<ConsumerUser> {
    private final JsonAdapter<BigDecimal> bigDecimalAdapter;
    private volatile Constructor<ConsumerUser> constructorRef;
    private final JsonAdapter<CurrencyCode> currencyCodeAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerUserJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "email", "withdrawalLimit", AppsFlyerProperties.CURRENCY_CODE, "restrictions");
        m.f(of, "of(\"id\", \"email\", \"withdrawalLimit\",\n      \"currencyCode\", \"restrictions\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<BigDecimal> adapter2 = moshi.adapter(BigDecimal.class, b3, "withdrawalLimit");
        m.f(adapter2, "moshi.adapter(BigDecimal::class.java,\n      emptySet(), \"withdrawalLimit\")");
        this.bigDecimalAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<CurrencyCode> adapter3 = moshi.adapter(CurrencyCode.class, b4, AppsFlyerProperties.CURRENCY_CODE);
        m.f(adapter3, "moshi.adapter(CurrencyCode::class.java, emptySet(), \"currencyCode\")");
        this.currencyCodeAdapter = adapter3;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b5 = s0.b();
        JsonAdapter<List<String>> adapter4 = moshi.adapter(newParameterizedType, b5, "restrictions");
        m.f(adapter4, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"restrictions\")");
        this.listOfStringAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerUser");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerUser fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        BigDecimal bigDecimal = null;
        CurrencyCode currencyCode = null;
        List<String> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("email", "email", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"email\", \"email\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                bigDecimal = this.bigDecimalAdapter.fromJson(reader);
                if (bigDecimal == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("withdrawalLimit", "withdrawalLimit", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"withdrawalLimit\", \"withdrawalLimit\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                currencyCode = this.currencyCodeAdapter.fromJson(reader);
                if (currencyCode == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"currencyCode\", \"currencyCode\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4) {
                list = this.listOfStringAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull5 = Util.unexpectedNull("restrictions", "restrictions", reader);
                    m.f(unexpectedNull5, "unexpectedNull(\"restrictions\", \"restrictions\", reader)");
                    throw unexpectedNull5;
                }
                i2 &= -17;
            } else {
                continue;
            }
        }
        reader.endObject();
        if (i2 == -17) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            } else if (str3 == null) {
                JsonDataException missingProperty2 = Util.missingProperty("email", "email", reader);
                m.f(missingProperty2, "missingProperty(\"email\", \"email\", reader)");
                throw missingProperty2;
            } else if (bigDecimal == null) {
                JsonDataException missingProperty3 = Util.missingProperty("withdrawalLimit", "withdrawalLimit", reader);
                m.f(missingProperty3, "missingProperty(\"withdrawalLimit\",\n              \"withdrawalLimit\", reader)");
                throw missingProperty3;
            } else if (currencyCode != null) {
                Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                return new ConsumerUser(str2, str3, bigDecimal, currencyCode, list);
            } else {
                JsonDataException missingProperty4 = Util.missingProperty(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
                m.f(missingProperty4, "missingProperty(\"currencyCode\", \"currencyCode\",\n              reader)");
                throw missingProperty4;
            }
        }
        Constructor<ConsumerUser> constructor = this.constructorRef;
        if (constructor == null) {
            str = "id";
            constructor = ConsumerUser.class.getDeclaredConstructor(String.class, String.class, BigDecimal.class, CurrencyCode.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerUser::class.java.getDeclaredConstructor(String::class.java, String::class.java,\n          BigDecimal::class.java, CurrencyCode::class.java, List::class.java,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        } else {
            str = "id";
        }
        Object[] objArr = new Object[7];
        if (str2 == null) {
            String str4 = str;
            JsonDataException missingProperty5 = Util.missingProperty(str4, str4, reader);
            m.f(missingProperty5, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty5;
        }
        objArr[0] = str2;
        if (str3 == null) {
            JsonDataException missingProperty6 = Util.missingProperty("email", "email", reader);
            m.f(missingProperty6, "missingProperty(\"email\", \"email\", reader)");
            throw missingProperty6;
        }
        objArr[1] = str3;
        if (bigDecimal == null) {
            JsonDataException missingProperty7 = Util.missingProperty("withdrawalLimit", "withdrawalLimit", reader);
            m.f(missingProperty7, "missingProperty(\"withdrawalLimit\", \"withdrawalLimit\",\n              reader)");
            throw missingProperty7;
        }
        objArr[2] = bigDecimal;
        if (currencyCode == null) {
            JsonDataException missingProperty8 = Util.missingProperty(AppsFlyerProperties.CURRENCY_CODE, AppsFlyerProperties.CURRENCY_CODE, reader);
            m.f(missingProperty8, "missingProperty(\"currencyCode\", \"currencyCode\", reader)");
            throw missingProperty8;
        }
        objArr[3] = currencyCode;
        objArr[4] = list;
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = null;
        ConsumerUser newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          email ?: throw Util.missingProperty(\"email\", \"email\", reader),\n          withdrawalLimit ?: throw Util.missingProperty(\"withdrawalLimit\", \"withdrawalLimit\",\n              reader),\n          currencyCode ?: throw Util.missingProperty(\"currencyCode\", \"currencyCode\", reader),\n          restrictions,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerUser consumerUser) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerUser, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerUser.getId());
        writer.name("email");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerUser.getEmail());
        writer.name("withdrawalLimit");
        this.bigDecimalAdapter.toJson(writer, (JsonWriter) consumerUser.getWithdrawalLimit());
        writer.name(AppsFlyerProperties.CURRENCY_CODE);
        this.currencyCodeAdapter.toJson(writer, (JsonWriter) consumerUser.getCurrencyCode());
        writer.name("restrictions");
        this.listOfStringAdapter.toJson(writer, (JsonWriter) consumerUser.getRestrictions());
        writer.endObject();
    }
}