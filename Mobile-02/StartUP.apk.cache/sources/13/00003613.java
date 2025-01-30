package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.appsflyer.internal.referrer.Payload;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class ba {
    private final b5 a;

    public ba(b5 b5Var) {
        this.a = b5Var;
    }

    private final boolean d() {
        return e() && this.a.i().a() - this.a.B().D.a() > this.a.y().r(null, r.U0);
    }

    private final boolean e() {
        return this.a.B().D.a() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.a.l().d();
        if (e()) {
            if (d()) {
                this.a.B().C.b(null);
                Bundle bundle = new Bundle();
                bundle.putString(Payload.SOURCE, "(not set)");
                bundle.putString(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.a.G().S("auto", "_cmpx", bundle);
            } else {
                String a = this.a.B().C.a();
                if (TextUtils.isEmpty(a)) {
                    this.a.f().I().a("Cache still valid but referrer not found");
                } else {
                    long a2 = ((this.a.B().D.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", a2);
                    this.a.G().S((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.a.B().C.b(null);
            }
            this.a.B().D.b(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, Bundle bundle) {
        String str2;
        this.a.l().d();
        if (this.a.q()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            str2 = null;
        } else {
            str = (str == null || str.isEmpty()) ? "auto" : "auto";
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str3 : bundle.keySet()) {
                builder.appendQueryParameter(str3, bundle.getString(str3));
            }
            str2 = builder.build().toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.a.B().C.b(str2);
        this.a.B().D.b(this.a.i().a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (e() && d()) {
            this.a.B().C.b(null);
        }
    }
}