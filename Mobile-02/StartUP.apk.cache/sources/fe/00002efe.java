package com.facebook.react.uimanager.events;

import android.util.SparseIntArray;
import okhttp3.internal.http2.Settings;

/* compiled from: TouchEventCoalescingKeyHelper.java */
/* loaded from: classes2.dex */
public class h {
    private final SparseIntArray a = new SparseIntArray();

    public void a(long j2) {
        this.a.put((int) j2, 0);
    }

    public short b(long j2) {
        int i2 = this.a.get((int) j2, -1);
        if (i2 != -1) {
            return (short) (i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        }
        throw new RuntimeException("Tried to get non-existent cookie");
    }

    public boolean c(long j2) {
        return this.a.get((int) j2, -1) != -1;
    }

    public void d(long j2) {
        int i2 = (int) j2;
        int i3 = this.a.get(i2, -1);
        if (i3 != -1) {
            this.a.put(i2, i3 + 1);
            return;
        }
        throw new RuntimeException("Tried to increment non-existent cookie");
    }

    public void e(long j2) {
        this.a.delete((int) j2);
    }
}