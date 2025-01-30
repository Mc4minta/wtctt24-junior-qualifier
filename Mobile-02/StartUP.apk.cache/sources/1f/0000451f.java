package e.c.a.a;

import android.os.Bundle;

/* compiled from: ReferrerDetails.java */
/* loaded from: classes.dex */
public class d {
    private final Bundle a;

    public d(Bundle bundle) {
        this.a = bundle;
    }

    public boolean a() {
        return this.a.getBoolean("google_play_instant");
    }

    public long b() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }

    public String c() {
        return this.a.getString("install_referrer");
    }

    public long d() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }
}