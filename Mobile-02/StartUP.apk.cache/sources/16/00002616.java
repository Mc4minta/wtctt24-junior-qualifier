package com.coinbase.wallet.stellar.dtos;

import com.coinbase.android.apiv3.generated.authed.b;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: GetTimeDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/stellar/dtos/GetTimeDTO;", "", "", "component1", "()J", "epoch", "copy", "(J)Lcom/coinbase/wallet/stellar/dtos/GetTimeDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getEpoch", "<init>", "(J)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetTimeDTO {
    private final long epoch;

    public GetTimeDTO(@Json(name = "epoch") long j2) {
        this.epoch = j2;
    }

    public static /* synthetic */ GetTimeDTO copy$default(GetTimeDTO getTimeDTO, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = getTimeDTO.epoch;
        }
        return getTimeDTO.copy(j2);
    }

    public final long component1() {
        return this.epoch;
    }

    public final GetTimeDTO copy(@Json(name = "epoch") long j2) {
        return new GetTimeDTO(j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetTimeDTO) && this.epoch == ((GetTimeDTO) obj).epoch;
    }

    public final long getEpoch() {
        return this.epoch;
    }

    public int hashCode() {
        return b.a(this.epoch);
    }

    public String toString() {
        return "GetTimeDTO(epoch=" + this.epoch + ')';
    }
}