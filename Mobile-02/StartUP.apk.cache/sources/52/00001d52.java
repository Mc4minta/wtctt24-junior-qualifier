package com.coinbase.wallet.features.cloudbackup.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BackupStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "", "<init>", "()V", "BackedUpAll", "BackedUpManually", "BackedUpToCloud", "Error", "NotBackedUp", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$BackedUpAll;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$BackedUpManually;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$BackedUpToCloud;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$NotBackedUp;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$Error;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class BackupStatus {

    /* compiled from: BackupStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$BackedUpAll;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BackedUpAll extends BackupStatus {
        public static final BackedUpAll INSTANCE = new BackedUpAll();

        private BackedUpAll() {
            super(null);
        }
    }

    /* compiled from: BackupStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$BackedUpManually;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BackedUpManually extends BackupStatus {
        public static final BackedUpManually INSTANCE = new BackedUpManually();

        private BackedUpManually() {
            super(null);
        }
    }

    /* compiled from: BackupStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$BackedUpToCloud;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BackedUpToCloud extends BackupStatus {
        public static final BackedUpToCloud INSTANCE = new BackedUpToCloud();

        private BackedUpToCloud() {
            super(null);
        }
    }

    /* compiled from: BackupStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$Error;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "", "throwable", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends BackupStatus {
        private final Throwable throwable;

        public Error() {
            this(null, 1, null);
        }

        public Error(Throwable th) {
            super(null);
            this.throwable = th;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public /* synthetic */ Error(Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : th);
        }
    }

    /* compiled from: BackupStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus$NotBackedUp;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NotBackedUp extends BackupStatus {
        public static final NotBackedUp INSTANCE = new NotBackedUp();

        private NotBackedUp() {
            super(null);
        }
    }

    private BackupStatus() {
    }

    public /* synthetic */ BackupStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}