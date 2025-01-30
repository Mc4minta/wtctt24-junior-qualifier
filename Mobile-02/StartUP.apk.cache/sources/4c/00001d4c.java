package com.coinbase.wallet.features.cloudbackup.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MnemonicBackupError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0005B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/errors/MnemonicBackupError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "NotSignedIn", "Lcom/coinbase/wallet/features/cloudbackup/errors/MnemonicBackupError$NotSignedIn;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class MnemonicBackupError extends Exception {

    /* compiled from: MnemonicBackupError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/errors/MnemonicBackupError$NotSignedIn;", "Lcom/coinbase/wallet/features/cloudbackup/errors/MnemonicBackupError;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NotSignedIn extends MnemonicBackupError {
        public static final NotSignedIn INSTANCE = new NotSignedIn();

        private NotSignedIn() {
            super(null);
        }
    }

    private MnemonicBackupError() {
    }

    public /* synthetic */ MnemonicBackupError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}