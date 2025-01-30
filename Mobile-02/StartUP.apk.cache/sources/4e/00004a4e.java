package e.j.l.r;

import android.graphics.Bitmap;
import kotlin.jvm.internal.m;

/* compiled from: Identicon.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final Bitmap a(String address) {
        m.g(address, "address");
        return new b(address).l();
    }
}