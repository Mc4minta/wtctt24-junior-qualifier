package e.f.j.d;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.concurrent.TimeUnit;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: DefaultEncodedMemoryCacheParamsSupplier.java */
/* loaded from: classes2.dex */
public class k implements e.f.d.c.l<q> {
    private static final long a = TimeUnit.MINUTES.toMillis(5);

    private int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return PKIFailureInfo.badCertTemplate;
        }
        if (min < 33554432) {
            return PKIFailureInfo.badSenderNonce;
        }
        return 4194304;
    }

    @Override // e.f.d.c.l
    /* renamed from: a */
    public q get() {
        int b2 = b();
        return new q(b2, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, b2, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, b2 / 8, a);
    }
}