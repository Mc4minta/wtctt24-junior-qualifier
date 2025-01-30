package e.g.a.e.e;

import android.net.Uri;
import com.google.android.gms.common.api.a;

/* loaded from: classes2.dex */
public final class b {
    private static final a.g<e.g.a.e.d.g.e> a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.AbstractC0138a<e.g.a.e.d.g.e, ?> f13170b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.android.gms.common.api.a<?> f13171c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private static final i f13172d;

    /* JADX WARN: Type inference failed for: r0v1, types: [e.g.a.e.e.i, e.g.a.e.d.g.d] */
    static {
        a.g<e.g.a.e.d.g.e> gVar = new a.g<>();
        a = gVar;
        h hVar = new h();
        f13170b = hVar;
        f13171c = new com.google.android.gms.common.api.a<>("Phenotype.API", hVar, gVar);
        f13172d = new e.g.a.e.d.g.d();
    }

    public static Uri a(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}