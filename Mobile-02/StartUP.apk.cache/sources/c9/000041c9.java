package com.toshi.view.activity.webView;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: MessageJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/toshi/view/activity/webView/MessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/toshi/view/activity/webView/Message;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "a", "(Lcom/squareup/moshi/JsonReader;)Lcom/toshi/view/activity/webView/Message;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "b", "(Lcom/squareup/moshi/JsonWriter;Lcom/toshi/view/activity/webView/Message;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "", "listOfStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MessageJsonAdapter extends JsonAdapter<Message> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", ApiConstants.NAME, "data");
        m.f(of, "of(\"id\", \"name\", \"data\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "id");
        m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, ApiConstants.NAME);
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"name\")");
        this.stringAdapter = adapter2;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b4 = s0.b();
        JsonAdapter<List<String>> adapter3 = moshi.adapter(newParameterizedType, b4, "data");
        m.f(adapter3, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"data\")");
        this.listOfStringAdapter = adapter3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: a */
    public Message fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        String str = null;
        List<String> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (list = this.listOfStringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("data_", "data", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"data_\",\n            \"data\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
                m.f(missingProperty, "missingProperty(\"name\", \"name\", reader)");
                throw missingProperty;
            } else if (list != null) {
                return new Message(intValue, str, list);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty("data_", "data", reader);
                m.f(missingProperty2, "missingProperty(\"data_\", \"data\", reader)");
                throw missingProperty2;
            }
        }
        JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
        m.f(missingProperty3, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: b */
    public void toJson(JsonWriter writer, Message message) {
        m.g(writer, "writer");
        Objects.requireNonNull(message, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(message.b()));
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) message.c());
        writer.name("data");
        this.listOfStringAdapter.toJson(writer, (JsonWriter) message.a());
        writer.endObject();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Message");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}