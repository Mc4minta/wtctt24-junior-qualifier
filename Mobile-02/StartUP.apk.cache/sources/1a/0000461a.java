package e.f.j.d;

import android.app.ActivityManager;
import android.os.Build;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.concurrent.TimeUnit;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: DefaultBitmapMemoryCacheParamsSupplier.java */
/* loaded from: classes2.dex */
public class i implements e.f.d.c.l<q> {
    private static final long a = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: b  reason: collision with root package name */
    private final ActivityManager f12456b;

    public i(ActivityManager activityManager) {
        this.f12456b = activityManager;
    }

    private int b() {
        int min = Math.min(this.f12456b.getMemoryClass() * PKIFailureInfo.badCertTemplate, (int) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return 6291456;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return min / 4;
    }

    @Override // e.f.d.c.l
    /* renamed from: a */
    public q get() {
        return new q(b(), 256, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, a);
    }
}