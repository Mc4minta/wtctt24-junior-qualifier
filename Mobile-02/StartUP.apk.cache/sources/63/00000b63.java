package com.coinbase.android.apiv3.generated.authed.accounts;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.PageDescription;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.coinbase.android.apiv3.generated.resources.Account;
import com.coinbase.android.apiv3.generated.resources.Address;
import com.coinbase.android.apiv3.generated.resources.Asset;
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

/* compiled from: GetAccountsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.BU\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010'R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b(\u0010'R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "page_description", "", "Lcom/coinbase/android/apiv3/generated/resources/Account;", ApiConstants.ACCOUNTS, "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "assets", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "default_account", "Lcom/coinbase/android/apiv3/generated/resources/Address;", "default_address", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/PageDescription;Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/resources/Address;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsResponse;", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "getPage_description", "()Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "Lcom/coinbase/android/apiv3/generated/resources/Address;", "getDefault_address", "()Lcom/coinbase/android/apiv3/generated/resources/Address;", "Ljava/util/List;", "getAssets", "()Ljava/util/List;", "getAccounts", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getDefault_account", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/PageDescription;Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/resources/Address;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetAccountsResponse extends a {
    public static final ProtoAdapter<GetAccountsResponse> ADAPTER;
    public static final Parcelable.Creator<GetAccountsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Account#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<Account> accounts;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset#ADAPTER", label = p.a.REPEATED, tag = 3)
    private final List<Asset> assets;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "defaultAccount", tag = 4)
    private final Ref default_account;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Address#ADAPTER", jsonName = "defaultAddress", tag = 5)
    private final Address default_address;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageDescription#ADAPTER", jsonName = "pageDescription", tag = 1)
    private final PageDescription page_description;

    /* compiled from: GetAccountsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/accounts/GetAccountsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(GetAccountsResponse.class);
        ProtoAdapter<GetAccountsResponse> protoAdapter = new ProtoAdapter<GetAccountsResponse>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.accounts.GetAccountsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.accounts.GetAccountsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAccountsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long d2 = reader.d();
                PageDescription pageDescription = null;
                Ref ref = null;
                Address address = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetAccountsResponse(pageDescription, arrayList, arrayList2, ref, address, reader.e(d2));
                    }
                    if (g2 == 1) {
                        pageDescription = PageDescription.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        arrayList.add(Account.ADAPTER.decode(reader));
                    } else if (g2 == 3) {
                        arrayList2.add(Asset.ADAPTER.decode(reader));
                    } else if (g2 == 4) {
                        ref = Ref.ADAPTER.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        address = Address.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetAccountsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPage_description() != null) {
                    PageDescription.ADAPTER.encodeWithTag(writer, 1, value.getPage_description());
                }
                Account.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getAccounts());
                Asset.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getAssets());
                if (value.getDefault_account() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 4, value.getDefault_account());
                }
                if (value.getDefault_address() != null) {
                    Address.ADAPTER.encodeWithTag(writer, 5, value.getDefault_address());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetAccountsResponse value) {
                m.h(value, "value");
                if (value.getPage_description() == null) {
                    return 0;
                }
                int encodedSizeWithTag = PageDescription.ADAPTER.encodedSizeWithTag(1, value.getPage_description()) + Account.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getAccounts()) + Asset.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getAssets());
                if (value.getDefault_account() != null) {
                    r1 = (value.getDefault_address() != null ? Address.ADAPTER.encodedSizeWithTag(5, value.getDefault_address()) + value.unknownFields().Q() : 0) + Ref.ADAPTER.encodedSizeWithTag(4, value.getDefault_account());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetAccountsResponse redact(GetAccountsResponse value) {
                m.h(value, "value");
                PageDescription page_description = value.getPage_description();
                PageDescription redact = page_description != null ? PageDescription.ADAPTER.redact(page_description) : null;
                List<Account> a = b.a(value.getAccounts(), Account.ADAPTER);
                List<Asset> a2 = b.a(value.getAssets(), Asset.ADAPTER);
                Ref default_account = value.getDefault_account();
                Ref redact2 = default_account != null ? Ref.ADAPTER.redact(default_account) : null;
                Address default_address = value.getDefault_address();
                return value.copy(redact, a, a2, redact2, default_address != null ? Address.ADAPTER.redact(default_address) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetAccountsResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ GetAccountsResponse(PageDescription pageDescription, List list, List list2, Ref ref, Address address, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : pageDescription, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? r.g() : list2, (i2 & 8) != 0 ? null : ref, (i2 & 16) == 0 ? address : null, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetAccountsResponse copy$default(GetAccountsResponse getAccountsResponse, PageDescription pageDescription, List list, List list2, Ref ref, Address address, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pageDescription = getAccountsResponse.page_description;
        }
        List<Account> list3 = list;
        if ((i2 & 2) != 0) {
            list3 = getAccountsResponse.accounts;
        }
        List list4 = list3;
        List<Asset> list5 = list2;
        if ((i2 & 4) != 0) {
            list5 = getAccountsResponse.assets;
        }
        List list6 = list5;
        if ((i2 & 8) != 0) {
            ref = getAccountsResponse.default_account;
        }
        Ref ref2 = ref;
        if ((i2 & 16) != 0) {
            address = getAccountsResponse.default_address;
        }
        Address address2 = address;
        if ((i2 & 32) != 0) {
            iVar = getAccountsResponse.unknownFields();
        }
        return getAccountsResponse.copy(pageDescription, list4, list6, ref2, address2, iVar);
    }

    public final GetAccountsResponse copy(PageDescription pageDescription, List<Account> accounts, List<Asset> assets, Ref ref, Address address, i unknownFields) {
        m.h(accounts, "accounts");
        m.h(assets, "assets");
        m.h(unknownFields, "unknownFields");
        return new GetAccountsResponse(pageDescription, accounts, assets, ref, address, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetAccountsResponse) {
            GetAccountsResponse getAccountsResponse = (GetAccountsResponse) obj;
            return m.c(unknownFields(), getAccountsResponse.unknownFields()) && m.c(this.page_description, getAccountsResponse.page_description) && m.c(this.accounts, getAccountsResponse.accounts) && m.c(this.assets, getAccountsResponse.assets) && m.c(this.default_account, getAccountsResponse.default_account) && m.c(this.default_address, getAccountsResponse.default_address);
        }
        return false;
    }

    public final List<Account> getAccounts() {
        return this.accounts;
    }

    public final List<Asset> getAssets() {
        return this.assets;
    }

    public final Ref getDefault_account() {
        return this.default_account;
    }

    public final Address getDefault_address() {
        return this.default_address;
    }

    public final PageDescription getPage_description() {
        return this.page_description;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            PageDescription pageDescription = this.page_description;
            int hashCode2 = (((((hashCode + (pageDescription != null ? pageDescription.hashCode() : 0)) * 37) + this.accounts.hashCode()) * 37) + this.assets.hashCode()) * 37;
            Ref ref = this.default_account;
            int hashCode3 = (hashCode2 + (ref != null ? ref.hashCode() : 0)) * 37;
            Address address = this.default_address;
            int hashCode4 = hashCode3 + (address != null ? address.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m268newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.page_description != null) {
            arrayList.add("page_description=" + this.page_description);
        }
        if (!this.accounts.isEmpty()) {
            arrayList.add("accounts=" + this.accounts);
        }
        if (!this.assets.isEmpty()) {
            arrayList.add("assets=" + this.assets);
        }
        if (this.default_account != null) {
            arrayList.add("default_account=" + this.default_account);
        }
        if (this.default_address != null) {
            arrayList.add("default_address=" + this.default_address);
        }
        h0 = z.h0(arrayList, ", ", "GetAccountsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m268newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAccountsResponse(PageDescription pageDescription, List<Account> accounts, List<Asset> assets, Ref ref, Address address, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(accounts, "accounts");
        m.h(assets, "assets");
        m.h(unknownFields, "unknownFields");
        this.page_description = pageDescription;
        this.accounts = accounts;
        this.assets = assets;
        this.default_account = ref;
        this.default_address = address;
    }
}