package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.interfaces.JsonSerializable;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.EventType;
import com.coinbase.walletlink.models.ServerMessageType;
import com.squareup.moshi.JsonClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import l.a.a;

/* compiled from: ServerRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0001(B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JB\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\bR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b%\u0010\u0004¨\u0006)"}, d2 = {"Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "Lcom/coinbase/wallet/core/interfaces/JsonSerializable;", "", "asJsonString", "()Ljava/lang/String;", "component1", "Lcom/coinbase/walletlink/models/ServerMessageType;", "component2", "()Lcom/coinbase/walletlink/models/ServerMessageType;", "Lcom/coinbase/walletlink/models/EventType;", "component3", "()Lcom/coinbase/walletlink/models/EventType;", "component4", "component5", WalletLinkPushNotification.sessionIdKey, "type", "event", WalletLinkPushNotification.eventIdKey, "data", "copy", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/ServerMessageType;Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletlink/models/EventType;", "getEvent", "Ljava/lang/String;", "getData", "Lcom/coinbase/walletlink/models/ServerMessageType;", "getType", "getEventId", "getSessionId", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/ServerMessageType;Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ServerRequestDTO implements JsonSerializable {
    public static final Companion Companion = new Companion(null);
    private final String data;
    private final EventType event;
    private final String eventId;
    private final String sessionId;
    private final ServerMessageType type;

    /* compiled from: ServerRequestDTO.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/walletlink/dtos/ServerRequestDTO$Companion;", "", "", "jsonString", "Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "fromJsonString", "(Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/ServerRequestDTO;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServerRequestDTO fromJsonString(String jsonString) {
            m.g(jsonString, "jsonString");
            JSON json = JSON.INSTANCE;
            ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                if (!(e0.b(ServerRequestDTO.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                    a.e(new AssertionException("Since " + ((Object) e0.b(ServerRequestDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
                }
                Object fromJson = json.getMoshi().adapter(ServerRequestDTO.class).fromJson(jsonString);
                readLock.unlock();
                return (ServerRequestDTO) fromJson;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
    }

    public ServerRequestDTO(String sessionId, ServerMessageType type, EventType event, String eventId, String data) {
        m.g(sessionId, "sessionId");
        m.g(type, "type");
        m.g(event, "event");
        m.g(eventId, "eventId");
        m.g(data, "data");
        this.sessionId = sessionId;
        this.type = type;
        this.event = event;
        this.eventId = eventId;
        this.data = data;
    }

    public static /* synthetic */ ServerRequestDTO copy$default(ServerRequestDTO serverRequestDTO, String str, ServerMessageType serverMessageType, EventType eventType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serverRequestDTO.sessionId;
        }
        if ((i2 & 2) != 0) {
            serverMessageType = serverRequestDTO.type;
        }
        ServerMessageType serverMessageType2 = serverMessageType;
        if ((i2 & 4) != 0) {
            eventType = serverRequestDTO.event;
        }
        EventType eventType2 = eventType;
        if ((i2 & 8) != 0) {
            str2 = serverRequestDTO.eventId;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = serverRequestDTO.data;
        }
        return serverRequestDTO.copy(str, serverMessageType2, eventType2, str4, str3);
    }

    @Override // com.coinbase.wallet.core.interfaces.JsonSerializable
    public String asJsonString() {
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            String json2 = json.getMoshi().adapter(ServerRequestDTO.class).toJson(this);
            m.f(json2, "adapter.toJson(instance)");
            return json2;
        } finally {
            readLock.unlock();
        }
    }

    public final String component1() {
        return this.sessionId;
    }

    public final ServerMessageType component2() {
        return this.type;
    }

    public final EventType component3() {
        return this.event;
    }

    public final String component4() {
        return this.eventId;
    }

    public final String component5() {
        return this.data;
    }

    public final ServerRequestDTO copy(String sessionId, ServerMessageType type, EventType event, String eventId, String data) {
        m.g(sessionId, "sessionId");
        m.g(type, "type");
        m.g(event, "event");
        m.g(eventId, "eventId");
        m.g(data, "data");
        return new ServerRequestDTO(sessionId, type, event, eventId, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerRequestDTO) {
            ServerRequestDTO serverRequestDTO = (ServerRequestDTO) obj;
            return m.c(this.sessionId, serverRequestDTO.sessionId) && this.type == serverRequestDTO.type && this.event == serverRequestDTO.event && m.c(this.eventId, serverRequestDTO.eventId) && m.c(this.data, serverRequestDTO.data);
        }
        return false;
    }

    public final String getData() {
        return this.data;
    }

    public final EventType getEvent() {
        return this.event;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ServerMessageType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.sessionId.hashCode() * 31) + this.type.hashCode()) * 31) + this.event.hashCode()) * 31) + this.eventId.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "ServerRequestDTO(sessionId=" + this.sessionId + ", type=" + this.type + ", event=" + this.event + ", eventId=" + this.eventId + ", data=" + this.data + ')';
    }
}