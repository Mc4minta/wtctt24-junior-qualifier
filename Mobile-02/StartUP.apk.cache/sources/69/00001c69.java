package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IETHWalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/wallet/ethereum/interfaces/ERC20Owning;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Address;", "getAddresses", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "address", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "(Ljava/lang/String;I)Lh/c/b0;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface IETHWalletRepository extends WalletManaging, ERC20Owning {
    h.c.b0<List<Address>> getAddresses(Network network);

    h.c.b0<Optional<Wallet>> getWallet(String str, int i2);
}