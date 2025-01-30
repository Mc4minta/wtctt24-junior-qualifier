package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: EarnSingleSelectQuiz.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B_\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJe\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b#\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b$\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b)\u0010\u000f¨\u0006-"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "assignment_uuid", "prompt_uuid", "header", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;", "progress_bar", "question", ApiConstants.DESCRIPTION, "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizOption;", "options", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "Ljava/lang/String;", "getAssignment_uuid", "getDescription", "getQuestion", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;", "getProgress_bar", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;", "getHeader", "getPrompt_uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class EarnSingleSelectQuiz extends a {
    public static final ProtoAdapter<EarnSingleSelectQuiz> ADAPTER;
    public static final Parcelable.Creator<EarnSingleSelectQuiz> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assignmentUuid", tag = 1)
    private final String assignment_uuid;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String header;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizOption#ADAPTER", label = p.a.REPEATED, tag = 7)
    private final List<EarnQuizOption> options;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizProgressBar#ADAPTER", jsonName = "progressBar", tag = 4)
    private final EarnQuizProgressBar progress_bar;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "promptUuid", tag = 2)
    private final String prompt_uuid;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String question;

    /* compiled from: EarnSingleSelectQuiz.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnSingleSelectQuiz;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(EarnSingleSelectQuiz.class);
        ProtoAdapter<EarnSingleSelectQuiz> protoAdapter = new ProtoAdapter<EarnSingleSelectQuiz>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loyalty.EarnSingleSelectQuiz") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.EarnSingleSelectQuiz$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EarnSingleSelectQuiz decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                EarnQuizProgressBar earnQuizProgressBar = null;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new EarnSingleSelectQuiz(str, str5, str2, earnQuizProgressBar, str3, str4, arrayList, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            earnQuizProgressBar = EarnQuizProgressBar.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            arrayList.add(EarnQuizOption.ADAPTER.decode(reader));
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, EarnSingleSelectQuiz value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAssignment_uuid(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAssignment_uuid());
                }
                if (!m.c(value.getPrompt_uuid(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPrompt_uuid());
                }
                if (!m.c(value.getHeader(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getHeader());
                }
                if (value.getProgress_bar() != null) {
                    EarnQuizProgressBar.ADAPTER.encodeWithTag(writer, 4, value.getProgress_bar());
                }
                if (!m.c(value.getQuestion(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getQuestion());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getDescription());
                }
                EarnQuizOption.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.getOptions());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(EarnSingleSelectQuiz value) {
                m.h(value, "value");
                if (m.c(value.getAssignment_uuid(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getAssignment_uuid());
                if (!m.c(value.getPrompt_uuid(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getPrompt_uuid());
                    if (!m.c(value.getHeader(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getHeader());
                        if (value.getProgress_bar() != null) {
                            int encodedSizeWithTag4 = EarnQuizProgressBar.ADAPTER.encodedSizeWithTag(4, value.getProgress_bar());
                            if (!m.c(value.getQuestion(), "")) {
                                r2 = (m.c(value.getDescription(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getDescription()) + EarnQuizOption.ADAPTER.asRepeated().encodedSizeWithTag(7, value.getOptions()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(5, value.getQuestion());
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
            public EarnSingleSelectQuiz redact(EarnSingleSelectQuiz value) {
                EarnSingleSelectQuiz copy;
                m.h(value, "value");
                EarnQuizProgressBar progress_bar = value.getProgress_bar();
                copy = value.copy((r18 & 1) != 0 ? value.assignment_uuid : null, (r18 & 2) != 0 ? value.prompt_uuid : null, (r18 & 4) != 0 ? value.header : null, (r18 & 8) != 0 ? value.progress_bar : progress_bar != null ? EarnQuizProgressBar.ADAPTER.redact(progress_bar) : null, (r18 & 16) != 0 ? value.question : null, (r18 & 32) != 0 ? value.description : null, (r18 & 64) != 0 ? value.options : b.a(value.getOptions(), EarnQuizOption.ADAPTER), (r18 & 128) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public EarnSingleSelectQuiz() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ EarnSingleSelectQuiz(String str, String str2, String str3, EarnQuizProgressBar earnQuizProgressBar, String str4, String str5, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? null : earnQuizProgressBar, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? r.g() : list, (i2 & 128) != 0 ? i.a : iVar);
    }

    public final EarnSingleSelectQuiz copy(String assignment_uuid, String prompt_uuid, String header, EarnQuizProgressBar earnQuizProgressBar, String question, String description, List<EarnQuizOption> options, i unknownFields) {
        m.h(assignment_uuid, "assignment_uuid");
        m.h(prompt_uuid, "prompt_uuid");
        m.h(header, "header");
        m.h(question, "question");
        m.h(description, "description");
        m.h(options, "options");
        m.h(unknownFields, "unknownFields");
        return new EarnSingleSelectQuiz(assignment_uuid, prompt_uuid, header, earnQuizProgressBar, question, description, options, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EarnSingleSelectQuiz) {
            EarnSingleSelectQuiz earnSingleSelectQuiz = (EarnSingleSelectQuiz) obj;
            return m.c(unknownFields(), earnSingleSelectQuiz.unknownFields()) && m.c(this.assignment_uuid, earnSingleSelectQuiz.assignment_uuid) && m.c(this.prompt_uuid, earnSingleSelectQuiz.prompt_uuid) && m.c(this.header, earnSingleSelectQuiz.header) && m.c(this.progress_bar, earnSingleSelectQuiz.progress_bar) && m.c(this.question, earnSingleSelectQuiz.question) && m.c(this.description, earnSingleSelectQuiz.description) && m.c(this.options, earnSingleSelectQuiz.options);
        }
        return false;
    }

    public final String getAssignment_uuid() {
        return this.assignment_uuid;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHeader() {
        return this.header;
    }

    public final List<EarnQuizOption> getOptions() {
        return this.options;
    }

    public final EarnQuizProgressBar getProgress_bar() {
        return this.progress_bar;
    }

    public final String getPrompt_uuid() {
        return this.prompt_uuid;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.assignment_uuid.hashCode()) * 37) + this.prompt_uuid.hashCode()) * 37) + this.header.hashCode()) * 37;
            EarnQuizProgressBar earnQuizProgressBar = this.progress_bar;
            int hashCode2 = ((((((hashCode + (earnQuizProgressBar != null ? earnQuizProgressBar.hashCode() : 0)) * 37) + this.question.hashCode()) * 37) + this.description.hashCode()) * 37) + this.options.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m396newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("assignment_uuid=" + b.c(this.assignment_uuid));
        arrayList.add("prompt_uuid=" + b.c(this.prompt_uuid));
        arrayList.add("header=" + b.c(this.header));
        if (this.progress_bar != null) {
            arrayList.add("progress_bar=" + this.progress_bar);
        }
        arrayList.add("question=" + b.c(this.question));
        arrayList.add("description=" + b.c(this.description));
        if (!this.options.isEmpty()) {
            arrayList.add("options=" + this.options);
        }
        h0 = z.h0(arrayList, ", ", "EarnSingleSelectQuiz{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m396newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnSingleSelectQuiz(String assignment_uuid, String prompt_uuid, String header, EarnQuizProgressBar earnQuizProgressBar, String question, String description, List<EarnQuizOption> options, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(assignment_uuid, "assignment_uuid");
        m.h(prompt_uuid, "prompt_uuid");
        m.h(header, "header");
        m.h(question, "question");
        m.h(description, "description");
        m.h(options, "options");
        m.h(unknownFields, "unknownFields");
        this.assignment_uuid = assignment_uuid;
        this.prompt_uuid = prompt_uuid;
        this.header = header;
        this.progress_bar = earnQuizProgressBar;
        this.question = question;
        this.description = description;
        this.options = options;
    }
}