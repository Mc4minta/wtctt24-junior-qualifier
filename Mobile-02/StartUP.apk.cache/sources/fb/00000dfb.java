package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Ref;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: CreateSendMaxRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'BE\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b!\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendMaxRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", ApiConstants.TO, "Lcom/coinbase/android/apiv3/generated/common/Ref;", "from_account", "destination_tag", "note", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "send_type", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendMaxRequest;", "Ljava/lang/String;", "getDestination_tag", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "getSend_type", "()Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "getTo", "getNote", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getFrom_account", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CreateSendMaxRequest extends a {
    public static final ProtoAdapter<CreateSendMaxRequest> ADAPTER;
    public static final Parcelable.Creator<CreateSendMaxRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "destinationTag", tag = 3)
    private final String destination_tag;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "fromAccount", tag = 2)
    private final Ref from_account;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String note;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.SendType#ADAPTER", jsonName = "sendType", tag = 5)
    private final SendType send_type;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String to;

    /* compiled from: CreateSendMaxRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendMaxRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendMaxRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(CreateSendMaxRequest.class);
        ProtoAdapter<CreateSendMaxRequest> protoAdapter = new ProtoAdapter<CreateSendMaxRequest>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.CreateSendMaxRequest") { // from class: com.coinbase.android.apiv3.generated.authed.sends.CreateSendMaxRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateSendMaxRequest decode(k reader) {
                m.h(reader, "reader");
                SendType sendType = SendType.UNKNOWN;
                long d2 = reader.d();
                SendType sendType2 = sendType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                Ref ref = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CreateSendMaxRequest(str, ref, str2, str3, sendType2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        ref = Ref.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        try {
                            sendType2 = SendType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CreateSendMaxRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTo(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTo());
                }
                if (value.getFrom_account() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 2, value.getFrom_account());
                }
                if (!m.c(value.getDestination_tag(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDestination_tag());
                }
                if (!m.c(value.getNote(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getNote());
                }
                if (value.getSend_type() != SendType.UNKNOWN) {
                    SendType.ADAPTER.encodeWithTag(writer, 5, value.getSend_type());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CreateSendMaxRequest value) {
                m.h(value, "value");
                if (m.c(value.getTo(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTo());
                if (value.getFrom_account() != null) {
                    int encodedSizeWithTag2 = Ref.ADAPTER.encodedSizeWithTag(2, value.getFrom_account());
                    if (!m.c(value.getDestination_tag(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getDestination_tag());
                        if (!m.c(value.getNote(), "")) {
                            r2 = (value.getSend_type() != SendType.UNKNOWN ? SendType.ADAPTER.encodedSizeWithTag(5, value.getSend_type()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(4, value.getNote());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CreateSendMaxRequest redact(CreateSendMaxRequest value) {
                m.h(value, "value");
                Ref from_account = value.getFrom_account();
                return CreateSendMaxRequest.copy$default(value, null, from_account != null ? Ref.ADAPTER.redact(from_account) : null, null, null, null, i.a, 29, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CreateSendMaxRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ CreateSendMaxRequest(String str, Ref ref, String str2, String str3, SendType sendType, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : ref, (i2 & 4) != 0 ? "" : str2, (i2 & 8) == 0 ? str3 : "", (i2 & 16) != 0 ? SendType.UNKNOWN : sendType, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CreateSendMaxRequest copy$default(CreateSendMaxRequest createSendMaxRequest, String str, Ref ref, String str2, String str3, SendType sendType, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createSendMaxRequest.to;
        }
        if ((i2 & 2) != 0) {
            ref = createSendMaxRequest.from_account;
        }
        Ref ref2 = ref;
        if ((i2 & 4) != 0) {
            str2 = createSendMaxRequest.destination_tag;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = createSendMaxRequest.note;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            sendType = createSendMaxRequest.send_type;
        }
        SendType sendType2 = sendType;
        if ((i2 & 32) != 0) {
            iVar = createSendMaxRequest.unknownFields();
        }
        return createSendMaxRequest.copy(str, ref2, str4, str5, sendType2, iVar);
    }

    public final CreateSendMaxRequest copy(String to, Ref ref, String destination_tag, String note, SendType send_type, i unknownFields) {
        m.h(to, "to");
        m.h(destination_tag, "destination_tag");
        m.h(note, "note");
        m.h(send_type, "send_type");
        m.h(unknownFields, "unknownFields");
        return new CreateSendMaxRequest(to, ref, destination_tag, note, send_type, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreateSendMaxRequest) {
            CreateSendMaxRequest createSendMaxRequest = (CreateSendMaxRequest) obj;
            return m.c(unknownFields(), createSendMaxRequest.unknownFields()) && m.c(this.to, createSendMaxRequest.to) && m.c(this.from_account, createSendMaxRequest.from_account) && m.c(this.destination_tag, createSendMaxRequest.destination_tag) && m.c(this.note, createSendMaxRequest.note) && this.send_type == createSendMaxRequest.send_type;
        }
        return false;
    }

    public final String getDestination_tag() {
        return this.destination_tag;
    }

    public final Ref getFrom_account() {
        return this.from_account;
    }

    public final String getNote() {
        return this.note;
    }

    public final SendType getSend_type() {
        return this.send_type;
    }

    public final String getTo() {
        return this.to;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.to.hashCode()) * 37;
            Ref ref = this.from_account;
            int hashCode2 = ((((((hashCode + (ref != null ? ref.hashCode() : 0)) * 37) + this.destination_tag.hashCode()) * 37) + this.note.hashCode()) * 37) + this.send_type.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m461newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("to=" + b.c(this.to));
        if (this.from_account != null) {
            arrayList.add("from_account=" + this.from_account);
        }
        arrayList.add("destination_tag=" + b.c(this.destination_tag));
        arrayList.add("note=" + b.c(this.note));
        arrayList.add("send_type=" + this.send_type);
        h0 = z.h0(arrayList, ", ", "CreateSendMaxRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m461newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateSendMaxRequest(String to, Ref ref, String destination_tag, String note, SendType send_type, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(to, "to");
        m.h(destination_tag, "destination_tag");
        m.h(note, "note");
        m.h(send_type, "send_type");
        m.h(unknownFields, "unknownFields");
        this.to = to;
        this.from_account = ref;
        this.destination_tag = destination_tag;
        this.note = note;
        this.send_type = send_type;
    }
}