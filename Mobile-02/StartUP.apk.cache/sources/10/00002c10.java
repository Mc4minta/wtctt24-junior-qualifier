package com.dieam.reactnativepushnotification.modules;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.b;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RNPushNotificationPicturesAggregator.java */
/* loaded from: classes2.dex */
public class f {
    private AtomicInteger a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f4480b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f4481c;

    /* renamed from: d  reason: collision with root package name */
    private c f4482d;

    /* compiled from: RNPushNotificationPicturesAggregator.java */
    /* loaded from: classes2.dex */
    class a extends e.f.j.f.b {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // e.f.e.b
        public void e(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            this.a.c(null);
        }

        @Override // e.f.j.f.b
        public void g(Bitmap bitmap) {
            this.a.c(bitmap);
        }
    }

    /* compiled from: RNPushNotificationPicturesAggregator.java */
    /* loaded from: classes2.dex */
    class b extends e.f.j.f.b {
        final /* synthetic */ f a;

        b(f fVar) {
            this.a = fVar;
        }

        @Override // e.f.e.b
        public void e(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            this.a.e(null);
        }

        @Override // e.f.j.f.b
        public void g(Bitmap bitmap) {
            this.a.e(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNPushNotificationPicturesAggregator.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(Bitmap bitmap, Bitmap bitmap2);
    }

    public f(c cVar) {
        this.f4482d = cVar;
    }

    private void a(Context context, Uri uri, e.f.j.f.b bVar) {
        com.facebook.imagepipeline.request.b a2 = ImageRequestBuilder.r(uri).B(com.facebook.imagepipeline.common.d.HIGH).x(b.EnumC0109b.FULL_FETCH).a();
        if (!e.f.h.a.a.c.c()) {
            e.f.h.a.a.c.d(context);
        }
        e.f.h.a.a.c.a().d(a2, context).g(bVar, e.f.d.b.a.a());
    }

    private void b() {
        c cVar;
        synchronized (this.a) {
            if (this.a.incrementAndGet() >= 2 && (cVar = this.f4482d) != null) {
                cVar.a(this.f4480b, this.f4481c);
            }
        }
    }

    public void c(Bitmap bitmap) {
        this.f4481c = bitmap;
        b();
    }

    public void d(Context context, String str) {
        if (str == null) {
            c(null);
            return;
        }
        try {
            a(context, Uri.parse(str), new a(this));
        } catch (Exception e2) {
            Log.e(RNPushNotification.LOG_TAG, "Failed to parse bigPictureUrl", e2);
            c(null);
        }
    }

    public void e(Bitmap bitmap) {
        this.f4480b = bitmap;
        b();
    }

    public void f(Context context, String str) {
        if (str == null) {
            e(null);
            return;
        }
        try {
            a(context, Uri.parse(str), new b(this));
        } catch (Exception e2) {
            Log.e(RNPushNotification.LOG_TAG, "Failed to parse largeIconUrl", e2);
            e(null);
        }
    }
}