package com.coinbase.android.apiv3.generated.authed.card;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Transaction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 A2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0097\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u009d\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u000fR\u001c\u0010!\u001a\u00020 8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b.\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b/\u0010-R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b1\u00102R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u00105R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b6\u0010-R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b7\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b8\u0010-R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010;R\u001c\u0010\u001f\u001a\u00020\u001e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/Transaction;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "uuid", "icon_url", "statement_descriptor", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "crypto_currency_spent", ApiConstants.FEE, "Lcom/google/protobuf/u;", "created_at", "Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "reward_program", "reward_earned", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "reward", "Lcom/coinbase/android/apiv3/generated/authed/card/TransactionStatus;", "status", "Lcom/coinbase/android/apiv3/generated/authed/card/TransactionType;", "type", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/authed/card/TransactionStatus;Lcom/coinbase/android/apiv3/generated/authed/card/TransactionType;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/Transaction;", "Ljava/lang/String;", "getUuid", "Lcom/coinbase/android/apiv3/generated/authed/card/TransactionType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/card/TransactionType;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getReward_earned", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getStatement_descriptor", "getAmount", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getReward", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "getReward_program", "()Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "getCrypto_currency_spent", "getIcon_url", "getFee", "Lcom/google/protobuf/u;", "getCreated_at", "()Lcom/google/protobuf/u;", "Lcom/coinbase/android/apiv3/generated/authed/card/TransactionStatus;", "getStatus", "()Lcom/coinbase/android/apiv3/generated/authed/card/TransactionStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/authed/card/TransactionStatus;Lcom/coinbase/android/apiv3/generated/authed/card/TransactionType;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Transaction extends a {
    public static final ProtoAdapter<Transaction> ADAPTER;
    public static final Parcelable.Creator<Transaction> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 4)
    private final Amount amount;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "createdAt", tag = 7)
    private final u created_at;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "cryptoCurrencySpent", tag = 5)
    private final Amount crypto_currency_spent;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 6)
    private final Amount fee;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 2)
    private final String icon_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", tag = 10)
    private final Ref reward;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "rewardEarned", tag = 9)
    private final Amount reward_earned;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.RewardProgram#ADAPTER", jsonName = "rewardProgram", tag = 8)
    private final RewardProgram reward_program;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "statementDescriptor", tag = 3)
    private final String statement_descriptor;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.TransactionStatus#ADAPTER", tag = 11)
    private final TransactionStatus status;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.TransactionType#ADAPTER", tag = 12)
    private final TransactionType type;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String uuid;

    /* compiled from: Transaction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/Transaction$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/Transaction;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Transaction.class);
        ProtoAdapter<Transaction> protoAdapter = new ProtoAdapter<Transaction>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.card.Transaction") { // from class: com.coinbase.android.apiv3.generated.authed.card.Transaction$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Transaction decode(k reader) {
                m.h(reader, "reader");
                TransactionStatus transactionStatus = TransactionStatus.TRANSACTION_STATUS_UNKNOWN;
                TransactionType transactionType = TransactionType.TRANSACTION_TYPE_UNKNOWN;
                long d2 = reader.d();
                TransactionStatus transactionStatus2 = transactionStatus;
                TransactionType transactionType2 = transactionType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                u uVar = null;
                RewardProgram rewardProgram = null;
                Amount amount4 = null;
                Ref ref = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Transaction(str, str2, str3, amount, amount2, amount3, uVar, rewardProgram, amount4, ref, transactionStatus2, transactionType2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            uVar = u.a.decode(reader);
                            break;
                        case 8:
                            rewardProgram = RewardProgram.ADAPTER.decode(reader);
                            break;
                        case 9:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        case 10:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        case 11:
                            try {
                                transactionStatus2 = TransactionStatus.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 12:
                            try {
                                transactionType2 = TransactionType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                                break;
                            }
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Transaction value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getUuid(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getUuid());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getIcon_url());
                }
                if (!m.c(value.getStatement_descriptor(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getStatement_descriptor());
                }
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getAmount());
                }
                if (value.getCrypto_currency_spent() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getCrypto_currency_spent());
                }
                if (value.getFee() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getFee());
                }
                if (value.getCreated_at() != null) {
                    u.a.encodeWithTag(writer, 7, value.getCreated_at());
                }
                if (value.getReward_program() != null) {
                    RewardProgram.ADAPTER.encodeWithTag(writer, 8, value.getReward_program());
                }
                if (value.getReward_earned() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 9, value.getReward_earned());
                }
                if (value.getReward() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 10, value.getReward());
                }
                if (value.getStatus() != TransactionStatus.TRANSACTION_STATUS_UNKNOWN) {
                    TransactionStatus.ADAPTER.encodeWithTag(writer, 11, value.getStatus());
                }
                if (value.getType() != TransactionType.TRANSACTION_TYPE_UNKNOWN) {
                    TransactionType.ADAPTER.encodeWithTag(writer, 12, value.getType());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Transaction value) {
                m.h(value, "value");
                if (m.c(value.getUuid(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getUuid());
                if (!m.c(value.getIcon_url(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getIcon_url());
                    if (!m.c(value.getStatement_descriptor(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getStatement_descriptor());
                        if (value.getAmount() != null) {
                            ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(4, value.getAmount());
                            if (value.getCrypto_currency_spent() != null) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getCrypto_currency_spent());
                                if (value.getFee() != null) {
                                    int encodedSizeWithTag6 = protoAdapter3.encodedSizeWithTag(6, value.getFee());
                                    if (value.getCreated_at() != null) {
                                        int encodedSizeWithTag7 = u.a.encodedSizeWithTag(7, value.getCreated_at());
                                        if (value.getReward_program() != null) {
                                            int encodedSizeWithTag8 = RewardProgram.ADAPTER.encodedSizeWithTag(8, value.getReward_program());
                                            if (value.getReward_earned() != null) {
                                                int encodedSizeWithTag9 = protoAdapter3.encodedSizeWithTag(9, value.getReward_earned());
                                                if (value.getReward() != null) {
                                                    int encodedSizeWithTag10 = Ref.ADAPTER.encodedSizeWithTag(10, value.getReward());
                                                    if (value.getStatus() != TransactionStatus.TRANSACTION_STATUS_UNKNOWN) {
                                                        r2 = (value.getType() != TransactionType.TRANSACTION_TYPE_UNKNOWN ? TransactionType.ADAPTER.encodedSizeWithTag(12, value.getType()) + value.unknownFields().Q() : 0) + TransactionStatus.ADAPTER.encodedSizeWithTag(11, value.getStatus());
                                                    }
                                                    r2 += encodedSizeWithTag10;
                                                }
                                                r2 += encodedSizeWithTag9;
                                            }
                                            r2 += encodedSizeWithTag8;
                                        }
                                        r2 += encodedSizeWithTag7;
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
            public Transaction redact(Transaction value) {
                Transaction copy;
                m.h(value, "value");
                Amount amount = value.getAmount();
                Amount redact = amount != null ? Amount.ADAPTER.redact(amount) : null;
                Amount crypto_currency_spent = value.getCrypto_currency_spent();
                Amount redact2 = crypto_currency_spent != null ? Amount.ADAPTER.redact(crypto_currency_spent) : null;
                Amount fee = value.getFee();
                Amount redact3 = fee != null ? Amount.ADAPTER.redact(fee) : null;
                u created_at = value.getCreated_at();
                u redact4 = created_at != null ? u.a.redact(created_at) : null;
                RewardProgram reward_program = value.getReward_program();
                RewardProgram redact5 = reward_program != null ? RewardProgram.ADAPTER.redact(reward_program) : null;
                Amount reward_earned = value.getReward_earned();
                Amount redact6 = reward_earned != null ? Amount.ADAPTER.redact(reward_earned) : null;
                Ref reward = value.getReward();
                copy = value.copy((r28 & 1) != 0 ? value.uuid : null, (r28 & 2) != 0 ? value.icon_url : null, (r28 & 4) != 0 ? value.statement_descriptor : null, (r28 & 8) != 0 ? value.amount : redact, (r28 & 16) != 0 ? value.crypto_currency_spent : redact2, (r28 & 32) != 0 ? value.fee : redact3, (r28 & 64) != 0 ? value.created_at : redact4, (r28 & 128) != 0 ? value.reward_program : redact5, (r28 & 256) != 0 ? value.reward_earned : redact6, (r28 & 512) != 0 ? value.reward : reward != null ? Ref.ADAPTER.redact(reward) : null, (r28 & 1024) != 0 ? value.status : null, (r28 & PKIFailureInfo.wrongIntegrity) != 0 ? value.type : null, (r28 & 4096) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Transaction() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ Transaction(String str, String str2, String str3, Amount amount, Amount amount2, Amount amount3, u uVar, RewardProgram rewardProgram, Amount amount4, Ref ref, TransactionStatus transactionStatus, TransactionType transactionType, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? null : amount, (i2 & 16) != 0 ? null : amount2, (i2 & 32) != 0 ? null : amount3, (i2 & 64) != 0 ? null : uVar, (i2 & 128) != 0 ? null : rewardProgram, (i2 & 256) != 0 ? null : amount4, (i2 & 512) == 0 ? ref : null, (i2 & 1024) != 0 ? TransactionStatus.TRANSACTION_STATUS_UNKNOWN : transactionStatus, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? TransactionType.TRANSACTION_TYPE_UNKNOWN : transactionType, (i2 & 4096) != 0 ? i.a : iVar);
    }

    public final Transaction copy(String uuid, String icon_url, String statement_descriptor, Amount amount, Amount amount2, Amount amount3, u uVar, RewardProgram rewardProgram, Amount amount4, Ref ref, TransactionStatus status, TransactionType type, i unknownFields) {
        m.h(uuid, "uuid");
        m.h(icon_url, "icon_url");
        m.h(statement_descriptor, "statement_descriptor");
        m.h(status, "status");
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new Transaction(uuid, icon_url, statement_descriptor, amount, amount2, amount3, uVar, rewardProgram, amount4, ref, status, type, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Transaction) {
            Transaction transaction = (Transaction) obj;
            return m.c(unknownFields(), transaction.unknownFields()) && m.c(this.uuid, transaction.uuid) && m.c(this.icon_url, transaction.icon_url) && m.c(this.statement_descriptor, transaction.statement_descriptor) && m.c(this.amount, transaction.amount) && m.c(this.crypto_currency_spent, transaction.crypto_currency_spent) && m.c(this.fee, transaction.fee) && m.c(this.created_at, transaction.created_at) && m.c(this.reward_program, transaction.reward_program) && m.c(this.reward_earned, transaction.reward_earned) && m.c(this.reward, transaction.reward) && this.status == transaction.status && this.type == transaction.type;
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final u getCreated_at() {
        return this.created_at;
    }

    public final Amount getCrypto_currency_spent() {
        return this.crypto_currency_spent;
    }

    public final Amount getFee() {
        return this.fee;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final Ref getReward() {
        return this.reward;
    }

    public final Amount getReward_earned() {
        return this.reward_earned;
    }

    public final RewardProgram getReward_program() {
        return this.reward_program;
    }

    public final String getStatement_descriptor() {
        return this.statement_descriptor;
    }

    public final TransactionStatus getStatus() {
        return this.status;
    }

    public final TransactionType getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.uuid.hashCode()) * 37) + this.icon_url.hashCode()) * 37) + this.statement_descriptor.hashCode()) * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.crypto_currency_spent;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.fee;
            int hashCode4 = (hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            u uVar = this.created_at;
            int hashCode5 = (hashCode4 + (uVar != null ? uVar.hashCode() : 0)) * 37;
            RewardProgram rewardProgram = this.reward_program;
            int hashCode6 = (hashCode5 + (rewardProgram != null ? rewardProgram.hashCode() : 0)) * 37;
            Amount amount4 = this.reward_earned;
            int hashCode7 = (hashCode6 + (amount4 != null ? amount4.hashCode() : 0)) * 37;
            Ref ref = this.reward;
            int hashCode8 = ((((hashCode7 + (ref != null ? ref.hashCode() : 0)) * 37) + this.status.hashCode()) * 37) + this.type.hashCode();
            this.hashCode = hashCode8;
            return hashCode8;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m330newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("uuid=" + b.c(this.uuid));
        arrayList.add("icon_url=" + b.c(this.icon_url));
        arrayList.add("statement_descriptor=" + b.c(this.statement_descriptor));
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.crypto_currency_spent != null) {
            arrayList.add("crypto_currency_spent=" + this.crypto_currency_spent);
        }
        if (this.fee != null) {
            arrayList.add("fee=" + this.fee);
        }
        if (this.created_at != null) {
            arrayList.add("created_at=" + this.created_at);
        }
        if (this.reward_program != null) {
            arrayList.add("reward_program=" + this.reward_program);
        }
        if (this.reward_earned != null) {
            arrayList.add("reward_earned=" + this.reward_earned);
        }
        if (this.reward != null) {
            arrayList.add("reward=" + this.reward);
        }
        arrayList.add("status=" + this.status);
        arrayList.add("type=" + this.type);
        h0 = z.h0(arrayList, ", ", "Transaction{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m330newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transaction(String uuid, String icon_url, String statement_descriptor, Amount amount, Amount amount2, Amount amount3, u uVar, RewardProgram rewardProgram, Amount amount4, Ref ref, TransactionStatus status, TransactionType type, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(uuid, "uuid");
        m.h(icon_url, "icon_url");
        m.h(statement_descriptor, "statement_descriptor");
        m.h(status, "status");
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.uuid = uuid;
        this.icon_url = icon_url;
        this.statement_descriptor = statement_descriptor;
        this.amount = amount;
        this.crypto_currency_spent = amount2;
        this.fee = amount3;
        this.created_at = uVar;
        this.reward_program = rewardProgram;
        this.reward_earned = amount4;
        this.reward = ref;
        this.status = status;
        this.type = type;
    }
}