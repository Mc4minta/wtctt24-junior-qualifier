package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.interfaces.JsonSerializable;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ClientMessageType;
import com.coinbase.walletlink.models.EventType;
import com.squareup.moshi.JsonClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: PublishEventDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004JB\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lcom/coinbase/walletlink/dtos/PublishEventDTO;", "Lcom/coinbase/wallet/core/interfaces/JsonSerializable;", "", "asJsonString", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/ClientMessageType;", "component1", "()Lcom/coinbase/walletlink/models/ClientMessageType;", "", "component2", "()I", "component3", "Lcom/coinbase/walletlink/models/EventType;", "component4", "()Lcom/coinbase/walletlink/models/EventType;", "component5", "type", "id", WalletLinkPushNotification.sessionIdKey, "event", "data", "copy", "(Lcom/coinbase/walletlink/models/ClientMessageType;ILjava/lang/String;Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/PublishEventDTO;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletlink/models/ClientMessageType;", "getType", "Ljava/lang/String;", "getSessionId", "I", "getId", "getData", "Lcom/coinbase/walletlink/models/EventType;", "getEvent", "<init>", "(Lcom/coinbase/walletlink/models/ClientMessageType;ILjava/lang/String;Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PublishEventDTO implements JsonSerializable {
    private final String data;
    private final EventType event;
    private final int id;
    private final String sessionId;
    private final ClientMessageType type;

    public PublishEventDTO(ClientMessageType type, int i2, String sessionId, EventType event, String data) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        m.g(event, "event");
        m.g(data, "data");
        this.type = type;
        this.id = i2;
        this.sessionId = sessionId;
        this.event = event;
        this.data = data;
    }

    public static /* synthetic */ PublishEventDTO copy$default(PublishEventDTO publishEventDTO, ClientMessageType clientMessageType, int i2, String str, EventType eventType, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            clientMessageType = publishEventDTO.type;
        }
        if ((i3 & 2) != 0) {
            i2 = publishEventDTO.id;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = publishEventDTO.sessionId;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            eventType = publishEventDTO.event;
        }
        EventType eventType2 = eventType;
        if ((i3 & 16) != 0) {
            str2 = publishEventDTO.data;
        }
        return publishEventDTO.copy(clientMessageType, i4, str3, eventType2, str2);
    }

    @Override // com.coinbase.wallet.core.interfaces.JsonSerializable
    public String asJsonString() {
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            String json2 = json.getMoshi().adapter(PublishEventDTO.class).toJson(this);
            m.f(json2, "adapter.toJson(instance)");
            return json2;
        } finally {
            readLock.unlock();
        }
    }

    public final ClientMessageType component1() {
        return this.type;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.sessionId;
    }

    public final EventType component4() {
        return this.event;
    }

    public final String component5() {
        return this.data;
    }

    public final PublishEventDTO copy(ClientMessageType type, int i2, String sessionId, EventType event, String data) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        m.g(event, "event");
        m.g(data, "data");
        return new PublishEventDTO(type, i2, sessionId, event, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PublishEventDTO) {
            PublishEventDTO publishEventDTO = (PublishEventDTO) obj;
            return this.type == publishEventDTO.type && this.id == publishEventDTO.id && m.c(this.sessionId, publishEventDTO.sessionId) && this.event == publishEventDTO.event && m.c(this.data, publishEventDTO.data);
        }
        return false;
    }

    public final String getData() {
        return this.data;
    }

    public final EventType getEvent() {
        return this.event;
    }

    public final int getId() {
        return this.id;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ClientMessageType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + this.id) * 31) + this.sessionId.hashCode()) * 31) + this.event.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "PublishEventDTO(type=" + this.type + ", id=" + this.id + ", sessionId=" + this.sessionId + ", event=" + this.event + ", data=" + this.data + ')';
    }

    public /* synthetic */ PublishEventDTO(ClientMessageType clientMessageType, int i2, String str, EventType eventType, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ClientMessageType.PublishEvent : clientMessageType, i2, str, eventType, str2);
    }
}