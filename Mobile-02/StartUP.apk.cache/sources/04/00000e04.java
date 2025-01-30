package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.Ref;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PreviewSendAmountRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B)\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "from_account", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountRequest;", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getFrom_account", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PreviewSendAmountRequest extends a {
    public static final ProtoAdapter<PreviewSendAmountRequest> ADAPTER;
    public static final Parcelable.Creator<PreviewSendAmountRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 1)
    private final Amount amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "fromAccount", tag = 2)
    private final Ref from_account;

    /* compiled from: PreviewSendAmountRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(PreviewSendAmountRequest.class);
        ProtoAdapter<PreviewSendAmountRequest> protoAdapter = new ProtoAdapter<PreviewSendAmountRequest>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.PreviewSendAmountRequest") { // from class: com.coinbase.android.apiv3.generated.authed.sends.PreviewSendAmountRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PreviewSendAmountRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                Ref ref = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PreviewSendAmountRequest(amount, ref, reader.e(d2));
                    }
                    if (g2 == 1) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        ref = Ref.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PreviewSendAmountRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getAmount());
                }
                if (value.getFrom_account() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 2, value.getFrom_account());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PreviewSendAmountRequest value) {
                m.h(value, "value");
                if (value.getAmount() == null) {
                    return 0;
                }
                return (value.getFrom_account() != null ? Ref.ADAPTER.encodedSizeWithTag(2, value.getFrom_account()) + value.unknownFields().Q() : 0) + Amount.ADAPTER.encodedSizeWithTag(1, value.getAmount());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PreviewSendAmountRequest redact(PreviewSendAmountRequest value) {
                m.h(value, "value");
                Amount amount = value.getAmount();
                Amount redact = amount != null ? Amount.ADAPTER.redact(amount) : null;
                Ref from_account = value.getFrom_account();
                return value.copy(redact, from_account != null ? Ref.ADAPTER.redact(from_account) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PreviewSendAmountRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ PreviewSendAmountRequest(Amount amount, Ref ref, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? null : ref, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PreviewSendAmountRequest copy$default(PreviewSendAmountRequest previewSendAmountRequest, Amount amount, Ref ref, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            amount = previewSendAmountRequest.amount;
        }
        if ((i2 & 2) != 0) {
            ref = previewSendAmountRequest.from_account;
        }
        if ((i2 & 4) != 0) {
            iVar = previewSendAmountRequest.unknownFields();
        }
        return previewSendAmountRequest.copy(amount, ref, iVar);
    }

    public final PreviewSendAmountRequest copy(Amount amount, Ref ref, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new PreviewSendAmountRequest(amount, ref, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PreviewSendAmountRequest) {
            PreviewSendAmountRequest previewSendAmountRequest = (PreviewSendAmountRequest) obj;
            return m.c(unknownFields(), previewSendAmountRequest.unknownFields()) && m.c(this.amount, previewSendAmountRequest.amount) && m.c(this.from_account, previewSendAmountRequest.from_account);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final Ref getFrom_account() {
        return this.from_account;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Ref ref = this.from_account;
            int hashCode3 = hashCode2 + (ref != null ? ref.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m464newBuilder();
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
        h0 = z.h0(arrayList, ", ", "PreviewSendAmountRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewSendAmountRequest(Amount amount, Ref ref, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.amount = amount;
        this.from_account = ref;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m464newBuilder() {
        throw new AssertionError();
    }
}