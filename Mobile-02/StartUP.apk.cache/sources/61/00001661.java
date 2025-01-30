package com.coinbase.wallet.consumer.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAuthTokenJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAuthTokenJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/consumer/models/ConsumerAuthToken;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/consumer/models/ConsumerAuthToken;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/consumer/models/ConsumerAuthToken;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "longAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAuthTokenJsonAdapter extends JsonAdapter<ConsumerAuthToken> {
    private final JsonAdapter<Long> longAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsumerAuthTokenJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("accessToken", "tokenType", "expiresIn", "refreshToken", "scope");
        m.f(of, "of(\"accessToken\", \"tokenType\",\n      \"expiresIn\", \"refreshToken\", \"scope\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "accessToken");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"accessToken\")");
        this.stringAdapter = adapter;
        Class cls = Long.TYPE;
        b3 = s0.b();
        JsonAdapter<Long> adapter2 = moshi.adapter(cls, b3, "expiresIn");
        m.f(adapter2, "moshi.adapter(Long::class.java, emptySet(),\n      \"expiresIn\")");
        this.longAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ConsumerAuthToken");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsumerAuthToken fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Long l2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("accessToken", "accessToken", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"accessToken\", \"accessToken\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("tokenType", "tokenType", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"tokenType\",\n            \"tokenType\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                l2 = this.longAdapter.fromJson(reader);
                if (l2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("expiresIn", "expiresIn", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"expiresIn\",\n            \"expiresIn\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("refreshToken", "refreshToken", reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"refreshToken\", \"refreshToken\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (str4 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("scope", "scope", reader);
                m.f(unexpectedNull5, "unexpectedNull(\"scope\", \"scope\",\n            reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("accessToken", "accessToken", reader);
            m.f(missingProperty, "missingProperty(\"accessToken\", \"accessToken\",\n            reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("tokenType", "tokenType", reader);
            m.f(missingProperty2, "missingProperty(\"tokenType\", \"tokenType\", reader)");
            throw missingProperty2;
        } else if (l2 != null) {
            long longValue = l2.longValue();
            if (str3 == null) {
                JsonDataException missingProperty3 = Util.missingProperty("refreshToken", "refreshToken", reader);
                m.f(missingProperty3, "missingProperty(\"refreshToken\", \"refreshToken\",\n            reader)");
                throw missingProperty3;
            } else if (str4 != null) {
                return new ConsumerAuthToken(str, str2, longValue, str3, str4);
            } else {
                JsonDataException missingProperty4 = Util.missingProperty("scope", "scope", reader);
                m.f(missingProperty4, "missingProperty(\"scope\", \"scope\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("expiresIn", "expiresIn", reader);
            m.f(missingProperty5, "missingProperty(\"expiresIn\", \"expiresIn\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsumerAuthToken consumerAuthToken) {
        m.g(writer, "writer");
        Objects.requireNonNull(consumerAuthToken, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("accessToken");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAuthToken.getAccessToken());
        writer.name("tokenType");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAuthToken.getTokenType());
        writer.name("expiresIn");
        this.longAdapter.toJson(writer, (JsonWriter) Long.valueOf(consumerAuthToken.getExpiresIn()));
        writer.name("refreshToken");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAuthToken.getRefreshToken());
        writer.name("scope");
        this.stringAdapter.toJson(writer, (JsonWriter) consumerAuthToken.getScope());
        writer.endObject();
    }
}