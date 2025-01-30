package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.Link;
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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: LoanEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB§\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u00ad\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010 \u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b.\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b/\u0010\u000fR\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00100\u001a\u0004\b1\u00102R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b3\u0010,R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u0019\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b7\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b8\u0010\u000fR\u001c\u0010\u001f\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b9\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b:\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b;\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b?\u0010\u000f¨\u0006C"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEvent;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEventType;", "type", "Lcom/google/protobuf/u;", "timestamp", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "loan_balance", "apr", MessageBundle.TITLE_ENTRY, "icon_url", ApiConstants.DESCRIPTION, ErrorBundle.SUMMARY_ENTRY, "Lcom/coinbase/android/apiv3/generated/common/Link;", "support_info", "context_id", "loan_id", "Lcom/coinbase/android/apiv3/generated/authed/loans/TransactionIdentifier;", "transaction_info", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEventType;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/TransactionIdentifier;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEvent;", "Lcom/google/protobuf/u;", "getTimestamp", "()Lcom/google/protobuf/u;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getLoan_id", "getIcon_url", "Lcom/coinbase/android/apiv3/generated/authed/loans/TransactionIdentifier;", "getTransaction_info", "()Lcom/coinbase/android/apiv3/generated/authed/loans/TransactionIdentifier;", "getLoan_balance", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEventType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEventType;", "getTitle", "getDescription", "getContext_id", "getId", "getSummary", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getSupport_info", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "getApr", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEventType;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/TransactionIdentifier;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoanEvent extends a {
    public static final ProtoAdapter<LoanEvent> ADAPTER;
    public static final Parcelable.Creator<LoanEvent> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 4)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String apr;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "contextId", tag = 12)
    private final String context_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 8)
    private final String icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "loanBalance", tag = 5)
    private final Amount loan_balance;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "loanId", tag = 13)
    private final String loan_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    private final String summary;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", jsonName = "supportInfo", tag = 11)
    private final Link support_info;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", tag = 3)
    private final u timestamp;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    private final String title;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.TransactionIdentifier#ADAPTER", jsonName = "transactionInfo", tag = 14)
    private final TransactionIdentifier transaction_info;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanEventType#ADAPTER", tag = 2)
    private final LoanEventType type;

    /* compiled from: LoanEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEvent$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEvent;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(LoanEvent.class);
        ProtoAdapter<LoanEvent> protoAdapter = new ProtoAdapter<LoanEvent>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loans.LoanEvent") { // from class: com.coinbase.android.apiv3.generated.authed.loans.LoanEvent$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoanEvent decode(k reader) {
                long j2;
                m.h(reader, "reader");
                LoanEventType loanEventType = LoanEventType.PAYMENT;
                long d2 = reader.d();
                LoanEventType loanEventType2 = loanEventType;
                u uVar = null;
                Amount amount = null;
                Amount amount2 = null;
                Link link = null;
                TransactionIdentifier transactionIdentifier = null;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoanEvent(str, loanEventType2, uVar, amount, amount2, str2, str3, str4, str5, str6, link, str7, str8, transactionIdentifier, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            j2 = d2;
                            str = ProtoAdapter.STRING.decode(reader);
                            continue;
                            d2 = j2;
                        case 2:
                            try {
                                loanEventType2 = LoanEventType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                j2 = d2;
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 3:
                            uVar = u.a.decode(reader);
                            break;
                        case 4:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 11:
                            link = Link.ADAPTER.decode(reader);
                            break;
                        case 12:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 14:
                            transactionIdentifier = TransactionIdentifier.ADAPTER.decode(reader);
                            break;
                        default:
                            j2 = d2;
                            reader.m(g2);
                            continue;
                            d2 = j2;
                    }
                    j2 = d2;
                    d2 = j2;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoanEvent value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (value.getType() != LoanEventType.PAYMENT) {
                    LoanEventType.ADAPTER.encodeWithTag(writer, 2, value.getType());
                }
                if (value.getTimestamp() != null) {
                    u.a.encodeWithTag(writer, 3, value.getTimestamp());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getAmount());
                }
                if (value.getLoan_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getLoan_balance());
                }
                if (!m.c(value.getApr(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getApr());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getTitle());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getIcon_url());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.getDescription());
                }
                if (!m.c(value.getSummary(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.getSummary());
                }
                if (value.getSupport_info() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 11, value.getSupport_info());
                }
                if (!m.c(value.getContext_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getContext_id());
                }
                if (!m.c(value.getLoan_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 13, value.getLoan_id());
                }
                if (value.getTransaction_info() != null) {
                    TransactionIdentifier.ADAPTER.encodeWithTag(writer, 14, value.getTransaction_info());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoanEvent value) {
                int encodedSizeWithTag;
                int i2;
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
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (value.getType() == LoanEventType.PAYMENT) {
                    i12 = 0;
                } else {
                    int encodedSizeWithTag3 = LoanEventType.ADAPTER.encodedSizeWithTag(2, value.getType());
                    if (value.getTimestamp() == null) {
                        i11 = 0;
                    } else {
                        int encodedSizeWithTag4 = u.a.encodedSizeWithTag(3, value.getTimestamp());
                        if (value.getAmount() == null) {
                            i10 = 0;
                        } else {
                            ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                            int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(4, value.getAmount());
                            if (value.getLoan_balance() == null) {
                                i9 = 0;
                            } else {
                                int encodedSizeWithTag6 = protoAdapter3.encodedSizeWithTag(5, value.getLoan_balance());
                                if (m.c(value.getApr(), "")) {
                                    i8 = 0;
                                } else {
                                    int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(6, value.getApr());
                                    if (m.c(value.getTitle(), "")) {
                                        i7 = 0;
                                    } else {
                                        int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(7, value.getTitle());
                                        if (m.c(value.getIcon_url(), "")) {
                                            i6 = 0;
                                        } else {
                                            int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(8, value.getIcon_url());
                                            if (m.c(value.getDescription(), "")) {
                                                i5 = 0;
                                            } else {
                                                int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(9, value.getDescription());
                                                if (m.c(value.getSummary(), "")) {
                                                    i4 = 0;
                                                } else {
                                                    int encodedSizeWithTag11 = protoAdapter2.encodedSizeWithTag(10, value.getSummary());
                                                    if (value.getSupport_info() == null) {
                                                        i3 = 0;
                                                    } else {
                                                        int encodedSizeWithTag12 = Link.ADAPTER.encodedSizeWithTag(11, value.getSupport_info());
                                                        if (m.c(value.getContext_id(), "")) {
                                                            i2 = 0;
                                                        } else {
                                                            int encodedSizeWithTag13 = protoAdapter2.encodedSizeWithTag(12, value.getContext_id());
                                                            if (m.c(value.getLoan_id(), "")) {
                                                                encodedSizeWithTag = 0;
                                                            } else {
                                                                encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(13, value.getLoan_id()) + (value.getTransaction_info() == null ? 0 : TransactionIdentifier.ADAPTER.encodedSizeWithTag(14, value.getTransaction_info()) + value.unknownFields().Q());
                                                            }
                                                            i2 = encodedSizeWithTag13 + encodedSizeWithTag;
                                                        }
                                                        i3 = encodedSizeWithTag12 + i2;
                                                    }
                                                    i4 = i3 + encodedSizeWithTag11;
                                                }
                                                i5 = i4 + encodedSizeWithTag10;
                                            }
                                            i6 = i5 + encodedSizeWithTag9;
                                        }
                                        i7 = i6 + encodedSizeWithTag8;
                                    }
                                    i8 = i7 + encodedSizeWithTag7;
                                }
                                i9 = i8 + encodedSizeWithTag6;
                            }
                            i10 = i9 + encodedSizeWithTag5;
                        }
                        i11 = i10 + encodedSizeWithTag4;
                    }
                    i12 = i11 + encodedSizeWithTag3;
                }
                return i12 + encodedSizeWithTag2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoanEvent redact(LoanEvent value) {
                LoanEvent copy;
                m.h(value, "value");
                u timestamp = value.getTimestamp();
                u redact = timestamp != null ? u.a.redact(timestamp) : null;
                Amount amount = value.getAmount();
                Amount redact2 = amount != null ? Amount.ADAPTER.redact(amount) : null;
                Amount loan_balance = value.getLoan_balance();
                Amount redact3 = loan_balance != null ? Amount.ADAPTER.redact(loan_balance) : null;
                Link support_info = value.getSupport_info();
                Link redact4 = support_info != null ? Link.ADAPTER.redact(support_info) : null;
                TransactionIdentifier transaction_info = value.getTransaction_info();
                copy = value.copy((r32 & 1) != 0 ? value.id : null, (r32 & 2) != 0 ? value.type : null, (r32 & 4) != 0 ? value.timestamp : redact, (r32 & 8) != 0 ? value.amount : redact2, (r32 & 16) != 0 ? value.loan_balance : redact3, (r32 & 32) != 0 ? value.apr : null, (r32 & 64) != 0 ? value.title : null, (r32 & 128) != 0 ? value.icon_url : null, (r32 & 256) != 0 ? value.description : null, (r32 & 512) != 0 ? value.summary : null, (r32 & 1024) != 0 ? value.support_info : redact4, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? value.context_id : null, (r32 & 4096) != 0 ? value.loan_id : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? value.transaction_info : transaction_info != null ? TransactionIdentifier.ADAPTER.redact(transaction_info) : null, (r32 & 16384) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoanEvent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public /* synthetic */ LoanEvent(String str, LoanEventType loanEventType, u uVar, Amount amount, Amount amount2, String str2, String str3, String str4, String str5, String str6, Link link, String str7, String str8, TransactionIdentifier transactionIdentifier, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? LoanEventType.PAYMENT : loanEventType, (i2 & 4) != 0 ? null : uVar, (i2 & 8) != 0 ? null : amount, (i2 & 16) != 0 ? null : amount2, (i2 & 32) != 0 ? "" : str2, (i2 & 64) != 0 ? "" : str3, (i2 & 128) != 0 ? "" : str4, (i2 & 256) != 0 ? "" : str5, (i2 & 512) != 0 ? "" : str6, (i2 & 1024) != 0 ? null : link, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? "" : str7, (i2 & 4096) == 0 ? str8 : "", (i2 & PKIFailureInfo.certRevoked) == 0 ? transactionIdentifier : null, (i2 & 16384) != 0 ? i.a : iVar);
    }

    public final LoanEvent copy(String id, LoanEventType type, u uVar, Amount amount, Amount amount2, String apr, String title, String icon_url, String description, String summary, Link link, String context_id, String loan_id, TransactionIdentifier transactionIdentifier, i unknownFields) {
        m.h(id, "id");
        m.h(type, "type");
        m.h(apr, "apr");
        m.h(title, "title");
        m.h(icon_url, "icon_url");
        m.h(description, "description");
        m.h(summary, "summary");
        m.h(context_id, "context_id");
        m.h(loan_id, "loan_id");
        m.h(unknownFields, "unknownFields");
        return new LoanEvent(id, type, uVar, amount, amount2, apr, title, icon_url, description, summary, link, context_id, loan_id, transactionIdentifier, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoanEvent) {
            LoanEvent loanEvent = (LoanEvent) obj;
            return m.c(unknownFields(), loanEvent.unknownFields()) && m.c(this.id, loanEvent.id) && this.type == loanEvent.type && m.c(this.timestamp, loanEvent.timestamp) && m.c(this.amount, loanEvent.amount) && m.c(this.loan_balance, loanEvent.loan_balance) && m.c(this.apr, loanEvent.apr) && m.c(this.title, loanEvent.title) && m.c(this.icon_url, loanEvent.icon_url) && m.c(this.description, loanEvent.description) && m.c(this.summary, loanEvent.summary) && m.c(this.support_info, loanEvent.support_info) && m.c(this.context_id, loanEvent.context_id) && m.c(this.loan_id, loanEvent.loan_id) && m.c(this.transaction_info, loanEvent.transaction_info);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getApr() {
        return this.apr;
    }

    public final String getContext_id() {
        return this.context_id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getId() {
        return this.id;
    }

    public final Amount getLoan_balance() {
        return this.loan_balance;
    }

    public final String getLoan_id() {
        return this.loan_id;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Link getSupport_info() {
        return this.support_info;
    }

    public final u getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TransactionIdentifier getTransaction_info() {
        return this.transaction_info;
    }

    public final LoanEventType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.type.hashCode()) * 37;
            u uVar = this.timestamp;
            int hashCode2 = (hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37;
            Amount amount = this.amount;
            int hashCode3 = (hashCode2 + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.loan_balance;
            int hashCode4 = (((((((((((hashCode3 + (amount2 != null ? amount2.hashCode() : 0)) * 37) + this.apr.hashCode()) * 37) + this.title.hashCode()) * 37) + this.icon_url.hashCode()) * 37) + this.description.hashCode()) * 37) + this.summary.hashCode()) * 37;
            Link link = this.support_info;
            int hashCode5 = (((((hashCode4 + (link != null ? link.hashCode() : 0)) * 37) + this.context_id.hashCode()) * 37) + this.loan_id.hashCode()) * 37;
            TransactionIdentifier transactionIdentifier = this.transaction_info;
            int hashCode6 = hashCode5 + (transactionIdentifier != null ? transactionIdentifier.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m372newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("type=" + this.type);
        if (this.timestamp != null) {
            arrayList.add("timestamp=" + this.timestamp);
        }
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.loan_balance != null) {
            arrayList.add("loan_balance=" + this.loan_balance);
        }
        arrayList.add("apr=" + b.c(this.apr));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("icon_url=" + b.c(this.icon_url));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("summary=" + b.c(this.summary));
        if (this.support_info != null) {
            arrayList.add("support_info=" + this.support_info);
        }
        arrayList.add("context_id=" + b.c(this.context_id));
        arrayList.add("loan_id=" + b.c(this.loan_id));
        if (this.transaction_info != null) {
            arrayList.add("transaction_info=" + this.transaction_info);
        }
        h0 = z.h0(arrayList, ", ", "LoanEvent{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m372newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoanEvent(String id, LoanEventType type, u uVar, Amount amount, Amount amount2, String apr, String title, String icon_url, String description, String summary, Link link, String context_id, String loan_id, TransactionIdentifier transactionIdentifier, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(type, "type");
        m.h(apr, "apr");
        m.h(title, "title");
        m.h(icon_url, "icon_url");
        m.h(description, "description");
        m.h(summary, "summary");
        m.h(context_id, "context_id");
        m.h(loan_id, "loan_id");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.type = type;
        this.timestamp = uVar;
        this.amount = amount;
        this.loan_balance = amount2;
        this.apr = apr;
        this.title = title;
        this.icon_url = icon_url;
        this.description = description;
        this.summary = summary;
        this.support_info = link;
        this.context_id = context_id;
        this.loan_id = loan_id;
        this.transaction_info = transactionIdentifier;
    }
}