package androidx.core.os;

import android.os.Parcel;

/* compiled from: ParcelableCompatCreatorCallbacks.java */
@Deprecated
/* loaded from: classes.dex */
public interface e<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i2);
}