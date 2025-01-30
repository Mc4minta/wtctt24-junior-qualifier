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

/* compiled from: EarnAnimation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001c\u0010\u0012\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001d\u0010\f¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/AnimationType;", "type", "start_progress", "end_progress", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/AnimationType;IILj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/AnimationType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/AnimationType;", "I", "getEnd_progress", "getStart_progress", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/AnimationType;IILj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class EarnAnimation extends a {
    public static final ProtoAdapter<EarnAnimation> ADAPTER;
    public static final Parcelable.Creator<EarnAnimation> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "endProgress", tag = 3)
    private final int end_progress;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "startProgress", tag = 2)
    private final int start_progress;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.AnimationType#ADAPTER", tag = 1)
    private final AnimationType type;

    /* compiled from: EarnAnimation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<EarnAnimation> protoAdapter = new ProtoAdapter<EarnAnimation>(c.LENGTH_DELIMITED, e0.b(EarnAnimation.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.EarnAnimation") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.EarnAnimation$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EarnAnimation decode(k reader) {
                m.h(reader, "reader");
                AnimationType animationType = AnimationType.UNKNOWN_ANIMATION_TYPE;
                long d2 = reader.d();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new EarnAnimation(animationType, i2, i3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            animationType = AnimationType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, EarnAnimation value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != AnimationType.UNKNOWN_ANIMATION_TYPE) {
                    AnimationType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getStart_progress() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(value.getStart_progress()));
                }
                if (value.getEnd_progress() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.getEnd_progress()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(EarnAnimation value) {
                m.h(value, "value");
                if (value.getType() == AnimationType.UNKNOWN_ANIMATION_TYPE) {
                    return 0;
                }
                int encodedSizeWithTag = AnimationType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (value.getStart_progress() != 0) {
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    r2 = (value.getEnd_progress() != 0 ? protoAdapter2.encodedSizeWithTag(3, Integer.valueOf(value.getEnd_progress())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.getStart_progress()));
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public EarnAnimation redact(EarnAnimation value) {
                m.h(value, "value");
                return EarnAnimation.copy$default(value, null, 0, 0, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public EarnAnimation() {
        this(null, 0, 0, null, 15, null);
    }

    public /* synthetic */ EarnAnimation(AnimationType animationType, int i2, int i3, i iVar, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? AnimationType.UNKNOWN_ANIMATION_TYPE : animationType, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ EarnAnimation copy$default(EarnAnimation earnAnimation, AnimationType animationType, int i2, int i3, i iVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            animationType = earnAnimation.type;
        }
        if ((i4 & 2) != 0) {
            i2 = earnAnimation.start_progress;
        }
        if ((i4 & 4) != 0) {
            i3 = earnAnimation.end_progress;
        }
        if ((i4 & 8) != 0) {
            iVar = earnAnimation.unknownFields();
        }
        return earnAnimation.copy(animationType, i2, i3, iVar);
    }

    public final EarnAnimation copy(AnimationType type, int i2, int i3, i unknownFields) {
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new EarnAnimation(type, i2, i3, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EarnAnimation) {
            EarnAnimation earnAnimation = (EarnAnimation) obj;
            return m.c(unknownFields(), earnAnimation.unknownFields()) && this.type == earnAnimation.type && this.start_progress == earnAnimation.start_progress && this.end_progress == earnAnimation.end_progress;
        }
        return false;
    }

    public final int getEnd_progress() {
        return this.end_progress;
    }

    public final int getStart_progress() {
        return this.start_progress;
    }

    public final AnimationType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.start_progress) * 37) + this.end_progress;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m391newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        arrayList.add("start_progress=" + this.start_progress);
        arrayList.add("end_progress=" + this.end_progress);
        h0 = z.h0(arrayList, ", ", "EarnAnimation{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m391newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnAnimation(AnimationType type, int i2, int i3, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.start_progress = i2;
        this.end_progress = i3;
    }
}