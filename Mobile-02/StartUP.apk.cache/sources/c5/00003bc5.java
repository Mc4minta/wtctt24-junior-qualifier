package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class m {
    private static final Map<String, m> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f9456b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9457c;

    private m(Context context, String str) {
        this.f9456b = context;
        this.f9457c = str;
    }

    public static synchronized m c(Context context, String str) {
        m mVar;
        synchronized (m.class) {
            Map<String, m> map = a;
            if (!map.containsKey(str)) {
                map.put(str, new m(context, str));
            }
            mVar = map.get(str);
        }
        return mVar;
    }

    public synchronized Void a() {
        this.f9456b.deleteFile(this.f9457c);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f9457c;
    }

    public synchronized f d() throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = this.f9456b.openFileInput(this.f9457c);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            f b2 = f.b(new JSONObject(new String(bArr, "UTF-8")));
            fileInputStream.close();
            return b2;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public synchronized Void e(f fVar) throws IOException {
        FileOutputStream openFileOutput = this.f9456b.openFileOutput(this.f9457c, 0);
        openFileOutput.write(fVar.toString().getBytes("UTF-8"));
        openFileOutput.close();
        return null;
    }
}