package com.coinbase.ciphercore;

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

/* compiled from: CallMessageJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/coinbase/ciphercore/CallMessageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/ciphercore/CallMessage;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/ciphercore/CallMessage;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/ciphercore/CallMessage;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "listOfStringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "intAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CallMessageJsonAdapter extends JsonAdapter<CallMessage> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CallMessageJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "method", "params");
        kotlin.jvm.internal.m.f(of, "of(\"id\", \"method\", \"params\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "id");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "method");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"method\")");
        this.stringAdapter = adapter2;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b4 = s0.b();
        JsonAdapter<List<String>> adapter3 = moshi.adapter(newParameterizedType, b4, "params");
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"params\")");
        this.listOfStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CallMessage");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CallMessage fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
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
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("method", "method", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"method\",\n            \"method\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (list = this.listOfStringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("params", "params", reader);
                kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"params\",\n            \"params\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty("method", "method", reader);
                kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"method\", \"method\", reader)");
                throw missingProperty;
            } else if (list != null) {
                return new CallMessage(intValue, str, list);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty("params", "params", reader);
                kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"params\", \"params\", reader)");
                throw missingProperty2;
            }
        }
        JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
        kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CallMessage callMessage) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(callMessage, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(callMessage.getId()));
        writer.name("method");
        this.stringAdapter.toJson(writer, (JsonWriter) callMessage.getMethod());
        writer.name("params");
        this.listOfStringAdapter.toJson(writer, (JsonWriter) callMessage.getParams());
        writer.endObject();
    }
}