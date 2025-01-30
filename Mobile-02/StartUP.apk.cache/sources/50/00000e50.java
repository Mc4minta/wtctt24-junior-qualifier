package com.coinbase.android.apiv3.generated.authed.user_eligibility;

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

/* compiled from: SplitTest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/SplitTest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "test", "group", "is_tracked", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/SplitTest;", "Ljava/lang/String;", "getTest", "Z", "()Z", "getGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SplitTest extends a {
    public static final ProtoAdapter<SplitTest> ADAPTER;
    public static final Parcelable.Creator<SplitTest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String group;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isTracked", tag = 3)
    private final boolean is_tracked;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String test;

    /* compiled from: SplitTest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/SplitTest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/SplitTest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<SplitTest> protoAdapter = new ProtoAdapter<SplitTest>(c.LENGTH_DELIMITED, e0.b(SplitTest.class), "type.googleapis.com/coinbase.public_api.authed.user_eligibility.SplitTest") { // from class: com.coinbase.android.apiv3.generated.authed.user_eligibility.SplitTest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SplitTest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                boolean z = false;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SplitTest(str, str2, z, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SplitTest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTest(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTest());
                }
                if (!m.c(value.getGroup(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getGroup());
                }
                if (value.is_tracked()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 3, Boolean.valueOf(value.is_tracked()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SplitTest value) {
                m.h(value, "value");
                if (m.c(value.getTest(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTest());
                if (!m.c(value.getGroup(), "")) {
                    r2 = (value.is_tracked() ? ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(value.is_tracked())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, value.getGroup());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SplitTest redact(SplitTest value) {
                m.h(value, "value");
                return SplitTest.copy$default(value, null, null, false, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SplitTest() {
        this(null, null, false, null, 15, null);
    }

    public /* synthetic */ SplitTest(String str, String str2, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ SplitTest copy$default(SplitTest splitTest, String str, String str2, boolean z, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = splitTest.test;
        }
        if ((i2 & 2) != 0) {
            str2 = splitTest.group;
        }
        if ((i2 & 4) != 0) {
            z = splitTest.is_tracked;
        }
        if ((i2 & 8) != 0) {
            iVar = splitTest.unknownFields();
        }
        return splitTest.copy(str, str2, z, iVar);
    }

    public final SplitTest copy(String test, String group, boolean z, i unknownFields) {
        m.h(test, "test");
        m.h(group, "group");
        m.h(unknownFields, "unknownFields");
        return new SplitTest(test, group, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitTest) {
            SplitTest splitTest = (SplitTest) obj;
            return m.c(unknownFields(), splitTest.unknownFields()) && m.c(this.test, splitTest.test) && m.c(this.group, splitTest.group) && this.is_tracked == splitTest.is_tracked;
        }
        return false;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getTest() {
        return this.test;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.test.hashCode()) * 37) + this.group.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.is_tracked);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    public final boolean is_tracked() {
        return this.is_tracked;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m486newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("test=" + b.c(this.test));
        arrayList.add("group=" + b.c(this.group));
        arrayList.add("is_tracked=" + this.is_tracked);
        h0 = z.h0(arrayList, ", ", "SplitTest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitTest(String test, String group, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(test, "test");
        m.h(group, "group");
        m.h(unknownFields, "unknownFields");
        this.test = test;
        this.group = group;
        this.is_tracked = z;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m486newBuilder() {
        throw new AssertionError();
    }
}