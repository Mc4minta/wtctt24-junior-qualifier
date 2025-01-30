package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.FeeDetails;
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
import org.spongycastle.i18n.ErrorBundle;

/* compiled from: CommitAutopayResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B[\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJa\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\"\u0010!R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u001a\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "autopay_setting", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "autopay_option", "", "Lcom/coinbase/android/apiv3/generated/common/FeeDetails;", "fee_details", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "subtotal", ApiConstants.TOTAL, ErrorBundle.SUMMARY_ENTRY, "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getSubtotal", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getTotal", "Ljava/util/List;", "getFee_details", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "getAutopay_option", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "Ljava/lang/String;", "getSummary", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAutopay_setting", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CommitAutopayResponse extends a {
    public static final ProtoAdapter<CommitAutopayResponse> ADAPTER;
    public static final Parcelable.Creator<CommitAutopayResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopayOption#ADAPTER", jsonName = "autopayOption", tag = 2)
    private final AutopayOption autopay_option;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting#ADAPTER", jsonName = "autopaySetting", tag = 1)
    private final AutopaySetting autopay_setting;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.FeeDetails#ADAPTER", jsonName = "feeDetails", label = p.a.REPEATED, tag = 3)
    private final List<FeeDetails> fee_details;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 4)
    private final Amount subtotal;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String summary;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 5)
    private final Amount total;

    /* compiled from: CommitAutopayResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitAutopayResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CommitAutopayResponse> protoAdapter = new ProtoAdapter<CommitAutopayResponse>(c.LENGTH_DELIMITED, e0.b(CommitAutopayResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.CommitAutopayResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.CommitAutopayResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CommitAutopayResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                AutopaySetting autopaySetting = null;
                Amount amount = null;
                Amount amount2 = null;
                String str = "";
                AutopayOption autopayOption = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CommitAutopayResponse(autopaySetting, autopayOption, arrayList, amount, amount2, str, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            autopaySetting = AutopaySetting.ADAPTER.decode(reader);
                            break;
                        case 2:
                            autopayOption = AutopayOption.ADAPTER.decode(reader);
                            break;
                        case 3:
                            arrayList.add(FeeDetails.ADAPTER.decode(reader));
                            break;
                        case 4:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CommitAutopayResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAutopay_setting() != null) {
                    AutopaySetting.ADAPTER.encodeWithTag(writer, 1, value.getAutopay_setting());
                }
                if (value.getAutopay_option() != null) {
                    AutopayOption.ADAPTER.encodeWithTag(writer, 2, value.getAutopay_option());
                }
                FeeDetails.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getFee_details());
                if (value.getSubtotal() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getSubtotal());
                }
                if (value.getTotal() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getTotal());
                }
                if (!m.c(value.getSummary(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getSummary());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CommitAutopayResponse value) {
                m.h(value, "value");
                if (value.getAutopay_setting() == null) {
                    return 0;
                }
                int encodedSizeWithTag = AutopaySetting.ADAPTER.encodedSizeWithTag(1, value.getAutopay_setting());
                if (value.getAutopay_option() != null) {
                    int encodedSizeWithTag2 = AutopayOption.ADAPTER.encodedSizeWithTag(2, value.getAutopay_option()) + FeeDetails.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getFee_details());
                    if (value.getSubtotal() != null) {
                        ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(4, value.getSubtotal());
                        if (value.getTotal() != null) {
                            r1 = (m.c(value.getSummary(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(6, value.getSummary()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(5, value.getTotal());
                        }
                        r1 += encodedSizeWithTag3;
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CommitAutopayResponse redact(CommitAutopayResponse value) {
                m.h(value, "value");
                AutopaySetting autopay_setting = value.getAutopay_setting();
                AutopaySetting redact = autopay_setting != null ? AutopaySetting.ADAPTER.redact(autopay_setting) : null;
                AutopayOption autopay_option = value.getAutopay_option();
                AutopayOption redact2 = autopay_option != null ? AutopayOption.ADAPTER.redact(autopay_option) : null;
                List a = b.a(value.getFee_details(), FeeDetails.ADAPTER);
                Amount subtotal = value.getSubtotal();
                Amount redact3 = subtotal != null ? Amount.ADAPTER.redact(subtotal) : null;
                Amount total = value.getTotal();
                return CommitAutopayResponse.copy$default(value, redact, redact2, a, redact3, total != null ? Amount.ADAPTER.redact(total) : null, null, i.a, 32, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CommitAutopayResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ CommitAutopayResponse(AutopaySetting autopaySetting, AutopayOption autopayOption, List list, Amount amount, Amount amount2, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : autopaySetting, (i2 & 2) != 0 ? null : autopayOption, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) != 0 ? null : amount, (i2 & 16) == 0 ? amount2 : null, (i2 & 32) != 0 ? "" : str, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CommitAutopayResponse copy$default(CommitAutopayResponse commitAutopayResponse, AutopaySetting autopaySetting, AutopayOption autopayOption, List list, Amount amount, Amount amount2, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            autopaySetting = commitAutopayResponse.autopay_setting;
        }
        if ((i2 & 2) != 0) {
            autopayOption = commitAutopayResponse.autopay_option;
        }
        AutopayOption autopayOption2 = autopayOption;
        List<FeeDetails> list2 = list;
        if ((i2 & 4) != 0) {
            list2 = commitAutopayResponse.fee_details;
        }
        List list3 = list2;
        if ((i2 & 8) != 0) {
            amount = commitAutopayResponse.subtotal;
        }
        Amount amount3 = amount;
        if ((i2 & 16) != 0) {
            amount2 = commitAutopayResponse.total;
        }
        Amount amount4 = amount2;
        if ((i2 & 32) != 0) {
            str = commitAutopayResponse.summary;
        }
        String str2 = str;
        if ((i2 & 64) != 0) {
            iVar = commitAutopayResponse.unknownFields();
        }
        return commitAutopayResponse.copy(autopaySetting, autopayOption2, list3, amount3, amount4, str2, iVar);
    }

    public final CommitAutopayResponse copy(AutopaySetting autopaySetting, AutopayOption autopayOption, List<FeeDetails> fee_details, Amount amount, Amount amount2, String summary, i unknownFields) {
        m.h(fee_details, "fee_details");
        m.h(summary, "summary");
        m.h(unknownFields, "unknownFields");
        return new CommitAutopayResponse(autopaySetting, autopayOption, fee_details, amount, amount2, summary, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommitAutopayResponse) {
            CommitAutopayResponse commitAutopayResponse = (CommitAutopayResponse) obj;
            return m.c(unknownFields(), commitAutopayResponse.unknownFields()) && m.c(this.autopay_setting, commitAutopayResponse.autopay_setting) && m.c(this.autopay_option, commitAutopayResponse.autopay_option) && m.c(this.fee_details, commitAutopayResponse.fee_details) && m.c(this.subtotal, commitAutopayResponse.subtotal) && m.c(this.total, commitAutopayResponse.total) && m.c(this.summary, commitAutopayResponse.summary);
        }
        return false;
    }

    public final AutopayOption getAutopay_option() {
        return this.autopay_option;
    }

    public final AutopaySetting getAutopay_setting() {
        return this.autopay_setting;
    }

    public final List<FeeDetails> getFee_details() {
        return this.fee_details;
    }

    public final Amount getSubtotal() {
        return this.subtotal;
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
            int hashCode = unknownFields().hashCode() * 37;
            AutopaySetting autopaySetting = this.autopay_setting;
            int hashCode2 = (hashCode + (autopaySetting != null ? autopaySetting.hashCode() : 0)) * 37;
            AutopayOption autopayOption = this.autopay_option;
            int hashCode3 = (((hashCode2 + (autopayOption != null ? autopayOption.hashCode() : 0)) * 37) + this.fee_details.hashCode()) * 37;
            Amount amount = this.subtotal;
            int hashCode4 = (hashCode3 + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.total;
            int hashCode5 = ((hashCode4 + (amount2 != null ? amount2.hashCode() : 0)) * 37) + this.summary.hashCode();
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m341newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.autopay_setting != null) {
            arrayList.add("autopay_setting=" + this.autopay_setting);
        }
        if (this.autopay_option != null) {
            arrayList.add("autopay_option=" + this.autopay_option);
        }
        if (!this.fee_details.isEmpty()) {
            arrayList.add("fee_details=" + this.fee_details);
        }
        if (this.subtotal != null) {
            arrayList.add("subtotal=" + this.subtotal);
        }
        if (this.total != null) {
            arrayList.add("total=" + this.total);
        }
        arrayList.add("summary=" + b.c(this.summary));
        h0 = z.h0(arrayList, ", ", "CommitAutopayResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m341newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitAutopayResponse(AutopaySetting autopaySetting, AutopayOption autopayOption, List<FeeDetails> fee_details, Amount amount, Amount amount2, String summary, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(fee_details, "fee_details");
        m.h(summary, "summary");
        m.h(unknownFields, "unknownFields");
        this.autopay_setting = autopaySetting;
        this.autopay_option = autopayOption;
        this.fee_details = fee_details;
        this.subtotal = amount;
        this.total = amount2;
        this.summary = summary;
    }
}