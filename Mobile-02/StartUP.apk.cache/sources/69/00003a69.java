package com.google.firebase.crashlytics.c.j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.coinbase.ApiConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class a {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0185a f8965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0185a {
        String a(File file) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, InterfaceC0185a interfaceC0185a) {
        this.a = context;
        this.f8965b = interfaceC0185a;
    }

    private File b(File file) {
        if (Build.VERSION.SDK_INT >= 9 && file.getAbsolutePath().startsWith("/data")) {
            try {
                return new File(this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 0).nativeLibraryDir, file.getName());
            } catch (PackageManager.NameNotFoundException e2) {
                com.google.firebase.crashlytics.c.b.f().e("Error getting ApplicationInfo", e2);
                return file;
            }
        }
        return file;
    }

    private static JSONObject c(String str, c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", cVar.a);
        jSONObject.put("size", cVar.f8966b);
        jSONObject.put(ApiConstants.NAME, cVar.f8968d);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static byte[] d(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes(Charset.forName("UTF-8"));
        } catch (JSONException e2) {
            com.google.firebase.crashlytics.c.b.f().j("Binary images string is null", e2);
            return new byte[0];
        }
    }

    private File e(String str) {
        File file = new File(str);
        return !file.exists() ? b(file) : file;
    }

    private static boolean f(c cVar) {
        return (cVar.f8967c.indexOf(120) == -1 || cVar.f8968d.indexOf(47) == -1) ? false : true;
    }

    private JSONObject g(String str) {
        c a = d.a(str);
        if (a != null && f(a)) {
            try {
                try {
                    return c(this.f8965b.a(e(a.f8968d)), a);
                } catch (JSONException e2) {
                    com.google.firebase.crashlytics.c.b.f().c("Could not create a binary image json string", e2);
                    return null;
                }
            } catch (IOException e3) {
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.c("Could not generate ID for file " + a.f8968d, e3);
            }
        }
        return null;
    }

    private JSONArray h(BufferedReader bufferedReader) throws IOException {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return jSONArray;
            }
            JSONObject g2 = g(readLine);
            if (g2 != null) {
                jSONArray.put(g2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(BufferedReader bufferedReader) throws IOException {
        return d(h(bufferedReader));
    }
}