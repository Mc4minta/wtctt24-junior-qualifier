package com.coinbase.wallet.swap.models;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: AggregatorJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/swap/models/AggregatorJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/swap/models/Aggregator;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/swap/models/Aggregator;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/swap/models/Aggregator;)V", "", "booleanAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Ljava/net/URL;", "uRLAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AggregatorJsonAdapter extends JsonAdapter<Aggregator> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<URL> uRLAdapter;

    public AggregatorJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", ApiConstants.NAME, "url", "toSwapEnabled");
        m.f(of, "of(\"id\", \"name\", \"url\",\n      \"toSwapEnabled\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<URL> adapter2 = moshi.adapter(URL.class, b3, "url");
        m.f(adapter2, "moshi.adapter(URL::class.java, emptySet(), \"url\")");
        this.uRLAdapter = adapter2;
        Class cls = Boolean.TYPE;
        b4 = s0.b();
        JsonAdapter<Boolean> adapter3 = moshi.adapter(cls, b4, "toSwapEnabled");
        m.f(adapter3, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"toSwapEnabled\")");
        this.booleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Aggregator");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Aggregator fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        URL url = null;
        Boolean bool = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                url = this.uRLAdapter.fromJson(reader);
                if (url == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("url", "url", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"url\", \"url\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (bool = this.booleanAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("toSwapEnabled", "toSwapEnabled", reader);
                m.f(unexpectedNull4, "unexpectedNull(\"toSwapEnabled\", \"toSwapEnabled\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
            m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            m.f(missingProperty2, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty2;
        } else if (url == null) {
            JsonDataException missingProperty3 = Util.missingProperty("url", "url", reader);
            m.f(missingProperty3, "missingProperty(\"url\", \"url\", reader)");
            throw missingProperty3;
        } else if (bool != null) {
            return new Aggregator(str, str2, url, bool.booleanValue());
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("toSwapEnabled", "toSwapEnabled", reader);
            m.f(missingProperty4, "missingProperty(\"toSwapEnabled\",\n            \"toSwapEnabled\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Aggregator aggregator) {
        m.g(writer, "writer");
        Objects.requireNonNull(aggregator, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) aggregator.getId());
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) aggregator.getName());
        writer.name("url");
        this.uRLAdapter.toJson(writer, (JsonWriter) aggregator.getUrl());
        writer.name("toSwapEnabled");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(aggregator.getToSwapEnabled()));
        writer.endObject();
    }
}