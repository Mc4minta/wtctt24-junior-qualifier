package com.facebook.react.views.image;

import android.graphics.Shader;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import e.f.h.e.q;

/* compiled from: ImageResizeMode.java */
/* loaded from: classes2.dex */
public class d {
    public static Shader.TileMode a() {
        return Shader.TileMode.CLAMP;
    }

    public static q.b b() {
        return q.b.f12318g;
    }

    public static q.b c(String str) {
        if ("contain".equals(str)) {
            return q.b.f12314c;
        }
        if ("cover".equals(str)) {
            return q.b.f12318g;
        }
        if ("stretch".equals(str)) {
            return q.b.a;
        }
        if ("center".equals(str)) {
            return q.b.f12317f;
        }
        if ("repeat".equals(str)) {
            return h.f5317j;
        }
        if (str == null) {
            return b();
        }
        throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + str + "'");
    }

    public static Shader.TileMode d(String str) {
        if (!"contain".equals(str) && !"cover".equals(str) && !"stretch".equals(str) && !"center".equals(str)) {
            if ("repeat".equals(str)) {
                return Shader.TileMode.REPEAT;
            }
            if (str == null) {
                return a();
            }
            throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + str + "'");
        }
        return Shader.TileMode.CLAMP;
    }
}