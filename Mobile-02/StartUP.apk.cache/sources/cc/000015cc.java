package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ConsumerAvailablePaymentMethodResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0003\u0010\u001f\u001a\u00020\f\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0003\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J®\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010\u001f\u001a\u00020\f2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00022\u0010\b\u0003\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b-\u0010\u0011R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010.\u001a\u0004\b/\u0010\u0004R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b0\u0010\u0004R!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b3\u0010\u0004R!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b4\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b5\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b7\u0010\u000eR\u0019\u0010\u001f\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0013R\u001b\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010.\u001a\u0004\b:\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b;\u0010\u0004R!\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b<\u0010\u0007¨\u0006?"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTO;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Boolean;", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyingPowerDTO;", "component8", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyingPowerDTO;", "component9", "()Z", "component10", "component11", "component12", "type", "requirements", "verifyRequirements", ApiConstants.NAME, ApiConstants.DESCRIPTION, "additionalFees", "recommended", "buyingPower", "instantWithdraw", "addText", "buyTime", "supports", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyingPowerDTO;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/coinbase/wallet/consumer/dtos/ConsumerAvailablePaymentMethodDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyingPowerDTO;", "getBuyingPower", "Ljava/lang/String;", "getAddText", "getDescription", "Ljava/util/List;", "getRequirements", "getType", "getVerifyRequirements", "getName", "Ljava/lang/Boolean;", "getRecommended", "Z", "getInstantWithdraw", "getBuyTime", "getAdditionalFees", "getSupports", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/coinbase/wallet/consumer/dtos/ConsumerBuyingPowerDTO;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodDTO {
    private final String addText;
    private final String additionalFees;
    private final String buyTime;
    private final ConsumerBuyingPowerDTO buyingPower;
    private final String description;
    private final boolean instantWithdraw;
    private final String name;
    private final Boolean recommended;
    private final List<String> requirements;
    private final List<String> supports;
    private final String type;
    private final List<String> verifyRequirements;

    public ConsumerAvailablePaymentMethodDTO(String type, List<String> list, @Json(name = "verify_requirements") List<String> list2, String str, String str2, @Json(name = "additional_fees") String str3, Boolean bool, @Json(name = "buying_power") ConsumerBuyingPowerDTO consumerBuyingPowerDTO, @Json(name = "instant_withdraw") boolean z, @Json(name = "add_text") String str4, @Json(name = "buy_time") String str5, @Json(name = "supports") List<String> list3) {
        m.g(type, "type");
        this.type = type;
        this.requirements = list;
        this.verifyRequirements = list2;
        this.name = str;
        this.description = str2;
        this.additionalFees = str3;
        this.recommended = bool;
        this.buyingPower = consumerBuyingPowerDTO;
        this.instantWithdraw = z;
        this.addText = str4;
        this.buyTime = str5;
        this.supports = list3;
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.addText;
    }

    public final String component11() {
        return this.buyTime;
    }

    public final List<String> component12() {
        return this.supports;
    }

    public final List<String> component2() {
        return this.requirements;
    }

    public final List<String> component3() {
        return this.verifyRequirements;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.additionalFees;
    }

    public final Boolean component7() {
        return this.recommended;
    }

    public final ConsumerBuyingPowerDTO component8() {
        return this.buyingPower;
    }

    public final boolean component9() {
        return this.instantWithdraw;
    }

    public final ConsumerAvailablePaymentMethodDTO copy(String type, List<String> list, @Json(name = "verify_requirements") List<String> list2, String str, String str2, @Json(name = "additional_fees") String str3, Boolean bool, @Json(name = "buying_power") ConsumerBuyingPowerDTO consumerBuyingPowerDTO, @Json(name = "instant_withdraw") boolean z, @Json(name = "add_text") String str4, @Json(name = "buy_time") String str5, @Json(name = "supports") List<String> list3) {
        m.g(type, "type");
        return new ConsumerAvailablePaymentMethodDTO(type, list, list2, str, str2, str3, bool, consumerBuyingPowerDTO, z, str4, str5, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAvailablePaymentMethodDTO) {
            ConsumerAvailablePaymentMethodDTO consumerAvailablePaymentMethodDTO = (ConsumerAvailablePaymentMethodDTO) obj;
            return m.c(this.type, consumerAvailablePaymentMethodDTO.type) && m.c(this.requirements, consumerAvailablePaymentMethodDTO.requirements) && m.c(this.verifyRequirements, consumerAvailablePaymentMethodDTO.verifyRequirements) && m.c(this.name, consumerAvailablePaymentMethodDTO.name) && m.c(this.description, consumerAvailablePaymentMethodDTO.description) && m.c(this.additionalFees, consumerAvailablePaymentMethodDTO.additionalFees) && m.c(this.recommended, consumerAvailablePaymentMethodDTO.recommended) && m.c(this.buyingPower, consumerAvailablePaymentMethodDTO.buyingPower) && this.instantWithdraw == consumerAvailablePaymentMethodDTO.instantWithdraw && m.c(this.addText, consumerAvailablePaymentMethodDTO.addText) && m.c(this.buyTime, consumerAvailablePaymentMethodDTO.buyTime) && m.c(this.supports, consumerAvailablePaymentMethodDTO.supports);
        }
        return false;
    }

    public final String getAddText() {
        return this.addText;
    }

    public final String getAdditionalFees() {
        return this.additionalFees;
    }

    public final String getBuyTime() {
        return this.buyTime;
    }

    public final ConsumerBuyingPowerDTO getBuyingPower() {
        return this.buyingPower;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getInstantWithdraw() {
        return this.instantWithdraw;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getRecommended() {
        return this.recommended;
    }

    public final List<String> getRequirements() {
        return this.requirements;
    }

    public final List<String> getSupports() {
        return this.supports;
    }

    public final String getType() {
        return this.type;
    }

    public final List<String> getVerifyRequirements() {
        return this.verifyRequirements;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        List<String> list = this.requirements;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.verifyRequirements;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.name;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.additionalFees;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.recommended;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        ConsumerBuyingPowerDTO consumerBuyingPowerDTO = this.buyingPower;
        int hashCode8 = (hashCode7 + (consumerBuyingPowerDTO == null ? 0 : consumerBuyingPowerDTO.hashCode())) * 31;
        boolean z = this.instantWithdraw;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode8 + i2) * 31;
        String str4 = this.addText;
        int hashCode9 = (i3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buyTime;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list3 = this.supports;
        return hashCode10 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "ConsumerAvailablePaymentMethodDTO(type=" + this.type + ", requirements=" + this.requirements + ", verifyRequirements=" + this.verifyRequirements + ", name=" + ((Object) this.name) + ", description=" + ((Object) this.description) + ", additionalFees=" + ((Object) this.additionalFees) + ", recommended=" + this.recommended + ", buyingPower=" + this.buyingPower + ", instantWithdraw=" + this.instantWithdraw + ", addText=" + ((Object) this.addText) + ", buyTime=" + ((Object) this.buyTime) + ", supports=" + this.supports + ')';
    }

    public /* synthetic */ ConsumerAvailablePaymentMethodDTO(String str, List list, List list2, String str2, String str3, String str4, Boolean bool, ConsumerBuyingPowerDTO consumerBuyingPowerDTO, boolean z, String str5, String str6, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : list2, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : bool, (i2 & 128) != 0 ? null : consumerBuyingPowerDTO, (i2 & 256) != 0 ? false : z, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : str6, (i2 & PKIFailureInfo.wrongIntegrity) == 0 ? list3 : null);
    }
}