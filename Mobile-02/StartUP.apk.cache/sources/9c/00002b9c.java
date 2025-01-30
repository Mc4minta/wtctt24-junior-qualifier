package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ServerMessageType;
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

/* compiled from: ClientResponseDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/walletlink/dtos/ClientResponseDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/ClientResponseDTO;)V", "Lcom/coinbase/walletlink/models/ServerMessageType;", "serverMessageTypeAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "nullableIntAdapter", "nullableStringAdapter", "stringAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ClientResponseDTOJsonAdapter extends JsonAdapter<ClientResponseDTO> {
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<ServerMessageType> serverMessageTypeAdapter;
    private final JsonAdapter<String> stringAdapter;

    public ClientResponseDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "id", WalletLinkPushNotification.eventIdKey, WalletLinkPushNotification.sessionIdKey);
        m.f(of, "of(\"type\", \"id\", \"eventId\",\n      \"sessionId\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<ServerMessageType> adapter = moshi.adapter(ServerMessageType.class, b2, "type");
        m.f(adapter, "moshi.adapter(ServerMessageType::class.java, emptySet(), \"type\")");
        this.serverMessageTypeAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, b3, "id");
        m.f(adapter2, "moshi.adapter(Int::class.javaObjectType,\n      emptySet(), \"id\")");
        this.nullableIntAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, WalletLinkPushNotification.eventIdKey);
        m.f(adapter3, "moshi.adapter(String::class.java,\n      emptySet(), \"eventId\")");
        this.nullableStringAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, b5, WalletLinkPushNotification.sessionIdKey);
        m.f(adapter4, "moshi.adapter(String::class.java, emptySet(),\n      \"sessionId\")");
        this.stringAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ClientResponseDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ClientResponseDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        ServerMessageType serverMessageType = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                serverMessageType = this.serverMessageTypeAdapter.fromJson(reader);
                if (serverMessageType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"type\",\n            \"type\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                num = this.nullableIntAdapter.fromJson(reader);
            } else if (selectName == 2) {
                str = this.nullableStringAdapter.fromJson(reader);
            } else if (selectName == 3 && (str2 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                m.f(unexpectedNull2, "unexpectedNull(\"sessionId\",\n            \"sessionId\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (serverMessageType == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", reader);
            m.f(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (str2 != null) {
            return new ClientResponseDTO(serverMessageType, num, str, str2);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
            m.f(missingProperty2, "missingProperty(\"sessionId\", \"sessionId\", reader)");
            throw missingProperty2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ClientResponseDTO clientResponseDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(clientResponseDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.serverMessageTypeAdapter.toJson(writer, (JsonWriter) clientResponseDTO.getType());
        writer.name("id");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) clientResponseDTO.getId());
        writer.name(WalletLinkPushNotification.eventIdKey);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) clientResponseDTO.getEventId());
        writer.name(WalletLinkPushNotification.sessionIdKey);
        this.stringAdapter.toJson(writer, (JsonWriter) clientResponseDTO.getSessionId());
        writer.endObject();
    }
}