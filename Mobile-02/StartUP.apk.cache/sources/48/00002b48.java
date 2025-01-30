package com.coinbase.walletlink.apis;

import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/coinbase/walletlink/apis/JoinSessionEvent;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", WalletLinkPushNotification.sessionIdKey, "joined", "copy", "(Ljava/lang/String;Z)Lcom/coinbase/walletlink/apis/JoinSessionEvent;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Z", "getJoined", "<init>", "(Ljava/lang/String;Z)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JoinSessionEvent {
    private final boolean joined;
    private final String sessionId;

    public JoinSessionEvent(String sessionId, boolean z) {
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.joined = z;
    }

    public static /* synthetic */ JoinSessionEvent copy$default(JoinSessionEvent joinSessionEvent, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = joinSessionEvent.sessionId;
        }
        if ((i2 & 2) != 0) {
            z = joinSessionEvent.joined;
        }
        return joinSessionEvent.copy(str, z);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final boolean component2() {
        return this.joined;
    }

    public final JoinSessionEvent copy(String sessionId, boolean z) {
        kotlin.jvm.internal.m.g(sessionId, "sessionId");
        return new JoinSessionEvent(sessionId, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JoinSessionEvent) {
            JoinSessionEvent joinSessionEvent = (JoinSessionEvent) obj;
            return kotlin.jvm.internal.m.c(this.sessionId, joinSessionEvent.sessionId) && this.joined == joinSessionEvent.joined;
        }
        return false;
    }

    public final boolean getJoined() {
        return this.joined;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.sessionId.hashCode() * 31;
        boolean z = this.joined;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "JoinSessionEvent(sessionId=" + this.sessionId + ", joined=" + this.joined + ')';
    }
}