package com.coinbase.android.apiv3.generated.authed.sends;

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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: SearchRecipientResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB!\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/sends/ToDetails;", "results", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientResponse;", "Ljava/util/List;", "getResults", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SearchRecipientResponse extends a {
    public static final ProtoAdapter<SearchRecipientResponse> ADAPTER;
    public static final Parcelable.Creator<SearchRecipientResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.ToDetails#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<ToDetails> results;

    /* compiled from: SearchRecipientResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(SearchRecipientResponse.class);
        ProtoAdapter<SearchRecipientResponse> protoAdapter = new ProtoAdapter<SearchRecipientResponse>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.SearchRecipientResponse") { // from class: com.coinbase.android.apiv3.generated.authed.sends.SearchRecipientResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SearchRecipientResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SearchRecipientResponse(arrayList, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        arrayList.add(ToDetails.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SearchRecipientResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                ToDetails.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getResults());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SearchRecipientResponse value) {
                m.h(value, "value");
                return ToDetails.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getResults()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SearchRecipientResponse redact(SearchRecipientResponse value) {
                m.h(value, "value");
                return value.copy(b.a(value.getResults(), ToDetails.ADAPTER), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SearchRecipientResponse() {
        this(null, null, 3, null);
    }

    public /* synthetic */ SearchRecipientResponse(List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchRecipientResponse copy$default(SearchRecipientResponse searchRecipientResponse, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = searchRecipientResponse.results;
        }
        if ((i2 & 2) != 0) {
            iVar = searchRecipientResponse.unknownFields();
        }
        return searchRecipientResponse.copy(list, iVar);
    }

    public final SearchRecipientResponse copy(List<ToDetails> results, i unknownFields) {
        m.h(results, "results");
        m.h(unknownFields, "unknownFields");
        return new SearchRecipientResponse(results, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchRecipientResponse) {
            SearchRecipientResponse searchRecipientResponse = (SearchRecipientResponse) obj;
            return m.c(unknownFields(), searchRecipientResponse.unknownFields()) && m.c(this.results, searchRecipientResponse.results);
        }
        return false;
    }

    public final List<ToDetails> getResults() {
        return this.results;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.results.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m468newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.results.isEmpty()) {
            arrayList.add("results=" + this.results);
        }
        h0 = z.h0(arrayList, ", ", "SearchRecipientResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m468newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchRecipientResponse(List<ToDetails> results, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(results, "results");
        m.h(unknownFields, "unknownFields");
        this.results = results;
    }
}