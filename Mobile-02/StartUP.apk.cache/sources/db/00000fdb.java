package com.coinbase.ciphercore;

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

/* compiled from: SerializedERC20TransferParamsJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/coinbase/ciphercore/SerializedERC20TransferParamsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/ciphercore/SerializedERC20TransferParams;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/ciphercore/SerializedERC20TransferParams;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/ciphercore/SerializedERC20TransferParams;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SerializedERC20TransferParamsJsonAdapter extends JsonAdapter<SerializedERC20TransferParams> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SerializedERC20TransferParamsJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("toAddress", "data");
        kotlin.jvm.internal.m.f(of, "of(\"toAddress\", \"data\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "toAddress");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"toAddress\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(51);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SerializedERC20TransferParams");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SerializedERC20TransferParams fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("toAddress", "toAddress", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"toAddress\",\n            \"toAddress\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (str2 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("data_", "data", reader);
                kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("toAddress", "toAddress", reader);
            kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"toAddress\", \"toAddress\", reader)");
            throw missingProperty;
        } else if (str2 != null) {
            return new SerializedERC20TransferParams(str, str2);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("data_", "data", reader);
            kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"data_\", \"data\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SerializedERC20TransferParams serializedERC20TransferParams) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(serializedERC20TransferParams, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("toAddress");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedERC20TransferParams.getToAddress());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) serializedERC20TransferParams.getData());
        writer.endObject();
    }
}