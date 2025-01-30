package com.coinbase.wallet.consumer.models;

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
import org.apache.http.cookie.ClientCookie;

/* compiled from: ConsumerWebViewConfigJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfigJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)V", "", "nullableIntAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerWebViewConfigJsonAdapter extends JsonAdapter<ConsumerWebViewConfig> {
    private volatile Constructor<ConsumerWebViewConfig> constructorRef;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerWebViewConfigJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("proto", "baseUrl", ClientCookie.PORT_ATTR, "host");
        m.f(of, "of(\"proto\", \"baseUrl\", \"port\",\n      \"host\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "proto");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"proto\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, b3, ClientCookie.PORT_ATTR);
        m.f(adapter2, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"port\")");
        this.nullableIntAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerWebViewConfig");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerWebViewConfig fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        Integer num = null;
        String str4 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("proto", "proto", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"proto\", \"proto\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("baseUrl", "baseUrl", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"baseUrl\",\n            \"baseUrl\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.nullableIntAdapter.fromJson(reader);
                i2 &= -5;
            } else if (selectName == 3 && (str4 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("host", "host", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"host\", \"host\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (i2 == -5) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("proto", "proto", reader);
                m.f(missingProperty, "missingProperty(\"proto\", \"proto\", reader)");
                throw missingProperty;
            } else if (str3 == null) {
                JsonDataException missingProperty2 = Util.missingProperty("baseUrl", "baseUrl", reader);
                m.f(missingProperty2, "missingProperty(\"baseUrl\", \"baseUrl\", reader)");
                throw missingProperty2;
            } else if (str4 != null) {
                return new ConsumerWebViewConfig(str2, str3, num, str4);
            } else {
                JsonDataException missingProperty3 = Util.missingProperty("host", "host", reader);
                m.f(missingProperty3, "missingProperty(\"host\", \"host\", reader)");
                throw missingProperty3;
            }
        }
        Constructor<ConsumerWebViewConfig> constructor = this.constructorRef;
        if (constructor == null) {
            str = "missingProperty(\"proto\", \"proto\", reader)";
            constructor = ConsumerWebViewConfig.class.getDeclaredConstructor(String.class, String.class, Integer.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "ConsumerWebViewConfig::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, Int::class.javaObjectType, String::class.java,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        } else {
            str = "missingProperty(\"proto\", \"proto\", reader)";
        }
        Object[] objArr = new Object[6];
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("proto", "proto", reader);
            m.f(missingProperty4, str);
            throw missingProperty4;
        }
        objArr[0] = str2;
        if (str3 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("baseUrl", "baseUrl", reader);
            m.f(missingProperty5, "missingProperty(\"baseUrl\", \"baseUrl\", reader)");
            throw missingProperty5;
        }
        objArr[1] = str3;
        objArr[2] = num;
        if (str4 == null) {
            JsonDataException missingProperty6 = Util.missingProperty("host", "host", reader);
            m.f(missingProperty6, "missingProperty(\"host\", \"host\", reader)");
            throw missingProperty6;
        }
        objArr[3] = str4;
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = null;
        ConsumerWebViewConfig newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          proto ?: throw Util.missingProperty(\"proto\", \"proto\", reader),\n          baseUrl ?: throw Util.missingProperty(\"baseUrl\", \"baseUrl\", reader),\n          port,\n          host ?: throw Util.missingProperty(\"host\", \"host\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerWebViewConfig consumerWebViewConfig) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerWebViewConfig, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("proto");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerWebViewConfig.getProto());
        writer.name("baseUrl");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerWebViewConfig.getBaseUrl());
        writer.name(ClientCookie.PORT_ATTR);
        this.nullableIntAdapter.toJson(writer, (JsonWriter) consumerWebViewConfig.getPort());
        writer.name("host");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerWebViewConfig.getHost());
        writer.endObject();
    }
}