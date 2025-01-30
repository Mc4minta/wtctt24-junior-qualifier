package com.toshi.model.network;

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

/* compiled from: MinimumSupportBuildJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/toshi/model/network/MinimumSupportBuildJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/toshi/model/network/MinimumSupportBuild;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/toshi/model/network/MinimumSupportBuild;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/toshi/model/network/MinimumSupportBuild;)V", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MinimumSupportBuildJsonAdapter extends JsonAdapter<MinimumSupportBuild> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;

    public MinimumSupportBuildJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("android", "ios");
        m.f(of, "of(\"android\", \"ios\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "android");
        m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"android\")");
        this.intAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(");
        sb.append("MinimumSupportBuild");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public MinimumSupportBuild fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        Integer num = null;
        Integer num2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("android", "android", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"android\",\n            \"android\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (num2 = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("ios", "ios", reader);
                m.f(unexpectedNull2, "unexpectedNull(\"ios\", \"ios\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                return new MinimumSupportBuild(intValue, num2.intValue());
            }
            JsonDataException missingProperty = Util.missingProperty("ios", "ios", reader);
            m.f(missingProperty, "missingProperty(\"ios\", \"ios\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("android", "android", reader);
        m.f(missingProperty2, "missingProperty(\"android\", \"android\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, MinimumSupportBuild minimumSupportBuild) {
        m.g(writer, "writer");
        Objects.requireNonNull(minimumSupportBuild, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("android");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(minimumSupportBuild.getAndroid()));
        writer.name("ios");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(minimumSupportBuild.getIos()));
        writer.endObject();
    }
}