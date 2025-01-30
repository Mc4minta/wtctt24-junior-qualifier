package com.toshi.view.activity.webView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: JSBookmarkJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/toshi/view/activity/webView/JSBookmarkJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/toshi/view/activity/webView/JSBookmark;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "a", "(Lcom/squareup/moshi/JsonReader;)Lcom/toshi/view/activity/webView/JSBookmark;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "b", "(Lcom/squareup/moshi/JsonWriter;Lcom/toshi/view/activity/webView/JSBookmark;)V", "Ljava/util/Date;", "dateAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JSBookmarkJsonAdapter extends JsonAdapter<JSBookmark> {
    private final JsonAdapter<Date> dateAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public JSBookmarkJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", MessageBundle.TITLE_ENTRY, "address", "createdAt");
        m.f(of, "of(\"id\", \"title\", \"address\",\n      \"createdAt\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Date> adapter2 = moshi.adapter(Date.class, b3, "createdAt");
        m.f(adapter2, "moshi.adapter(Date::class.java, emptySet(),\n      \"createdAt\")");
        this.dateAdapter = adapter2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: a */
    public JSBookmark fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        Date date = null;
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
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"title\", \"title\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("address", "address", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"address\",\n            \"address\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (date = this.dateAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("createdAt", "createdAt", reader);
                m.f(unexpectedNull4, "unexpectedNull(\"createdAt\",\n            \"createdAt\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
            m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, reader);
            m.f(missingProperty2, "missingProperty(\"title\", \"title\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("address", "address", reader);
            m.f(missingProperty3, "missingProperty(\"address\", \"address\", reader)");
            throw missingProperty3;
        } else if (date != null) {
            return new JSBookmark(str, str2, str3, date);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("createdAt", "createdAt", reader);
            m.f(missingProperty4, "missingProperty(\"createdAt\", \"createdAt\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: b */
    public void toJson(JsonWriter writer, JSBookmark jSBookmark) {
        m.g(writer, "writer");
        Objects.requireNonNull(jSBookmark, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) jSBookmark.d());
        writer.name(MessageBundle.TITLE_ENTRY);
        this.stringAdapter.toJson(writer, (JsonWriter) jSBookmark.e());
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) jSBookmark.b());
        writer.name("createdAt");
        this.dateAdapter.toJson(writer, (JsonWriter) jSBookmark.c());
        writer.endObject();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(");
        sb.append("JSBookmark");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}