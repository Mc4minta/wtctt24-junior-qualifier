package com.coinbase.wallet.features.wallets.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Wallet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: ListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/ListItem;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "FundListItem", "LendListItem", "SectionHeader", "WalletListItem", "Lcom/coinbase/wallet/features/wallets/models/ListItem$SectionHeader;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$LendListItem;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$FundListItem;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ListItem {
    private final String id;

    /* compiled from: ListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/ListItem$FundListItem;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "", "component1", "()Ljava/lang/String;", "component2", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/wallets/models/ListItem$FundListItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class FundListItem extends ListItem {
        private final String description;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FundListItem(String title, String description) {
            super("fund_cell", null);
            m.g(title, "title");
            m.g(description, "description");
            this.title = title;
            this.description = description;
        }

        public static /* synthetic */ FundListItem copy$default(FundListItem fundListItem, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = fundListItem.title;
            }
            if ((i2 & 2) != 0) {
                str2 = fundListItem.description;
            }
            return fundListItem.copy(str, str2);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.description;
        }

        public final FundListItem copy(String title, String description) {
            m.g(title, "title");
            m.g(description, "description");
            return new FundListItem(title, description);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FundListItem) {
                FundListItem fundListItem = (FundListItem) obj;
                return m.c(this.title, fundListItem.title) && m.c(this.description, fundListItem.description);
            }
            return false;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.description.hashCode();
        }

        public String toString() {
            return "FundListItem(title=" + this.title + ", description=" + this.description + ')';
        }
    }

    /* compiled from: ListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/ListItem$LendListItem;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "fiatBalance", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/wallets/models/ListItem$LendListItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getDescription", "getFiatBalance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LendListItem extends ListItem {
        private final String description;
        private final String fiatBalance;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LendListItem(String title, String description, String fiatBalance) {
            super("lend_cell", null);
            m.g(title, "title");
            m.g(description, "description");
            m.g(fiatBalance, "fiatBalance");
            this.title = title;
            this.description = description;
            this.fiatBalance = fiatBalance;
        }

        public static /* synthetic */ LendListItem copy$default(LendListItem lendListItem, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = lendListItem.title;
            }
            if ((i2 & 2) != 0) {
                str2 = lendListItem.description;
            }
            if ((i2 & 4) != 0) {
                str3 = lendListItem.fiatBalance;
            }
            return lendListItem.copy(str, str2, str3);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.description;
        }

        public final String component3() {
            return this.fiatBalance;
        }

        public final LendListItem copy(String title, String description, String fiatBalance) {
            m.g(title, "title");
            m.g(description, "description");
            m.g(fiatBalance, "fiatBalance");
            return new LendListItem(title, description, fiatBalance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LendListItem) {
                LendListItem lendListItem = (LendListItem) obj;
                return m.c(this.title, lendListItem.title) && m.c(this.description, lendListItem.description) && m.c(this.fiatBalance, lendListItem.fiatBalance);
            }
            return false;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getFiatBalance() {
            return this.fiatBalance;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.fiatBalance.hashCode();
        }

        public String toString() {
            return "LendListItem(title=" + this.title + ", description=" + this.description + ", fiatBalance=" + this.fiatBalance + ')';
        }
    }

    /* compiled from: ListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/ListItem$SectionHeader;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "", "component1", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/wallets/models/ListItem$SectionHeader;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SectionHeader extends ListItem {
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeader(String title) {
            super(title, null);
            m.g(title, "title");
            this.title = title;
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sectionHeader.title;
            }
            return sectionHeader.copy(str);
        }

        public final String component1() {
            return this.title;
        }

        public final SectionHeader copy(String title) {
            m.g(title, "title");
            return new SectionHeader(title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SectionHeader) && m.c(this.title, ((SectionHeader) obj).title);
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return this.title.hashCode();
        }

        public String toString() {
            return "SectionHeader(title=" + this.title + ')';
        }
    }

    /* compiled from: ListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "", "component2", "()Ljava/lang/String;", "component3", "wallet", "fiatBalance", "cryptoBalance", "copy", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "Ljava/lang/String;", "getCryptoBalance", "getFiatBalance", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class WalletListItem extends ListItem {
        private final String cryptoBalance;
        private final String fiatBalance;
        private final Wallet wallet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WalletListItem(Wallet wallet, String str, String cryptoBalance) {
            super(wallet.getId(), null);
            m.g(wallet, "wallet");
            m.g(cryptoBalance, "cryptoBalance");
            this.wallet = wallet;
            this.fiatBalance = str;
            this.cryptoBalance = cryptoBalance;
        }

        public static /* synthetic */ WalletListItem copy$default(WalletListItem walletListItem, Wallet wallet, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                wallet = walletListItem.wallet;
            }
            if ((i2 & 2) != 0) {
                str = walletListItem.fiatBalance;
            }
            if ((i2 & 4) != 0) {
                str2 = walletListItem.cryptoBalance;
            }
            return walletListItem.copy(wallet, str, str2);
        }

        public final Wallet component1() {
            return this.wallet;
        }

        public final String component2() {
            return this.fiatBalance;
        }

        public final String component3() {
            return this.cryptoBalance;
        }

        public final WalletListItem copy(Wallet wallet, String str, String cryptoBalance) {
            m.g(wallet, "wallet");
            m.g(cryptoBalance, "cryptoBalance");
            return new WalletListItem(wallet, str, cryptoBalance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WalletListItem) {
                WalletListItem walletListItem = (WalletListItem) obj;
                return m.c(this.wallet, walletListItem.wallet) && m.c(this.fiatBalance, walletListItem.fiatBalance) && m.c(this.cryptoBalance, walletListItem.cryptoBalance);
            }
            return false;
        }

        public final String getCryptoBalance() {
            return this.cryptoBalance;
        }

        public final String getFiatBalance() {
            return this.fiatBalance;
        }

        public final Wallet getWallet() {
            return this.wallet;
        }

        public int hashCode() {
            int hashCode = this.wallet.hashCode() * 31;
            String str = this.fiatBalance;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.cryptoBalance.hashCode();
        }

        public String toString() {
            return "WalletListItem(wallet=" + this.wallet + ", fiatBalance=" + ((Object) this.fiatBalance) + ", cryptoBalance=" + this.cryptoBalance + ')';
        }
    }

    private ListItem(String str) {
        this.id = str;
    }

    public /* synthetic */ ListItem(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getId() {
        return this.id;
    }
}