package com.coinbase.wallet.ethereum.apis;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.dtos.ERC20IconDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20BalancesDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20BalancesResult;
import com.coinbase.wallet.ethereum.dtos.GetERC20IconsDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20IconsResultDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20InfoDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20InfoResultDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20TokensOwnedByAddressDTO;
import com.coinbase.wallet.ethereum.dtos.GetERC20TokensOwnedByAddressResultDTO;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.m0.n;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.jvm.internal.m;

/* compiled from: ERC20TokenAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\tJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\tJ)\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "", "", "address", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "", "getERC20TokensOwnedByAddress", "(Ljava/lang/String;I)Lh/c/b0;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lcom/coinbase/wallet/core/util/Optional;", "getTokenIcon", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20InfoDTO;", "getERC20Info", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesDTO;", "getERC20Balances", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenHTTP;", "api", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenHTTP;", "<init>", "(Lcom/coinbase/wallet/ethereum/apis/ERC20TokenHTTP;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20TokenAPI {
    private final ERC20TokenHTTP api;

    public ERC20TokenAPI(ERC20TokenHTTP api) {
        m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ List a(GetERC20BalancesResult getERC20BalancesResult) {
        return m1090getERC20Balances$lambda4(getERC20BalancesResult);
    }

    public static /* synthetic */ List b(GetERC20TokensOwnedByAddressResultDTO getERC20TokensOwnedByAddressResultDTO) {
        return m1092getERC20TokensOwnedByAddress$lambda0(getERC20TokensOwnedByAddressResultDTO);
    }

    public static /* synthetic */ Optional c(String str, GetERC20IconsResultDTO getERC20IconsResultDTO) {
        return m1093getTokenIcon$lambda2(str, getERC20IconsResultDTO);
    }

    public static /* synthetic */ GetERC20InfoDTO d(GetERC20InfoResultDTO getERC20InfoResultDTO) {
        return m1091getERC20Info$lambda3(getERC20InfoResultDTO);
    }

    /* renamed from: getERC20Balances$lambda-4 */
    public static final List m1090getERC20Balances$lambda4(GetERC20BalancesResult it) {
        m.g(it, "it");
        return it.getResult().getBalances();
    }

    /* renamed from: getERC20Info$lambda-3 */
    public static final GetERC20InfoDTO m1091getERC20Info$lambda3(GetERC20InfoResultDTO it) {
        m.g(it, "it");
        return it.getResult();
    }

    /* renamed from: getERC20TokensOwnedByAddress$lambda-0 */
    public static final List m1092getERC20TokensOwnedByAddress$lambda0(GetERC20TokensOwnedByAddressResultDTO it) {
        m.g(it, "it");
        GetERC20TokensOwnedByAddressDTO result = it.getResult();
        List<String> contractAddresses = result == null ? null : result.getContractAddresses();
        if (contractAddresses != null) {
            return contractAddresses;
        }
        throw EthereumException.UnableToGetERC20Details.INSTANCE;
    }

    /* renamed from: getTokenIcon$lambda-2 */
    public static final Optional m1093getTokenIcon$lambda2(String contractAddress, GetERC20IconsResultDTO response) {
        Map<String, List<ERC20IconDTO>> icons;
        List<ERC20IconDTO> list;
        Object next;
        m.g(contractAddress, "$contractAddress");
        m.g(response, "response");
        GetERC20IconsDTO result = response.getResult();
        String str = null;
        if (result != null && (icons = result.getIcons()) != null && (list = icons.get(contractAddress)) != null) {
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int width = ((ERC20IconDTO) next).getWidth();
                    do {
                        Object next2 = it.next();
                        int width2 = ((ERC20IconDTO) next2).getWidth();
                        if (width < width2) {
                            next = next2;
                            width = width2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            ERC20IconDTO eRC20IconDTO = (ERC20IconDTO) next;
            if (eRC20IconDTO != null) {
                str = eRC20IconDTO.getUrl();
            }
        }
        return OptionalKt.toOptional(str);
    }

    public final b0<List<GetERC20BalancesDTO>> getERC20Balances(String address, int i2) {
        m.g(address, "address");
        ERC20TokenHTTP eRC20TokenHTTP = this.api;
        Locale US = Locale.US;
        m.f(US, "US");
        String lowerCase = address.toLowerCase(US);
        m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        b0 map = eRC20TokenHTTP.getERC20Balances(lowerCase, i2).map(new n() { // from class: com.coinbase.wallet.ethereum.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20TokenAPI.a((GetERC20BalancesResult) obj);
            }
        });
        m.f(map, "api.getERC20Balances(address.toLowerCase(Locale.US), chainId)\n        .map { it.result.balances }");
        return map;
    }

    public final b0<GetERC20InfoDTO> getERC20Info(String contractAddress, int i2) {
        m.g(contractAddress, "contractAddress");
        b0 map = this.api.getERC20Info(contractAddress, i2).map(new n() { // from class: com.coinbase.wallet.ethereum.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20TokenAPI.d((GetERC20InfoResultDTO) obj);
            }
        });
        m.f(map, "api.getERC20Info(contractAddress, chainId)\n        .map { it.result }");
        return map;
    }

    public final b0<List<String>> getERC20TokensOwnedByAddress(String address, int i2) {
        m.g(address, "address");
        ERC20TokenHTTP eRC20TokenHTTP = this.api;
        Locale US = Locale.US;
        m.f(US, "US");
        String lowerCase = address.toLowerCase(US);
        m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        b0 map = eRC20TokenHTTP.getERC20TokensOwnedByAddress(lowerCase, i2).map(new n() { // from class: com.coinbase.wallet.ethereum.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20TokenAPI.b((GetERC20TokensOwnedByAddressResultDTO) obj);
            }
        });
        m.f(map, "api.getERC20TokensOwnedByAddress(address.toLowerCase(Locale.US), chainId)\n        .map { it.result?.contractAddresses ?: throw EthereumException.UnableToGetERC20Details }");
        return map;
    }

    public final b0<Optional<String>> getTokenIcon(final String contractAddress, int i2) {
        List<String> b2;
        m.g(contractAddress, "contractAddress");
        ERC20TokenHTTP eRC20TokenHTTP = this.api;
        b2 = q.b(contractAddress);
        b0 map = eRC20TokenHTTP.getTokenIcon(b2, i2).map(new n() { // from class: com.coinbase.wallet.ethereum.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20TokenAPI.c(contractAddress, (GetERC20IconsResultDTO) obj);
            }
        });
        m.f(map, "api.getTokenIcon(listOf(contractAddress), chainId)\n        .map { response -> response.result?.icons?.get(contractAddress)?.maxByOrNull { it.width }?.url.toOptional() }");
        return map;
    }
}