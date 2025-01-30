package com.google.firebase.installations;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
class p {
    public static final long a = TimeUnit.HOURS.toSeconds(1);

    public long a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public boolean b(com.google.firebase.installations.q.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < a() + a;
    }
}