package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;
import java.io.IOException;

/* compiled from: SoSource.java */
/* loaded from: classes2.dex */
public abstract class l {
    public abstract int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i2) throws IOException {
    }

    public abstract File c(String str) throws IOException;

    public String toString() {
        return getClass().getName();
    }
}