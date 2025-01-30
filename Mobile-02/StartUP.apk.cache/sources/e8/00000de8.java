package com.coinbase.android.apiv3.generated.authed.referrals_service;

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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: Referral.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(BM\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJS\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0015\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/referrals_service/Referral;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "referee_first_name", "referee_uuid", "Lcom/coinbase/android/apiv3/generated/authed/referrals_service/ReferralStatus;", "referee_status", "status_text", "received_reminder_email", "reminder_button_text", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/referrals_service/ReferralStatus;Ljava/lang/String;ZLjava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/referrals_service/Referral;", "Ljava/lang/String;", "getReminder_button_text", "getStatus_text", "getReferee_first_name", "getReferee_uuid", "Lcom/coinbase/android/apiv3/generated/authed/referrals_service/ReferralStatus;", "getReferee_status", "()Lcom/coinbase/android/apiv3/generated/authed/referrals_service/ReferralStatus;", "Z", "getReceived_reminder_email", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/referrals_service/ReferralStatus;Ljava/lang/String;ZLjava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Referral extends a {
    public static final ProtoAdapter<Referral> ADAPTER;
    public static final Parcelable.Creator<Referral> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "receivedReminderEmail", tag = 5)
    private final boolean received_reminder_email;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "refereeFirstName", tag = 1)
    private final String referee_first_name;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.referrals_service.ReferralStatus#ADAPTER", jsonName = "refereeStatus", tag = 3)
    private final ReferralStatus referee_status;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "refereeUuid", tag = 2)
    private final String referee_uuid;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reminderButtonText", tag = 6)
    private final String reminder_button_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "statusText", tag = 4)
    private final String status_text;

    /* compiled from: Referral.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/referrals_service/Referral$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/referrals_service/Referral;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Referral> protoAdapter = new ProtoAdapter<Referral>(c.LENGTH_DELIMITED, e0.b(Referral.class), "type.googleapis.com/coinbase.public_api.authed.referrals_service.Referral") { // from class: com.coinbase.android.apiv3.generated.authed.referrals_service.Referral$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Referral decode(k reader) {
                m.h(reader, "reader");
                ReferralStatus referralStatus = ReferralStatus.REGISTERED;
                long d2 = reader.d();
                ReferralStatus referralStatus2 = referralStatus;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Referral(str, str2, referralStatus2, str3, z, str4, reader.e(d2));
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
                                referralStatus2 = ReferralStatus.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
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
            public void encode(l writer, Referral value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getReferee_first_name(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getReferee_first_name());
                }
                if (!m.c(value.getReferee_uuid(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getReferee_uuid());
                }
                if (value.getReferee_status() != ReferralStatus.REGISTERED) {
                    ReferralStatus.ADAPTER.encodeWithTag(writer, 3, value.getReferee_status());
                }
                if (!m.c(value.getStatus_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getStatus_text());
                }
                if (value.getReceived_reminder_email()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 5, Boolean.valueOf(value.getReceived_reminder_email()));
                }
                if (!m.c(value.getReminder_button_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getReminder_button_text());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Referral value) {
                m.h(value, "value");
                if (m.c(value.getReferee_first_name(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getReferee_first_name());
                if (!m.c(value.getReferee_uuid(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getReferee_uuid());
                    if (value.getReferee_status() != ReferralStatus.REGISTERED) {
                        int encodedSizeWithTag3 = ReferralStatus.ADAPTER.encodedSizeWithTag(3, value.getReferee_status());
                        if (!m.c(value.getStatus_text(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getStatus_text());
                            if (value.getReceived_reminder_email()) {
                                r2 = (m.c(value.getReminder_button_text(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getReminder_button_text()) + value.unknownFields().Q()) + ProtoAdapter.BOOL.encodedSizeWithTag(5, Boolean.valueOf(value.getReceived_reminder_email()));
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
            public Referral redact(Referral value) {
                m.h(value, "value");
                return Referral.copy$default(value, null, null, null, null, false, null, i.a, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Referral() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    public /* synthetic */ Referral(String str, String str2, ReferralStatus referralStatus, String str3, boolean z, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? ReferralStatus.REGISTERED : referralStatus, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? false : z, (i2 & 32) == 0 ? str4 : "", (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Referral copy$default(Referral referral, String str, String str2, ReferralStatus referralStatus, String str3, boolean z, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = referral.referee_first_name;
        }
        if ((i2 & 2) != 0) {
            str2 = referral.referee_uuid;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            referralStatus = referral.referee_status;
        }
        ReferralStatus referralStatus2 = referralStatus;
        if ((i2 & 8) != 0) {
            str3 = referral.status_text;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            z = referral.received_reminder_email;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            str4 = referral.reminder_button_text;
        }
        String str7 = str4;
        if ((i2 & 64) != 0) {
            iVar = referral.unknownFields();
        }
        return referral.copy(str, str5, referralStatus2, str6, z2, str7, iVar);
    }

    public final Referral copy(String referee_first_name, String referee_uuid, ReferralStatus referee_status, String status_text, boolean z, String reminder_button_text, i unknownFields) {
        m.h(referee_first_name, "referee_first_name");
        m.h(referee_uuid, "referee_uuid");
        m.h(referee_status, "referee_status");
        m.h(status_text, "status_text");
        m.h(reminder_button_text, "reminder_button_text");
        m.h(unknownFields, "unknownFields");
        return new Referral(referee_first_name, referee_uuid, referee_status, status_text, z, reminder_button_text, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Referral) {
            Referral referral = (Referral) obj;
            return m.c(unknownFields(), referral.unknownFields()) && m.c(this.referee_first_name, referral.referee_first_name) && m.c(this.referee_uuid, referral.referee_uuid) && this.referee_status == referral.referee_status && m.c(this.status_text, referral.status_text) && this.received_reminder_email == referral.received_reminder_email && m.c(this.reminder_button_text, referral.reminder_button_text);
        }
        return false;
    }

    public final boolean getReceived_reminder_email() {
        return this.received_reminder_email;
    }

    public final String getReferee_first_name() {
        return this.referee_first_name;
    }

    public final ReferralStatus getReferee_status() {
        return this.referee_status;
    }

    public final String getReferee_uuid() {
        return this.referee_uuid;
    }

    public final String getReminder_button_text() {
        return this.reminder_button_text;
    }

    public final String getStatus_text() {
        return this.status_text;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.referee_first_name.hashCode()) * 37) + this.referee_uuid.hashCode()) * 37) + this.referee_status.hashCode()) * 37) + this.status_text.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.received_reminder_email)) * 37) + this.reminder_button_text.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m456newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("referee_first_name=" + b.c(this.referee_first_name));
        arrayList.add("referee_uuid=" + b.c(this.referee_uuid));
        arrayList.add("referee_status=" + this.referee_status);
        arrayList.add("status_text=" + b.c(this.status_text));
        arrayList.add("received_reminder_email=" + this.received_reminder_email);
        arrayList.add("reminder_button_text=" + b.c(this.reminder_button_text));
        h0 = z.h0(arrayList, ", ", "Referral{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m456newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Referral(String referee_first_name, String referee_uuid, ReferralStatus referee_status, String status_text, boolean z, String reminder_button_text, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(referee_first_name, "referee_first_name");
        m.h(referee_uuid, "referee_uuid");
        m.h(referee_status, "referee_status");
        m.h(status_text, "status_text");
        m.h(reminder_button_text, "reminder_button_text");
        m.h(unknownFields, "unknownFields");
        this.referee_first_name = referee_first_name;
        this.referee_uuid = referee_uuid;
        this.referee_status = referee_status;
        this.status_text = status_text;
        this.received_reminder_email = z;
        this.reminder_button_text = reminder_button_text;
    }
}