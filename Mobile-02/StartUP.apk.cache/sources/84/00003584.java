package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t1 {
    private final Map<String, Map<String, String>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(Map<String, Map<String, String>> map) {
        this.a = map;
    }

    public final String a(Uri uri, String str, String str2, String str3) {
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map<String, String> map = this.a.get(str);
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str3);
            str3 = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        return map.get(str3);
    }
}