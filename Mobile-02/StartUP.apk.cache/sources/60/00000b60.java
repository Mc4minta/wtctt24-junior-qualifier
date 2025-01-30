package com.coinbase.android.apiv3.generated.authed.accounts;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageOptions;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
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

/* compiled from: GetAccountsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B'\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/accounts/Type;", "type", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "page_options", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/accounts/Type;Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsRequest;", "Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "getPage_options", "()Lcom/coinbase/android/apiv3/generated/common/PageOptions;", "Lcom/coinbase/android/apiv3/generated/authed/accounts/Type;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/accounts/Type;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/accounts/Type;Lcom/coinbase/android/apiv3/generated/common/PageOptions;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetAccountsRequest extends a {
    public static final ProtoAdapter<GetAccountsRequest> ADAPTER;
    public static final Parcelable.Creator<GetAccountsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageOptions#ADAPTER", jsonName = "pageOptions", tag = 2)
    private final PageOptions page_options;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.accounts.Type#ADAPTER", tag = 1)
    private final Type type;

    /* compiled from: GetAccountsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetAccountsRequest> protoAdapter = new ProtoAdapter<GetAccountsRequest>(c.LENGTH_DELIMITED, e0.b(GetAccountsRequest.class), "type.googleapis.com/coinbase.public_api.authed.accounts.GetAccountsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.accounts.GetAccountsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAccountsRequest decode(k reader) {
                m.h(reader, "reader");
                Type type = Type.ALL;
                long d2 = reader.d();
                PageOptions pageOptions = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetAccountsRequest(type, pageOptions, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            type = Type.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        pageOptions = PageOptions.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetAccountsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != Type.ALL) {
                    Type.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getPage_options() != null) {
                    PageOptions.ADAPTER.encodeWithTag(writer, 2, value.getPage_options());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetAccountsRequest value) {
                m.h(value, "value");
                if (value.getType() == Type.ALL) {
                    return 0;
                }
                return (value.getPage_options() != null ? PageOptions.ADAPTER.encodedSizeWithTag(2, value.getPage_options()) + value.unknownFields().Q() : 0) + Type.ADAPTER.encodedSizeWithTag(1, value.getType());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetAccountsRequest redact(GetAccountsRequest value) {
                m.h(value, "value");
                PageOptions page_options = value.getPage_options();
                return GetAccountsRequest.copy$default(value, null, page_options != null ? PageOptions.ADAPTER.redact(page_options) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetAccountsRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetAccountsRequest(Type type, PageOptions pageOptions, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Type.ALL : type, (i2 & 2) != 0 ? null : pageOptions, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetAccountsRequest copy$default(GetAccountsRequest getAccountsRequest, Type type, PageOptions pageOptions, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            type = getAccountsRequest.type;
        }
        if ((i2 & 2) != 0) {
            pageOptions = getAccountsRequest.page_options;
        }
        if ((i2 & 4) != 0) {
            iVar = getAccountsRequest.unknownFields();
        }
        return getAccountsRequest.copy(type, pageOptions, iVar);
    }

    public final GetAccountsRequest copy(Type type, PageOptions pageOptions, i unknownFields) {
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new GetAccountsRequest(type, pageOptions, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetAccountsRequest) {
            GetAccountsRequest getAccountsRequest = (GetAccountsRequest) obj;
            return m.c(unknownFields(), getAccountsRequest.unknownFields()) && this.type == getAccountsRequest.type && m.c(this.page_options, getAccountsRequest.page_options);
        }
        return false;
    }

    public final PageOptions getPage_options() {
        return this.page_options;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37;
            PageOptions pageOptions = this.page_options;
            int hashCode2 = hashCode + (pageOptions != null ? pageOptions.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m267newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        if (this.page_options != null) {
            arrayList.add("page_options=" + this.page_options);
        }
        h0 = z.h0(arrayList, ", ", "GetAccountsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m267newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAccountsRequest(Type type, PageOptions pageOptions, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.page_options = pageOptions;
    }
}