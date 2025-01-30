package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import kotlin.Metadata;

/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/QrResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "destination", SendConfirmationArgs.metadataKey, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/viewmodels/QrResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMetadata", "getDestination", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class QrResult {
    private final String destination;
    private final String metadata;

    public QrResult(String str, String str2) {
        this.destination = str;
        this.metadata = str2;
    }

    public static /* synthetic */ QrResult copy$default(QrResult qrResult, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = qrResult.destination;
        }
        if ((i2 & 2) != 0) {
            str2 = qrResult.metadata;
        }
        return qrResult.copy(str, str2);
    }

    public final String component1() {
        return this.destination;
    }

    public final String component2() {
        return this.metadata;
    }

    public final QrResult copy(String str, String str2) {
        return new QrResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QrResult) {
            QrResult qrResult = (QrResult) obj;
            return kotlin.jvm.internal.m.c(this.destination, qrResult.destination) && kotlin.jvm.internal.m.c(this.metadata, qrResult.metadata);
        }
        return false;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        String str = this.destination;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.metadata;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "QrResult(destination=" + ((Object) this.destination) + ", metadata=" + ((Object) this.metadata) + ')';
    }
}