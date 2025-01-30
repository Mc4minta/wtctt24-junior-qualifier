package com.coinbase.wallet.http.models;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WebConnectionState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/http/models/WebConnectionState;", "", "", "isConnected", "()Z", "<init>", "()V", "Connected", "Disconnected", "Lcom/coinbase/wallet/http/models/WebConnectionState$Connected;", "Lcom/coinbase/wallet/http/models/WebConnectionState$Disconnected;", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WebConnectionState {

    /* compiled from: WebConnectionState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/http/models/WebConnectionState$Connected;", "Lcom/coinbase/wallet/http/models/WebConnectionState;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Connected extends WebConnectionState {
        public static final Connected INSTANCE = new Connected();

        private Connected() {
            super(null);
        }
    }

    /* compiled from: WebConnectionState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/http/models/WebConnectionState$Disconnected;", "Lcom/coinbase/wallet/http/models/WebConnectionState;", "", "component1", "()Ljava/lang/Throwable;", "t", "copy", "(Ljava/lang/Throwable;)Lcom/coinbase/wallet/http/models/WebConnectionState$Disconnected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Throwable;", "getT", "<init>", "(Ljava/lang/Throwable;)V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Disconnected extends WebConnectionState {
        private final Throwable t;

        public Disconnected(Throwable th) {
            super(null);
            this.t = th;
        }

        public static /* synthetic */ Disconnected copy$default(Disconnected disconnected, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                th = disconnected.t;
            }
            return disconnected.copy(th);
        }

        public final Throwable component1() {
            return this.t;
        }

        public final Disconnected copy(Throwable th) {
            return new Disconnected(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Disconnected) && m.c(this.t, ((Disconnected) obj).t);
        }

        public final Throwable getT() {
            return this.t;
        }

        public int hashCode() {
            Throwable th = this.t;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Disconnected(t=" + this.t + ')';
        }
    }

    private WebConnectionState() {
    }

    public /* synthetic */ WebConnectionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean isConnected() {
        if (this instanceof Connected) {
            return true;
        }
        if (this instanceof Disconnected) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}