package e.j.f;

import android.content.Intent;
import android.net.Uri;

/* compiled from: Globals.kt */
/* loaded from: classes2.dex */
public final class n {
    private static final Intent a = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=org.toshi"));

    public static final Intent a() {
        return a;
    }
}