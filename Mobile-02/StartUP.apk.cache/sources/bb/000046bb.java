package e.f.j.l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalContentUriThumbnailFetchProducer.java */
/* loaded from: classes2.dex */
public class x extends z implements w0<e.f.j.i.d> {

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f12779c = x.class;

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f12780d = {"_id", "_data"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f12781e = {"_data"};

    /* renamed from: f  reason: collision with root package name */
    private static final Rect f12782f = new Rect(0, 0, 512, 384);

    /* renamed from: g  reason: collision with root package name */
    private static final Rect f12783g = new Rect(0, 0, 96, 96);

    /* renamed from: h  reason: collision with root package name */
    private final ContentResolver f12784h;

    public x(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.f12784h = contentResolver;
    }

    private e.f.j.i.d g(Uri uri, com.facebook.imagepipeline.common.e eVar) throws IOException {
        e.f.j.i.d j2;
        Cursor query = this.f12784h.query(uri, f12780d, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (eVar == null || (j2 = j(eVar, query.getInt(query.getColumnIndex("_id")))) == null) {
                return null;
            }
            j2.x0(i(string));
            return j2;
        } finally {
            query.close();
        }
    }

    private static int h(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    private static int i(String str) {
        if (str != null) {
            try {
                return com.facebook.imageutils.c.a(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e2) {
                e.f.d.d.a.h(f12779c, e2, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }

    private e.f.j.i.d j(com.facebook.imagepipeline.common.e eVar, int i2) throws IOException {
        int k2 = k(eVar);
        Cursor cursor = null;
        if (k2 == 0) {
            return null;
        }
        try {
            Cursor queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f12784h, i2, k2, f12781e);
            if (queryMiniThumbnail == null) {
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                return null;
            }
            try {
                queryMiniThumbnail.moveToFirst();
                if (queryMiniThumbnail.getCount() > 0) {
                    String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                    if (new File(string).exists()) {
                        e.f.j.i.d e2 = e(new FileInputStream(string), h(string));
                        queryMiniThumbnail.close();
                        return e2;
                    }
                }
                queryMiniThumbnail.close();
                return null;
            } catch (Throwable th) {
                th = th;
                cursor = queryMiniThumbnail;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int k(com.facebook.imagepipeline.common.e eVar) {
        Rect rect = f12783g;
        if (x0.b(rect.width(), rect.height(), eVar)) {
            return 3;
        }
        Rect rect2 = f12782f;
        return x0.b(rect2.width(), rect2.height(), eVar) ? 1 : 0;
    }

    @Override // e.f.j.l.w0
    public boolean a(com.facebook.imagepipeline.common.e eVar) {
        Rect rect = f12782f;
        return x0.b(rect.width(), rect.height(), eVar);
    }

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        e.f.j.i.d g2;
        Uri q = bVar.q();
        if (!com.facebook.common.util.e.f(q) || (g2 = g(q, bVar.m())) == null) {
            return null;
        }
        return g2;
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "LocalContentUriThumbnailFetchProducer";
    }
}