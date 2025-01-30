package com.coinbase.android.apiv3.generated.authed.new_user_experience;

import android.os.Parcelable;
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

/* compiled from: GetNextStepsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,BI\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0012\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b&\u0010\"R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/GetNextStepsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "next_pre_proofing_step", "next_post_proofing_step", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;", "simplified_buy_metadata", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;", "incentives_metadata", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;", "simplified_buy_referral_metadata", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/GetNextStepsResponse;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;", "getIncentives_metadata", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "getNext_pre_proofing_step", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;", "getSimplified_buy_metadata", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;", "getNext_post_proofing_step", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;", "getSimplified_buy_referral_metadata", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/IncentivesMetadata;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetNextStepsResponse extends a {
    public static final ProtoAdapter<GetNextStepsResponse> ADAPTER;
    public static final Parcelable.Creator<GetNextStepsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.IncentivesMetadata#ADAPTER", jsonName = "incentivesMetadata", tag = 4)
    private final IncentivesMetadata incentives_metadata;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.Step#ADAPTER", jsonName = "nextPostProofingStep", tag = 2)
    private final Step next_post_proofing_step;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.Step#ADAPTER", jsonName = "nextPreProofingStep", tag = 1)
    private final Step next_pre_proofing_step;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.SimplifiedBuyMetadata#ADAPTER", jsonName = "simplifiedBuyMetadata", tag = 3)
    private final SimplifiedBuyMetadata simplified_buy_metadata;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.SimplifiedBuyReferralMetadata#ADAPTER", jsonName = "simplifiedBuyReferralMetadata", tag = 5)
    private final SimplifiedBuyReferralMetadata simplified_buy_referral_metadata;

    /* compiled from: GetNextStepsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/GetNextStepsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/GetNextStepsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetNextStepsResponse> protoAdapter = new ProtoAdapter<GetNextStepsResponse>(c.LENGTH_DELIMITED, e0.b(GetNextStepsResponse.class), "type.googleapis.com/coinbase.public_api.authed.new_user_experience.GetNextStepsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.GetNextStepsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetNextStepsResponse decode(k reader) {
                m.h(reader, "reader");
                Step step = Step.NONE;
                long d2 = reader.d();
                Step step2 = step;
                Step step3 = step2;
                SimplifiedBuyMetadata simplifiedBuyMetadata = null;
                IncentivesMetadata incentivesMetadata = null;
                SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetNextStepsResponse(step2, step3, simplifiedBuyMetadata, incentivesMetadata, simplifiedBuyReferralMetadata, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            step2 = Step.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        try {
                            step3 = Step.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                            reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                        }
                    } else if (g2 == 3) {
                        simplifiedBuyMetadata = SimplifiedBuyMetadata.ADAPTER.decode(reader);
                    } else if (g2 == 4) {
                        incentivesMetadata = IncentivesMetadata.ADAPTER.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        simplifiedBuyReferralMetadata = SimplifiedBuyReferralMetadata.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetNextStepsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                Step next_pre_proofing_step = value.getNext_pre_proofing_step();
                Step step = Step.NONE;
                if (next_pre_proofing_step != step) {
                    Step.ADAPTER.encodeWithTag(writer, 1, value.getNext_pre_proofing_step());
                }
                if (value.getNext_post_proofing_step() != step) {
                    Step.ADAPTER.encodeWithTag(writer, 2, value.getNext_post_proofing_step());
                }
                if (value.getSimplified_buy_metadata() != null) {
                    SimplifiedBuyMetadata.ADAPTER.encodeWithTag(writer, 3, value.getSimplified_buy_metadata());
                }
                if (value.getIncentives_metadata() != null) {
                    IncentivesMetadata.ADAPTER.encodeWithTag(writer, 4, value.getIncentives_metadata());
                }
                if (value.getSimplified_buy_referral_metadata() != null) {
                    SimplifiedBuyReferralMetadata.ADAPTER.encodeWithTag(writer, 5, value.getSimplified_buy_referral_metadata());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetNextStepsResponse value) {
                m.h(value, "value");
                Step next_pre_proofing_step = value.getNext_pre_proofing_step();
                Step step = Step.NONE;
                if (next_pre_proofing_step == step) {
                    return 0;
                }
                ProtoAdapter<Step> protoAdapter2 = Step.ADAPTER;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getNext_pre_proofing_step());
                if (value.getNext_post_proofing_step() != step) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getNext_post_proofing_step());
                    if (value.getSimplified_buy_metadata() != null) {
                        int encodedSizeWithTag3 = SimplifiedBuyMetadata.ADAPTER.encodedSizeWithTag(3, value.getSimplified_buy_metadata());
                        if (value.getIncentives_metadata() != null) {
                            r2 = (value.getSimplified_buy_referral_metadata() != null ? SimplifiedBuyReferralMetadata.ADAPTER.encodedSizeWithTag(5, value.getSimplified_buy_referral_metadata()) + value.unknownFields().Q() : 0) + IncentivesMetadata.ADAPTER.encodedSizeWithTag(4, value.getIncentives_metadata());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetNextStepsResponse redact(GetNextStepsResponse value) {
                m.h(value, "value");
                SimplifiedBuyMetadata simplified_buy_metadata = value.getSimplified_buy_metadata();
                SimplifiedBuyMetadata redact = simplified_buy_metadata != null ? SimplifiedBuyMetadata.ADAPTER.redact(simplified_buy_metadata) : null;
                IncentivesMetadata incentives_metadata = value.getIncentives_metadata();
                IncentivesMetadata redact2 = incentives_metadata != null ? IncentivesMetadata.ADAPTER.redact(incentives_metadata) : null;
                SimplifiedBuyReferralMetadata simplified_buy_referral_metadata = value.getSimplified_buy_referral_metadata();
                return GetNextStepsResponse.copy$default(value, null, null, redact, redact2, simplified_buy_referral_metadata != null ? SimplifiedBuyReferralMetadata.ADAPTER.redact(simplified_buy_referral_metadata) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetNextStepsResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ GetNextStepsResponse(Step step, Step step2, SimplifiedBuyMetadata simplifiedBuyMetadata, IncentivesMetadata incentivesMetadata, SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Step.NONE : step, (i2 & 2) != 0 ? Step.NONE : step2, (i2 & 4) != 0 ? null : simplifiedBuyMetadata, (i2 & 8) != 0 ? null : incentivesMetadata, (i2 & 16) == 0 ? simplifiedBuyReferralMetadata : null, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetNextStepsResponse copy$default(GetNextStepsResponse getNextStepsResponse, Step step, Step step2, SimplifiedBuyMetadata simplifiedBuyMetadata, IncentivesMetadata incentivesMetadata, SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            step = getNextStepsResponse.next_pre_proofing_step;
        }
        if ((i2 & 2) != 0) {
            step2 = getNextStepsResponse.next_post_proofing_step;
        }
        Step step3 = step2;
        if ((i2 & 4) != 0) {
            simplifiedBuyMetadata = getNextStepsResponse.simplified_buy_metadata;
        }
        SimplifiedBuyMetadata simplifiedBuyMetadata2 = simplifiedBuyMetadata;
        if ((i2 & 8) != 0) {
            incentivesMetadata = getNextStepsResponse.incentives_metadata;
        }
        IncentivesMetadata incentivesMetadata2 = incentivesMetadata;
        if ((i2 & 16) != 0) {
            simplifiedBuyReferralMetadata = getNextStepsResponse.simplified_buy_referral_metadata;
        }
        SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata2 = simplifiedBuyReferralMetadata;
        if ((i2 & 32) != 0) {
            iVar = getNextStepsResponse.unknownFields();
        }
        return getNextStepsResponse.copy(step, step3, simplifiedBuyMetadata2, incentivesMetadata2, simplifiedBuyReferralMetadata2, iVar);
    }

    public final GetNextStepsResponse copy(Step next_pre_proofing_step, Step next_post_proofing_step, SimplifiedBuyMetadata simplifiedBuyMetadata, IncentivesMetadata incentivesMetadata, SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata, i unknownFields) {
        m.h(next_pre_proofing_step, "next_pre_proofing_step");
        m.h(next_post_proofing_step, "next_post_proofing_step");
        m.h(unknownFields, "unknownFields");
        return new GetNextStepsResponse(next_pre_proofing_step, next_post_proofing_step, simplifiedBuyMetadata, incentivesMetadata, simplifiedBuyReferralMetadata, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetNextStepsResponse) {
            GetNextStepsResponse getNextStepsResponse = (GetNextStepsResponse) obj;
            return m.c(unknownFields(), getNextStepsResponse.unknownFields()) && this.next_pre_proofing_step == getNextStepsResponse.next_pre_proofing_step && this.next_post_proofing_step == getNextStepsResponse.next_post_proofing_step && m.c(this.simplified_buy_metadata, getNextStepsResponse.simplified_buy_metadata) && m.c(this.incentives_metadata, getNextStepsResponse.incentives_metadata) && m.c(this.simplified_buy_referral_metadata, getNextStepsResponse.simplified_buy_referral_metadata);
        }
        return false;
    }

    public final IncentivesMetadata getIncentives_metadata() {
        return this.incentives_metadata;
    }

    public final Step getNext_post_proofing_step() {
        return this.next_post_proofing_step;
    }

    public final Step getNext_pre_proofing_step() {
        return this.next_pre_proofing_step;
    }

    public final SimplifiedBuyMetadata getSimplified_buy_metadata() {
        return this.simplified_buy_metadata;
    }

    public final SimplifiedBuyReferralMetadata getSimplified_buy_referral_metadata() {
        return this.simplified_buy_referral_metadata;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.next_pre_proofing_step.hashCode()) * 37) + this.next_post_proofing_step.hashCode()) * 37;
            SimplifiedBuyMetadata simplifiedBuyMetadata = this.simplified_buy_metadata;
            int hashCode2 = (hashCode + (simplifiedBuyMetadata != null ? simplifiedBuyMetadata.hashCode() : 0)) * 37;
            IncentivesMetadata incentivesMetadata = this.incentives_metadata;
            int hashCode3 = (hashCode2 + (incentivesMetadata != null ? incentivesMetadata.hashCode() : 0)) * 37;
            SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata = this.simplified_buy_referral_metadata;
            int hashCode4 = hashCode3 + (simplifiedBuyReferralMetadata != null ? simplifiedBuyReferralMetadata.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m430newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("next_pre_proofing_step=" + this.next_pre_proofing_step);
        arrayList.add("next_post_proofing_step=" + this.next_post_proofing_step);
        if (this.simplified_buy_metadata != null) {
            arrayList.add("simplified_buy_metadata=" + this.simplified_buy_metadata);
        }
        if (this.incentives_metadata != null) {
            arrayList.add("incentives_metadata=" + this.incentives_metadata);
        }
        if (this.simplified_buy_referral_metadata != null) {
            arrayList.add("simplified_buy_referral_metadata=" + this.simplified_buy_referral_metadata);
        }
        h0 = z.h0(arrayList, ", ", "GetNextStepsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m430newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetNextStepsResponse(Step next_pre_proofing_step, Step next_post_proofing_step, SimplifiedBuyMetadata simplifiedBuyMetadata, IncentivesMetadata incentivesMetadata, SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(next_pre_proofing_step, "next_pre_proofing_step");
        m.h(next_post_proofing_step, "next_post_proofing_step");
        m.h(unknownFields, "unknownFields");
        this.next_pre_proofing_step = next_pre_proofing_step;
        this.next_post_proofing_step = next_post_proofing_step;
        this.simplified_buy_metadata = simplifiedBuyMetadata;
        this.incentives_metadata = incentivesMetadata;
        this.simplified_buy_referral_metadata = simplifiedBuyReferralMetadata;
    }
}