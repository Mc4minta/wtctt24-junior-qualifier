package com.google.android.gms.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class q {
    private static final j a = new j("LibraryVersion", "");

    /* renamed from: b  reason: collision with root package name */
    private static q f6266b = new q();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f6267c = new ConcurrentHashMap<>();

    protected q() {
    }

    public static q a() {
        return f6266b;
    }

    public String b(String str) {
        t.h(str, "Please provide a valid libraryName");
        if (this.f6267c.containsKey(str)) {
            return this.f6267c.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = q.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty(ClientCookie.VERSION_ATTR, null);
                j jVar = a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                jVar.d("LibraryVersion", sb.toString());
            } else {
                j jVar2 = a;
                String valueOf = String.valueOf(str);
                jVar2.e("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e2) {
            j jVar3 = a;
            String valueOf2 = String.valueOf(str);
            jVar3.c("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e2);
        }
        if (str2 == null) {
            a.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.f6267c.put(str, str2);
        return str2;
    }
}