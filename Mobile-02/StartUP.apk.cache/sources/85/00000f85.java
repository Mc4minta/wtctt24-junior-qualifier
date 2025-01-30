package com.coinbase.android.apiv3.generated.unauthed.proofing;

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
import kotlin.x;

/* compiled from: ListEmployerNameResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*BS\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJY\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010#R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "question", "question_subtitle", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/AnswerType;", "answer_type", "answer_placeholder", "", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/AnswerOption;", "data", "answer_title", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/proofing/AnswerType;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameResponse;", "Ljava/lang/String;", "getAnswer_placeholder", "getAnswer_title", "getQuestion", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/AnswerType;", "getAnswer_type", "()Lcom/coinbase/android/apiv3/generated/unauthed/proofing/AnswerType;", "Ljava/util/List;", "getData", "()Ljava/util/List;", "getQuestion_subtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/proofing/AnswerType;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListEmployerNameResponse extends a {
    public static final ProtoAdapter<ListEmployerNameResponse> ADAPTER;
    public static final Parcelable.Creator<ListEmployerNameResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "answerPlaceholder", tag = 4)
    private final String answer_placeholder;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "answerTitle", tag = 6)
    private final String answer_title;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.proofing.AnswerType#ADAPTER", jsonName = "answerType", tag = 3)
    private final AnswerType answer_type;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.proofing.AnswerOption#ADAPTER", label = p.a.REPEATED, tag = 5)
    private final List<AnswerOption> data;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String question;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "questionSubtitle", tag = 2)
    private final String question_subtitle;

    /* compiled from: ListEmployerNameResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/proofing/ListEmployerNameResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListEmployerNameResponse> protoAdapter = new ProtoAdapter<ListEmployerNameResponse>(c.LENGTH_DELIMITED, e0.b(ListEmployerNameResponse.class), "type.googleapis.com/coinbase.public_api.unauthed.proofing.ListEmployerNameResponse") { // from class: com.coinbase.android.apiv3.generated.unauthed.proofing.ListEmployerNameResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListEmployerNameResponse decode(k reader) {
                AnswerType answerType;
                ProtoAdapter.EnumConstantNotFoundException e2;
                m.h(reader, "reader");
                AnswerType answerType2 = AnswerType.OPTIONS;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                AnswerType answerType3 = answerType2;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListEmployerNameResponse(str, str2, answerType3, str3, arrayList, str4, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            try {
                                answerType = AnswerType.ADAPTER.decode(reader);
                                try {
                                    x xVar = x.a;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                    e2 = e3;
                                    reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                    x xVar2 = x.a;
                                    answerType3 = answerType;
                                }
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                answerType = answerType3;
                                e2 = e4;
                            }
                            answerType3 = answerType;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            arrayList.add(AnswerOption.ADAPTER.decode(reader));
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListEmployerNameResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getQuestion(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getQuestion());
                }
                if (!m.c(value.getQuestion_subtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getQuestion_subtitle());
                }
                if (value.getAnswer_type() != AnswerType.OPTIONS) {
                    AnswerType.ADAPTER.encodeWithTag(writer, 3, value.getAnswer_type());
                }
                if (!m.c(value.getAnswer_placeholder(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getAnswer_placeholder());
                }
                AnswerOption.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.getData());
                if (!m.c(value.getAnswer_title(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getAnswer_title());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListEmployerNameResponse value) {
                m.h(value, "value");
                if (m.c(value.getQuestion(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getQuestion());
                if (!m.c(value.getQuestion_subtitle(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getQuestion_subtitle());
                    if (value.getAnswer_type() != AnswerType.OPTIONS) {
                        int encodedSizeWithTag3 = AnswerType.ADAPTER.encodedSizeWithTag(3, value.getAnswer_type());
                        if (!m.c(value.getAnswer_placeholder(), "")) {
                            r2 = (m.c(value.getAnswer_title(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getAnswer_title()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(4, value.getAnswer_placeholder()) + AnswerOption.ADAPTER.asRepeated().encodedSizeWithTag(5, value.getData());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListEmployerNameResponse redact(ListEmployerNameResponse value) {
                m.h(value, "value");
                return ListEmployerNameResponse.copy$default(value, null, null, null, null, b.a(value.getData(), AnswerOption.ADAPTER), null, i.a, 47, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ListEmployerNameResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ ListEmployerNameResponse(String str, String str2, AnswerType answerType, String str3, List list, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? AnswerType.OPTIONS : answerType, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? r.g() : list, (i2 & 32) == 0 ? str4 : "", (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListEmployerNameResponse copy$default(ListEmployerNameResponse listEmployerNameResponse, String str, String str2, AnswerType answerType, String str3, List list, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = listEmployerNameResponse.question;
        }
        if ((i2 & 2) != 0) {
            str2 = listEmployerNameResponse.question_subtitle;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            answerType = listEmployerNameResponse.answer_type;
        }
        AnswerType answerType2 = answerType;
        if ((i2 & 8) != 0) {
            str3 = listEmployerNameResponse.answer_placeholder;
        }
        String str6 = str3;
        List<AnswerOption> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = listEmployerNameResponse.data;
        }
        List list3 = list2;
        if ((i2 & 32) != 0) {
            str4 = listEmployerNameResponse.answer_title;
        }
        String str7 = str4;
        if ((i2 & 64) != 0) {
            iVar = listEmployerNameResponse.unknownFields();
        }
        return listEmployerNameResponse.copy(str, str5, answerType2, str6, list3, str7, iVar);
    }

    public final ListEmployerNameResponse copy(String question, String question_subtitle, AnswerType answer_type, String answer_placeholder, List<AnswerOption> data, String answer_title, i unknownFields) {
        m.h(question, "question");
        m.h(question_subtitle, "question_subtitle");
        m.h(answer_type, "answer_type");
        m.h(answer_placeholder, "answer_placeholder");
        m.h(data, "data");
        m.h(answer_title, "answer_title");
        m.h(unknownFields, "unknownFields");
        return new ListEmployerNameResponse(question, question_subtitle, answer_type, answer_placeholder, data, answer_title, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListEmployerNameResponse) {
            ListEmployerNameResponse listEmployerNameResponse = (ListEmployerNameResponse) obj;
            return m.c(unknownFields(), listEmployerNameResponse.unknownFields()) && m.c(this.question, listEmployerNameResponse.question) && m.c(this.question_subtitle, listEmployerNameResponse.question_subtitle) && this.answer_type == listEmployerNameResponse.answer_type && m.c(this.answer_placeholder, listEmployerNameResponse.answer_placeholder) && m.c(this.data, listEmployerNameResponse.data) && m.c(this.answer_title, listEmployerNameResponse.answer_title);
        }
        return false;
    }

    public final String getAnswer_placeholder() {
        return this.answer_placeholder;
    }

    public final String getAnswer_title() {
        return this.answer_title;
    }

    public final AnswerType getAnswer_type() {
        return this.answer_type;
    }

    public final List<AnswerOption> getData() {
        return this.data;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getQuestion_subtitle() {
        return this.question_subtitle;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.question.hashCode()) * 37) + this.question_subtitle.hashCode()) * 37) + this.answer_type.hashCode()) * 37) + this.answer_placeholder.hashCode()) * 37) + this.data.hashCode()) * 37) + this.answer_title.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m572newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("question=" + b.c(this.question));
        arrayList.add("question_subtitle=" + b.c(this.question_subtitle));
        arrayList.add("answer_type=" + this.answer_type);
        arrayList.add("answer_placeholder=" + b.c(this.answer_placeholder));
        if (!this.data.isEmpty()) {
            arrayList.add("data=" + this.data);
        }
        arrayList.add("answer_title=" + b.c(this.answer_title));
        h0 = z.h0(arrayList, ", ", "ListEmployerNameResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m572newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListEmployerNameResponse(String question, String question_subtitle, AnswerType answer_type, String answer_placeholder, List<AnswerOption> data, String answer_title, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(question, "question");
        m.h(question_subtitle, "question_subtitle");
        m.h(answer_type, "answer_type");
        m.h(answer_placeholder, "answer_placeholder");
        m.h(data, "data");
        m.h(answer_title, "answer_title");
        m.h(unknownFields, "unknownFields");
        this.question = question;
        this.question_subtitle = question_subtitle;
        this.answer_type = answer_type;
        this.answer_placeholder = answer_placeholder;
        this.data = data;
        this.answer_title = answer_title;
    }
}