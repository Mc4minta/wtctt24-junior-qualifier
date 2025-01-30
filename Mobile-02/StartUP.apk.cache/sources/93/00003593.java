package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u1 {
    private static final c.e.a<String, Uri> a = new c.e.a<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (u1.class) {
            c.e.a<String, Uri> aVar = a;
            uri = aVar.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                aVar.put(str, uri);
            }
        }
        return uri;
    }
}