package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ClientMessageType;
import com.coinbase.walletlink.models.EventType;
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

/* compiled from: PublishEventDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012¨\u0006\""}, d2 = {"Lcom/coinbase/walletlink/dtos/PublishEventDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/PublishEventDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/PublishEventDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/PublishEventDTO;)V", "", "intAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "Lcom/coinbase/walletlink/models/ClientMessageType;", "clientMessageTypeAdapter", "stringAdapter", "Lcom/coinbase/walletlink/models/EventType;", "eventTypeAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PublishEventDTOJsonAdapter extends JsonAdapter<PublishEventDTO> {
    private final JsonAdapter<ClientMessageType> clientMessageTypeAdapter;
    private volatile Constructor<PublishEventDTO> constructorRef;
    private final JsonAdapter<EventType> eventTypeAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public PublishEventDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "id", WalletLinkPushNotification.sessionIdKey, "event", "data");
        m.f(of, "of(\"type\", \"id\", \"sessionId\",\n      \"event\", \"data\")");
        this.options = of;
        b2 = s0.b();
        JsonAdapter<ClientMessageType> adapter = moshi.adapter(ClientMessageType.class, b2, "type");
        m.f(adapter, "moshi.adapter(ClientMessageType::class.java, emptySet(), \"type\")");
        this.clientMessageTypeAdapter = adapter;
        Class cls = Integer.TYPE;
        b3 = s0.b();
        JsonAdapter<Integer> adapter2 = moshi.adapter(cls, b3, "id");
        m.f(adapter2, "moshi.adapter(Int::class.java, emptySet(), \"id\")");
        this.intAdapter = adapter2;
        b4 = s0.b();
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, b4, WalletLinkPushNotification.sessionIdKey);
        m.f(adapter3, "moshi.adapter(String::class.java, emptySet(),\n      \"sessionId\")");
        this.stringAdapter = adapter3;
        b5 = s0.b();
        JsonAdapter<EventType> adapter4 = moshi.adapter(EventType.class, b5, "event");
        m.f(adapter4, "moshi.adapter(EventType::class.java,\n      emptySet(), \"event\")");
        this.eventTypeAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(");
        sb.append("PublishEventDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public PublishEventDTO fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        int i3 = -1;
        Integer num = null;
        ClientMessageType clientMessageType = null;
        String str2 = null;
        EventType eventType = null;
        String str3 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == i2) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                clientMessageType = this.clientMessageTypeAdapter.fromJson(reader);
                if (clientMessageType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                    m.f(unexpectedNull, "unexpectedNull(\"type\",\n              \"type\", reader)");
                    throw unexpectedNull;
                }
                i3 &= -2;
            } else if (selectName == 1) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", reader);
                    m.f(unexpectedNull2, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                    m.f(unexpectedNull3, "unexpectedNull(\"sessionId\",\n            \"sessionId\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                eventType = this.eventTypeAdapter.fromJson(reader);
                if (eventType == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("event", "event", reader);
                    m.f(unexpectedNull4, "unexpectedNull(\"event\",\n            \"event\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (str3 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("data_", "data", reader);
                m.f(unexpectedNull5, "unexpectedNull(\"data_\", \"data\",\n            reader)");
                throw unexpectedNull5;
            }
            i2 = -1;
        }
        reader.endObject();
        if (i3 == -2) {
            Objects.requireNonNull(clientMessageType, "null cannot be cast to non-null type com.coinbase.walletlink.models.ClientMessageType");
            if (num != null) {
                int intValue = num.intValue();
                if (str2 == null) {
                    JsonDataException missingProperty = Util.missingProperty(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                    m.f(missingProperty, "missingProperty(\"sessionId\", \"sessionId\", reader)");
                    throw missingProperty;
                } else if (eventType == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("event", "event", reader);
                    m.f(missingProperty2, "missingProperty(\"event\", \"event\", reader)");
                    throw missingProperty2;
                } else if (str3 != null) {
                    return new PublishEventDTO(clientMessageType, intValue, str2, eventType, str3);
                } else {
                    JsonDataException missingProperty3 = Util.missingProperty("data_", "data", reader);
                    m.f(missingProperty3, "missingProperty(\"data_\", \"data\", reader)");
                    throw missingProperty3;
                }
            }
            JsonDataException missingProperty4 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty4, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty4;
        }
        Constructor<PublishEventDTO> constructor = this.constructorRef;
        if (constructor == null) {
            str = WalletLinkPushNotification.sessionIdKey;
            Class cls = Integer.TYPE;
            constructor = PublishEventDTO.class.getDeclaredConstructor(ClientMessageType.class, cls, String.class, EventType.class, String.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "PublishEventDTO::class.java.getDeclaredConstructor(ClientMessageType::class.java,\n          Int::class.javaPrimitiveType, String::class.java, EventType::class.java,\n          String::class.java, Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        } else {
            str = WalletLinkPushNotification.sessionIdKey;
        }
        Object[] objArr = new Object[7];
        objArr[0] = clientMessageType;
        if (num != null) {
            objArr[1] = Integer.valueOf(num.intValue());
            if (str2 == null) {
                String str4 = str;
                JsonDataException missingProperty5 = Util.missingProperty(str4, str4, reader);
                m.f(missingProperty5, "missingProperty(\"sessionId\", \"sessionId\", reader)");
                throw missingProperty5;
            }
            objArr[2] = str2;
            if (eventType == null) {
                JsonDataException missingProperty6 = Util.missingProperty("event", "event", reader);
                m.f(missingProperty6, "missingProperty(\"event\", \"event\", reader)");
                throw missingProperty6;
            }
            objArr[3] = eventType;
            if (str3 == null) {
                JsonDataException missingProperty7 = Util.missingProperty("data_", "data", reader);
                m.f(missingProperty7, "missingProperty(\"data_\", \"data\", reader)");
                throw missingProperty7;
            }
            objArr[4] = str3;
            objArr[5] = Integer.valueOf(i3);
            objArr[6] = null;
            PublishEventDTO newInstance = constructor.newInstance(objArr);
            m.f(newInstance, "localConstructor.newInstance(\n          type,\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          sessionId ?: throw Util.missingProperty(\"sessionId\", \"sessionId\", reader),\n          event ?: throw Util.missingProperty(\"event\", \"event\", reader),\n          data_ ?: throw Util.missingProperty(\"data_\", \"data\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
            return newInstance;
        }
        JsonDataException missingProperty8 = Util.missingProperty("id", "id", reader);
        m.f(missingProperty8, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty8;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, PublishEventDTO publishEventDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(publishEventDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.clientMessageTypeAdapter.toJson(writer, (JsonWriter) publishEventDTO.getType());
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(publishEventDTO.getId()));
        writer.name(WalletLinkPushNotification.sessionIdKey);
        this.stringAdapter.toJson(writer, (JsonWriter) publishEventDTO.getSessionId());
        writer.name("event");
        this.eventTypeAdapter.toJson(writer, (JsonWriter) publishEventDTO.getEvent());
        writer.name("data");
        this.stringAdapter.toJson(writer, (JsonWriter) publishEventDTO.getData());
        writer.endObject();
    }
}