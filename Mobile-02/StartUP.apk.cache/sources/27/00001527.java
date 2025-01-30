package com.coinbase.wallet.compoundfinance.repositories;

import com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI;
import com.coinbase.wallet.compoundfinance.daos.CompoundTokenDAO;
import com.coinbase.wallet.compoundfinance.models.CompoundExchangeRateResult;
import com.coinbase.wallet.compoundfinance.models.CompoundToken;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.util.Optional;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlin.x;

/* compiled from: CompoundFinanceRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0019\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\b\u0010\u000bJ'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lh/c/b0;", "", "Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;", "supportedTokens", "()Lh/c/b0;", "getTokens", "", "contractAddresses", "(Ljava/util/List;)Ljava/util/List;", "Lcom/coinbase/wallet/compoundfinance/models/CompoundExchangeRateResult;", "getExchangeRates", "(Ljava/util/List;)Lh/c/b0;", "Lkotlin/x;", "start", "()V", "", "destroy", "", "tokens", "Ljava/util/Map;", "Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;", "compoundTokenDAO", "Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;", "Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;", "compoundFinanceAPI", "Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "<init>", "(Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompoundFinanceRepository implements Startable, Destroyable {
    private final CompoundFinanceAPI compoundFinanceAPI;
    private final CompoundTokenDAO compoundTokenDAO;
    private final h.c.k0.a disposeBag;
    private Map<String, CompoundToken> tokens;

    public CompoundFinanceRepository(CompoundFinanceAPI compoundFinanceAPI, CompoundTokenDAO compoundTokenDAO) {
        m.g(compoundFinanceAPI, "compoundFinanceAPI");
        m.g(compoundTokenDAO, "compoundTokenDAO");
        this.compoundFinanceAPI = compoundFinanceAPI;
        this.compoundTokenDAO = compoundTokenDAO;
        this.disposeBag = new h.c.k0.a();
        this.tokens = new LinkedHashMap();
    }

    public static /* synthetic */ x b(CompoundFinanceRepository compoundFinanceRepository, Optional optional) {
        return m823start$lambda13(compoundFinanceRepository, optional);
    }

    public static /* synthetic */ h0 c(CompoundFinanceRepository compoundFinanceRepository, List list) {
        return m822start$lambda11(compoundFinanceRepository, list);
    }

    public static /* synthetic */ List d(o oVar) {
        return m821getTokens$lambda7$lambda6(oVar);
    }

    public static /* synthetic */ h0 e(CompoundFinanceRepository compoundFinanceRepository, Map map) {
        return m820getTokens$lambda7(compoundFinanceRepository, map);
    }

    public static /* synthetic */ CompoundExchangeRateResult f(CompoundToken compoundToken, BigInteger bigInteger) {
        return m819getExchangeRates$lambda10$lambda9(compoundToken, bigInteger);
    }

    /* renamed from: getExchangeRates$lambda-10$lambda-9 */
    public static final CompoundExchangeRateResult m819getExchangeRates$lambda10$lambda9(CompoundToken token, BigInteger it) {
        m.g(token, "$token");
        m.g(it, "it");
        return new CompoundExchangeRateResult(token, it);
    }

    /* renamed from: getTokens$lambda-7 */
    public static final h0 m820getTokens$lambda7(CompoundFinanceRepository this$0, Map tokens) {
        int r;
        m.g(this$0, "this$0");
        m.g(tokens, "tokens");
        if (!tokens.isEmpty()) {
            Collection<CompoundToken> values = tokens.values();
            r = s.r(values, 10);
            ArrayList arrayList = new ArrayList(r);
            for (CompoundToken compoundToken : values) {
                arrayList.add(compoundToken);
            }
            return b0.just(arrayList);
        }
        return h.c.t0.e.a.a(this$0.compoundFinanceAPI.getTokens(), this$0.compoundFinanceAPI.getCryptoCurrencies()).map(new n() { // from class: com.coinbase.wallet.compoundfinance.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceRepository.d((o) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00aa A[SYNTHETIC] */
    /* renamed from: getTokens$lambda-7$lambda-6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List m821getTokens$lambda7$lambda6(kotlin.o r18) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository.m821getTokens$lambda7$lambda6(kotlin.o):java.util.List");
    }

    /* renamed from: start$lambda-11 */
    public static final h0 m822start$lambda11(CompoundFinanceRepository this$0, List it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.compoundTokenDAO.save(it);
    }

    /* renamed from: start$lambda-13 */
    public static final x m823start$lambda13(CompoundFinanceRepository this$0, Optional savedTokens) {
        int r;
        Map r2;
        m.g(this$0, "this$0");
        m.g(savedTokens, "savedTokens");
        List<CompoundToken> list = (List) savedTokens.toNullable();
        Map<String, CompoundToken> map = null;
        if (list != null) {
            r = s.r(list, 10);
            ArrayList arrayList = new ArrayList(r);
            for (CompoundToken compoundToken : list) {
                arrayList.add(u.a(compoundToken.getContractAddress(), compoundToken));
            }
            r2 = m0.r(arrayList);
            if (r2 != null) {
                map = m0.v(r2);
            }
        }
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        this$0.tokens = map;
        return x.a;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        this.disposeBag.d();
        b0<Boolean> just = b0.just(Boolean.TRUE);
        m.f(just, "just(true)");
        return just;
    }

    public final b0<List<CompoundExchangeRateResult>> getExchangeRates(List<String> contractAddresses) {
        int r;
        List g2;
        m.g(contractAddresses, "contractAddresses");
        List<CompoundToken> tokens = getTokens(contractAddresses);
        r = s.r(tokens, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final CompoundToken compoundToken : tokens) {
            arrayList.add(this.compoundFinanceAPI.getExchangeRate(compoundToken.getContractAddress()).map(new n() { // from class: com.coinbase.wallet.compoundfinance.repositories.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return CompoundFinanceRepository.f(CompoundToken.this, (BigInteger) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            b0<List<CompoundExchangeRateResult>> just = b0.just(g2);
            m.f(just, "just(emptyList())");
            return just;
        }
        b0<List<CompoundExchangeRateResult>> zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository$getExchangeRates$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                m.g(it, "it");
                if (it.length == 0) {
                    g3 = r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                int length = it.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = it[i2];
                    if (obj != null ? obj instanceof CompoundExchangeRateResult : true) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    public final b0<List<CompoundToken>> getTokens() {
        b0<List<CompoundToken>> flatMap = b0.just(this.tokens).flatMap(new n() { // from class: com.coinbase.wallet.compoundfinance.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceRepository.e(CompoundFinanceRepository.this, (Map) obj);
            }
        });
        m.f(flatMap, "just(tokens)\n        .flatMap { tokens ->\n            if (tokens.isNotEmpty()) {\n                return@flatMap Single.just(tokens.values.map { it })\n            }\n\n            // CompoundToken contains composed data from 2 API responses:\n            // token list from compound + all crypto currencies\n            // 2nd one is used to get decimals for underlying ERC20 and ETH for further use during\n            // exchange rate calculations\n            Singles.zip(\n                compoundFinanceAPI.getTokens(),\n                compoundFinanceAPI.getCryptoCurrencies()\n            ).map { (cTokensInfo, allTokens) ->\n                val contractAddressToDecimalsMap = allTokens\n                    .filter { token -> token.contractAddress != null }\n                    .map { token -> token.contractAddress to token.decimals }\n                    .toMap()\n                val ethDecimals = allTokens.first { it.code == \"ETH\" && it.contractAddress == null }.decimals\n\n                cTokensInfo.mapNotNull { cTokenInfo ->\n                    var underlyingDecimals = contractAddressToDecimalsMap[cTokenInfo.underlyingContractAddress]\n                    if (underlyingDecimals == null) {\n                        if (cTokenInfo.underlyingCode == \"ETH\" &&\n                            cTokenInfo.underlyingContractAddress == null) {\n                            underlyingDecimals = ethDecimals\n                        } else {\n                            return@mapNotNull null\n                        }\n                    }\n\n                    CompoundToken(\n                        name = cTokenInfo.name,\n                        code = CurrencyCode(cTokenInfo.code),\n                        contractAddress = cTokenInfo.contractAddress,\n                        underlyingCode = CurrencyCode(cTokenInfo.underlyingCode),\n                        underlyingDecimals = underlyingDecimals,\n                        underlyingContractAddress = cTokenInfo.underlyingContractAddress\n                    )\n                }\n            }\n        }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = getTokens().flatMap(new n() { // from class: com.coinbase.wallet.compoundfinance.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceRepository.c(CompoundFinanceRepository.this, (List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.compoundfinance.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceRepository.b(CompoundFinanceRepository.this, (Optional) obj);
            }
        }).subscribe();
        m.f(subscribe, "getTokens()\n            .flatMap { compoundTokenDAO.save(it) }\n            .map { savedTokens ->\n                tokens = savedTokens.toNullable()?.map { savedToken ->\n                    savedToken.contractAddress to savedToken\n                }\n                ?.toMap()\n                ?.toMutableMap()\n                ?: mutableMapOf()\n            }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }

    public final b0<List<CompoundToken>> supportedTokens() {
        int r;
        Collection<CompoundToken> values = this.tokens.values();
        r = s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CompoundToken compoundToken : values) {
            arrayList.add(compoundToken);
        }
        b0<List<CompoundToken>> just = b0.just(arrayList);
        m.f(just, "just(tokens.values.map { it })");
        return just;
    }

    public final List<CompoundToken> getTokens(List<String> contractAddresses) {
        m.g(contractAddresses, "contractAddresses");
        ArrayList arrayList = new ArrayList();
        for (String str : contractAddresses) {
            CompoundToken compoundToken = this.tokens.get(str);
            if (compoundToken != null) {
                arrayList.add(compoundToken);
            }
        }
        return arrayList;
    }
}