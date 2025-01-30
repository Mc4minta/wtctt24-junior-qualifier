package com.coinbase.android.apiv3.generated.resources;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: Account.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+Ba\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJg\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b(\u0010\u000f¨\u0006,"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Account;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", ApiConstants.NAME, "Lcom/coinbase/android/apiv3/generated/common/Amount;", "available_balance", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "asset_id", "available_to_send", "available_balance_fiat", "available_to_send_fiat", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/Account;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAvailable_balance_fiat", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAvailable_to_send", "Ljava/lang/String;", "getId", "getAvailable_to_send_fiat", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getAsset_id", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "getAvailable_balance", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Account extends a {
    public static final ProtoAdapter<Account> ADAPTER;
    public static final Parcelable.Creator<Account> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "assetId", tag = 4)
    private final Ref asset_id;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "availableBalance", tag = 3)
    private final Amount available_balance;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "availableBalanceFiat", tag = 6)
    private final Amount available_balance_fiat;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "availableToSend", tag = 5)
    private final Amount available_to_send;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "availableToSendFiat", tag = 7)
    private final Amount available_to_send_fiat;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;

    /* compiled from: Account.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Account$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Account;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Account> protoAdapter = new ProtoAdapter<Account>(c.LENGTH_DELIMITED, e0.b(Account.class), "type.googleapis.com/coinbase.public_api.resources.Account") { // from class: com.coinbase.android.apiv3.generated.resources.Account$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Account decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                Amount amount = null;
                Ref ref = null;
                Amount amount2 = null;
                Amount amount3 = null;
                Amount amount4 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Account(str, str2, amount, ref, amount2, amount3, amount4, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Account value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                if (value.getAvailable_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getAvailable_balance());
                }
                if (value.getAsset_id() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 4, value.getAsset_id());
                }
                if (value.getAvailable_to_send() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getAvailable_to_send());
                }
                if (value.getAvailable_balance_fiat() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getAvailable_balance_fiat());
                }
                if (value.getAvailable_to_send_fiat() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 7, value.getAvailable_to_send_fiat());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Account value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (!m.c(value.getName(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getName());
                    if (value.getAvailable_balance() != null) {
                        ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getAvailable_balance());
                        if (value.getAsset_id() != null) {
                            int encodedSizeWithTag4 = Ref.ADAPTER.encodedSizeWithTag(4, value.getAsset_id());
                            if (value.getAvailable_to_send() != null) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getAvailable_to_send());
                                if (value.getAvailable_balance_fiat() != null) {
                                    r2 = (value.getAvailable_to_send_fiat() != null ? protoAdapter3.encodedSizeWithTag(7, value.getAvailable_to_send_fiat()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(6, value.getAvailable_balance_fiat());
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
            public Account redact(Account value) {
                m.h(value, "value");
                Amount available_balance = value.getAvailable_balance();
                Amount redact = available_balance != null ? Amount.ADAPTER.redact(available_balance) : null;
                Ref asset_id = value.getAsset_id();
                Ref redact2 = asset_id != null ? Ref.ADAPTER.redact(asset_id) : null;
                Amount available_to_send = value.getAvailable_to_send();
                Amount redact3 = available_to_send != null ? Amount.ADAPTER.redact(available_to_send) : null;
                Amount available_balance_fiat = value.getAvailable_balance_fiat();
                Amount redact4 = available_balance_fiat != null ? Amount.ADAPTER.redact(available_balance_fiat) : null;
                Amount available_to_send_fiat = value.getAvailable_to_send_fiat();
                return Account.copy$default(value, null, null, redact, redact2, redact3, redact4, available_to_send_fiat != null ? Amount.ADAPTER.redact(available_to_send_fiat) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Account() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ Account(String str, String str2, Amount amount, Ref ref, Amount amount2, Amount amount3, Amount amount4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? null : amount, (i2 & 8) != 0 ? null : ref, (i2 & 16) != 0 ? null : amount2, (i2 & 32) != 0 ? null : amount3, (i2 & 64) == 0 ? amount4 : null, (i2 & 128) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Account copy$default(Account account, String str, String str2, Amount amount, Ref ref, Amount amount2, Amount amount3, Amount amount4, i iVar, int i2, Object obj) {
        return account.copy((i2 & 1) != 0 ? account.id : str, (i2 & 2) != 0 ? account.name : str2, (i2 & 4) != 0 ? account.available_balance : amount, (i2 & 8) != 0 ? account.asset_id : ref, (i2 & 16) != 0 ? account.available_to_send : amount2, (i2 & 32) != 0 ? account.available_balance_fiat : amount3, (i2 & 64) != 0 ? account.available_to_send_fiat : amount4, (i2 & 128) != 0 ? account.unknownFields() : iVar);
    }

    public final Account copy(String id, String name, Amount amount, Ref ref, Amount amount2, Amount amount3, Amount amount4, i unknownFields) {
        m.h(id, "id");
        m.h(name, "name");
        m.h(unknownFields, "unknownFields");
        return new Account(id, name, amount, ref, amount2, amount3, amount4, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return m.c(unknownFields(), account.unknownFields()) && m.c(this.id, account.id) && m.c(this.name, account.name) && m.c(this.available_balance, account.available_balance) && m.c(this.asset_id, account.asset_id) && m.c(this.available_to_send, account.available_to_send) && m.c(this.available_balance_fiat, account.available_balance_fiat) && m.c(this.available_to_send_fiat, account.available_to_send_fiat);
        }
        return false;
    }

    public final Ref getAsset_id() {
        return this.asset_id;
    }

    public final Amount getAvailable_balance() {
        return this.available_balance;
    }

    public final Amount getAvailable_balance_fiat() {
        return this.available_balance_fiat;
    }

    public final Amount getAvailable_to_send() {
        return this.available_to_send;
    }

    public final Amount getAvailable_to_send_fiat() {
        return this.available_to_send_fiat;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.name.hashCode()) * 37;
            Amount amount = this.available_balance;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Ref ref = this.asset_id;
            int hashCode3 = (hashCode2 + (ref != null ? ref.hashCode() : 0)) * 37;
            Amount amount2 = this.available_to_send;
            int hashCode4 = (hashCode3 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.available_balance_fiat;
            int hashCode5 = (hashCode4 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            Amount amount4 = this.available_to_send_fiat;
            int hashCode6 = hashCode5 + (amount4 != null ? amount4.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m521newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("name=" + b.c(this.name));
        if (this.available_balance != null) {
            arrayList.add("available_balance=" + this.available_balance);
        }
        if (this.asset_id != null) {
            arrayList.add("asset_id=" + this.asset_id);
        }
        if (this.available_to_send != null) {
            arrayList.add("available_to_send=" + this.available_to_send);
        }
        if (this.available_balance_fiat != null) {
            arrayList.add("available_balance_fiat=" + this.available_balance_fiat);
        }
        if (this.available_to_send_fiat != null) {
            arrayList.add("available_to_send_fiat=" + this.available_to_send_fiat);
        }
        h0 = z.h0(arrayList, ", ", "Account{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Account(String id, String name, Amount amount, Ref ref, Amount amount2, Amount amount3, Amount amount4, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(name, "name");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.name = name;
        this.available_balance = amount;
        this.asset_id = ref;
        this.available_to_send = amount2;
        this.available_balance_fiat = amount3;
        this.available_to_send_fiat = amount4;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m521newBuilder() {
        throw new AssertionError();
    }
}