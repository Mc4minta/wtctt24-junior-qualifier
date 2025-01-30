package com.coinbase.android.apiv3.generated.authed.portfolio_performance;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.swap.models.SwapConfirmationArgs;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: AccountChange.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*BY\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ_\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0017\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b!\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/AccountChange;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/protobuf/u;", "timestamp", "currency_type", "transaction_type", "amount", ApiConstants.CURRENCY, "total_usd", "changes_fiat_invested", "Lj/i;", "unknownFields", "copy", "(Lcom/google/protobuf/u;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/AccountChange;", "Z", "getChanges_fiat_invested", "()Z", "Ljava/lang/String;", "getAmount", "getTransaction_type", "Lcom/google/protobuf/u;", "getTimestamp", "()Lcom/google/protobuf/u;", "getCurrency", "getTotal_usd", "getCurrency_type", "<init>", "(Lcom/google/protobuf/u;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AccountChange extends a {
    public static final ProtoAdapter<AccountChange> ADAPTER;
    public static final Parcelable.Creator<AccountChange> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "changesFiatInvested", tag = 7)
    private final boolean changes_fiat_invested;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String currency;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = SwapConfirmationArgs.currencyTypeKey, tag = 2)
    private final String currency_type;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", tag = 1)
    private final u timestamp;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "totalUsd", tag = 6)
    private final String total_usd;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "transactionType", tag = 3)
    private final String transaction_type;

    /* compiled from: AccountChange.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/AccountChange$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/portfolio_performance/AccountChange;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AccountChange> protoAdapter = new ProtoAdapter<AccountChange>(c.LENGTH_DELIMITED, e0.b(AccountChange.class), "type.googleapis.com/coinbase.public_api.authed.portfolio_performance.AccountChange") { // from class: com.coinbase.android.apiv3.generated.authed.portfolio_performance.AccountChange$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AccountChange decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                u uVar = null;
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AccountChange(uVar, str, str2, str3, str4, str5, z, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            uVar = u.a.decode(reader);
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AccountChange value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getTimestamp() != null) {
                    u.a.encodeWithTag(writer, 1, value.getTimestamp());
                }
                if (!m.c(value.getCurrency_type(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCurrency_type());
                }
                if (!m.c(value.getTransaction_type(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTransaction_type());
                }
                if (!m.c(value.getAmount(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getAmount());
                }
                if (!m.c(value.getCurrency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getCurrency());
                }
                if (!m.c(value.getTotal_usd(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getTotal_usd());
                }
                if (value.getChanges_fiat_invested()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 7, Boolean.valueOf(value.getChanges_fiat_invested()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AccountChange value) {
                m.h(value, "value");
                if (value.getTimestamp() == null) {
                    return 0;
                }
                int encodedSizeWithTag = u.a.encodedSizeWithTag(1, value.getTimestamp());
                if (!m.c(value.getCurrency_type(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getCurrency_type());
                    if (!m.c(value.getTransaction_type(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getTransaction_type());
                        if (!m.c(value.getAmount(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getAmount());
                            if (!m.c(value.getCurrency(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getCurrency());
                                if (!m.c(value.getTotal_usd(), "")) {
                                    r1 = (value.getChanges_fiat_invested() ? ProtoAdapter.BOOL.encodedSizeWithTag(7, Boolean.valueOf(value.getChanges_fiat_invested())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(6, value.getTotal_usd());
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
            public AccountChange redact(AccountChange value) {
                m.h(value, "value");
                u timestamp = value.getTimestamp();
                return AccountChange.copy$default(value, timestamp != null ? u.a.redact(timestamp) : null, null, null, null, null, null, false, i.a, 126, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AccountChange() {
        this(null, null, null, null, null, null, false, null, 255, null);
    }

    public /* synthetic */ AccountChange(u uVar, String str, String str2, String str3, String str4, String str5, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : uVar, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AccountChange copy$default(AccountChange accountChange, u uVar, String str, String str2, String str3, String str4, String str5, boolean z, i iVar, int i2, Object obj) {
        return accountChange.copy((i2 & 1) != 0 ? accountChange.timestamp : uVar, (i2 & 2) != 0 ? accountChange.currency_type : str, (i2 & 4) != 0 ? accountChange.transaction_type : str2, (i2 & 8) != 0 ? accountChange.amount : str3, (i2 & 16) != 0 ? accountChange.currency : str4, (i2 & 32) != 0 ? accountChange.total_usd : str5, (i2 & 64) != 0 ? accountChange.changes_fiat_invested : z, (i2 & 128) != 0 ? accountChange.unknownFields() : iVar);
    }

    public final AccountChange copy(u uVar, String currency_type, String transaction_type, String amount, String currency, String total_usd, boolean z, i unknownFields) {
        m.h(currency_type, "currency_type");
        m.h(transaction_type, "transaction_type");
        m.h(amount, "amount");
        m.h(currency, "currency");
        m.h(total_usd, "total_usd");
        m.h(unknownFields, "unknownFields");
        return new AccountChange(uVar, currency_type, transaction_type, amount, currency, total_usd, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChange) {
            AccountChange accountChange = (AccountChange) obj;
            return m.c(unknownFields(), accountChange.unknownFields()) && m.c(this.timestamp, accountChange.timestamp) && m.c(this.currency_type, accountChange.currency_type) && m.c(this.transaction_type, accountChange.transaction_type) && m.c(this.amount, accountChange.amount) && m.c(this.currency, accountChange.currency) && m.c(this.total_usd, accountChange.total_usd) && this.changes_fiat_invested == accountChange.changes_fiat_invested;
        }
        return false;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final boolean getChanges_fiat_invested() {
        return this.changes_fiat_invested;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getCurrency_type() {
        return this.currency_type;
    }

    public final u getTimestamp() {
        return this.timestamp;
    }

    public final String getTotal_usd() {
        return this.total_usd;
    }

    public final String getTransaction_type() {
        return this.transaction_type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            u uVar = this.timestamp;
            int hashCode2 = ((((((((((((hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.currency_type.hashCode()) * 37) + this.transaction_type.hashCode()) * 37) + this.amount.hashCode()) * 37) + this.currency.hashCode()) * 37) + this.total_usd.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.changes_fiat_invested);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m443newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.timestamp != null) {
            arrayList.add("timestamp=" + this.timestamp);
        }
        arrayList.add("currency_type=" + b.c(this.currency_type));
        arrayList.add("transaction_type=" + b.c(this.transaction_type));
        arrayList.add("amount=" + b.c(this.amount));
        arrayList.add("currency=" + b.c(this.currency));
        arrayList.add("total_usd=" + b.c(this.total_usd));
        arrayList.add("changes_fiat_invested=" + this.changes_fiat_invested);
        h0 = z.h0(arrayList, ", ", "AccountChange{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountChange(u uVar, String currency_type, String transaction_type, String amount, String currency, String total_usd, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(currency_type, "currency_type");
        m.h(transaction_type, "transaction_type");
        m.h(amount, "amount");
        m.h(currency, "currency");
        m.h(total_usd, "total_usd");
        m.h(unknownFields, "unknownFields");
        this.timestamp = uVar;
        this.currency_type = currency_type;
        this.transaction_type = transaction_type;
        this.amount = amount;
        this.currency = currency;
        this.total_usd = total_usd;
        this.changes_fiat_invested = z;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m443newBuilder() {
        throw new AssertionError();
    }
}