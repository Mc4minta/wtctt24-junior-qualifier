package com.coinbase.android.apiv3.generated.authed.loans;

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
import org.spongycastle.i18n.MessageBundle;

/* compiled from: UpcomingPayment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b!\u0010\u000f¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPayment;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "amount", ApiConstants.DESCRIPTION, "icon_url", "Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;", "type", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPayment;", "Ljava/lang/String;", "getDescription", "getIcon_url", "Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;", "getAmount", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPaymentType;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UpcomingPayment extends a {
    public static final ProtoAdapter<UpcomingPayment> ADAPTER;
    public static final Parcelable.Creator<UpcomingPayment> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 4)
    private final String icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.UpcomingPaymentType#ADAPTER", tag = 5)
    private final UpcomingPaymentType type;

    /* compiled from: UpcomingPayment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPayment$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/UpcomingPayment;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UpcomingPayment> protoAdapter = new ProtoAdapter<UpcomingPayment>(c.LENGTH_DELIMITED, e0.b(UpcomingPayment.class), "type.googleapis.com/coinbase.public_api.authed.loans.UpcomingPayment") { // from class: com.coinbase.android.apiv3.generated.authed.loans.UpcomingPayment$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpcomingPayment decode(k reader) {
                m.h(reader, "reader");
                UpcomingPaymentType upcomingPaymentType = UpcomingPaymentType.DUE;
                long d2 = reader.d();
                UpcomingPaymentType upcomingPaymentType2 = upcomingPaymentType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UpcomingPayment(str, str2, str3, str4, upcomingPaymentType2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        str4 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        try {
                            upcomingPaymentType2 = UpcomingPaymentType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UpcomingPayment value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getAmount(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getAmount());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDescription());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getIcon_url());
                }
                if (value.getType() != UpcomingPaymentType.DUE) {
                    UpcomingPaymentType.ADAPTER.encodeWithTag(writer, 5, value.getType());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UpcomingPayment value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getAmount(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getAmount());
                    if (!m.c(value.getDescription(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getDescription());
                        if (!m.c(value.getIcon_url(), "")) {
                            r2 = (value.getType() != UpcomingPaymentType.DUE ? UpcomingPaymentType.ADAPTER.encodedSizeWithTag(5, value.getType()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(4, value.getIcon_url());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public UpcomingPayment redact(UpcomingPayment value) {
                m.h(value, "value");
                return UpcomingPayment.copy$default(value, null, null, null, null, null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public UpcomingPayment() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ UpcomingPayment(String str, String str2, String str3, String str4, UpcomingPaymentType upcomingPaymentType, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? UpcomingPaymentType.DUE : upcomingPaymentType, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ UpcomingPayment copy$default(UpcomingPayment upcomingPayment, String str, String str2, String str3, String str4, UpcomingPaymentType upcomingPaymentType, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = upcomingPayment.title;
        }
        if ((i2 & 2) != 0) {
            str2 = upcomingPayment.amount;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = upcomingPayment.description;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = upcomingPayment.icon_url;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            upcomingPaymentType = upcomingPayment.type;
        }
        UpcomingPaymentType upcomingPaymentType2 = upcomingPaymentType;
        if ((i2 & 32) != 0) {
            iVar = upcomingPayment.unknownFields();
        }
        return upcomingPayment.copy(str, str5, str6, str7, upcomingPaymentType2, iVar);
    }

    public final UpcomingPayment copy(String title, String amount, String description, String icon_url, UpcomingPaymentType type, i unknownFields) {
        m.h(title, "title");
        m.h(amount, "amount");
        m.h(description, "description");
        m.h(icon_url, "icon_url");
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new UpcomingPayment(title, amount, description, icon_url, type, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpcomingPayment) {
            UpcomingPayment upcomingPayment = (UpcomingPayment) obj;
            return m.c(unknownFields(), upcomingPayment.unknownFields()) && m.c(this.title, upcomingPayment.title) && m.c(this.amount, upcomingPayment.amount) && m.c(this.description, upcomingPayment.description) && m.c(this.icon_url, upcomingPayment.icon_url) && this.type == upcomingPayment.type;
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final UpcomingPaymentType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.amount.hashCode()) * 37) + this.description.hashCode()) * 37) + this.icon_url.hashCode()) * 37) + this.type.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m390newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("amount=" + b.c(this.amount));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("icon_url=" + b.c(this.icon_url));
        arrayList.add("type=" + this.type);
        h0 = z.h0(arrayList, ", ", "UpcomingPayment{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m390newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpcomingPayment(String title, String amount, String description, String icon_url, UpcomingPaymentType type, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(amount, "amount");
        m.h(description, "description");
        m.h(icon_url, "icon_url");
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.icon_url = icon_url;
        this.type = type;
    }
}