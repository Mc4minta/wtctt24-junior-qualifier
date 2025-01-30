package com.coinbase.walletlink.repositories;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.walletlink.dtos.RequestEthereumAccountsParams;
import com.coinbase.walletlink.dtos.ServerRequestDTO;
import com.coinbase.walletlink.dtos.Web3RequestDTO;
import com.coinbase.walletlink.models.Dapp;
import com.coinbase.walletlink.models.HostRequestId;
import h.c.m0.n;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: LinkRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a:\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004 \u0007*\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"T", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/walletlink/models/Dapp;", "dapp", "Lkotlin/o;", "Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "Lcom/coinbase/walletlink/models/HostRequestId;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)Lcom/coinbase/wallet/core/util/Optional;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LinkRepository$hostRequestId$1<T, R> implements n {
    final /* synthetic */ ServerRequestDTO $serverRequest;
    final /* synthetic */ URL $url;
    final /* synthetic */ Web3RequestDTO<T> $web3Request;
    final /* synthetic */ LinkRepository this$0;

    public LinkRepository$hostRequestId$1(Web3RequestDTO<T> web3RequestDTO, LinkRepository linkRepository, ServerRequestDTO serverRequestDTO, URL url) {
        this.$web3Request = web3RequestDTO;
        this.this$0 = linkRepository;
        this.$serverRequest = serverRequestDTO;
        this.$url = url;
    }

    @Override // h.c.m0.n
    public final Optional<o<Web3RequestDTO<T>, HostRequestId>> apply(Optional<Dapp> dapp) {
        m.g(dapp, "dapp");
        Dapp nullable = dapp.toNullable();
        URL logoURL = nullable == null ? null : nullable.getLogoURL();
        Dapp nullable2 = dapp.toNullable();
        String name = nullable2 == null ? null : nullable2.getName();
        T params = this.$web3Request.getRequest().getParams();
        RequestEthereumAccountsParams requestEthereumAccountsParams = params instanceof RequestEthereumAccountsParams ? (RequestEthereumAccountsParams) params : null;
        if (requestEthereumAccountsParams != null) {
            name = requestEthereumAccountsParams.getAppName();
            logoURL = this.this$0.getAppLogoUrl(requestEthereumAccountsParams.getAppLogoUrl(), this.$web3Request.getOrigin());
        }
        return new Optional<>(new o(this.$web3Request, new HostRequestId(this.$web3Request.getId(), this.$serverRequest.getSessionId(), this.$serverRequest.getEventId(), this.$url, this.$web3Request.getOrigin(), logoURL, name, this.$web3Request.getRequest().getMethod())));
    }
}