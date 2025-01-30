package com.coinbase.wallet.txhistory.models;

import com.coinbase.wallet.blockchains.models.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: TxHistoryDetail.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jz\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0016\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b\u0016\u0010\bR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\fR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u0010\u0013R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b3\u0010\u0004¨\u00066"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component5", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component6", "component7", "component8", "component9", "Lcom/coinbase/wallet/blockchains/models/Network;", "component10", "()Lcom/coinbase/wallet/blockchains/models/Network;", MessageBundle.TITLE_ENTRY, "destination", "isDestinationHighLegibilityFontNeeded", "destinationDetails", "recipientType", "primaryAmount", "secondaryAmount", "viewOnButtonTitle", "txHash", "network", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getSecondaryAmount", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "getDestination", "getTxHash", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "getViewOnButtonTitle", "getDestinationDetails", "getTitle", "getPrimaryAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDetail {
    private final String destination;
    private final String destinationDetails;
    private final boolean isDestinationHighLegibilityFontNeeded;
    private final Network network;
    private final String primaryAmount;
    private final RecipientType recipientType;
    private final String secondaryAmount;
    private final String title;
    private final String txHash;
    private final String viewOnButtonTitle;

    public TxHistoryDetail(String title, String destination, boolean z, String destinationDetails, RecipientType recipientType, String primaryAmount, String str, String str2, String str3, Network network) {
        m.g(title, "title");
        m.g(destination, "destination");
        m.g(destinationDetails, "destinationDetails");
        m.g(recipientType, "recipientType");
        m.g(primaryAmount, "primaryAmount");
        m.g(network, "network");
        this.title = title;
        this.destination = destination;
        this.isDestinationHighLegibilityFontNeeded = z;
        this.destinationDetails = destinationDetails;
        this.recipientType = recipientType;
        this.primaryAmount = primaryAmount;
        this.secondaryAmount = str;
        this.viewOnButtonTitle = str2;
        this.txHash = str3;
        this.network = network;
    }

    public final String component1() {
        return this.title;
    }

    public final Network component10() {
        return this.network;
    }

    public final String component2() {
        return this.destination;
    }

    public final boolean component3() {
        return this.isDestinationHighLegibilityFontNeeded;
    }

    public final String component4() {
        return this.destinationDetails;
    }

    public final RecipientType component5() {
        return this.recipientType;
    }

    public final String component6() {
        return this.primaryAmount;
    }

    public final String component7() {
        return this.secondaryAmount;
    }

    public final String component8() {
        return this.viewOnButtonTitle;
    }

    public final String component9() {
        return this.txHash;
    }

    public final TxHistoryDetail copy(String title, String destination, boolean z, String destinationDetails, RecipientType recipientType, String primaryAmount, String str, String str2, String str3, Network network) {
        m.g(title, "title");
        m.g(destination, "destination");
        m.g(destinationDetails, "destinationDetails");
        m.g(recipientType, "recipientType");
        m.g(primaryAmount, "primaryAmount");
        m.g(network, "network");
        return new TxHistoryDetail(title, destination, z, destinationDetails, recipientType, primaryAmount, str, str2, str3, network);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TxHistoryDetail) {
            TxHistoryDetail txHistoryDetail = (TxHistoryDetail) obj;
            return m.c(this.title, txHistoryDetail.title) && m.c(this.destination, txHistoryDetail.destination) && this.isDestinationHighLegibilityFontNeeded == txHistoryDetail.isDestinationHighLegibilityFontNeeded && m.c(this.destinationDetails, txHistoryDetail.destinationDetails) && this.recipientType == txHistoryDetail.recipientType && m.c(this.primaryAmount, txHistoryDetail.primaryAmount) && m.c(this.secondaryAmount, txHistoryDetail.secondaryAmount) && m.c(this.viewOnButtonTitle, txHistoryDetail.viewOnButtonTitle) && m.c(this.txHash, txHistoryDetail.txHash) && m.c(this.network, txHistoryDetail.network);
        }
        return false;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getDestinationDetails() {
        return this.destinationDetails;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final String getPrimaryAmount() {
        return this.primaryAmount;
    }

    public final RecipientType getRecipientType() {
        return this.recipientType;
    }

    public final String getSecondaryAmount() {
        return this.secondaryAmount;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTxHash() {
        return this.txHash;
    }

    public final String getViewOnButtonTitle() {
        return this.viewOnButtonTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.destination.hashCode()) * 31;
        boolean z = this.isDestinationHighLegibilityFontNeeded;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode2 = (((((((hashCode + i2) * 31) + this.destinationDetails.hashCode()) * 31) + this.recipientType.hashCode()) * 31) + this.primaryAmount.hashCode()) * 31;
        String str = this.secondaryAmount;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.viewOnButtonTitle;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.txHash;
        return ((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.network.hashCode();
    }

    public final boolean isDestinationHighLegibilityFontNeeded() {
        return this.isDestinationHighLegibilityFontNeeded;
    }

    public String toString() {
        return "TxHistoryDetail(title=" + this.title + ", destination=" + this.destination + ", isDestinationHighLegibilityFontNeeded=" + this.isDestinationHighLegibilityFontNeeded + ", destinationDetails=" + this.destinationDetails + ", recipientType=" + this.recipientType + ", primaryAmount=" + this.primaryAmount + ", secondaryAmount=" + ((Object) this.secondaryAmount) + ", viewOnButtonTitle=" + ((Object) this.viewOnButtonTitle) + ", txHash=" + ((Object) this.txHash) + ", network=" + this.network + ')';
    }
}