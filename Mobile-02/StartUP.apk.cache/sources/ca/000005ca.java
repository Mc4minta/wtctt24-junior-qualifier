package c.j.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AbsSavedState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    private final Parcelable f3090b;
    public static final a a = new C0072a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: c.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0072a extends a {
        C0072a() {
            super((C0072a) null);
        }
    }

    /* compiled from: AbsSavedState.java */
    /* loaded from: classes.dex */
    class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.a;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(C0072a c0072a) {
        this();
    }

    public final Parcelable a() {
        return this.f3090b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f3090b, i2);
    }

    private a() {
        this.f3090b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f3090b = parcelable == a ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f3090b = readParcelable == null ? a : readParcelable;
    }
}