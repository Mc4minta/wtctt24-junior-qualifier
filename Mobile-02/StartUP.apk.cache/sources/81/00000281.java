package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelableCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class d {

    /* compiled from: ParcelableCompat.java */
    /* loaded from: classes.dex */
    static class a<T> implements Parcelable.ClassLoaderCreator<T> {
        private final e<T> a;

        a(e<T> eVar) {
            this.a = eVar;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.a.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i2) {
            return this.a.newArray(i2);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.a.createFromParcel(parcel, classLoader);
        }
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> a(e<T> eVar) {
        return new a(eVar);
    }
}