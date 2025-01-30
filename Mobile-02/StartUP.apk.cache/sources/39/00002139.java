package com.coinbase.wallet.features.signer.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SigningSessionEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Cancelled", "Failure", "RequestEthereumAccountsApproved", "SignedAndSubmittedTx", "SignedMessage", "SignedTx", "Signing", "SwitchEthereumChainApproved", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Signing;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedAndSubmittedTx;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedTx;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedMessage;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Cancelled;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$RequestEthereumAccountsApproved;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SwitchEthereumChainApproved;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Failure;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SigningSessionEvent {
    private final String uuid;

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Cancelled;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "uuid", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Cancelled;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Cancelled extends SigningSessionEvent {
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancelled(String uuid) {
            super(uuid, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
        }

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cancelled.getUuid();
            }
            return cancelled.copy(str);
        }

        public final String component1() {
            return getUuid();
        }

        public final Cancelled copy(String uuid) {
            m.g(uuid, "uuid");
            return new Cancelled(uuid);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cancelled) && m.c(getUuid(), ((Cancelled) obj).getUuid());
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return getUuid().hashCode();
        }

        public String toString() {
            return "Cancelled(uuid=" + getUuid() + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Failure;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Throwable;", "uuid", "error", "copy", "(Ljava/lang/String;Ljava/lang/Throwable;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Failure;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "Ljava/lang/Throwable;", "getError", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Failure extends SigningSessionEvent {
        private final Throwable error;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String uuid, Throwable error) {
            super(uuid, null);
            m.g(uuid, "uuid");
            m.g(error, "error");
            this.uuid = uuid;
            this.error = error;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, String str, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = failure.getUuid();
            }
            if ((i2 & 2) != 0) {
                th = failure.error;
            }
            return failure.copy(str, th);
        }

        public final String component1() {
            return getUuid();
        }

        public final Throwable component2() {
            return this.error;
        }

        public final Failure copy(String uuid, Throwable error) {
            m.g(uuid, "uuid");
            m.g(error, "error");
            return new Failure(uuid, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return m.c(getUuid(), failure.getUuid()) && m.c(this.error, failure.error);
            }
            return false;
        }

        public final Throwable getError() {
            return this.error;
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return (getUuid().hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "Failure(uuid=" + getUuid() + ", error=" + this.error + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$RequestEthereumAccountsApproved;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "uuid", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$RequestEthereumAccountsApproved;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RequestEthereumAccountsApproved extends SigningSessionEvent {
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestEthereumAccountsApproved(String uuid) {
            super(uuid, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
        }

        public static /* synthetic */ RequestEthereumAccountsApproved copy$default(RequestEthereumAccountsApproved requestEthereumAccountsApproved, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = requestEthereumAccountsApproved.getUuid();
            }
            return requestEthereumAccountsApproved.copy(str);
        }

        public final String component1() {
            return getUuid();
        }

        public final RequestEthereumAccountsApproved copy(String uuid) {
            m.g(uuid, "uuid");
            return new RequestEthereumAccountsApproved(uuid);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestEthereumAccountsApproved) && m.c(getUuid(), ((RequestEthereumAccountsApproved) obj).getUuid());
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return getUuid().hashCode();
        }

        public String toString() {
            return "RequestEthereumAccountsApproved(uuid=" + getUuid() + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedAndSubmittedTx;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "component2", "()Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "component3", "uuid", "tx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;Ljava/lang/String;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedAndSubmittedTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "getMnemonic", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "getTx", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignedAndSubmittedTx extends SigningSessionEvent {
        private final String mnemonic;
        private final com.coinbase.wallet.blockchains.interfaces.SignedTx tx;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedAndSubmittedTx(String uuid, com.coinbase.wallet.blockchains.interfaces.SignedTx tx, String mnemonic) {
            super(uuid, null);
            m.g(uuid, "uuid");
            m.g(tx, "tx");
            m.g(mnemonic, "mnemonic");
            this.uuid = uuid;
            this.tx = tx;
            this.mnemonic = mnemonic;
        }

        public static /* synthetic */ SignedAndSubmittedTx copy$default(SignedAndSubmittedTx signedAndSubmittedTx, String str, com.coinbase.wallet.blockchains.interfaces.SignedTx signedTx, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = signedAndSubmittedTx.getUuid();
            }
            if ((i2 & 2) != 0) {
                signedTx = signedAndSubmittedTx.tx;
            }
            if ((i2 & 4) != 0) {
                str2 = signedAndSubmittedTx.mnemonic;
            }
            return signedAndSubmittedTx.copy(str, signedTx, str2);
        }

        public final String component1() {
            return getUuid();
        }

        public final com.coinbase.wallet.blockchains.interfaces.SignedTx component2() {
            return this.tx;
        }

        public final String component3() {
            return this.mnemonic;
        }

        public final SignedAndSubmittedTx copy(String uuid, com.coinbase.wallet.blockchains.interfaces.SignedTx tx, String mnemonic) {
            m.g(uuid, "uuid");
            m.g(tx, "tx");
            m.g(mnemonic, "mnemonic");
            return new SignedAndSubmittedTx(uuid, tx, mnemonic);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SignedAndSubmittedTx) {
                SignedAndSubmittedTx signedAndSubmittedTx = (SignedAndSubmittedTx) obj;
                return m.c(getUuid(), signedAndSubmittedTx.getUuid()) && m.c(this.tx, signedAndSubmittedTx.tx) && m.c(this.mnemonic, signedAndSubmittedTx.mnemonic);
            }
            return false;
        }

        public final String getMnemonic() {
            return this.mnemonic;
        }

        public final com.coinbase.wallet.blockchains.interfaces.SignedTx getTx() {
            return this.tx;
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return (((getUuid().hashCode() * 31) + this.tx.hashCode()) * 31) + this.mnemonic.hashCode();
        }

        public String toString() {
            return "SignedAndSubmittedTx(uuid=" + getUuid() + ", tx=" + this.tx + ", mnemonic=" + this.mnemonic + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedMessage;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()[B", "uuid", ApiConstants.MESSAGE, "signature", "copy", "(Ljava/lang/String;Ljava/lang/String;[B)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedMessage;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getSignature", "Ljava/lang/String;", "getUuid", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;[B)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignedMessage extends SigningSessionEvent {
        private final String message;
        private final byte[] signature;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedMessage(String uuid, String message, byte[] signature) {
            super(uuid, null);
            m.g(uuid, "uuid");
            m.g(message, "message");
            m.g(signature, "signature");
            this.uuid = uuid;
            this.message = message;
            this.signature = signature;
        }

        public static /* synthetic */ SignedMessage copy$default(SignedMessage signedMessage, String str, String str2, byte[] bArr, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = signedMessage.getUuid();
            }
            if ((i2 & 2) != 0) {
                str2 = signedMessage.message;
            }
            if ((i2 & 4) != 0) {
                bArr = signedMessage.signature;
            }
            return signedMessage.copy(str, str2, bArr);
        }

        public final String component1() {
            return getUuid();
        }

        public final String component2() {
            return this.message;
        }

        public final byte[] component3() {
            return this.signature;
        }

        public final SignedMessage copy(String uuid, String message, byte[] signature) {
            m.g(uuid, "uuid");
            m.g(message, "message");
            m.g(signature, "signature");
            return new SignedMessage(uuid, message, signature);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SignedMessage) {
                SignedMessage signedMessage = (SignedMessage) obj;
                return m.c(getUuid(), signedMessage.getUuid()) && m.c(this.message, signedMessage.message) && m.c(this.signature, signedMessage.signature);
            }
            return false;
        }

        public final String getMessage() {
            return this.message;
        }

        public final byte[] getSignature() {
            return this.signature;
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return (((getUuid().hashCode() * 31) + this.message.hashCode()) * 31) + Arrays.hashCode(this.signature);
        }

        public String toString() {
            return "SignedMessage(uuid=" + getUuid() + ", message=" + this.message + ", signature=" + Arrays.toString(this.signature) + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedTx;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "component2", "()Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "component3", "uuid", "tx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;Ljava/lang/String;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SignedTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "getTx", "Ljava/lang/String;", "getMnemonic", "getUuid", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignedTx extends SigningSessionEvent {
        private final String mnemonic;
        private final com.coinbase.wallet.blockchains.interfaces.SignedTx tx;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedTx(String uuid, com.coinbase.wallet.blockchains.interfaces.SignedTx tx, String mnemonic) {
            super(uuid, null);
            m.g(uuid, "uuid");
            m.g(tx, "tx");
            m.g(mnemonic, "mnemonic");
            this.uuid = uuid;
            this.tx = tx;
            this.mnemonic = mnemonic;
        }

        public static /* synthetic */ SignedTx copy$default(SignedTx signedTx, String str, com.coinbase.wallet.blockchains.interfaces.SignedTx signedTx2, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = signedTx.getUuid();
            }
            if ((i2 & 2) != 0) {
                signedTx2 = signedTx.tx;
            }
            if ((i2 & 4) != 0) {
                str2 = signedTx.mnemonic;
            }
            return signedTx.copy(str, signedTx2, str2);
        }

        public final String component1() {
            return getUuid();
        }

        public final com.coinbase.wallet.blockchains.interfaces.SignedTx component2() {
            return this.tx;
        }

        public final String component3() {
            return this.mnemonic;
        }

        public final SignedTx copy(String uuid, com.coinbase.wallet.blockchains.interfaces.SignedTx tx, String mnemonic) {
            m.g(uuid, "uuid");
            m.g(tx, "tx");
            m.g(mnemonic, "mnemonic");
            return new SignedTx(uuid, tx, mnemonic);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SignedTx) {
                SignedTx signedTx = (SignedTx) obj;
                return m.c(getUuid(), signedTx.getUuid()) && m.c(this.tx, signedTx.tx) && m.c(this.mnemonic, signedTx.mnemonic);
            }
            return false;
        }

        public final String getMnemonic() {
            return this.mnemonic;
        }

        public final com.coinbase.wallet.blockchains.interfaces.SignedTx getTx() {
            return this.tx;
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return (((getUuid().hashCode() * 31) + this.tx.hashCode()) * 31) + this.mnemonic.hashCode();
        }

        public String toString() {
            return "SignedTx(uuid=" + getUuid() + ", tx=" + this.tx + ", mnemonic=" + this.mnemonic + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Signing;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "uuid", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$Signing;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Signing extends SigningSessionEvent {
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Signing(String uuid) {
            super(uuid, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
        }

        public static /* synthetic */ Signing copy$default(Signing signing, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = signing.getUuid();
            }
            return signing.copy(str);
        }

        public final String component1() {
            return getUuid();
        }

        public final Signing copy(String uuid) {
            m.g(uuid, "uuid");
            return new Signing(uuid);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Signing) && m.c(getUuid(), ((Signing) obj).getUuid());
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return getUuid().hashCode();
        }

        public String toString() {
            return "Signing(uuid=" + getUuid() + ')';
        }
    }

    /* compiled from: SigningSessionEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SwitchEthereumChainApproved;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "", "component1", "()Ljava/lang/String;", "uuid", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent$SwitchEthereumChainApproved;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SwitchEthereumChainApproved extends SigningSessionEvent {
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchEthereumChainApproved(String uuid) {
            super(uuid, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
        }

        public static /* synthetic */ SwitchEthereumChainApproved copy$default(SwitchEthereumChainApproved switchEthereumChainApproved, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = switchEthereumChainApproved.getUuid();
            }
            return switchEthereumChainApproved.copy(str);
        }

        public final String component1() {
            return getUuid();
        }

        public final SwitchEthereumChainApproved copy(String uuid) {
            m.g(uuid, "uuid");
            return new SwitchEthereumChainApproved(uuid);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchEthereumChainApproved) && m.c(getUuid(), ((SwitchEthereumChainApproved) obj).getUuid());
        }

        @Override // com.coinbase.wallet.features.signer.models.SigningSessionEvent
        public String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return getUuid().hashCode();
        }

        public String toString() {
            return "SwitchEthereumChainApproved(uuid=" + getUuid() + ')';
        }
    }

    private SigningSessionEvent(String str) {
        this.uuid = str;
    }

    public /* synthetic */ SigningSessionEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String getUuid() {
        return this.uuid;
    }
}