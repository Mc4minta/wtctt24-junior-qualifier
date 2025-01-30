package com.coinbase.wallet.lending.interfaces;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.lending.models.LendInterest;
import com.coinbase.wallet.lending.models.LendToken;
import h.c.b0;
import h.c.s;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ILendRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/RefreshIntervalCustomizable;", "Lh/c/s;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "observeTokens", "()Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "address", "Lh/c/b0;", "Lcom/coinbase/wallet/lending/models/LendInterest;", "getLifetimeInterestEarned", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;)Lh/c/b0;", ApiConstants.TOKEN, "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "supply", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "withdraw", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ILendRepository extends Startable, Refreshable, RefreshIntervalCustomizable {
    b0<List<LendInterest>> getLifetimeInterestEarned(WalletAddress walletAddress);

    s<List<LendToken>> observeTokens();

    b0<List<EthereumUnsigned1559Tx>> supply(WalletAddress walletAddress, LendToken lendToken, TransferValue transferValue);

    b0<EthereumUnsigned1559Tx> withdraw(WalletAddress walletAddress, LendToken lendToken, TransferValue transferValue);
}