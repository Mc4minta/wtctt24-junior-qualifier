package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.interfaces.JsonSerializable;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.ClientMessageType;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SetSessionConfigMessageDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0081\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\\\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b'\u0010\u0004R%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0010¨\u0006,"}, d2 = {"Lcom/coinbase/walletlink/dtos/SetSessionConfigMessageDTO;", "Lcom/coinbase/wallet/core/interfaces/JsonSerializable;", "", "asJsonString", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/ClientMessageType;", "component1", "()Lcom/coinbase/walletlink/models/ClientMessageType;", "", "component2", "()I", "component3", "component4", "component5", "", "component6", "()Ljava/util/Map;", "type", "id", WalletLinkPushNotification.sessionIdKey, "webhookId", "webhookUrl", SendConfirmationArgs.metadataKey, "copy", "(Lcom/coinbase/walletlink/models/ClientMessageType;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/coinbase/walletlink/dtos/SetSessionConfigMessageDTO;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletlink/models/ClientMessageType;", "getType", "Ljava/lang/String;", "getWebhookId", "I", "getId", "getSessionId", "getWebhookUrl", "Ljava/util/Map;", "getMetadata", "<init>", "(Lcom/coinbase/walletlink/models/ClientMessageType;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SetSessionConfigMessageDTO implements JsonSerializable {
    private final int id;
    private final Map<String, String> metadata;
    private final String sessionId;
    private final ClientMessageType type;
    private final String webhookId;
    private final String webhookUrl;

    public SetSessionConfigMessageDTO(ClientMessageType type, int i2, String sessionId, String str, String str2, Map<String, String> metadata) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        m.g(metadata, "metadata");
        this.type = type;
        this.id = i2;
        this.sessionId = sessionId;
        this.webhookId = str;
        this.webhookUrl = str2;
        this.metadata = metadata;
    }

    public static /* synthetic */ SetSessionConfigMessageDTO copy$default(SetSessionConfigMessageDTO setSessionConfigMessageDTO, ClientMessageType clientMessageType, int i2, String str, String str2, String str3, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            clientMessageType = setSessionConfigMessageDTO.type;
        }
        if ((i3 & 2) != 0) {
            i2 = setSessionConfigMessageDTO.id;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = setSessionConfigMessageDTO.sessionId;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = setSessionConfigMessageDTO.webhookId;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = setSessionConfigMessageDTO.webhookUrl;
        }
        String str6 = str3;
        Map<String, String> map2 = map;
        if ((i3 & 32) != 0) {
            map2 = setSessionConfigMessageDTO.metadata;
        }
        return setSessionConfigMessageDTO.copy(clientMessageType, i4, str4, str5, str6, map2);
    }

    @Override // com.coinbase.wallet.core.interfaces.JsonSerializable
    public String asJsonString() {
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            String json2 = json.getMoshi().adapter(SetSessionConfigMessageDTO.class).toJson(this);
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
        return this.webhookId;
    }

    public final String component5() {
        return this.webhookUrl;
    }

    public final Map<String, String> component6() {
        return this.metadata;
    }

    public final SetSessionConfigMessageDTO copy(ClientMessageType type, int i2, String sessionId, String str, String str2, Map<String, String> metadata) {
        m.g(type, "type");
        m.g(sessionId, "sessionId");
        m.g(metadata, "metadata");
        return new SetSessionConfigMessageDTO(type, i2, sessionId, str, str2, metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetSessionConfigMessageDTO) {
            SetSessionConfigMessageDTO setSessionConfigMessageDTO = (SetSessionConfigMessageDTO) obj;
            return this.type == setSessionConfigMessageDTO.type && this.id == setSessionConfigMessageDTO.id && m.c(this.sessionId, setSessionConfigMessageDTO.sessionId) && m.c(this.webhookId, setSessionConfigMessageDTO.webhookId) && m.c(this.webhookUrl, setSessionConfigMessageDTO.webhookUrl) && m.c(this.metadata, setSessionConfigMessageDTO.metadata);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ClientMessageType getType() {
        return this.type;
    }

    public final String getWebhookId() {
        return this.webhookId;
    }

    public final String getWebhookUrl() {
        return this.webhookUrl;
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + this.id) * 31) + this.sessionId.hashCode()) * 31;
        String str = this.webhookId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.webhookUrl;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "SetSessionConfigMessageDTO(type=" + this.type + ", id=" + this.id + ", sessionId=" + this.sessionId + ", webhookId=" + ((Object) this.webhookId) + ", webhookUrl=" + ((Object) this.webhookUrl) + ", metadata=" + this.metadata + ')';
    }

    public /* synthetic */ SetSessionConfigMessageDTO(ClientMessageType clientMessageType, int i2, String str, String str2, String str3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ClientMessageType.SetSessionConfig : clientMessageType, i2, str, str2, str3, map);
    }
}