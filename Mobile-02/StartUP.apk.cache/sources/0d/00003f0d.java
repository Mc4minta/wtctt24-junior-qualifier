package com.rumax.reactnative.pdfviewer;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: AsyncDownload.java */
/* loaded from: classes2.dex */
class a extends AsyncTask<Void, Void, Void> {
    private final ReadableMap a;

    /* renamed from: b  reason: collision with root package name */
    private Context f10833b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0232a f10834c;

    /* renamed from: d  reason: collision with root package name */
    private File f10835d;

    /* renamed from: e  reason: collision with root package name */
    private String f10836e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f10837f;

    /* compiled from: AsyncDownload.java */
    /* renamed from: com.rumax.reactnative.pdfviewer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0232a {
        void a(Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str, File file, ReadableMap readableMap, InterfaceC0232a interfaceC0232a) {
        this.f10833b = context;
        this.f10834c = interfaceC0232a;
        this.f10835d = file;
        this.f10836e = str;
        this.a = readableMap;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[PKIFailureInfo.certRevoked];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void c(HttpURLConnection httpURLConnection) throws IOException {
        if (this.a == null) {
            return;
        }
        h(httpURLConnection);
        g(httpURLConnection);
        f(httpURLConnection);
    }

    private Void d(Uri uri) {
        try {
            InputStream openInputStream = this.f10833b.getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(this.f10835d);
            a(openInputStream, fileOutputStream);
            fileOutputStream.close();
            if (openInputStream != null) {
                openInputStream.close();
                return null;
            }
            return null;
        } catch (Exception e2) {
            this.f10837f = e2;
            return null;
        }
    }

    private void f(HttpURLConnection httpURLConnection) throws IOException {
        if (this.a.hasKey("body")) {
            if (this.a.getType("body") == ReadableType.String) {
                String string = this.a.getString("body");
                if (string.getBytes().length > 0) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestProperty("Content-Length", "" + string.getBytes().length);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(string.getBytes());
                        outputStream.flush();
                        outputStream.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                return;
            }
            throw new IOException("Invalid body type. String is expected");
        }
    }

    private void g(HttpURLConnection httpURLConnection) throws IOException {
        ReadableMap map;
        if (this.a.hasKey("headers") && (map = this.a.getMap("headers")) != null) {
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (map.getType(nextKey) == ReadableType.String) {
                    httpURLConnection.setRequestProperty(nextKey, map.getString(nextKey));
                } else {
                    throw new IOException("Invalid header key type. String is expected for " + nextKey);
                }
            }
        }
    }

    private void h(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        if (!this.a.hasKey("method")) {
            str = HttpGet.METHOD_NAME;
        } else if (this.a.getType("method") == ReadableType.String) {
            str = this.a.getString("method");
        } else {
            throw new IOException("Invalid method type. String is expected");
        }
        httpURLConnection.setRequestMethod(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public Void doInBackground(Void... voidArr) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Uri parse = Uri.parse(this.f10836e);
        if (parse.getScheme().equalsIgnoreCase("content")) {
            return d(parse);
        }
        try {
            URL url = new URL(this.f10836e);
            String protocol = url.getProtocol();
            if (!protocol.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) && !protocol.equalsIgnoreCase("https")) {
                this.f10837f = new IOException("Protocol \"" + protocol + "\" is not supported");
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            c(httpURLConnection);
            httpURLConnection.connect();
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), PKIFailureInfo.certRevoked);
                fileOutputStream = new FileOutputStream(this.f10835d);
            } catch (IOException e2) {
                this.f10837f = e2;
            }
            try {
                a(bufferedInputStream, fileOutputStream);
                fileOutputStream.close();
                bufferedInputStream.close();
                return null;
            } finally {
            }
        } catch (Exception e3) {
            this.f10837f = e3;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e */
    public void onPostExecute(Void r2) {
        this.f10834c.a(this.f10837f);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f10837f = null;
    }
}