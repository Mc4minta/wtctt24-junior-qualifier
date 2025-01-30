package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.google.protobuf.u;
import com.squareup.wire.ProtoAdapter;
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

/* compiled from: UserTaxInfoResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,BO\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/InterviewStatus;", "status", ApiConstants.DESCRIPTION, "Lcom/google/protobuf/u;", "last_updated", "short_error", "long_error", "Lcom/coinbase/android/apiv3/generated/authed/InterviewPriority;", "priority", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/InterviewStatus;Ljava/lang/String;Lcom/google/protobuf/u;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/InterviewPriority;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoResponse;", "Ljava/lang/String;", "getDescription", "getShort_error", "getLong_error", "Lcom/coinbase/android/apiv3/generated/authed/InterviewPriority;", "getPriority", "()Lcom/coinbase/android/apiv3/generated/authed/InterviewPriority;", "Lcom/coinbase/android/apiv3/generated/authed/InterviewStatus;", "getStatus", "()Lcom/coinbase/android/apiv3/generated/authed/InterviewStatus;", "Lcom/google/protobuf/u;", "getLast_updated", "()Lcom/google/protobuf/u;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/InterviewStatus;Ljava/lang/String;Lcom/google/protobuf/u;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/InterviewPriority;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UserTaxInfoResponse extends com.squareup.wire.a {
    public static final ProtoAdapter<UserTaxInfoResponse> ADAPTER;
    public static final Parcelable.Creator<UserTaxInfoResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String description;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "lastUpdated", tag = 3)
    private final u last_updated;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "longError", tag = 5)
    private final String long_error;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.InterviewPriority#ADAPTER", tag = 6)
    private final InterviewPriority priority;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "shortError", tag = 4)
    private final String short_error;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.InterviewStatus#ADAPTER", tag = 1)
    private final InterviewStatus status;

    /* compiled from: UserTaxInfoResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/UserTaxInfoResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UserTaxInfoResponse> protoAdapter = new ProtoAdapter<UserTaxInfoResponse>(c.LENGTH_DELIMITED, e0.b(UserTaxInfoResponse.class), "type.googleapis.com/coinbase.public_api.authed.UserTaxInfoResponse") { // from class: com.coinbase.android.apiv3.generated.authed.UserTaxInfoResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserTaxInfoResponse decode(k reader) {
                m.h(reader, "reader");
                InterviewStatus interviewStatus = InterviewStatus.UNKNOWN;
                InterviewPriority interviewPriority = InterviewPriority.UNKNOWN_PRIORITY;
                long d2 = reader.d();
                InterviewStatus interviewStatus2 = interviewStatus;
                InterviewPriority interviewPriority2 = interviewPriority;
                String str = "";
                String str2 = str;
                String str3 = str2;
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UserTaxInfoResponse(interviewStatus2, str, uVar, str2, str3, interviewPriority2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            try {
                                interviewStatus2 = InterviewStatus.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            uVar = u.a.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            try {
                                interviewPriority2 = InterviewPriority.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                                break;
                            }
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UserTaxInfoResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStatus() != InterviewStatus.UNKNOWN) {
                    InterviewStatus.ADAPTER.encodeWithTag(writer, 1, value.getStatus());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDescription());
                }
                if (value.getLast_updated() != null) {
                    u.a.encodeWithTag(writer, 3, value.getLast_updated());
                }
                if (!m.c(value.getShort_error(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getShort_error());
                }
                if (!m.c(value.getLong_error(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getLong_error());
                }
                if (value.getPriority() != InterviewPriority.UNKNOWN_PRIORITY) {
                    InterviewPriority.ADAPTER.encodeWithTag(writer, 6, value.getPriority());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UserTaxInfoResponse value) {
                m.h(value, "value");
                if (value.getStatus() == InterviewStatus.UNKNOWN) {
                    return 0;
                }
                int encodedSizeWithTag = InterviewStatus.ADAPTER.encodedSizeWithTag(1, value.getStatus());
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getDescription());
                    if (value.getLast_updated() != null) {
                        int encodedSizeWithTag3 = u.a.encodedSizeWithTag(3, value.getLast_updated());
                        if (!m.c(value.getShort_error(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getShort_error());
                            if (!m.c(value.getLong_error(), "")) {
                                r2 = (value.getPriority() != InterviewPriority.UNKNOWN_PRIORITY ? InterviewPriority.ADAPTER.encodedSizeWithTag(6, value.getPriority()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getLong_error());
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
            public UserTaxInfoResponse redact(UserTaxInfoResponse value) {
                m.h(value, "value");
                u last_updated = value.getLast_updated();
                return UserTaxInfoResponse.copy$default(value, null, null, last_updated != null ? u.a.redact(last_updated) : null, null, null, null, i.a, 59, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public UserTaxInfoResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ UserTaxInfoResponse(InterviewStatus interviewStatus, String str, u uVar, String str2, String str3, InterviewPriority interviewPriority, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? InterviewStatus.UNKNOWN : interviewStatus, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : uVar, (i2 & 8) != 0 ? "" : str2, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? InterviewPriority.UNKNOWN_PRIORITY : interviewPriority, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ UserTaxInfoResponse copy$default(UserTaxInfoResponse userTaxInfoResponse, InterviewStatus interviewStatus, String str, u uVar, String str2, String str3, InterviewPriority interviewPriority, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interviewStatus = userTaxInfoResponse.status;
        }
        if ((i2 & 2) != 0) {
            str = userTaxInfoResponse.description;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            uVar = userTaxInfoResponse.last_updated;
        }
        u uVar2 = uVar;
        if ((i2 & 8) != 0) {
            str2 = userTaxInfoResponse.short_error;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = userTaxInfoResponse.long_error;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            interviewPriority = userTaxInfoResponse.priority;
        }
        InterviewPriority interviewPriority2 = interviewPriority;
        if ((i2 & 64) != 0) {
            iVar = userTaxInfoResponse.unknownFields();
        }
        return userTaxInfoResponse.copy(interviewStatus, str4, uVar2, str5, str6, interviewPriority2, iVar);
    }

    public final UserTaxInfoResponse copy(InterviewStatus status, String description, u uVar, String short_error, String long_error, InterviewPriority priority, i unknownFields) {
        m.h(status, "status");
        m.h(description, "description");
        m.h(short_error, "short_error");
        m.h(long_error, "long_error");
        m.h(priority, "priority");
        m.h(unknownFields, "unknownFields");
        return new UserTaxInfoResponse(status, description, uVar, short_error, long_error, priority, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UserTaxInfoResponse) {
            UserTaxInfoResponse userTaxInfoResponse = (UserTaxInfoResponse) obj;
            return m.c(unknownFields(), userTaxInfoResponse.unknownFields()) && this.status == userTaxInfoResponse.status && m.c(this.description, userTaxInfoResponse.description) && m.c(this.last_updated, userTaxInfoResponse.last_updated) && m.c(this.short_error, userTaxInfoResponse.short_error) && m.c(this.long_error, userTaxInfoResponse.long_error) && this.priority == userTaxInfoResponse.priority;
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final u getLast_updated() {
        return this.last_updated;
    }

    public final String getLong_error() {
        return this.long_error;
    }

    public final InterviewPriority getPriority() {
        return this.priority;
    }

    public final String getShort_error() {
        return this.short_error;
    }

    public final InterviewStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.status.hashCode()) * 37) + this.description.hashCode()) * 37;
            u uVar = this.last_updated;
            int hashCode2 = ((((((hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.short_error.hashCode()) * 37) + this.long_error.hashCode()) * 37) + this.priority.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m263newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("status=" + this.status);
        arrayList.add("description=" + com.squareup.wire.q.b.c(this.description));
        if (this.last_updated != null) {
            arrayList.add("last_updated=" + this.last_updated);
        }
        arrayList.add("short_error=" + com.squareup.wire.q.b.c(this.short_error));
        arrayList.add("long_error=" + com.squareup.wire.q.b.c(this.long_error));
        arrayList.add("priority=" + this.priority);
        h0 = z.h0(arrayList, ", ", "UserTaxInfoResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m263newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTaxInfoResponse(InterviewStatus status, String description, u uVar, String short_error, String long_error, InterviewPriority priority, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(status, "status");
        m.h(description, "description");
        m.h(short_error, "short_error");
        m.h(long_error, "long_error");
        m.h(priority, "priority");
        m.h(unknownFields, "unknownFields");
        this.status = status;
        this.description = description;
        this.last_updated = uVar;
        this.short_error = short_error;
        this.long_error = long_error;
        this.priority = priority;
    }
}