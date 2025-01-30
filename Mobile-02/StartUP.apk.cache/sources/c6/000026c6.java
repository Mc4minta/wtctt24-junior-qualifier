package com.coinbase.wallet.swap.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.swap.models.ApproveTx;
import com.coinbase.wallet.swap.models.SwapFee;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.swap.models.SwapTx;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapTxDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÀ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u000eHÀ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0015\u001a\u00020\u000e8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\bR\u001c\u0010\u0014\u001a\u00020\n8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\f¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "", "Lcom/coinbase/wallet/swap/models/SwapTx;", "component1$swap_release", "()Lcom/coinbase/wallet/swap/models/SwapTx;", "component1", "Lcom/coinbase/wallet/swap/models/ApproveTx;", "component2$swap_release", "()Lcom/coinbase/wallet/swap/models/ApproveTx;", "component2", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "component3$swap_release", "()Lcom/coinbase/wallet/swap/models/SwapQuote;", "component3", "Lcom/coinbase/wallet/swap/models/SwapFee;", "component4$swap_release", "()Lcom/coinbase/wallet/swap/models/SwapFee;", "component4", "tx", "approveTx", ApiConstants.QUOTE, ApiConstants.FEE, "copy", "(Lcom/coinbase/wallet/swap/models/SwapTx;Lcom/coinbase/wallet/swap/models/ApproveTx;Lcom/coinbase/wallet/swap/models/SwapQuote;Lcom/coinbase/wallet/swap/models/SwapFee;)Lcom/coinbase/wallet/swap/dtos/SwapTxResultDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/swap/models/SwapFee;", "getFee$swap_release", "Lcom/coinbase/wallet/swap/models/SwapTx;", "getTx$swap_release", "Lcom/coinbase/wallet/swap/models/ApproveTx;", "getApproveTx$swap_release", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "getQuote$swap_release", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapTx;Lcom/coinbase/wallet/swap/models/ApproveTx;Lcom/coinbase/wallet/swap/models/SwapQuote;Lcom/coinbase/wallet/swap/models/SwapFee;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapTxResultDTO {
    private final ApproveTx approveTx;
    private final SwapFee fee;
    private final SwapQuote quote;
    private final SwapTx tx;

    public SwapTxResultDTO(SwapTx tx, ApproveTx approveTx, SwapQuote quote, SwapFee fee) {
        m.g(tx, "tx");
        m.g(quote, "quote");
        m.g(fee, "fee");
        this.tx = tx;
        this.approveTx = approveTx;
        this.quote = quote;
        this.fee = fee;
    }

    public static /* synthetic */ SwapTxResultDTO copy$default(SwapTxResultDTO swapTxResultDTO, SwapTx swapTx, ApproveTx approveTx, SwapQuote swapQuote, SwapFee swapFee, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            swapTx = swapTxResultDTO.tx;
        }
        if ((i2 & 2) != 0) {
            approveTx = swapTxResultDTO.approveTx;
        }
        if ((i2 & 4) != 0) {
            swapQuote = swapTxResultDTO.quote;
        }
        if ((i2 & 8) != 0) {
            swapFee = swapTxResultDTO.fee;
        }
        return swapTxResultDTO.copy(swapTx, approveTx, swapQuote, swapFee);
    }

    public final SwapTx component1$swap_release() {
        return this.tx;
    }

    public final ApproveTx component2$swap_release() {
        return this.approveTx;
    }

    public final SwapQuote component3$swap_release() {
        return this.quote;
    }

    public final SwapFee component4$swap_release() {
        return this.fee;
    }

    public final SwapTxResultDTO copy(SwapTx tx, ApproveTx approveTx, SwapQuote quote, SwapFee fee) {
        m.g(tx, "tx");
        m.g(quote, "quote");
        m.g(fee, "fee");
        return new SwapTxResultDTO(tx, approveTx, quote, fee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapTxResultDTO) {
            SwapTxResultDTO swapTxResultDTO = (SwapTxResultDTO) obj;
            return m.c(this.tx, swapTxResultDTO.tx) && m.c(this.approveTx, swapTxResultDTO.approveTx) && m.c(this.quote, swapTxResultDTO.quote) && m.c(this.fee, swapTxResultDTO.fee);
        }
        return false;
    }

    public final ApproveTx getApproveTx$swap_release() {
        return this.approveTx;
    }

    public final SwapFee getFee$swap_release() {
        return this.fee;
    }

    public final SwapQuote getQuote$swap_release() {
        return this.quote;
    }

    public final SwapTx getTx$swap_release() {
        return this.tx;
    }

    public int hashCode() {
        int hashCode = this.tx.hashCode() * 31;
        ApproveTx approveTx = this.approveTx;
        return ((((hashCode + (approveTx == null ? 0 : approveTx.hashCode())) * 31) + this.quote.hashCode()) * 31) + this.fee.hashCode();
    }

    public String toString() {
        return "SwapTxResultDTO(tx=" + this.tx + ", approveTx=" + this.approveTx + ", quote=" + this.quote + ", fee=" + this.fee + ')';
    }
}