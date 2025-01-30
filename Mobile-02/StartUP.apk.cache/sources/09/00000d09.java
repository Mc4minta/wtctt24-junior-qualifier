package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Button;
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
import org.spongycastle.i18n.MessageBundle;

/* compiled from: EarnQuizSuccessModal.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B3\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;", "animation", MessageBundle.TITLE_ENTRY, "Lcom/coinbase/android/apiv3/generated/common/Button;", "button", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Button;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;", "Lcom/coinbase/android/apiv3/generated/common/Button;", "getButton", "()Lcom/coinbase/android/apiv3/generated/common/Button;", "Ljava/lang/String;", "getTitle", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;", "getAnimation", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnAnimation;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Button;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class EarnQuizSuccessModal extends a {
    public static final ProtoAdapter<EarnQuizSuccessModal> ADAPTER;
    public static final Parcelable.Creator<EarnQuizSuccessModal> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnAnimation#ADAPTER", tag = 1)
    private final EarnAnimation animation;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Button#ADAPTER", tag = 3)
    private final Button button;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;

    /* compiled from: EarnQuizSuccessModal.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizSuccessModal;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(EarnQuizSuccessModal.class);
        ProtoAdapter<EarnQuizSuccessModal> protoAdapter = new ProtoAdapter<EarnQuizSuccessModal>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loyalty.EarnQuizSuccessModal") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizSuccessModal$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EarnQuizSuccessModal decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                EarnAnimation earnAnimation = null;
                String str = "";
                Button button = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new EarnQuizSuccessModal(earnAnimation, str, button, reader.e(d2));
                    }
                    if (g2 == 1) {
                        earnAnimation = EarnAnimation.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        button = Button.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, EarnQuizSuccessModal value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAnimation() != null) {
                    EarnAnimation.ADAPTER.encodeWithTag(writer, 1, value.getAnimation());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (value.getButton() != null) {
                    Button.ADAPTER.encodeWithTag(writer, 3, value.getButton());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(EarnQuizSuccessModal value) {
                m.h(value, "value");
                if (value.getAnimation() == null) {
                    return 0;
                }
                int encodedSizeWithTag = EarnAnimation.ADAPTER.encodedSizeWithTag(1, value.getAnimation());
                if (!m.c(value.getTitle(), "")) {
                    r1 = (value.getButton() != null ? Button.ADAPTER.encodedSizeWithTag(3, value.getButton()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.getTitle());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public EarnQuizSuccessModal redact(EarnQuizSuccessModal value) {
                m.h(value, "value");
                EarnAnimation animation = value.getAnimation();
                EarnAnimation redact = animation != null ? EarnAnimation.ADAPTER.redact(animation) : null;
                Button button = value.getButton();
                return EarnQuizSuccessModal.copy$default(value, redact, null, button != null ? Button.ADAPTER.redact(button) : null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public EarnQuizSuccessModal() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ EarnQuizSuccessModal(EarnAnimation earnAnimation, String str, Button button, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : earnAnimation, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : button, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ EarnQuizSuccessModal copy$default(EarnQuizSuccessModal earnQuizSuccessModal, EarnAnimation earnAnimation, String str, Button button, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            earnAnimation = earnQuizSuccessModal.animation;
        }
        if ((i2 & 2) != 0) {
            str = earnQuizSuccessModal.title;
        }
        if ((i2 & 4) != 0) {
            button = earnQuizSuccessModal.button;
        }
        if ((i2 & 8) != 0) {
            iVar = earnQuizSuccessModal.unknownFields();
        }
        return earnQuizSuccessModal.copy(earnAnimation, str, button, iVar);
    }

    public final EarnQuizSuccessModal copy(EarnAnimation earnAnimation, String title, Button button, i unknownFields) {
        m.h(title, "title");
        m.h(unknownFields, "unknownFields");
        return new EarnQuizSuccessModal(earnAnimation, title, button, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EarnQuizSuccessModal) {
            EarnQuizSuccessModal earnQuizSuccessModal = (EarnQuizSuccessModal) obj;
            return m.c(unknownFields(), earnQuizSuccessModal.unknownFields()) && m.c(this.animation, earnQuizSuccessModal.animation) && m.c(this.title, earnQuizSuccessModal.title) && m.c(this.button, earnQuizSuccessModal.button);
        }
        return false;
    }

    public final EarnAnimation getAnimation() {
        return this.animation;
    }

    public final Button getButton() {
        return this.button;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            EarnAnimation earnAnimation = this.animation;
            int hashCode2 = (((hashCode + (earnAnimation != null ? earnAnimation.hashCode() : 0)) * 37) + this.title.hashCode()) * 37;
            Button button = this.button;
            int hashCode3 = hashCode2 + (button != null ? button.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m395newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.animation != null) {
            arrayList.add("animation=" + this.animation);
        }
        arrayList.add("title=" + b.c(this.title));
        if (this.button != null) {
            arrayList.add("button=" + this.button);
        }
        h0 = z.h0(arrayList, ", ", "EarnQuizSuccessModal{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnQuizSuccessModal(EarnAnimation earnAnimation, String title, Button button, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(unknownFields, "unknownFields");
        this.animation = earnAnimation;
        this.title = title;
        this.button = button;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m395newBuilder() {
        throw new AssertionError();
    }
}