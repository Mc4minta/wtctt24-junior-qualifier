package com.coinbase.wallet.lending.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.lending.apis.LendAPI;
import com.coinbase.wallet.lending.interfaces.LendManaging;
import com.coinbase.wallet.lending.interfaces.TokenResult;
import com.coinbase.wallet.lending.models.LendInterest;
import com.coinbase.wallet.lending.models.LendProvider;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import java.util.List;
import kotlin.Metadata;

/* compiled from: RemoteLendService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0007J;\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/lending/repositories/RemoteLendService;", "Lcom/coinbase/wallet/lending/interfaces/LendManaging;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "address", "Lh/c/b0;", "Lcom/coinbase/wallet/lending/interfaces/TokenResult;", "getTokens", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;)Lh/c/b0;", "", "Lcom/coinbase/wallet/lending/models/LendInterest;", "getLifetimeInterestEarned", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "supplyERC20", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "supplyETH", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "withdrawERC20", "withdrawETH", "Lcom/coinbase/wallet/lending/apis/LendAPI;", "lendAPI", "Lcom/coinbase/wallet/lending/apis/LendAPI;", "", "providerId", "Ljava/lang/String;", "Lcom/coinbase/wallet/lending/models/LendProvider;", "getProvider", "()Lh/c/b0;", "provider", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/lending/apis/LendAPI;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RemoteLendService implements LendManaging {
    private final LendAPI lendAPI;
    private final String providerId;

    public RemoteLendService(String providerId, LendAPI lendAPI) {
        kotlin.jvm.internal.m.g(providerId, "providerId");
        kotlin.jvm.internal.m.g(lendAPI, "lendAPI");
        this.providerId = providerId;
        this.lendAPI = lendAPI;
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<List<LendInterest>> getLifetimeInterestEarned(WalletAddress address) {
        kotlin.jvm.internal.m.g(address, "address");
        return this.lendAPI.getLifetimeInterestEarned(this.providerId, address.getAddress());
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<LendProvider> getProvider() {
        return this.lendAPI.getProvider(this.providerId);
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<TokenResult> getTokens(WalletAddress address) {
        kotlin.jvm.internal.m.g(address, "address");
        return this.lendAPI.getSupportedTokens(this.providerId, address.getAddress());
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<List<EthereumUnsigned1559Tx>> supplyERC20(WalletAddress address, ContractAddress contractAddress, CurrencyCode currencyCode, TransferValue amount) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(amount, "amount");
        return this.lendAPI.supplyERC20(address, this.providerId, contractAddress, currencyCode, amount);
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<List<EthereumUnsigned1559Tx>> supplyETH(WalletAddress address, TransferValue amount) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(amount, "amount");
        return this.lendAPI.supplyETH(address, this.providerId, amount);
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<EthereumUnsigned1559Tx> withdrawERC20(WalletAddress address, ContractAddress contractAddress, CurrencyCode currencyCode, TransferValue amount) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(amount, "amount");
        return this.lendAPI.withdrawERC20(this.providerId, address, contractAddress, currencyCode, amount);
    }

    @Override // com.coinbase.wallet.lending.interfaces.LendManaging
    public b0<EthereumUnsigned1559Tx> withdrawETH(WalletAddress address, TransferValue amount) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(amount, "amount");
        return this.lendAPI.withdrawETH(this.providerId, address, amount);
    }
}