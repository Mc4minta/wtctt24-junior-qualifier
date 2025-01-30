package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.FeeDetails;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.coinbase.android.apiv3.generated.common.UserWarning;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.internal.http2.Settings;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: CreateSendResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 L2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001LBÇ\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJÍ\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00192\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010#\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010.R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b/\u0010.R\u001c\u0010%\u001a\u00020$8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00100\u001a\u0004\b1\u00102R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b4\u00105R\u001c\u0010&\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00106\u001a\u0004\b7\u0010\u000fR\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b8\u0010.R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00109\u001a\u0004\b:\u0010;R\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00106\u001a\u0004\b?\u0010\u000fR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b@\u00105R\u001c\u0010'\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010#\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00106\u001a\u0004\bD\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010E\u001a\u0004\bF\u0010GR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\bH\u00105R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010E\u001a\u0004\bI\u0010G¨\u0006M"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "fiat_amount", "Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "to_details", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "from_account", "payment_method", "", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "payment_methods", "Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "fees", "Lcom/coinbase/android/apiv3/generated/common/UserWarning;", "user_warnings", "Lcom/coinbase/android/apiv3/generated/authed/sends/QuotePrice;", "quote_price", ApiConstants.TOTAL, "note", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "send_type", "on_chain_estimation", "eligible_for_offchain", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/sends/QuotePrice;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;Ljava/lang/String;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendResponse;", "Ljava/util/List;", "getPayment_methods", "()Ljava/util/List;", "getUser_warnings", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "getSend_type", "()Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getOn_chain_estimation", "getFees", "Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "getTo_details", "()Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "Lcom/coinbase/android/apiv3/generated/authed/sends/QuotePrice;", "getQuote_price", "()Lcom/coinbase/android/apiv3/generated/authed/sends/QuotePrice;", "getId", "getTotal", "Z", "getEligible_for_offchain", "()Z", "getNote", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "getFiat_amount", "getFrom_account", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/sends/QuotePrice;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;Ljava/lang/String;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CreateSendResponse extends a {
    public static final ProtoAdapter<CreateSendResponse> ADAPTER;
    public static final Parcelable.Creator<CreateSendResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 2)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "eligibleForOffchain", tag = 15)
    private final boolean eligible_for_offchain;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.FeeDetails#ADAPTER", label = p.a.REPEATED, tag = 8)
    private final List<FeeDetails> fees;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "fiatAmount", tag = 3)
    private final Amount fiat_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "fromAccount", tag = 5)
    private final Ref from_account;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    private final String note;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "onChainEstimation", tag = 14)
    private final String on_chain_estimation;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "paymentMethod", tag = 6)
    private final Ref payment_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.SendPaymentMethod#ADAPTER", jsonName = "paymentMethods", label = p.a.REPEATED, tag = 7)
    private final List<SendPaymentMethod> payment_methods;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.QuotePrice#ADAPTER", jsonName = "quotePrice", tag = 10)
    private final QuotePrice quote_price;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.SendType#ADAPTER", jsonName = "sendType", tag = 13)
    private final SendType send_type;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.ToDetails#ADAPTER", jsonName = "toDetails", tag = 4)
    private final ToDetails to_details;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 11)
    private final Amount total;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.UserWarning#ADAPTER", jsonName = "userWarnings", label = p.a.REPEATED, tag = 9)
    private final List<UserWarning> user_warnings;

    /* compiled from: CreateSendResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final d b2 = e0.b(CreateSendResponse.class);
        ProtoAdapter<CreateSendResponse> protoAdapter = new ProtoAdapter<CreateSendResponse>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.CreateSendResponse") { // from class: com.coinbase.android.apiv3.generated.authed.sends.CreateSendResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateSendResponse decode(k reader) {
                long j2;
                String str;
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                SendType sendType = SendType.UNKNOWN;
                long d2 = reader.d();
                String str2 = "";
                Amount amount = null;
                SendType sendType2 = sendType;
                String str3 = "";
                String str4 = str3;
                ToDetails toDetails = null;
                Ref ref = null;
                Ref ref2 = null;
                QuotePrice quotePrice = null;
                Amount amount2 = null;
                boolean z = false;
                Amount amount3 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CreateSendResponse(str2, amount, amount3, toDetails, ref, ref2, arrayList, arrayList2, arrayList3, quotePrice, amount2, str4, sendType2, str3, z, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            j2 = d2;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            j2 = d2;
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            j2 = d2;
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            j2 = d2;
                            toDetails = ToDetails.ADAPTER.decode(reader);
                            break;
                        case 5:
                            j2 = d2;
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        case 6:
                            j2 = d2;
                            ref2 = Ref.ADAPTER.decode(reader);
                            break;
                        case 7:
                            j2 = d2;
                            str = str2;
                            arrayList.add(SendPaymentMethod.ADAPTER.decode(reader));
                            str2 = str;
                            break;
                        case 8:
                            j2 = d2;
                            str = str2;
                            arrayList2.add(FeeDetails.ADAPTER.decode(reader));
                            str2 = str;
                            break;
                        case 9:
                            j2 = d2;
                            str = str2;
                            arrayList3.add(UserWarning.ADAPTER.decode(reader));
                            str2 = str;
                            break;
                        case 10:
                            j2 = d2;
                            quotePrice = QuotePrice.ADAPTER.decode(reader);
                            break;
                        case 11:
                            j2 = d2;
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 12:
                            j2 = d2;
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            try {
                                SendType decode = SendType.ADAPTER.decode(reader);
                                try {
                                    x xVar = x.a;
                                    j2 = d2;
                                    sendType2 = decode;
                                    str = str2;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                    e = e2;
                                    j2 = d2;
                                    sendType2 = decode;
                                    str = str2;
                                    reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                    x xVar2 = x.a;
                                    str2 = str;
                                    d2 = j2;
                                }
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e = e3;
                                j2 = d2;
                            }
                            str2 = str;
                        case 14:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 15:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            j2 = d2;
                            break;
                        default:
                            j2 = d2;
                            str = str2;
                            reader.m(g2);
                            str2 = str;
                            break;
                    }
                    d2 = j2;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CreateSendResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getAmount());
                }
                if (value.getFiat_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getFiat_amount());
                }
                if (value.getTo_details() != null) {
                    ToDetails.ADAPTER.encodeWithTag(writer, 4, value.getTo_details());
                }
                if (value.getFrom_account() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 5, value.getFrom_account());
                }
                if (value.getPayment_method() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 6, value.getPayment_method());
                }
                SendPaymentMethod.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.getPayment_methods());
                FeeDetails.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.getFees());
                UserWarning.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.getUser_warnings());
                if (value.getQuote_price() != null) {
                    QuotePrice.ADAPTER.encodeWithTag(writer, 10, value.getQuote_price());
                }
                if (value.getTotal() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 11, value.getTotal());
                }
                if (!m.c(value.getNote(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getNote());
                }
                if (value.getSend_type() != SendType.UNKNOWN) {
                    SendType.ADAPTER.encodeWithTag(writer, 13, value.getSend_type());
                }
                if (!m.c(value.getOn_chain_estimation(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 14, value.getOn_chain_estimation());
                }
                if (value.getEligible_for_offchain()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 15, Boolean.valueOf(value.getEligible_for_offchain()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CreateSendResponse value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (value.getAmount() != null) {
                    ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, value.getAmount());
                    if (value.getFiat_amount() != null) {
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getFiat_amount());
                        if (value.getTo_details() != null) {
                            int encodedSizeWithTag4 = ToDetails.ADAPTER.encodedSizeWithTag(4, value.getTo_details());
                            if (value.getFrom_account() != null) {
                                ProtoAdapter<Ref> protoAdapter4 = Ref.ADAPTER;
                                int encodedSizeWithTag5 = protoAdapter4.encodedSizeWithTag(5, value.getFrom_account());
                                if (value.getPayment_method() != null) {
                                    int encodedSizeWithTag6 = protoAdapter4.encodedSizeWithTag(6, value.getPayment_method()) + SendPaymentMethod.ADAPTER.asRepeated().encodedSizeWithTag(7, value.getPayment_methods()) + FeeDetails.ADAPTER.asRepeated().encodedSizeWithTag(8, value.getFees()) + UserWarning.ADAPTER.asRepeated().encodedSizeWithTag(9, value.getUser_warnings());
                                    if (value.getQuote_price() != null) {
                                        int encodedSizeWithTag7 = QuotePrice.ADAPTER.encodedSizeWithTag(10, value.getQuote_price());
                                        if (value.getTotal() != null) {
                                            int encodedSizeWithTag8 = protoAdapter3.encodedSizeWithTag(11, value.getTotal());
                                            if (!m.c(value.getNote(), "")) {
                                                int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(12, value.getNote());
                                                if (value.getSend_type() != SendType.UNKNOWN) {
                                                    int encodedSizeWithTag10 = SendType.ADAPTER.encodedSizeWithTag(13, value.getSend_type());
                                                    if (!m.c(value.getOn_chain_estimation(), "")) {
                                                        r3 = (value.getEligible_for_offchain() ? ProtoAdapter.BOOL.encodedSizeWithTag(15, Boolean.valueOf(value.getEligible_for_offchain())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(14, value.getOn_chain_estimation());
                                                    }
                                                    r3 += encodedSizeWithTag10;
                                                }
                                                r3 += encodedSizeWithTag9;
                                            }
                                            r3 += encodedSizeWithTag8;
                                        }
                                        r3 += encodedSizeWithTag7;
                                    }
                                    r3 += encodedSizeWithTag6;
                                }
                                r3 += encodedSizeWithTag5;
                            }
                            r3 += encodedSizeWithTag4;
                        }
                        r3 += encodedSizeWithTag3;
                    }
                    r3 += encodedSizeWithTag2;
                }
                return r3 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CreateSendResponse redact(CreateSendResponse value) {
                CreateSendResponse copy;
                m.h(value, "value");
                Amount amount = value.getAmount();
                Amount redact = amount != null ? Amount.ADAPTER.redact(amount) : null;
                Amount fiat_amount = value.getFiat_amount();
                Amount redact2 = fiat_amount != null ? Amount.ADAPTER.redact(fiat_amount) : null;
                ToDetails to_details = value.getTo_details();
                ToDetails redact3 = to_details != null ? ToDetails.ADAPTER.redact(to_details) : null;
                Ref from_account = value.getFrom_account();
                Ref redact4 = from_account != null ? Ref.ADAPTER.redact(from_account) : null;
                Ref payment_method = value.getPayment_method();
                Ref redact5 = payment_method != null ? Ref.ADAPTER.redact(payment_method) : null;
                List a = b.a(value.getPayment_methods(), SendPaymentMethod.ADAPTER);
                List a2 = b.a(value.getFees(), FeeDetails.ADAPTER);
                List a3 = b.a(value.getUser_warnings(), UserWarning.ADAPTER);
                QuotePrice quote_price = value.getQuote_price();
                QuotePrice redact6 = quote_price != null ? QuotePrice.ADAPTER.redact(quote_price) : null;
                Amount total = value.getTotal();
                copy = value.copy((r34 & 1) != 0 ? value.id : null, (r34 & 2) != 0 ? value.amount : redact, (r34 & 4) != 0 ? value.fiat_amount : redact2, (r34 & 8) != 0 ? value.to_details : redact3, (r34 & 16) != 0 ? value.from_account : redact4, (r34 & 32) != 0 ? value.payment_method : redact5, (r34 & 64) != 0 ? value.payment_methods : a, (r34 & 128) != 0 ? value.fees : a2, (r34 & 256) != 0 ? value.user_warnings : a3, (r34 & 512) != 0 ? value.quote_price : redact6, (r34 & 1024) != 0 ? value.total : total != null ? Amount.ADAPTER.redact(total) : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? value.note : null, (r34 & 4096) != 0 ? value.send_type : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? value.on_chain_estimation : null, (r34 & 16384) != 0 ? value.eligible_for_offchain : false, (r34 & 32768) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CreateSendResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    public /* synthetic */ CreateSendResponse(String str, Amount amount, Amount amount2, ToDetails toDetails, Ref ref, Ref ref2, List list, List list2, List list3, QuotePrice quotePrice, Amount amount3, String str2, SendType sendType, String str3, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : amount2, (i2 & 8) != 0 ? null : toDetails, (i2 & 16) != 0 ? null : ref, (i2 & 32) != 0 ? null : ref2, (i2 & 64) != 0 ? r.g() : list, (i2 & 128) != 0 ? r.g() : list2, (i2 & 256) != 0 ? r.g() : list3, (i2 & 512) != 0 ? null : quotePrice, (i2 & 1024) == 0 ? amount3 : null, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? "" : str2, (i2 & 4096) != 0 ? SendType.UNKNOWN : sendType, (i2 & PKIFailureInfo.certRevoked) == 0 ? str3 : "", (i2 & 16384) != 0 ? false : z, (i2 & 32768) != 0 ? i.a : iVar);
    }

    public final CreateSendResponse copy(String id, Amount amount, Amount amount2, ToDetails toDetails, Ref ref, Ref ref2, List<SendPaymentMethod> payment_methods, List<FeeDetails> fees, List<UserWarning> user_warnings, QuotePrice quotePrice, Amount amount3, String note, SendType send_type, String on_chain_estimation, boolean z, i unknownFields) {
        m.h(id, "id");
        m.h(payment_methods, "payment_methods");
        m.h(fees, "fees");
        m.h(user_warnings, "user_warnings");
        m.h(note, "note");
        m.h(send_type, "send_type");
        m.h(on_chain_estimation, "on_chain_estimation");
        m.h(unknownFields, "unknownFields");
        return new CreateSendResponse(id, amount, amount2, toDetails, ref, ref2, payment_methods, fees, user_warnings, quotePrice, amount3, note, send_type, on_chain_estimation, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreateSendResponse) {
            CreateSendResponse createSendResponse = (CreateSendResponse) obj;
            return m.c(unknownFields(), createSendResponse.unknownFields()) && m.c(this.id, createSendResponse.id) && m.c(this.amount, createSendResponse.amount) && m.c(this.fiat_amount, createSendResponse.fiat_amount) && m.c(this.to_details, createSendResponse.to_details) && m.c(this.from_account, createSendResponse.from_account) && m.c(this.payment_method, createSendResponse.payment_method) && m.c(this.payment_methods, createSendResponse.payment_methods) && m.c(this.fees, createSendResponse.fees) && m.c(this.user_warnings, createSendResponse.user_warnings) && m.c(this.quote_price, createSendResponse.quote_price) && m.c(this.total, createSendResponse.total) && m.c(this.note, createSendResponse.note) && this.send_type == createSendResponse.send_type && m.c(this.on_chain_estimation, createSendResponse.on_chain_estimation) && this.eligible_for_offchain == createSendResponse.eligible_for_offchain;
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final boolean getEligible_for_offchain() {
        return this.eligible_for_offchain;
    }

    public final List<FeeDetails> getFees() {
        return this.fees;
    }

    public final Amount getFiat_amount() {
        return this.fiat_amount;
    }

    public final Ref getFrom_account() {
        return this.from_account;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getOn_chain_estimation() {
        return this.on_chain_estimation;
    }

    public final Ref getPayment_method() {
        return this.payment_method;
    }

    public final List<SendPaymentMethod> getPayment_methods() {
        return this.payment_methods;
    }

    public final QuotePrice getQuote_price() {
        return this.quote_price;
    }

    public final SendType getSend_type() {
        return this.send_type;
    }

    public final ToDetails getTo_details() {
        return this.to_details;
    }

    public final Amount getTotal() {
        return this.total;
    }

    public final List<UserWarning> getUser_warnings() {
        return this.user_warnings;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.fiat_amount;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            ToDetails toDetails = this.to_details;
            int hashCode4 = (hashCode3 + (toDetails != null ? toDetails.hashCode() : 0)) * 37;
            Ref ref = this.from_account;
            int hashCode5 = (hashCode4 + (ref != null ? ref.hashCode() : 0)) * 37;
            Ref ref2 = this.payment_method;
            int hashCode6 = (((((((hashCode5 + (ref2 != null ? ref2.hashCode() : 0)) * 37) + this.payment_methods.hashCode()) * 37) + this.fees.hashCode()) * 37) + this.user_warnings.hashCode()) * 37;
            QuotePrice quotePrice = this.quote_price;
            int hashCode7 = (hashCode6 + (quotePrice != null ? quotePrice.hashCode() : 0)) * 37;
            Amount amount3 = this.total;
            int hashCode8 = ((((((((hashCode7 + (amount3 != null ? amount3.hashCode() : 0)) * 37) + this.note.hashCode()) * 37) + this.send_type.hashCode()) * 37) + this.on_chain_estimation.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.eligible_for_offchain);
            this.hashCode = hashCode8;
            return hashCode8;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m463newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.fiat_amount != null) {
            arrayList.add("fiat_amount=" + this.fiat_amount);
        }
        if (this.to_details != null) {
            arrayList.add("to_details=" + this.to_details);
        }
        if (this.from_account != null) {
            arrayList.add("from_account=" + this.from_account);
        }
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        if (!this.payment_methods.isEmpty()) {
            arrayList.add("payment_methods=" + this.payment_methods);
        }
        if (!this.fees.isEmpty()) {
            arrayList.add("fees=" + this.fees);
        }
        if (!this.user_warnings.isEmpty()) {
            arrayList.add("user_warnings=" + this.user_warnings);
        }
        if (this.quote_price != null) {
            arrayList.add("quote_price=" + this.quote_price);
        }
        if (this.total != null) {
            arrayList.add("total=" + this.total);
        }
        arrayList.add("note=" + b.c(this.note));
        arrayList.add("send_type=" + this.send_type);
        arrayList.add("on_chain_estimation=" + b.c(this.on_chain_estimation));
        arrayList.add("eligible_for_offchain=" + this.eligible_for_offchain);
        h0 = z.h0(arrayList, ", ", "CreateSendResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m463newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateSendResponse(String id, Amount amount, Amount amount2, ToDetails toDetails, Ref ref, Ref ref2, List<SendPaymentMethod> payment_methods, List<FeeDetails> fees, List<UserWarning> user_warnings, QuotePrice quotePrice, Amount amount3, String note, SendType send_type, String on_chain_estimation, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(payment_methods, "payment_methods");
        m.h(fees, "fees");
        m.h(user_warnings, "user_warnings");
        m.h(note, "note");
        m.h(send_type, "send_type");
        m.h(on_chain_estimation, "on_chain_estimation");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.amount = amount;
        this.fiat_amount = amount2;
        this.to_details = toDetails;
        this.from_account = ref;
        this.payment_method = ref2;
        this.payment_methods = payment_methods;
        this.fees = fees;
        this.user_warnings = user_warnings;
        this.quote_price = quotePrice;
        this.total = amount3;
        this.note = note;
        this.send_type = send_type;
        this.on_chain_estimation = on_chain_estimation;
        this.eligible_for_offchain = z;
    }
}