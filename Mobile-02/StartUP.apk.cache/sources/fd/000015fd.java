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

/* compiled from: ConsumerUserDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00180\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerUserDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerUserDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/ConsumerUserDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/ConsumerUserDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "nullableListOfStringAdapter", "stringAdapter", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWithdrawableBalanceDTO;", "nullableConsumerWithdrawableBalanceDTOAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUserDTOJsonAdapter extends JsonAdapter<ConsumerUserDTO> {
    private volatile Constructor<ConsumerUserDTO> constructorRef;
    private final JsonAdapter<ConsumerWithdrawableBalanceDTO> nullableConsumerWithdrawableBalanceDTOAdapter;
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerUserDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "email", "available_balance", ApiConstants.NATIVE_CURRENCY, "restrictions", "next_requirement");
        m.f(of, "of(\"id\", \"email\",\n      \"available_balance\", \"native_currency\", \"restrictions\", \"next_requirement\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<ConsumerWithdrawableBalanceDTO> adapter2 = moshi.adapter(ConsumerWithdrawableBalanceDTO.class, b3, "availableBalance");
        m.f(adapter2, "moshi.adapter(ConsumerWithdrawableBalanceDTO::class.java, emptySet(), \"availableBalance\")");
        this.nullableConsumerWithdrawableBalanceDTOAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "nativeCurrency");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"nativeCurrency\")");
        this.nullableStringAdapter = adapter3;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b5 = s0.b();
        JsonAdapter<List<String>> adapter4 = moshi.adapter(newParameterizedType, b5, "restrictions");
        m.f(adapter4, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"restrictions\")");
        this.nullableListOfStringAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerUserDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerUserDTO fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO = null;
        String str4 = null;
        List<String> list = null;
        String str5 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                        m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("email", "email", reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"email\", \"email\",\n            reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    consumerWithdrawableBalanceDTO = this.nullableConsumerWithdrawableBalanceDTOAdapter.fromJson(reader);
                    break;
                case 3:
                    str4 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -9;
                    break;
                case 4:
                    list = this.nullableListOfStringAdapter.fromJson(reader);
                    i2 &= -17;
                    break;
                case 5:
                    str5 = this.nullableStringAdapter.fromJson(reader);
                    i2 &= -33;
                    break;
            }
        }
        reader.endObject();
        if (i2 == -57) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            } else if (str3 != null) {
                return new ConsumerUserDTO(str2, str3, consumerWithdrawableBalanceDTO, str4, list, str5);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty("email", "email", reader);
                m.f(missingProperty2, "missingProperty(\"email\", \"email\", reader)");
                throw missingProperty2;
            }
        }
        Constructor<ConsumerUserDTO> constructor = this.constructorRef;
        if (constructor == null) {
            str = "missingProperty(\"id\", \"id\", reader)";
            constructor = ConsumerUserDTO.class.getDeclaredConstructor(String.class, String.class, ConsumerWithdrawableBalanceDTO.class, String.class, List.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerUserDTO::class.java.getDeclaredConstructor(String::class.java, String::class.java,\n          ConsumerWithdrawableBalanceDTO::class.java, String::class.java, List::class.java,\n          String::class.java, Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        } else {
            str = "missingProperty(\"id\", \"id\", reader)";
        }
        Object[] objArr = new Object[8];
        if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty3, str);
            throw missingProperty3;
        }
        objArr[0] = str2;
        if (str3 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("email", "email", reader);
            m.f(missingProperty4, "missingProperty(\"email\", \"email\", reader)");
            throw missingProperty4;
        }
        objArr[1] = str3;
        objArr[2] = consumerWithdrawableBalanceDTO;
        objArr[3] = str4;
        objArr[4] = list;
        objArr[5] = str5;
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = null;
        ConsumerUserDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          email ?: throw Util.missingProperty(\"email\", \"email\", reader),\n          availableBalance,\n          nativeCurrency,\n          restrictions,\n          nextRequirement,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerUserDTO consumerUserDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerUserDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerUserDTO.getId());
        writer.name("email");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerUserDTO.getEmail());
        writer.name("available_balance");
        this.nullableConsumerWithdrawableBalanceDTOAdapter.toJson(writer, (JsonWriter) consumerUserDTO.getAvailableBalance());
        writer.name(ApiConstants.NATIVE_CURRENCY);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerUserDTO.getNativeCurrency());
        writer.name("restrictions");
        this.nullableListOfStringAdapter.toJson(writer, (JsonWriter) consumerUserDTO.getRestrictions());
        writer.name("next_requirement");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) consumerUserDTO.getNextRequirement());
        writer.endObject();
    }
}