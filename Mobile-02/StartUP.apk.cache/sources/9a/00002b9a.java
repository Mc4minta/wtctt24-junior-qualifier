package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.interfaces.JsonSerializable;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ServerMessageType;
import com.squareup.moshi.JsonClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import l.a.a;

/* compiled from: ClientResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0081\b\u0018\u0000 $2\u00020\u0001:\u0001$B+\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J<\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006%"}, d2 = {"Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "Lcom/coinbase/wallet/core/interfaces/JsonSerializable;", "", "asJsonString", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/ServerMessageType;", "component1", "()Lcom/coinbase/walletlink/models/ServerMessageType;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "type", "id", WalletLinkPushNotification.eventIdKey, WalletLinkPushNotification.sessionIdKey, "copy", "(Lcom/coinbase/walletlink/models/ServerMessageType;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEventId", "Ljava/lang/Integer;", "getId", "getSessionId", "Lcom/coinbase/walletlink/models/ServerMessageType;", "getType", "<init>", "(Lcom/coinbase/walletlink/models/ServerMessageType;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ClientResponseDTO implements JsonSerializable {
    public static final Companion Companion = new Companion(null);
    private final String eventId;
    private final Integer id;
    private final String sessionId;
    private final ServerMessageType type;

    /* compiled from: ClientResponseDTO.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/walletlink/dtos/ClientResponseDTO$Companion;", "", "", "jsonString", "Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "fromJsonString", "(Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClientResponseDTO fromJsonString(String jsonString) {
            m.g(jsonString, "jsonString");
            JSON json = JSON.INSTANCE;
            ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                if (!(e0.b(ClientResponseDTO.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                    a.e(new AssertionException("Since " + ((Object) e0.b(ClientResponseDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
                }
                Object fromJson = json.getMoshi().adapter(ClientResponseDTO.class).fromJson(jsonString);
                readLock.unlock();
                return (ClientResponseDTO) fromJson;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
    }

    public ClientResponseDTO(ServerMessageType type, Integer num, String str, String sessionId) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        this.type = type;
        this.id = num;
        this.eventId = str;
        this.sessionId = sessionId;
    }

    public static /* synthetic */ ClientResponseDTO copy$default(ClientResponseDTO clientResponseDTO, ServerMessageType serverMessageType, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            serverMessageType = clientResponseDTO.type;
        }
        if ((i2 & 2) != 0) {
            num = clientResponseDTO.id;
        }
        if ((i2 & 4) != 0) {
            str = clientResponseDTO.eventId;
        }
        if ((i2 & 8) != 0) {
            str2 = clientResponseDTO.sessionId;
        }
        return clientResponseDTO.copy(serverMessageType, num, str, str2);
    }

    @Override // com.coinbase.wallet.core.interfaces.JsonSerializable
    public String asJsonString() {
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            String json2 = json.getMoshi().adapter(ClientResponseDTO.class).toJson(this);
            m.f(json2, "adapter.toJson(instance)");
            return json2;
        } finally {
            readLock.unlock();
        }
    }

    public final ServerMessageType component1() {
        return this.type;
    }

    public final Integer component2() {
        return this.id;
    }

    public final String component3() {
        return this.eventId;
    }

    public final String component4() {
        return this.sessionId;
    }

    public final ClientResponseDTO copy(ServerMessageType type, Integer num, String str, String sessionId) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        return new ClientResponseDTO(type, num, str, sessionId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClientResponseDTO) {
            ClientResponseDTO clientResponseDTO = (ClientResponseDTO) obj;
            return this.type == clientResponseDTO.type && m.c(this.id, clientResponseDTO.id) && m.c(this.eventId, clientResponseDTO.eventId) && m.c(this.sessionId, clientResponseDTO.sessionId);
        }
        return false;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ServerMessageType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Integer num = this.id;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.eventId;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.sessionId.hashCode();
    }

    public String toString() {
        return "ClientResponseDTO(type=" + this.type + ", id=" + this.id + ", eventId=" + ((Object) this.eventId) + ", sessionId=" + this.sessionId + ')';
    }
}