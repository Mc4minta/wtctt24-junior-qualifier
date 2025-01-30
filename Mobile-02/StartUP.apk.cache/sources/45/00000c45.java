package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: AutopayInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B1\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayInfo;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "Lcom/coinbase/android/apiv3/generated/common/Link;", "support_info", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayInfo;", "Ljava/lang/String;", "getTitle", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getSupport_info", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AutopayInfo extends a {
    public static final ProtoAdapter<AutopayInfo> ADAPTER;
    public static final Parcelable.Creator<AutopayInfo> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", jsonName = "supportInfo", tag = 3)
    private final Link support_info;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: AutopayInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayInfo$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopayInfo;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AutopayInfo> protoAdapter = new ProtoAdapter<AutopayInfo>(c.LENGTH_DELIMITED, e0.b(AutopayInfo.class), "type.googleapis.com/coinbase.public_api.authed.loans.AutopayInfo") { // from class: com.coinbase.android.apiv3.generated.authed.loans.AutopayInfo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AutopayInfo decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                Link link = null;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AutopayInfo(str, str2, link, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        link = Link.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AutopayInfo value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDescription());
                }
                if (value.getSupport_info() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 3, value.getSupport_info());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AutopayInfo value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getDescription(), "")) {
                    r2 = (value.getSupport_info() != null ? Link.ADAPTER.encodedSizeWithTag(3, value.getSupport_info()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, value.getDescription());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AutopayInfo redact(AutopayInfo value) {
                m.h(value, "value");
                Link support_info = value.getSupport_info();
                return AutopayInfo.copy$default(value, null, null, support_info != null ? Link.ADAPTER.redact(support_info) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AutopayInfo() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ AutopayInfo(String str, String str2, Link link, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : link, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AutopayInfo copy$default(AutopayInfo autopayInfo, String str, String str2, Link link, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = autopayInfo.title;
        }
        if ((i2 & 2) != 0) {
            str2 = autopayInfo.description;
        }
        if ((i2 & 4) != 0) {
            link = autopayInfo.support_info;
        }
        if ((i2 & 8) != 0) {
            iVar = autopayInfo.unknownFields();
        }
        return autopayInfo.copy(str, str2, link, iVar);
    }

    public final AutopayInfo copy(String title, String description, Link link, i unknownFields) {
        m.h(title, "title");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        return new AutopayInfo(title, description, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutopayInfo) {
            AutopayInfo autopayInfo = (AutopayInfo) obj;
            return m.c(unknownFields(), autopayInfo.unknownFields()) && m.c(this.title, autopayInfo.title) && m.c(this.description, autopayInfo.description) && m.c(this.support_info, autopayInfo.support_info);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Link getSupport_info() {
        return this.support_info;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.description.hashCode()) * 37;
            Link link = this.support_info;
            int hashCode2 = hashCode + (link != null ? link.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m337newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        if (this.support_info != null) {
            arrayList.add("support_info=" + this.support_info);
        }
        h0 = z.h0(arrayList, ", ", "AutopayInfo{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutopayInfo(String title, String description, Link link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.description = description;
        this.support_info = link;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m337newBuilder() {
        throw new AssertionError();
    }
}