package com.coinbase.wallet.swap.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapTxDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapTxDTO;", "", "Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "component1$swap_release", "()Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "component1", "result", "copy", "(Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;)Lcom/coinbase/wallet/swap/dtos/SwapTxDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "getResult$swap_release", "<init>", "(Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapTxDTO {
    private final SwapTxResultDTO result;

    public SwapTxDTO(SwapTxResultDTO result) {
        m.g(result, "result");
        this.result = result;
    }

    public static /* synthetic */ SwapTxDTO copy$default(SwapTxDTO swapTxDTO, SwapTxResultDTO swapTxResultDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            swapTxResultDTO = swapTxDTO.result;
        }
        return swapTxDTO.copy(swapTxResultDTO);
    }

    public final SwapTxResultDTO component1$swap_release() {
        return this.result;
    }

    public final SwapTxDTO copy(SwapTxResultDTO result) {
        m.g(result, "result");
        return new SwapTxDTO(result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwapTxDTO) && m.c(this.result, ((SwapTxDTO) obj).result);
    }

    public final SwapTxResultDTO getResult$swap_release() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "SwapTxDTO(result=" + this.result + ')';
    }
}