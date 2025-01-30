package com.coinbase.android.apiv3.generated.common;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import com.squareup.wire.q.b;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.ErrorBundle;

/* compiled from: PaymentMethodLimit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B[\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJa\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b \u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b$\u0010#R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b%\u0010\u000f¨\u0006)"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "label", "headline", ErrorBundle.SUMMARY_ENTRY, "detailed_description", "period_in_days", "Lcom/coinbase/android/apiv3/generated/common/Amount;", ApiConstants.TOTAL, "remaining", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;", "Ljava/lang/String;", "getLabel", "getHeadline", "getSummary", "getDetailed_description", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getTotal", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getRemaining", "getPeriod_in_days", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PaymentMethodLimit extends a {
    public static final ProtoAdapter<PaymentMethodLimit> ADAPTER;
    public static final Parcelable.Creator<PaymentMethodLimit> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "detailedDescription", tag = 4)
    private final String detailed_description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String headline;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "periodInDays", tag = 5)
    private final String period_in_days;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 7)
    private final Amount remaining;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String summary;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 6)
    private final Amount total;

    /* compiled from: PaymentMethodLimit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PaymentMethodLimit> protoAdapter = new ProtoAdapter<PaymentMethodLimit>(c.LENGTH_DELIMITED, e0.b(PaymentMethodLimit.class), "type.googleapis.com/coinbase.public_api.common.PaymentMethodLimit") { // from class: com.coinbase.android.apiv3.generated.common.PaymentMethodLimit$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PaymentMethodLimit decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                Amount amount2 = null;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PaymentMethodLimit(str, str2, str3, str4, str5, amount, amount2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PaymentMethodLimit value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getLabel());
                }
                if (!m.c(value.getHeadline(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getHeadline());
                }
                if (!m.c(value.getSummary(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSummary());
                }
                if (!m.c(value.getDetailed_description(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getDetailed_description());
                }
                if (!m.c(value.getPeriod_in_days(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getPeriod_in_days());
                }
                if (value.getTotal() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getTotal());
                }
                if (value.getRemaining() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 7, value.getRemaining());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PaymentMethodLimit value) {
                m.h(value, "value");
                if (m.c(value.getLabel(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getLabel());
                if (!m.c(value.getHeadline(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getHeadline());
                    if (!m.c(value.getSummary(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getSummary());
                        if (!m.c(value.getDetailed_description(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getDetailed_description());
                            if (!m.c(value.getPeriod_in_days(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getPeriod_in_days());
                                if (value.getTotal() != null) {
                                    ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                                    r2 = (value.getRemaining() != null ? protoAdapter3.encodedSizeWithTag(7, value.getRemaining()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(6, value.getTotal());
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PaymentMethodLimit redact(PaymentMethodLimit value) {
                m.h(value, "value");
                Amount total = value.getTotal();
                Amount redact = total != null ? Amount.ADAPTER.redact(total) : null;
                Amount remaining = value.getRemaining();
                return PaymentMethodLimit.copy$default(value, null, null, null, null, null, redact, remaining != null ? Amount.ADAPTER.redact(remaining) : null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PaymentMethodLimit() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ PaymentMethodLimit(String str, String str2, String str3, String str4, String str5, Amount amount, Amount amount2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? null : amount, (i2 & 64) == 0 ? amount2 : null, (i2 & 128) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PaymentMethodLimit copy$default(PaymentMethodLimit paymentMethodLimit, String str, String str2, String str3, String str4, String str5, Amount amount, Amount amount2, i iVar, int i2, Object obj) {
        return paymentMethodLimit.copy((i2 & 1) != 0 ? paymentMethodLimit.label : str, (i2 & 2) != 0 ? paymentMethodLimit.headline : str2, (i2 & 4) != 0 ? paymentMethodLimit.summary : str3, (i2 & 8) != 0 ? paymentMethodLimit.detailed_description : str4, (i2 & 16) != 0 ? paymentMethodLimit.period_in_days : str5, (i2 & 32) != 0 ? paymentMethodLimit.total : amount, (i2 & 64) != 0 ? paymentMethodLimit.remaining : amount2, (i2 & 128) != 0 ? paymentMethodLimit.unknownFields() : iVar);
    }

    public final PaymentMethodLimit copy(String label, String headline, String summary, String detailed_description, String period_in_days, Amount amount, Amount amount2, i unknownFields) {
        m.h(label, "label");
        m.h(headline, "headline");
        m.h(summary, "summary");
        m.h(detailed_description, "detailed_description");
        m.h(period_in_days, "period_in_days");
        m.h(unknownFields, "unknownFields");
        return new PaymentMethodLimit(label, headline, summary, detailed_description, period_in_days, amount, amount2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PaymentMethodLimit) {
            PaymentMethodLimit paymentMethodLimit = (PaymentMethodLimit) obj;
            return m.c(unknownFields(), paymentMethodLimit.unknownFields()) && m.c(this.label, paymentMethodLimit.label) && m.c(this.headline, paymentMethodLimit.headline) && m.c(this.summary, paymentMethodLimit.summary) && m.c(this.detailed_description, paymentMethodLimit.detailed_description) && m.c(this.period_in_days, paymentMethodLimit.period_in_days) && m.c(this.total, paymentMethodLimit.total) && m.c(this.remaining, paymentMethodLimit.remaining);
        }
        return false;
    }

    public final String getDetailed_description() {
        return this.detailed_description;
    }

    public final String getHeadline() {
        return this.headline;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getPeriod_in_days() {
        return this.period_in_days;
    }

    public final Amount getRemaining() {
        return this.remaining;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Amount getTotal() {
        return this.total;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + this.label.hashCode()) * 37) + this.headline.hashCode()) * 37) + this.summary.hashCode()) * 37) + this.detailed_description.hashCode()) * 37) + this.period_in_days.hashCode()) * 37;
            Amount amount = this.total;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.remaining;
            int hashCode3 = hashCode2 + (amount2 != null ? amount2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m512newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("label=" + b.c(this.label));
        arrayList.add("headline=" + b.c(this.headline));
        arrayList.add("summary=" + b.c(this.summary));
        arrayList.add("detailed_description=" + b.c(this.detailed_description));
        arrayList.add("period_in_days=" + b.c(this.period_in_days));
        if (this.total != null) {
            arrayList.add("total=" + this.total);
        }
        if (this.remaining != null) {
            arrayList.add("remaining=" + this.remaining);
        }
        h0 = z.h0(arrayList, ", ", "PaymentMethodLimit{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethodLimit(String label, String headline, String summary, String detailed_description, String period_in_days, Amount amount, Amount amount2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(label, "label");
        m.h(headline, "headline");
        m.h(summary, "summary");
        m.h(detailed_description, "detailed_description");
        m.h(period_in_days, "period_in_days");
        m.h(unknownFields, "unknownFields");
        this.label = label;
        this.headline = headline;
        this.summary = summary;
        this.detailed_description = detailed_description;
        this.period_in_days = period_in_days;
        this.total = amount;
        this.remaining = amount2;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m512newBuilder() {
        throw new AssertionError();
    }
}