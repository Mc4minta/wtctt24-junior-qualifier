package com.coinbase.wallet.swap.exceptions;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SwapException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\n\u000bB\u0019\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0013\b\u0014\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/swap/exceptions/SwapException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/String;)V", "UnableToCalculateGas", "UnableToGenerateSwapTx", "Lcom/coinbase/wallet/swap/exceptions/SwapException$UnableToGenerateSwapTx;", "Lcom/coinbase/wallet/swap/exceptions/SwapException$UnableToCalculateGas;", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class SwapException extends Exception {

    /* compiled from: SwapException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/swap/exceptions/SwapException$UnableToCalculateGas;", "Lcom/coinbase/wallet/swap/exceptions/SwapException;", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToCalculateGas extends SwapException {
        public static final UnableToCalculateGas INSTANCE = new UnableToCalculateGas();

        private UnableToCalculateGas() {
            super((String) null, 1, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: SwapException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/swap/exceptions/SwapException$UnableToGenerateSwapTx;", "Lcom/coinbase/wallet/swap/exceptions/SwapException;", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToGenerateSwapTx extends SwapException {
        public static final UnableToGenerateSwapTx INSTANCE = new UnableToGenerateSwapTx();

        private UnableToGenerateSwapTx() {
            super((String) null, 1, (DefaultConstructorMarker) null);
        }
    }

    private SwapException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ SwapException(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    public /* synthetic */ SwapException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private SwapException(String str) {
        super(str);
    }

    public /* synthetic */ SwapException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (DefaultConstructorMarker) null);
    }
}