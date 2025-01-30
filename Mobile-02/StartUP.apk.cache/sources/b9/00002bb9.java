package com.coinbase.walletlink.dtos;

import android.net.Uri;
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

/* compiled from: Web3RequestCanceledDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Landroid/net/Uri;", "uriAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3RequestCanceledDTOJsonAdapter extends JsonAdapter<Web3RequestCanceledDTO> {
    private volatile Constructor<Web3RequestCanceledDTO> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<Uri> uriAdapter;

    public Web3RequestCanceledDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "id", "origin");
        m.f(of, "of(\"type\", \"id\", \"origin\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "type");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"type\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Uri> adapter2 = moshi.adapter(Uri.class, b3, "origin");
        m.f(adapter2, "moshi.adapter(Uri::class.java, emptySet(), \"origin\")");
        this.uriAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Web3RequestCanceledDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Web3RequestCanceledDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str = null;
        String str2 = null;
        Uri uri = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"type\", \"type\", reader)");
                    throw unexpectedNull;
                }
                i2 &= -2;
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (uri = this.uriAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("origin", "origin", reader);
                m.f(unexpectedNull3, "unexpectedNull(\"origin\", \"origin\",\n            reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (i2 == -2) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            } else if (uri != null) {
                return new Web3RequestCanceledDTO(str, str2, uri);
            } else {
                JsonDataException missingProperty2 = Util.missingProperty("origin", "origin", reader);
                m.f(missingProperty2, "missingProperty(\"origin\", \"origin\", reader)");
                throw missingProperty2;
            }
        }
        Constructor<Web3RequestCanceledDTO> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = Web3RequestCanceledDTO.class.getDeclaredConstructor(String.class, String.class, Uri.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "Web3RequestCanceledDTO::class.java.getDeclaredConstructor(String::class.java,\n          String::class.java, Uri::class.java, Int::class.javaPrimitiveType,\n          Util.DEFAULT_CONSTRUCTOR_MARKER).also { this.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        objArr[0] = str;
        if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty3, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty3;
        }
        objArr[1] = str2;
        if (uri == null) {
            JsonDataException missingProperty4 = Util.missingProperty("origin", "origin", reader);
            m.f(missingProperty4, "missingProperty(\"origin\", \"origin\", reader)");
            throw missingProperty4;
        }
        objArr[2] = uri;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = null;
        Web3RequestCanceledDTO newInstance = constructor.newInstance(objArr);
        m.f(newInstance, "localConstructor.newInstance(\n          type,\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          origin ?: throw Util.missingProperty(\"origin\", \"origin\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Web3RequestCanceledDTO web3RequestCanceledDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(web3RequestCanceledDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) web3RequestCanceledDTO.getType());
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) web3RequestCanceledDTO.getId());
        writer.name("origin");
        this.uriAdapter.toJson(writer, (JsonWriter) web3RequestCanceledDTO.getOrigin());
        writer.endObject();
    }
}