package com.coinbase.wallet.ethereum.apis;

import com.coinbase.wallet.core.extensions.BigIntegers;
import com.coinbase.wallet.core.extensions.BigIntegers_CoreKt;
import com.coinbase.wallet.ethereum.dtos.ETHCallDTO;
import com.coinbase.wallet.ethereum.exceptions.ERC20ContractException;
import com.coinbase.wallet.ethereum.extensions.HTTP_EthereumKt;
import com.coinbase.wallet.ethereum.models.ETHABIEncodedAddress;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;

/* compiled from: ERC20ContractAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/ethereum/apis/ERC20ContractAPI;", "", "", "ownerAddress", "spenderAddress", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "chainID", "Lh/c/b0;", "Ljava/math/BigInteger;", "getAllowance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lh/c/b0;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20ContractAPI {
    public static /* synthetic */ BigInteger a(ETHCallDTO eTHCallDTO) {
        return m1089getAllowance$lambda1(eTHCallDTO);
    }

    /* renamed from: getAllowance$lambda-1 */
    public static final BigInteger m1089getAllowance$lambda1(ETHCallDTO response) {
        m.g(response, "response");
        BigInteger fromHex = BigIntegers_CoreKt.fromHex(BigIntegers.INSTANCE, response.getResult());
        if (fromHex != null) {
            return fromHex;
        }
        throw ERC20ContractException.UnableToGetAllowance.INSTANCE;
    }

    public final b0<BigInteger> getAllowance(String ownerAddress, String spenderAddress, String contractAddress, int i2) {
        List<String> j2;
        int r;
        b0 ethCall;
        m.g(ownerAddress, "ownerAddress");
        m.g(spenderAddress, "spenderAddress");
        m.g(contractAddress, "contractAddress");
        HTTP http = HTTP.INSTANCE;
        j2 = r.j(ownerAddress, spenderAddress);
        r = s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str : j2) {
            arrayList.add(new ETHABIEncodedAddress(str));
        }
        ethCall = HTTP_EthereumKt.ethCall(http, "allowance(address,address)", (r13 & 2) != 0 ? null : arrayList, contractAddress, i2, (r13 & 16) != 0 ? null : null);
        b0<BigInteger> map = ethCall.map(new n() { // from class: com.coinbase.wallet.ethereum.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20ContractAPI.a((ETHCallDTO) obj);
            }
        });
        m.f(map, "HTTP\n            .ethCall(\n                method = \"allowance(address,address)\",\n                parameters = listOf(ownerAddress, spenderAddress).map { ETHABIEncodedAddress(it) },\n                to = contractAddress,\n                chainID = chainID\n            )\n            .map { response ->\n                BigIntegers.fromHex(response.result) ?: throw ERC20ContractException.UnableToGetAllowance\n            }");
        return map;
    }
}