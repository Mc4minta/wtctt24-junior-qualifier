package org.reactnative.camera.h;

import android.content.Context;
import java.io.File;

/* compiled from: ScopedContext.java */
/* loaded from: classes3.dex */
public class d {
    private File a = null;

    public d(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.a = new File(context.getCacheDir() + "/Camera/");
    }

    public File b() {
        return this.a;
    }
}