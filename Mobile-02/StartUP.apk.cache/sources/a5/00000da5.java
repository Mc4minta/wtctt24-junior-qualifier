package com.coinbase.android.apiv3.generated.authed.new_user_experience;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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

/* compiled from: UpdateStepRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B1\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/UpdateStepRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "attempted_step", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/State;", ApiConstants.STATE, "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;", "simplified_buy_metadata", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/State;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/UpdateStepRequest;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;", "getSimplified_buy_metadata", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "getAttempted_step", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/State;", "getState", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/State;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Step;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/State;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyMetadata;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UpdateStepRequest extends a {
    public static final ProtoAdapter<UpdateStepRequest> ADAPTER;
    public static final Parcelable.Creator<UpdateStepRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.Step#ADAPTER", jsonName = "attemptedStep", tag = 1)
    private final Step attempted_step;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.SimplifiedBuyMetadata#ADAPTER", jsonName = "simplifiedBuyMetadata", tag = 3)
    private final SimplifiedBuyMetadata simplified_buy_metadata;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.State#ADAPTER", tag = 2)
    private final State state;

    /* compiled from: UpdateStepRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/UpdateStepRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/UpdateStepRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UpdateStepRequest> protoAdapter = new ProtoAdapter<UpdateStepRequest>(c.LENGTH_DELIMITED, e0.b(UpdateStepRequest.class), "type.googleapis.com/coinbase.public_api.authed.new_user_experience.UpdateStepRequest") { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.UpdateStepRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdateStepRequest decode(k reader) {
                m.h(reader, "reader");
                Step step = Step.NONE;
                State state = State.SKIPPED;
                long d2 = reader.d();
                SimplifiedBuyMetadata simplifiedBuyMetadata = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UpdateStepRequest(step, state, simplifiedBuyMetadata, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            step = Step.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        try {
                            state = State.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                            reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                        }
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        simplifiedBuyMetadata = SimplifiedBuyMetadata.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UpdateStepRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAttempted_step() != Step.NONE) {
                    Step.ADAPTER.encodeWithTag(writer, 1, value.getAttempted_step());
                }
                if (value.getState() != State.SKIPPED) {
                    State.ADAPTER.encodeWithTag(writer, 2, value.getState());
                }
                if (value.getSimplified_buy_metadata() != null) {
                    SimplifiedBuyMetadata.ADAPTER.encodeWithTag(writer, 3, value.getSimplified_buy_metadata());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UpdateStepRequest value) {
                m.h(value, "value");
                if (value.getAttempted_step() == Step.NONE) {
                    return 0;
                }
                int encodedSizeWithTag = Step.ADAPTER.encodedSizeWithTag(1, value.getAttempted_step());
                if (value.getState() != State.SKIPPED) {
                    r2 = (value.getSimplified_buy_metadata() != null ? SimplifiedBuyMetadata.ADAPTER.encodedSizeWithTag(3, value.getSimplified_buy_metadata()) + value.unknownFields().Q() : 0) + State.ADAPTER.encodedSizeWithTag(2, value.getState());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public UpdateStepRequest redact(UpdateStepRequest value) {
                m.h(value, "value");
                SimplifiedBuyMetadata simplified_buy_metadata = value.getSimplified_buy_metadata();
                return UpdateStepRequest.copy$default(value, null, null, simplified_buy_metadata != null ? SimplifiedBuyMetadata.ADAPTER.redact(simplified_buy_metadata) : null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public UpdateStepRequest() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ UpdateStepRequest(Step step, State state, SimplifiedBuyMetadata simplifiedBuyMetadata, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Step.NONE : step, (i2 & 2) != 0 ? State.SKIPPED : state, (i2 & 4) != 0 ? null : simplifiedBuyMetadata, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ UpdateStepRequest copy$default(UpdateStepRequest updateStepRequest, Step step, State state, SimplifiedBuyMetadata simplifiedBuyMetadata, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            step = updateStepRequest.attempted_step;
        }
        if ((i2 & 2) != 0) {
            state = updateStepRequest.state;
        }
        if ((i2 & 4) != 0) {
            simplifiedBuyMetadata = updateStepRequest.simplified_buy_metadata;
        }
        if ((i2 & 8) != 0) {
            iVar = updateStepRequest.unknownFields();
        }
        return updateStepRequest.copy(step, state, simplifiedBuyMetadata, iVar);
    }

    public final UpdateStepRequest copy(Step attempted_step, State state, SimplifiedBuyMetadata simplifiedBuyMetadata, i unknownFields) {
        m.h(attempted_step, "attempted_step");
        m.h(state, "state");
        m.h(unknownFields, "unknownFields");
        return new UpdateStepRequest(attempted_step, state, simplifiedBuyMetadata, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdateStepRequest) {
            UpdateStepRequest updateStepRequest = (UpdateStepRequest) obj;
            return m.c(unknownFields(), updateStepRequest.unknownFields()) && this.attempted_step == updateStepRequest.attempted_step && this.state == updateStepRequest.state && m.c(this.simplified_buy_metadata, updateStepRequest.simplified_buy_metadata);
        }
        return false;
    }

    public final Step getAttempted_step() {
        return this.attempted_step;
    }

    public final SimplifiedBuyMetadata getSimplified_buy_metadata() {
        return this.simplified_buy_metadata;
    }

    public final State getState() {
        return this.state;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.attempted_step.hashCode()) * 37) + this.state.hashCode()) * 37;
            SimplifiedBuyMetadata simplifiedBuyMetadata = this.simplified_buy_metadata;
            int hashCode2 = hashCode + (simplifiedBuyMetadata != null ? simplifiedBuyMetadata.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m435newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("attempted_step=" + this.attempted_step);
        arrayList.add("state=" + this.state);
        if (this.simplified_buy_metadata != null) {
            arrayList.add("simplified_buy_metadata=" + this.simplified_buy_metadata);
        }
        h0 = z.h0(arrayList, ", ", "UpdateStepRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m435newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateStepRequest(Step attempted_step, State state, SimplifiedBuyMetadata simplifiedBuyMetadata, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(attempted_step, "attempted_step");
        m.h(state, "state");
        m.h(unknownFields, "unknownFields");
        this.attempted_step = attempted_step;
        this.state = state;
        this.simplified_buy_metadata = simplifiedBuyMetadata;
    }
}