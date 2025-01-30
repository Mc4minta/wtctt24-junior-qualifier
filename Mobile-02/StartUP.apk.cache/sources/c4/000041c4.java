package com.toshi.view.activity.webView;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: DappInfoJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00160\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/toshi/view/activity/webView/DappInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/toshi/view/activity/webView/DappInfo;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "a", "(Lcom/squareup/moshi/JsonReader;)Lcom/toshi/view/activity/webView/DappInfo;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "b", "(Lcom/squareup/moshi/JsonWriter;Lcom/toshi/view/activity/webView/DappInfo;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "", "nullableListOfStringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DappInfoJsonAdapter extends JsonAdapter<DappInfo> {
    private volatile Constructor<DappInfo> constructorRef;
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public DappInfoJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ApiConstants.NAME, "categories");
        m.f(of, "of(\"name\", \"categories\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, ApiConstants.NAME);
        m.f(adapter, "moshi.adapter(String::class.java,\n      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter;
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
        b3 = s0.b();
        JsonAdapter<List<String>> adapter2 = moshi.adapter(newParameterizedType, b3, "categories");
        m.f(adapter2, "moshi.adapter(Types.newParameterizedType(List::class.java, String::class.java), emptySet(),\n      \"categories\")");
        this.nullableListOfStringAdapter = adapter2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: a */
    public DappInfo fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str = null;
        List<String> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(reader);
                i2 &= -2;
            } else if (selectName == 1) {
                list = this.nullableListOfStringAdapter.fromJson(reader);
                i2 &= -3;
            }
        }
        reader.endObject();
        if (i2 == -4) {
            return new DappInfo(str, list);
        }
        Constructor<DappInfo> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = DappInfo.class.getDeclaredConstructor(String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "DappInfo::class.java.getDeclaredConstructor(String::class.java, List::class.java,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        }
        DappInfo newInstance = constructor.newInstance(str, list, Integer.valueOf(i2), null);
        m.f(newInstance, "localConstructor.newInstance(\n          name,\n          categories,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    /* renamed from: b */
    public void toJson(JsonWriter writer, DappInfo dappInfo) {
        m.g(writer, "writer");
        Objects.requireNonNull(dappInfo, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(ApiConstants.NAME);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) dappInfo.b());
        writer.name("categories");
        this.nullableListOfStringAdapter.toJson(writer, (JsonWriter) dappInfo.a());
        writer.endObject();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DappInfo");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}