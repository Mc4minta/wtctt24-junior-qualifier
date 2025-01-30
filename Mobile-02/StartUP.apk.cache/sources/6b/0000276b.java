package com.coinbase.wallet.txhistory.models;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.extensions.CurrencyFormatter_TxHistoryKt;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import h.c.s;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: TxHistoryCellViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "", "<init>", "()V", "Header", "Item", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Header;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Item;", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class TxHistoryCellViewState {

    /* compiled from: TxHistoryCellViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Header;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "", "component1", "()I", MessageBundle.TITLE_ENTRY, "copy", "(I)Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Header;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTitle", "<init>", "(I)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Header extends TxHistoryCellViewState {
        private final int title;

        public Header(int i2) {
            super(null);
            this.title = i2;
        }

        public static /* synthetic */ Header copy$default(Header header, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = header.title;
            }
            return header.copy(i2);
        }

        public final int component1() {
            return this.title;
        }

        public final Header copy(int i2) {
            return new Header(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && this.title == ((Header) obj).title;
        }

        public final int getTitle() {
            return this.title;
        }

        public int hashCode() {
            return this.title;
        }

        public String toString() {
            return "Header(title=" + this.title + ')';
        }
    }

    private TxHistoryCellViewState() {
    }

    public /* synthetic */ TxHistoryCellViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: TxHistoryCellViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012$\u0010\u001a\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e¢\u0006\u0004\b3\u00104B[\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u00105\u001a\u00020\u0011\u0012\u0006\u00107\u001a\u000206\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u000e\u0012\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00100\u000e¢\u0006\u0004\b3\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J.\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jt\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00052&\b\u0002\u0010\u001a\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\u0007R7\u0010\u001a\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\u0013R\u0013\u0010)\u001a\u00020\"8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\fR\u0013\u00100\u001a\u00020\"8F@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010*R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b2\u0010\u0007¨\u0006="}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Item;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Transaction;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component5", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component6", "Lh/c/s;", "Lkotlin/t;", "Lcom/coinbase/wallet/core/util/Optional;", "", "component7", "()Lh/c/s;", "tx", "displayName", "displayAddress", "entity", "recipientType", "date", "amountsObservable", "copy", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Lh/c/s;)Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Item;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDisplayName", "Lh/c/s;", "getAmountsObservable", "isPending", "()Z", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "getTx", "getDisplayAddress", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "isFailure", "getEntity", "getDate", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Lh/c/s;)V", "decimals", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lkotlin/x;", "refreshObservable", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWalletObservable", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;ILcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lh/c/s;Lh/c/s;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Item extends TxHistoryCellViewState {
        private final s<t<String, Optional<String>, Integer>> amountsObservable;
        private final String date;
        private final String displayAddress;
        private final String displayName;
        private final String entity;
        private final RecipientType recipientType;
        private final Transaction tx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(Transaction tx, String displayName, String displayAddress, String entity, RecipientType recipientType, String date, s<t<String, Optional<String>, Integer>> amountsObservable) {
            super(null);
            m.g(tx, "tx");
            m.g(displayName, "displayName");
            m.g(displayAddress, "displayAddress");
            m.g(entity, "entity");
            m.g(recipientType, "recipientType");
            m.g(date, "date");
            m.g(amountsObservable, "amountsObservable");
            this.tx = tx;
            this.displayName = displayName;
            this.displayAddress = displayAddress;
            this.entity = entity;
            this.recipientType = recipientType;
            this.date = date;
            this.amountsObservable = amountsObservable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final t m1754_init_$lambda0(Transaction tx, int i2, CurrencyFormatter currencyFormatter, o dstr$_u24__u24$feeWallet) {
            BigInteger amount;
            List m;
            m.g(tx, "$tx");
            m.g(currencyFormatter, "$currencyFormatter");
            m.g(dstr$_u24__u24$feeWallet, "$dstr$_u24__u24$feeWallet");
            Wallet wallet = (Wallet) dstr$_u24__u24$feeWallet.b();
            if (m.c(tx.getMetadata().get(TxMetadataKey_EthereumKt.getContractAction(TxMetadataKey.Companion)), ContractAction.WITHDRAW.getRawValue())) {
                amount = tx.getAmount();
            } else if (tx.isSent()) {
                amount = tx.getAmount().negate();
                m.f(amount, "this.negate()");
            } else {
                amount = tx.getAmount();
            }
            m = r.m(new CurrencyComponents(tx.getCurrencyCode(), i2, amount));
            if (tx.isSent()) {
                CurrencyCode feeCurrencyCode = tx.getFeeCurrencyCode();
                int decimals = wallet.getDecimals();
                BigInteger negate = tx.getFee().negate();
                m.f(negate, "this.negate()");
                m.add(new CurrencyComponents(feeCurrencyCode, decimals, negate));
            }
            boolean z = !TxHistoryCellViewStateKt.access$isSelfTransaction(tx);
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(tx.getNetwork());
            o<String, Boolean> formatFiatTotal = CurrencyFormatter_TxHistoryKt.formatFiatTotal(currencyFormatter, m, z, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
            String a = formatFiatTotal.a();
            boolean booleanValue = formatFiatTotal.b().booleanValue();
            String formatToCrypto$default = CurrencyFormatter.formatToCrypto$default(currencyFormatter, tx.getCurrencyCode(), i2, tx.getAmount(), false, 0, 0, 56, (Object) null);
            return new t(a == null ? formatToCrypto$default : a, OptionalKt.toOptional(a != null ? formatToCrypto$default : null), Integer.valueOf(booleanValue ? R.color.primary_green : R.color.primary_black));
        }

        public static /* synthetic */ Item copy$default(Item item, Transaction transaction, String str, String str2, String str3, RecipientType recipientType, String str4, s sVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                transaction = item.tx;
            }
            if ((i2 & 2) != 0) {
                str = item.displayName;
            }
            String str5 = str;
            if ((i2 & 4) != 0) {
                str2 = item.displayAddress;
            }
            String str6 = str2;
            if ((i2 & 8) != 0) {
                str3 = item.entity;
            }
            String str7 = str3;
            if ((i2 & 16) != 0) {
                recipientType = item.recipientType;
            }
            RecipientType recipientType2 = recipientType;
            if ((i2 & 32) != 0) {
                str4 = item.date;
            }
            String str8 = str4;
            s<t<String, Optional<String>, Integer>> sVar2 = sVar;
            if ((i2 & 64) != 0) {
                sVar2 = item.amountsObservable;
            }
            return item.copy(transaction, str5, str6, str7, recipientType2, str8, sVar2);
        }

        public final Transaction component1() {
            return this.tx;
        }

        public final String component2() {
            return this.displayName;
        }

        public final String component3() {
            return this.displayAddress;
        }

        public final String component4() {
            return this.entity;
        }

        public final RecipientType component5() {
            return this.recipientType;
        }

        public final String component6() {
            return this.date;
        }

        public final s<t<String, Optional<String>, Integer>> component7() {
            return this.amountsObservable;
        }

        public final Item copy(Transaction tx, String displayName, String displayAddress, String entity, RecipientType recipientType, String date, s<t<String, Optional<String>, Integer>> amountsObservable) {
            m.g(tx, "tx");
            m.g(displayName, "displayName");
            m.g(displayAddress, "displayAddress");
            m.g(entity, "entity");
            m.g(recipientType, "recipientType");
            m.g(date, "date");
            m.g(amountsObservable, "amountsObservable");
            return new Item(tx, displayName, displayAddress, entity, recipientType, date, amountsObservable);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return m.c(this.tx, item.tx) && m.c(this.displayName, item.displayName) && m.c(this.displayAddress, item.displayAddress) && m.c(this.entity, item.entity) && this.recipientType == item.recipientType && m.c(this.date, item.date) && m.c(this.amountsObservable, item.amountsObservable);
            }
            return false;
        }

        public final s<t<String, Optional<String>, Integer>> getAmountsObservable() {
            return this.amountsObservable;
        }

        public final String getDate() {
            return this.date;
        }

        public final String getDisplayAddress() {
            return this.displayAddress;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getEntity() {
            return this.entity;
        }

        public final RecipientType getRecipientType() {
            return this.recipientType;
        }

        public final Transaction getTx() {
            return this.tx;
        }

        public int hashCode() {
            return (((((((((((this.tx.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.displayAddress.hashCode()) * 31) + this.entity.hashCode()) * 31) + this.recipientType.hashCode()) * 31) + this.date.hashCode()) * 31) + this.amountsObservable.hashCode();
        }

        public final boolean isFailure() {
            return this.tx.getState() == TxState.FAILED || this.tx.getState() == TxState.DROPPED;
        }

        public final boolean isPending() {
            return this.tx.getState() == TxState.PENDING;
        }

        public String toString() {
            return "Item(tx=" + this.tx + ", displayName=" + this.displayName + ", displayAddress=" + this.displayAddress + ", entity=" + this.entity + ", recipientType=" + this.recipientType + ", date=" + this.date + ", amountsObservable=" + this.amountsObservable + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Item(final com.coinbase.wallet.blockchains.models.Transaction r15, java.lang.String r16, java.lang.String r17, com.coinbase.wallet.txhistory.models.RecipientType r18, final int r19, final com.coinbase.wallet.wallets.formatters.CurrencyFormatter r20, h.c.s<kotlin.x> r21, h.c.s<com.coinbase.wallet.core.util.Optional<com.coinbase.wallet.blockchains.models.Wallet>> r22) {
            /*
                r14 = this;
                r1 = r15
                r0 = r18
                r2 = r20
                r3 = r21
                r4 = r22
                java.lang.String r5 = "tx"
                kotlin.jvm.internal.m.g(r15, r5)
                java.lang.String r5 = "displayName"
                r6 = r16
                kotlin.jvm.internal.m.g(r6, r5)
                java.lang.String r5 = "displayAddress"
                r13 = r17
                kotlin.jvm.internal.m.g(r13, r5)
                java.lang.String r5 = "recipientType"
                kotlin.jvm.internal.m.g(r0, r5)
                java.lang.String r5 = "currencyFormatter"
                kotlin.jvm.internal.m.g(r2, r5)
                java.lang.String r5 = "refreshObservable"
                kotlin.jvm.internal.m.g(r3, r5)
                java.lang.String r5 = "feeWalletObservable"
                kotlin.jvm.internal.m.g(r4, r5)
                boolean r5 = com.coinbase.wallet.txhistory.extensions.Transaction_TxHistoryKt.isConsumerTransfer(r15)
                if (r5 == 0) goto L39
                com.coinbase.wallet.txhistory.models.RecipientType r5 = com.coinbase.wallet.txhistory.models.RecipientType.Coinbase
                goto L3a
            L39:
                r5 = r0
            L3a:
                com.coinbase.wallet.txhistory.models.RecipientType r7 = com.coinbase.wallet.txhistory.models.RecipientType.Address
                if (r0 != r7) goto L4b
                r8 = 6
                r9 = 4
                r10 = 0
                r11 = 4
                r12 = 0
                r7 = r17
                java.lang.String r0 = com.coinbase.wallet.common.extensions.String_CommonKt.truncateMiddle$default(r7, r8, r9, r10, r11, r12)
                r7 = r0
                goto L4c
            L4b:
                r7 = r6
            L4c:
                java.text.SimpleDateFormat r0 = com.coinbase.wallet.txhistory.models.TxHistoryCellViewStateKt.access$getDateFormatter()
                java.util.Date r8 = r15.getCreatedAt()
                java.lang.String r8 = r0.format(r8)
                h.c.t0.c r0 = h.c.t0.c.a
                com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1<T> r9 = new h.c.m0.p() { // from class: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1
                    static {
                        /*
                            com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1 r0 = new com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT  (r0 I:com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1<T>) com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1.INSTANCE com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1.<clinit>():void");
                    }

                    {
                        /*
                            r0 = this;
                            r0.<init>()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1.<init>():void");
                    }

                    public final boolean test(com.coinbase.wallet.core.util.Optional<? extends T> r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.m.g(r2, r0)
                            java.lang.Object r2 = r2.toNullable()
                            if (r2 == 0) goto Ld
                            r2 = 1
                            goto Le
                        Ld:
                            r2 = 0
                        Le:
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1.test(com.coinbase.wallet.core.util.Optional):boolean");
                    }

                    @Override // h.c.m0.p
                    public /* bridge */ /* synthetic */ boolean test(java.lang.Object r1) {
                        /*
                            r0 = this;
                            com.coinbase.wallet.core.util.Optional r1 = (com.coinbase.wallet.core.util.Optional) r1
                            boolean r1 = r0.test(r1)
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$1.test(java.lang.Object):boolean");
                    }
                }
                h.c.s r4 = r4.filter(r9)
                com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2<T, R> r9 = new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2
                    static {
                        /*
                            com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2 r0 = new com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2
                            r0.<init>()
                            
                            // error: 0x0005: SPUT  (r0 I:com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2<T, R>) com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2.INSTANCE com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2.<clinit>():void");
                    }

                    {
                        /*
                            r0 = this;
                            r0.<init>()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2.<init>():void");
                    }

                    public final T apply(com.coinbase.wallet.core.util.Optional<? extends T> r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.m.g(r2, r0)
                            java.lang.Object r2 = r2.toNullable()
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2.apply(com.coinbase.wallet.core.util.Optional):java.lang.Object");
                    }

                    @Override // h.c.m0.n
                    public /* bridge */ /* synthetic */ java.lang.Object apply(java.lang.Object r1) {
                        /*
                            r0 = this;
                            com.coinbase.wallet.core.util.Optional r1 = (com.coinbase.wallet.core.util.Optional) r1
                            java.lang.Object r1 = r0.apply(r1)
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState$Item$special$$inlined$unwrap$2.apply(java.lang.Object):java.lang.Object");
                    }
                }
                h.c.s r4 = r4.map(r9)
                java.lang.String r9 = "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }"
                kotlin.jvm.internal.m.f(r4, r9)
                r9 = 1
                h.c.s r4 = r4.take(r9)
                java.lang.String r9 = "feeWalletObservable.unwrap().take(1)"
                kotlin.jvm.internal.m.f(r4, r9)
                h.c.s r0 = r0.a(r3, r4)
                com.coinbase.wallet.txhistory.models.a r3 = new com.coinbase.wallet.txhistory.models.a
                r4 = r19
                r3.<init>()
                h.c.s r9 = r0.map(r3)
                java.lang.String r0 = "format(tx.createdAt)"
                kotlin.jvm.internal.m.f(r8, r0)
                java.lang.String r0 = "map { (_, feeWallet) ->\n                    val amount: BigInteger = when {\n                        tx.metadata[TxMetadataKey.contractAction] == ContractAction.WITHDRAW.rawValue -> tx.amount\n                        tx.isSent -> -tx.amount\n                        else -> tx.amount\n                    }\n                    val amountsToFormat = mutableListOf(\n                        CurrencyComponents(tx.currencyCode, decimals, amount)\n                    )\n\n                    if (tx.isSent) {\n                        amountsToFormat.add(CurrencyComponents(tx.feeCurrencyCode, feeWallet.decimals, -tx.fee))\n                    }\n\n                    val (fiatAmount, isPositive) = currencyFormatter\n                        .formatFiatTotal(amountsToFormat, !tx.isSelfTransaction(), tx.network.asEthereumChain?.chainId)\n\n                    val cryptoAmount = currencyFormatter.formatToCrypto(tx.currencyCode, decimals, tx.amount)\n\n                    val primaryAmount = fiatAmount ?: cryptoAmount\n                    val secondaryAmount = if (fiatAmount == null) null else cryptoAmount\n                    val primaryColor = if (isPositive) R.color.primary_green else R.color.primary_black\n\n                    Triple(primaryAmount, secondaryAmount.toOptional(), primaryColor)\n                }"
                kotlin.jvm.internal.m.f(r9, r0)
                r0 = r14
                r1 = r15
                r2 = r16
                r3 = r17
                r4 = r7
                r6 = r8
                r7 = r9
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxHistoryCellViewState.Item.<init>(com.coinbase.wallet.blockchains.models.Transaction, java.lang.String, java.lang.String, com.coinbase.wallet.txhistory.models.RecipientType, int, com.coinbase.wallet.wallets.formatters.CurrencyFormatter, h.c.s, h.c.s):void");
        }
    }
}