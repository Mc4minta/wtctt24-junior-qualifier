package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
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

/* compiled from: CreateSendRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B]\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJc\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b&\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b'\u0010%R\u001c\u0010\u0019\u001a\u00020\u00188\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b+\u0010\u000f¨\u0006/"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "from_account", ApiConstants.TO, "payment_method", "destination_tag", "note", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "send_type", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendRequest;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getTo", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "getNote", "getFrom_account", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "getSend_type", "()Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;", "getDestination_tag", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/sends/SendType;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CreateSendRequest extends a {
    public static final ProtoAdapter<CreateSendRequest> ADAPTER;
    public static final Parcelable.Creator<CreateSendRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 1)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "destinationTag", tag = 5)
    private final String destination_tag;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "fromAccount", tag = 2)
    private final Ref from_account;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String note;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "paymentMethod", tag = 4)
    private final Ref payment_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.sends.SendType#ADAPTER", jsonName = "sendType", tag = 7)
    private final SendType send_type;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String to;

    /* compiled from: CreateSendRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(CreateSendRequest.class);
        ProtoAdapter<CreateSendRequest> protoAdapter = new ProtoAdapter<CreateSendRequest>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.CreateSendRequest") { // from class: com.coinbase.android.apiv3.generated.authed.sends.CreateSendRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateSendRequest decode(k reader) {
                m.h(reader, "reader");
                SendType sendType = SendType.UNKNOWN;
                long d2 = reader.d();
                SendType sendType2 = sendType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                Amount amount = null;
                Ref ref = null;
                Ref ref2 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CreateSendRequest(amount, ref, str, ref2, str2, str3, sendType2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 2:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        case 3:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            ref2 = Ref.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            try {
                                sendType2 = SendType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CreateSendRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getAmount());
                }
                if (value.getFrom_account() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 2, value.getFrom_account());
                }
                if (!m.c(value.getTo(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTo());
                }
                if (value.getPayment_method() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 4, value.getPayment_method());
                }
                if (!m.c(value.getDestination_tag(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getDestination_tag());
                }
                if (!m.c(value.getNote(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getNote());
                }
                if (value.getSend_type() != SendType.UNKNOWN) {
                    SendType.ADAPTER.encodeWithTag(writer, 7, value.getSend_type());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CreateSendRequest value) {
                m.h(value, "value");
                if (value.getAmount() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Amount.ADAPTER.encodedSizeWithTag(1, value.getAmount());
                if (value.getFrom_account() != null) {
                    ProtoAdapter<Ref> protoAdapter2 = Ref.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getFrom_account());
                    if (!m.c(value.getTo(), "")) {
                        ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getTo());
                        if (value.getPayment_method() != null) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getPayment_method());
                            if (!m.c(value.getDestination_tag(), "")) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getDestination_tag());
                                if (!m.c(value.getNote(), "")) {
                                    r1 = (value.getSend_type() != SendType.UNKNOWN ? SendType.ADAPTER.encodedSizeWithTag(7, value.getSend_type()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(6, value.getNote());
                                }
                                r1 += encodedSizeWithTag5;
                            }
                            r1 += encodedSizeWithTag4;
                        }
                        r1 += encodedSizeWithTag3;
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CreateSendRequest redact(CreateSendRequest value) {
                CreateSendRequest copy;
                m.h(value, "value");
                Amount amount = value.getAmount();
                Amount redact = amount != null ? Amount.ADAPTER.redact(amount) : null;
                Ref from_account = value.getFrom_account();
                Ref redact2 = from_account != null ? Ref.ADAPTER.redact(from_account) : null;
                Ref payment_method = value.getPayment_method();
                copy = value.copy((r18 & 1) != 0 ? value.amount : redact, (r18 & 2) != 0 ? value.from_account : redact2, (r18 & 4) != 0 ? value.to : null, (r18 & 8) != 0 ? value.payment_method : payment_method != null ? Ref.ADAPTER.redact(payment_method) : null, (r18 & 16) != 0 ? value.destination_tag : null, (r18 & 32) != 0 ? value.note : null, (r18 & 64) != 0 ? value.send_type : null, (r18 & 128) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CreateSendRequest() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ CreateSendRequest(Amount amount, Ref ref, String str, Ref ref2, String str2, String str3, SendType sendType, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? null : ref, (i2 & 4) != 0 ? "" : str, (i2 & 8) == 0 ? ref2 : null, (i2 & 16) != 0 ? "" : str2, (i2 & 32) == 0 ? str3 : "", (i2 & 64) != 0 ? SendType.UNKNOWN : sendType, (i2 & 128) != 0 ? i.a : iVar);
    }

    public final CreateSendRequest copy(Amount amount, Ref ref, String to, Ref ref2, String destination_tag, String note, SendType send_type, i unknownFields) {
        m.h(to, "to");
        m.h(destination_tag, "destination_tag");
        m.h(note, "note");
        m.h(send_type, "send_type");
        m.h(unknownFields, "unknownFields");
        return new CreateSendRequest(amount, ref, to, ref2, destination_tag, note, send_type, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreateSendRequest) {
            CreateSendRequest createSendRequest = (CreateSendRequest) obj;
            return m.c(unknownFields(), createSendRequest.unknownFields()) && m.c(this.amount, createSendRequest.amount) && m.c(this.from_account, createSendRequest.from_account) && m.c(this.to, createSendRequest.to) && m.c(this.payment_method, createSendRequest.payment_method) && m.c(this.destination_tag, createSendRequest.destination_tag) && m.c(this.note, createSendRequest.note) && this.send_type == createSendRequest.send_type;
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
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

    public final Ref getPayment_method() {
        return this.payment_method;
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
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Ref ref = this.from_account;
            int hashCode3 = (((hashCode2 + (ref != null ? ref.hashCode() : 0)) * 37) + this.to.hashCode()) * 37;
            Ref ref2 = this.payment_method;
            int hashCode4 = ((((((hashCode3 + (ref2 != null ? ref2.hashCode() : 0)) * 37) + this.destination_tag.hashCode()) * 37) + this.note.hashCode()) * 37) + this.send_type.hashCode();
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m462newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.from_account != null) {
            arrayList.add("from_account=" + this.from_account);
        }
        arrayList.add("to=" + b.c(this.to));
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        arrayList.add("destination_tag=" + b.c(this.destination_tag));
        arrayList.add("note=" + b.c(this.note));
        arrayList.add("send_type=" + this.send_type);
        h0 = z.h0(arrayList, ", ", "CreateSendRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m462newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateSendRequest(Amount amount, Ref ref, String to, Ref ref2, String destination_tag, String note, SendType send_type, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(to, "to");
        m.h(destination_tag, "destination_tag");
        m.h(note, "note");
        m.h(send_type, "send_type");
        m.h(unknownFields, "unknownFields");
        this.amount = amount;
        this.from_account = ref;
        this.to = to;
        this.payment_method = ref2;
        this.destination_tag = destination_tag;
        this.note = note;
        this.send_type = send_type;
    }
}