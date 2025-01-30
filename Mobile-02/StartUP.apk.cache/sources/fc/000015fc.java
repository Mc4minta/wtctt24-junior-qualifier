package com.coinbase.wallet.consumer.dtos;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerUserDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JZ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b\"\u0010\u0004R!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b&\u0010\u0004R\u0013\u0010*\u001a\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerUserDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWithdrawableBalanceDTO;", "component3", "()Lcom/coinbase/wallet/consumer/dtos/ConsumerWithdrawableBalanceDTO;", "component4", "", "component5", "()Ljava/util/List;", "component6", "id", "email", "availableBalance", "nativeCurrency", "restrictions", "nextRequirement", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerWithdrawableBalanceDTO;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerUserDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/consumer/dtos/ConsumerWithdrawableBalanceDTO;", "getAvailableBalance", "Ljava/lang/String;", "getNextRequirement", "getEmail", "Ljava/util/List;", "getRestrictions", "getNativeCurrency", "getId", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "getToConsumerUserModel", "()Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "toConsumerUserModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/consumer/dtos/ConsumerWithdrawableBalanceDTO;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUserDTO {
    private final ConsumerWithdrawableBalanceDTO availableBalance;
    private final String email;
    private final String id;
    private final String nativeCurrency;
    private final String nextRequirement;
    private final List<String> restrictions;

    public ConsumerUserDTO(String id, String email, @Json(name = "available_balance") ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO, @Json(name = "native_currency") String str, List<String> list, @Json(name = "next_requirement") String str2) {
        m.g(id, "id");
        m.g(email, "email");
        this.id = id;
        this.email = email;
        this.availableBalance = consumerWithdrawableBalanceDTO;
        this.nativeCurrency = str;
        this.restrictions = list;
        this.nextRequirement = str2;
    }

    public static /* synthetic */ ConsumerUserDTO copy$default(ConsumerUserDTO consumerUserDTO, String str, String str2, ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO, String str3, List list, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerUserDTO.id;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerUserDTO.email;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            consumerWithdrawableBalanceDTO = consumerUserDTO.availableBalance;
        }
        ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO2 = consumerWithdrawableBalanceDTO;
        if ((i2 & 8) != 0) {
            str3 = consumerUserDTO.nativeCurrency;
        }
        String str6 = str3;
        List<String> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = consumerUserDTO.restrictions;
        }
        List list3 = list2;
        if ((i2 & 32) != 0) {
            str4 = consumerUserDTO.nextRequirement;
        }
        return consumerUserDTO.copy(str, str5, consumerWithdrawableBalanceDTO2, str6, list3, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.email;
    }

    public final ConsumerWithdrawableBalanceDTO component3() {
        return this.availableBalance;
    }

    public final String component4() {
        return this.nativeCurrency;
    }

    public final List<String> component5() {
        return this.restrictions;
    }

    public final String component6() {
        return this.nextRequirement;
    }

    public final ConsumerUserDTO copy(String id, String email, @Json(name = "available_balance") ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO, @Json(name = "native_currency") String str, List<String> list, @Json(name = "next_requirement") String str2) {
        m.g(id, "id");
        m.g(email, "email");
        return new ConsumerUserDTO(id, email, consumerWithdrawableBalanceDTO, str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerUserDTO) {
            ConsumerUserDTO consumerUserDTO = (ConsumerUserDTO) obj;
            return m.c(this.id, consumerUserDTO.id) && m.c(this.email, consumerUserDTO.email) && m.c(this.availableBalance, consumerUserDTO.availableBalance) && m.c(this.nativeCurrency, consumerUserDTO.nativeCurrency) && m.c(this.restrictions, consumerUserDTO.restrictions) && m.c(this.nextRequirement, consumerUserDTO.nextRequirement);
        }
        return false;
    }

    public final ConsumerWithdrawableBalanceDTO getAvailableBalance() {
        return this.availableBalance;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNativeCurrency() {
        return this.nativeCurrency;
    }

    public final String getNextRequirement() {
        return this.nextRequirement;
    }

    public final List<String> getRestrictions() {
        return this.restrictions;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.coinbase.wallet.consumer.models.ConsumerUser getToConsumerUserModel() {
        /*
            r9 = this;
            com.coinbase.wallet.consumer.dtos.ConsumerWithdrawableBalanceDTO r0 = r9.availableBalance
            r1 = 0
            if (r0 != 0) goto L7
            r2 = r1
            goto L10
        L7:
            java.lang.String r0 = r0.getAmount()
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r0)
        L10:
            if (r2 != 0) goto L14
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
        L14:
            r6 = r2
            com.coinbase.wallet.consumer.dtos.ConsumerWithdrawableBalanceDTO r0 = r9.availableBalance
            if (r0 != 0) goto L1b
            r2 = r1
            goto L39
        L1b:
            java.lang.String r0 = r0.getCurrency()
            com.coinbase.wallet.blockchains.models.CurrencyCode r2 = new com.coinbase.wallet.blockchains.models.CurrencyCode
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "US"
            kotlin.jvm.internal.m.f(r3, r4)
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r4)
            java.lang.String r0 = r0.toUpperCase(r3)
            java.lang.String r3 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.m.f(r0, r3)
            r2.<init>(r0)
        L39:
            if (r2 != 0) goto L50
            java.lang.String r0 = r9.nativeCurrency
            if (r0 != 0) goto L41
            r2 = r1
            goto L46
        L41:
            com.coinbase.wallet.blockchains.models.CurrencyCode r2 = new com.coinbase.wallet.blockchains.models.CurrencyCode
            r2.<init>(r0)
        L46:
            if (r2 != 0) goto L50
            com.coinbase.wallet.blockchains.models.CurrencyCode$Companion r0 = com.coinbase.wallet.blockchains.models.CurrencyCode.Companion
            com.coinbase.wallet.blockchains.models.CurrencyCode r0 = r0.getUSD()
            r7 = r0
            goto L51
        L50:
            r7 = r2
        L51:
            java.util.List<java.lang.String> r0 = r9.restrictions
            if (r0 != 0) goto L56
            goto L5a
        L56:
            java.util.List r1 = kotlin.a0.p.K0(r0)
        L5a:
            if (r1 != 0) goto L63
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8 = r0
            goto L64
        L63:
            r8 = r1
        L64:
            java.lang.String r0 = r9.getNextRequirement()
            if (r0 == 0) goto L71
            java.lang.String r0 = r9.getNextRequirement()
            r8.add(r0)
        L71:
            com.coinbase.wallet.consumer.models.ConsumerUser r0 = new com.coinbase.wallet.consumer.models.ConsumerUser
            java.lang.String r4 = r9.id
            java.lang.String r5 = r9.email
            java.lang.String r1 = "withdrawalLimit"
            kotlin.jvm.internal.m.f(r6, r1)
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.dtos.ConsumerUserDTO.getToConsumerUserModel():com.coinbase.wallet.consumer.models.ConsumerUser");
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.email.hashCode()) * 31;
        ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO = this.availableBalance;
        int hashCode2 = (hashCode + (consumerWithdrawableBalanceDTO == null ? 0 : consumerWithdrawableBalanceDTO.hashCode())) * 31;
        String str = this.nativeCurrency;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.restrictions;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.nextRequirement;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ConsumerUserDTO(id=" + this.id + ", email=" + this.email + ", availableBalance=" + this.availableBalance + ", nativeCurrency=" + ((Object) this.nativeCurrency) + ", restrictions=" + this.restrictions + ", nextRequirement=" + ((Object) this.nextRequirement) + ')';
    }

    public /* synthetic */ ConsumerUserDTO(String str, String str2, ConsumerWithdrawableBalanceDTO consumerWithdrawableBalanceDTO, String str3, List list, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, consumerWithdrawableBalanceDTO, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : list, (i2 & 32) != 0 ? null : str4);
    }
}