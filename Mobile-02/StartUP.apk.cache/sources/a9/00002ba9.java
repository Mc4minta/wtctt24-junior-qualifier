package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.EventType;
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

/* compiled from: ServerRequestDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/coinbase/walletlink/dtos/ServerRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/ServerRequestDTO;)V", "Lcom/coinbase/walletlink/models/ServerMessageType;", "serverMessageTypeAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/models/EventType;", "eventTypeAdapter", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ServerRequestDTOJsonAdapter extends JsonAdapter<ServerRequestDTO> {
    private final JsonAdapter<EventType> eventTypeAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<ServerMessageType> serverMessageTypeAdapter;
    private final JsonAdapter<String> stringAdapter;

    public ServerRequestDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(WalletLinkPushNotification.sessionIdKey, "type", "event", WalletLinkPushNotification.eventIdKey, "data");
        m.f(of, "of(\"sessionId\", \"type\", \"event\",\n      \"eventId\", \"data\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<String> adapter = moshi.adapter(String.class, b2, WalletLinkPushNotification.sessionIdKey);
        m.f(adapter, "moshi.adapter(String::class.java, emptySet(),\n      \"sessionId\")");
        this.stringAdapter = adapter;
        b3 = s0.b();
        JsonAdapter<ServerMessageType> adapter2 = moshi.adapter(ServerMessageType.class, b3, "type");
        m.f(adapter2, "moshi.adapter(ServerMessageType::class.java, emptySet(), \"type\")");
        this.serverMessageTypeAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<EventType> adapter3 = moshi.adapter(EventType.class, b4, "event");
        m.f(adapter3, "moshi.adapter(EventType::class.java,\n      emptySet(), \"event\")");
        this.eventTypeAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("ServerRequestDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ServerRequestDTO fromJson(JsonReader reader) {
        m.g(reader, "reader");
        reader.beginObject();
        String str = null;
        ServerMessageType serverMessageType = null;
        EventType eventType = null;
        String str2 = null;
        String str3 = null;
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
                serverMessageType = this.serverMessageTypeAdapter.fromJson(reader);
                if (serverMessageType == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("type", "type", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"type\",\n            \"type\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                eventType = this.eventTypeAdapter.fromJson(reader);
                if (eventType == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("event", "event", reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"event\",\n            \"event\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull(WalletLinkPushNotification.eventIdKey, WalletLinkPushNotification.eventIdKey, reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"eventId\",\n            \"eventId\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (str3 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("data_", "data", reader);
                m.f(unexpectedNull5, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
            m.f(missingProperty, "missingProperty(\"sessionId\", \"sessionId\", reader)");
            throw missingProperty;
        } else if (serverMessageType == null) {
            JsonDataException missingProperty2 = Util.missingProperty("type", "type", reader);
            m.f(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty2;
        } else if (eventType == null) {
            JsonDataException missingProperty3 = Util.missingProperty("event", "event", reader);
            m.f(missingProperty3, "missingProperty(\"event\", \"event\", reader)");
            throw missingProperty3;
        } else if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty(WalletLinkPushNotification.eventIdKey, WalletLinkPushNotification.eventIdKey, reader);
            m.f(missingProperty4, "missingProperty(\"eventId\", \"eventId\", reader)");
            throw missingProperty4;
        } else if (str3 != null) {
            return new ServerRequestDTO(str, serverMessageType, eventType, str2, str3);
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("data_", "data", reader);
            m.f(missingProperty5, "missingProperty(\"data_\", \"data\", reader)");
            throw missingProperty5;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ServerRequestDTO serverRequestDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(serverRequestDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name(WalletLinkPushNotification.sessionIdKey);
        this.stringAdapter.toJson(writer, (JsonWriter) serverRequestDTO.getSessionId());
        writer.name("type");
        this.serverMessageTypeAdapter.toJson(writer, (JsonWriter) serverRequestDTO.getType());
        writer.name("event");
        this.eventTypeAdapter.toJson(writer, (JsonWriter) serverRequestDTO.getEvent());
        writer.name(WalletLinkPushNotification.eventIdKey);
        this.stringAdapter.toJson(writer, (JsonWriter) serverRequestDTO.getEventId());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) serverRequestDTO.getData());
        writer.endObject();
    }
}