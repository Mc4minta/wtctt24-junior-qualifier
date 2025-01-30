package com.coinbase.walletlink.apis;

import com.coinbase.walletlink.dtos.ClientResponseDTO;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkWebSocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/coinbase/walletlink/apis/WalletLinkCallback;", "", "", "component1", "()I", "Lh/c/v0/c;", "Lcom/coinbase/walletlink/dtos/ClientResponseDTO;", "component2", "()Lh/c/v0/c;", "requestId", "subject", "copy", "(ILh/c/v0/c;)Lcom/coinbase/walletlink/apis/WalletLinkCallback;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lh/c/v0/c;", "getSubject", "I", "getRequestId", "<init>", "(ILh/c/v0/c;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkCallback {
    private final int requestId;
    private final h.c.v0.c<ClientResponseDTO> subject;

    public WalletLinkCallback(int i2, h.c.v0.c<ClientResponseDTO> subject) {
        kotlin.jvm.internal.m.g(subject, "subject");
        this.requestId = i2;
        this.subject = subject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WalletLinkCallback copy$default(WalletLinkCallback walletLinkCallback, int i2, h.c.v0.c cVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = walletLinkCallback.requestId;
        }
        if ((i3 & 2) != 0) {
            cVar = walletLinkCallback.subject;
        }
        return walletLinkCallback.copy(i2, cVar);
    }

    public final int component1() {
        return this.requestId;
    }

    public final h.c.v0.c<ClientResponseDTO> component2() {
        return this.subject;
    }

    public final WalletLinkCallback copy(int i2, h.c.v0.c<ClientResponseDTO> subject) {
        kotlin.jvm.internal.m.g(subject, "subject");
        return new WalletLinkCallback(i2, subject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WalletLinkCallback) {
            WalletLinkCallback walletLinkCallback = (WalletLinkCallback) obj;
            return this.requestId == walletLinkCallback.requestId && kotlin.jvm.internal.m.c(this.subject, walletLinkCallback.subject);
        }
        return false;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final h.c.v0.c<ClientResponseDTO> getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return (this.requestId * 31) + this.subject.hashCode();
    }

    public String toString() {
        return "WalletLinkCallback(requestId=" + this.requestId + ", subject=" + this.subject + ')';
    }
}