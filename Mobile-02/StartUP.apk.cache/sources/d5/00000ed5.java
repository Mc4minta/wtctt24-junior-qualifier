package com.coinbase.android.apiv3.generated.resources;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.AddressWarning;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.google.protobuf.u;
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

/* compiled from: Address.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00013Bu\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ{\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\u000fR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b+\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b0\u0010\u000f¨\u00064"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Address;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "address", "destination_tag", "deposit_uri", "network", "", "Lcom/coinbase/android/apiv3/generated/common/AddressWarning;", "warnings", "label", "Lcom/google/protobuf/u;", "created_at", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "asset_id", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/Address;", "Ljava/lang/String;", "getAddress", "getNetwork", "Ljava/util/List;", "getWarnings", "()Ljava/util/List;", "Lcom/google/protobuf/u;", "getCreated_at", "()Lcom/google/protobuf/u;", "getId", "getLabel", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getAsset_id", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "getDestination_tag", "getDeposit_uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Address extends a {
    public static final ProtoAdapter<Address> ADAPTER;
    public static final Parcelable.Creator<Address> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String address;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "assetId", tag = 9)
    private final Ref asset_id;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "createdAt", tag = 8)
    private final u created_at;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "depositUri", tag = 4)
    private final String deposit_uri;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "destinationTag", tag = 3)
    private final String destination_tag;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    private final String label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String network;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.AddressWarning#ADAPTER", label = p.a.REPEATED, tag = 6)
    private final List<AddressWarning> warnings;

    /* compiled from: Address.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Address$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Address;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Address.class);
        ProtoAdapter<Address> protoAdapter = new ProtoAdapter<Address>(cVar, b2, "type.googleapis.com/coinbase.public_api.resources.Address") { // from class: com.coinbase.android.apiv3.generated.resources.Address$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Address decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                u uVar = null;
                Ref ref = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Address(str2, str, str3, str4, str5, arrayList, str6, uVar, ref, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            arrayList.add(AddressWarning.ADAPTER.decode(reader));
                            break;
                        case 7:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            uVar = u.a.decode(reader);
                            break;
                        case 9:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Address value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getAddress(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getAddress());
                }
                if (!m.c(value.getDestination_tag(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDestination_tag());
                }
                if (!m.c(value.getDeposit_uri(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getDeposit_uri());
                }
                if (!m.c(value.getNetwork(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getNetwork());
                }
                AddressWarning.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.getWarnings());
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getLabel());
                }
                if (value.getCreated_at() != null) {
                    u.a.encodeWithTag(writer, 8, value.getCreated_at());
                }
                if (value.getAsset_id() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 9, value.getAsset_id());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Address value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (!m.c(value.getAddress(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getAddress());
                    if (!m.c(value.getDestination_tag(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getDestination_tag());
                        if (!m.c(value.getDeposit_uri(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getDeposit_uri());
                            if (!m.c(value.getNetwork(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getNetwork()) + AddressWarning.ADAPTER.asRepeated().encodedSizeWithTag(6, value.getWarnings());
                                if (!m.c(value.getLabel(), "")) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(7, value.getLabel());
                                    if (value.getCreated_at() != null) {
                                        r2 = (value.getAsset_id() != null ? Ref.ADAPTER.encodedSizeWithTag(9, value.getAsset_id()) + value.unknownFields().Q() : 0) + u.a.encodedSizeWithTag(8, value.getCreated_at());
                                    }
                                    r2 += encodedSizeWithTag6;
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Address redact(Address value) {
                Address copy;
                m.h(value, "value");
                List a = b.a(value.getWarnings(), AddressWarning.ADAPTER);
                u created_at = value.getCreated_at();
                u redact = created_at != null ? u.a.redact(created_at) : null;
                Ref asset_id = value.getAsset_id();
                copy = value.copy((r22 & 1) != 0 ? value.id : null, (r22 & 2) != 0 ? value.address : null, (r22 & 4) != 0 ? value.destination_tag : null, (r22 & 8) != 0 ? value.deposit_uri : null, (r22 & 16) != 0 ? value.network : null, (r22 & 32) != 0 ? value.warnings : a, (r22 & 64) != 0 ? value.label : null, (r22 & 128) != 0 ? value.created_at : redact, (r22 & 256) != 0 ? value.asset_id : asset_id != null ? Ref.ADAPTER.redact(asset_id) : null, (r22 & 512) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Address() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ Address(String str, String str2, String str3, String str4, String str5, List list, String str6, u uVar, Ref ref, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? r.g() : list, (i2 & 64) == 0 ? str6 : "", (i2 & 128) != 0 ? null : uVar, (i2 & 256) == 0 ? ref : null, (i2 & 512) != 0 ? i.a : iVar);
    }

    public final Address copy(String id, String address, String destination_tag, String deposit_uri, String network, List<AddressWarning> warnings, String label, u uVar, Ref ref, i unknownFields) {
        m.h(id, "id");
        m.h(address, "address");
        m.h(destination_tag, "destination_tag");
        m.h(deposit_uri, "deposit_uri");
        m.h(network, "network");
        m.h(warnings, "warnings");
        m.h(label, "label");
        m.h(unknownFields, "unknownFields");
        return new Address(id, address, destination_tag, deposit_uri, network, warnings, label, uVar, ref, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return m.c(unknownFields(), address.unknownFields()) && m.c(this.id, address.id) && m.c(this.address, address.address) && m.c(this.destination_tag, address.destination_tag) && m.c(this.deposit_uri, address.deposit_uri) && m.c(this.network, address.network) && m.c(this.warnings, address.warnings) && m.c(this.label, address.label) && m.c(this.created_at, address.created_at) && m.c(this.asset_id, address.asset_id);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Ref getAsset_id() {
        return this.asset_id;
    }

    public final u getCreated_at() {
        return this.created_at;
    }

    public final String getDeposit_uri() {
        return this.deposit_uri;
    }

    public final String getDestination_tag() {
        return this.destination_tag;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getNetwork() {
        return this.network;
    }

    public final List<AddressWarning> getWarnings() {
        return this.warnings;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.address.hashCode()) * 37) + this.destination_tag.hashCode()) * 37) + this.deposit_uri.hashCode()) * 37) + this.network.hashCode()) * 37) + this.warnings.hashCode()) * 37) + this.label.hashCode()) * 37;
            u uVar = this.created_at;
            int hashCode2 = (hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37;
            Ref ref = this.asset_id;
            int hashCode3 = hashCode2 + (ref != null ? ref.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m522newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("address=" + b.c(this.address));
        arrayList.add("destination_tag=" + b.c(this.destination_tag));
        arrayList.add("deposit_uri=" + b.c(this.deposit_uri));
        arrayList.add("network=" + b.c(this.network));
        if (!this.warnings.isEmpty()) {
            arrayList.add("warnings=" + this.warnings);
        }
        arrayList.add("label=" + b.c(this.label));
        if (this.created_at != null) {
            arrayList.add("created_at=" + this.created_at);
        }
        if (this.asset_id != null) {
            arrayList.add("asset_id=" + this.asset_id);
        }
        h0 = z.h0(arrayList, ", ", "Address{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m522newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Address(String id, String address, String destination_tag, String deposit_uri, String network, List<AddressWarning> warnings, String label, u uVar, Ref ref, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(address, "address");
        m.h(destination_tag, "destination_tag");
        m.h(deposit_uri, "deposit_uri");
        m.h(network, "network");
        m.h(warnings, "warnings");
        m.h(label, "label");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.address = address;
        this.destination_tag = destination_tag;
        this.deposit_uri = deposit_uri;
        this.network = network;
        this.warnings = warnings;
        this.label = label;
        this.created_at = uVar;
        this.asset_id = ref;
    }
}