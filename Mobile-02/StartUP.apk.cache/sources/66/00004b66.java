package f.c;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: DaggerCollections.java */
/* loaded from: classes2.dex */
public final class b {
    private static int a(int i2) {
        return i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((i2 / 0.75f) + 1.0f) : RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> b(int i2) {
        return new HashSet<>(a(i2));
    }

    public static <K, V> LinkedHashMap<K, V> c(int i2) {
        return new LinkedHashMap<>(a(i2));
    }

    public static <T> List<T> d(int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i2);
    }
}