package com.toshi.model.local.room;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: PromptJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R$\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014¨\u0006!"}, d2 = {"Lcom/toshi/model/local/room/PromptJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/toshi/model/local/room/Prompt;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/toshi/model/local/room/Prompt;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/toshi/model/local/room/Prompt;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "intAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableIntAdapter", "", "nullableArrayOfStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PromptJsonAdapter extends JsonAdapter<Prompt> {
    private volatile Constructor<Prompt> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String[]> nullableArrayOfStringAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public PromptJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", MessageBundle.TITLE_ENTRY, ApiConstants.MESSAGE, "formatArgs", "imageResource", "firstButtonId", "secondButtonId", "thirdButtonId");
        m.f(of, "of(\"id\", \"title\", \"message\",\n      \"formatArgs\", \"imageResource\", \"firstButtonId\", \"secondButtonId\", \"thirdButtonId\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        Class cls = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls, b3, MessageBundle.TITLE_ENTRY);
        m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(), \"title\")");
        this.intAdapter = adapter2;
        GenericArrayType arrayOf = Types.arrayOf(String.class);
        b4 = s0.b();
        JsonAdapter<String[]> adapter3 = moshi.adapter(arrayOf, b4, "formatArgs");
        m.f(adapter3, "moshi.adapter(Types.arrayOf(String::class.java), emptySet(), \"formatArgs\")");
        this.nullableArrayOfStringAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.class, b5, "imageResource");
        m.f(adapter4, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"imageResource\")");
        this.nullableIntAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(28);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Prompt");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Prompt fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        Integer num = null;
        String str2 = null;
        Integer num2 = null;
        String[] strArr = null;
        Integer num3 = null;
        Integer num4 = null;
        Integer num5 = null;
        Integer num6 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", reader);
                        m.f(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    num = this.intAdapter.fromJson(reader);
                    if (num == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"title\", \"title\",\n            reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    num2 = this.intAdapter.fromJson(reader);
                    if (num2 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
                        m.f(unexpectedNull3, "unexpectedNull(\"message\",\n            \"message\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    strArr = this.nullableArrayOfStringAdapter.fromJson(reader);
                    i2 &= -9;
                    break;
                case 4:
                    num3 = this.nullableIntAdapter.fromJson(reader);
                    i2 &= -17;
                    break;
                case 5:
                    num4 = this.nullableIntAdapter.fromJson(reader);
                    i2 &= -33;
                    break;
                case 6:
                    num5 = this.nullableIntAdapter.fromJson(reader);
                    i2 &= -65;
                    break;
                case 7:
                    num6 = this.nullableIntAdapter.fromJson(reader);
                    i2 &= -129;
                    break;
            }
        }
        reader.endObject();
        if (i2 == -249) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            } else if (num != null) {
                int intValue = num.intValue();
                if (num2 != null) {
                    return new Prompt(str2, intValue, num2.intValue(), strArr, num3, num4, num5, num6);
                }
                JsonDataException missingProperty2 = Util.missingProperty(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
                m.f(missingProperty2, "missingProperty(\"message\", \"message\", reader)");
                throw missingProperty2;
            } else {
                JsonDataException missingProperty3 = Util.missingProperty(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, reader);
                m.f(missingProperty3, "missingProperty(\"title\", \"title\", reader)");
                throw missingProperty3;
            }
        }
        Constructor<Prompt> constructor = this.constructorRef;
        if (constructor == null) {
            str = MessageBundle.TITLE_ENTRY;
            Class cls = Integer.TYPE;
            constructor = Prompt.class.getDeclaredConstructor(String.class, cls, cls, String[].class, Integer.class, Integer.class, Integer.class, Integer.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "Prompt::class.java.getDeclaredConstructor(String::class.java,\n          Int::class.javaPrimitiveType, Int::class.javaPrimitiveType, Array<String>::class.java,\n          Int::class.javaObjectType, Int::class.javaObjectType, Int::class.javaObjectType,\n          Int::class.javaObjectType, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        } else {
            str = MessageBundle.TITLE_ENTRY;
        }
        Object[] objArr = new Object[10];
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty4, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty4;
        }
        objArr[0] = str2;
        if (num != null) {
            objArr[1] = Integer.valueOf(num.intValue());
            if (num2 == null) {
                JsonDataException missingProperty5 = Util.missingProperty(ApiConstants.MESSAGE, ApiConstants.MESSAGE, reader);
                m.f(missingProperty5, "missingProperty(\"message\", \"message\", reader)");
                throw missingProperty5;
            }
            objArr[2] = Integer.valueOf(num2.intValue());
            objArr[3] = strArr;
            objArr[4] = num3;
            objArr[5] = num4;
            objArr[6] = num5;
            objArr[7] = num6;
            objArr[8] = Integer.valueOf(i2);
            objArr[9] = null;
            Prompt newInstance = constructor.newInstance(objArr);
            m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          title ?: throw Util.missingProperty(\"title\", \"title\", reader),\n          message ?: throw Util.missingProperty(\"message\", \"message\", reader),\n          formatArgs,\n          imageResource,\n          firstButtonId,\n          secondButtonId,\n          thirdButtonId,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
            return newInstance;
        }
        String str3 = str;
        JsonDataException missingProperty6 = Util.missingProperty(str3, str3, reader);
        m.f(missingProperty6, "missingProperty(\"title\", \"title\", reader)");
        throw missingProperty6;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Prompt prompt) {
        m.g(writer, "writer");
        Objects.requireNonNull(prompt, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) prompt.getId());
        writer.name(MessageBundle.TITLE_ENTRY);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(prompt.getTitle()));
        writer.name(ApiConstants.MESSAGE);
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(prompt.getMessage()));
        writer.name("formatArgs");
        this.nullableArrayOfStringAdapter.toJson(writer, (JsonWriter) prompt.getFormatArgs());
        writer.name("imageResource");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) prompt.getImageResource());
        writer.name("firstButtonId");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) prompt.getFirstButtonId());
        writer.name("secondButtonId");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) prompt.getSecondButtonId());
        writer.name("thirdButtonId");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) prompt.getThirdButtonId());
        writer.endObject();
    }
}