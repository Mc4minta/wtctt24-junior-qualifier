package e.g.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.util.Size;
import e.g.a.b.f;

/* compiled from: Camera2Api23.java */
@TargetApi(23)
/* loaded from: classes2.dex */
class d extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f.a aVar, i iVar, Context context, Handler handler) {
        super(aVar, iVar, context, handler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.g.a.b.c
    public void b0(k kVar, StreamConfigurationMap streamConfigurationMap) {
        Size[] highResolutionOutputSizes;
        if (streamConfigurationMap.getHighResolutionOutputSizes(256) != null) {
            for (Size size : streamConfigurationMap.getHighResolutionOutputSizes(256)) {
                kVar.a(new j(size.getWidth(), size.getHeight()));
            }
        }
        if (kVar.c()) {
            super.b0(kVar, streamConfigurationMap);
        }
    }
}