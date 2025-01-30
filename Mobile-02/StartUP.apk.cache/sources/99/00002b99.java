package com.coinbase.walletlink.dtos;

import android.net.Uri;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
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

/* compiled from: ChildRequestEthereumAccountsParamsJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/coinbase/walletlink/dtos/ChildRequestEthereumAccountsParamsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/ChildRequestEthereumAccountsParams;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/ChildRequestEthereumAccountsParams;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/ChildRequestEthereumAccountsParams;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Landroid/net/Uri;", "uriAdapter", "nullableStringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ChildRequestEthereumAccountsParamsJsonAdapter extends JsonAdapter<ChildRequestEthereumAccountsParams> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<Uri> uriAdapter;

    public ChildRequestEthereumAccountsParamsJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(WalletLinkPushNotification.sessionIdKey, "sessionSecret", "appURL", "appName", "appLogoURL");
        m.f(of, "of(\"sessionId\", \"sessionSecret\",\n      \"appURL\", \"appName\", \"appLogoURL\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, WalletLinkPushNotification.sessionIdKey);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"sessionId\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Uri> adapter2 = moshi.adapter(Uri.class, b3, "appURL");
        m.f(adapter2, "moshi.adapter(Uri::class.java, emptySet(), \"appURL\")");
        this.uriAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, "appLogoURL");
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"appLogoURL\")");
        this.nullableStringAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(56);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ChildRequestEthereumAccountsParams");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ChildRequestEthereumAccountsParams fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                    m.f(unexpectedNull, "unexpectedNull(\"sessionId\",\n            \"sessionId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("sessionSecret", "sessionSecret", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"sessionSecret\", \"sessionSecret\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                uri = this.uriAdapter.fromJson(reader);
                if (uri == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("appURL", "appURL", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"appURL\", \"appURL\",\n            reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("appName", "appName", reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"appName\",\n            \"appName\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4) {
                str4 = this.nullableStringAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
            m.f(missingProperty, "missingProperty(\"sessionId\", \"sessionId\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("sessionSecret", "sessionSecret", reader);
            m.f(missingProperty2, "missingProperty(\"sessionSecret\",\n            \"sessionSecret\", reader)");
            throw missingProperty2;
        } else if (uri == null) {
            JsonDataException missingProperty3 = Util.missingProperty("appURL", "appURL", reader);
            m.f(missingProperty3, "missingProperty(\"appURL\", \"appURL\", reader)");
            throw missingProperty3;
        } else if (str3 != null) {
            return new ChildRequestEthereumAccountsParams(str, str2, uri, str3, str4);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("appName", "appName", reader);
            m.f(missingProperty4, "missingProperty(\"appName\", \"appName\", reader)");
            throw missingProperty4;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ChildRequestEthereumAccountsParams childRequestEthereumAccountsParams) {
        m.g(writer, "writer");
        Objects.requireNonNull(childRequestEthereumAccountsParams, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(WalletLinkPushNotification.sessionIdKey);
        this.stringAdapter.toJson(writer, (JsonWriter) childRequestEthereumAccountsParams.getSessionId());
        writer.name("sessionSecret");
        this.stringAdapter.toJson(writer, (JsonWriter) childRequestEthereumAccountsParams.getSessionSecret());
        writer.name("appURL");
        this.uriAdapter.toJson(writer, (JsonWriter) childRequestEthereumAccountsParams.getAppURL());
        writer.name("appName");
        this.stringAdapter.toJson(writer, (JsonWriter) childRequestEthereumAccountsParams.getAppName());
        writer.name("appLogoURL");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) childRequestEthereumAccountsParams.getAppLogoURL());
        writer.endObject();
    }
}