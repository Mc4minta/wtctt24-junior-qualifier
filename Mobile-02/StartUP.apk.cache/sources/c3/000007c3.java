package com.bugsnag.android;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* compiled from: ObjectJsonStreamer.java */
/* loaded from: classes.dex */
class u0 {
    String[] a = {"password"};

    private boolean b(String str) {
        String[] strArr = this.a;
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj, o0 o0Var) throws IOException {
        if (obj == null) {
            o0Var.n();
        } else if (obj instanceof String) {
            o0Var.d0((String) obj);
        } else if (obj instanceof Number) {
            o0Var.a0((Number) obj);
        } else if (obj instanceof Boolean) {
            o0Var.V((Boolean) obj);
        } else if (obj instanceof Map) {
            o0Var.d();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    String str = (String) key;
                    o0Var.j(str);
                    if (b(str)) {
                        o0Var.d0("[FILTERED]");
                    } else {
                        a(entry.getValue(), o0Var);
                    }
                }
            }
            o0Var.g();
        } else if (obj instanceof Collection) {
            o0Var.c();
            for (Object obj2 : (Collection) obj) {
                a(obj2, o0Var);
            }
            o0Var.f();
        } else if (obj.getClass().isArray()) {
            o0Var.c();
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                a(Array.get(obj, i2), o0Var);
            }
            o0Var.f();
        } else {
            o0Var.d0("[OBJECT]");
        }
    }
}