package e.f.j.l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: LocalVideoThumbnailProducer.java */
/* loaded from: classes2.dex */
public class c0 implements j0<com.facebook.common.references.a<e.f.j.i.b>> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f12585b;

    /* compiled from: LocalVideoThumbnailProducer.java */
    /* loaded from: classes2.dex */
    class a extends q0<com.facebook.common.references.a<e.f.j.i.b>> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ m0 f12586f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f12587g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.facebook.imagepipeline.request.b f12588h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, m0 m0Var, String str, String str2, m0 m0Var2, String str3, com.facebook.imagepipeline.request.b bVar) {
            super(kVar, m0Var, str, str2);
            this.f12586f = m0Var2;
            this.f12587g = str3;
            this.f12588h = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0, e.f.d.b.d
        public void e(Exception exc) {
            super.e(exc);
            this.f12586f.e(this.f12587g, "VideoThumbnailProducer", false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.d.b.d
        /* renamed from: j */
        public void b(com.facebook.common.references.a<e.f.j.i.b> aVar) {
            com.facebook.common.references.a.f(aVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0
        /* renamed from: k */
        public Map<String, String> i(com.facebook.common.references.a<e.f.j.i.b> aVar) {
            return e.f.d.c.f.of("createdThumbnail", String.valueOf(aVar != null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.d.b.d
        /* renamed from: l */
        public com.facebook.common.references.a<e.f.j.i.b> c() throws Exception {
            String str;
            try {
                str = c0.this.i(this.f12588h);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            Bitmap createVideoThumbnail = str != null ? ThumbnailUtils.createVideoThumbnail(str, c0.g(this.f12588h)) : c0.h(c0.this.f12585b, this.f12588h.q());
            if (createVideoThumbnail == null) {
                return null;
            }
            return com.facebook.common.references.a.K(new e.f.j.i.c(createVideoThumbnail, e.f.j.c.h.a(), e.f.j.i.f.a, 0));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0, e.f.d.b.d
        /* renamed from: m */
        public void f(com.facebook.common.references.a<e.f.j.i.b> aVar) {
            super.f(aVar);
            this.f12586f.e(this.f12587g, "VideoThumbnailProducer", aVar != null);
        }
    }

    /* compiled from: LocalVideoThumbnailProducer.java */
    /* loaded from: classes2.dex */
    class b extends e {
        final /* synthetic */ q0 a;

        b(q0 q0Var) {
            this.a = q0Var;
        }

        @Override // e.f.j.l.l0
        public void a() {
            this.a.a();
        }
    }

    public c0(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f12585b = contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(com.facebook.imagepipeline.request.b bVar) {
        return (bVar.i() > 96 || bVar.h() > 96) ? 1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap h(ContentResolver contentResolver, Uri uri) {
        if (Build.VERSION.SDK_INT >= 10) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
                return mediaMetadataRetriever.getFrameAtTime(-1L);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(com.facebook.imagepipeline.request.b bVar) {
        Uri uri;
        String str;
        String[] strArr;
        Uri q = bVar.q();
        if (com.facebook.common.util.e.i(q)) {
            return bVar.p().getPath();
        }
        if (com.facebook.common.util.e.h(q)) {
            if (Build.VERSION.SDK_INT < 19 || !"com.android.providers.media.documents".equals(q.getAuthority())) {
                uri = q;
                str = null;
                strArr = null;
            } else {
                String documentId = DocumentsContract.getDocumentId(q);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(":")[1]};
            }
            Cursor query = this.f12585b.query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (query != null) {
            }
        }
        return null;
    }

    @Override // e.f.j.l.j0
    public void b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var) {
        m0 f2 = k0Var.f();
        String id = k0Var.getId();
        a aVar = new a(kVar, f2, "VideoThumbnailProducer", id, f2, id, k0Var.c());
        k0Var.d(new b(aVar));
        this.a.execute(aVar);
    }
}