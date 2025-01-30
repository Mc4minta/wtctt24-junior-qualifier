package com.coinbase.android.apiv3.generated.authed.card;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: Reward.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,BU\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b)\u0010\u000f¨\u0006-"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/Reward;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "icon_url", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "transaction", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "fiat_equivalent_amount", "transaction_statement_descriptor", "Lcom/google/protobuf/u;", "credited_at", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/google/protobuf/u;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/Reward;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getFiat_equivalent_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getTransaction", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "Lcom/google/protobuf/u;", "getCredited_at", "()Lcom/google/protobuf/u;", "getAmount", "Ljava/lang/String;", "getTransaction_statement_descriptor", "getIcon_url", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/google/protobuf/u;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Reward extends a {
    public static final ProtoAdapter<Reward> ADAPTER;
    public static final Parcelable.Creator<Reward> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 3)
    private final Amount amount;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "creditedAt", tag = 6)
    private final u credited_at;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "fiatEquivalentAmount", tag = 4)
    private final Amount fiat_equivalent_amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 1)
    private final String icon_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", tag = 2)
    private final Ref transaction;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "transactionStatementDescriptor", tag = 5)
    private final String transaction_statement_descriptor;

    /* compiled from: Reward.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/Reward$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/Reward;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Reward.class);
        ProtoAdapter<Reward> protoAdapter = new ProtoAdapter<Reward>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.card.Reward") { // from class: com.coinbase.android.apiv3.generated.authed.card.Reward$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Reward decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                Ref ref = null;
                Amount amount = null;
                Amount amount2 = null;
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Reward(str, ref, amount, amount2, str2, uVar, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        case 3:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            uVar = u.a.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Reward value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getIcon_url());
                }
                if (value.getTransaction() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 2, value.getTransaction());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getAmount());
                }
                if (value.getFiat_equivalent_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getFiat_equivalent_amount());
                }
                if (!m.c(value.getTransaction_statement_descriptor(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getTransaction_statement_descriptor());
                }
                if (value.getCredited_at() != null) {
                    u.a.encodeWithTag(writer, 6, value.getCredited_at());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Reward value) {
                m.h(value, "value");
                if (m.c(value.getIcon_url(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getIcon_url());
                if (value.getTransaction() != null) {
                    int encodedSizeWithTag2 = Ref.ADAPTER.encodedSizeWithTag(2, value.getTransaction());
                    if (value.getAmount() != null) {
                        ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getAmount());
                        if (value.getFiat_equivalent_amount() != null) {
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(4, value.getFiat_equivalent_amount());
                            if (!m.c(value.getTransaction_statement_descriptor(), "")) {
                                r2 = (value.getCredited_at() != null ? u.a.encodedSizeWithTag(6, value.getCredited_at()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getTransaction_statement_descriptor());
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
            public Reward redact(Reward value) {
                m.h(value, "value");
                Ref transaction = value.getTransaction();
                Ref redact = transaction != null ? Ref.ADAPTER.redact(transaction) : null;
                Amount amount = value.getAmount();
                Amount redact2 = amount != null ? Amount.ADAPTER.redact(amount) : null;
                Amount fiat_equivalent_amount = value.getFiat_equivalent_amount();
                Amount redact3 = fiat_equivalent_amount != null ? Amount.ADAPTER.redact(fiat_equivalent_amount) : null;
                u credited_at = value.getCredited_at();
                return Reward.copy$default(value, null, redact, redact2, redact3, null, credited_at != null ? u.a.redact(credited_at) : null, i.a, 17, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Reward() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ Reward(String str, Ref ref, Amount amount, Amount amount2, String str2, u uVar, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : ref, (i2 & 4) != 0 ? null : amount, (i2 & 8) != 0 ? null : amount2, (i2 & 16) == 0 ? str2 : "", (i2 & 32) == 0 ? uVar : null, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Reward copy$default(Reward reward, String str, Ref ref, Amount amount, Amount amount2, String str2, u uVar, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reward.icon_url;
        }
        if ((i2 & 2) != 0) {
            ref = reward.transaction;
        }
        Ref ref2 = ref;
        if ((i2 & 4) != 0) {
            amount = reward.amount;
        }
        Amount amount3 = amount;
        if ((i2 & 8) != 0) {
            amount2 = reward.fiat_equivalent_amount;
        }
        Amount amount4 = amount2;
        if ((i2 & 16) != 0) {
            str2 = reward.transaction_statement_descriptor;
        }
        String str3 = str2;
        if ((i2 & 32) != 0) {
            uVar = reward.credited_at;
        }
        u uVar2 = uVar;
        if ((i2 & 64) != 0) {
            iVar = reward.unknownFields();
        }
        return reward.copy(str, ref2, amount3, amount4, str3, uVar2, iVar);
    }

    public final Reward copy(String icon_url, Ref ref, Amount amount, Amount amount2, String transaction_statement_descriptor, u uVar, i unknownFields) {
        m.h(icon_url, "icon_url");
        m.h(transaction_statement_descriptor, "transaction_statement_descriptor");
        m.h(unknownFields, "unknownFields");
        return new Reward(icon_url, ref, amount, amount2, transaction_statement_descriptor, uVar, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Reward) {
            Reward reward = (Reward) obj;
            return m.c(unknownFields(), reward.unknownFields()) && m.c(this.icon_url, reward.icon_url) && m.c(this.transaction, reward.transaction) && m.c(this.amount, reward.amount) && m.c(this.fiat_equivalent_amount, reward.fiat_equivalent_amount) && m.c(this.transaction_statement_descriptor, reward.transaction_statement_descriptor) && m.c(this.credited_at, reward.credited_at);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final u getCredited_at() {
        return this.credited_at;
    }

    public final Amount getFiat_equivalent_amount() {
        return this.fiat_equivalent_amount;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final Ref getTransaction() {
        return this.transaction;
    }

    public final String getTransaction_statement_descriptor() {
        return this.transaction_statement_descriptor;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.icon_url.hashCode()) * 37;
            Ref ref = this.transaction;
            int hashCode2 = (hashCode + (ref != null ? ref.hashCode() : 0)) * 37;
            Amount amount = this.amount;
            int hashCode3 = (hashCode2 + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.fiat_equivalent_amount;
            int hashCode4 = (((hashCode3 + (amount2 != null ? amount2.hashCode() : 0)) * 37) + this.transaction_statement_descriptor.hashCode()) * 37;
            u uVar = this.credited_at;
            int hashCode5 = hashCode4 + (uVar != null ? uVar.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m321newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("icon_url=" + b.c(this.icon_url));
        if (this.transaction != null) {
            arrayList.add("transaction=" + this.transaction);
        }
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.fiat_equivalent_amount != null) {
            arrayList.add("fiat_equivalent_amount=" + this.fiat_equivalent_amount);
        }
        arrayList.add("transaction_statement_descriptor=" + b.c(this.transaction_statement_descriptor));
        if (this.credited_at != null) {
            arrayList.add("credited_at=" + this.credited_at);
        }
        h0 = z.h0(arrayList, ", ", "Reward{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Reward(String icon_url, Ref ref, Amount amount, Amount amount2, String transaction_statement_descriptor, u uVar, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(icon_url, "icon_url");
        m.h(transaction_statement_descriptor, "transaction_statement_descriptor");
        m.h(unknownFields, "unknownFields");
        this.icon_url = icon_url;
        this.transaction = ref;
        this.amount = amount;
        this.fiat_equivalent_amount = amount2;
        this.transaction_statement_descriptor = transaction_statement_descriptor;
        this.credited_at = uVar;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m321newBuilder() {
        throw new AssertionError();
    }
}