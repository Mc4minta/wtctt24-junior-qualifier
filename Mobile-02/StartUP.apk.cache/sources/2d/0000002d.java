package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.e;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: MediaControllerCompat.java */
/* loaded from: classes.dex */
public abstract class c implements IBinder.DeathRecipient {
    final Object a;

    /* renamed from: b  reason: collision with root package name */
    a f391b;

    /* renamed from: c  reason: collision with root package name */
    android.support.v4.media.session.a f392c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaControllerCompat.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
    }

    /* compiled from: MediaControllerCompat.java */
    /* loaded from: classes.dex */
    private static class b implements e.a {
        private final WeakReference<c> a;

        b(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.e.a
        public void a(Object obj) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.c(MediaMetadataCompat.a(obj));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void b(int i2, int i3, int i4, int i5, int i6) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.a(new d(i2, i3, i4, i5, i6));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void c(Object obj) {
            c cVar = this.a.get();
            if (cVar == null || cVar.f392c != null) {
                return;
            }
            cVar.d(PlaybackStateCompat.a(obj));
        }

        @Override // android.support.v4.media.session.e.a
        public void d(Bundle bundle) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.b(bundle);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void e(List<?> list) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.e(MediaSessionCompat.QueueItem.b(list));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void f(String str, Bundle bundle) {
            c cVar = this.a.get();
            if (cVar != null) {
                if (cVar.f392c == null || Build.VERSION.SDK_INT >= 23) {
                    cVar.h(str, bundle);
                }
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void k(CharSequence charSequence) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.f(charSequence);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void l() {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaControllerCompat.java */
    /* renamed from: android.support.v4.media.session.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class BinderC0004c extends a.AbstractBinderC0002a {
        private final WeakReference<c> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BinderC0004c(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.a
        public void J() throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(13, null, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void S(boolean z) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(11, Boolean.valueOf(z), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void U0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(2, playbackStateCompat, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void V0(String str, Bundle bundle) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(1, str, bundle);
            }
        }

        public void X0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.a, parcelableVolumeInfo.f373b, parcelableVolumeInfo.f374c, parcelableVolumeInfo.f375d, parcelableVolumeInfo.f376e) : null, null);
            }
        }

        public void d(Bundle bundle) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(7, bundle, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void d0(boolean z) throws RemoteException {
        }

        public void e(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(5, list, null);
            }
        }

        public void i0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(3, mediaMetadataCompat, null);
            }
        }

        public void k(CharSequence charSequence) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(6, charSequence, null);
            }
        }

        public void l() throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void q0(int i2) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(9, Integer.valueOf(i2), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void w0(int i2) throws RemoteException {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(12, Integer.valueOf(i2), null);
            }
        }
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a = e.a(new b(this));
            return;
        }
        BinderC0004c binderC0004c = new BinderC0004c(this);
        this.f392c = binderC0004c;
        this.a = binderC0004c;
    }

    public void a(d dVar) {
    }

    public void b(Bundle bundle) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        i(8, null, null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i2, Object obj, Bundle bundle) {
        if (this.f391b != null) {
            throw null;
        }
    }
}