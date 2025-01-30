package com.coinbase.wallet.core.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TraceKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B-\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u000f\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u000e\u0010\nR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Z", "component4", ApiConstants.NAME, "uuid", "isRemoteTrace", "isNoisy", "copy", "(Ljava/lang/String;IZZ)Lcom/coinbase/wallet/core/models/TraceKey;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getName", "descriptor", "getDescriptor", "setDescriptor", "(Ljava/lang/String;)V", "I", "getUuid", "<init>", "(Ljava/lang/String;IZZ)V", "Companion", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TraceKey {
    public static final Companion Companion = new Companion(null);
    private String descriptor;
    private final boolean isNoisy;
    private final boolean isRemoteTrace;
    private final String name;
    private final int uuid;

    /* compiled from: TraceKey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "", "<init>", "()V", "core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TraceKey(String name, int i2, boolean z, boolean z2) {
        m.g(name, "name");
        this.name = name;
        this.uuid = i2;
        this.isRemoteTrace = z;
        this.isNoisy = z2;
    }

    public static /* synthetic */ TraceKey copy$default(TraceKey traceKey, String str, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = traceKey.name;
        }
        if ((i3 & 2) != 0) {
            i2 = traceKey.uuid;
        }
        if ((i3 & 4) != 0) {
            z = traceKey.isRemoteTrace;
        }
        if ((i3 & 8) != 0) {
            z2 = traceKey.isNoisy;
        }
        return traceKey.copy(str, i2, z, z2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.uuid;
    }

    public final boolean component3() {
        return this.isRemoteTrace;
    }

    public final boolean component4() {
        return this.isNoisy;
    }

    public final TraceKey copy(String name, int i2, boolean z, boolean z2) {
        m.g(name, "name");
        return new TraceKey(name, i2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TraceKey) {
            TraceKey traceKey = (TraceKey) obj;
            return m.c(this.name, traceKey.name) && this.uuid == traceKey.uuid && this.isRemoteTrace == traceKey.isRemoteTrace && this.isNoisy == traceKey.isNoisy;
        }
        return false;
    }

    public final String getDescriptor() {
        return this.descriptor;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.uuid) * 31;
        boolean z = this.isRemoteTrace;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isNoisy;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean isNoisy() {
        return this.isNoisy;
    }

    public final boolean isRemoteTrace() {
        return this.isRemoteTrace;
    }

    public final void setDescriptor(String str) {
        this.descriptor = str;
    }

    public String toString() {
        return "TraceKey(name=" + this.name + ", uuid=" + this.uuid + ", isRemoteTrace=" + this.isRemoteTrace + ", isNoisy=" + this.isNoisy + ')';
    }

    public /* synthetic */ TraceKey(String str, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2);
    }
}