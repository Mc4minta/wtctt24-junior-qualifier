package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class b extends com.google.android.gms.common.internal.safeparcel.a {

    /* renamed from: b  reason: collision with root package name */
    private final int f6152b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6153c;

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f6154d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6155e;
    public static final b a = new b(0);
    public static final Parcelable.Creator<b> CREATOR = new o();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f6152b = i2;
        this.f6153c = i3;
        this.f6154d = pendingIntent;
        this.f6155e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n1(int i2) {
        if (i2 != 99) {
            if (i2 != 1500) {
                switch (i2) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return Payload.RESPONSE_DEVELOPER_ERROR;
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i2) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return Payload.RESPONSE_TIMEOUT;
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            default:
                                StringBuilder sb = new StringBuilder(31);
                                sb.append("UNKNOWN_ERROR_CODE(");
                                sb.append(i2);
                                sb.append(")");
                                return sb.toString();
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f6153c == bVar.f6153c && com.google.android.gms.common.internal.r.a(this.f6154d, bVar.f6154d) && com.google.android.gms.common.internal.r.a(this.f6155e, bVar.f6155e);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.r.b(Integer.valueOf(this.f6153c), this.f6154d, this.f6155e);
    }

    public final int i1() {
        return this.f6153c;
    }

    public final String j1() {
        return this.f6155e;
    }

    public final PendingIntent k1() {
        return this.f6154d;
    }

    public final boolean l1() {
        return (this.f6153c == 0 || this.f6154d == null) ? false : true;
    }

    public final boolean m1() {
        return this.f6153c == 0;
    }

    public final String toString() {
        return com.google.android.gms.common.internal.r.c(this).a("statusCode", n1(this.f6153c)).a("resolution", this.f6154d).a(ApiConstants.MESSAGE, this.f6155e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.f6152b);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 2, i1());
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, k1(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, j1(), false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }

    public b(int i2) {
        this(i2, null, null);
    }

    public b(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public b(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}