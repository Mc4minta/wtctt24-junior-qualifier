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

/* compiled from: ConsumerNetworkConfigJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfigJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerNetworkConfigJsonAdapter extends JsonAdapter<ConsumerNetworkConfig> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<ConsumerNetworkConfig> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerNetworkConfigJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("baseApiURL", "baseApiV3URL", "oAuthApiURL", "clientId", "clientSecret", "apiVersion", "pinCertificates");
        m.f(of, "of(\"baseApiURL\", \"baseApiV3URL\",\n      \"oAuthApiURL\", \"clientId\", \"clientSecret\", \"apiVersion\", \"pinCertificates\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "baseApiURL");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"baseApiURL\")");
        this.stringAdapter = adapter;
        Class cls = Boolean.TYPE;
        b3 = s0.b();
        JsonAdapter<Boolean> adapter2 = moshi.adapter(cls, b3, "pinCertificates");
        m.f(adapter2, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"pinCertificates\")");
        this.booleanAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerNetworkConfig");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerNetworkConfig fromJson(JsonReader reader) {
        String str;
        Class<String> cls = String.class;
        m.g(reader, "reader");
        Boolean bool = Boolean.FALSE;
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (true) {
            Class<String> cls2 = cls;
            Boolean bool2 = bool;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        break;
                    case 0:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("baseApiURL", "baseApiURL", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"baseApiURL\",\n            \"baseApiURL\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("baseApiV3URL", "baseApiV3URL", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"baseApiV3URL\", \"baseApiV3URL\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("oAuthApiURL", "oAuthApiURL", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"oAuthApiURL\", \"oAuthApiURL\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("clientId", "clientId", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"clientId\",\n            \"clientId\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        str6 = this.stringAdapter.fromJson(reader);
                        if (str6 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("clientSecret", "clientSecret", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"clientSecret\", \"clientSecret\", reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        str7 = this.stringAdapter.fromJson(reader);
                        if (str7 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("apiVersion", "apiVersion", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"apiVersion\",\n            \"apiVersion\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        bool = this.booleanAdapter.fromJson(reader);
                        if (bool == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("pinCertificates", "pinCertificates", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"pinCertificates\", \"pinCertificates\", reader)");
                            throw unexpectedNull7;
                        }
                        i2 &= -65;
                        cls = cls2;
                        continue;
                }
                cls = cls2;
                bool = bool2;
            } else {
                reader.endObject();
                if (i2 == -65) {
                    if (str2 == null) {
                        JsonDataException missingProperty = Util.missingProperty("baseApiURL", "baseApiURL", reader);
                        m.f(missingProperty, "missingProperty(\"baseApiURL\", \"baseApiURL\", reader)");
                        throw missingProperty;
                    } else if (str3 == null) {
                        JsonDataException missingProperty2 = Util.missingProperty("baseApiV3URL", "baseApiV3URL", reader);
                        m.f(missingProperty2, "missingProperty(\"baseApiV3URL\", \"baseApiV3URL\",\n              reader)");
                        throw missingProperty2;
                    } else if (str4 == null) {
                        JsonDataException missingProperty3 = Util.missingProperty("oAuthApiURL", "oAuthApiURL", reader);
                        m.f(missingProperty3, "missingProperty(\"oAuthApiURL\", \"oAuthApiURL\",\n              reader)");
                        throw missingProperty3;
                    } else if (str5 == null) {
                        JsonDataException missingProperty4 = Util.missingProperty("clientId", "clientId", reader);
                        m.f(missingProperty4, "missingProperty(\"clientId\", \"clientId\", reader)");
                        throw missingProperty4;
                    } else if (str6 == null) {
                        JsonDataException missingProperty5 = Util.missingProperty("clientSecret", "clientSecret", reader);
                        m.f(missingProperty5, "missingProperty(\"clientSecret\", \"clientSecret\",\n              reader)");
                        throw missingProperty5;
                    } else if (str7 != null) {
                        return new ConsumerNetworkConfig(str2, str3, str4, str5, str6, str7, bool2.booleanValue());
                    } else {
                        JsonDataException missingProperty6 = Util.missingProperty("apiVersion", "apiVersion", reader);
                        m.f(missingProperty6, "missingProperty(\"apiVersion\", \"apiVersion\", reader)");
                        throw missingProperty6;
                    }
                }
                Constructor<ConsumerNetworkConfig> constructor = this.constructorRef;
                if (constructor == null) {
                    str = "oAuthApiURL";
                    constructor = ConsumerNetworkConfig.class.getDeclaredConstructor(cls2, cls2, cls2, cls2, cls2, cls2, Boolean.TYPE, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = constructor;
                    m.f(constructor, "ConsumerNetworkConfig::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, String::class.java, String::class.java, String::class.java,\n          String::class.java, Boolean::class.javaPrimitiveType, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
                } else {
                    str = "oAuthApiURL";
                }
                Object[] objArr = new Object[9];
                if (str2 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("baseApiURL", "baseApiURL", reader);
                    m.f(missingProperty7, "missingProperty(\"baseApiURL\", \"baseApiURL\", reader)");
                    throw missingProperty7;
                }
                objArr[0] = str2;
                if (str3 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("baseApiV3URL", "baseApiV3URL", reader);
                    m.f(missingProperty8, "missingProperty(\"baseApiV3URL\", \"baseApiV3URL\", reader)");
                    throw missingProperty8;
                }
                objArr[1] = str3;
                if (str4 == null) {
                    String str8 = str;
                    JsonDataException missingProperty9 = Util.missingProperty(str8, str8, reader);
                    m.f(missingProperty9, "missingProperty(\"oAuthApiURL\", \"oAuthApiURL\", reader)");
                    throw missingProperty9;
                }
                objArr[2] = str4;
                if (str5 == null) {
                    JsonDataException missingProperty10 = Util.missingProperty("clientId", "clientId", reader);
                    m.f(missingProperty10, "missingProperty(\"clientId\", \"clientId\", reader)");
                    throw missingProperty10;
                }
                objArr[3] = str5;
                if (str6 == null) {
                    JsonDataException missingProperty11 = Util.missingProperty("clientSecret", "clientSecret", reader);
                    m.f(missingProperty11, "missingProperty(\"clientSecret\", \"clientSecret\", reader)");
                    throw missingProperty11;
                }
                objArr[4] = str6;
                if (str7 == null) {
                    JsonDataException missingProperty12 = Util.missingProperty("apiVersion", "apiVersion", reader);
                    m.f(missingProperty12, "missingProperty(\"apiVersion\", \"apiVersion\", reader)");
                    throw missingProperty12;
                }
                objArr[5] = str7;
                objArr[6] = bool2;
                objArr[7] = Integer.valueOf(i2);
                objArr[8] = null;
                ConsumerNetworkConfig newInstance = constructor.newInstance(objArr);
                m.f(newInstance, "localConstructor.newInstance(\n          baseApiURL ?: throw Util.missingProperty(\"baseApiURL\", \"baseApiURL\", reader),\n          baseApiV3URL ?: throw Util.missingProperty(\"baseApiV3URL\", \"baseApiV3URL\", reader),\n          oAuthApiURL ?: throw Util.missingProperty(\"oAuthApiURL\", \"oAuthApiURL\", reader),\n          clientId ?: throw Util.missingProperty(\"clientId\", \"clientId\", reader),\n          clientSecret ?: throw Util.missingProperty(\"clientSecret\", \"clientSecret\", reader),\n          apiVersion ?: throw Util.missingProperty(\"apiVersion\", \"apiVersion\", reader),\n          pinCertificates,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
                return newInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerNetworkConfig consumerNetworkConfig) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerNetworkConfig, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("baseApiURL");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkConfig.getBaseApiURL());
        writer.name("baseApiV3URL");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkConfig.getBaseApiV3URL());
        writer.name("oAuthApiURL");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkConfig.getOAuthApiURL());
        writer.name("clientId");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkConfig.getClientId());
        writer.name("clientSecret");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkConfig.getClientSecret());
        writer.name("apiVersion");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerNetworkConfig.getApiVersion());
        writer.name("pinCertificates");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(consumerNetworkConfig.getPinCertificates()));
        writer.endObject();
    }
}