package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.a0.z;
import kotlin.jvm.internal.m;

/* compiled from: platformUtil.kt */
/* loaded from: classes3.dex */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform targetPlatform) {
        String h0;
        m.g(targetPlatform, "<this>");
        h0 = z.h0(targetPlatform.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
        return h0;
    }
}