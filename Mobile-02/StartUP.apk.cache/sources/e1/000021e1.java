package com.coinbase.wallet.features.swap.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: SwapAssetPickerItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "SectionHeader", "SwapAssetItem", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SectionHeader;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SwapAssetPickerItem {
    private final String id;

    /* compiled from: SwapAssetPickerItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SectionHeader;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "", "component1", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SectionHeader;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SectionHeader extends SwapAssetPickerItem {
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeader(String title) {
            super(m.o("header:", title), null);
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

    private SwapAssetPickerItem(String str) {
        this.id = str;
    }

    public /* synthetic */ SwapAssetPickerItem(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getId() {
        return this.id;
    }

    /* compiled from: SwapAssetPickerItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007JN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "component1", "()Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "type", ApiConstants.NAME, AppsFlyerProperties.CURRENCY_CODE, "imageURL", "fiatBalance", "cryptoBalance", "copy", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCryptoBalance", "getImageURL", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "getType", "getFiatBalance", "getCurrencyCode", "getName", "<init>", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SwapAssetItem extends SwapAssetPickerItem {
        private final String cryptoBalance;
        private final String currencyCode;
        private final String fiatBalance;
        private final String imageURL;
        private final String name;
        private final SwapAssetType type;

        public /* synthetic */ SwapAssetItem(SwapAssetType swapAssetType, String str, String str2, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(swapAssetType, str, str2, str3, (i2 & 16) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str4, (i2 & 32) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str5);
        }

        public static /* synthetic */ SwapAssetItem copy$default(SwapAssetItem swapAssetItem, SwapAssetType swapAssetType, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                swapAssetType = swapAssetItem.type;
            }
            if ((i2 & 2) != 0) {
                str = swapAssetItem.name;
            }
            String str6 = str;
            if ((i2 & 4) != 0) {
                str2 = swapAssetItem.currencyCode;
            }
            String str7 = str2;
            if ((i2 & 8) != 0) {
                str3 = swapAssetItem.imageURL;
            }
            String str8 = str3;
            if ((i2 & 16) != 0) {
                str4 = swapAssetItem.fiatBalance;
            }
            String str9 = str4;
            if ((i2 & 32) != 0) {
                str5 = swapAssetItem.cryptoBalance;
            }
            return swapAssetItem.copy(swapAssetType, str6, str7, str8, str9, str5);
        }

        public final SwapAssetType component1() {
            return this.type;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.currencyCode;
        }

        public final String component4() {
            return this.imageURL;
        }

        public final String component5() {
            return this.fiatBalance;
        }

        public final String component6() {
            return this.cryptoBalance;
        }

        public final SwapAssetItem copy(SwapAssetType type, String name, String currencyCode, String str, String fiatBalance, String cryptoBalance) {
            m.g(type, "type");
            m.g(name, "name");
            m.g(currencyCode, "currencyCode");
            m.g(fiatBalance, "fiatBalance");
            m.g(cryptoBalance, "cryptoBalance");
            return new SwapAssetItem(type, name, currencyCode, str, fiatBalance, cryptoBalance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwapAssetItem) {
                SwapAssetItem swapAssetItem = (SwapAssetItem) obj;
                return m.c(this.type, swapAssetItem.type) && m.c(this.name, swapAssetItem.name) && m.c(this.currencyCode, swapAssetItem.currencyCode) && m.c(this.imageURL, swapAssetItem.imageURL) && m.c(this.fiatBalance, swapAssetItem.fiatBalance) && m.c(this.cryptoBalance, swapAssetItem.cryptoBalance);
            }
            return false;
        }

        public final String getCryptoBalance() {
            return this.cryptoBalance;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public final String getFiatBalance() {
            return this.fiatBalance;
        }

        public final String getImageURL() {
            return this.imageURL;
        }

        public final String getName() {
            return this.name;
        }

        public final SwapAssetType getType() {
            return this.type;
        }

        public int hashCode() {
            int hashCode = ((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
            String str = this.imageURL;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fiatBalance.hashCode()) * 31) + this.cryptoBalance.hashCode();
        }

        public String toString() {
            return "SwapAssetItem(type=" + this.type + ", name=" + this.name + ", currencyCode=" + this.currencyCode + ", imageURL=" + ((Object) this.imageURL) + ", fiatBalance=" + this.fiatBalance + ", cryptoBalance=" + this.cryptoBalance + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwapAssetItem(SwapAssetType type, String name, String currencyCode, String str, String fiatBalance, String cryptoBalance) {
            super(name + '/' + currencyCode, null);
            m.g(type, "type");
            m.g(name, "name");
            m.g(currencyCode, "currencyCode");
            m.g(fiatBalance, "fiatBalance");
            m.g(cryptoBalance, "cryptoBalance");
            this.type = type;
            this.name = name;
            this.currencyCode = currencyCode;
            this.imageURL = str;
            this.fiatBalance = fiatBalance;
            this.cryptoBalance = cryptoBalance;
        }
    }
}