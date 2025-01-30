package com.coinbase.wallet.features.walletlink.extensions;

import com.coinbase.wallet.features.signer.models.SignatureRequest;
import com.coinbase.walletlink.models.HostRequest;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;

/* compiled from: HostRequest+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "asSignatureRequest", "(Lcom/coinbase/walletlink/models/HostRequest;)Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HostRequest_WalletLinkKt {
    public static final SignatureRequest asSignatureRequest(HostRequest hostRequest) {
        m.g(hostRequest, "<this>");
        String uuid = UUID.randomUUID().toString();
        m.f(uuid, "randomUUID().toString()");
        if (hostRequest instanceof HostRequest.SignMessage) {
            HostRequest.SignMessage signMessage = (HostRequest.SignMessage) hostRequest;
            return new SignatureRequest.SignMessage(uuid, hostRequest.getHostRequestId(), signMessage.getAddress(), signMessage.getMessage(), signMessage.isPrefixed(), signMessage.getTypedDataJson());
        } else if (hostRequest instanceof HostRequest.SignAndSubmitTx) {
            HostRequest.SignAndSubmitTx signAndSubmitTx = (HostRequest.SignAndSubmitTx) hostRequest;
            return new SignatureRequest.SignAndSubmitTx(uuid, hostRequest.getHostRequestId(), signAndSubmitTx.getFromAddress(), signAndSubmitTx.getToAddress(), signAndSubmitTx.getWeiValue(), signAndSubmitTx.getData(), signAndSubmitTx.getNonce(), signAndSubmitTx.getGasPrice(), signAndSubmitTx.getMaxFeePerGas(), signAndSubmitTx.getMaxPriorityFeePerGas(), signAndSubmitTx.getGasLimit(), signAndSubmitTx.getChainId(), signAndSubmitTx.getShouldSubmit(), hostRequest.getHostRequestId().getDappURL());
        } else if (hostRequest instanceof HostRequest.RequestEthereumAccounts) {
            return new SignatureRequest.RequestEthereumAccounts(uuid, hostRequest.getHostRequestId(), ((HostRequest.RequestEthereumAccounts) hostRequest).isParent());
        } else {
            if (hostRequest instanceof HostRequest.SwitchEthereumChain) {
                return new SignatureRequest.SwitchEthereumChain(uuid, hostRequest.getHostRequestId(), ((HostRequest.SwitchEthereumChain) hostRequest).getChainId());
            }
            if (hostRequest instanceof HostRequest.SubmitSignedTx) {
                return null;
            }
            if (hostRequest instanceof HostRequest.RequestCanceled) {
                return new SignatureRequest.RequestCanceled(uuid, hostRequest.getHostRequestId());
            }
            if (hostRequest instanceof HostRequest.ChildRequestEthereumAccounts) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}