package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public class u0 implements Parcelable {
    public static final Parcelable.Creator<u0> CREATOR = new t0();
    private Messenger a;

    /* renamed from: b  reason: collision with root package name */
    private i1 f9184b;

    /* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
    /* loaded from: classes2.dex */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (FirebaseInstanceId.y()) {
                    Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
                    return u0.class;
                }
                return u0.class;
            }
            return super.loadClass(str, z);
        }
    }

    public u0(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a = new Messenger(iBinder);
        } else {
            this.f9184b = new h1(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.a;
        return messenger != null ? messenger.getBinder() : this.f9184b.asBinder();
    }

    public final void b(Message message) throws RemoteException {
        Messenger messenger = this.a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f9184b.H0(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((u0) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f9184b.asBinder());
        }
    }
}