package com.coinbase.android.apiv3.generated.authed.card;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetRewardsSummaryResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00011Bg\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJm\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b(\u0010!R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010+R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b,\u0010!R\u001c\u0010\u001a\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\f¨\u00062"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "current_reward_program", "Lcom/google/protobuf/u;", "current_reward_program_expires_at", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "earned_fiat_amount", "", "earned_crypto_amount", "current_reward_program_earned_amount", "current_reward_program_earned_fiat_amount", "total_number_of_rewards_earned", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;ILj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getCurrent_reward_program_earned_fiat_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/util/List;", "getEarned_crypto_amount", "()Ljava/util/List;", "Lcom/google/protobuf/u;", "getCurrent_reward_program_expires_at", "()Lcom/google/protobuf/u;", "getCurrent_reward_program_earned_amount", "Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "getCurrent_reward_program", "()Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "getEarned_fiat_amount", "I", "getTotal_number_of_rewards_earned", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;ILj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetRewardsSummaryResponse extends a {
    public static final ProtoAdapter<GetRewardsSummaryResponse> ADAPTER;
    public static final Parcelable.Creator<GetRewardsSummaryResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.RewardProgram#ADAPTER", jsonName = "currentRewardProgram", tag = 1)
    private final RewardProgram current_reward_program;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "currentRewardProgramEarnedAmount", tag = 5)
    private final Amount current_reward_program_earned_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "currentRewardProgramEarnedFiatAmount", tag = 6)
    private final Amount current_reward_program_earned_fiat_amount;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "currentRewardProgramExpiresAt", tag = 2)
    private final u current_reward_program_expires_at;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "earnedCryptoAmount", label = p.a.REPEATED, tag = 4)
    private final List<Amount> earned_crypto_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "earnedFiatAmount", tag = 3)
    private final Amount earned_fiat_amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "totalNumberOfRewardsEarned", tag = 7)
    private final int total_number_of_rewards_earned;

    /* compiled from: GetRewardsSummaryResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetRewardsSummaryResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetRewardsSummaryResponse> protoAdapter = new ProtoAdapter<GetRewardsSummaryResponse>(c.LENGTH_DELIMITED, e0.b(GetRewardsSummaryResponse.class), "type.googleapis.com/coinbase.public_api.authed.card.GetRewardsSummaryResponse") { // from class: com.coinbase.android.apiv3.generated.authed.card.GetRewardsSummaryResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetRewardsSummaryResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                RewardProgram rewardProgram = null;
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                int i2 = 0;
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetRewardsSummaryResponse(rewardProgram, uVar, amount, arrayList, amount2, amount3, i2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            rewardProgram = RewardProgram.ADAPTER.decode(reader);
                            break;
                        case 2:
                            uVar = u.a.decode(reader);
                            break;
                        case 3:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            arrayList.add(Amount.ADAPTER.decode(reader));
                            break;
                        case 5:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            i2 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetRewardsSummaryResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCurrent_reward_program() != null) {
                    RewardProgram.ADAPTER.encodeWithTag(writer, 1, value.getCurrent_reward_program());
                }
                if (value.getCurrent_reward_program_expires_at() != null) {
                    u.a.encodeWithTag(writer, 2, value.getCurrent_reward_program_expires_at());
                }
                if (value.getEarned_fiat_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getEarned_fiat_amount());
                }
                ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.getEarned_crypto_amount());
                if (value.getCurrent_reward_program_earned_amount() != null) {
                    protoAdapter2.encodeWithTag(writer, 5, value.getCurrent_reward_program_earned_amount());
                }
                if (value.getCurrent_reward_program_earned_fiat_amount() != null) {
                    protoAdapter2.encodeWithTag(writer, 6, value.getCurrent_reward_program_earned_fiat_amount());
                }
                if (value.getTotal_number_of_rewards_earned() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 7, Integer.valueOf(value.getTotal_number_of_rewards_earned()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetRewardsSummaryResponse value) {
                m.h(value, "value");
                if (value.getCurrent_reward_program() == null) {
                    return 0;
                }
                int encodedSizeWithTag = RewardProgram.ADAPTER.encodedSizeWithTag(1, value.getCurrent_reward_program());
                if (value.getCurrent_reward_program_expires_at() != null) {
                    int encodedSizeWithTag2 = u.a.encodedSizeWithTag(2, value.getCurrent_reward_program_expires_at());
                    if (value.getEarned_fiat_amount() != null) {
                        ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getEarned_fiat_amount()) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.getEarned_crypto_amount());
                        if (value.getCurrent_reward_program_earned_amount() != null) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(5, value.getCurrent_reward_program_earned_amount());
                            if (value.getCurrent_reward_program_earned_fiat_amount() != null) {
                                r1 = (value.getTotal_number_of_rewards_earned() != 0 ? ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(value.getTotal_number_of_rewards_earned())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(6, value.getCurrent_reward_program_earned_fiat_amount());
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
            public GetRewardsSummaryResponse redact(GetRewardsSummaryResponse value) {
                m.h(value, "value");
                RewardProgram current_reward_program = value.getCurrent_reward_program();
                RewardProgram redact = current_reward_program != null ? RewardProgram.ADAPTER.redact(current_reward_program) : null;
                u current_reward_program_expires_at = value.getCurrent_reward_program_expires_at();
                u redact2 = current_reward_program_expires_at != null ? u.a.redact(current_reward_program_expires_at) : null;
                Amount earned_fiat_amount = value.getEarned_fiat_amount();
                Amount redact3 = earned_fiat_amount != null ? Amount.ADAPTER.redact(earned_fiat_amount) : null;
                List<Amount> earned_crypto_amount = value.getEarned_crypto_amount();
                ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                List a = b.a(earned_crypto_amount, protoAdapter2);
                Amount current_reward_program_earned_amount = value.getCurrent_reward_program_earned_amount();
                Amount redact4 = current_reward_program_earned_amount != null ? protoAdapter2.redact(current_reward_program_earned_amount) : null;
                Amount current_reward_program_earned_fiat_amount = value.getCurrent_reward_program_earned_fiat_amount();
                return GetRewardsSummaryResponse.copy$default(value, redact, redact2, redact3, a, redact4, current_reward_program_earned_fiat_amount != null ? protoAdapter2.redact(current_reward_program_earned_fiat_amount) : null, 0, i.a, 64, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetRewardsSummaryResponse() {
        this(null, null, null, null, null, null, 0, null, 255, null);
    }

    public /* synthetic */ GetRewardsSummaryResponse(RewardProgram rewardProgram, u uVar, Amount amount, List list, Amount amount2, Amount amount3, int i2, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : rewardProgram, (i3 & 2) != 0 ? null : uVar, (i3 & 4) != 0 ? null : amount, (i3 & 8) != 0 ? r.g() : list, (i3 & 16) != 0 ? null : amount2, (i3 & 32) == 0 ? amount3 : null, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetRewardsSummaryResponse copy$default(GetRewardsSummaryResponse getRewardsSummaryResponse, RewardProgram rewardProgram, u uVar, Amount amount, List list, Amount amount2, Amount amount3, int i2, i iVar, int i3, Object obj) {
        return getRewardsSummaryResponse.copy((i3 & 1) != 0 ? getRewardsSummaryResponse.current_reward_program : rewardProgram, (i3 & 2) != 0 ? getRewardsSummaryResponse.current_reward_program_expires_at : uVar, (i3 & 4) != 0 ? getRewardsSummaryResponse.earned_fiat_amount : amount, (i3 & 8) != 0 ? getRewardsSummaryResponse.earned_crypto_amount : list, (i3 & 16) != 0 ? getRewardsSummaryResponse.current_reward_program_earned_amount : amount2, (i3 & 32) != 0 ? getRewardsSummaryResponse.current_reward_program_earned_fiat_amount : amount3, (i3 & 64) != 0 ? getRewardsSummaryResponse.total_number_of_rewards_earned : i2, (i3 & 128) != 0 ? getRewardsSummaryResponse.unknownFields() : iVar);
    }

    public final GetRewardsSummaryResponse copy(RewardProgram rewardProgram, u uVar, Amount amount, List<Amount> earned_crypto_amount, Amount amount2, Amount amount3, int i2, i unknownFields) {
        m.h(earned_crypto_amount, "earned_crypto_amount");
        m.h(unknownFields, "unknownFields");
        return new GetRewardsSummaryResponse(rewardProgram, uVar, amount, earned_crypto_amount, amount2, amount3, i2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetRewardsSummaryResponse) {
            GetRewardsSummaryResponse getRewardsSummaryResponse = (GetRewardsSummaryResponse) obj;
            return m.c(unknownFields(), getRewardsSummaryResponse.unknownFields()) && m.c(this.current_reward_program, getRewardsSummaryResponse.current_reward_program) && m.c(this.current_reward_program_expires_at, getRewardsSummaryResponse.current_reward_program_expires_at) && m.c(this.earned_fiat_amount, getRewardsSummaryResponse.earned_fiat_amount) && m.c(this.earned_crypto_amount, getRewardsSummaryResponse.earned_crypto_amount) && m.c(this.current_reward_program_earned_amount, getRewardsSummaryResponse.current_reward_program_earned_amount) && m.c(this.current_reward_program_earned_fiat_amount, getRewardsSummaryResponse.current_reward_program_earned_fiat_amount) && this.total_number_of_rewards_earned == getRewardsSummaryResponse.total_number_of_rewards_earned;
        }
        return false;
    }

    public final RewardProgram getCurrent_reward_program() {
        return this.current_reward_program;
    }

    public final Amount getCurrent_reward_program_earned_amount() {
        return this.current_reward_program_earned_amount;
    }

    public final Amount getCurrent_reward_program_earned_fiat_amount() {
        return this.current_reward_program_earned_fiat_amount;
    }

    public final u getCurrent_reward_program_expires_at() {
        return this.current_reward_program_expires_at;
    }

    public final List<Amount> getEarned_crypto_amount() {
        return this.earned_crypto_amount;
    }

    public final Amount getEarned_fiat_amount() {
        return this.earned_fiat_amount;
    }

    public final int getTotal_number_of_rewards_earned() {
        return this.total_number_of_rewards_earned;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RewardProgram rewardProgram = this.current_reward_program;
            int hashCode2 = (hashCode + (rewardProgram != null ? rewardProgram.hashCode() : 0)) * 37;
            u uVar = this.current_reward_program_expires_at;
            int hashCode3 = (hashCode2 + (uVar != null ? uVar.hashCode() : 0)) * 37;
            Amount amount = this.earned_fiat_amount;
            int hashCode4 = (((hashCode3 + (amount != null ? amount.hashCode() : 0)) * 37) + this.earned_crypto_amount.hashCode()) * 37;
            Amount amount2 = this.current_reward_program_earned_amount;
            int hashCode5 = (hashCode4 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.current_reward_program_earned_fiat_amount;
            int hashCode6 = ((hashCode5 + (amount3 != null ? amount3.hashCode() : 0)) * 37) + this.total_number_of_rewards_earned;
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m311newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.current_reward_program != null) {
            arrayList.add("current_reward_program=" + this.current_reward_program);
        }
        if (this.current_reward_program_expires_at != null) {
            arrayList.add("current_reward_program_expires_at=" + this.current_reward_program_expires_at);
        }
        if (this.earned_fiat_amount != null) {
            arrayList.add("earned_fiat_amount=" + this.earned_fiat_amount);
        }
        if (!this.earned_crypto_amount.isEmpty()) {
            arrayList.add("earned_crypto_amount=" + this.earned_crypto_amount);
        }
        if (this.current_reward_program_earned_amount != null) {
            arrayList.add("current_reward_program_earned_amount=" + this.current_reward_program_earned_amount);
        }
        if (this.current_reward_program_earned_fiat_amount != null) {
            arrayList.add("current_reward_program_earned_fiat_amount=" + this.current_reward_program_earned_fiat_amount);
        }
        arrayList.add("total_number_of_rewards_earned=" + this.total_number_of_rewards_earned);
        h0 = z.h0(arrayList, ", ", "GetRewardsSummaryResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m311newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRewardsSummaryResponse(RewardProgram rewardProgram, u uVar, Amount amount, List<Amount> earned_crypto_amount, Amount amount2, Amount amount3, int i2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(earned_crypto_amount, "earned_crypto_amount");
        m.h(unknownFields, "unknownFields");
        this.current_reward_program = rewardProgram;
        this.current_reward_program_expires_at = uVar;
        this.earned_fiat_amount = amount;
        this.earned_crypto_amount = earned_crypto_amount;
        this.current_reward_program_earned_amount = amount2;
        this.current_reward_program_earned_fiat_amount = amount3;
        this.total_number_of_rewards_earned = i2;
    }
}