package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.FeeDetails;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.coinbase.android.apiv3.generated.common.UserWarning;
import com.google.protobuf.u;
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
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: CommitSendResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 M2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MBÙ\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a\u0012\b\b\u0002\u0010!\u001a\u00020\r\u0012\b\b\u0002\u0010\"\u001a\u00020\r\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\r\u0012\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJß\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\r2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,R\u001c\u0010\"\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010-\u001a\u0004\b.\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b/\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b1\u00102R\u001e\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00103\u001a\u0004\b4\u00105R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00106\u001a\u0004\b7\u00108R\u001c\u0010'\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00109\u001a\u0004\b:\u0010;R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00106\u001a\u0004\b<\u00108R\u001c\u0010#\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010-\u001a\u0004\b=\u0010\u000fR\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010&\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010-\u001a\u0004\bA\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010B\u001a\u0004\bC\u0010DR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010>\u001a\u0004\bE\u0010@R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\bF\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010B\u001a\u0004\bG\u0010DR\u001c\u0010(\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010-\u001a\u0004\bH\u0010\u000fR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\bI\u0010@R\u001c\u0010!\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\bJ\u0010\u000f¨\u0006N"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "status", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "fiat_amount", "Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "to_details", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "from_account", "payment_method", "", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "payment_methods", "Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "fees", "Lcom/coinbase/android/apiv3/generated/common/UserWarning;", "user_warnings", "note", "status_description", ApiConstants.DESCRIPTION, "Lcom/google/protobuf/u;", "timestamp", "header", "cancelable", "health", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/protobuf/u;Ljava/lang/String;ZLjava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendResponse;", "Ljava/lang/String;", "getStatus_description", "getStatus", "Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "getTo_details", "()Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "Lcom/google/protobuf/u;", "getTimestamp", "()Lcom/google/protobuf/u;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getFiat_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Z", "getCancelable", "()Z", "getAmount", "getDescription", "Ljava/util/List;", "getFees", "()Ljava/util/List;", "getHeader", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getFrom_account", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "getPayment_methods", "getId", "getPayment_method", "getHealth", "getUser_warnings", "getNote", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/protobuf/u;Ljava/lang/String;ZLjava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CommitSendResponse extends a {
    public static final ProtoAdapter<CommitSendResponse> ADAPTER;
    public static final Parcelable.Creator<CommitSendResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 3)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    private final boolean cancelable;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.FeeDetails#ADAPTER", label = p.a.REPEATED, tag = 9)
    private final List<FeeDetails> fees;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "fiatAmount", tag = 4)
    private final Amount fiat_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "fromAccount", tag = 6)
    private final Ref from_account;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    private final String header;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    private final String health;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    private final String note;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "paymentMethod", tag = 7)
    private final Ref payment_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.SendPaymentMethod#ADAPTER", jsonName = "paymentMethods", label = p.a.REPEATED, tag = 8)
    private final List<SendPaymentMethod> payment_methods;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String status;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "statusDescription", tag = 12)
    private final String status_description;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", tag = 14)
    private final u timestamp;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.ToDetails#ADAPTER", jsonName = "toDetails", tag = 5)
    private final ToDetails to_details;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.UserWarning#ADAPTER", jsonName = "userWarnings", label = p.a.REPEATED, tag = 10)
    private final List<UserWarning> user_warnings;

    /* compiled from: CommitSendResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(CommitSendResponse.class);
        ProtoAdapter<CommitSendResponse> protoAdapter = new ProtoAdapter<CommitSendResponse>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.CommitSendResponse") { // from class: com.coinbase.android.apiv3.generated.authed.sends.CommitSendResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CommitSendResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                long d2 = reader.d();
                String str = "";
                Amount amount = null;
                ToDetails toDetails = null;
                Ref ref = null;
                Ref ref2 = null;
                u uVar = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                boolean z = false;
                Amount amount2 = null;
                String str7 = str6;
                while (true) {
                    int g2 = reader.g();
                    String str8 = str3;
                    if (g2 == -1) {
                        return new CommitSendResponse(str7, str, amount2, amount, toDetails, ref, ref2, arrayList, arrayList2, arrayList3, str2, str8, str6, uVar, str4, z, str5, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            toDetails = ToDetails.ADAPTER.decode(reader);
                            break;
                        case 6:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        case 7:
                            ref2 = Ref.ADAPTER.decode(reader);
                            break;
                        case 8:
                            arrayList.add(SendPaymentMethod.ADAPTER.decode(reader));
                            break;
                        case 9:
                            arrayList2.add(FeeDetails.ADAPTER.decode(reader));
                            break;
                        case 10:
                            arrayList3.add(UserWarning.ADAPTER.decode(reader));
                            break;
                        case 11:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 12:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 13:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 14:
                            uVar = u.a.decode(reader);
                            break;
                        case 15:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 16:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        case 17:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                    str3 = str8;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CommitSendResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getStatus(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getStatus());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getAmount());
                }
                if (value.getFiat_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getFiat_amount());
                }
                if (value.getTo_details() != null) {
                    ToDetails.ADAPTER.encodeWithTag(writer, 5, value.getTo_details());
                }
                if (value.getFrom_account() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 6, value.getFrom_account());
                }
                if (value.getPayment_method() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 7, value.getPayment_method());
                }
                SendPaymentMethod.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.getPayment_methods());
                FeeDetails.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.getFees());
                UserWarning.ADAPTER.asRepeated().encodeWithTag(writer, 10, value.getUser_warnings());
                if (!m.c(value.getNote(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 11, value.getNote());
                }
                if (!m.c(value.getStatus_description(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getStatus_description());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 13, value.getDescription());
                }
                if (value.getTimestamp() != null) {
                    u.a.encodeWithTag(writer, 14, value.getTimestamp());
                }
                if (!m.c(value.getHeader(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 15, value.getHeader());
                }
                if (value.getCancelable()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 16, Boolean.valueOf(value.getCancelable()));
                }
                if (!m.c(value.getHealth(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 17, value.getHealth());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CommitSendResponse value) {
                int i2;
                int encodedSizeWithTag;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (m.c(value.getStatus(), "")) {
                    i2 = encodedSizeWithTag2;
                    i13 = 0;
                } else {
                    int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(2, value.getStatus());
                    if (value.getAmount() == null) {
                        i2 = encodedSizeWithTag2;
                        i12 = 0;
                    } else {
                        ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                        int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(3, value.getAmount());
                        if (value.getFiat_amount() == null) {
                            i2 = encodedSizeWithTag2;
                            i11 = 0;
                        } else {
                            int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(4, value.getFiat_amount());
                            if (value.getTo_details() == null) {
                                i2 = encodedSizeWithTag2;
                                i10 = 0;
                            } else {
                                int encodedSizeWithTag6 = ToDetails.ADAPTER.encodedSizeWithTag(5, value.getTo_details());
                                if (value.getFrom_account() == null) {
                                    i2 = encodedSizeWithTag2;
                                    i9 = 0;
                                } else {
                                    ProtoAdapter<Ref> protoAdapter4 = Ref.ADAPTER;
                                    int encodedSizeWithTag7 = protoAdapter4.encodedSizeWithTag(6, value.getFrom_account());
                                    if (value.getPayment_method() == null) {
                                        i2 = encodedSizeWithTag2;
                                        i8 = 0;
                                    } else {
                                        int encodedSizeWithTag8 = protoAdapter4.encodedSizeWithTag(7, value.getPayment_method()) + SendPaymentMethod.ADAPTER.asRepeated().encodedSizeWithTag(8, value.getPayment_methods()) + FeeDetails.ADAPTER.asRepeated().encodedSizeWithTag(9, value.getFees()) + UserWarning.ADAPTER.asRepeated().encodedSizeWithTag(10, value.getUser_warnings());
                                        if (m.c(value.getNote(), "")) {
                                            i2 = encodedSizeWithTag2;
                                            i7 = 0;
                                        } else {
                                            int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(11, value.getNote());
                                            if (m.c(value.getStatus_description(), "")) {
                                                i2 = encodedSizeWithTag2;
                                                i6 = 0;
                                            } else {
                                                int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(12, value.getStatus_description());
                                                if (m.c(value.getDescription(), "")) {
                                                    i2 = encodedSizeWithTag2;
                                                    i5 = 0;
                                                } else {
                                                    int encodedSizeWithTag11 = protoAdapter2.encodedSizeWithTag(13, value.getDescription());
                                                    if (value.getTimestamp() == null) {
                                                        i2 = encodedSizeWithTag2;
                                                        i4 = 0;
                                                    } else {
                                                        int encodedSizeWithTag12 = u.a.encodedSizeWithTag(14, value.getTimestamp());
                                                        if (m.c(value.getHeader(), "")) {
                                                            i2 = encodedSizeWithTag2;
                                                            i3 = 0;
                                                        } else {
                                                            int encodedSizeWithTag13 = protoAdapter2.encodedSizeWithTag(15, value.getHeader());
                                                            if (value.getCancelable()) {
                                                                i2 = encodedSizeWithTag2;
                                                                encodedSizeWithTag = (m.c(value.getHealth(), "") ? 0 : protoAdapter2.encodedSizeWithTag(17, value.getHealth()) + value.unknownFields().Q()) + ProtoAdapter.BOOL.encodedSizeWithTag(16, Boolean.valueOf(value.getCancelable()));
                                                            } else {
                                                                i2 = encodedSizeWithTag2;
                                                                encodedSizeWithTag = 0;
                                                            }
                                                            i3 = encodedSizeWithTag13 + encodedSizeWithTag;
                                                        }
                                                        i4 = encodedSizeWithTag12 + i3;
                                                    }
                                                    i5 = i4 + encodedSizeWithTag11;
                                                }
                                                i6 = i5 + encodedSizeWithTag10;
                                            }
                                            i7 = i6 + encodedSizeWithTag9;
                                        }
                                        i8 = i7 + encodedSizeWithTag8;
                                    }
                                    i9 = i8 + encodedSizeWithTag7;
                                }
                                i10 = i9 + encodedSizeWithTag6;
                            }
                            i11 = i10 + encodedSizeWithTag5;
                        }
                        i12 = i11 + encodedSizeWithTag4;
                    }
                    i13 = i12 + encodedSizeWithTag3;
                }
                return i2 + i13;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CommitSendResponse redact(CommitSendResponse value) {
                CommitSendResponse copy;
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
                u timestamp = value.getTimestamp();
                copy = value.copy((r36 & 1) != 0 ? value.id : null, (r36 & 2) != 0 ? value.status : null, (r36 & 4) != 0 ? value.amount : redact, (r36 & 8) != 0 ? value.fiat_amount : redact2, (r36 & 16) != 0 ? value.to_details : redact3, (r36 & 32) != 0 ? value.from_account : redact4, (r36 & 64) != 0 ? value.payment_method : redact5, (r36 & 128) != 0 ? value.payment_methods : a, (r36 & 256) != 0 ? value.fees : a2, (r36 & 512) != 0 ? value.user_warnings : a3, (r36 & 1024) != 0 ? value.note : null, (r36 & PKIFailureInfo.wrongIntegrity) != 0 ? value.status_description : null, (r36 & 4096) != 0 ? value.description : null, (r36 & PKIFailureInfo.certRevoked) != 0 ? value.timestamp : timestamp != null ? u.a.redact(timestamp) : null, (r36 & 16384) != 0 ? value.header : null, (r36 & 32768) != 0 ? value.cancelable : false, (r36 & 65536) != 0 ? value.health : null, (r36 & PKIFailureInfo.unsupportedVersion) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CommitSendResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 262143, null);
    }

    public /* synthetic */ CommitSendResponse(String str, String str2, Amount amount, Amount amount2, ToDetails toDetails, Ref ref, Ref ref2, List list, List list2, List list3, String str3, String str4, String str5, u uVar, String str6, boolean z, String str7, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : amount, (i2 & 8) != 0 ? null : amount2, (i2 & 16) != 0 ? null : toDetails, (i2 & 32) != 0 ? null : ref, (i2 & 64) != 0 ? null : ref2, (i2 & 128) != 0 ? r.g() : list, (i2 & 256) != 0 ? r.g() : list2, (i2 & 512) != 0 ? r.g() : list3, (i2 & 1024) != 0 ? "" : str3, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? "" : str4, (i2 & 4096) != 0 ? "" : str5, (i2 & PKIFailureInfo.certRevoked) != 0 ? null : uVar, (i2 & 16384) != 0 ? "" : str6, (i2 & 32768) != 0 ? false : z, (i2 & 65536) != 0 ? "" : str7, (i2 & PKIFailureInfo.unsupportedVersion) != 0 ? i.a : iVar);
    }

    public final CommitSendResponse copy(String id, String status, Amount amount, Amount amount2, ToDetails toDetails, Ref ref, Ref ref2, List<SendPaymentMethod> payment_methods, List<FeeDetails> fees, List<UserWarning> user_warnings, String note, String status_description, String description, u uVar, String header, boolean z, String health, i unknownFields) {
        m.h(id, "id");
        m.h(status, "status");
        m.h(payment_methods, "payment_methods");
        m.h(fees, "fees");
        m.h(user_warnings, "user_warnings");
        m.h(note, "note");
        m.h(status_description, "status_description");
        m.h(description, "description");
        m.h(header, "header");
        m.h(health, "health");
        m.h(unknownFields, "unknownFields");
        return new CommitSendResponse(id, status, amount, amount2, toDetails, ref, ref2, payment_methods, fees, user_warnings, note, status_description, description, uVar, header, z, health, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommitSendResponse) {
            CommitSendResponse commitSendResponse = (CommitSendResponse) obj;
            return m.c(unknownFields(), commitSendResponse.unknownFields()) && m.c(this.id, commitSendResponse.id) && m.c(this.status, commitSendResponse.status) && m.c(this.amount, commitSendResponse.amount) && m.c(this.fiat_amount, commitSendResponse.fiat_amount) && m.c(this.to_details, commitSendResponse.to_details) && m.c(this.from_account, commitSendResponse.from_account) && m.c(this.payment_method, commitSendResponse.payment_method) && m.c(this.payment_methods, commitSendResponse.payment_methods) && m.c(this.fees, commitSendResponse.fees) && m.c(this.user_warnings, commitSendResponse.user_warnings) && m.c(this.note, commitSendResponse.note) && m.c(this.status_description, commitSendResponse.status_description) && m.c(this.description, commitSendResponse.description) && m.c(this.timestamp, commitSendResponse.timestamp) && m.c(this.header, commitSendResponse.header) && this.cancelable == commitSendResponse.cancelable && m.c(this.health, commitSendResponse.health);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final String getDescription() {
        return this.description;
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

    public final String getHeader() {
        return this.header;
    }

    public final String getHealth() {
        return this.health;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNote() {
        return this.note;
    }

    public final Ref getPayment_method() {
        return this.payment_method;
    }

    public final List<SendPaymentMethod> getPayment_methods() {
        return this.payment_methods;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatus_description() {
        return this.status_description;
    }

    public final u getTimestamp() {
        return this.timestamp;
    }

    public final ToDetails getTo_details() {
        return this.to_details;
    }

    public final List<UserWarning> getUser_warnings() {
        return this.user_warnings;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.status.hashCode()) * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.fiat_amount;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            ToDetails toDetails = this.to_details;
            int hashCode4 = (hashCode3 + (toDetails != null ? toDetails.hashCode() : 0)) * 37;
            Ref ref = this.from_account;
            int hashCode5 = (hashCode4 + (ref != null ? ref.hashCode() : 0)) * 37;
            Ref ref2 = this.payment_method;
            int hashCode6 = (((((((((((((hashCode5 + (ref2 != null ? ref2.hashCode() : 0)) * 37) + this.payment_methods.hashCode()) * 37) + this.fees.hashCode()) * 37) + this.user_warnings.hashCode()) * 37) + this.note.hashCode()) * 37) + this.status_description.hashCode()) * 37) + this.description.hashCode()) * 37;
            u uVar = this.timestamp;
            int hashCode7 = ((((((hashCode6 + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.header.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.cancelable)) * 37) + this.health.hashCode();
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m460newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("status=" + b.c(this.status));
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
        arrayList.add("note=" + b.c(this.note));
        arrayList.add("status_description=" + b.c(this.status_description));
        arrayList.add("description=" + b.c(this.description));
        if (this.timestamp != null) {
            arrayList.add("timestamp=" + this.timestamp);
        }
        arrayList.add("header=" + b.c(this.header));
        arrayList.add("cancelable=" + this.cancelable);
        arrayList.add("health=" + b.c(this.health));
        h0 = z.h0(arrayList, ", ", "CommitSendResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m460newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitSendResponse(String id, String status, Amount amount, Amount amount2, ToDetails toDetails, Ref ref, Ref ref2, List<SendPaymentMethod> payment_methods, List<FeeDetails> fees, List<UserWarning> user_warnings, String note, String status_description, String description, u uVar, String header, boolean z, String health, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(status, "status");
        m.h(payment_methods, "payment_methods");
        m.h(fees, "fees");
        m.h(user_warnings, "user_warnings");
        m.h(note, "note");
        m.h(status_description, "status_description");
        m.h(description, "description");
        m.h(header, "header");
        m.h(health, "health");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.fiat_amount = amount2;
        this.to_details = toDetails;
        this.from_account = ref;
        this.payment_method = ref2;
        this.payment_methods = payment_methods;
        this.fees = fees;
        this.user_warnings = user_warnings;
        this.note = note;
        this.status_description = status_description;
        this.description = description;
        this.timestamp = uVar;
        this.header = header;
        this.cancelable = z;
        this.health = health;
    }
}