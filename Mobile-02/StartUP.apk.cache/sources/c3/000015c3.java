package com.coinbase.wallet.consumer.dtos;

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

/* compiled from: CompleteCDVRequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompleteCDVRequestDTOJsonAdapter extends JsonAdapter<CompleteCDVRequestDTO> {
    private volatile Constructor<CompleteCDVRequestDTO> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CompleteCDVRequestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("amount_1", "amount_2", "verification_method");
        m.f(of, "of(\"amount_1\", \"amount_2\",\n      \"verification_method\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "amount_1");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"amount_1\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CompleteCDVRequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CompleteCDVRequestDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("amount_1", "amount_1", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"amount_1\",\n            \"amount_1\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("amount_2", "amount_2", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"amount_2\",\n            \"amount_2\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("verificationMethod", "verification_method", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"verificationMethod\", \"verification_method\", reader)");
                    throw unexpectedNull3;
                }
                i2 &= -5;
            } else {
                continue;
            }
        }
        reader.endObject();
        if (i2 == -5) {
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty("amount_1", "amount_1", reader);
                m.f(missingProperty, "missingProperty(\"amount_1\", \"amount_1\", reader)");
                throw missingProperty;
            } else if (str2 != null) {
                Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.String");
                return new CompleteCDVRequestDTO(str, str2, str3);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty("amount_2", "amount_2", reader);
                m.f(missingProperty2, "missingProperty(\"amount_2\", \"amount_2\", reader)");
                throw missingProperty2;
            }
        }
        Constructor<CompleteCDVRequestDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = CompleteCDVRequestDTO.class.getDeclaredConstructor(String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "CompleteCDVRequestDTO::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, String::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("amount_1", "amount_1", reader);
            m.f(missingProperty3, "missingProperty(\"amount_1\", \"amount_1\", reader)");
            throw missingProperty3;
        }
        objArr[0] = str;
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("amount_2", "amount_2", reader);
            m.f(missingProperty4, "missingProperty(\"amount_2\", \"amount_2\", reader)");
            throw missingProperty4;
        }
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = null;
        CompleteCDVRequestDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          amount_1 ?: throw Util.missingProperty(\"amount_1\", \"amount_1\", reader),\n          amount_2 ?: throw Util.missingProperty(\"amount_2\", \"amount_2\", reader),\n          verificationMethod,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CompleteCDVRequestDTO completeCDVRequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(completeCDVRequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("amount_1");
        this.stringAdapter.toJson(writer, (JsonWriter) completeCDVRequestDTO.getAmount_1());
        writer.name("amount_2");
        this.stringAdapter.toJson(writer, (JsonWriter) completeCDVRequestDTO.getAmount_2());
        writer.name("verification_method");
        this.stringAdapter.toJson(writer, (JsonWriter) completeCDVRequestDTO.getVerificationMethod());
        writer.endObject();
    }
}