package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

/* loaded from: classes.dex */
class MediaBrowserCompat$CustomActionResultReceiver extends b.a.b.a.b {

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f342d;

    /* renamed from: e  reason: collision with root package name */
    private final a f343e;

    @Override // b.a.b.a.b
    protected void a(int i2, Bundle bundle) {
        if (this.f343e == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i2 == -1) {
            throw null;
        }
        if (i2 == 0) {
            throw null;
        }
        if (i2 != 1) {
            Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f342d + ", resultData=" + bundle + ")");
            return;
        }
        throw null;
    }
}