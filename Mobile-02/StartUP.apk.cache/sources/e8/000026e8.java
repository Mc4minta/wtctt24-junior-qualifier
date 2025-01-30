package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.v;

/* compiled from: SwapTrade.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\bG\u0010HJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÀ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JD\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0012J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b#\u0010\u0012J \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b(\u0010)R\u0015\u0010-\u001a\u0004\u0018\u00010*8F@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u00100\u001a\u00020 8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b2\u0010\fR\u001c\u0010\u0014\u001a\u00020\u00068\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u00103\u001a\u0004\b4\u0010\bR\u0015\u00106\u001a\u0004\u0018\u00010*8F@\u0006¢\u0006\u0006\u001a\u0004\b5\u0010,R\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00107\u001a\u0004\b8\u0010\u000fR\u0019\u0010\u0017\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00109\u001a\u0004\b:\u0010\u0012R\u0015\u0010>\u001a\u0004\u0018\u00010;8F@\u0006¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0015\u0010@\u001a\u0004\u0018\u00010;8F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010=R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010A\u001a\u0004\bB\u0010\u0004R\u0015\u0010D\u001a\u0004\u0018\u00010*8F@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010,R\u0013\u0010F\u001a\u00020*8F@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010,¨\u0006I"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapTrade;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/swap/models/ApproveTx;", "component1$swap_release", "()Lcom/coinbase/wallet/swap/models/ApproveTx;", "component1", "Lcom/coinbase/wallet/swap/models/SwapTx;", "component2$swap_release", "()Lcom/coinbase/wallet/swap/models/SwapTx;", "component2", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "component3", "()Lcom/coinbase/wallet/swap/models/SwapQuote;", "Lcom/coinbase/wallet/swap/models/SwapFee;", "component4", "()Lcom/coinbase/wallet/swap/models/SwapFee;", "", "component5", "()I", "approveTx", "tx", ApiConstants.QUOTE, ApiConstants.FEE, RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Lcom/coinbase/wallet/swap/models/ApproveTx;Lcom/coinbase/wallet/swap/models/SwapTx;Lcom/coinbase/wallet/swap/models/SwapQuote;Lcom/coinbase/wallet/swap/models/SwapFee;I)Lcom/coinbase/wallet/swap/models/SwapTrade;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigInteger;", "getGasPrice", "()Ljava/math/BigInteger;", "gasPrice", "getHighPriceImpact", "()Z", "highPriceImpact", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "getQuote", "Lcom/coinbase/wallet/swap/models/SwapTx;", "getTx$swap_release", "getEstimatedSwapTxMinerFee", "estimatedSwapTxMinerFee", "Lcom/coinbase/wallet/swap/models/SwapFee;", "getFee", "I", "getChainId", "", "getApproveHexEncodedTxData", "()[B", "approveHexEncodedTxData", "getSwapHexEncodedTxData", "swapHexEncodedTxData", "Lcom/coinbase/wallet/swap/models/ApproveTx;", "getApproveTx$swap_release", "getEstimatedApproveTxMinerFee", "estimatedApproveTxMinerFee", "getChainPrimaryAssetValue", "chainPrimaryAssetValue", "<init>", "(Lcom/coinbase/wallet/swap/models/ApproveTx;Lcom/coinbase/wallet/swap/models/SwapTx;Lcom/coinbase/wallet/swap/models/SwapQuote;Lcom/coinbase/wallet/swap/models/SwapFee;I)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapTrade implements Parcelable {
    public static final Parcelable.Creator<SwapTrade> CREATOR = new Creator();
    private final ApproveTx approveTx;
    private final int chainId;
    private final SwapFee fee;
    private final SwapQuote quote;
    private final SwapTx tx;

    /* compiled from: SwapTrade.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SwapTrade> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapTrade createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new SwapTrade(parcel.readInt() == 0 ? null : ApproveTx.CREATOR.createFromParcel(parcel), SwapTx.CREATOR.createFromParcel(parcel), SwapQuote.CREATOR.createFromParcel(parcel), SwapFee.CREATOR.createFromParcel(parcel), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapTrade[] newArray(int i2) {
            return new SwapTrade[i2];
        }
    }

    public SwapTrade(ApproveTx approveTx, SwapTx tx, SwapQuote quote, SwapFee fee, int i2) {
        m.g(tx, "tx");
        m.g(quote, "quote");
        m.g(fee, "fee");
        this.approveTx = approveTx;
        this.tx = tx;
        this.quote = quote;
        this.fee = fee;
        this.chainId = i2;
    }

    public static /* synthetic */ SwapTrade copy$default(SwapTrade swapTrade, ApproveTx approveTx, SwapTx swapTx, SwapQuote swapQuote, SwapFee swapFee, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            approveTx = swapTrade.approveTx;
        }
        if ((i3 & 2) != 0) {
            swapTx = swapTrade.tx;
        }
        SwapTx swapTx2 = swapTx;
        if ((i3 & 4) != 0) {
            swapQuote = swapTrade.quote;
        }
        SwapQuote swapQuote2 = swapQuote;
        if ((i3 & 8) != 0) {
            swapFee = swapTrade.fee;
        }
        SwapFee swapFee2 = swapFee;
        if ((i3 & 16) != 0) {
            i2 = swapTrade.chainId;
        }
        return swapTrade.copy(approveTx, swapTx2, swapQuote2, swapFee2, i2);
    }

    public final ApproveTx component1$swap_release() {
        return this.approveTx;
    }

    public final SwapTx component2$swap_release() {
        return this.tx;
    }

    public final SwapQuote component3() {
        return this.quote;
    }

    public final SwapFee component4() {
        return this.fee;
    }

    public final int component5() {
        return this.chainId;
    }

    public final SwapTrade copy(ApproveTx approveTx, SwapTx tx, SwapQuote quote, SwapFee fee, int i2) {
        m.g(tx, "tx");
        m.g(quote, "quote");
        m.g(fee, "fee");
        return new SwapTrade(approveTx, tx, quote, fee, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapTrade) {
            SwapTrade swapTrade = (SwapTrade) obj;
            return m.c(this.approveTx, swapTrade.approveTx) && m.c(this.tx, swapTrade.tx) && m.c(this.quote, swapTrade.quote) && m.c(this.fee, swapTrade.fee) && this.chainId == swapTrade.chainId;
        }
        return false;
    }

    public final byte[] getApproveHexEncodedTxData() {
        String data$swap_release;
        ApproveTx approveTx = this.approveTx;
        if (approveTx == null || (data$swap_release = approveTx.getData$swap_release()) == null) {
            return null;
        }
        return String_CoreKt.asHexEncodedData(data$swap_release);
    }

    public final ApproveTx getApproveTx$swap_release() {
        return this.approveTx;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final BigInteger getChainPrimaryAssetValue() {
        String value$swap_release = this.tx.getValue$swap_release();
        BigInteger bigInteger = value$swap_release == null ? null : new BigInteger(value$swap_release);
        if (bigInteger == null) {
            BigInteger ZERO = BigInteger.ZERO;
            m.f(ZERO, "ZERO");
            return ZERO;
        }
        return bigInteger;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
        r2 = kotlin.l0.v.k(r3.approveTx.getGasPrice$swap_release());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.math.BigInteger getEstimatedApproveTxMinerFee() {
        /*
            r3 = this;
            com.coinbase.wallet.swap.models.ApproveTx r0 = r3.approveTx
            r1 = 0
            if (r0 != 0) goto L7
        L5:
            r0 = r1
            goto L12
        L7:
            java.lang.String r0 = r0.getGas$swap_release()
            if (r0 != 0) goto Le
            goto L5
        Le:
            java.math.BigInteger r0 = kotlin.l0.o.k(r0)
        L12:
            if (r0 != 0) goto L15
            return r1
        L15:
            com.coinbase.wallet.swap.models.ApproveTx r2 = r3.approveTx
            java.lang.String r2 = r2.getGasPrice$swap_release()
            java.math.BigInteger r2 = kotlin.l0.o.k(r2)
            if (r2 != 0) goto L22
            return r1
        L22:
            java.math.BigInteger r0 = r0.multiply(r2)
            java.lang.String r1 = "this.multiply(other)"
            kotlin.jvm.internal.m.f(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.models.SwapTrade.getEstimatedApproveTxMinerFee():java.math.BigInteger");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        r2 = kotlin.l0.v.k(r3.tx.getGasPrice$swap_release());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.math.BigInteger getEstimatedSwapTxMinerFee() {
        /*
            r3 = this;
            com.coinbase.wallet.swap.models.SwapTx r0 = r3.tx
            java.lang.String r0 = r0.getGas$swap_release()
            java.math.BigInteger r0 = kotlin.l0.o.k(r0)
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            com.coinbase.wallet.swap.models.SwapTx r2 = r3.tx
            java.lang.String r2 = r2.getGasPrice$swap_release()
            java.math.BigInteger r2 = kotlin.l0.o.k(r2)
            if (r2 != 0) goto L1b
            return r1
        L1b:
            java.math.BigInteger r0 = r0.multiply(r2)
            java.lang.String r1 = "this.multiply(other)"
            kotlin.jvm.internal.m.f(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.models.SwapTrade.getEstimatedSwapTxMinerFee():java.math.BigInteger");
    }

    public final SwapFee getFee() {
        return this.fee;
    }

    public final BigInteger getGasPrice() {
        BigInteger k2;
        k2 = v.k(this.tx.getGasPrice$swap_release());
        return k2;
    }

    public final boolean getHighPriceImpact() {
        return this.quote.getHighPriceImpact();
    }

    public final SwapQuote getQuote() {
        return this.quote;
    }

    public final byte[] getSwapHexEncodedTxData() {
        return String_CoreKt.asHexEncodedData(this.tx.getData$swap_release());
    }

    public final SwapTx getTx$swap_release() {
        return this.tx;
    }

    public int hashCode() {
        ApproveTx approveTx = this.approveTx;
        return ((((((((approveTx == null ? 0 : approveTx.hashCode()) * 31) + this.tx.hashCode()) * 31) + this.quote.hashCode()) * 31) + this.fee.hashCode()) * 31) + this.chainId;
    }

    public String toString() {
        return "SwapTrade(approveTx=" + this.approveTx + ", tx=" + this.tx + ", quote=" + this.quote + ", fee=" + this.fee + ", chainId=" + this.chainId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        ApproveTx approveTx = this.approveTx;
        if (approveTx == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            approveTx.writeToParcel(out, i2);
        }
        this.tx.writeToParcel(out, i2);
        this.quote.writeToParcel(out, i2);
        this.fee.writeToParcel(out, i2);
        out.writeInt(this.chainId);
    }
}