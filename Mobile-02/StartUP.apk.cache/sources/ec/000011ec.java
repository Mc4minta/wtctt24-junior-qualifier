package com.coinbase.wallet.application.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/application/model/AppState;", "", "<init>", "()V", "AppLocked", "AppUnlocked", "NoStoredMnemonic", "UnfinishedAccountSetup", "Lcom/coinbase/wallet/application/model/AppState$AppLocked;", "Lcom/coinbase/wallet/application/model/AppState$AppUnlocked;", "Lcom/coinbase/wallet/application/model/AppState$NoStoredMnemonic;", "Lcom/coinbase/wallet/application/model/AppState$UnfinishedAccountSetup;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AppState {

    /* compiled from: AppState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/application/model/AppState$AppLocked;", "Lcom/coinbase/wallet/application/model/AppState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AppLocked extends AppState {
        public static final AppLocked INSTANCE = new AppLocked();

        private AppLocked() {
            super(null);
        }
    }

    /* compiled from: AppState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/application/model/AppState$AppUnlocked;", "Lcom/coinbase/wallet/application/model/AppState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AppUnlocked extends AppState {
        public static final AppUnlocked INSTANCE = new AppUnlocked();

        private AppUnlocked() {
            super(null);
        }
    }

    /* compiled from: AppState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/application/model/AppState$NoStoredMnemonic;", "Lcom/coinbase/wallet/application/model/AppState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NoStoredMnemonic extends AppState {
        public static final NoStoredMnemonic INSTANCE = new NoStoredMnemonic();

        private NoStoredMnemonic() {
            super(null);
        }
    }

    /* compiled from: AppState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/application/model/AppState$UnfinishedAccountSetup;", "Lcom/coinbase/wallet/application/model/AppState;", "", "component1", "()Z", "hasCreatedWallets", "copy", "(Z)Lcom/coinbase/wallet/application/model/AppState$UnfinishedAccountSetup;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasCreatedWallets", "<init>", "(Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnfinishedAccountSetup extends AppState {
        private final boolean hasCreatedWallets;

        public UnfinishedAccountSetup(boolean z) {
            super(null);
            this.hasCreatedWallets = z;
        }

        public static /* synthetic */ UnfinishedAccountSetup copy$default(UnfinishedAccountSetup unfinishedAccountSetup, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = unfinishedAccountSetup.hasCreatedWallets;
            }
            return unfinishedAccountSetup.copy(z);
        }

        public final boolean component1() {
            return this.hasCreatedWallets;
        }

        public final UnfinishedAccountSetup copy(boolean z) {
            return new UnfinishedAccountSetup(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnfinishedAccountSetup) && this.hasCreatedWallets == ((UnfinishedAccountSetup) obj).hasCreatedWallets;
        }

        public final boolean getHasCreatedWallets() {
            return this.hasCreatedWallets;
        }

        public int hashCode() {
            boolean z = this.hasCreatedWallets;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "UnfinishedAccountSetup(hasCreatedWallets=" + this.hasCreatedWallets + ')';
        }
    }

    private AppState() {
    }

    public /* synthetic */ AppState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}