package com.coinbase.walletengine.services.example;

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

/* compiled from: RelationshipJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/coinbase/walletengine/services/example/RelationshipJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/example/Relationship;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/example/Relationship;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/example/Relationship;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/walletengine/services/example/Person;", "personAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RelationshipJsonAdapter extends JsonAdapter<Relationship> {
    private final JsonReader.Options options;
    private final JsonAdapter<Person> personAdapter;
    private final JsonAdapter<String> stringAdapter;

    public RelationshipJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("relation", "person", "toPerson");
        kotlin.jvm.internal.m.f(of, "of(\"relation\", \"person\", \"toPerson\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "relation");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"relation\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Person> adapter2 = moshi.adapter(Person.class, b3, "person");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(Person::class.java, emptySet(),\n      \"person\")");
        this.personAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Relationship");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Relationship fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        Person person = null;
        Person person2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("relation", "relation", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"relation\",\n            \"relation\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                person = this.personAdapter.fromJson(reader);
                if (person == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("person", "person", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"person\",\n            \"person\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (person2 = this.personAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("toPerson", "toPerson", reader);
                kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"toPerson\",\n            \"toPerson\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("relation", "relation", reader);
            kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"relation\", \"relation\", reader)");
            throw missingProperty;
        } else if (person == null) {
            JsonDataException missingProperty2 = Util.missingProperty("person", "person", reader);
            kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"person\", \"person\", reader)");
            throw missingProperty2;
        } else if (person2 != null) {
            return new Relationship(str, person, person2);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("toPerson", "toPerson", reader);
            kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"toPerson\", \"toPerson\", reader)");
            throw missingProperty3;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Relationship relationship) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(relationship, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("relation");
        this.stringAdapter.toJson(writer, (JsonWriter) relationship.getRelation());
        writer.name("person");
        this.personAdapter.toJson(writer, (JsonWriter) relationship.getPerson());
        writer.name("toPerson");
        this.personAdapter.toJson(writer, (JsonWriter) relationship.getToPerson());
        writer.endObject();
    }
}