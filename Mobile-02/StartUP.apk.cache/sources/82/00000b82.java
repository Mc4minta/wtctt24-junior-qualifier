package com.coinbase.android.apiv3.generated.authed.addresses;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageOptions;
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

/* compiled from: ListAddressesForAccountRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/addresses/ListAddressesForAccountRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "account_id", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "page_options", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/addresses/ListAddressesForAccountRequest;", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "getPage_options", "()Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "Ljava/lang/String;", "getAccount_id", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListAddressesForAccountRequest extends a {
    public static final ProtoAdapter<ListAddressesForAccountRequest> ADAPTER;
    public static final Parcelable.Creator<ListAddressesForAccountRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "accountId", tag = 1)
    private final String account_id;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageOptions#ADAPTER", jsonName = "pageOptions", tag = 2)
    private final PageOptions page_options;

    /* compiled from: ListAddressesForAccountRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/addresses/ListAddressesForAccountRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/ListAddressesForAccountRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListAddressesForAccountRequest> protoAdapter = new ProtoAdapter<ListAddressesForAccountRequest>(c.LENGTH_DELIMITED, e0.b(ListAddressesForAccountRequest.class), "type.googleapis.com/coinbase.public_api.authed.addresses.ListAddressesForAccountRequest") { // from class: com.coinbase.android.apiv3.generated.authed.addresses.ListAddressesForAccountRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListAddressesForAccountRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                PageOptions pageOptions = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListAddressesForAccountRequest(str, pageOptions, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        pageOptions = PageOptions.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListAddressesForAccountRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAccount_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAccount_id());
                }
                if (value.getPage_options() != null) {
                    PageOptions.ADAPTER.encodeWithTag(writer, 2, value.getPage_options());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListAddressesForAccountRequest value) {
                m.h(value, "value");
                if (m.c(value.getAccount_id(), "")) {
                    return 0;
                }
                return (value.getPage_options() != null ? PageOptions.ADAPTER.encodedSizeWithTag(2, value.getPage_options()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getAccount_id());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListAddressesForAccountRequest redact(ListAddressesForAccountRequest value) {
                m.h(value, "value");
                PageOptions page_options = value.getPage_options();
                return ListAddressesForAccountRequest.copy$default(value, null, page_options != null ? PageOptions.ADAPTER.redact(page_options) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ListAddressesForAccountRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ ListAddressesForAccountRequest(String str, PageOptions pageOptions, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : pageOptions, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListAddressesForAccountRequest copy$default(ListAddressesForAccountRequest listAddressesForAccountRequest, String str, PageOptions pageOptions, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = listAddressesForAccountRequest.account_id;
        }
        if ((i2 & 2) != 0) {
            pageOptions = listAddressesForAccountRequest.page_options;
        }
        if ((i2 & 4) != 0) {
            iVar = listAddressesForAccountRequest.unknownFields();
        }
        return listAddressesForAccountRequest.copy(str, pageOptions, iVar);
    }

    public final ListAddressesForAccountRequest copy(String account_id, PageOptions pageOptions, i unknownFields) {
        m.h(account_id, "account_id");
        m.h(unknownFields, "unknownFields");
        return new ListAddressesForAccountRequest(account_id, pageOptions, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListAddressesForAccountRequest) {
            ListAddressesForAccountRequest listAddressesForAccountRequest = (ListAddressesForAccountRequest) obj;
            return m.c(unknownFields(), listAddressesForAccountRequest.unknownFields()) && m.c(this.account_id, listAddressesForAccountRequest.account_id) && m.c(this.page_options, listAddressesForAccountRequest.page_options);
        }
        return false;
    }

    public final String getAccount_id() {
        return this.account_id;
    }

    public final PageOptions getPage_options() {
        return this.page_options;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.account_id.hashCode()) * 37;
            PageOptions pageOptions = this.page_options;
            int hashCode2 = hashCode + (pageOptions != null ? pageOptions.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m277newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("account_id=" + b.c(this.account_id));
        if (this.page_options != null) {
            arrayList.add("page_options=" + this.page_options);
        }
        h0 = z.h0(arrayList, ", ", "ListAddressesForAccountRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListAddressesForAccountRequest(String account_id, PageOptions pageOptions, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(account_id, "account_id");
        m.h(unknownFields, "unknownFields");
        this.account_id = account_id;
        this.page_options = pageOptions;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m277newBuilder() {
        throw new AssertionError();
    }
}