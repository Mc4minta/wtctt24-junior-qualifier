package com.coinbase.wallet.features.lend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LendError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError;", "", "<init>", "()V", "supplyCancelled", "unableToFindLendingProvider", "unableToGetLendService", "unableToGetLendingData", "unableToSupply", "unableToWithdraw", "withdrawCancelled", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class LendError {

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$supplyCancelled;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class supplyCancelled extends Throwable {
        public static final supplyCancelled INSTANCE = new supplyCancelled();

        private supplyCancelled() {
        }
    }

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$unableToFindLendingProvider;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class unableToFindLendingProvider extends Throwable {
        public static final unableToFindLendingProvider INSTANCE = new unableToFindLendingProvider();

        private unableToFindLendingProvider() {
        }
    }

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$unableToGetLendService;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class unableToGetLendService extends Throwable {
        public static final unableToGetLendService INSTANCE = new unableToGetLendService();

        private unableToGetLendService() {
        }
    }

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$unableToGetLendingData;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class unableToGetLendingData extends Throwable {
        public static final unableToGetLendingData INSTANCE = new unableToGetLendingData();

        private unableToGetLendingData() {
        }
    }

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$unableToSupply;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class unableToSupply extends Throwable {
        public static final unableToSupply INSTANCE = new unableToSupply();

        private unableToSupply() {
        }
    }

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$unableToWithdraw;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class unableToWithdraw extends Throwable {
        public static final unableToWithdraw INSTANCE = new unableToWithdraw();

        private unableToWithdraw() {
        }
    }

    /* compiled from: LendError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/LendError$withdrawCancelled;", "", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class withdrawCancelled extends Throwable {
        public static final withdrawCancelled INSTANCE = new withdrawCancelled();

        private withdrawCancelled() {
        }
    }

    private LendError() {
    }

    public /* synthetic */ LendError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}