package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.ethereum.models.ERC20;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;

/* compiled from: IERC20Fetching.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "chainID", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/ERC20;", "getERC20", "(Ljava/lang/String;ILcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/b0;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface IERC20Fetching {
    h.c.b0<ERC20> getERC20(String str, int i2, Blockchain blockchain);
}