package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class q implements Closeable {
    private final URL a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.android.gms.tasks.g<Bitmap> f9277b;

    /* renamed from: c  reason: collision with root package name */
    private volatile InputStream f9278c;

    private q(URL url) {
        this.a = url;
    }

    public static q b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new q(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    private final byte[] e() throws IOException {
        URLConnection openConnection = this.a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.f9278c = inputStream;
                byte[] b2 = e.g.a.e.d.f.i.b(e.g.a.e.d.f.i.a(inputStream, 1048577L));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    int length = b2.length;
                    String valueOf = String.valueOf(this.a);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                    sb.append("Downloaded ");
                    sb.append(length);
                    sb.append(" bytes from ");
                    sb.append(valueOf);
                    Log.v("FirebaseMessaging", sb.toString());
                }
                if (b2.length <= 1048576) {
                    return b2;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        e.g.a.e.d.f.l.b(th, th2);
                    }
                }
                throw th;
            }
        }
        throw new IOException("Content-Length exceeds max size of 1048576");
    }

    public final com.google.android.gms.tasks.g<Bitmap> a() {
        return (com.google.android.gms.tasks.g) com.google.android.gms.common.internal.t.k(this.f9277b);
    }

    public final void c(Executor executor) {
        this.f9277b = com.google.android.gms.tasks.j.c(executor, new Callable(this) { // from class: com.google.firebase.messaging.s
            private final q a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.d();
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            e.g.a.e.d.f.j.a(this.f9278c);
        } catch (NullPointerException e2) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e2);
        }
    }

    public final Bitmap d() throws IOException {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] e2 = e();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(e2, 0, e2.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.a);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                Log.d("FirebaseMessaging", sb2.toString());
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.a);
        StringBuilder sb3 = new StringBuilder(valueOf3.length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }
}