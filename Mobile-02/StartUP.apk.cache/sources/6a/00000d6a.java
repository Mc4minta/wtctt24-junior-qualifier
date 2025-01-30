package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
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

/* compiled from: PostEarnQuizAnswerRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B5\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "assignment_id", "prompt_id", "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizOption;", "options", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerRequest;", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "Ljava/lang/String;", "getAssignment_id", "getPrompt_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PostEarnQuizAnswerRequest extends a {
    public static final ProtoAdapter<PostEarnQuizAnswerRequest> ADAPTER;
    public static final Parcelable.Creator<PostEarnQuizAnswerRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assignmentId", tag = 1)
    private final String assignment_id;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizOption#ADAPTER", label = p.a.REPEATED, tag = 3)
    private final List<EarnQuizOption> options;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "promptId", tag = 2)
    private final String prompt_id;

    /* compiled from: PostEarnQuizAnswerRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/PostEarnQuizAnswerRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PostEarnQuizAnswerRequest> protoAdapter = new ProtoAdapter<PostEarnQuizAnswerRequest>(c.LENGTH_DELIMITED, e0.b(PostEarnQuizAnswerRequest.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.PostEarnQuizAnswerRequest") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.PostEarnQuizAnswerRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PostEarnQuizAnswerRequest decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PostEarnQuizAnswerRequest(str, str2, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        arrayList.add(EarnQuizOption.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PostEarnQuizAnswerRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAssignment_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAssignment_id());
                }
                if (!m.c(value.getPrompt_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPrompt_id());
                }
                EarnQuizOption.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getOptions());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PostEarnQuizAnswerRequest value) {
                m.h(value, "value");
                if (m.c(value.getAssignment_id(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return (m.c(value.getPrompt_id(), "") ? 0 : protoAdapter2.encodedSizeWithTag(2, value.getPrompt_id()) + EarnQuizOption.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getOptions()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(1, value.getAssignment_id());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PostEarnQuizAnswerRequest redact(PostEarnQuizAnswerRequest value) {
                m.h(value, "value");
                return PostEarnQuizAnswerRequest.copy$default(value, null, null, b.a(value.getOptions(), EarnQuizOption.ADAPTER), i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PostEarnQuizAnswerRequest() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ PostEarnQuizAnswerRequest(String str, String str2, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostEarnQuizAnswerRequest copy$default(PostEarnQuizAnswerRequest postEarnQuizAnswerRequest, String str, String str2, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = postEarnQuizAnswerRequest.assignment_id;
        }
        if ((i2 & 2) != 0) {
            str2 = postEarnQuizAnswerRequest.prompt_id;
        }
        if ((i2 & 4) != 0) {
            list = postEarnQuizAnswerRequest.options;
        }
        if ((i2 & 8) != 0) {
            iVar = postEarnQuizAnswerRequest.unknownFields();
        }
        return postEarnQuizAnswerRequest.copy(str, str2, list, iVar);
    }

    public final PostEarnQuizAnswerRequest copy(String assignment_id, String prompt_id, List<EarnQuizOption> options, i unknownFields) {
        m.h(assignment_id, "assignment_id");
        m.h(prompt_id, "prompt_id");
        m.h(options, "options");
        m.h(unknownFields, "unknownFields");
        return new PostEarnQuizAnswerRequest(assignment_id, prompt_id, options, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PostEarnQuizAnswerRequest) {
            PostEarnQuizAnswerRequest postEarnQuizAnswerRequest = (PostEarnQuizAnswerRequest) obj;
            return m.c(unknownFields(), postEarnQuizAnswerRequest.unknownFields()) && m.c(this.assignment_id, postEarnQuizAnswerRequest.assignment_id) && m.c(this.prompt_id, postEarnQuizAnswerRequest.prompt_id) && m.c(this.options, postEarnQuizAnswerRequest.options);
        }
        return false;
    }

    public final String getAssignment_id() {
        return this.assignment_id;
    }

    public final List<EarnQuizOption> getOptions() {
        return this.options;
    }

    public final String getPrompt_id() {
        return this.prompt_id;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.assignment_id.hashCode()) * 37) + this.prompt_id.hashCode()) * 37) + this.options.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m421newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("assignment_id=" + b.c(this.assignment_id));
        arrayList.add("prompt_id=" + b.c(this.prompt_id));
        if (!this.options.isEmpty()) {
            arrayList.add("options=" + this.options);
        }
        h0 = z.h0(arrayList, ", ", "PostEarnQuizAnswerRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m421newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostEarnQuizAnswerRequest(String assignment_id, String prompt_id, List<EarnQuizOption> options, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(assignment_id, "assignment_id");
        m.h(prompt_id, "prompt_id");
        m.h(options, "options");
        m.h(unknownFields, "unknownFields");
        this.assignment_id = assignment_id;
        this.prompt_id = prompt_id;
        this.options = options;
    }
}