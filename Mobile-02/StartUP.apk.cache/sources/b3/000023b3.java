package com.coinbase.wallet.http.connectivity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConnectionStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "", "", "isOnline", "()Z", "<init>", "()V", "Connected", "Offline", "Unknown", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Connected;", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Offline;", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Unknown;", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConnectionStatus {

    /* compiled from: ConnectionStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Connected;", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "Lcom/coinbase/wallet/http/connectivity/ConnectionKind;", "component1", "()Lcom/coinbase/wallet/http/connectivity/ConnectionKind;", "kind", "copy", "(Lcom/coinbase/wallet/http/connectivity/ConnectionKind;)Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Connected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/http/connectivity/ConnectionKind;", "getKind", "<init>", "(Lcom/coinbase/wallet/http/connectivity/ConnectionKind;)V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Connected extends ConnectionStatus {
        private final ConnectionKind kind;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Connected(ConnectionKind kind) {
            super(null);
            m.g(kind, "kind");
            this.kind = kind;
        }

        public static /* synthetic */ Connected copy$default(Connected connected, ConnectionKind connectionKind, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                connectionKind = connected.kind;
            }
            return connected.copy(connectionKind);
        }

        public final ConnectionKind component1() {
            return this.kind;
        }

        public final Connected copy(ConnectionKind kind) {
            m.g(kind, "kind");
            return new Connected(kind);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Connected) && this.kind == ((Connected) obj).kind;
        }

        public final ConnectionKind getKind() {
            return this.kind;
        }

        public int hashCode() {
            return this.kind.hashCode();
        }

        public String toString() {
            return "Connected(kind=" + this.kind + ')';
        }
    }

    /* compiled from: ConnectionStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Offline;", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Offline extends ConnectionStatus {
        public static final Offline INSTANCE = new Offline();

        private Offline() {
            super(null);
        }
    }

    /* compiled from: ConnectionStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/ConnectionStatus$Unknown;", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Unknown extends ConnectionStatus {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    private ConnectionStatus() {
    }

    public /* synthetic */ ConnectionStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean isOnline() {
        return this instanceof Connected;
    }
}