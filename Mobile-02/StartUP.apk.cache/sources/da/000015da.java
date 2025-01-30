package com.coinbase.wallet.consumer.dtos;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.models.ConsumerBuyOrder;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.v;

/* compiled from: ConsumerBuyOrderResponseWrapperDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t\u0012\b\u0010&\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\t\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0001\u0010)\u001a\u00020\u0002\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bO\u0010PJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\bJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0012J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0012J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!JÄ\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010)\u001a\u00020\u00022\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010-\u001a\u00020\u00022\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b4\u0010\bJ\u0010\u00105\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00108\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b8\u00109R\u001b\u00101\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010:\u001a\u0004\b;\u0010!R\u0019\u0010#\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b=\u0010\u000bR\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\b>\u0010\u000bR\u0019\u0010%\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b?\u0010\u000bR\u001b\u0010*\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010<\u001a\u0004\b@\u0010\u000bR\u001b\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010<\u001a\u0004\bA\u0010\u000bR\u001b\u0010.\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010B\u001a\u0004\bC\u0010\u0012R\u0019\u0010)\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010D\u001a\u0004\bE\u0010\bR\u001b\u0010/\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010B\u001a\u0004\b/\u0010\u0012R\u001b\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010<\u001a\u0004\bF\u0010\u000bR\u001b\u0010,\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010G\u001a\u0004\bH\u0010\u0018R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010D\u001a\u0004\bI\u0010\bR\u001b\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010<\u001a\u0004\bJ\u0010\u000bR\u001b\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bK\u0010\u0012R\u0019\u0010-\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010D\u001a\u0004\bL\u0010\bR\u001b\u00100\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010M\u001a\u0004\bN\u0010\u001e¨\u0006Q"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseDTO;", "", "", "paymentMethodID", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "asConsumerBuyOrder", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "component2", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Boolean;", "component8", "component9", "component10", "", "component11", "()Ljava/lang/Integer;", "component12", "component13", "component14", "Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "component15", "()Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;", "component16", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;", "id", "amount", "subtotal", ApiConstants.TOTAL, ApiConstants.FEE, "defaultFee", Payload.INSTANT, "payoutAt", "paymentMethodFee", "unitPrice", "holdDays", "resource", "requiresCompletionStep", "isFirstBuy", "secure3DVerification", "wblInfo", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Ljava/lang/Boolean;Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;)Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyOrderResponseDTO;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;", "getWblInfo", "Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;", "getAmount", "getSubtotal", "getTotal", "getPaymentMethodFee", "getUnitPrice", "Ljava/lang/Boolean;", "getRequiresCompletionStep", "Ljava/lang/String;", "getPayoutAt", "getDefaultFee", "Ljava/lang/Integer;", "getHoldDays", "getId", "getFee", "getInstant", "getResource", "Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "getSecure3DVerification", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Ljava/lang/Boolean;Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerNetworkAmountDTO;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;Lcom/coinbase/wallet/consumer/dtos/ConsumerWBLInfoDTO;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyOrderResponseDTO {
    private final ConsumerNetworkAmountDTO amount;
    private final ConsumerNetworkAmountDTO defaultFee;
    private final ConsumerNetworkAmountDTO fee;
    private final Integer holdDays;
    private final String id;
    private final Boolean instant;
    private final Boolean isFirstBuy;
    private final ConsumerNetworkAmountDTO paymentMethodFee;
    private final String payoutAt;
    private final Boolean requiresCompletionStep;
    private final String resource;
    private final Secure3DVerificationDTO secure3DVerification;
    private final ConsumerNetworkAmountDTO subtotal;
    private final ConsumerNetworkAmountDTO total;
    private final ConsumerNetworkAmountDTO unitPrice;
    private final ConsumerWBLInfoDTO wblInfo;

    public ConsumerBuyOrderResponseDTO(String id, ConsumerNetworkAmountDTO amount, ConsumerNetworkAmountDTO subtotal, ConsumerNetworkAmountDTO total, ConsumerNetworkAmountDTO consumerNetworkAmountDTO, @Json(name = "default_fee") ConsumerNetworkAmountDTO consumerNetworkAmountDTO2, Boolean bool, @Json(name = "payout_at") String payoutAt, @Json(name = "payment_method_fee") ConsumerNetworkAmountDTO consumerNetworkAmountDTO3, @Json(name = "unit_price") ConsumerNetworkAmountDTO consumerNetworkAmountDTO4, @Json(name = "hold_days") Integer num, String resource, @Json(name = "requires_completion_step") Boolean bool2, @Json(name = "is_first_buy") Boolean bool3, @Json(name = "secure3d_verification") Secure3DVerificationDTO secure3DVerificationDTO, @Json(name = "wbl_ux_data") ConsumerWBLInfoDTO consumerWBLInfoDTO) {
        m.g(id, "id");
        m.g(amount, "amount");
        m.g(subtotal, "subtotal");
        m.g(total, "total");
        m.g(payoutAt, "payoutAt");
        m.g(resource, "resource");
        this.id = id;
        this.amount = amount;
        this.subtotal = subtotal;
        this.total = total;
        this.fee = consumerNetworkAmountDTO;
        this.defaultFee = consumerNetworkAmountDTO2;
        this.instant = bool;
        this.payoutAt = payoutAt;
        this.paymentMethodFee = consumerNetworkAmountDTO3;
        this.unitPrice = consumerNetworkAmountDTO4;
        this.holdDays = num;
        this.resource = resource;
        this.requiresCompletionStep = bool2;
        this.isFirstBuy = bool3;
        this.secure3DVerification = secure3DVerificationDTO;
        this.wblInfo = consumerWBLInfoDTO;
    }

    public final ConsumerBuyOrder asConsumerBuyOrder(String paymentMethodID) {
        String amount;
        String amount2;
        m.g(paymentMethodID, "paymentMethodID");
        String str = this.id;
        BigDecimal bigDecimal = new BigDecimal(this.amount.getAmount());
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO = this.fee;
        BigDecimal bigDecimal2 = null;
        BigDecimal j2 = (consumerNetworkAmountDTO == null || (amount = consumerNetworkAmountDTO.getAmount()) == null) ? null : v.j(amount);
        if (j2 == null) {
            j2 = BigDecimal.ZERO;
        }
        BigDecimal bigDecimal3 = j2;
        m.f(bigDecimal3, "fee?.amount?.toBigDecimalOrNull() ?: BigDecimal.ZERO");
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO2 = this.paymentMethodFee;
        if (consumerNetworkAmountDTO2 != null && (amount2 = consumerNetworkAmountDTO2.getAmount()) != null) {
            bigDecimal2 = v.j(amount2);
        }
        BigDecimal bigDecimal4 = bigDecimal2 == null ? BigDecimal.ZERO : bigDecimal2;
        m.f(bigDecimal4, "paymentMethodFee?.amount?.toBigDecimalOrNull() ?: BigDecimal.ZERO");
        return new ConsumerBuyOrder(str, bigDecimal, bigDecimal3, bigDecimal4, paymentMethodID, m.c(this.instant, Boolean.TRUE));
    }

    public final String component1() {
        return this.id;
    }

    public final ConsumerNetworkAmountDTO component10() {
        return this.unitPrice;
    }

    public final Integer component11() {
        return this.holdDays;
    }

    public final String component12() {
        return this.resource;
    }

    public final Boolean component13() {
        return this.requiresCompletionStep;
    }

    public final Boolean component14() {
        return this.isFirstBuy;
    }

    public final Secure3DVerificationDTO component15() {
        return this.secure3DVerification;
    }

    public final ConsumerWBLInfoDTO component16() {
        return this.wblInfo;
    }

    public final ConsumerNetworkAmountDTO component2() {
        return this.amount;
    }

    public final ConsumerNetworkAmountDTO component3() {
        return this.subtotal;
    }

    public final ConsumerNetworkAmountDTO component4() {
        return this.total;
    }

    public final ConsumerNetworkAmountDTO component5() {
        return this.fee;
    }

    public final ConsumerNetworkAmountDTO component6() {
        return this.defaultFee;
    }

    public final Boolean component7() {
        return this.instant;
    }

    public final String component8() {
        return this.payoutAt;
    }

    public final ConsumerNetworkAmountDTO component9() {
        return this.paymentMethodFee;
    }

    public final ConsumerBuyOrderResponseDTO copy(String id, ConsumerNetworkAmountDTO amount, ConsumerNetworkAmountDTO subtotal, ConsumerNetworkAmountDTO total, ConsumerNetworkAmountDTO consumerNetworkAmountDTO, @Json(name = "default_fee") ConsumerNetworkAmountDTO consumerNetworkAmountDTO2, Boolean bool, @Json(name = "payout_at") String payoutAt, @Json(name = "payment_method_fee") ConsumerNetworkAmountDTO consumerNetworkAmountDTO3, @Json(name = "unit_price") ConsumerNetworkAmountDTO consumerNetworkAmountDTO4, @Json(name = "hold_days") Integer num, String resource, @Json(name = "requires_completion_step") Boolean bool2, @Json(name = "is_first_buy") Boolean bool3, @Json(name = "secure3d_verification") Secure3DVerificationDTO secure3DVerificationDTO, @Json(name = "wbl_ux_data") ConsumerWBLInfoDTO consumerWBLInfoDTO) {
        m.g(id, "id");
        m.g(amount, "amount");
        m.g(subtotal, "subtotal");
        m.g(total, "total");
        m.g(payoutAt, "payoutAt");
        m.g(resource, "resource");
        return new ConsumerBuyOrderResponseDTO(id, amount, subtotal, total, consumerNetworkAmountDTO, consumerNetworkAmountDTO2, bool, payoutAt, consumerNetworkAmountDTO3, consumerNetworkAmountDTO4, num, resource, bool2, bool3, secure3DVerificationDTO, consumerWBLInfoDTO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerBuyOrderResponseDTO) {
            ConsumerBuyOrderResponseDTO consumerBuyOrderResponseDTO = (ConsumerBuyOrderResponseDTO) obj;
            return m.c(this.id, consumerBuyOrderResponseDTO.id) && m.c(this.amount, consumerBuyOrderResponseDTO.amount) && m.c(this.subtotal, consumerBuyOrderResponseDTO.subtotal) && m.c(this.total, consumerBuyOrderResponseDTO.total) && m.c(this.fee, consumerBuyOrderResponseDTO.fee) && m.c(this.defaultFee, consumerBuyOrderResponseDTO.defaultFee) && m.c(this.instant, consumerBuyOrderResponseDTO.instant) && m.c(this.payoutAt, consumerBuyOrderResponseDTO.payoutAt) && m.c(this.paymentMethodFee, consumerBuyOrderResponseDTO.paymentMethodFee) && m.c(this.unitPrice, consumerBuyOrderResponseDTO.unitPrice) && m.c(this.holdDays, consumerBuyOrderResponseDTO.holdDays) && m.c(this.resource, consumerBuyOrderResponseDTO.resource) && m.c(this.requiresCompletionStep, consumerBuyOrderResponseDTO.requiresCompletionStep) && m.c(this.isFirstBuy, consumerBuyOrderResponseDTO.isFirstBuy) && m.c(this.secure3DVerification, consumerBuyOrderResponseDTO.secure3DVerification) && m.c(this.wblInfo, consumerBuyOrderResponseDTO.wblInfo);
        }
        return false;
    }

    public final ConsumerNetworkAmountDTO getAmount() {
        return this.amount;
    }

    public final ConsumerNetworkAmountDTO getDefaultFee() {
        return this.defaultFee;
    }

    public final ConsumerNetworkAmountDTO getFee() {
        return this.fee;
    }

    public final Integer getHoldDays() {
        return this.holdDays;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getInstant() {
        return this.instant;
    }

    public final ConsumerNetworkAmountDTO getPaymentMethodFee() {
        return this.paymentMethodFee;
    }

    public final String getPayoutAt() {
        return this.payoutAt;
    }

    public final Boolean getRequiresCompletionStep() {
        return this.requiresCompletionStep;
    }

    public final String getResource() {
        return this.resource;
    }

    public final Secure3DVerificationDTO getSecure3DVerification() {
        return this.secure3DVerification;
    }

    public final ConsumerNetworkAmountDTO getSubtotal() {
        return this.subtotal;
    }

    public final ConsumerNetworkAmountDTO getTotal() {
        return this.total;
    }

    public final ConsumerNetworkAmountDTO getUnitPrice() {
        return this.unitPrice;
    }

    public final ConsumerWBLInfoDTO getWblInfo() {
        return this.wblInfo;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.amount.hashCode()) * 31) + this.subtotal.hashCode()) * 31) + this.total.hashCode()) * 31;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO = this.fee;
        int hashCode2 = (hashCode + (consumerNetworkAmountDTO == null ? 0 : consumerNetworkAmountDTO.hashCode())) * 31;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO2 = this.defaultFee;
        int hashCode3 = (hashCode2 + (consumerNetworkAmountDTO2 == null ? 0 : consumerNetworkAmountDTO2.hashCode())) * 31;
        Boolean bool = this.instant;
        int hashCode4 = (((hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31) + this.payoutAt.hashCode()) * 31;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO3 = this.paymentMethodFee;
        int hashCode5 = (hashCode4 + (consumerNetworkAmountDTO3 == null ? 0 : consumerNetworkAmountDTO3.hashCode())) * 31;
        ConsumerNetworkAmountDTO consumerNetworkAmountDTO4 = this.unitPrice;
        int hashCode6 = (hashCode5 + (consumerNetworkAmountDTO4 == null ? 0 : consumerNetworkAmountDTO4.hashCode())) * 31;
        Integer num = this.holdDays;
        int hashCode7 = (((hashCode6 + (num == null ? 0 : num.hashCode())) * 31) + this.resource.hashCode()) * 31;
        Boolean bool2 = this.requiresCompletionStep;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isFirstBuy;
        int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Secure3DVerificationDTO secure3DVerificationDTO = this.secure3DVerification;
        int hashCode10 = (hashCode9 + (secure3DVerificationDTO == null ? 0 : secure3DVerificationDTO.hashCode())) * 31;
        ConsumerWBLInfoDTO consumerWBLInfoDTO = this.wblInfo;
        return hashCode10 + (consumerWBLInfoDTO != null ? consumerWBLInfoDTO.hashCode() : 0);
    }

    public final Boolean isFirstBuy() {
        return this.isFirstBuy;
    }

    public String toString() {
        return "ConsumerBuyOrderResponseDTO(id=" + this.id + ", amount=" + this.amount + ", subtotal=" + this.subtotal + ", total=" + this.total + ", fee=" + this.fee + ", defaultFee=" + this.defaultFee + ", instant=" + this.instant + ", payoutAt=" + this.payoutAt + ", paymentMethodFee=" + this.paymentMethodFee + ", unitPrice=" + this.unitPrice + ", holdDays=" + this.holdDays + ", resource=" + this.resource + ", requiresCompletionStep=" + this.requiresCompletionStep + ", isFirstBuy=" + this.isFirstBuy + ", secure3DVerification=" + this.secure3DVerification + ", wblInfo=" + this.wblInfo + ')';
    }

    public /* synthetic */ ConsumerBuyOrderResponseDTO(String str, ConsumerNetworkAmountDTO consumerNetworkAmountDTO, ConsumerNetworkAmountDTO consumerNetworkAmountDTO2, ConsumerNetworkAmountDTO consumerNetworkAmountDTO3, ConsumerNetworkAmountDTO consumerNetworkAmountDTO4, ConsumerNetworkAmountDTO consumerNetworkAmountDTO5, Boolean bool, String str2, ConsumerNetworkAmountDTO consumerNetworkAmountDTO6, ConsumerNetworkAmountDTO consumerNetworkAmountDTO7, Integer num, String str3, Boolean bool2, Boolean bool3, Secure3DVerificationDTO secure3DVerificationDTO, ConsumerWBLInfoDTO consumerWBLInfoDTO, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, consumerNetworkAmountDTO, consumerNetworkAmountDTO2, consumerNetworkAmountDTO3, consumerNetworkAmountDTO4, consumerNetworkAmountDTO5, bool, str2, consumerNetworkAmountDTO6, consumerNetworkAmountDTO7, num, str3, bool2, bool3, secure3DVerificationDTO, (i2 & 32768) != 0 ? null : consumerWBLInfoDTO);
    }
}