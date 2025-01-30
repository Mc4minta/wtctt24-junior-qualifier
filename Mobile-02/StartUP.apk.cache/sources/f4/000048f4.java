package e.g.c.a;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: Ints.java */
/* loaded from: classes2.dex */
public final class a {
    public static int a(long j2) {
        if (j2 > 2147483647L) {
            return RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }
}