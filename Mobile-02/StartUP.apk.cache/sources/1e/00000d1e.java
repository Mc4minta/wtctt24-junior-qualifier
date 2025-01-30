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

/* compiled from: GetEarnQuizResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B'\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizType;", "type", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;", "quiz", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizType;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizType;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;", "getQuiz", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizType;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetEarnQuizResponse extends a {
    public static final ProtoAdapter<GetEarnQuizResponse> ADAPTER;
    public static final Parcelable.Creator<GetEarnQuizResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnSingleSelectQuiz#ADAPTER", tag = 2)
    private final EarnSingleSelectQuiz quiz;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizType#ADAPTER", tag = 1)
    private final EarnQuizType type;

    /* compiled from: GetEarnQuizResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnQuizResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetEarnQuizResponse> protoAdapter = new ProtoAdapter<GetEarnQuizResponse>(c.LENGTH_DELIMITED, e0.b(GetEarnQuizResponse.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.GetEarnQuizResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.GetEarnQuizResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetEarnQuizResponse decode(k reader) {
                m.h(reader, "reader");
                EarnQuizType earnQuizType = EarnQuizType.UNKNOWN_QUIZ_TYPE;
                long d2 = reader.d();
                EarnSingleSelectQuiz earnSingleSelectQuiz = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetEarnQuizResponse(earnQuizType, earnSingleSelectQuiz, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            earnQuizType = EarnQuizType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        earnSingleSelectQuiz = EarnSingleSelectQuiz.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetEarnQuizResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != EarnQuizType.UNKNOWN_QUIZ_TYPE) {
                    EarnQuizType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getQuiz() != null) {
                    EarnSingleSelectQuiz.ADAPTER.encodeWithTag(writer, 2, value.getQuiz());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetEarnQuizResponse value) {
                m.h(value, "value");
                if (value.getType() == EarnQuizType.UNKNOWN_QUIZ_TYPE) {
                    return 0;
                }
                return (value.getQuiz() != null ? EarnSingleSelectQuiz.ADAPTER.encodedSizeWithTag(2, value.getQuiz()) + value.unknownFields().Q() : 0) + EarnQuizType.ADAPTER.encodedSizeWithTag(1, value.getType());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetEarnQuizResponse redact(GetEarnQuizResponse value) {
                m.h(value, "value");
                EarnSingleSelectQuiz quiz = value.getQuiz();
                return GetEarnQuizResponse.copy$default(value, null, quiz != null ? EarnSingleSelectQuiz.ADAPTER.redact(quiz) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetEarnQuizResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetEarnQuizResponse(EarnQuizType earnQuizType, EarnSingleSelectQuiz earnSingleSelectQuiz, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? EarnQuizType.UNKNOWN_QUIZ_TYPE : earnQuizType, (i2 & 2) != 0 ? null : earnSingleSelectQuiz, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetEarnQuizResponse copy$default(GetEarnQuizResponse getEarnQuizResponse, EarnQuizType earnQuizType, EarnSingleSelectQuiz earnSingleSelectQuiz, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            earnQuizType = getEarnQuizResponse.type;
        }
        if ((i2 & 2) != 0) {
            earnSingleSelectQuiz = getEarnQuizResponse.quiz;
        }
        if ((i2 & 4) != 0) {
            iVar = getEarnQuizResponse.unknownFields();
        }
        return getEarnQuizResponse.copy(earnQuizType, earnSingleSelectQuiz, iVar);
    }

    public final GetEarnQuizResponse copy(EarnQuizType type, EarnSingleSelectQuiz earnSingleSelectQuiz, i unknownFields) {
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new GetEarnQuizResponse(type, earnSingleSelectQuiz, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetEarnQuizResponse) {
            GetEarnQuizResponse getEarnQuizResponse = (GetEarnQuizResponse) obj;
            return m.c(unknownFields(), getEarnQuizResponse.unknownFields()) && this.type == getEarnQuizResponse.type && m.c(this.quiz, getEarnQuizResponse.quiz);
        }
        return false;
    }

    public final EarnSingleSelectQuiz getQuiz() {
        return this.quiz;
    }

    public final EarnQuizType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37;
            EarnSingleSelectQuiz earnSingleSelectQuiz = this.quiz;
            int hashCode2 = hashCode + (earnSingleSelectQuiz != null ? earnSingleSelectQuiz.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m401newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        if (this.quiz != null) {
            arrayList.add("quiz=" + this.quiz);
        }
        h0 = z.h0(arrayList, ", ", "GetEarnQuizResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m401newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetEarnQuizResponse(EarnQuizType type, EarnSingleSelectQuiz earnSingleSelectQuiz, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.quiz = earnSingleSelectQuiz;
    }
}