package com.coinbase.walletengine.services.example;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.s0;

/* compiled from: PersonJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00018\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/coinbase/walletengine/services/example/PersonJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/services/example/Person;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletengine/services/example/Person;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletengine/services/example/Person;)V", "Ljava/math/BigInteger;", "bigIntegerAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/coinbase/walletengine/services/example/MetaData;", "mapOfStringMetaDataAdapter", "", "Lcom/coinbase/walletengine/services/example/Skill;", "listOfSkillAdapter", "Lkotlin/UInt;", "uIntAdapter", "stringAdapter", "Lcom/coinbase/walletengine/services/example/Religion;", "nullableReligionAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "", "booleanAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PersonJsonAdapter extends JsonAdapter<Person> {
    private final JsonAdapter<BigInteger> bigIntegerAdapter;
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<List<Skill>> listOfSkillAdapter;
    private final JsonAdapter<Map<String, MetaData>> mapOfStringMetaDataAdapter;
    private final JsonAdapter<Religion> nullableReligionAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<UInt> uIntAdapter;

    public PersonJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        Set<? extends Annotation> b7;
        Set<? extends Annotation> b8;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("firstName", "lastName", "age", "married", "netWorth", "skills", "religion", "meta");
        kotlin.jvm.internal.m.f(of, "of(\"firstName\", \"lastName\", \"age\",\n      \"married\", \"netWorth\", \"skills\", \"religion\", \"meta\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "firstName");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"firstName\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<UInt> adapter2 = moshi.adapter(UInt.class, b3, "age");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(UInt::class.java, emptySet(), \"age\")");
        this.uIntAdapter = adapter2;
        Class cls = Boolean.TYPE;
        b4 = s0.b();
        JsonAdapter<Boolean> adapter3 = moshi.adapter(cls, b4, "married");
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(Boolean::class.java, emptySet(),\n      \"married\")");
        this.booleanAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<BigInteger> adapter4 = moshi.adapter(BigInteger.class, b5, "netWorth");
        kotlin.jvm.internal.m.f(adapter4, "moshi.adapter(BigInteger::class.java,\n      emptySet(), \"netWorth\")");
        this.bigIntegerAdapter = adapter4;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Skill.class);
        b6 = s0.b();
        JsonAdapter<List<Skill>> adapter5 = moshi.adapter(newParameterizedType, b6, "skills");
        kotlin.jvm.internal.m.f(adapter5, "moshi.adapter(Types.newParameterizedType(List::class.java, Skill::class.java), emptySet(),\n      \"skills\")");
        this.listOfSkillAdapter = adapter5;
        b7 = s0.b();
        JsonAdapter<Religion> adapter6 = moshi.adapter(Religion.class, b7, "religion");
        kotlin.jvm.internal.m.f(adapter6, "moshi.adapter(Religion::class.java,\n      emptySet(), \"religion\")");
        this.nullableReligionAdapter = adapter6;
        ParameterizedType newParameterizedType2 = Types.newParameterizedType(Map.class, String.class, MetaData.class);
        b8 = s0.b();
        JsonAdapter<Map<String, MetaData>> adapter7 = moshi.adapter(newParameterizedType2, b8, "meta");
        kotlin.jvm.internal.m.f(adapter7, "moshi.adapter(Types.newParameterizedType(Map::class.java, String::class.java,\n      MetaData::class.java), emptySet(), \"meta\")");
        this.mapOfStringMetaDataAdapter = adapter7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(28);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Person");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Person fromJson(JsonReader reader) {
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        UInt uInt = null;
        Boolean bool = null;
        String str = null;
        String str2 = null;
        BigInteger bigInteger = null;
        List<Skill> list = null;
        Religion religion = null;
        Map<String, MetaData> map = null;
        while (true) {
            Religion religion2 = religion;
            Map<String, MetaData> map2 = map;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        religion = religion2;
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("firstName", "firstName", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"firstName\",\n            \"firstName\", reader)");
                            throw unexpectedNull;
                        }
                        religion = religion2;
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("lastName", "lastName", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"lastName\",\n            \"lastName\", reader)");
                            throw unexpectedNull2;
                        }
                        religion = religion2;
                        break;
                    case 2:
                        uInt = this.uIntAdapter.fromJson(reader);
                        if (uInt == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("age", "age", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"age\", \"age\", reader)");
                            throw unexpectedNull3;
                        }
                        religion = religion2;
                        break;
                    case 3:
                        bool = this.booleanAdapter.fromJson(reader);
                        if (bool == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("married", "married", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull4, "unexpectedNull(\"married\",\n            \"married\", reader)");
                            throw unexpectedNull4;
                        }
                        religion = religion2;
                        break;
                    case 4:
                        bigInteger = this.bigIntegerAdapter.fromJson(reader);
                        if (bigInteger == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("netWorth", "netWorth", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull5, "unexpectedNull(\"netWorth\",\n            \"netWorth\", reader)");
                            throw unexpectedNull5;
                        }
                        religion = religion2;
                        break;
                    case 5:
                        list = this.listOfSkillAdapter.fromJson(reader);
                        if (list == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("skills", "skills", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull6, "unexpectedNull(\"skills\",\n            \"skills\", reader)");
                            throw unexpectedNull6;
                        }
                        religion = religion2;
                        break;
                    case 6:
                        religion = this.nullableReligionAdapter.fromJson(reader);
                        break;
                    case 7:
                        map = this.mapOfStringMetaDataAdapter.fromJson(reader);
                        if (map == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("meta", "meta", reader);
                            kotlin.jvm.internal.m.f(unexpectedNull7, "unexpectedNull(\"meta\",\n            \"meta\", reader)");
                            throw unexpectedNull7;
                        }
                        religion = religion2;
                        continue;
                    default:
                        religion = religion2;
                        break;
                }
                map = map2;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("firstName", "firstName", reader);
                    kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"firstName\", \"firstName\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("lastName", "lastName", reader);
                    kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"lastName\", \"lastName\", reader)");
                    throw missingProperty2;
                } else if (uInt != null) {
                    int B = uInt.B();
                    if (bool != null) {
                        boolean booleanValue = bool.booleanValue();
                        if (bigInteger == null) {
                            JsonDataException missingProperty3 = Util.missingProperty("netWorth", "netWorth", reader);
                            kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"netWorth\", \"netWorth\", reader)");
                            throw missingProperty3;
                        } else if (list == null) {
                            JsonDataException missingProperty4 = Util.missingProperty("skills", "skills", reader);
                            kotlin.jvm.internal.m.f(missingProperty4, "missingProperty(\"skills\", \"skills\", reader)");
                            throw missingProperty4;
                        } else if (map2 != null) {
                            return new Person(str, str2, B, booleanValue, bigInteger, list, religion2, map2, null);
                        } else {
                            JsonDataException missingProperty5 = Util.missingProperty("meta", "meta", reader);
                            kotlin.jvm.internal.m.f(missingProperty5, "missingProperty(\"meta\", \"meta\", reader)");
                            throw missingProperty5;
                        }
                    }
                    JsonDataException missingProperty6 = Util.missingProperty("married", "married", reader);
                    kotlin.jvm.internal.m.f(missingProperty6, "missingProperty(\"married\", \"married\", reader)");
                    throw missingProperty6;
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("age", "age", reader);
                    kotlin.jvm.internal.m.f(missingProperty7, "missingProperty(\"age\", \"age\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Person person) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(person, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("firstName");
        this.stringAdapter.toJson(writer, (JsonWriter) person.getFirstName());
        writer.name("lastName");
        this.stringAdapter.toJson(writer, (JsonWriter) person.getLastName());
        writer.name("age");
        this.uIntAdapter.toJson(writer, (JsonWriter) UInt.h(person.m2043getAgepVg5ArA()));
        writer.name("married");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(person.getMarried()));
        writer.name("netWorth");
        this.bigIntegerAdapter.toJson(writer, (JsonWriter) person.getNetWorth());
        writer.name("skills");
        this.listOfSkillAdapter.toJson(writer, (JsonWriter) person.getSkills());
        writer.name("religion");
        this.nullableReligionAdapter.toJson(writer, (JsonWriter) person.getReligion());
        writer.name("meta");
        this.mapOfStringMetaDataAdapter.toJson(writer, (JsonWriter) person.getMeta());
        writer.endObject();
    }
}