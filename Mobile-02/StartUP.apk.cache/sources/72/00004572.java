package e.f.d.e;

import android.webkit.MimeTypeMap;
import e.f.d.c.f;
import java.util.Map;

/* compiled from: MimeTypeMapWrapper.java */
/* loaded from: classes2.dex */
public class b {
    private static final MimeTypeMap a = MimeTypeMap.getSingleton();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, String> f12076b = f.of("image/heif", "heif", "image/heic", "heic");

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f12077c = f.of("heif", "image/heif", "heic", "image/heic");

    public static String a(String str) {
        String str2 = f12077c.get(str);
        return str2 != null ? str2 : a.getMimeTypeFromExtension(str);
    }
}