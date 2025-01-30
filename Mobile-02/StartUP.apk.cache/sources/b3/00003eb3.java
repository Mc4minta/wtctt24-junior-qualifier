package com.reactcommunity.rndatetimepicker;

import android.os.Bundle;
import java.util.Calendar;

/* compiled from: RNDate.java */
/* loaded from: classes2.dex */
public class b {
    private Calendar a = Calendar.getInstance();

    public b(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("value")) {
            return;
        }
        e(bundle.getLong("value"));
    }

    public int a() {
        return this.a.get(5);
    }

    public int b() {
        return this.a.get(11);
    }

    public int c() {
        return this.a.get(12);
    }

    public int d() {
        return this.a.get(2);
    }

    public void e(long j2) {
        this.a.setTimeInMillis(j2);
    }

    public int f() {
        return this.a.get(1);
    }
}