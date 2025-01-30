package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.interfaces.JsonSerializable;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ClientMessageType;
import com.squareup.moshi.JsonClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: JoinSessionMessageDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/walletlink/dtos/JoinSessionMessageDTO;", "Lcom/coinbase/wallet/core/interfaces/JsonSerializable;", "", "asJsonString", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/ClientMessageType;", "component1", "()Lcom/coinbase/walletlink/models/ClientMessageType;", "", "component2", "()I", "component3", "component4", "type", "id", WalletLinkPushNotification.sessionIdKey, "sessionKey", "copy", "(Lcom/coinbase/walletlink/models/ClientMessageType;ILjava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/JoinSessionMessageDTO;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getSessionId", "Lcom/coinbase/walletlink/models/ClientMessageType;", "getType", "getSessionKey", "<init>", "(Lcom/coinbase/walletlink/models/ClientMessageType;ILjava/lang/String;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JoinSessionMessageDTO implements JsonSerializable {
    private final int id;
    private final String sessionId;
    private final String sessionKey;
    private final ClientMessageType type;

    public JoinSessionMessageDTO(ClientMessageType type, int i2, String sessionId, String sessionKey) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        m.g(sessionKey, "sessionKey");
        this.type = type;
        this.id = i2;
        this.sessionId = sessionId;
        this.sessionKey = sessionKey;
    }

    public static /* synthetic */ JoinSessionMessageDTO copy$default(JoinSessionMessageDTO joinSessionMessageDTO, ClientMessageType clientMessageType, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            clientMessageType = joinSessionMessageDTO.type;
        }
        if ((i3 & 2) != 0) {
            i2 = joinSessionMessageDTO.id;
        }
        if ((i3 & 4) != 0) {
            str = joinSessionMessageDTO.sessionId;
        }
        if ((i3 & 8) != 0) {
            str2 = joinSessionMessageDTO.sessionKey;
        }
        return joinSessionMessageDTO.copy(clientMessageType, i2, str, str2);
    }

    @Override // com.coinbase.wallet.core.interfaces.JsonSerializable
    public String asJsonString() {
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            String json2 = json.getMoshi().adapter(JoinSessionMessageDTO.class).toJson(this);
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

    public final String component4() {
        return this.sessionKey;
    }

    public final JoinSessionMessageDTO copy(ClientMessageType type, int i2, String sessionId, String sessionKey) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        m.g(sessionKey, "sessionKey");
        return new JoinSessionMessageDTO(type, i2, sessionId, sessionKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JoinSessionMessageDTO) {
            JoinSessionMessageDTO joinSessionMessageDTO = (JoinSessionMessageDTO) obj;
            return this.type == joinSessionMessageDTO.type && this.id == joinSessionMessageDTO.id && m.c(this.sessionId, joinSessionMessageDTO.sessionId) && m.c(this.sessionKey, joinSessionMessageDTO.sessionKey);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final ClientMessageType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.id) * 31) + this.sessionId.hashCode()) * 31) + this.sessionKey.hashCode();
    }

    public String toString() {
        return "JoinSessionMessageDTO(type=" + this.type + ", id=" + this.id + ", sessionId=" + this.sessionId + ", sessionKey=" + this.sessionKey + ')';
    }

    public /* synthetic */ JoinSessionMessageDTO(ClientMessageType clientMessageType, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ClientMessageType.JoinSession : clientMessageType, i2, str, str2);
    }
}