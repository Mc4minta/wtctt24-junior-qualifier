package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21 {
    final Object a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f366b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<c, a> f367c;

    /* renamed from: d  reason: collision with root package name */
    final MediaSessionCompat.Token f368d;

    /* loaded from: classes.dex */
    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> a;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i2, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.a.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.a) {
                mediaControllerCompat$MediaControllerImplApi21.f368d.b(b.a.n(androidx.core.app.e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f368d.c(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends c.BinderC0004c {
        a(c cVar) {
            super(cVar);
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void X0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void d(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void e(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void i0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void k(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void l() throws RemoteException {
            throw new AssertionError();
        }
    }

    void a() {
        if (this.f368d.a() == null) {
            return;
        }
        for (c cVar : this.f366b) {
            a aVar = new a(cVar);
            this.f367c.put(cVar, aVar);
            cVar.f392c = aVar;
            try {
                this.f368d.a().t(aVar);
                cVar.i(13, null, null);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
            }
        }
        this.f366b.clear();
    }
}