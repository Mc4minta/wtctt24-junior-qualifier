package com.toshi.view.fragment;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.toshi.view.fragment.DisplayCoinAddressFragment;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;

/* compiled from: DisplayCoinAddressFragment_DisplayCoinAddressJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/toshi/view/fragment/DisplayCoinAddressFragment_DisplayCoinAddressJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/toshi/view/fragment/DisplayCoinAddressFragment$DisplayCoinAddress;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "a", "(Lcom/squareup/moshi/JsonReader;)Lcom/toshi/view/fragment/DisplayCoinAddressFragment$DisplayCoinAddress;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "b", "(Lcom/squareup/moshi/JsonWriter;Lcom/toshi/view/fragment/DisplayCoinAddressFragment$DisplayCoinAddress;)V", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "nullableIntAdapter", "intAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DisplayCoinAddressFragment_DisplayCoinAddressJsonAdapter extends JsonAdapter<DisplayCoinAddressFragment.DisplayCoinAddress> {
    private volatile Constructor<DisplayCoinAddressFragment.DisplayCoinAddress> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public DisplayCoinAddressFragment_DisplayCoinAddressJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        kotlin.jvm.internal.m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("address", "url", "addressName", "copyText");
        kotlin.jvm.internal.m.f(of, "of(\"address\", \"url\", \"addressName\",\n      \"copyText\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "address");
        kotlin.jvm.internal.m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"address\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, b3, "addressName");
        kotlin.jvm.internal.m.f(adapter2, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"addressName\")");
        this.nullableIntAdapter = adapter2;
        Class cls = Integer.TYPE;
        b4 = s0.b();
        JsonAdapter<Integer> adapter3 = moshi.adapter(cls, b4, "copyText");
        kotlin.jvm.internal.m.f(adapter3, "moshi.adapter(Int::class.java, emptySet(), \"copyText\")");
        this.intAdapter = adapter3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: a */
    public DisplayCoinAddressFragment.DisplayCoinAddress fromJson(JsonReader reader) {
        String str;
        kotlin.jvm.internal.m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        Integer num = null;
        Integer num2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("address", "address", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull, "unexpectedNull(\"address\",\n            \"address\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("url", "url", reader);
                    kotlin.jvm.internal.m.f(unexpectedNull2, "unexpectedNull(\"url\", \"url\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.nullableIntAdapter.fromJson(reader);
                i2 &= -5;
            } else if (selectName == 3 && (num2 = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("copyText", "copyText", reader);
                kotlin.jvm.internal.m.f(unexpectedNull3, "unexpectedNull(\"copyText\",\n            \"copyText\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (i2 == -5) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("address", "address", reader);
                kotlin.jvm.internal.m.f(missingProperty, "missingProperty(\"address\", \"address\", reader)");
                throw missingProperty;
            } else if (str3 == null) {
                JsonDataException missingProperty2 = Util.missingProperty("url", "url", reader);
                kotlin.jvm.internal.m.f(missingProperty2, "missingProperty(\"url\", \"url\", reader)");
                throw missingProperty2;
            } else if (num2 != null) {
                return new DisplayCoinAddressFragment.DisplayCoinAddress(str2, str3, num, num2.intValue());
            } else {
                JsonDataException missingProperty3 = Util.missingProperty("copyText", "copyText", reader);
                kotlin.jvm.internal.m.f(missingProperty3, "missingProperty(\"copyText\", \"copyText\", reader)");
                throw missingProperty3;
            }
        }
        Constructor<DisplayCoinAddressFragment.DisplayCoinAddress> constructor = this.constructorRef;
        if (constructor == null) {
            str = "missingProperty(\"address\", \"address\", reader)";
            Class cls = Integer.TYPE;
            constructor = DisplayCoinAddressFragment.DisplayCoinAddress.class.getDeclaredConstructor(String.class, String.class, Integer.class, cls, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            kotlin.jvm.internal.m.f(constructor, "DisplayCoinAddressFragment.DisplayCoinAddress::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, Int::class.javaObjectType, Int::class.javaPrimitiveType,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        } else {
            str = "missingProperty(\"address\", \"address\", reader)";
        }
        Object[] objArr = new Object[6];
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("address", "address", reader);
            kotlin.jvm.internal.m.f(missingProperty4, str);
            throw missingProperty4;
        }
        objArr[0] = str2;
        if (str3 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("url", "url", reader);
            kotlin.jvm.internal.m.f(missingProperty5, "missingProperty(\"url\", \"url\", reader)");
            throw missingProperty5;
        }
        objArr[1] = str3;
        objArr[2] = num;
        if (num2 == null) {
            JsonDataException missingProperty6 = Util.missingProperty("copyText", "copyText", reader);
            kotlin.jvm.internal.m.f(missingProperty6, "missingProperty(\"copyText\", \"copyText\", reader)");
            throw missingProperty6;
        }
        objArr[3] = Integer.valueOf(num2.intValue());
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = null;
        DisplayCoinAddressFragment.DisplayCoinAddress newInstance = constructor.newInstance(objArr);
        kotlin.jvm.internal.m.f(newInstance, "localConstructor.newInstance(\n          address ?: throw Util.missingProperty(\"address\", \"address\", reader),\n          url ?: throw Util.missingProperty(\"url\", \"url\", reader),\n          addressName,\n          copyText ?: throw Util.missingProperty(\"copyText\", \"copyText\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: b */
    public void toJson(JsonWriter writer, DisplayCoinAddressFragment.DisplayCoinAddress displayCoinAddress) {
        kotlin.jvm.internal.m.g(writer, "writer");
        Objects.requireNonNull(displayCoinAddress, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("address");
        this.stringAdapter.toJson(writer, (JsonWriter) displayCoinAddress.a());
        writer.name("url");
        this.stringAdapter.toJson(writer, (JsonWriter) displayCoinAddress.d());
        writer.name("addressName");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) displayCoinAddress.b());
        writer.name("copyText");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(displayCoinAddress.c()));
        writer.endObject();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(67);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DisplayCoinAddressFragment.DisplayCoinAddress");
        sb.append(')');
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}