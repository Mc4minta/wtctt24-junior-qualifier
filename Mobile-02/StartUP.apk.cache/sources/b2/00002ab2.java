package com.coinbase.walletengine.services.example;

import com.coinbase.ApiConstants;
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

/* compiled from: SkillJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/coinbase/walletengine/services/example/SkillJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/example/Skill;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/example/Skill;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/example/Skill;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/walletengine/services/example/SkillLevel;", "skillLevelAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SkillJsonAdapter extends JsonAdapter<Skill> {
    private final JsonReader.Options options;
    private final JsonAdapter<SkillLevel> skillLevelAdapter;
    private final JsonAdapter<String> stringAdapter;

    public SkillJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.NAME, "skillLevel");
        kotlin.jvm.internal.m.f(of, "of(\"name\", \"skillLevel\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.NAME);
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"name\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<SkillLevel> adapter2 = moshi.adapter(SkillLevel.class, b3, "skillLevel");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(SkillLevel::class.java,\n      emptySet(), \"skillLevel\")");
        this.skillLevelAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(27);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Skill");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Skill fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        SkillLevel skillLevel = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(ApiConstants.NAME, ApiConstants.NAME, reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (skillLevel = this.skillLevelAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("skillLevel", "skillLevel", reader);
                kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"skillLevel\", \"skillLevel\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(ApiConstants.NAME, ApiConstants.NAME, reader);
            kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty;
        } else if (skillLevel != null) {
            return new Skill(str, skillLevel);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("skillLevel", "skillLevel", reader);
            kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"skillLevel\", \"skillLevel\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Skill skill) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(skill, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.NAME);
        this.stringAdapter.toJson(writer, (JsonWriter) skill.getName());
        writer.name("skillLevel");
        this.skillLevelAdapter.toJson(writer, (JsonWriter) skill.getSkillLevel());
        writer.endObject();
    }
}