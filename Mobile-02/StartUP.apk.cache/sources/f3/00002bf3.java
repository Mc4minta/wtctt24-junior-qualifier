package com.coinbase.walletlink.models;

import android.net.Uri;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;

/* compiled from: SessionJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/coinbase/walletlink/models/SessionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/models/Session;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/models/Session;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/models/Session;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "nullableStringAdapter", "Landroid/net/Uri;", "nullableUriAdapter", "Ljava/net/URL;", "uRLAdapter", "nullableURLAdapter", "", "nullableBooleanAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SessionJsonAdapter extends JsonAdapter<Session> {
    private volatile Constructor<Session> constructorRef;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<URL> nullableURLAdapter;
    private final JsonAdapter<Uri> nullableUriAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<URL> uRLAdapter;

    public SessionJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        Set<? extends Annotation> b7;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "secret", "url", ClientCookie.VERSION_ATTR, "isParent", "parentSessionId", WalletLinkCompleteArgs.DAPP_NAME, "dappImageURL", "dappURL", "isApproved");
        m.f(of, "of(\"id\", \"secret\", \"url\", \"version\",\n      \"isParent\", \"parentSessionId\", \"dappName\", \"dappImageURL\", \"dappURL\", \"isApproved\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "id");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<URL> adapter2 = moshi.adapter(URL.class, b3, "url");
        m.f(adapter2, "moshi.adapter(URL::class.java, emptySet(), \"url\")");
        this.uRLAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, ClientCookie.VERSION_ATTR);
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"version\")");
        this.nullableStringAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<Boolean> adapter4 = moshi.adapter(Boolean.class, b5, "isParent");
        m.f(adapter4, "moshi.adapter(Boolean::class.javaObjectType, emptySet(), \"isParent\")");
        this.nullableBooleanAdapter = adapter4;
        b6 = s0.b();
        JsonAdapter<URL> adapter5 = moshi.adapter(URL.class, b6, "dappImageURL");
        m.f(adapter5, "moshi.adapter(URL::class.java, emptySet(),\n      \"dappImageURL\")");
        this.nullableURLAdapter = adapter5;
        b7 = s0.b();
        JsonAdapter<Uri> adapter6 = moshi.adapter(Uri.class, b7, "dappURL");
        m.f(adapter6, "moshi.adapter(Uri::class.java, emptySet(),\n      \"dappURL\")");
        this.nullableUriAdapter = adapter6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Session");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Session fromJson(JsonReader reader) {
        String str;
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String str2 = null;
        String str3 = null;
        URL url = null;
        String str4 = null;
        Boolean bool = null;
        String str5 = null;
        String str6 = null;
        URL url2 = null;
        Uri uri = null;
        Boolean bool2 = null;
        while (true) {
            Class<Boolean> cls3 = cls;
            Class<String> cls4 = cls2;
            if (reader.hasNext()) {
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
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("secret", "secret", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"secret\",\n            \"secret\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        url = this.uRLAdapter.fromJson(reader);
                        if (url == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("url", "url", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"url\", \"url\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str4 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -9;
                        break;
                    case 4:
                        bool = this.nullableBooleanAdapter.fromJson(reader);
                        break;
                    case 5:
                        str5 = this.nullableStringAdapter.fromJson(reader);
                        break;
                    case 6:
                        str6 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -65;
                        break;
                    case 7:
                        url2 = this.nullableURLAdapter.fromJson(reader);
                        i2 &= -129;
                        break;
                    case 8:
                        uri = this.nullableUriAdapter.fromJson(reader);
                        i2 &= -257;
                        break;
                    case 9:
                        bool2 = this.nullableBooleanAdapter.fromJson(reader);
                        i2 &= -513;
                        break;
                }
                cls = cls3;
                cls2 = cls4;
            } else {
                reader.endObject();
                if (i2 == -969) {
                    if (str2 == null) {
                        JsonDataException missingProperty = Util.missingProperty("id", "id", reader);
                        m.f(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                        throw missingProperty;
                    } else if (str3 == null) {
                        JsonDataException missingProperty2 = Util.missingProperty("secret", "secret", reader);
                        m.f(missingProperty2, "missingProperty(\"secret\", \"secret\", reader)");
                        throw missingProperty2;
                    } else if (url != null) {
                        return new Session(str2, str3, url, str4, bool, str5, str6, url2, uri, bool2);
                    } else {
                        JsonDataException missingProperty3 = Util.missingProperty("url", "url", reader);
                        m.f(missingProperty3, "missingProperty(\"url\", \"url\", reader)");
                        throw missingProperty3;
                    }
                }
                Constructor<Session> constructor = this.constructorRef;
                if (constructor == null) {
                    str = "missingProperty(\"url\", \"url\", reader)";
                    constructor = Session.class.getDeclaredConstructor(cls4, cls4, URL.class, cls4, cls3, cls4, cls4, URL.class, Uri.class, cls3, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = constructor;
                    m.f(constructor, "Session::class.java.getDeclaredConstructor(String::class.java, String::class.java,\n          URL::class.java, String::class.java, Boolean::class.javaObjectType, String::class.java,\n          String::class.java, URL::class.java, Uri::class.java, Boolean::class.javaObjectType,\n          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
                } else {
                    str = "missingProperty(\"url\", \"url\", reader)";
                }
                Object[] objArr = new Object[12];
                if (str2 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("id", "id", reader);
                    m.f(missingProperty4, "missingProperty(\"id\", \"id\", reader)");
                    throw missingProperty4;
                }
                objArr[0] = str2;
                if (str3 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("secret", "secret", reader);
                    m.f(missingProperty5, "missingProperty(\"secret\", \"secret\", reader)");
                    throw missingProperty5;
                }
                objArr[1] = str3;
                if (url == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("url", "url", reader);
                    m.f(missingProperty6, str);
                    throw missingProperty6;
                }
                objArr[2] = url;
                objArr[3] = str4;
                objArr[4] = bool;
                objArr[5] = str5;
                objArr[6] = str6;
                objArr[7] = url2;
                objArr[8] = uri;
                objArr[9] = bool2;
                objArr[10] = Integer.valueOf(i2);
                objArr[11] = null;
                Session newInstance = constructor.newInstance(objArr);
                m.f(newInstance, "localConstructor.newInstance(\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          secret ?: throw Util.missingProperty(\"secret\", \"secret\", reader),\n          url ?: throw Util.missingProperty(\"url\", \"url\", reader),\n          version,\n          isParent,\n          parentSessionId,\n          dappName,\n          dappImageURL,\n          dappURL,\n          isApproved,\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
                return newInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Session session) {
        m.g(writer, "writer");
        Objects.requireNonNull(session, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, (JsonWriter) session.getId());
        writer.name("secret");
        this.stringAdapter.toJson(writer, (JsonWriter) session.getSecret());
        writer.name("url");
        this.uRLAdapter.toJson(writer, (JsonWriter) session.getUrl());
        writer.name(ClientCookie.VERSION_ATTR);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) session.getVersion());
        writer.name("isParent");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) session.isParent());
        writer.name("parentSessionId");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) session.getParentSessionId());
        writer.name(WalletLinkCompleteArgs.DAPP_NAME);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) session.getDappName());
        writer.name("dappImageURL");
        this.nullableURLAdapter.toJson(writer, (JsonWriter) session.getDappImageURL());
        writer.name("dappURL");
        this.nullableUriAdapter.toJson(writer, (JsonWriter) session.getDappURL());
        writer.name("isApproved");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) session.isApproved());
        writer.endObject();
    }
}