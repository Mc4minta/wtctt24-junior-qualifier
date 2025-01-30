package com.google.zxing.p.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import java.io.IOException;

/* compiled from: BeepManager.java */
/* loaded from: classes2.dex */
public final class b {
    private static final String a = "b";

    /* renamed from: b  reason: collision with root package name */
    private final Context f9883b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9884c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9885d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BeepManager.java */
    /* loaded from: classes2.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BeepManager.java */
    /* renamed from: com.google.zxing.p.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0209b implements MediaPlayer.OnErrorListener {
        C0209b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            String str = b.a;
            Log.w(str, "Failed to beep " + i2 + ", " + i3);
            mediaPlayer.stop();
            mediaPlayer.release();
            return true;
        }
    }

    public b(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f9883b = activity.getApplicationContext();
    }

    public MediaPlayer b() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new a());
        mediaPlayer.setOnErrorListener(new C0209b());
        try {
            AssetFileDescriptor openRawResourceFd = this.f9883b.getResources().openRawResourceFd(i.zxing_beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            mediaPlayer.start();
            return mediaPlayer;
        } catch (IOException e2) {
            Log.w(a, e2);
            mediaPlayer.release();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void c() {
        Vibrator vibrator;
        if (this.f9884c) {
            b();
        }
        if (this.f9885d && (vibrator = (Vibrator) this.f9883b.getSystemService("vibrator")) != null) {
            vibrator.vibrate(200L);
        }
    }

    public void d(boolean z) {
        this.f9884c = z;
    }
}