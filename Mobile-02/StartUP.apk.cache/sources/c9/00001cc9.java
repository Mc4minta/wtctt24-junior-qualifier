package com.coinbase.wallet.ethereum.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.ERC20Info;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.ethereum.interfaces.IERC20Fetching;
import com.coinbase.wallet.ethereum.models.ERC20;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;

/* compiled from: ERC20Fetching.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/ethereum/repositories/ERC20Fetching;", "Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "chainID", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/ERC20;", "getERC20", "(Ljava/lang/String;ILcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/b0;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20Fetching implements IERC20Fetching {
    private final CipherCoreInterface cipherCore;

    public ERC20Fetching(CipherCoreInterface cipherCore) {
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        this.cipherCore = cipherCore;
    }

    public static /* synthetic */ ERC20 a(String str, int i2, Blockchain blockchain, ERC20Info eRC20Info) {
        return m1164getERC20$lambda0(str, i2, blockchain, eRC20Info);
    }

    /* renamed from: getERC20$lambda-0 */
    public static final ERC20 m1164getERC20$lambda0(String contractAddress, int i2, Blockchain blockchain, ERC20Info erc20Info) {
        kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(erc20Info, "erc20Info");
        return new ERC20(erc20Info.getName(), erc20Info.getDecimals(), contractAddress, i2, new CurrencyCode(erc20Info.getSymbol()), blockchain, null);
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.IERC20Fetching
    public h.c.b0<ERC20> getERC20(final String contractAddress, final int i2, final Blockchain blockchain) {
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        h.c.b0 map = this.cipherCore.getERC20Info(contractAddress, i2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20Fetching.a(contractAddress, i2, blockchain, (ERC20Info) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherCore.getERC20Info(contractAddress, chainID)\n            .map { erc20Info ->\n                ERC20(\n                    name = erc20Info.name,\n                    currencyCode = CurrencyCode(erc20Info.symbol),\n                    decimals = erc20Info.decimals,\n                    contractAddress = contractAddress,\n                    chainId = chainID,\n                    blockchain = blockchain,\n                    imageURL = null\n                )\n            }");
        return map;
    }
}