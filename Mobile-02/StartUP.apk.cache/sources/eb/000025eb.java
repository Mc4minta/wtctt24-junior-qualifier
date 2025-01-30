package com.coinbase.wallet.routing.models;

import android.net.Uri;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.swap.models.SwapAsset;
import h.c.b0;
import h.c.m0.n;
import h.c.t0.f;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: SwapRouteAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/routing/models/SwapRouteAction;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "Lh/c/b0;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "execute", "()Lh/c/b0;", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "swapRepository", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "getSwapRepository", "()Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "<init>", "(Landroid/net/Uri;Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapRouteAction implements RouteAction {
    private final ISwapRepository swapRepository;
    private final Uri uri;

    public SwapRouteAction(Uri uri, ISwapRepository swapRepository) {
        m.g(uri, "uri");
        m.g(swapRepository, "swapRepository");
        this.uri = uri;
        this.swapRepository = swapRepository;
    }

    public static /* synthetic */ SwapAsset a(ContractAddress contractAddress, o oVar) {
        return m1685execute$lambda2(contractAddress, oVar);
    }

    public static /* synthetic */ DeeplinkDestination b(SwapAsset swapAsset) {
        return m1686execute$lambda3(swapAsset);
    }

    /* renamed from: execute$lambda-2 */
    public static final SwapAsset m1685execute$lambda2(ContractAddress contractAddress, o dstr$assets$_u24__u24) {
        boolean z;
        m.g(dstr$assets$_u24__u24, "$dstr$assets$_u24__u24");
        for (SwapAsset swapAsset : (List) dstr$assets$_u24__u24.a()) {
            if (m.c(swapAsset.getContractAddress(), contractAddress) && swapAsset.getSwappable()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return swapAsset;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* renamed from: execute$lambda-3 */
    public static final DeeplinkDestination m1686execute$lambda3(SwapAsset swapAsset) {
        m.g(swapAsset, "swapAsset");
        return new SwapDeepLinkDestination(swapAsset);
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public b0<DeeplinkDestination> execute() {
        String queryParameter = getUri().getQueryParameter(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        final ContractAddress contractAddress = null;
        if (queryParameter != null) {
            Locale US = Locale.US;
            m.f(US, "US");
            String lowerCase = queryParameter.toLowerCase(US);
            m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase != null) {
                contractAddress = new ContractAddress(lowerCase);
            }
        }
        String queryParameter2 = getUri().getQueryParameter(RouteActionKey.RouteActionKeys.CHAIN_ID);
        if (queryParameter2 != null) {
            Locale US2 = Locale.US;
            m.f(US2, "US");
            m.f(queryParameter2.toLowerCase(US2), "(this as java.lang.String).toLowerCase(locale)");
        }
        String queryParameter3 = getUri().getQueryParameter(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        if (queryParameter3 != null) {
            Locale US3 = Locale.US;
            m.f(US3, "US");
            m.f(queryParameter3.toLowerCase(US3), "(this as java.lang.String).toLowerCase(locale)");
        }
        b0<DeeplinkDestination> map = f.a(Observable_CoreKt.takeSingle(this.swapRepository.getSwapAssetListObservable()), this.swapRepository.refresh(true)).map(new n() { // from class: com.coinbase.wallet.routing.models.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRouteAction.a(ContractAddress.this, (o) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.routing.models.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapRouteAction.b((SwapAsset) obj);
            }
        });
        m.f(map, "swapRepository.swapAssetListObservable.takeSingle()\n            .zipWith(swapRepository.refresh(true))\n            .map { (assets, _) ->\n                assets.first { it.contractAddress == contractAddress && it.swappable }\n            }.map { swapAsset ->\n                SwapDeepLinkDestination(swapAsset)\n            }");
        return map;
    }

    public final ISwapRepository getSwapRepository() {
        return this.swapRepository;
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public Uri getUri() {
        return this.uri;
    }
}