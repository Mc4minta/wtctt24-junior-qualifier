package com.coinbase.android.apiv3.generated.authed.tutorials;

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

/* compiled from: TutorialCTA.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "type", ApiConstants.DESCRIPTION, "cta_link", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;", "Ljava/lang/String;", "getType", "getCta_link", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TutorialCTA extends a {
    public static final ProtoAdapter<TutorialCTA> ADAPTER;
    public static final Parcelable.Creator<TutorialCTA> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "ctaLink", tag = 3)
    private final String cta_link;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String type;

    /* compiled from: TutorialCTA.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<TutorialCTA> protoAdapter = new ProtoAdapter<TutorialCTA>(c.LENGTH_DELIMITED, e0.b(TutorialCTA.class), "type.googleapis.com/coinbase.public_api.authed.tutorials.TutorialCTA") { // from class: com.coinbase.android.apiv3.generated.authed.tutorials.TutorialCTA$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TutorialCTA decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new TutorialCTA(str, str2, str3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, TutorialCTA value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getType(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getType());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDescription());
                }
                if (!m.c(value.getCta_link(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getCta_link());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(TutorialCTA value) {
                m.h(value, "value");
                if (m.c(value.getType(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getType());
                if (!m.c(value.getDescription(), "")) {
                    r2 = (m.c(value.getCta_link(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getCta_link()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getDescription());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public TutorialCTA redact(TutorialCTA value) {
                m.h(value, "value");
                return TutorialCTA.copy$default(value, null, null, null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public TutorialCTA() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ TutorialCTA(String str, String str2, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ TutorialCTA copy$default(TutorialCTA tutorialCTA, String str, String str2, String str3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tutorialCTA.type;
        }
        if ((i2 & 2) != 0) {
            str2 = tutorialCTA.description;
        }
        if ((i2 & 4) != 0) {
            str3 = tutorialCTA.cta_link;
        }
        if ((i2 & 8) != 0) {
            iVar = tutorialCTA.unknownFields();
        }
        return tutorialCTA.copy(str, str2, str3, iVar);
    }

    public final TutorialCTA copy(String type, String description, String cta_link, i unknownFields) {
        m.h(type, "type");
        m.h(description, "description");
        m.h(cta_link, "cta_link");
        m.h(unknownFields, "unknownFields");
        return new TutorialCTA(type, description, cta_link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TutorialCTA) {
            TutorialCTA tutorialCTA = (TutorialCTA) obj;
            return m.c(unknownFields(), tutorialCTA.unknownFields()) && m.c(this.type, tutorialCTA.type) && m.c(this.description, tutorialCTA.description) && m.c(this.cta_link, tutorialCTA.cta_link);
        }
        return false;
    }

    public final String getCta_link() {
        return this.cta_link;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.description.hashCode()) * 37) + this.cta_link.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m481newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + b.c(this.type));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("cta_link=" + b.c(this.cta_link));
        h0 = z.h0(arrayList, ", ", "TutorialCTA{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialCTA(String type, String description, String cta_link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(description, "description");
        m.h(cta_link, "cta_link");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.description = description;
        this.cta_link = cta_link;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m481newBuilder() {
        throw new AssertionError();
    }
}