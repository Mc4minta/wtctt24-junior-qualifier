package com.coinbase.android.apiv3.generated.authed.loyalty;

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

/* compiled from: PostEarnQuizAnswerResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB'\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "answer_correct", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;", "modal", "Lj/i;", "unknownFields", "copy", "(ZLcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;", "getModal", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;", "Z", "getAnswer_correct", "()Z", "<init>", "(ZLcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PostEarnQuizAnswerResponse extends a {
    public static final ProtoAdapter<PostEarnQuizAnswerResponse> ADAPTER;
    public static final Parcelable.Creator<PostEarnQuizAnswerResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "answerCorrect", tag = 1)
    private final boolean answer_correct;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizSuccessModal#ADAPTER", tag = 2)
    private final EarnQuizSuccessModal modal;

    /* compiled from: PostEarnQuizAnswerResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PostEarnQuizAnswerResponse> protoAdapter = new ProtoAdapter<PostEarnQuizAnswerResponse>(c.LENGTH_DELIMITED, e0.b(PostEarnQuizAnswerResponse.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.PostEarnQuizAnswerResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.PostEarnQuizAnswerResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PostEarnQuizAnswerResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                boolean z = false;
                EarnQuizSuccessModal earnQuizSuccessModal = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PostEarnQuizAnswerResponse(z, earnQuizSuccessModal, reader.e(d2));
                    }
                    if (g2 == 1) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        earnQuizSuccessModal = EarnQuizSuccessModal.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PostEarnQuizAnswerResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAnswer_correct()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 1, Boolean.valueOf(value.getAnswer_correct()));
                }
                if (value.getModal() != null) {
                    EarnQuizSuccessModal.ADAPTER.encodeWithTag(writer, 2, value.getModal());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PostEarnQuizAnswerResponse value) {
                m.h(value, "value");
                if (value.getAnswer_correct()) {
                    return (value.getModal() != null ? EarnQuizSuccessModal.ADAPTER.encodedSizeWithTag(2, value.getModal()) + value.unknownFields().Q() : 0) + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(value.getAnswer_correct()));
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PostEarnQuizAnswerResponse redact(PostEarnQuizAnswerResponse value) {
                m.h(value, "value");
                EarnQuizSuccessModal modal = value.getModal();
                return PostEarnQuizAnswerResponse.copy$default(value, false, modal != null ? EarnQuizSuccessModal.ADAPTER.redact(modal) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PostEarnQuizAnswerResponse() {
        this(false, null, null, 7, null);
    }

    public /* synthetic */ PostEarnQuizAnswerResponse(boolean z, EarnQuizSuccessModal earnQuizSuccessModal, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? null : earnQuizSuccessModal, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PostEarnQuizAnswerResponse copy$default(PostEarnQuizAnswerResponse postEarnQuizAnswerResponse, boolean z, EarnQuizSuccessModal earnQuizSuccessModal, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = postEarnQuizAnswerResponse.answer_correct;
        }
        if ((i2 & 2) != 0) {
            earnQuizSuccessModal = postEarnQuizAnswerResponse.modal;
        }
        if ((i2 & 4) != 0) {
            iVar = postEarnQuizAnswerResponse.unknownFields();
        }
        return postEarnQuizAnswerResponse.copy(z, earnQuizSuccessModal, iVar);
    }

    public final PostEarnQuizAnswerResponse copy(boolean z, EarnQuizSuccessModal earnQuizSuccessModal, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new PostEarnQuizAnswerResponse(z, earnQuizSuccessModal, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PostEarnQuizAnswerResponse) {
            PostEarnQuizAnswerResponse postEarnQuizAnswerResponse = (PostEarnQuizAnswerResponse) obj;
            return m.c(unknownFields(), postEarnQuizAnswerResponse.unknownFields()) && this.answer_correct == postEarnQuizAnswerResponse.answer_correct && m.c(this.modal, postEarnQuizAnswerResponse.modal);
        }
        return false;
    }

    public final boolean getAnswer_correct() {
        return this.answer_correct;
    }

    public final EarnQuizSuccessModal getModal() {
        return this.modal;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.answer_correct)) * 37;
            EarnQuizSuccessModal earnQuizSuccessModal = this.modal;
            int hashCode2 = hashCode + (earnQuizSuccessModal != null ? earnQuizSuccessModal.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m422newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("answer_correct=" + this.answer_correct);
        if (this.modal != null) {
            arrayList.add("modal=" + this.modal);
        }
        h0 = z.h0(arrayList, ", ", "PostEarnQuizAnswerResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostEarnQuizAnswerResponse(boolean z, EarnQuizSuccessModal earnQuizSuccessModal, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.answer_correct = z;
        this.modal = earnQuizSuccessModal;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m422newBuilder() {
        throw new AssertionError();
    }
}