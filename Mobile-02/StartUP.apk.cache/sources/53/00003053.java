package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: ApplicationSoSource.java */
/* loaded from: classes2.dex */
public class b extends l {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private int f5615b;

    /* renamed from: c  reason: collision with root package name */
    private c f5616c;

    public b(Context context, int i2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.a = context;
        }
        this.f5615b = i2;
        this.f5616c = new c(new File(this.a.getApplicationInfo().nativeLibraryDir), i2);
    }

    @Override // com.facebook.soloader.l
    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.f5616c.a(str, i2, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.l
    public void b(int i2) throws IOException {
        this.f5616c.b(i2);
    }

    @Override // com.facebook.soloader.l
    public File c(String str) throws IOException {
        return this.f5616c.c(str);
    }

    public boolean d() throws IOException {
        try {
            File file = this.f5616c.a;
            Context context = this.a;
            Context createPackageContext = context.createPackageContext(context.getPackageName(), 0);
            File file2 = new File(createPackageContext.getApplicationInfo().nativeLibraryDir);
            if (file.equals(file2)) {
                return false;
            }
            Log.d("SoLoader", "Native library directory updated from " + file + " to " + file2);
            int i2 = this.f5615b | 1;
            this.f5615b = i2;
            c cVar = new c(file2, i2);
            this.f5616c = cVar;
            cVar.b(this.f5615b);
            this.a = createPackageContext;
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.facebook.soloader.l
    public String toString() {
        return this.f5616c.toString();
    }
}