package com.coinbase.wallet.swap.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SwapAssetStats.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B3\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b)\u0010*B+\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b)\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\rR\u001c\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\nR\u001c\u0010\u0015\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u0010¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAssetStats;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component2", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component3", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "component4", "()Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "", "component5", "()I", "id", RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "selectedCount", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;I)Lcom/coinbase/wallet/swap/models/SwapAssetStats;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "getContractAddress", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "I", "getSelectedCount", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;I)V", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;I)V", "Companion", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAssetStats implements DatabaseModelObject {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final ContractAddress contractAddress;
    private final CurrencyCode currencyCode;
    private final String id;
    private final int selectedCount;

    /* compiled from: SwapAssetStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAssetStats$Companion;", "", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "generateID$swap_release", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;)Ljava/lang/String;", "generateID", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String generateID$swap_release(Blockchain blockchain, CurrencyCode currencyCode, ContractAddress contractAddress) {
            List l2;
            String h0;
            m.g(blockchain, "blockchain");
            m.g(currencyCode, "currencyCode");
            String[] strArr = new String[3];
            strArr[0] = blockchain.getRawValue();
            strArr[1] = currencyCode.getRawValue();
            strArr[2] = contractAddress == null ? null : contractAddress.getRawValue();
            l2 = r.l(strArr);
            h0 = z.h0(l2, "/", null, null, 0, null, null, 62, null);
            return h0;
        }
    }

    public SwapAssetStats(String id, Blockchain blockchain, CurrencyCode currencyCode, ContractAddress contractAddress, int i2) {
        m.g(id, "id");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        this.id = id;
        this.blockchain = blockchain;
        this.currencyCode = currencyCode;
        this.contractAddress = contractAddress;
        this.selectedCount = i2;
    }

    public static /* synthetic */ SwapAssetStats copy$default(SwapAssetStats swapAssetStats, String str, Blockchain blockchain, CurrencyCode currencyCode, ContractAddress contractAddress, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = swapAssetStats.getId();
        }
        if ((i3 & 2) != 0) {
            blockchain = swapAssetStats.blockchain;
        }
        Blockchain blockchain2 = blockchain;
        if ((i3 & 4) != 0) {
            currencyCode = swapAssetStats.currencyCode;
        }
        CurrencyCode currencyCode2 = currencyCode;
        if ((i3 & 8) != 0) {
            contractAddress = swapAssetStats.contractAddress;
        }
        ContractAddress contractAddress2 = contractAddress;
        if ((i3 & 16) != 0) {
            i2 = swapAssetStats.selectedCount;
        }
        return swapAssetStats.copy(str, blockchain2, currencyCode2, contractAddress2, i2);
    }

    public final String component1() {
        return getId();
    }

    public final Blockchain component2() {
        return this.blockchain;
    }

    public final CurrencyCode component3() {
        return this.currencyCode;
    }

    public final ContractAddress component4() {
        return this.contractAddress;
    }

    public final int component5() {
        return this.selectedCount;
    }

    public final SwapAssetStats copy(String id, Blockchain blockchain, CurrencyCode currencyCode, ContractAddress contractAddress, int i2) {
        m.g(id, "id");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        return new SwapAssetStats(id, blockchain, currencyCode, contractAddress, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapAssetStats) {
            SwapAssetStats swapAssetStats = (SwapAssetStats) obj;
            return m.c(getId(), swapAssetStats.getId()) && m.c(this.blockchain, swapAssetStats.blockchain) && m.c(this.currencyCode, swapAssetStats.currencyCode) && m.c(this.contractAddress, swapAssetStats.contractAddress) && this.selectedCount == swapAssetStats.selectedCount;
        }
        return false;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final ContractAddress getContractAddress() {
        return this.contractAddress;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final int getSelectedCount() {
        return this.selectedCount;
    }

    public int hashCode() {
        int hashCode = ((((getId().hashCode() * 31) + this.blockchain.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        ContractAddress contractAddress = this.contractAddress;
        return ((hashCode + (contractAddress == null ? 0 : contractAddress.hashCode())) * 31) + this.selectedCount;
    }

    public String toString() {
        return "SwapAssetStats(id=" + getId() + ", blockchain=" + this.blockchain + ", currencyCode=" + this.currencyCode + ", contractAddress=" + this.contractAddress + ", selectedCount=" + this.selectedCount + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwapAssetStats(Blockchain blockchain, CurrencyCode currencyCode, ContractAddress contractAddress, int i2) {
        this(Companion.generateID$swap_release(blockchain, currencyCode, contractAddress), blockchain, currencyCode, contractAddress, i2);
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
    }
}