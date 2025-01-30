package com.coinbase.wallet.consumer.apis;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.dtos.BuyStatusWrapperDTO;
import com.coinbase.wallet.consumer.dtos.CompleteCDVRequestDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAssetWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAssetsWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerAvailablePaymentMethodResponseDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyOrderRequestDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerBuyOrderResponseWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerCompleteBuyBodyDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerPaymentMethodWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerSendFeeResponseDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerSendRequestDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerTxWrapperDTO;
import com.coinbase.wallet.consumer.dtos.ConsumerUserResponseEnvelopeDTO;
import com.coinbase.wallet.consumer.dtos.PutConsumerWalletAddressRequestDTO;
import kotlin.Metadata;

/* compiled from: ConsumerAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0001\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\b\b\u0001\u0010\r\u001a\u00020\bH'¢\u0006\u0004\b\u000f\u0010\fJ)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\bH'¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\b2\b\b\u0001\u0010\u0017\u001a\u00020\u00162\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0019\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0017\u001a\u00020\u00162\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0019\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00042\b\b\u0001\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00042\b\b\u0001\u0010$\u001a\u00020\bH'¢\u0006\u0004\b%\u0010\fJ\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0004H'¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0004H'¢\u0006\u0004\b*\u0010(J)\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010,\u001a\u00020+H'¢\u0006\u0004\b.\u0010/J)\u00102\u001a\b\u0012\u0004\u0012\u00020!0\u00042\b\b\u0001\u00100\u001a\u00020\b2\b\b\u0001\u0010,\u001a\u000201H'¢\u0006\u0004\b2\u00103J)\u00105\u001a\b\u0012\u0004\u0012\u00020-0\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u00104\u001a\u00020\bH'¢\u0006\u0004\b5\u0010\u0014J3\u00107\u001a\b\u0012\u0004\u0012\u00020-0\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u00104\u001a\u00020\b2\b\b\u0001\u0010,\u001a\u000206H'¢\u0006\u0004\b7\u00108J)\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u00042\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u00104\u001a\u00020\bH'¢\u0006\u0004\b:\u0010\u0014¨\u0006;"}, d2 = {"Lcom/coinbase/wallet/consumer/apis/ConsumerAPIHttp;", "", "", "includeWbl", "Lh/c/b0;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerUserResponseEnvelopeDTO;", "getCurrentUser", "(Z)Lh/c/b0;", "", "scope", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetsWrapperDTO;", "getAssets", "(Ljava/lang/String;)Lh/c/b0;", "assetId", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetWrapperDTO;", "getAssetInfo", "accountId", "toAddress", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendFeeResponseDTO;", "getFeeEstimate", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "twoFactorAuthToken", "Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;", "sendRequest", "noDestinationTag", "toFinancialInstitution", "Lcom/coinbase/wallet/consumer/dtos/ConsumerTxWrapperDTO;", "sendWith2fa", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;Ljava/lang/Boolean;Z)Lh/c/b0;", "send", "(Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;Ljava/lang/Boolean;Z)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;", "address", "Lkotlin/x;", "updateWalletAddresses", "(Lcom/coinbase/wallet/consumer/dtos/PutConsumerWalletAddressRequestDTO;)Lh/c/b0;", "walletUserId", "deleteWalletAddresses", "Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodResponseDTO;", "availablePaymentMethods", "()Lh/c/b0;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodWrapperDTO;", "paymentMethods", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;", "body", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseWrapperDTO;", "buyAssets", "(Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderRequestDTO;)Lh/c/b0;", "paymentMethodId", "Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;", "completeCardCDVVerification", "(Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/CompleteCDVRequestDTO;)Lh/c/b0;", "buyId", "commitBuyAssets", "Lcom/coinbase/wallet/consumer/dtos/ConsumerCompleteBuyBodyDTO;", "completeBuyAssets", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerCompleteBuyBodyDTO;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/dtos/BuyStatusWrapperDTO;", "getCommitBuyStatus", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ConsumerAPIHttp {

    /* compiled from: ConsumerAPI.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ h.c.b0 send$default(ConsumerAPIHttp consumerAPIHttp, String str, ConsumerSendRequestDTO consumerSendRequestDTO, Boolean bool, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    z = false;
                }
                return consumerAPIHttp.send(str, consumerSendRequestDTO, bool, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }

        public static /* synthetic */ h.c.b0 sendWith2fa$default(ConsumerAPIHttp consumerAPIHttp, String str, String str2, ConsumerSendRequestDTO consumerSendRequestDTO, Boolean bool, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    z = false;
                }
                return consumerAPIHttp.sendWith2fa(str, str2, consumerSendRequestDTO, bool, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendWith2fa");
        }
    }

    @retrofit2.z.f("user/available-payment-methods")
    h.c.b0<ConsumerAvailablePaymentMethodResponseDTO> availablePaymentMethods();

    @retrofit2.z.o("accounts/{account_id}/buys")
    h.c.b0<ConsumerBuyOrderResponseWrapperDTO> buyAssets(@retrofit2.z.s("account_id") String str, @retrofit2.z.a ConsumerBuyOrderRequestDTO consumerBuyOrderRequestDTO);

    @retrofit2.z.o("accounts/{account_id}/buys/{buy_id}/commit")
    h.c.b0<ConsumerBuyOrderResponseWrapperDTO> commitBuyAssets(@retrofit2.z.s("account_id") String str, @retrofit2.z.s("buy_id") String str2);

    @retrofit2.z.o("accounts/{account_id}/buys/{buy_id}/complete")
    h.c.b0<ConsumerBuyOrderResponseWrapperDTO> completeBuyAssets(@retrofit2.z.s("account_id") String str, @retrofit2.z.s("buy_id") String str2, @retrofit2.z.a ConsumerCompleteBuyBodyDTO consumerCompleteBuyBodyDTO);

    @retrofit2.z.o("payment-methods/{payment-method-id}/complete-card-verification")
    h.c.b0<kotlin.x> completeCardCDVVerification(@retrofit2.z.s("payment-method-id") String str, @retrofit2.z.a CompleteCDVRequestDTO completeCDVRequestDTO);

    @retrofit2.z.b("external-wallet/addresses/{wallet_user_id}")
    h.c.b0<kotlin.x> deleteWalletAddresses(@retrofit2.z.s("wallet_user_id") String str);

    @retrofit2.z.f("assets/info/{assetId}")
    h.c.b0<ConsumerAssetWrapperDTO> getAssetInfo(@retrofit2.z.s("assetId") String str);

    @retrofit2.z.f("assets/info")
    h.c.b0<ConsumerAssetsWrapperDTO> getAssets(@retrofit2.z.t("scope") String str);

    @retrofit2.z.f("accounts/{account_id}/buys/{buy_id}/status")
    h.c.b0<BuyStatusWrapperDTO> getCommitBuyStatus(@retrofit2.z.s("account_id") String str, @retrofit2.z.s("buy_id") String str2);

    @retrofit2.z.f(ApiConstants.USER)
    h.c.b0<ConsumerUserResponseEnvelopeDTO> getCurrentUser(@retrofit2.z.t("include_wbl") boolean z);

    @retrofit2.z.f("accounts/{account_id}/transactions/fee-estimate")
    h.c.b0<ConsumerSendFeeResponseDTO> getFeeEstimate(@retrofit2.z.s("account_id") String str, @retrofit2.z.t("to") String str2);

    @retrofit2.z.f(ApiConstants.PAYMENT_METHODS)
    h.c.b0<ConsumerPaymentMethodWrapperDTO> paymentMethods();

    @retrofit2.z.o("accounts/{account_id}/transactions")
    h.c.b0<ConsumerTxWrapperDTO> send(@retrofit2.z.s("account_id") String str, @retrofit2.z.a ConsumerSendRequestDTO consumerSendRequestDTO, @retrofit2.z.t("no_destination_tag") Boolean bool, @retrofit2.z.t("to_financial_institution") boolean z);

    @retrofit2.z.o("accounts/{account_id}/transactions")
    h.c.b0<ConsumerTxWrapperDTO> sendWith2fa(@retrofit2.z.s("account_id") String str, @retrofit2.z.i("CB-2FA-Token") String str2, @retrofit2.z.a ConsumerSendRequestDTO consumerSendRequestDTO, @retrofit2.z.t("no_destination_tag") Boolean bool, @retrofit2.z.t("to_financial_institution") boolean z);

    @retrofit2.z.p("external-wallet/addresses")
    h.c.b0<kotlin.x> updateWalletAddresses(@retrofit2.z.a PutConsumerWalletAddressRequestDTO putConsumerWalletAddressRequestDTO);
}