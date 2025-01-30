package com.coinbase.wallet.features.send.models;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import com.coinbase.wallet.txhistory.models.RecipientType;
import h.c.s;
import h.c.v0.a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import org.apache.http.message.TokenParser;
import org.spongycastle.i18n.MessageBundle;
import org.toshi.R;

/* compiled from: SendDestinationViewInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017B?\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JR\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\u0007R$\u0010,\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u001b0\u001b0*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R*\u0010/\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b4\u0010\u0004¨\u00068"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component2", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component3", "component4", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component5", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component6", "destination", "recipientType", MessageBundle.TITLE_ENTRY, "subtitle", "metadataKey", SendConfirmationArgs.metadataKey, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lh/c/s;", "isLoadingObservable", "Lh/c/s;", "()Lh/c/s;", "getDestination", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "getSubtitle", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "isLoadingSubject", "Lh/c/v0/a;", "value", "isLoading", "Z", "()Z", "setLoading", "(Z)V", "getMetadata", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationViewInfo {
    public static final Companion Companion = new Companion(null);
    private final String destination;
    private boolean isLoading;
    private final s<Boolean> isLoadingObservable;
    private final a<Boolean> isLoadingSubject;
    private final String metadata;
    private final TxMetadataKey metadataKey;
    private final RecipientType recipientType;
    private final String subtitle;
    private final String title;

    /* compiled from: SendDestinationViewInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J)\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo$Companion;", "", "", "username", "Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "fromUsername", "(Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "ensDomainName", "fromENS", "address", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "metadataKey", SendConfirmationArgs.metadataKey, "fromAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "coinbaseEmail", "fromCoinbaseEmail", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SendDestinationViewInfo fromAddress(String address, TxMetadataKey txMetadataKey, String str) {
            CharSequence h1;
            String str2;
            String str3;
            m.g(address, "address");
            if (txMetadataKey != null && str != null) {
                h1 = y.h1(str);
                if (!(h1.toString().length() == 0)) {
                    TxMetadataKey.Companion companion = TxMetadataKey.Companion;
                    if (m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoText(companion))) {
                        str2 = LocalizedStrings.INSTANCE.get(R.string.xlm_memo_text_label);
                    } else if (m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoId(companion))) {
                        str2 = LocalizedStrings.INSTANCE.get(R.string.xlm_memo_id_label);
                    } else if (m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoHash(companion))) {
                        str2 = LocalizedStrings.INSTANCE.get(R.string.xlm_memo_hash_label);
                    } else if (m.c(txMetadataKey, TxMetadataKey_StellarKt.getMemoReturn(companion))) {
                        str2 = LocalizedStrings.INSTANCE.get(R.string.xlm_memo_return_label);
                    } else {
                        str2 = m.c(txMetadataKey, TxMetadataKey_RippleKt.getDestinationTag(companion)) ? LocalizedStrings.INSTANCE.get(R.string.destination_tag_label) : null;
                    }
                    if (str2 != null) {
                        Locale US = Locale.US;
                        m.f(US, "US");
                        String upperCase = str2.toUpperCase(US);
                        m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                        if (upperCase != null) {
                            str3 = upperCase + TokenParser.SP + ((Object) str);
                            return new SendDestinationViewInfo(address, RecipientType.Address, address, str3, txMetadataKey, str);
                        }
                    }
                    str3 = null;
                    return new SendDestinationViewInfo(address, RecipientType.Address, address, str3, txMetadataKey, str);
                }
            }
            return new SendDestinationViewInfo(address, RecipientType.Address, address, null, txMetadataKey, str);
        }

        public final SendDestinationViewInfo fromCoinbaseEmail(String coinbaseEmail, TxMetadataKey txMetadataKey, String str) {
            m.g(coinbaseEmail, "coinbaseEmail");
            return new SendDestinationViewInfo(coinbaseEmail, RecipientType.Coinbase, LocalizedStrings.INSTANCE.get(R.string.coinbase), coinbaseEmail, txMetadataKey, str);
        }

        public final SendDestinationViewInfo fromENS(String ensDomainName) {
            m.g(ensDomainName, "ensDomainName");
            return new SendDestinationViewInfo(ensDomainName, RecipientType.ENS, ensDomainName, null, null, null);
        }

        public final SendDestinationViewInfo fromUsername(String username) {
            m.g(username, "username");
            return new SendDestinationViewInfo(username, RecipientType.User, m.o(Strings_CoreKt.getAt(Strings.INSTANCE), username), null, null, null);
        }
    }

    public SendDestinationViewInfo(String destination, RecipientType recipientType, String title, String str, TxMetadataKey txMetadataKey, String str2) {
        m.g(destination, "destination");
        m.g(recipientType, "recipientType");
        m.g(title, "title");
        this.destination = destination;
        this.recipientType = recipientType;
        this.title = title;
        this.subtitle = str;
        this.metadataKey = txMetadataKey;
        this.metadata = str2;
        a<Boolean> e2 = a.e(Boolean.FALSE);
        m.f(e2, "createDefault(false)");
        this.isLoadingSubject = e2;
        s<Boolean> hide = e2.hide();
        m.f(hide, "isLoadingSubject.hide()");
        this.isLoadingObservable = hide;
    }

    public static /* synthetic */ SendDestinationViewInfo copy$default(SendDestinationViewInfo sendDestinationViewInfo, String str, RecipientType recipientType, String str2, String str3, TxMetadataKey txMetadataKey, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sendDestinationViewInfo.destination;
        }
        if ((i2 & 2) != 0) {
            recipientType = sendDestinationViewInfo.recipientType;
        }
        RecipientType recipientType2 = recipientType;
        if ((i2 & 4) != 0) {
            str2 = sendDestinationViewInfo.title;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = sendDestinationViewInfo.subtitle;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            txMetadataKey = sendDestinationViewInfo.metadataKey;
        }
        TxMetadataKey txMetadataKey2 = txMetadataKey;
        if ((i2 & 32) != 0) {
            str4 = sendDestinationViewInfo.metadata;
        }
        return sendDestinationViewInfo.copy(str, recipientType2, str5, str6, txMetadataKey2, str4);
    }

    public final String component1() {
        return this.destination;
    }

    public final RecipientType component2() {
        return this.recipientType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.subtitle;
    }

    public final TxMetadataKey component5() {
        return this.metadataKey;
    }

    public final String component6() {
        return this.metadata;
    }

    public final SendDestinationViewInfo copy(String destination, RecipientType recipientType, String title, String str, TxMetadataKey txMetadataKey, String str2) {
        m.g(destination, "destination");
        m.g(recipientType, "recipientType");
        m.g(title, "title");
        return new SendDestinationViewInfo(destination, recipientType, title, str, txMetadataKey, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendDestinationViewInfo) {
            SendDestinationViewInfo sendDestinationViewInfo = (SendDestinationViewInfo) obj;
            return m.c(this.destination, sendDestinationViewInfo.destination) && this.recipientType == sendDestinationViewInfo.recipientType && m.c(this.title, sendDestinationViewInfo.title) && m.c(this.subtitle, sendDestinationViewInfo.subtitle) && m.c(this.metadataKey, sendDestinationViewInfo.metadataKey) && m.c(this.metadata, sendDestinationViewInfo.metadata);
        }
        return false;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final TxMetadataKey getMetadataKey() {
        return this.metadataKey;
    }

    public final RecipientType getRecipientType() {
        return this.recipientType;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.destination.hashCode() * 31) + this.recipientType.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.subtitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        TxMetadataKey txMetadataKey = this.metadataKey;
        int hashCode3 = (hashCode2 + (txMetadataKey == null ? 0 : txMetadataKey.hashCode())) * 31;
        String str2 = this.metadata;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final s<Boolean> isLoadingObservable() {
        return this.isLoadingObservable;
    }

    public final void setLoading(boolean z) {
        this.isLoadingSubject.onNext(Boolean.valueOf(z));
        this.isLoading = z;
    }

    public String toString() {
        return "SendDestinationViewInfo(destination=" + this.destination + ", recipientType=" + this.recipientType + ", title=" + this.title + ", subtitle=" + ((Object) this.subtitle) + ", metadataKey=" + this.metadataKey + ", metadata=" + ((Object) this.metadata) + ')';
    }
}