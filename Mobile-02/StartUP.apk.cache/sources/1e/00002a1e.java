package com.coinbase.walletengine.models;

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

/* compiled from: ResponseMessageJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/walletengine/models/ResponseMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/ResponseMessage;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/models/ResponseMessage;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/models/ResponseMessage;)V", "nullableStringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "stringAdapter", "", "intAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ResponseMessageJsonAdapter extends JsonAdapter<ResponseMessage> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ResponseMessageJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "valueJSON", "error");
        m.f(of, "of(\"id\", \"valueJSON\", \"error\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "id");
        m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "valueJSON");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"valueJSON\")");
        this.stringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "error");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"error\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ResponseMessage");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ResponseMessage fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        String str = null;
        String str2 = null;
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
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("valueJSON", "valueJSON", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"valueJSON\",\n            \"valueJSON\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (str != null) {
                return new ResponseMessage(intValue, str, str2);
            }
            JsonDataException missingProperty = Util.missingProperty("valueJSON", "valueJSON", reader);
            m.f(missingProperty, "missingProperty(\"valueJSON\", \"valueJSON\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("id", "id", reader);
        m.f(missingProperty2, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ResponseMessage responseMessage) {
        m.g(writer, "writer");
        Objects.requireNonNull(responseMessage, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(responseMessage.getId()));
        writer.name("valueJSON");
        this.stringAdapter.toJson(writer, (JsonWriter) responseMessage.getValueJSON());
        writer.name("error");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) responseMessage.getError());
        writer.endObject();
    }
}