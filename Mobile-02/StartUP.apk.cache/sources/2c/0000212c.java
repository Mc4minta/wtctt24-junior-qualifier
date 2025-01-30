package com.coinbase.wallet.features.signer.exceptions;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SignerViewException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0007\bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToGenerateUnsignedTx", "UnknownChainId", "Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException$UnableToGenerateUnsignedTx;", "Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException$UnknownChainId;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SignerViewException extends Exception {

    /* compiled from: SignerViewException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException$UnableToGenerateUnsignedTx;", "Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGenerateUnsignedTx extends SignerViewException {
        public static final UnableToGenerateUnsignedTx INSTANCE = new UnableToGenerateUnsignedTx();

        private UnableToGenerateUnsignedTx() {
            super("Unable to generate an unsigned transaction", null);
        }
    }

    /* compiled from: SignerViewException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException$UnknownChainId;", "Lcom/coinbase/wallet/features/signer/exceptions/SignerViewException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnknownChainId extends SignerViewException {
        public static final UnknownChainId INSTANCE = new UnknownChainId();

        private UnknownChainId() {
            super("Unknown chain id passed in", null);
        }
    }

    private SignerViewException(String str) {
        super(str);
    }

    public /* synthetic */ SignerViewException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ SignerViewException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}