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

/* compiled from: GetEarnLessonResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B3\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnLessonType;", "type", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;", "video_lesson", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;", "invite_lesson", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnLessonType;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonResponse;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnLessonType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnLessonType;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;", "getVideo_lesson", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;", "getInvite_lesson", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnLessonType;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetEarnLessonResponse extends a {
    public static final ProtoAdapter<GetEarnLessonResponse> ADAPTER;
    public static final Parcelable.Creator<GetEarnLessonResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnInviteLesson#ADAPTER", jsonName = "inviteLesson", tag = 3)
    private final EarnInviteLesson invite_lesson;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnLessonType#ADAPTER", tag = 1)
    private final EarnLessonType type;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnVideoLesson#ADAPTER", jsonName = "videoLesson", tag = 2)
    private final EarnVideoLesson video_lesson;

    /* compiled from: GetEarnLessonResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/GetEarnLessonResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetEarnLessonResponse> protoAdapter = new ProtoAdapter<GetEarnLessonResponse>(c.LENGTH_DELIMITED, e0.b(GetEarnLessonResponse.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.GetEarnLessonResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.GetEarnLessonResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetEarnLessonResponse decode(k reader) {
                m.h(reader, "reader");
                EarnLessonType earnLessonType = EarnLessonType.UNKNOWN_LESSON_TYPE;
                long d2 = reader.d();
                EarnVideoLesson earnVideoLesson = null;
                EarnInviteLesson earnInviteLesson = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetEarnLessonResponse(earnLessonType, earnVideoLesson, earnInviteLesson, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            earnLessonType = EarnLessonType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        earnVideoLesson = EarnVideoLesson.ADAPTER.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        earnInviteLesson = EarnInviteLesson.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetEarnLessonResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != EarnLessonType.UNKNOWN_LESSON_TYPE) {
                    EarnLessonType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getVideo_lesson() != null) {
                    EarnVideoLesson.ADAPTER.encodeWithTag(writer, 2, value.getVideo_lesson());
                }
                if (value.getInvite_lesson() != null) {
                    EarnInviteLesson.ADAPTER.encodeWithTag(writer, 3, value.getInvite_lesson());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetEarnLessonResponse value) {
                m.h(value, "value");
                if (value.getType() == EarnLessonType.UNKNOWN_LESSON_TYPE) {
                    return 0;
                }
                int encodedSizeWithTag = EarnLessonType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (value.getVideo_lesson() != null) {
                    r2 = (value.getInvite_lesson() != null ? EarnInviteLesson.ADAPTER.encodedSizeWithTag(3, value.getInvite_lesson()) + value.unknownFields().Q() : 0) + EarnVideoLesson.ADAPTER.encodedSizeWithTag(2, value.getVideo_lesson());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetEarnLessonResponse redact(GetEarnLessonResponse value) {
                m.h(value, "value");
                EarnVideoLesson video_lesson = value.getVideo_lesson();
                EarnVideoLesson redact = video_lesson != null ? EarnVideoLesson.ADAPTER.redact(video_lesson) : null;
                EarnInviteLesson invite_lesson = value.getInvite_lesson();
                return GetEarnLessonResponse.copy$default(value, null, redact, invite_lesson != null ? EarnInviteLesson.ADAPTER.redact(invite_lesson) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetEarnLessonResponse() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ GetEarnLessonResponse(EarnLessonType earnLessonType, EarnVideoLesson earnVideoLesson, EarnInviteLesson earnInviteLesson, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? EarnLessonType.UNKNOWN_LESSON_TYPE : earnLessonType, (i2 & 2) != 0 ? null : earnVideoLesson, (i2 & 4) != 0 ? null : earnInviteLesson, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetEarnLessonResponse copy$default(GetEarnLessonResponse getEarnLessonResponse, EarnLessonType earnLessonType, EarnVideoLesson earnVideoLesson, EarnInviteLesson earnInviteLesson, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            earnLessonType = getEarnLessonResponse.type;
        }
        if ((i2 & 2) != 0) {
            earnVideoLesson = getEarnLessonResponse.video_lesson;
        }
        if ((i2 & 4) != 0) {
            earnInviteLesson = getEarnLessonResponse.invite_lesson;
        }
        if ((i2 & 8) != 0) {
            iVar = getEarnLessonResponse.unknownFields();
        }
        return getEarnLessonResponse.copy(earnLessonType, earnVideoLesson, earnInviteLesson, iVar);
    }

    public final GetEarnLessonResponse copy(EarnLessonType type, EarnVideoLesson earnVideoLesson, EarnInviteLesson earnInviteLesson, i unknownFields) {
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new GetEarnLessonResponse(type, earnVideoLesson, earnInviteLesson, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetEarnLessonResponse) {
            GetEarnLessonResponse getEarnLessonResponse = (GetEarnLessonResponse) obj;
            return m.c(unknownFields(), getEarnLessonResponse.unknownFields()) && this.type == getEarnLessonResponse.type && m.c(this.video_lesson, getEarnLessonResponse.video_lesson) && m.c(this.invite_lesson, getEarnLessonResponse.invite_lesson);
        }
        return false;
    }

    public final EarnInviteLesson getInvite_lesson() {
        return this.invite_lesson;
    }

    public final EarnLessonType getType() {
        return this.type;
    }

    public final EarnVideoLesson getVideo_lesson() {
        return this.video_lesson;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37;
            EarnVideoLesson earnVideoLesson = this.video_lesson;
            int hashCode2 = (hashCode + (earnVideoLesson != null ? earnVideoLesson.hashCode() : 0)) * 37;
            EarnInviteLesson earnInviteLesson = this.invite_lesson;
            int hashCode3 = hashCode2 + (earnInviteLesson != null ? earnInviteLesson.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m399newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        if (this.video_lesson != null) {
            arrayList.add("video_lesson=" + this.video_lesson);
        }
        if (this.invite_lesson != null) {
            arrayList.add("invite_lesson=" + this.invite_lesson);
        }
        h0 = z.h0(arrayList, ", ", "GetEarnLessonResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m399newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetEarnLessonResponse(EarnLessonType type, EarnVideoLesson earnVideoLesson, EarnInviteLesson earnInviteLesson, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.video_lesson = earnVideoLesson;
        this.invite_lesson = earnInviteLesson;
    }
}