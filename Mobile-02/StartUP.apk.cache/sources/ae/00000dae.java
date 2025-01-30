package com.coinbase.android.apiv3.generated.authed.payment_methods;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Link;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetPaymentMethodBuyLimitsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B7\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/payment_methods/GetPaymentMethodBuyLimitsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "overview", "Lcom/coinbase/android/apiv3/generated/common/Link;", "support_info", "", "Lcom/coinbase/android/apiv3/generated/authed/payment_methods/PaymentMethodBuyLimit;", "payment_method_buy_limits", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/payment_methods/GetPaymentMethodBuyLimitsResponse;", "Ljava/lang/String;", "getOverview", "Ljava/util/List;", "getPayment_method_buy_limits", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getSupport_info", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetPaymentMethodBuyLimitsResponse extends a {
    public static final ProtoAdapter<GetPaymentMethodBuyLimitsResponse> ADAPTER;
    public static final Parcelable.Creator<GetPaymentMethodBuyLimitsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String overview;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.payment_methods.PaymentMethodBuyLimit#ADAPTER", jsonName = "paymentMethodBuyLimits", label = p.a.REPEATED, tag = 3)
    private final List<PaymentMethodBuyLimit> payment_method_buy_limits;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", jsonName = "supportInfo", tag = 2)
    private final Link support_info;

    /* compiled from: GetPaymentMethodBuyLimitsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/payment_methods/GetPaymentMethodBuyLimitsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/payment_methods/GetPaymentMethodBuyLimitsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetPaymentMethodBuyLimitsResponse> protoAdapter = new ProtoAdapter<GetPaymentMethodBuyLimitsResponse>(c.LENGTH_DELIMITED, e0.b(GetPaymentMethodBuyLimitsResponse.class), "type.googleapis.com/coinbase.public_api.authed.payment_methods.GetPaymentMethodBuyLimitsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.payment_methods.GetPaymentMethodBuyLimitsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetPaymentMethodBuyLimitsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                Link link = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetPaymentMethodBuyLimitsResponse(str, link, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        link = Link.ADAPTER.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        arrayList.add(PaymentMethodBuyLimit.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetPaymentMethodBuyLimitsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getOverview(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getOverview());
                }
                if (value.getSupport_info() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 2, value.getSupport_info());
                }
                PaymentMethodBuyLimit.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getPayment_method_buy_limits());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetPaymentMethodBuyLimitsResponse value) {
                m.h(value, "value");
                if (m.c(value.getOverview(), "")) {
                    return 0;
                }
                return (value.getSupport_info() != null ? Link.ADAPTER.encodedSizeWithTag(2, value.getSupport_info()) + PaymentMethodBuyLimit.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getPayment_method_buy_limits()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getOverview());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetPaymentMethodBuyLimitsResponse redact(GetPaymentMethodBuyLimitsResponse value) {
                m.h(value, "value");
                Link support_info = value.getSupport_info();
                return GetPaymentMethodBuyLimitsResponse.copy$default(value, null, support_info != null ? Link.ADAPTER.redact(support_info) : null, b.a(value.getPayment_method_buy_limits(), PaymentMethodBuyLimit.ADAPTER), i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetPaymentMethodBuyLimitsResponse() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ GetPaymentMethodBuyLimitsResponse(String str, Link link, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : link, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetPaymentMethodBuyLimitsResponse copy$default(GetPaymentMethodBuyLimitsResponse getPaymentMethodBuyLimitsResponse, String str, Link link, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getPaymentMethodBuyLimitsResponse.overview;
        }
        if ((i2 & 2) != 0) {
            link = getPaymentMethodBuyLimitsResponse.support_info;
        }
        if ((i2 & 4) != 0) {
            list = getPaymentMethodBuyLimitsResponse.payment_method_buy_limits;
        }
        if ((i2 & 8) != 0) {
            iVar = getPaymentMethodBuyLimitsResponse.unknownFields();
        }
        return getPaymentMethodBuyLimitsResponse.copy(str, link, list, iVar);
    }

    public final GetPaymentMethodBuyLimitsResponse copy(String overview, Link link, List<PaymentMethodBuyLimit> payment_method_buy_limits, i unknownFields) {
        m.h(overview, "overview");
        m.h(payment_method_buy_limits, "payment_method_buy_limits");
        m.h(unknownFields, "unknownFields");
        return new GetPaymentMethodBuyLimitsResponse(overview, link, payment_method_buy_limits, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetPaymentMethodBuyLimitsResponse) {
            GetPaymentMethodBuyLimitsResponse getPaymentMethodBuyLimitsResponse = (GetPaymentMethodBuyLimitsResponse) obj;
            return m.c(unknownFields(), getPaymentMethodBuyLimitsResponse.unknownFields()) && m.c(this.overview, getPaymentMethodBuyLimitsResponse.overview) && m.c(this.support_info, getPaymentMethodBuyLimitsResponse.support_info) && m.c(this.payment_method_buy_limits, getPaymentMethodBuyLimitsResponse.payment_method_buy_limits);
        }
        return false;
    }

    public final String getOverview() {
        return this.overview;
    }

    public final List<PaymentMethodBuyLimit> getPayment_method_buy_limits() {
        return this.payment_method_buy_limits;
    }

    public final Link getSupport_info() {
        return this.support_info;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.overview.hashCode()) * 37;
            Link link = this.support_info;
            int hashCode2 = ((hashCode + (link != null ? link.hashCode() : 0)) * 37) + this.payment_method_buy_limits.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m438newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("overview=" + b.c(this.overview));
        if (this.support_info != null) {
            arrayList.add("support_info=" + this.support_info);
        }
        if (!this.payment_method_buy_limits.isEmpty()) {
            arrayList.add("payment_method_buy_limits=" + this.payment_method_buy_limits);
        }
        h0 = z.h0(arrayList, ", ", "GetPaymentMethodBuyLimitsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m438newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPaymentMethodBuyLimitsResponse(String overview, Link link, List<PaymentMethodBuyLimit> payment_method_buy_limits, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(overview, "overview");
        m.h(payment_method_buy_limits, "payment_method_buy_limits");
        m.h(unknownFields, "unknownFields");
        this.overview = overview;
        this.support_info = link;
        this.payment_method_buy_limits = payment_method_buy_limits;
    }
}