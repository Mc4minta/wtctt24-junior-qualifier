package e.g.a.e.d.f;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.reactnativecommunity.webview.RNCWebViewManager;
import okhttp3.internal.http2.Http2Connection;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class m {
    private static final byte[] a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13151b = {1, 10, 100, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13152c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13153d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e  reason: collision with root package name */
    private static int[] f13154e = {RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, 65536, 2345, 477, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int a(int i2, int i3) {
        long j2 = i2 << 1;
        if (j2 > 2147483647L) {
            return RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }
}