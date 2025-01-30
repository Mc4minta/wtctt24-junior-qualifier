package com.coinbase.android.apiv3.generated.common;

import android.os.Parcelable;
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

/* compiled from: PageDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "size", "previous_cursor", "next_cursor", "Lj/i;", "unknownFields", "copy", "(ILjava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "Ljava/lang/String;", "getPrevious_cursor", "getNext_cursor", "I", "getSize", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PageDescription extends a {
    public static final ProtoAdapter<PageDescription> ADAPTER;
    public static final Parcelable.Creator<PageDescription> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "nextCursor", tag = 3)
    private final String next_cursor;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "previousCursor", tag = 2)
    private final String previous_cursor;
    @p(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    private final int size;

    /* compiled from: PageDescription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PageDescription$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PageDescription> protoAdapter = new ProtoAdapter<PageDescription>(c.LENGTH_DELIMITED, e0.b(PageDescription.class), "type.googleapis.com/coinbase.public_api.common.PageDescription") { // from class: com.coinbase.android.apiv3.generated.common.PageDescription$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PageDescription decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                int i2 = 0;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PageDescription(i2, str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        i2 = ProtoAdapter.UINT32.decode(reader).intValue();
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PageDescription value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getSize() != 0) {
                    ProtoAdapter.UINT32.encodeWithTag(writer, 1, Integer.valueOf(value.getSize()));
                }
                if (!m.c(value.getPrevious_cursor(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPrevious_cursor());
                }
                if (!m.c(value.getNext_cursor(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getNext_cursor());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PageDescription value) {
                m.h(value, "value");
                if (value.getSize() == 0) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(value.getSize()));
                if (!m.c(value.getPrevious_cursor(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    r1 = (m.c(value.getNext_cursor(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getNext_cursor()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getPrevious_cursor());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PageDescription redact(PageDescription value) {
                m.h(value, "value");
                return PageDescription.copy$default(value, 0, null, null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PageDescription() {
        this(0, null, null, null, 15, null);
    }

    public /* synthetic */ PageDescription(int i2, String str, String str2, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PageDescription copy$default(PageDescription pageDescription, int i2, String str, String str2, i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = pageDescription.size;
        }
        if ((i3 & 2) != 0) {
            str = pageDescription.previous_cursor;
        }
        if ((i3 & 4) != 0) {
            str2 = pageDescription.next_cursor;
        }
        if ((i3 & 8) != 0) {
            iVar = pageDescription.unknownFields();
        }
        return pageDescription.copy(i2, str, str2, iVar);
    }

    public final PageDescription copy(int i2, String previous_cursor, String next_cursor, i unknownFields) {
        m.h(previous_cursor, "previous_cursor");
        m.h(next_cursor, "next_cursor");
        m.h(unknownFields, "unknownFields");
        return new PageDescription(i2, previous_cursor, next_cursor, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PageDescription) {
            PageDescription pageDescription = (PageDescription) obj;
            return m.c(unknownFields(), pageDescription.unknownFields()) && this.size == pageDescription.size && m.c(this.previous_cursor, pageDescription.previous_cursor) && m.c(this.next_cursor, pageDescription.next_cursor);
        }
        return false;
    }

    public final String getNext_cursor() {
        return this.next_cursor;
    }

    public final String getPrevious_cursor() {
        return this.previous_cursor;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.size) * 37) + this.previous_cursor.hashCode()) * 37) + this.next_cursor.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m510newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("size=" + this.size);
        arrayList.add("previous_cursor=" + b.c(this.previous_cursor));
        arrayList.add("next_cursor=" + b.c(this.next_cursor));
        h0 = z.h0(arrayList, ", ", "PageDescription{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageDescription(int i2, String previous_cursor, String next_cursor, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(previous_cursor, "previous_cursor");
        m.h(next_cursor, "next_cursor");
        m.h(unknownFields, "unknownFields");
        this.size = i2;
        this.previous_cursor = previous_cursor;
        this.next_cursor = next_cursor;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m510newBuilder() {
        throw new AssertionError();
    }
}