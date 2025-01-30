package com.google.api.client.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* compiled from: HttpTransport.java */
/* loaded from: classes2.dex */
public abstract class u {
    static final Logger a = Logger.getLogger(u.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f8403b;

    static {
        String[] strArr = {HttpDelete.METHOD_NAME, HttpGet.METHOD_NAME, HttpPost.METHOD_NAME, HttpPut.METHOD_NAME};
        f8403b = strArr;
        Arrays.sort(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o a() {
        return new o(this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract x b(String str, String str2) throws IOException;

    public final p c() {
        return d(null);
    }

    public final p d(q qVar) {
        return new p(this, qVar);
    }

    public boolean e(String str) throws IOException {
        return Arrays.binarySearch(f8403b, str) >= 0;
    }
}