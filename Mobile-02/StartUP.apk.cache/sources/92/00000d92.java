package com.coinbase.android.apiv3.generated.authed.new_user_experience;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: IncentivesMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB+\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentiveData;", "incentive_data", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;", "Ljava/util/List;", "getIncentive_data", "()Ljava/util/List;", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class IncentivesMetadata extends a {
    public static final ProtoAdapter<IncentivesMetadata> ADAPTER;
    public static final Parcelable.Creator<IncentivesMetadata> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.IncentiveData#ADAPTER", jsonName = "incentiveData", label = p.a.REPEATED, tag = 2)
    private final List<IncentiveData> incentive_data;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: IncentivesMetadata.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<IncentivesMetadata> protoAdapter = new ProtoAdapter<IncentivesMetadata>(c.LENGTH_DELIMITED, e0.b(IncentivesMetadata.class), "type.googleapis.com/coinbase.public_api.authed.new_user_experience.IncentivesMetadata") { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.IncentivesMetadata$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public IncentivesMetadata decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new IncentivesMetadata(str, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        arrayList.add(IncentiveData.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, IncentivesMetadata value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                IncentiveData.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getIncentive_data());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(IncentivesMetadata value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                return value.unknownFields().Q() + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getTitle()) + IncentiveData.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getIncentive_data());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public IncentivesMetadata redact(IncentivesMetadata value) {
                m.h(value, "value");
                return IncentivesMetadata.copy$default(value, null, b.a(value.getIncentive_data(), IncentiveData.ADAPTER), i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public IncentivesMetadata() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ IncentivesMetadata(String str, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IncentivesMetadata copy$default(IncentivesMetadata incentivesMetadata, String str, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = incentivesMetadata.title;
        }
        if ((i2 & 2) != 0) {
            list = incentivesMetadata.incentive_data;
        }
        if ((i2 & 4) != 0) {
            iVar = incentivesMetadata.unknownFields();
        }
        return incentivesMetadata.copy(str, list, iVar);
    }

    public final IncentivesMetadata copy(String title, List<IncentiveData> incentive_data, i unknownFields) {
        m.h(title, "title");
        m.h(incentive_data, "incentive_data");
        m.h(unknownFields, "unknownFields");
        return new IncentivesMetadata(title, incentive_data, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IncentivesMetadata) {
            IncentivesMetadata incentivesMetadata = (IncentivesMetadata) obj;
            return m.c(unknownFields(), incentivesMetadata.unknownFields()) && m.c(this.title, incentivesMetadata.title) && m.c(this.incentive_data, incentivesMetadata.incentive_data);
        }
        return false;
    }

    public final List<IncentiveData> getIncentive_data() {
        return this.incentive_data;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.incentive_data.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m432newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        if (!this.incentive_data.isEmpty()) {
            arrayList.add("incentive_data=" + this.incentive_data);
        }
        h0 = z.h0(arrayList, ", ", "IncentivesMetadata{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m432newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncentivesMetadata(String title, List<IncentiveData> incentive_data, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(incentive_data, "incentive_data");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.incentive_data = incentive_data;
    }
}