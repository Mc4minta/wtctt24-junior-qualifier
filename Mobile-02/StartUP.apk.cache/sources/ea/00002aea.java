package com.coinbase.walletengine.services.resolver;

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

/* compiled from: ResolutionResultJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/coinbase/walletengine/services/resolver/ResolutionResultJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/resolver/ResolutionResult;)V", "Lcom/coinbase/walletengine/services/resolver/ResolveType;", "resolveTypeAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ResolutionResultJsonAdapter extends JsonAdapter<ResolutionResult> {
    private final JsonReader.Options options;
    private final JsonAdapter<ResolveType> resolveTypeAdapter;
    private final JsonAdapter<String> stringAdapter;

    public ResolutionResultJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("address", "resolveType");
        m.f(of, "of(\"address\", \"resolveType\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "address");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"address\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<ResolveType> adapter2 = moshi.adapter(ResolveType.class, b3, "resolveType");
        m.f(adapter2, "moshi.adapter(ResolveType::class.java,\n      emptySet(), \"resolveType\")");
        this.resolveTypeAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ResolutionResult");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ResolutionResult fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        ResolveType resolveType = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("address", "address", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"address\",\n            \"address\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (resolveType = this.resolveTypeAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("resolveType", "resolveType", reader);
                m.f(unexpectedNull2, "unexpectedNull(\"resolveType\", \"resolveType\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("address", "address", reader);
            m.f(missingProperty, "missingProperty(\"address\", \"address\", reader)");
            throw missingProperty;
        } else if (resolveType != null) {
            return new ResolutionResult(str, resolveType);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("resolveType", "resolveType", reader);
            m.f(missingProperty2, "missingProperty(\"resolveType\", \"resolveType\",\n            reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ResolutionResult resolutionResult) {
        m.g(writer, "writer");
        Objects.requireNonNull(resolutionResult, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) resolutionResult.getAddress());
        writer.name("resolveType");
        this.resolveTypeAdapter.toJson(writer, (JsonWriter) resolutionResult.getResolveType());
        writer.endObject();
    }
}