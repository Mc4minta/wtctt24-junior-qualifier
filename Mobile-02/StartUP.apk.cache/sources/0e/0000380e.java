package com.google.api.client.http.e0;

import com.google.api.client.http.y;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetHttpResponse.java */
/* loaded from: classes2.dex */
public final class d extends y {
    private final HttpURLConnection a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8350b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8351c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<String> f8352d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<String> f8353e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HttpURLConnection httpURLConnection) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f8352d = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.f8353e = arrayList2;
        this.a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        this.f8350b = responseCode == -1 ? 0 : responseCode;
        this.f8351c = httpURLConnection.getResponseMessage();
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                for (String str : entry.getValue()) {
                    if (str != null) {
                        arrayList.add(key);
                        arrayList2.add(str);
                    }
                }
            }
        }
    }

    @Override // com.google.api.client.http.y
    public void a() {
        this.a.disconnect();
    }

    @Override // com.google.api.client.http.y
    public InputStream b() throws IOException {
        InputStream errorStream;
        try {
            errorStream = this.a.getInputStream();
        } catch (IOException unused) {
            errorStream = this.a.getErrorStream();
        }
        if (errorStream == null) {
            return null;
        }
        return new a(errorStream);
    }

    @Override // com.google.api.client.http.y
    public String c() {
        return this.a.getContentEncoding();
    }

    @Override // com.google.api.client.http.y
    public String d() {
        return this.a.getHeaderField("Content-Type");
    }

    @Override // com.google.api.client.http.y
    public int e() {
        return this.f8352d.size();
    }

    @Override // com.google.api.client.http.y
    public String f(int i2) {
        return this.f8352d.get(i2);
    }

    @Override // com.google.api.client.http.y
    public String g(int i2) {
        return this.f8353e.get(i2);
    }

    @Override // com.google.api.client.http.y
    public String h() {
        return this.f8351c;
    }

    @Override // com.google.api.client.http.y
    public int i() {
        return this.f8350b;
    }

    @Override // com.google.api.client.http.y
    public String j() {
        String headerField = this.a.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    public long k() {
        String headerField = this.a.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    /* compiled from: NetHttpResponse.java */
    /* loaded from: classes2.dex */
    private final class a extends FilterInputStream {
        private long a;

        public a(InputStream inputStream) {
            super(inputStream);
            this.a = 0L;
        }

        private void a() throws IOException {
            long k2 = d.this.k();
            if (k2 == -1) {
                return;
            }
            long j2 = this.a;
            if (j2 == 0 || j2 >= k2) {
                return;
            }
            throw new IOException("Connection closed prematurely: bytesRead = " + this.a + ", Content-Length = " + k2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
            if (read == -1) {
                a();
            } else {
                this.a += read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(j2);
            this.a += skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                a();
            } else {
                this.a++;
            }
            return read;
        }
    }
}