package e.f.j.c;

import android.graphics.Bitmap;

/* compiled from: SimpleBitmapReleaser.java */
/* loaded from: classes2.dex */
public class h implements com.facebook.common.references.c<Bitmap> {
    private static h a;

    private h() {
    }

    public static h a() {
        if (a == null) {
            a = new h();
        }
        return a;
    }

    @Override // com.facebook.common.references.c
    /* renamed from: b */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}