package com.google.firebase.crashlytics.c.g;

import com.coinbase.ApiConstants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class y {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private final File f8808b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class a extends JSONObject {
        final /* synthetic */ g0 a;

        a(g0 g0Var) throws JSONException {
            this.a = g0Var;
            put("userId", g0Var.b());
        }
    }

    public y(File file) {
        this.f8808b = file;
    }

    private static g0 c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        g0 g0Var = new g0();
        g0Var.e(g(jSONObject, "userId"));
        return g0Var;
    }

    private static String d(Map<String, String> map) throws JSONException {
        return new JSONObject(map).toString();
    }

    private static String f(g0 g0Var) throws JSONException {
        return new a(g0Var).toString();
    }

    private static String g(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        File file = this.f8808b;
        return new File(file, str + "keys.meta");
    }

    public File b(String str) {
        File file = this.f8808b;
        return new File(file, str + ApiConstants.USER + ".meta");
    }

    public g0 e(String str) {
        File b2 = b(str);
        if (!b2.exists()) {
            return new g0();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(b2);
                try {
                    g0 c2 = c(h.J(fileInputStream2));
                    h.e(fileInputStream2, "Failed to close user metadata file.");
                    return c2;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    com.google.firebase.crashlytics.c.b.f().e("Error deserializing user metadata.", e);
                    h.e(fileInputStream, "Failed to close user metadata file.");
                    return new g0();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    h.e(fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void h(String str, Map<String, String> map) {
        File a2 = a(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String d2 = d(map);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a2), a));
                try {
                    bufferedWriter2.write(d2);
                    bufferedWriter2.flush();
                    h.e(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    com.google.firebase.crashlytics.c.b.f().e("Error serializing key/value metadata.", e);
                    h.e(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    h.e(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void i(String str, g0 g0Var) {
        File b2 = b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String f2 = f(g0Var);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b2), a));
                try {
                    bufferedWriter2.write(f2);
                    bufferedWriter2.flush();
                    h.e(bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    com.google.firebase.crashlytics.c.b.f().e("Error serializing user metadata.", e);
                    h.e(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    h.e(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}