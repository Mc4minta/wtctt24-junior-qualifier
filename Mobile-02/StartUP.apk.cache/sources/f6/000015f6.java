package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerSendRequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "amount", ApiConstants.FEE, ApiConstants.IDEM, ApiConstants.DESCRIPTION, ApiConstants.CURRENCY, ApiConstants.TO, "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerSendRequestDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCurrency", "getType", "getFee", "getAmount", "getTo", "getIdem", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendRequestDTO {
    private final String amount;
    private final String currency;
    private final String description;
    private final String fee;
    private final String idem;
    private final String to;
    private final String type;

    public ConsumerSendRequestDTO(String amount, String fee, String idem, String description, String currency, String to, String type) {
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(idem, "idem");
        m.g(description, "description");
        m.g(currency, "currency");
        m.g(to, "to");
        m.g(type, "type");
        this.amount = amount;
        this.fee = fee;
        this.idem = idem;
        this.description = description;
        this.currency = currency;
        this.to = to;
        this.type = type;
    }

    public static /* synthetic */ ConsumerSendRequestDTO copy$default(ConsumerSendRequestDTO consumerSendRequestDTO, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerSendRequestDTO.amount;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerSendRequestDTO.fee;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = consumerSendRequestDTO.idem;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = consumerSendRequestDTO.description;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = consumerSendRequestDTO.currency;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = consumerSendRequestDTO.to;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = consumerSendRequestDTO.type;
        }
        return consumerSendRequestDTO.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.fee;
    }

    public final String component3() {
        return this.idem;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.currency;
    }

    public final String component6() {
        return this.to;
    }

    public final String component7() {
        return this.type;
    }

    public final ConsumerSendRequestDTO copy(String amount, String fee, String idem, String description, String currency, String to, String type) {
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(idem, "idem");
        m.g(description, "description");
        m.g(currency, "currency");
        m.g(to, "to");
        m.g(type, "type");
        return new ConsumerSendRequestDTO(amount, fee, idem, description, currency, to, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerSendRequestDTO) {
            ConsumerSendRequestDTO consumerSendRequestDTO = (ConsumerSendRequestDTO) obj;
            return m.c(this.amount, consumerSendRequestDTO.amount) && m.c(this.fee, consumerSendRequestDTO.fee) && m.c(this.idem, consumerSendRequestDTO.idem) && m.c(this.description, consumerSendRequestDTO.description) && m.c(this.currency, consumerSendRequestDTO.currency) && m.c(this.to, consumerSendRequestDTO.to) && m.c(this.type, consumerSendRequestDTO.type);
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFee() {
        return this.fee;
    }

    public final String getIdem() {
        return this.idem;
    }

    public final String getTo() {
        return this.to;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.amount.hashCode() * 31) + this.fee.hashCode()) * 31) + this.idem.hashCode()) * 31) + this.description.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.to.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ConsumerSendRequestDTO(amount=" + this.amount + ", fee=" + this.fee + ", idem=" + this.idem + ", description=" + this.description + ", currency=" + this.currency + ", to=" + this.to + ", type=" + this.type + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ConsumerSendRequestDTO(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 4
            if (r0 == 0) goto L13
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "randomUUID().toString()"
            kotlin.jvm.internal.m.f(r0, r1)
            r5 = r0
            goto L14
        L13:
            r5 = r13
        L14:
            r0 = r18 & 8
            if (r0 == 0) goto L20
            com.coinbase.wallet.core.extensions.Strings r0 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r0 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r0)
            r6 = r0
            goto L21
        L20:
            r6 = r14
        L21:
            r0 = r18 & 64
            if (r0 == 0) goto L29
            java.lang.String r0 = "send"
            r9 = r0
            goto L2b
        L29:
            r9 = r17
        L2b:
            r2 = r10
            r3 = r11
            r4 = r12
            r7 = r15
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.dtos.ConsumerSendRequestDTO.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}