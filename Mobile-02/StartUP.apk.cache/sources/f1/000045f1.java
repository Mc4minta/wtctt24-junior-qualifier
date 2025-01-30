package e.f.i;

/* compiled from: DefaultImageFormats.java */
/* loaded from: classes2.dex */
public final class b {
    public static final c a = new c("JPEG", "jpeg");

    /* renamed from: b  reason: collision with root package name */
    public static final c f12388b = new c("PNG", "png");

    /* renamed from: c  reason: collision with root package name */
    public static final c f12389c = new c("GIF", "gif");

    /* renamed from: d  reason: collision with root package name */
    public static final c f12390d = new c("BMP", "bmp");

    /* renamed from: e  reason: collision with root package name */
    public static final c f12391e = new c("ICO", "ico");

    /* renamed from: f  reason: collision with root package name */
    public static final c f12392f = new c("WEBP_SIMPLE", "webp");

    /* renamed from: g  reason: collision with root package name */
    public static final c f12393g = new c("WEBP_LOSSLESS", "webp");

    /* renamed from: h  reason: collision with root package name */
    public static final c f12394h = new c("WEBP_EXTENDED", "webp");

    /* renamed from: i  reason: collision with root package name */
    public static final c f12395i = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");

    /* renamed from: j  reason: collision with root package name */
    public static final c f12396j = new c("WEBP_ANIMATED", "webp");

    /* renamed from: k  reason: collision with root package name */
    public static final c f12397k = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return cVar == f12392f || cVar == f12393g || cVar == f12394h || cVar == f12395i;
    }

    public static boolean b(c cVar) {
        return a(cVar) || cVar == f12396j;
    }
}