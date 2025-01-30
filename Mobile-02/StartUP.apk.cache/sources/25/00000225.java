package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = (IconCompat) versionedParcel.v(remoteActionCompat.a, 1);
        remoteActionCompat.f1381b = versionedParcel.l(remoteActionCompat.f1381b, 2);
        remoteActionCompat.f1382c = versionedParcel.l(remoteActionCompat.f1382c, 3);
        remoteActionCompat.f1383d = (PendingIntent) versionedParcel.r(remoteActionCompat.f1383d, 4);
        remoteActionCompat.f1384e = versionedParcel.h(remoteActionCompat.f1384e, 5);
        remoteActionCompat.f1385f = versionedParcel.h(remoteActionCompat.f1385f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.a, 1);
        versionedParcel.D(remoteActionCompat.f1381b, 2);
        versionedParcel.D(remoteActionCompat.f1382c, 3);
        versionedParcel.H(remoteActionCompat.f1383d, 4);
        versionedParcel.z(remoteActionCompat.f1384e, 5);
        versionedParcel.z(remoteActionCompat.f1385f, 6);
    }
}