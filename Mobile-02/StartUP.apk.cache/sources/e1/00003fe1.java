package com.swmansion.reanimated.f;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import c.s.c0;
import c.s.e;
import c.s.f;
import c.s.w;
import c.s.w0;
import c.s.y;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: TransitionUtils.java */
/* loaded from: classes2.dex */
class d {
    private static void a(y yVar, ReadableMap readableMap) {
        if (readableMap.hasKey("durationMs")) {
            yVar.setDuration(readableMap.getInt("durationMs"));
        }
        if (readableMap.hasKey("interpolation")) {
            String string = readableMap.getString("interpolation");
            if (string.equals("easeIn")) {
                yVar.setInterpolator(new AccelerateInterpolator());
            } else if (string.equals("easeOut")) {
                yVar.setInterpolator(new DecelerateInterpolator());
            } else if (string.equals("easeInOut")) {
                yVar.setInterpolator(new AccelerateDecelerateInterpolator());
            } else if (string.equals("linear")) {
                yVar.setInterpolator(new LinearInterpolator());
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid interpolation type " + string);
            }
        }
        if (readableMap.hasKey("propagation")) {
            String string2 = readableMap.getString("propagation");
            a aVar = new a();
            if ("top".equals(string2)) {
                aVar.j(80);
            } else if ("bottom".equals(string2)) {
                aVar.j(48);
            } else if ("left".equals(string2)) {
                aVar.j(5);
            } else if ("right".equals(string2)) {
                aVar.j(3);
            }
            yVar.setPropagation(aVar);
        } else {
            yVar.setPropagation(null);
        }
        if (readableMap.hasKey("delayMs")) {
            yVar.setStartDelay(readableMap.getInt("delayMs"));
        }
    }

    private static w0 b(String str) {
        if (str == null || "none".equals(str)) {
            return null;
        }
        if ("fade".equals(str)) {
            return new f(3);
        }
        if ("scale".equals(str)) {
            return new b();
        }
        if ("slide-top".equals(str)) {
            return new w(48);
        }
        if ("slide-bottom".equals(str)) {
            return new w(80);
        }
        if ("slide-right".equals(str)) {
            return new w(5);
        }
        if ("slide-left".equals(str)) {
            return new w(3);
        }
        throw new JSApplicationIllegalArgumentException("Invalid transition type " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y c(ReadableMap readableMap) {
        String string = readableMap.getString("type");
        if ("group".equals(string)) {
            return e(readableMap);
        }
        if ("in".equals(string)) {
            return f(readableMap);
        }
        if ("out".equals(string)) {
            return g(readableMap);
        }
        if ("change".equals(string)) {
            return d(readableMap);
        }
        throw new JSApplicationIllegalArgumentException("Unrecognized transition type " + string);
    }

    private static y d(ReadableMap readableMap) {
        c.s.d dVar = new c.s.d();
        e eVar = new e();
        a(dVar, readableMap);
        a(eVar, readableMap);
        return new c0().h(dVar).h(eVar);
    }

    private static y e(ReadableMap readableMap) {
        c0 c0Var = new c0();
        if (readableMap.hasKey("sequence") && readableMap.getBoolean("sequence")) {
            c0Var.u(1);
        } else {
            c0Var.u(0);
        }
        ReadableArray array = readableMap.getArray("transitions");
        int size = array.size();
        for (int i2 = 0; i2 < size; i2++) {
            y c2 = c(array.getMap(i2));
            if (c2 != null) {
                c0Var.h(c2);
            }
        }
        return c0Var;
    }

    private static y f(ReadableMap readableMap) {
        w0 b2 = b(readableMap.getString("animation"));
        if (b2 == null) {
            return null;
        }
        b2.h(1);
        a(b2, readableMap);
        return b2;
    }

    private static y g(ReadableMap readableMap) {
        w0 b2 = b(readableMap.getString("animation"));
        if (b2 == null) {
            return null;
        }
        b2.h(2);
        a(b2, readableMap);
        return b2;
    }
}