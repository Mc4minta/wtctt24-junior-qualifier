package com.coinbase.wallet.features.lend.models;

import com.coinbase.android.apiv3.generated.authed.a;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.lending.models.LendToken;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BalanceInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0000\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.B'\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b-\u0010/J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015JR\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u001b\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010\u0012R\u0019\u0010\u001a\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b'\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b)\u0010\u0015R\u0019\u0010\u001e\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b*\u0010\u0015R\u0019\u0010\u001d\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010,¨\u00060"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/BalanceInfo;", "", "", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "component1", "()Ljava/util/List;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/coinbase/wallet/lending/models/LendToken;", "component2", "()Lcom/coinbase/wallet/lending/models/LendToken;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "component3", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "component5", "()Z", "component6", "pendingTxs", LendConfirmationArgs.lendTokenKey, "wallet", "supplyRate", "isPending", "pendingAmount", "copy", "(Ljava/util/List;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/math/BigInteger;ZLjava/math/BigInteger;)Lcom/coinbase/wallet/features/lend/models/BalanceInfo;", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "Lcom/coinbase/wallet/lending/models/LendToken;", "getLendToken", "Ljava/math/BigInteger;", "getSupplyRate", "getPendingAmount", "Z", "Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/math/BigInteger;ZLjava/math/BigInteger;)V", "(Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BalanceInfo {
    private final boolean isPending;
    private final LendToken lendToken;
    private final BigInteger pendingAmount;
    private final List<Transaction> pendingTxs;
    private final BigInteger supplyRate;
    private final Wallet wallet;

    /* compiled from: BalanceInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContractAction.values().length];
            iArr[ContractAction.SUPPLY.ordinal()] = 1;
            iArr[ContractAction.WITHDRAW.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BalanceInfo(List<Transaction> pendingTxs, LendToken lendToken, Wallet wallet, BigInteger supplyRate, boolean z, BigInteger pendingAmount) {
        m.g(pendingTxs, "pendingTxs");
        m.g(lendToken, "lendToken");
        m.g(wallet, "wallet");
        m.g(supplyRate, "supplyRate");
        m.g(pendingAmount, "pendingAmount");
        this.pendingTxs = pendingTxs;
        this.lendToken = lendToken;
        this.wallet = wallet;
        this.supplyRate = supplyRate;
        this.isPending = z;
        this.pendingAmount = pendingAmount;
    }

    private final List<Transaction> component1() {
        return this.pendingTxs;
    }

    public static /* synthetic */ BalanceInfo copy$default(BalanceInfo balanceInfo, List list, LendToken lendToken, Wallet wallet, BigInteger bigInteger, boolean z, BigInteger bigInteger2, int i2, Object obj) {
        List<Transaction> list2 = list;
        if ((i2 & 1) != 0) {
            list2 = balanceInfo.pendingTxs;
        }
        if ((i2 & 2) != 0) {
            lendToken = balanceInfo.lendToken;
        }
        LendToken lendToken2 = lendToken;
        if ((i2 & 4) != 0) {
            wallet = balanceInfo.wallet;
        }
        Wallet wallet2 = wallet;
        if ((i2 & 8) != 0) {
            bigInteger = balanceInfo.supplyRate;
        }
        BigInteger bigInteger3 = bigInteger;
        if ((i2 & 16) != 0) {
            z = balanceInfo.isPending;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            bigInteger2 = balanceInfo.pendingAmount;
        }
        return balanceInfo.copy(list2, lendToken2, wallet2, bigInteger3, z2, bigInteger2);
    }

    public final LendToken component2() {
        return this.lendToken;
    }

    public final Wallet component3() {
        return this.wallet;
    }

    public final BigInteger component4() {
        return this.supplyRate;
    }

    public final boolean component5() {
        return this.isPending;
    }

    public final BigInteger component6() {
        return this.pendingAmount;
    }

    public final BalanceInfo copy(List<Transaction> pendingTxs, LendToken lendToken, Wallet wallet, BigInteger supplyRate, boolean z, BigInteger pendingAmount) {
        m.g(pendingTxs, "pendingTxs");
        m.g(lendToken, "lendToken");
        m.g(wallet, "wallet");
        m.g(supplyRate, "supplyRate");
        m.g(pendingAmount, "pendingAmount");
        return new BalanceInfo(pendingTxs, lendToken, wallet, supplyRate, z, pendingAmount);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BalanceInfo) {
            BalanceInfo balanceInfo = (BalanceInfo) obj;
            return m.c(balanceInfo.lendToken, this.lendToken) && balanceInfo.isPending == this.isPending;
        }
        return false;
    }

    public final LendToken getLendToken() {
        return this.lendToken;
    }

    public final BigInteger getPendingAmount() {
        return this.pendingAmount;
    }

    public final BigInteger getSupplyRate() {
        return this.supplyRate;
    }

    public final Wallet getWallet() {
        return this.wallet;
    }

    public int hashCode() {
        return this.lendToken.hashCode() + (a.a(this.isPending) * 37);
    }

    public final boolean isPending() {
        return this.isPending;
    }

    public String toString() {
        return "BalanceInfo(pendingTxs=" + this.pendingTxs + ", lendToken=" + this.lendToken + ", wallet=" + this.wallet + ", supplyRate=" + this.supplyRate + ", isPending=" + this.isPending + ", pendingAmount=" + this.pendingAmount + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BalanceInfo(com.coinbase.wallet.lending.models.LendToken r10, com.coinbase.wallet.blockchains.models.Wallet r11, java.util.List<com.coinbase.wallet.blockchains.models.Transaction> r12) {
        /*
            r9 = this;
            java.lang.String r0 = "lendToken"
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "wallet"
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "pendingTxs"
            kotlin.jvm.internal.m.g(r12, r0)
            java.math.BigInteger r5 = r10.getSupplyInterestRate()
            boolean r0 = r12.isEmpty()
            r1 = 1
            r6 = r0 ^ 1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r2 = r12.iterator()
        L23:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L7a
            java.lang.Object r3 = r2.next()
            com.coinbase.wallet.blockchains.models.Transaction r3 = (com.coinbase.wallet.blockchains.models.Transaction) r3
            com.coinbase.wallet.blockchains.models.TxMetadata r4 = r3.getMetadata()
            com.coinbase.wallet.blockchains.models.TxMetadataKey$Companion r7 = com.coinbase.wallet.blockchains.models.TxMetadataKey.Companion
            com.coinbase.wallet.blockchains.models.TxMetadataKey r7 = com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt.getContractAction(r7)
            java.lang.Object r4 = r4.get(r7)
            boolean r7 = r4 instanceof java.lang.String
            r8 = 0
            if (r7 == 0) goto L45
            java.lang.String r4 = (java.lang.String) r4
            goto L46
        L45:
            r4 = r8
        L46:
            if (r4 != 0) goto L4a
            r4 = r8
            goto L50
        L4a:
            com.coinbase.wallet.ethereum.models.ContractAction$Companion r7 = com.coinbase.wallet.ethereum.models.ContractAction.Companion
            com.coinbase.wallet.ethereum.models.ContractAction r4 = r7.fromValue(r4)
        L50:
            if (r4 != 0) goto L53
            goto L74
        L53:
            int[] r7 = com.coinbase.wallet.features.lend.models.BalanceInfo.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r7[r4]
            if (r4 == r1) goto L6b
            r7 = 2
            if (r4 != r7) goto L65
            java.math.BigInteger r3 = r3.getAmount()
            goto L73
        L65:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L6b:
            java.math.BigInteger r3 = r3.getAmount()
            java.math.BigInteger r3 = r3.negate()
        L73:
            r8 = r3
        L74:
            if (r8 == 0) goto L23
            r0.add(r8)
            goto L23
        L7a:
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            java.util.Iterator r0 = r0.iterator()
            r7 = r1
        L81:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L9c
            java.lang.Object r1 = r0.next()
            java.math.BigInteger r1 = (java.math.BigInteger) r1
            java.lang.String r2 = "acc"
            kotlin.jvm.internal.m.f(r7, r2)
            java.math.BigInteger r7 = r7.add(r1)
            java.lang.String r1 = "this.add(other)"
            kotlin.jvm.internal.m.f(r7, r1)
            goto L81
        L9c:
            java.lang.String r0 = "pendingTxs\n            .mapNotNull { tx ->\n                val contractAction = (tx.metadata[TxMetadataKey.contractAction] as? String)?.let {\n                    ContractAction.fromValue(it)\n                } ?: return@mapNotNull null\n\n                when (contractAction) {\n                    ContractAction.SUPPLY -> tx.amount.negate()\n                    ContractAction.WITHDRAW -> tx.amount\n                }\n            }\n            .fold(BigInteger.ZERO) { acc, e -> acc + e }"
            kotlin.jvm.internal.m.f(r7, r0)
            r1 = r9
            r2 = r12
            r3 = r10
            r4 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.lend.models.BalanceInfo.<init>(com.coinbase.wallet.lending.models.LendToken, com.coinbase.wallet.blockchains.models.Wallet, java.util.List):void");
    }
}