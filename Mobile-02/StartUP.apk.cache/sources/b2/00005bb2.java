package org.apache.commons.lang3;

import java.io.Serializable;

/* compiled from: ObjectUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static final C0425a a = new C0425a();

    /* compiled from: ObjectUtils.java */
    /* renamed from: org.apache.commons.lang3.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0425a implements Serializable {
        C0425a() {
        }
    }

    @Deprecated
    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }
}