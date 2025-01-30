package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageOptions;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ListBankBranchesRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B1\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "bank_code", "filter", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "page_options", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesRequest;", "Ljava/lang/String;", "getBank_code", "getFilter", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "getPage_options", "()Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListBankBranchesRequest extends com.squareup.wire.a {
    public static final ProtoAdapter<ListBankBranchesRequest> ADAPTER;
    public static final Parcelable.Creator<ListBankBranchesRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bankCode", tag = 1)
    private final String bank_code;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String filter;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageOptions#ADAPTER", jsonName = "pageOptions", tag = 3)
    private final PageOptions page_options;

    /* compiled from: ListBankBranchesRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListBankBranchesRequest> protoAdapter = new ProtoAdapter<ListBankBranchesRequest>(c.LENGTH_DELIMITED, e0.b(ListBankBranchesRequest.class), "type.googleapis.com/coinbase.public_api.authed.ListBankBranchesRequest") { // from class: com.coinbase.android.apiv3.generated.authed.ListBankBranchesRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListBankBranchesRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                PageOptions pageOptions = null;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListBankBranchesRequest(str, str2, pageOptions, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        pageOptions = PageOptions.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListBankBranchesRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBank_code(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBank_code());
                }
                if (!m.c(value.getFilter(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getFilter());
                }
                if (value.getPage_options() != null) {
                    PageOptions.ADAPTER.encodeWithTag(writer, 3, value.getPage_options());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListBankBranchesRequest value) {
                m.h(value, "value");
                if (m.c(value.getBank_code(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getBank_code());
                if (!m.c(value.getFilter(), "")) {
                    r2 = (value.getPage_options() != null ? PageOptions.ADAPTER.encodedSizeWithTag(3, value.getPage_options()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, value.getFilter());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListBankBranchesRequest redact(ListBankBranchesRequest value) {
                m.h(value, "value");
                PageOptions page_options = value.getPage_options();
                return ListBankBranchesRequest.copy$default(value, null, null, page_options != null ? PageOptions.ADAPTER.redact(page_options) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public ListBankBranchesRequest() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ ListBankBranchesRequest(String str, String str2, PageOptions pageOptions, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : pageOptions, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListBankBranchesRequest copy$default(ListBankBranchesRequest listBankBranchesRequest, String str, String str2, PageOptions pageOptions, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = listBankBranchesRequest.bank_code;
        }
        if ((i2 & 2) != 0) {
            str2 = listBankBranchesRequest.filter;
        }
        if ((i2 & 4) != 0) {
            pageOptions = listBankBranchesRequest.page_options;
        }
        if ((i2 & 8) != 0) {
            iVar = listBankBranchesRequest.unknownFields();
        }
        return listBankBranchesRequest.copy(str, str2, pageOptions, iVar);
    }

    public final ListBankBranchesRequest copy(String bank_code, String filter, PageOptions pageOptions, i unknownFields) {
        m.h(bank_code, "bank_code");
        m.h(filter, "filter");
        m.h(unknownFields, "unknownFields");
        return new ListBankBranchesRequest(bank_code, filter, pageOptions, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListBankBranchesRequest) {
            ListBankBranchesRequest listBankBranchesRequest = (ListBankBranchesRequest) obj;
            return m.c(unknownFields(), listBankBranchesRequest.unknownFields()) && m.c(this.bank_code, listBankBranchesRequest.bank_code) && m.c(this.filter, listBankBranchesRequest.filter) && m.c(this.page_options, listBankBranchesRequest.page_options);
        }
        return false;
    }

    public final String getBank_code() {
        return this.bank_code;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final PageOptions getPage_options() {
        return this.page_options;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.bank_code.hashCode()) * 37) + this.filter.hashCode()) * 37;
            PageOptions pageOptions = this.page_options;
            int hashCode2 = hashCode + (pageOptions != null ? pageOptions.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m229newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("bank_code=" + com.squareup.wire.q.b.c(this.bank_code));
        arrayList.add("filter=" + com.squareup.wire.q.b.c(this.filter));
        if (this.page_options != null) {
            arrayList.add("page_options=" + this.page_options);
        }
        h0 = z.h0(arrayList, ", ", "ListBankBranchesRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListBankBranchesRequest(String bank_code, String filter, PageOptions pageOptions, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(bank_code, "bank_code");
        m.h(filter, "filter");
        m.h(unknownFields, "unknownFields");
        this.bank_code = bank_code;
        this.filter = filter;
        this.page_options = pageOptions;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m229newBuilder() {
        throw new AssertionError();
    }
}