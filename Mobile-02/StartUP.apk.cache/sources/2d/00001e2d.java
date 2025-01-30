package com.coinbase.wallet.features.dapps;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DappsException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/features/dapps/DappsException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "ChainIdMismatch", "ChainNotSupported", "UnableToDecodeTxHash", "Lcom/coinbase/wallet/features/dapps/DappsException$ChainIdMismatch;", "Lcom/coinbase/wallet/features/dapps/DappsException$ChainNotSupported;", "Lcom/coinbase/wallet/features/dapps/DappsException$UnableToDecodeTxHash;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class DappsException extends Exception {

    /* compiled from: DappsException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/dapps/DappsException$ChainIdMismatch;", "Lcom/coinbase/wallet/features/dapps/DappsException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ChainIdMismatch extends DappsException {
        public static final ChainIdMismatch INSTANCE = new ChainIdMismatch();

        private ChainIdMismatch() {
            super("Chain ID mismatch", null);
        }
    }

    /* compiled from: DappsException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/dapps/DappsException$ChainNotSupported;", "Lcom/coinbase/wallet/features/dapps/DappsException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ChainNotSupported extends DappsException {
        public static final ChainNotSupported INSTANCE = new ChainNotSupported();

        private ChainNotSupported() {
            super("Chain not supported", null);
        }
    }

    /* compiled from: DappsException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/dapps/DappsException$UnableToDecodeTxHash;", "Lcom/coinbase/wallet/features/dapps/DappsException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToDecodeTxHash extends DappsException {
        public static final UnableToDecodeTxHash INSTANCE = new UnableToDecodeTxHash();

        private UnableToDecodeTxHash() {
            super("Unable to decome tx hash", null);
        }
    }

    private DappsException(String str) {
        super(str);
    }

    public /* synthetic */ DappsException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ DappsException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}