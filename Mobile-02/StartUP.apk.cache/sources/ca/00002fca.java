package com.facebook.react.views.scroll;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.o;
import java.util.Map;

/* compiled from: ReactScrollViewCommandHelper.java */
/* loaded from: classes2.dex */
public class f {

    /* compiled from: ReactScrollViewCommandHelper.java */
    /* loaded from: classes2.dex */
    public interface a<T> {
        void flashScrollIndicators(T t);

        void scrollTo(T t, b bVar);

        void scrollToEnd(T t, c cVar);
    }

    /* compiled from: ReactScrollViewCommandHelper.java */
    /* loaded from: classes2.dex */
    public static class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5376b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5377c;

        b(int i2, int i3, boolean z) {
            this.a = i2;
            this.f5376b = i3;
            this.f5377c = z;
        }
    }

    /* compiled from: ReactScrollViewCommandHelper.java */
    /* loaded from: classes2.dex */
    public static class c {
        public final boolean a;

        c(boolean z) {
            this.a = z;
        }
    }

    public static Map<String, Integer> a() {
        return com.facebook.react.common.c.f("scrollTo", 1, "scrollToEnd", 2, "flashScrollIndicators", 3);
    }

    public static <T> void b(a<T> aVar, T t, int i2, ReadableArray readableArray) {
        e.f.k.a.a.c(aVar);
        e.f.k.a.a.c(t);
        e.f.k.a.a.c(readableArray);
        if (i2 == 1) {
            d(aVar, t, readableArray);
        } else if (i2 == 2) {
            e(aVar, t, readableArray);
        } else if (i2 == 3) {
            aVar.flashScrollIndicators(t);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i2), aVar.getClass().getSimpleName()));
        }
    }

    public static <T> void c(a<T> aVar, T t, String str, ReadableArray readableArray) {
        e.f.k.a.a.c(aVar);
        e.f.k.a.a.c(t);
        e.f.k.a.a.c(readableArray);
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -402165208:
                if (str.equals("scrollTo")) {
                    c2 = 0;
                    break;
                }
                break;
            case 28425985:
                if (str.equals("flashScrollIndicators")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2055114131:
                if (str.equals("scrollToEnd")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                d(aVar, t, readableArray);
                return;
            case 1:
                aVar.flashScrollIndicators(t);
                return;
            case 2:
                e(aVar, t, readableArray);
                return;
            default:
                throw new IllegalArgumentException(String.format("Unsupported command %s received by %s.", str, aVar.getClass().getSimpleName()));
        }
    }

    private static <T> void d(a<T> aVar, T t, ReadableArray readableArray) {
        aVar.scrollTo(t, new b(Math.round(o.b(readableArray.getDouble(0))), Math.round(o.b(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    private static <T> void e(a<T> aVar, T t, ReadableArray readableArray) {
        aVar.scrollToEnd(t, new c(readableArray.getBoolean(0)));
    }
}