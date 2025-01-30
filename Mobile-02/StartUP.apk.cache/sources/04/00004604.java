package e.f.j.c;

import android.os.Build;
import com.facebook.imagepipeline.memory.d0;

/* compiled from: PlatformBitmapFactoryProvider.java */
/* loaded from: classes2.dex */
public class g {
    public static f a(d0 d0Var, com.facebook.imagepipeline.platform.f fVar, e.f.j.e.a aVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            return new a(d0Var.a(), aVar);
        }
        if (i2 >= 11) {
            return new e(new b(d0Var.g()), fVar, aVar);
        }
        return new c();
    }
}