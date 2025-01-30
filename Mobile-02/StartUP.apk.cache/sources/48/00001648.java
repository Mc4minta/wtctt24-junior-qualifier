package com.coinbase.wallet.consumer.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BuyStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/consumer/models/BuyStatus;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "component3", "()Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "status", "requiresCompletionStep", "secure3DVerification", "copy", "(Ljava/lang/String;ZLcom/coinbase/wallet/consumer/models/Secure3DVerification;)Lcom/coinbase/wallet/consumer/models/BuyStatus;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getRequiresCompletionStep", "Ljava/lang/String;", "getStatus", "Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "getSecure3DVerification", "<init>", "(Ljava/lang/String;ZLcom/coinbase/wallet/consumer/models/Secure3DVerification;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BuyStatus {
    private final boolean requiresCompletionStep;
    private final Secure3DVerification secure3DVerification;
    private final String status;

    public BuyStatus(String status, boolean z, Secure3DVerification secure3DVerification) {
        m.g(status, "status");
        this.status = status;
        this.requiresCompletionStep = z;
        this.secure3DVerification = secure3DVerification;
    }

    public static /* synthetic */ BuyStatus copy$default(BuyStatus buyStatus, String str, boolean z, Secure3DVerification secure3DVerification, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = buyStatus.status;
        }
        if ((i2 & 2) != 0) {
            z = buyStatus.requiresCompletionStep;
        }
        if ((i2 & 4) != 0) {
            secure3DVerification = buyStatus.secure3DVerification;
        }
        return buyStatus.copy(str, z, secure3DVerification);
    }

    public final String component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.requiresCompletionStep;
    }

    public final Secure3DVerification component3() {
        return this.secure3DVerification;
    }

    public final BuyStatus copy(String status, boolean z, Secure3DVerification secure3DVerification) {
        m.g(status, "status");
        return new BuyStatus(status, z, secure3DVerification);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuyStatus) {
            BuyStatus buyStatus = (BuyStatus) obj;
            return m.c(this.status, buyStatus.status) && this.requiresCompletionStep == buyStatus.requiresCompletionStep && m.c(this.secure3DVerification, buyStatus.secure3DVerification);
        }
        return false;
    }

    public final boolean getRequiresCompletionStep() {
        return this.requiresCompletionStep;
    }

    public final Secure3DVerification getSecure3DVerification() {
        return this.secure3DVerification;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        boolean z = this.requiresCompletionStep;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        Secure3DVerification secure3DVerification = this.secure3DVerification;
        return i3 + (secure3DVerification == null ? 0 : secure3DVerification.hashCode());
    }

    public String toString() {
        return "BuyStatus(status=" + this.status + ", requiresCompletionStep=" + this.requiresCompletionStep + ", secure3DVerification=" + this.secure3DVerification + ')';
    }

    public /* synthetic */ BuyStatus(String str, boolean z, Secure3DVerification secure3DVerification, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i2 & 4) != 0 ? null : secure3DVerification);
    }
}