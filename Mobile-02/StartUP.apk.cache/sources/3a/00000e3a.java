package com.coinbase.android.apiv3.generated.authed.tutorials;

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

/* compiled from: GetTutorialRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/tutorials/GetTutorialRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "tutorial_name", "asset_uuid", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/tutorials/GetTutorialRequest;", "Ljava/lang/String;", "getTutorial_name", "getAsset_uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetTutorialRequest extends a {
    public static final ProtoAdapter<GetTutorialRequest> ADAPTER;
    public static final Parcelable.Creator<GetTutorialRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetUuid", tag = 2)
    private final String asset_uuid;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "tutorialName", tag = 1)
    private final String tutorial_name;

    /* compiled from: GetTutorialRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/tutorials/GetTutorialRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/tutorials/GetTutorialRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetTutorialRequest> protoAdapter = new ProtoAdapter<GetTutorialRequest>(c.LENGTH_DELIMITED, e0.b(GetTutorialRequest.class), "type.googleapis.com/coinbase.public_api.authed.tutorials.GetTutorialRequest") { // from class: com.coinbase.android.apiv3.generated.authed.tutorials.GetTutorialRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetTutorialRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetTutorialRequest(str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetTutorialRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTutorial_name(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTutorial_name());
                }
                if (!m.c(value.getAsset_uuid(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getAsset_uuid());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetTutorialRequest value) {
                m.h(value, "value");
                if (m.c(value.getTutorial_name(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return (m.c(value.getAsset_uuid(), "") ? 0 : protoAdapter2.encodedSizeWithTag(2, value.getAsset_uuid()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(1, value.getTutorial_name());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetTutorialRequest redact(GetTutorialRequest value) {
                m.h(value, "value");
                return GetTutorialRequest.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetTutorialRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetTutorialRequest(String str, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetTutorialRequest copy$default(GetTutorialRequest getTutorialRequest, String str, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getTutorialRequest.tutorial_name;
        }
        if ((i2 & 2) != 0) {
            str2 = getTutorialRequest.asset_uuid;
        }
        if ((i2 & 4) != 0) {
            iVar = getTutorialRequest.unknownFields();
        }
        return getTutorialRequest.copy(str, str2, iVar);
    }

    public final GetTutorialRequest copy(String tutorial_name, String asset_uuid, i unknownFields) {
        m.h(tutorial_name, "tutorial_name");
        m.h(asset_uuid, "asset_uuid");
        m.h(unknownFields, "unknownFields");
        return new GetTutorialRequest(tutorial_name, asset_uuid, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetTutorialRequest) {
            GetTutorialRequest getTutorialRequest = (GetTutorialRequest) obj;
            return m.c(unknownFields(), getTutorialRequest.unknownFields()) && m.c(this.tutorial_name, getTutorialRequest.tutorial_name) && m.c(this.asset_uuid, getTutorialRequest.asset_uuid);
        }
        return false;
    }

    public final String getAsset_uuid() {
        return this.asset_uuid;
    }

    public final String getTutorial_name() {
        return this.tutorial_name;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.tutorial_name.hashCode()) * 37) + this.asset_uuid.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m479newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("tutorial_name=" + b.c(this.tutorial_name));
        arrayList.add("asset_uuid=" + b.c(this.asset_uuid));
        h0 = z.h0(arrayList, ", ", "GetTutorialRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTutorialRequest(String tutorial_name, String asset_uuid, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(tutorial_name, "tutorial_name");
        m.h(asset_uuid, "asset_uuid");
        m.h(unknownFields, "unknownFields");
        this.tutorial_name = tutorial_name;
        this.asset_uuid = asset_uuid;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m479newBuilder() {
        throw new AssertionError();
    }
}