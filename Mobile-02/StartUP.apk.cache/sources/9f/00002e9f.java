package com.facebook.react.modules.network;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import j.e0;
import j.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPOutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestBodyUtil.java */
/* loaded from: classes2.dex */
public class m {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBodyUtil.java */
    /* loaded from: classes2.dex */
    public static class a extends RequestBody {
        final /* synthetic */ MediaType a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f4986b;

        a(MediaType mediaType, InputStream inputStream) {
            this.a = mediaType;
            this.f4986b = inputStream;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            try {
                return this.f4986b.available();
            } catch (IOException unused) {
                return 0L;
            }
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(j.g gVar) throws IOException {
            e0 e0Var = null;
            try {
                e0Var = q.k(this.f4986b);
                gVar.t0(e0Var);
            } finally {
                Util.closeQuietly(e0Var);
            }
        }
    }

    public static RequestBody a(MediaType mediaType, InputStream inputStream) {
        return new a(mediaType, inputStream);
    }

    public static RequestBody b(MediaType mediaType, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            return RequestBody.create(mediaType, byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return null;
        }
    }

    public static i c(RequestBody requestBody, h hVar) {
        return new i(requestBody, hVar);
    }

    private static InputStream d(Context context, Uri uri) throws IOException {
        File createTempFile = File.createTempFile("RequestBodyUtil", "temp", context.getApplicationContext().getCacheDir());
        createTempFile.deleteOnExit();
        InputStream openStream = FirebasePerfUrlConnection.openStream(new URL(uri.toString()));
        try {
            ReadableByteChannel newChannel = Channels.newChannel(openStream);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            try {
                fileOutputStream.getChannel().transferFrom(newChannel, 0L, Long.MAX_VALUE);
                FileInputStream fileInputStream = new FileInputStream(createTempFile);
                newChannel.close();
                return fileInputStream;
            } finally {
                fileOutputStream.close();
            }
        } finally {
            openStream.close();
        }
    }

    public static RequestBody e(String str) {
        if (str.equals(HttpPost.METHOD_NAME) || str.equals(HttpPut.METHOD_NAME) || str.equals(HttpPatch.METHOD_NAME)) {
            return RequestBody.create((MediaType) null, j.i.a);
        }
        return null;
    }

    public static InputStream f(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                return d(context, parse);
            }
            return context.getContentResolver().openInputStream(parse);
        } catch (Exception e2) {
            e.f.d.d.a.j("ReactNative", "Could not retrieve file for contentUri " + str, e2);
            return null;
        }
    }

    public static boolean g(String str) {
        return "gzip".equalsIgnoreCase(str);
    }
}