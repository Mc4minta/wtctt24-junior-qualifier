package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SendAmounts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendAmounts;", "", "", "component1", "()Ljava/lang/String;", "component2", "fiat", "crypto", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/SendAmounts;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCrypto", "getFiat", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendAmounts {
    private final String crypto;
    private final String fiat;

    public SendAmounts(String fiat, String crypto) {
        m.g(fiat, "fiat");
        m.g(crypto, "crypto");
        this.fiat = fiat;
        this.crypto = crypto;
    }

    public static /* synthetic */ SendAmounts copy$default(SendAmounts sendAmounts, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sendAmounts.fiat;
        }
        if ((i2 & 2) != 0) {
            str2 = sendAmounts.crypto;
        }
        return sendAmounts.copy(str, str2);
    }

    public final String component1() {
        return this.fiat;
    }

    public final String component2() {
        return this.crypto;
    }

    public final SendAmounts copy(String fiat, String crypto) {
        m.g(fiat, "fiat");
        m.g(crypto, "crypto");
        return new SendAmounts(fiat, crypto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendAmounts) {
            SendAmounts sendAmounts = (SendAmounts) obj;
            return m.c(this.fiat, sendAmounts.fiat) && m.c(this.crypto, sendAmounts.crypto);
        }
        return false;
    }

    public final String getCrypto() {
        return this.crypto;
    }

    public final String getFiat() {
        return this.fiat;
    }

    public int hashCode() {
        return (this.fiat.hashCode() * 31) + this.crypto.hashCode();
    }

    public String toString() {
        return "SendAmounts(fiat=" + this.fiat + ", crypto=" + this.crypto + ')';
    }
}