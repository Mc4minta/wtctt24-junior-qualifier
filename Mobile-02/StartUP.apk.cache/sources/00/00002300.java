package com.coinbase.wallet.features.walletlink.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WalletLinkException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0006B\u0013\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/exceptions/WalletLinkException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "ChainIdMismatch", "Lcom/coinbase/wallet/features/walletlink/exceptions/WalletLinkException$ChainIdMismatch;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WalletLinkException extends Exception {

    /* compiled from: WalletLinkException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/exceptions/WalletLinkException$ChainIdMismatch;", "Lcom/coinbase/wallet/features/walletlink/exceptions/WalletLinkException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ChainIdMismatch extends WalletLinkException {
        public static final ChainIdMismatch INSTANCE = new ChainIdMismatch();

        private ChainIdMismatch() {
            super("Chain ID mismatch", null);
        }
    }

    private WalletLinkException(String str) {
        super(str);
    }

    public /* synthetic */ WalletLinkException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ WalletLinkException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, null);
    }
}