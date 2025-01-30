package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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

/* compiled from: QuoteCollateralChangeResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BM\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJS\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\"\u0010!R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b#\u0010!¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "collateral_change", "new_collateral_balance", "new_account_balance", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "status_before", "status_after", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "getStatus_before", "()Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;", "getStatus_after", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getNew_account_balance", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getNew_collateral_balance", "getCollateral_change", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatus;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class QuoteCollateralChangeResponse extends a {
    public static final ProtoAdapter<QuoteCollateralChangeResponse> ADAPTER;
    public static final Parcelable.Creator<QuoteCollateralChangeResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "collateralChange", tag = 1)
    private final Amount collateral_change;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "newAccountBalance", tag = 5)
    private final Amount new_account_balance;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "newCollateralBalance", tag = 2)
    private final Amount new_collateral_balance;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatus#ADAPTER", jsonName = "statusAfter", tag = 4)
    private final LoanStatus status_after;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatus#ADAPTER", jsonName = "statusBefore", tag = 3)
    private final LoanStatus status_before;

    /* compiled from: QuoteCollateralChangeResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteCollateralChangeResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<QuoteCollateralChangeResponse> protoAdapter = new ProtoAdapter<QuoteCollateralChangeResponse>(c.LENGTH_DELIMITED, e0.b(QuoteCollateralChangeResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.QuoteCollateralChangeResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.QuoteCollateralChangeResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public QuoteCollateralChangeResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                LoanStatus loanStatus = null;
                LoanStatus loanStatus2 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new QuoteCollateralChangeResponse(amount, amount2, amount3, loanStatus, loanStatus2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        amount2 = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 3) {
                        loanStatus = LoanStatus.ADAPTER.decode(reader);
                    } else if (g2 == 4) {
                        loanStatus2 = LoanStatus.ADAPTER.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        amount3 = Amount.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, QuoteCollateralChangeResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCollateral_change() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getCollateral_change());
                }
                if (value.getNew_collateral_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getNew_collateral_balance());
                }
                if (value.getNew_account_balance() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getNew_account_balance());
                }
                if (value.getStatus_before() != null) {
                    LoanStatus.ADAPTER.encodeWithTag(writer, 3, value.getStatus_before());
                }
                if (value.getStatus_after() != null) {
                    LoanStatus.ADAPTER.encodeWithTag(writer, 4, value.getStatus_after());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(QuoteCollateralChangeResponse value) {
                m.h(value, "value");
                if (value.getCollateral_change() == null) {
                    return 0;
                }
                ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getCollateral_change());
                if (value.getNew_collateral_balance() != null) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getNew_collateral_balance());
                    if (value.getNew_account_balance() != null) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(5, value.getNew_account_balance());
                        if (value.getStatus_before() != null) {
                            ProtoAdapter<LoanStatus> protoAdapter3 = LoanStatus.ADAPTER;
                            r1 = (value.getStatus_after() != null ? protoAdapter3.encodedSizeWithTag(4, value.getStatus_after()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(3, value.getStatus_before());
                        }
                        r1 += encodedSizeWithTag3;
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public QuoteCollateralChangeResponse redact(QuoteCollateralChangeResponse value) {
                m.h(value, "value");
                Amount collateral_change = value.getCollateral_change();
                Amount redact = collateral_change != null ? Amount.ADAPTER.redact(collateral_change) : null;
                Amount new_collateral_balance = value.getNew_collateral_balance();
                Amount redact2 = new_collateral_balance != null ? Amount.ADAPTER.redact(new_collateral_balance) : null;
                Amount new_account_balance = value.getNew_account_balance();
                Amount redact3 = new_account_balance != null ? Amount.ADAPTER.redact(new_account_balance) : null;
                LoanStatus status_before = value.getStatus_before();
                LoanStatus redact4 = status_before != null ? LoanStatus.ADAPTER.redact(status_before) : null;
                LoanStatus status_after = value.getStatus_after();
                return value.copy(redact, redact2, redact3, redact4, status_after != null ? LoanStatus.ADAPTER.redact(status_after) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public QuoteCollateralChangeResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ QuoteCollateralChangeResponse(Amount amount, Amount amount2, Amount amount3, LoanStatus loanStatus, LoanStatus loanStatus2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? null : amount2, (i2 & 4) != 0 ? null : amount3, (i2 & 8) != 0 ? null : loanStatus, (i2 & 16) == 0 ? loanStatus2 : null, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ QuoteCollateralChangeResponse copy$default(QuoteCollateralChangeResponse quoteCollateralChangeResponse, Amount amount, Amount amount2, Amount amount3, LoanStatus loanStatus, LoanStatus loanStatus2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            amount = quoteCollateralChangeResponse.collateral_change;
        }
        if ((i2 & 2) != 0) {
            amount2 = quoteCollateralChangeResponse.new_collateral_balance;
        }
        Amount amount4 = amount2;
        if ((i2 & 4) != 0) {
            amount3 = quoteCollateralChangeResponse.new_account_balance;
        }
        Amount amount5 = amount3;
        if ((i2 & 8) != 0) {
            loanStatus = quoteCollateralChangeResponse.status_before;
        }
        LoanStatus loanStatus3 = loanStatus;
        if ((i2 & 16) != 0) {
            loanStatus2 = quoteCollateralChangeResponse.status_after;
        }
        LoanStatus loanStatus4 = loanStatus2;
        if ((i2 & 32) != 0) {
            iVar = quoteCollateralChangeResponse.unknownFields();
        }
        return quoteCollateralChangeResponse.copy(amount, amount4, amount5, loanStatus3, loanStatus4, iVar);
    }

    public final QuoteCollateralChangeResponse copy(Amount amount, Amount amount2, Amount amount3, LoanStatus loanStatus, LoanStatus loanStatus2, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new QuoteCollateralChangeResponse(amount, amount2, amount3, loanStatus, loanStatus2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof QuoteCollateralChangeResponse) {
            QuoteCollateralChangeResponse quoteCollateralChangeResponse = (QuoteCollateralChangeResponse) obj;
            return m.c(unknownFields(), quoteCollateralChangeResponse.unknownFields()) && m.c(this.collateral_change, quoteCollateralChangeResponse.collateral_change) && m.c(this.new_collateral_balance, quoteCollateralChangeResponse.new_collateral_balance) && m.c(this.new_account_balance, quoteCollateralChangeResponse.new_account_balance) && m.c(this.status_before, quoteCollateralChangeResponse.status_before) && m.c(this.status_after, quoteCollateralChangeResponse.status_after);
        }
        return false;
    }

    public final Amount getCollateral_change() {
        return this.collateral_change;
    }

    public final Amount getNew_account_balance() {
        return this.new_account_balance;
    }

    public final Amount getNew_collateral_balance() {
        return this.new_collateral_balance;
    }

    public final LoanStatus getStatus_after() {
        return this.status_after;
    }

    public final LoanStatus getStatus_before() {
        return this.status_before;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.collateral_change;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.new_collateral_balance;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.new_account_balance;
            int hashCode4 = (hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            LoanStatus loanStatus = this.status_before;
            int hashCode5 = (hashCode4 + (loanStatus != null ? loanStatus.hashCode() : 0)) * 37;
            LoanStatus loanStatus2 = this.status_after;
            int hashCode6 = hashCode5 + (loanStatus2 != null ? loanStatus2.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m382newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.collateral_change != null) {
            arrayList.add("collateral_change=" + this.collateral_change);
        }
        if (this.new_collateral_balance != null) {
            arrayList.add("new_collateral_balance=" + this.new_collateral_balance);
        }
        if (this.new_account_balance != null) {
            arrayList.add("new_account_balance=" + this.new_account_balance);
        }
        if (this.status_before != null) {
            arrayList.add("status_before=" + this.status_before);
        }
        if (this.status_after != null) {
            arrayList.add("status_after=" + this.status_after);
        }
        h0 = z.h0(arrayList, ", ", "QuoteCollateralChangeResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuoteCollateralChangeResponse(Amount amount, Amount amount2, Amount amount3, LoanStatus loanStatus, LoanStatus loanStatus2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.collateral_change = amount;
        this.new_collateral_balance = amount2;
        this.new_account_balance = amount3;
        this.status_before = loanStatus;
        this.status_after = loanStatus2;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m382newBuilder() {
        throw new AssertionError();
    }
}