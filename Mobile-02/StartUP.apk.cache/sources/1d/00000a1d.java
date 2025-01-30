package com.caverock.androidsvg;

import android.graphics.Canvas;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
class CanvasLegacy {
    static final int MATRIX_SAVE_FLAG;
    private static final Method SAVE;

    static {
        try {
            MATRIX_SAVE_FLAG = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            SAVE = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    CanvasLegacy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void save(Canvas canvas, int i2) {
        try {
            SAVE.invoke(canvas, Integer.valueOf(i2));
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    private static RuntimeException sneakyThrow(Throwable th) {
        Objects.requireNonNull(th, "t");
        return (RuntimeException) sneakyThrow0(th);
    }

    private static <T extends Throwable> T sneakyThrow0(Throwable th) throws Throwable {
        throw th;
    }
}