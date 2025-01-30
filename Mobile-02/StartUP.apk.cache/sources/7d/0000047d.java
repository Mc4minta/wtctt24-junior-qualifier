package b.a.b.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.b.a.a;

/* compiled from: ResultReceiver.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    final boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f2389b = null;

    /* renamed from: c  reason: collision with root package name */
    b.a.b.a.a f2390c;

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: b.a.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class BinderC0050b extends a.AbstractBinderC0048a {
        BinderC0050b() {
        }

        @Override // b.a.b.a.a
        public void W0(int i2, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f2389b;
            if (handler != null) {
                handler.post(new c(i2, bundle));
            } else {
                bVar.a(i2, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f2391b;

        c(int i2, Bundle bundle) {
            this.a = i2;
            this.f2391b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.a, this.f2391b);
        }
    }

    b(Parcel parcel) {
        this.f2390c = a.AbstractBinderC0048a.n(parcel.readStrongBinder());
    }

    protected void a(int i2, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f2390c == null) {
                this.f2390c = new BinderC0050b();
            }
            parcel.writeStrongBinder(this.f2390c.asBinder());
        }
    }
}