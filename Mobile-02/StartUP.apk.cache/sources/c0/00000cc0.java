package com.coinbase.android.apiv3.generated.authed.loans;

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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: LoanStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00010BW\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010*R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusType;", "type", "label", "health_ratio", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusInfo;", "loan_status_infos", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusAlert;", "loan_status_alert", "Lcom/coinbase/android/apiv3/generated/common/Link;", "support_info", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusAlert;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "Ljava/lang/String;", "getLabel", "getHealth_ratio", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusType;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusAlert;", "getLoan_status_alert", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusAlert;", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getSupport_info", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "Ljava/util/List;", "getLoan_status_infos", "()Ljava/util/List;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatusAlert;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoanStatus extends a {
    public static final ProtoAdapter<LoanStatus> ADAPTER;
    public static final Parcelable.Creator<LoanStatus> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "healthRatio", tag = 3)
    private final String health_ratio;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String label;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatusAlert#ADAPTER", jsonName = "loanStatusAlert", tag = 5)
    private final LoanStatusAlert loan_status_alert;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatusInfo#ADAPTER", jsonName = "loanStatusInfos", label = p.a.REPEATED, tag = 4)
    private final List<LoanStatusInfo> loan_status_infos;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", jsonName = "supportInfo", tag = 6)
    private final Link support_info;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatusType#ADAPTER", tag = 1)
    private final LoanStatusType type;

    /* compiled from: LoanStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(LoanStatus.class);
        ProtoAdapter<LoanStatus> protoAdapter = new ProtoAdapter<LoanStatus>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loans.LoanStatus") { // from class: com.coinbase.android.apiv3.generated.authed.loans.LoanStatus$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoanStatus decode(k reader) {
                LoanStatusType loanStatusType;
                ProtoAdapter.EnumConstantNotFoundException e2;
                m.h(reader, "reader");
                LoanStatusType loanStatusType2 = LoanStatusType.EXCELLENT;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                LoanStatusAlert loanStatusAlert = null;
                Link link = null;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoanStatus(loanStatusType2, str2, str, arrayList, loanStatusAlert, link, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            try {
                                loanStatusType = LoanStatusType.ADAPTER.decode(reader);
                                try {
                                    x xVar = x.a;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                    e2 = e3;
                                    reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                    x xVar2 = x.a;
                                    loanStatusType2 = loanStatusType;
                                }
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                loanStatusType = loanStatusType2;
                                e2 = e4;
                            }
                            loanStatusType2 = loanStatusType;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            arrayList.add(LoanStatusInfo.ADAPTER.decode(reader));
                            break;
                        case 5:
                            loanStatusAlert = LoanStatusAlert.ADAPTER.decode(reader);
                            break;
                        case 6:
                            link = Link.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoanStatus value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != LoanStatusType.EXCELLENT) {
                    LoanStatusType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getLabel());
                }
                if (!m.c(value.getHealth_ratio(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getHealth_ratio());
                }
                LoanStatusInfo.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.getLoan_status_infos());
                if (value.getLoan_status_alert() != null) {
                    LoanStatusAlert.ADAPTER.encodeWithTag(writer, 5, value.getLoan_status_alert());
                }
                if (value.getSupport_info() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 6, value.getSupport_info());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoanStatus value) {
                m.h(value, "value");
                if (value.getType() == LoanStatusType.EXCELLENT) {
                    return 0;
                }
                int encodedSizeWithTag = LoanStatusType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getLabel());
                    if (!m.c(value.getHealth_ratio(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getHealth_ratio()) + LoanStatusInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, value.getLoan_status_infos());
                        if (value.getLoan_status_alert() != null) {
                            r2 = (value.getSupport_info() != null ? Link.ADAPTER.encodedSizeWithTag(6, value.getSupport_info()) + value.unknownFields().Q() : 0) + LoanStatusAlert.ADAPTER.encodedSizeWithTag(5, value.getLoan_status_alert());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoanStatus redact(LoanStatus value) {
                m.h(value, "value");
                List a = b.a(value.getLoan_status_infos(), LoanStatusInfo.ADAPTER);
                LoanStatusAlert loan_status_alert = value.getLoan_status_alert();
                LoanStatusAlert redact = loan_status_alert != null ? LoanStatusAlert.ADAPTER.redact(loan_status_alert) : null;
                Link support_info = value.getSupport_info();
                return LoanStatus.copy$default(value, null, null, null, a, redact, support_info != null ? Link.ADAPTER.redact(support_info) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoanStatus() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ LoanStatus(LoanStatusType loanStatusType, String str, String str2, List list, LoanStatusAlert loanStatusAlert, Link link, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? LoanStatusType.EXCELLENT : loanStatusType, (i2 & 2) != 0 ? "" : str, (i2 & 4) == 0 ? str2 : "", (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? null : loanStatusAlert, (i2 & 32) != 0 ? null : link, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoanStatus copy$default(LoanStatus loanStatus, LoanStatusType loanStatusType, String str, String str2, List list, LoanStatusAlert loanStatusAlert, Link link, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loanStatusType = loanStatus.type;
        }
        if ((i2 & 2) != 0) {
            str = loanStatus.label;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = loanStatus.health_ratio;
        }
        String str4 = str2;
        List<LoanStatusInfo> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = loanStatus.loan_status_infos;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            loanStatusAlert = loanStatus.loan_status_alert;
        }
        LoanStatusAlert loanStatusAlert2 = loanStatusAlert;
        if ((i2 & 32) != 0) {
            link = loanStatus.support_info;
        }
        Link link2 = link;
        if ((i2 & 64) != 0) {
            iVar = loanStatus.unknownFields();
        }
        return loanStatus.copy(loanStatusType, str3, str4, list3, loanStatusAlert2, link2, iVar);
    }

    public final LoanStatus copy(LoanStatusType type, String label, String health_ratio, List<LoanStatusInfo> loan_status_infos, LoanStatusAlert loanStatusAlert, Link link, i unknownFields) {
        m.h(type, "type");
        m.h(label, "label");
        m.h(health_ratio, "health_ratio");
        m.h(loan_status_infos, "loan_status_infos");
        m.h(unknownFields, "unknownFields");
        return new LoanStatus(type, label, health_ratio, loan_status_infos, loanStatusAlert, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoanStatus) {
            LoanStatus loanStatus = (LoanStatus) obj;
            return m.c(unknownFields(), loanStatus.unknownFields()) && this.type == loanStatus.type && m.c(this.label, loanStatus.label) && m.c(this.health_ratio, loanStatus.health_ratio) && m.c(this.loan_status_infos, loanStatus.loan_status_infos) && m.c(this.loan_status_alert, loanStatus.loan_status_alert) && m.c(this.support_info, loanStatus.support_info);
        }
        return false;
    }

    public final String getHealth_ratio() {
        return this.health_ratio;
    }

    public final String getLabel() {
        return this.label;
    }

    public final LoanStatusAlert getLoan_status_alert() {
        return this.loan_status_alert;
    }

    public final List<LoanStatusInfo> getLoan_status_infos() {
        return this.loan_status_infos;
    }

    public final Link getSupport_info() {
        return this.support_info;
    }

    public final LoanStatusType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.label.hashCode()) * 37) + this.health_ratio.hashCode()) * 37) + this.loan_status_infos.hashCode()) * 37;
            LoanStatusAlert loanStatusAlert = this.loan_status_alert;
            int hashCode2 = (hashCode + (loanStatusAlert != null ? loanStatusAlert.hashCode() : 0)) * 37;
            Link link = this.support_info;
            int hashCode3 = hashCode2 + (link != null ? link.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m375newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        arrayList.add("label=" + b.c(this.label));
        arrayList.add("health_ratio=" + b.c(this.health_ratio));
        if (!this.loan_status_infos.isEmpty()) {
            arrayList.add("loan_status_infos=" + this.loan_status_infos);
        }
        if (this.loan_status_alert != null) {
            arrayList.add("loan_status_alert=" + this.loan_status_alert);
        }
        if (this.support_info != null) {
            arrayList.add("support_info=" + this.support_info);
        }
        h0 = z.h0(arrayList, ", ", "LoanStatus{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m375newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoanStatus(LoanStatusType type, String label, String health_ratio, List<LoanStatusInfo> loan_status_infos, LoanStatusAlert loanStatusAlert, Link link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(label, "label");
        m.h(health_ratio, "health_ratio");
        m.h(loan_status_infos, "loan_status_infos");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.label = label;
        this.health_ratio = health_ratio;
        this.loan_status_infos = loan_status_infos;
        this.loan_status_alert = loanStatusAlert;
        this.support_info = link;
    }
}