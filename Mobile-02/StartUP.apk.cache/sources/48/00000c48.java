package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import org.spongycastle.asn1.eac.EACTags;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: AutopayOption.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-BY\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ_\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b)\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b*\u0010\u000f¨\u0006."}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;", "type", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", MessageBundle.TITLE_ENTRY, "label", ErrorBundle.SUMMARY_ENTRY, ApiConstants.DESCRIPTION, "recommended", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getLabel", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;", "getDescription", "Z", "getRecommended", "()Z", "getSummary", "getTitle", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayType;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AutopayOption extends a {
    public static final ProtoAdapter<AutopayOption> ADAPTER;
    public static final Parcelable.Creator<AutopayOption> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 2)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    private final boolean recommended;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String summary;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String title;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopayType#ADAPTER", tag = 1)
    private final AutopayType type;

    /* compiled from: AutopayOption.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayOption;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AutopayOption> protoAdapter = new ProtoAdapter<AutopayOption>(c.LENGTH_DELIMITED, e0.b(AutopayOption.class), "type.googleapis.com/coinbase.public_api.authed.loans.AutopayOption") { // from class: com.coinbase.android.apiv3.generated.authed.loans.AutopayOption$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AutopayOption decode(k reader) {
                m.h(reader, "reader");
                AutopayType autopayType = AutopayType.NONE;
                long d2 = reader.d();
                AutopayType autopayType2 = autopayType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                Amount amount = null;
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AutopayOption(autopayType2, amount, str, str2, str3, str4, z, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            try {
                                autopayType2 = AutopayType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 2:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AutopayOption value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != AutopayType.NONE) {
                    AutopayType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getAmount());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTitle());
                }
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getLabel());
                }
                if (!m.c(value.getSummary(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getSummary());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getDescription());
                }
                if (value.getRecommended()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 7, Boolean.valueOf(value.getRecommended()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AutopayOption value) {
                m.h(value, "value");
                if (value.getType() == AutopayType.NONE) {
                    return 0;
                }
                int encodedSizeWithTag = AutopayType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (value.getAmount() != null) {
                    int encodedSizeWithTag2 = Amount.ADAPTER.encodedSizeWithTag(2, value.getAmount());
                    if (!m.c(value.getTitle(), "")) {
                        ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getTitle());
                        if (!m.c(value.getLabel(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getLabel());
                            if (!m.c(value.getSummary(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getSummary());
                                if (!m.c(value.getDescription(), "")) {
                                    r2 = (value.getRecommended() ? ProtoAdapter.BOOL.encodedSizeWithTag(7, Boolean.valueOf(value.getRecommended())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(6, value.getDescription());
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
            public AutopayOption redact(AutopayOption value) {
                m.h(value, "value");
                Amount amount = value.getAmount();
                return AutopayOption.copy$default(value, null, amount != null ? Amount.ADAPTER.redact(amount) : null, null, null, null, null, false, i.a, EACTags.SECURE_MESSAGING_TEMPLATE, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AutopayOption() {
        this(null, null, null, null, null, null, false, null, 255, null);
    }

    public /* synthetic */ AutopayOption(AutopayType autopayType, Amount amount, String str, String str2, String str3, String str4, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? AutopayType.NONE : autopayType, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) == 0 ? str4 : "", (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AutopayOption copy$default(AutopayOption autopayOption, AutopayType autopayType, Amount amount, String str, String str2, String str3, String str4, boolean z, i iVar, int i2, Object obj) {
        return autopayOption.copy((i2 & 1) != 0 ? autopayOption.type : autopayType, (i2 & 2) != 0 ? autopayOption.amount : amount, (i2 & 4) != 0 ? autopayOption.title : str, (i2 & 8) != 0 ? autopayOption.label : str2, (i2 & 16) != 0 ? autopayOption.summary : str3, (i2 & 32) != 0 ? autopayOption.description : str4, (i2 & 64) != 0 ? autopayOption.recommended : z, (i2 & 128) != 0 ? autopayOption.unknownFields() : iVar);
    }

    public final AutopayOption copy(AutopayType type, Amount amount, String title, String label, String summary, String description, boolean z, i unknownFields) {
        m.h(type, "type");
        m.h(title, "title");
        m.h(label, "label");
        m.h(summary, "summary");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        return new AutopayOption(type, amount, title, label, summary, description, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutopayOption) {
            AutopayOption autopayOption = (AutopayOption) obj;
            return m.c(unknownFields(), autopayOption.unknownFields()) && this.type == autopayOption.type && m.c(this.amount, autopayOption.amount) && m.c(this.title, autopayOption.title) && m.c(this.label, autopayOption.label) && m.c(this.summary, autopayOption.summary) && m.c(this.description, autopayOption.description) && this.recommended == autopayOption.recommended;
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getRecommended() {
        return this.recommended;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public final AutopayType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37;
            Amount amount = this.amount;
            int hashCode2 = ((((((((((hashCode + (amount != null ? amount.hashCode() : 0)) * 37) + this.title.hashCode()) * 37) + this.label.hashCode()) * 37) + this.summary.hashCode()) * 37) + this.description.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.recommended);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m338newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("label=" + b.c(this.label));
        arrayList.add("summary=" + b.c(this.summary));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("recommended=" + this.recommended);
        h0 = z.h0(arrayList, ", ", "AutopayOption{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m338newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutopayOption(AutopayType type, Amount amount, String title, String label, String summary, String description, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(title, "title");
        m.h(label, "label");
        m.h(summary, "summary");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.amount = amount;
        this.title = title;
        this.label = label;
        this.summary = summary;
        this.description = description;
        this.recommended = z;
    }
}