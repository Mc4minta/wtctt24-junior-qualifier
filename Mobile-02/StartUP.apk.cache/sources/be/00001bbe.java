package com.coinbase.wallet.ethereum.apis;

import com.coinbase.wallet.ethereum.dtos.GetERC20BalancesResult;
import com.coinbase.wallet.ethereum.dtos.GetERC20IconsResultDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20InfoResultDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20TokensOwnedByAddressResultDTO;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import java.util.List;
import kotlin.Metadata;
import retrofit2.z.t;

/* compiled from: ERC20TokenAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ/\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0011\u0010\tJ)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/ethereum/apis/ERC20TokenHTTP;", "", "", "address", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressResultDTO;", "getERC20TokensOwnedByAddress", "(Ljava/lang/String;I)Lh/c/b0;", "", "contractAddresses", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsResultDTO;", "getTokenIcon", "(Ljava/util/List;I)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lcom/coinbase/wallet/ethereum/dtos/GetERC20InfoResultDTO;", "getERC20Info", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResult;", "getERC20Balances", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ERC20TokenHTTP {
    @retrofit2.z.f("/rpc/v1/getBalances")
    b0<GetERC20BalancesResult> getERC20Balances(@t("address") String str, @t("chainId") int i2);

    @retrofit2.z.f("/rpc/v2/getERC20Info")
    b0<GetERC20InfoResultDTO> getERC20Info(@t("contractAddress") String str, @t("chainId") int i2);

    @retrofit2.z.f("/rpc/v2/getERC20TokensOwnedByAddress")
    b0<GetERC20TokensOwnedByAddressResultDTO> getERC20TokensOwnedByAddress(@t("address") String str, @t("chainId") int i2);

    @retrofit2.z.f("/rpc/v2/getERC20Icons")
    b0<GetERC20IconsResultDTO> getTokenIcon(@t("contractAddresses") List<String> list, @t("chainId") int i2);
}