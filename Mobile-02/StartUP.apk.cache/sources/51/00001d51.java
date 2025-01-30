package com.coinbase.wallet.features.cloudbackup.models;

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

/* compiled from: BackupPayloadJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;)V", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupPayloadJsonAdapter extends JsonAdapter<BackupPayload> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public BackupPayloadJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("salt", "iv", "cipherText", "authTag", "hash", "timestamp", "username");
        m.f(of, "of(\"salt\", \"iv\", \"cipherText\",\n      \"authTag\", \"hash\", \"timestamp\", \"username\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, "salt");
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"salt\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("BackupPayload");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public BackupPayload fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (true) {
            String str8 = str7;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(reader);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("salt", "salt", reader);
                            m.f(unexpectedNull, "unexpectedNull(\"salt\", \"salt\",\n            reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(reader);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("iv", "iv", reader);
                            m.f(unexpectedNull2, "unexpectedNull(\"iv\", \"iv\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(reader);
                        if (str3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("cipherText", "cipherText", reader);
                            m.f(unexpectedNull3, "unexpectedNull(\"cipherText\",\n            \"cipherText\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(reader);
                        if (str4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("authTag", "authTag", reader);
                            m.f(unexpectedNull4, "unexpectedNull(\"authTag\",\n            \"authTag\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        str5 = this.stringAdapter.fromJson(reader);
                        if (str5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("hash", "hash", reader);
                            m.f(unexpectedNull5, "unexpectedNull(\"hash\", \"hash\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        str6 = this.stringAdapter.fromJson(reader);
                        if (str6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("timestamp", "timestamp", reader);
                            m.f(unexpectedNull6, "unexpectedNull(\"timestamp\",\n            \"timestamp\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        str7 = this.stringAdapter.fromJson(reader);
                        if (str7 == null) {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("username", "username", reader);
                            m.f(unexpectedNull7, "unexpectedNull(\"username\",\n            \"username\", reader)");
                            throw unexpectedNull7;
                        }
                        continue;
                }
                str7 = str8;
            } else {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("salt", "salt", reader);
                    m.f(missingProperty, "missingProperty(\"salt\", \"salt\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("iv", "iv", reader);
                    m.f(missingProperty2, "missingProperty(\"iv\", \"iv\", reader)");
                    throw missingProperty2;
                } else if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("cipherText", "cipherText", reader);
                    m.f(missingProperty3, "missingProperty(\"cipherText\", \"cipherText\", reader)");
                    throw missingProperty3;
                } else if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("authTag", "authTag", reader);
                    m.f(missingProperty4, "missingProperty(\"authTag\", \"authTag\", reader)");
                    throw missingProperty4;
                } else if (str5 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("hash", "hash", reader);
                    m.f(missingProperty5, "missingProperty(\"hash\", \"hash\", reader)");
                    throw missingProperty5;
                } else if (str6 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("timestamp", "timestamp", reader);
                    m.f(missingProperty6, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                    throw missingProperty6;
                } else if (str8 != null) {
                    return new BackupPayload(str, str2, str3, str4, str5, str6, str8);
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("username", "username", reader);
                    m.f(missingProperty7, "missingProperty(\"username\", \"username\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, BackupPayload backupPayload) {
        m.g(writer, "writer");
        Objects.requireNonNull(backupPayload, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("salt");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getSalt());
        writer.name("iv");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getIv());
        writer.name("cipherText");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getCipherText());
        writer.name("authTag");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getAuthTag());
        writer.name("hash");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getHash());
        writer.name("timestamp");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getTimestamp());
        writer.name("username");
        this.stringAdapter.toJson(writer, (JsonWriter) backupPayload.getUsername());
        writer.endObject();
    }
}