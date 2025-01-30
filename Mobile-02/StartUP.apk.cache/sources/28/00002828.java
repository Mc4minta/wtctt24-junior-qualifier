package com.coinbase.wallet.user.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: UserJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/user/models/UserJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/user/models/User;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/user/models/User;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/user/models/User;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "nullableBooleanAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "", "intAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UserJsonAdapter extends JsonAdapter<User> {
    private volatile Constructor<User> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public UserJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "username", "isPublic");
        m.f(of, "of(\"id\", \"username\", \"isPublic\")");
        this.options = of;
        Class cls = Integer.TYPE;
        b2 = s0.b();
        JsonAdapter<Integer> adapter = moshi.adapter(cls, b2, "id");
        m.f(adapter, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, b3, "username");
        m.f(adapter2, "moshi.adapter(String::class.java, emptySet(),\n      \"username\")");
        this.stringAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, b4, "isPublic");
        m.f(adapter3, "moshi.adapter(Boolean::class.javaObjectType, emptySet(), \"isPublic\")");
        this.nullableBooleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(26);
        sb.append("GeneratedJsonAdapter(");
        sb.append("User");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public User fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        Integer num = null;
        String str = null;
        Boolean bool = null;
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
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("username", "username", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"username\",\n            \"username\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                bool = this.nullableBooleanAdapter.fromJson(reader);
                i2 &= -5;
            }
        }
        reader.endObject();
        if (i2 == -5) {
            if (num != null) {
                int intValue = num.intValue();
                if (str != null) {
                    return new User(intValue, str, bool);
                }
                JsonDataException missingProperty = Util.missingProperty("username", "username", reader);
                m.f(missingProperty, "missingProperty(\"username\", \"username\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty2, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty2;
        }
        Constructor<User> constructor = this.constructorRef;
        if (constructor == null) {
            Class cls = Integer.TYPE;
            constructor = User.class.getDeclaredConstructor(cls, String.class, Boolean.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "User::class.java.getDeclaredConstructor(Int::class.javaPrimitiveType, String::class.java,\n          Boolean::class.javaObjectType, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        if (num != null) {
            objArr[0] = Integer.valueOf(num.intValue());
            if (str == null) {
                JsonDataException missingProperty3 = Util.missingProperty("username", "username", reader);
                m.f(missingProperty3, "missingProperty(\"username\", \"username\", reader)");
                throw missingProperty3;
            }
            objArr[1] = str;
            objArr[2] = bool;
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = null;
            User newInstance = constructor.newInstance(objArr);
            m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          username ?: throw Util.missingProperty(\"username\", \"username\", reader),\n          isPublic,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
            return newInstance;
        }
        JsonDataException missingProperty4 = Util.missingProperty("id", "id", reader);
        m.f(missingProperty4, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty4;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, User user) {
        m.g(writer, "writer");
        Objects.requireNonNull(user, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(user.getId()));
        writer.name("username");
        this.stringAdapter.toJson(writer, (JsonWriter) user.getUsername());
        writer.name("isPublic");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) user.isPublic());
        writer.endObject();
    }
}