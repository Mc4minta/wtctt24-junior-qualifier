package e.g.a.e.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class c extends com.google.android.gms.common.internal.safeparcel.a implements com.google.android.gms.common.api.i {
    public static final Parcelable.Creator<c> CREATOR = new b();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private int f13201b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f13202c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i2, int i3, Intent intent) {
        this.a = i2;
        this.f13201b = i3;
        this.f13202c = intent;
    }

    @Override // com.google.android.gms.common.api.i
    public final Status getStatus() {
        if (this.f13201b == 0) {
            return Status.a;
        }
        return Status.f6036e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 2, this.f13201b);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, this.f13202c, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public c() {
        this(0, null);
    }

    private c(int i2, Intent intent) {
        this(2, 0, null);
    }
}