package com.coinbase.wallet.swap.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapQuoteDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÀ\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00068\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\n\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/swap/dtos/SwapQuoteResultDTO;", "", "", "component1$swap_release", "()Ljava/lang/String;", "component1", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "component2$swap_release", "()Lcom/coinbase/wallet/swap/models/SwapQuote;", "component2", "mode", ApiConstants.QUOTE, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapQuote;)Lcom/coinbase/wallet/swap/dtos/SwapQuoteResultDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "getQuote$swap_release", "Ljava/lang/String;", "getMode$swap_release", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/swap/models/SwapQuote;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapQuoteResultDTO {
    private final String mode;
    private final SwapQuote quote;

    public SwapQuoteResultDTO(String mode, SwapQuote quote) {
        m.g(mode, "mode");
        m.g(quote, "quote");
        this.mode = mode;
        this.quote = quote;
    }

    public static /* synthetic */ SwapQuoteResultDTO copy$default(SwapQuoteResultDTO swapQuoteResultDTO, String str, SwapQuote swapQuote, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = swapQuoteResultDTO.mode;
        }
        if ((i2 & 2) != 0) {
            swapQuote = swapQuoteResultDTO.quote;
        }
        return swapQuoteResultDTO.copy(str, swapQuote);
    }

    public final String component1$swap_release() {
        return this.mode;
    }

    public final SwapQuote component2$swap_release() {
        return this.quote;
    }

    public final SwapQuoteResultDTO copy(String mode, SwapQuote quote) {
        m.g(mode, "mode");
        m.g(quote, "quote");
        return new SwapQuoteResultDTO(mode, quote);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapQuoteResultDTO) {
            SwapQuoteResultDTO swapQuoteResultDTO = (SwapQuoteResultDTO) obj;
            return m.c(this.mode, swapQuoteResultDTO.mode) && m.c(this.quote, swapQuoteResultDTO.quote);
        }
        return false;
    }

    public final String getMode$swap_release() {
        return this.mode;
    }

    public final SwapQuote getQuote$swap_release() {
        return this.quote;
    }

    public int hashCode() {
        return (this.mode.hashCode() * 31) + this.quote.hashCode();
    }

    public String toString() {
        return "SwapQuoteResultDTO(mode=" + this.mode + ", quote=" + this.quote + ')';
    }
}