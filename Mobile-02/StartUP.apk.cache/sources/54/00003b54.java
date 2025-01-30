package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class b extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<b> CREATOR = new u();
    Bundle a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f9269b;

    public b(Bundle bundle) {
        this.a = bundle;
    }

    public final Map<String, String> i1() {
        if (this.f9269b == null) {
            Bundle bundle = this.a;
            c.e.a aVar = new c.e.a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals(ApiConstants.FROM) && !str.equals("message_type") && !str.equals("collapse_key")) {
                        aVar.put(str, str2);
                    }
                }
            }
            this.f9269b = aVar;
        }
        return this.f9269b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}