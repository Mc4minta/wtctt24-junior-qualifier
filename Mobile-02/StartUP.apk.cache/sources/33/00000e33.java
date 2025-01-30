package com.coinbase.android.apiv3.generated.authed.transaction_limits;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: Limit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/Bu\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ{\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b&\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b'\u0010!R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b+\u0010!R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b,\u0010!¨\u00060"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/transaction_limits/Limit;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "action", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "maximum_fiat", "maximum_crypto", "remaining_fiat", "remaining_crypto", "fiat_max_label", "crypto_max_label", "max_summary", "Lcom/coinbase/android/apiv3/generated/common/Link;", "support_info", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/transaction_limits/Limit;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getRemaining_crypto", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getFiat_max_label", "getMax_summary", "getCrypto_max_label", "getAction", "getMaximum_crypto", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getSupport_info", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "getMaximum_fiat", "getRemaining_fiat", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Limit extends a {
    public static final ProtoAdapter<Limit> ADAPTER;
    public static final Parcelable.Creator<Limit> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String action;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cryptoMaxLabel", tag = 7)
    private final String crypto_max_label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "fiatMaxLabel", tag = 6)
    private final String fiat_max_label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "maxSummary", tag = 8)
    private final String max_summary;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "maximumCrypto", tag = 3)
    private final Amount maximum_crypto;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "maximumFiat", tag = 2)
    private final Amount maximum_fiat;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "remainingCrypto", tag = 5)
    private final Amount remaining_crypto;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "remainingFiat", tag = 4)
    private final Amount remaining_fiat;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", jsonName = "supportInfo", tag = 9)
    private final Link support_info;

    /* compiled from: Limit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/transaction_limits/Limit$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/transaction_limits/Limit;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Limit.class);
        ProtoAdapter<Limit> protoAdapter = new ProtoAdapter<Limit>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.transaction_limits.Limit") { // from class: com.coinbase.android.apiv3.generated.authed.transaction_limits.Limit$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Limit decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                Amount amount4 = null;
                Link link = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Limit(str, amount, amount2, amount3, amount4, str2, str3, str4, link, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount4 = Amount.ADAPTER.decode(reader);
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
                            link = Link.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Limit value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAction(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAction());
                }
                if (value.getMaximum_fiat() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getMaximum_fiat());
                }
                if (value.getMaximum_crypto() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getMaximum_crypto());
                }
                if (value.getRemaining_fiat() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getRemaining_fiat());
                }
                if (value.getRemaining_crypto() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getRemaining_crypto());
                }
                if (!m.c(value.getFiat_max_label(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getFiat_max_label());
                }
                if (!m.c(value.getCrypto_max_label(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getCrypto_max_label());
                }
                if (!m.c(value.getMax_summary(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getMax_summary());
                }
                if (value.getSupport_info() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 9, value.getSupport_info());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Limit value) {
                m.h(value, "value");
                if (m.c(value.getAction(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getAction());
                if (value.getMaximum_fiat() != null) {
                    ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, value.getMaximum_fiat());
                    if (value.getMaximum_crypto() != null) {
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getMaximum_crypto());
                        if (value.getRemaining_fiat() != null) {
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(4, value.getRemaining_fiat());
                            if (value.getRemaining_crypto() != null) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getRemaining_crypto());
                                if (!m.c(value.getFiat_max_label(), "")) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getFiat_max_label());
                                    if (!m.c(value.getCrypto_max_label(), "")) {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getCrypto_max_label());
                                        if (!m.c(value.getMax_summary(), "")) {
                                            r2 = (value.getSupport_info() != null ? Link.ADAPTER.encodedSizeWithTag(9, value.getSupport_info()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(8, value.getMax_summary());
                                        }
                                        r2 += encodedSizeWithTag7;
                                    }
                                    r2 += encodedSizeWithTag6;
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
            public Limit redact(Limit value) {
                Limit copy;
                m.h(value, "value");
                Amount maximum_fiat = value.getMaximum_fiat();
                Amount redact = maximum_fiat != null ? Amount.ADAPTER.redact(maximum_fiat) : null;
                Amount maximum_crypto = value.getMaximum_crypto();
                Amount redact2 = maximum_crypto != null ? Amount.ADAPTER.redact(maximum_crypto) : null;
                Amount remaining_fiat = value.getRemaining_fiat();
                Amount redact3 = remaining_fiat != null ? Amount.ADAPTER.redact(remaining_fiat) : null;
                Amount remaining_crypto = value.getRemaining_crypto();
                Amount redact4 = remaining_crypto != null ? Amount.ADAPTER.redact(remaining_crypto) : null;
                Link support_info = value.getSupport_info();
                copy = value.copy((r22 & 1) != 0 ? value.action : null, (r22 & 2) != 0 ? value.maximum_fiat : redact, (r22 & 4) != 0 ? value.maximum_crypto : redact2, (r22 & 8) != 0 ? value.remaining_fiat : redact3, (r22 & 16) != 0 ? value.remaining_crypto : redact4, (r22 & 32) != 0 ? value.fiat_max_label : null, (r22 & 64) != 0 ? value.crypto_max_label : null, (r22 & 128) != 0 ? value.max_summary : null, (r22 & 256) != 0 ? value.support_info : support_info != null ? Link.ADAPTER.redact(support_info) : null, (r22 & 512) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Limit() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ Limit(String str, Amount amount, Amount amount2, Amount amount3, Amount amount4, String str2, String str3, String str4, Link link, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : amount2, (i2 & 8) != 0 ? null : amount3, (i2 & 16) != 0 ? null : amount4, (i2 & 32) != 0 ? "" : str2, (i2 & 64) != 0 ? "" : str3, (i2 & 128) == 0 ? str4 : "", (i2 & 256) == 0 ? link : null, (i2 & 512) != 0 ? i.a : iVar);
    }

    public final Limit copy(String action, Amount amount, Amount amount2, Amount amount3, Amount amount4, String fiat_max_label, String crypto_max_label, String max_summary, Link link, i unknownFields) {
        m.h(action, "action");
        m.h(fiat_max_label, "fiat_max_label");
        m.h(crypto_max_label, "crypto_max_label");
        m.h(max_summary, "max_summary");
        m.h(unknownFields, "unknownFields");
        return new Limit(action, amount, amount2, amount3, amount4, fiat_max_label, crypto_max_label, max_summary, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Limit) {
            Limit limit = (Limit) obj;
            return m.c(unknownFields(), limit.unknownFields()) && m.c(this.action, limit.action) && m.c(this.maximum_fiat, limit.maximum_fiat) && m.c(this.maximum_crypto, limit.maximum_crypto) && m.c(this.remaining_fiat, limit.remaining_fiat) && m.c(this.remaining_crypto, limit.remaining_crypto) && m.c(this.fiat_max_label, limit.fiat_max_label) && m.c(this.crypto_max_label, limit.crypto_max_label) && m.c(this.max_summary, limit.max_summary) && m.c(this.support_info, limit.support_info);
        }
        return false;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getCrypto_max_label() {
        return this.crypto_max_label;
    }

    public final String getFiat_max_label() {
        return this.fiat_max_label;
    }

    public final String getMax_summary() {
        return this.max_summary;
    }

    public final Amount getMaximum_crypto() {
        return this.maximum_crypto;
    }

    public final Amount getMaximum_fiat() {
        return this.maximum_fiat;
    }

    public final Amount getRemaining_crypto() {
        return this.remaining_crypto;
    }

    public final Amount getRemaining_fiat() {
        return this.remaining_fiat;
    }

    public final Link getSupport_info() {
        return this.support_info;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.action.hashCode()) * 37;
            Amount amount = this.maximum_fiat;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.maximum_crypto;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.remaining_fiat;
            int hashCode4 = (hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            Amount amount4 = this.remaining_crypto;
            int hashCode5 = (((((((hashCode4 + (amount4 != null ? amount4.hashCode() : 0)) * 37) + this.fiat_max_label.hashCode()) * 37) + this.crypto_max_label.hashCode()) * 37) + this.max_summary.hashCode()) * 37;
            Link link = this.support_info;
            int hashCode6 = hashCode5 + (link != null ? link.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m477newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("action=" + b.c(this.action));
        if (this.maximum_fiat != null) {
            arrayList.add("maximum_fiat=" + this.maximum_fiat);
        }
        if (this.maximum_crypto != null) {
            arrayList.add("maximum_crypto=" + this.maximum_crypto);
        }
        if (this.remaining_fiat != null) {
            arrayList.add("remaining_fiat=" + this.remaining_fiat);
        }
        if (this.remaining_crypto != null) {
            arrayList.add("remaining_crypto=" + this.remaining_crypto);
        }
        arrayList.add("fiat_max_label=" + b.c(this.fiat_max_label));
        arrayList.add("crypto_max_label=" + b.c(this.crypto_max_label));
        arrayList.add("max_summary=" + b.c(this.max_summary));
        if (this.support_info != null) {
            arrayList.add("support_info=" + this.support_info);
        }
        h0 = z.h0(arrayList, ", ", "Limit{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Limit(String action, Amount amount, Amount amount2, Amount amount3, Amount amount4, String fiat_max_label, String crypto_max_label, String max_summary, Link link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(action, "action");
        m.h(fiat_max_label, "fiat_max_label");
        m.h(crypto_max_label, "crypto_max_label");
        m.h(max_summary, "max_summary");
        m.h(unknownFields, "unknownFields");
        this.action = action;
        this.maximum_fiat = amount;
        this.maximum_crypto = amount2;
        this.remaining_fiat = amount3;
        this.remaining_crypto = amount4;
        this.fiat_max_label = fiat_max_label;
        this.crypto_max_label = crypto_max_label;
        this.max_summary = max_summary;
        this.support_info = link;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m477newBuilder() {
        throw new AssertionError();
    }
}