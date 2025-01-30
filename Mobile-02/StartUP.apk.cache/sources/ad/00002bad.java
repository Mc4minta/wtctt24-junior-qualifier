package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ClientMessageType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;

/* compiled from: SetSessionConfigMessageDTOJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R(\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011¨\u0006#"}, d2 = {"Lcom/coinbase/walletlink/dtos/SetSessionConfigMessageDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletlink/dtos/SetSessionConfigMessageDTO;", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Lcom/coinbase/walletlink/dtos/SetSessionConfigMessageDTO;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value_", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Lcom/coinbase/walletlink/dtos/SetSessionConfigMessageDTO;)V", "stringAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableStringAdapter", "Ljava/lang/reflect/Constructor;", "constructorRef", "Ljava/lang/reflect/Constructor;", "", "intAdapter", "", "mapOfStringStringAdapter", "Lcom/coinbase/walletlink/models/ClientMessageType;", "clientMessageTypeAdapter", "Lcom/squareup/moshi/Moshi;", "moshi", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SetSessionConfigMessageDTOJsonAdapter extends JsonAdapter<SetSessionConfigMessageDTO> {
    private final JsonAdapter<ClientMessageType> clientMessageTypeAdapter;
    private volatile Constructor<SetSessionConfigMessageDTO> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Map<String, String>> mapOfStringStringAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SetSessionConfigMessageDTOJsonAdapter(Moshi moshi) {
        Set<? extends Annotation> b2;
        Set<? extends Annotation> b3;
        Set<? extends Annotation> b4;
        Set<? extends Annotation> b5;
        Set<? extends Annotation> b6;
        m.g(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "id", WalletLinkPushNotification.sessionIdKey, "webhookId", "webhookUrl", SendConfirmationArgs.metadataKey);
        m.f(of, "of(\"type\", \"id\", \"sessionId\",\n      \"webhookId\", \"webhookUrl\", \"metadata\")");
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
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, b5, "webhookId");
        m.f(adapter4, "moshi.adapter(String::class.java,\n      emptySet(), \"webhookId\")");
        this.nullableStringAdapter = adapter4;
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, String.class, String.class);
        b6 = s0.b();
        JsonAdapter<Map<String, String>> adapter5 = moshi.adapter(newParameterizedType, b6, SendConfirmationArgs.metadataKey);
        m.f(adapter5, "moshi.adapter(Types.newParameterizedType(Map::class.java, String::class.java,\n      String::class.java), emptySet(), \"metadata\")");
        this.mapOfStringStringAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(48);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SetSessionConfigMessageDTO");
        sb.append(')');
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SetSessionConfigMessageDTO fromJson(JsonReader reader) {
        String str;
        m.g(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        Integer num = null;
        ClientMessageType clientMessageType = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Map<String, String> map = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    clientMessageType = this.clientMessageTypeAdapter.fromJson(reader);
                    if (clientMessageType == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                        m.f(unexpectedNull, "unexpectedNull(\"type\",\n              \"type\", reader)");
                        throw unexpectedNull;
                    }
                    i2 &= -2;
                    break;
                case 1:
                    num = this.intAdapter.fromJson(reader);
                    if (num == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", reader);
                        m.f(unexpectedNull2, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                        m.f(unexpectedNull3, "unexpectedNull(\"sessionId\",\n            \"sessionId\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(reader);
                    break;
                case 4:
                    str4 = this.nullableStringAdapter.fromJson(reader);
                    break;
                case 5:
                    map = this.mapOfStringStringAdapter.fromJson(reader);
                    if (map == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(SendConfirmationArgs.metadataKey, SendConfirmationArgs.metadataKey, reader);
                        m.f(unexpectedNull4, "unexpectedNull(\"metadata\", \"metadata\", reader)");
                        throw unexpectedNull4;
                    }
                    break;
            }
        }
        reader.endObject();
        if (i2 == -2) {
            Objects.requireNonNull(clientMessageType, "null cannot be cast to non-null type com.coinbase.walletlink.models.ClientMessageType");
            if (num != null) {
                int intValue = num.intValue();
                if (str2 == null) {
                    JsonDataException missingProperty = Util.missingProperty(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                    m.f(missingProperty, "missingProperty(\"sessionId\", \"sessionId\", reader)");
                    throw missingProperty;
                } else if (map != null) {
                    return new SetSessionConfigMessageDTO(clientMessageType, intValue, str2, str3, str4, map);
                } else {
                    JsonDataException missingProperty2 = Util.missingProperty(SendConfirmationArgs.metadataKey, SendConfirmationArgs.metadataKey, reader);
                    m.f(missingProperty2, "missingProperty(\"metadata\", \"metadata\", reader)");
                    throw missingProperty2;
                }
            }
            JsonDataException missingProperty3 = Util.missingProperty("id", "id", reader);
            m.f(missingProperty3, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty3;
        }
        Constructor<SetSessionConfigMessageDTO> constructor = this.constructorRef;
        if (constructor == null) {
            str = "id";
            Class cls = Integer.TYPE;
            constructor = SetSessionConfigMessageDTO.class.getDeclaredConstructor(ClientMessageType.class, cls, String.class, String.class, String.class, Map.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            m.f(constructor, "SetSessionConfigMessageDTO::class.java.getDeclaredConstructor(ClientMessageType::class.java,\n          Int::class.javaPrimitiveType, String::class.java, String::class.java, String::class.java,\n          Map::class.java, Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {\n          this.constructorRef = it }");
        } else {
            str = "id";
        }
        Object[] objArr = new Object[8];
        objArr[0] = clientMessageType;
        if (num != null) {
            objArr[1] = Integer.valueOf(num.intValue());
            if (str2 == null) {
                JsonDataException missingProperty4 = Util.missingProperty(WalletLinkPushNotification.sessionIdKey, WalletLinkPushNotification.sessionIdKey, reader);
                m.f(missingProperty4, "missingProperty(\"sessionId\", \"sessionId\", reader)");
                throw missingProperty4;
            }
            objArr[2] = str2;
            objArr[3] = str3;
            objArr[4] = str4;
            if (map == null) {
                JsonDataException missingProperty5 = Util.missingProperty(SendConfirmationArgs.metadataKey, SendConfirmationArgs.metadataKey, reader);
                m.f(missingProperty5, "missingProperty(\"metadata\", \"metadata\", reader)");
                throw missingProperty5;
            }
            objArr[5] = map;
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = null;
            SetSessionConfigMessageDTO newInstance = constructor.newInstance(objArr);
            m.f(newInstance, "localConstructor.newInstance(\n          type,\n          id ?: throw Util.missingProperty(\"id\", \"id\", reader),\n          sessionId ?: throw Util.missingProperty(\"sessionId\", \"sessionId\", reader),\n          webhookId,\n          webhookUrl,\n          metadata ?: throw Util.missingProperty(\"metadata\", \"metadata\", reader),\n          mask0,\n          /* DefaultConstructorMarker */ null\n      )");
            return newInstance;
        }
        String str5 = str;
        JsonDataException missingProperty6 = Util.missingProperty(str5, str5, reader);
        m.f(missingProperty6, "missingProperty(\"id\", \"id\", reader)");
        throw missingProperty6;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SetSessionConfigMessageDTO setSessionConfigMessageDTO) {
        m.g(writer, "writer");
        Objects.requireNonNull(setSessionConfigMessageDTO, "value_ was null! Wrap in .nullSafe() to write nullable values.");
        writer.beginObject();
        writer.name("type");
        this.clientMessageTypeAdapter.toJson(writer, (JsonWriter) setSessionConfigMessageDTO.getType());
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(setSessionConfigMessageDTO.getId()));
        writer.name(WalletLinkPushNotification.sessionIdKey);
        this.stringAdapter.toJson(writer, (JsonWriter) setSessionConfigMessageDTO.getSessionId());
        writer.name("webhookId");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) setSessionConfigMessageDTO.getWebhookId());
        writer.name("webhookUrl");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) setSessionConfigMessageDTO.getWebhookUrl());
        writer.name(SendConfirmationArgs.metadataKey);
        this.mapOfStringStringAdapter.toJson(writer, (JsonWriter) setSessionConfigMessageDTO.getMetadata());
        writer.endObject();
    }
}