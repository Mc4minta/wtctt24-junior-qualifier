package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;

/* compiled from: ERC20Owning.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/ERC20Owning;", "", "", "address", "", "index", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lkotlin/x;", "takeOwnership", "(Ljava/lang/String;ILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ERC20Owning {
    h.c.b0<kotlin.x> takeOwnership(String str, int i2, String str2, Network network);
}