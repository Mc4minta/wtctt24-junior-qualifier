package kotlinx.coroutines.internal;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import kotlin.l0.w;

/* compiled from: SystemProps.common.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class r {
    public static final int a(String str, int i2, int i3, int i4) {
        return (int) p.c(str, i2, i3, i4);
    }

    public static final long b(String str, long j2, long j3, long j4) {
        Long s;
        String d2 = p.d(str);
        if (d2 != null) {
            s = w.s(d2);
            if (s == null) {
                throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d2 + '\'').toString());
            }
            long longValue = s.longValue();
            if (j3 > longValue || j4 < longValue) {
                throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + longValue + '\'').toString());
            }
            return longValue;
        }
        return j2;
    }

    public static final boolean c(String str, boolean z) {
        String d2 = p.d(str);
        return d2 != null ? Boolean.parseBoolean(d2) : z;
    }

    public static /* synthetic */ int d(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        return p.b(str, i2, i3, i4);
    }

    public static /* synthetic */ long e(String str, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j3 = 1;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            j4 = Long.MAX_VALUE;
        }
        return p.c(str, j2, j5, j4);
    }
}