package com.uber.autodispose.b0;

import h.c.m0.e;
import java.util.Objects;

/* compiled from: AutoDisposeAndroidPlugins.java */
/* loaded from: classes2.dex */
public final class a {
    private static volatile e a;

    public static boolean a(e eVar) {
        Objects.requireNonNull(eVar, "defaultChecker == null");
        e eVar2 = a;
        try {
            if (eVar2 == null) {
                return eVar.a();
            }
            return eVar2.a();
        } catch (Exception e2) {
            throw io.reactivex.exceptions.a.a(e2);
        }
    }
}