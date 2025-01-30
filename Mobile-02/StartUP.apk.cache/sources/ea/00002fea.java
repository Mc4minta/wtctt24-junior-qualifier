package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextLayoutManager.java */
/* loaded from: classes2.dex */
public class b0 {
    private static final TextPaint a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5406b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static LruCache<String, Spannable> f5407c = new LruCache<>(100);

    /* compiled from: TextLayoutManager.java */
    /* loaded from: classes2.dex */
    public static class a {
        protected int a;

        /* renamed from: b  reason: collision with root package name */
        protected int f5408b;

        /* renamed from: c  reason: collision with root package name */
        protected l f5409c;

        a(int i2, int i3, l lVar) {
            this.a = i2;
            this.f5408b = i3;
            this.f5409c = lVar;
        }

        public void a(SpannableStringBuilder spannableStringBuilder, int i2) {
            int i3 = this.a;
            spannableStringBuilder.setSpan(this.f5409c, i3, this.f5408b, ((i2 << 16) & 16711680) | ((i3 == 0 ? 18 : 34) & (-16711681)));
        }
    }

    private static void a(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<a> list) {
        int i2;
        int i3 = 0;
        for (int size = readableArray.size(); i3 < size; size = i2) {
            ReadableMap map = readableArray.getMap(i3);
            int length = spannableStringBuilder.length();
            x xVar = new x(new com.facebook.react.uimanager.a0(map.getMap("textAttributes")));
            spannableStringBuilder.append((CharSequence) c0.h(map.getString("string"), xVar.o));
            int length2 = spannableStringBuilder.length();
            int i4 = map.getInt("reactTag");
            if (map.hasKey("isAttachment") && map.getBoolean("isAttachment")) {
                list.add(new a(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new a0(i4, (int) com.facebook.react.uimanager.o.d(map.getDouble("width")), (int) com.facebook.react.uimanager.o.d(map.getDouble("height")))));
            } else if (length2 >= length) {
                if (xVar.f5458d) {
                    list.add(new a(length, length2, new j(xVar.f5460f)));
                }
                if (xVar.f5461g) {
                    list.add(new a(length, length2, new g(xVar.f5462h)));
                }
                if (Build.VERSION.SDK_INT >= 21 && !Float.isNaN(xVar.g())) {
                    list.add(new a(length, length2, new com.facebook.react.views.text.a(xVar.g())));
                }
                list.add(new a(length, length2, new f(xVar.f5464j)));
                if (xVar.w == -1 && xVar.x == -1 && xVar.y == null) {
                    i2 = size;
                } else {
                    i2 = size;
                    list.add(new a(length, length2, new c(xVar.w, xVar.x, xVar.z, xVar.y, context.getAssets())));
                }
                if (xVar.t) {
                    list.add(new a(length, length2, new u()));
                }
                if (xVar.u) {
                    list.add(new a(length, length2, new m()));
                }
                if (xVar.p != 0.0f || xVar.q != 0.0f) {
                    list.add(new a(length, length2, new w(xVar.p, xVar.q, xVar.r, xVar.s)));
                }
                if (!Float.isNaN(xVar.c())) {
                    list.add(new a(length, length2, new b(xVar.c())));
                }
                list.add(new a(length, length2, new n(i4)));
                i3++;
            }
            i2 = size;
            i3++;
        }
    }

    private static Spannable b(Context context, ReadableMap readableMap, s sVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<a> arrayList = new ArrayList();
        a(context, readableMap.getArray("fragments"), spannableStringBuilder, arrayList);
        int i2 = 0;
        for (a aVar : arrayList) {
            aVar.a(spannableStringBuilder, i2);
            i2++;
        }
        if (sVar != null) {
            sVar.a(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public static Spannable c(Context context, ReadableMap readableMap, s sVar) {
        String obj = readableMap.toString();
        Object obj2 = f5406b;
        synchronized (obj2) {
            Spannable spannable = f5407c.get(obj);
            if (spannable != null) {
                return spannable;
            }
            Spannable b2 = b(context, readableMap, sVar);
            synchronized (obj2) {
                f5407c.put(obj, b2);
            }
            return b2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x018c, code lost:
        if (r11 != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long d(android.content.Context r18, com.facebook.react.bridge.ReadableMap r19, com.facebook.react.bridge.ReadableMap r20, float r21, com.facebook.yoga.n r22, float r23, com.facebook.yoga.n r24, com.facebook.react.views.text.s r25, int[] r26) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.b0.d(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, float, com.facebook.yoga.n, float, com.facebook.yoga.n, com.facebook.react.views.text.s, int[]):long");
    }
}