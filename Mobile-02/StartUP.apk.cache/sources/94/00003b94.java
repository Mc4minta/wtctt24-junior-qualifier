package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    private static <T> T a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            b2.h(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).i(httpRequest.getRequestLine().getMethod());
            Long a = g.a(httpRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            return (T) httpClient.execute(httpHost, httpRequest, new e(responseHandler, y0Var, b2));
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    private static <T> T b(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            b2.h(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).i(httpRequest.getRequestLine().getMethod());
            Long a = g.a(httpRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            return (T) httpClient.execute(httpHost, httpRequest, new e(responseHandler, y0Var, b2), httpContext);
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    private static <T> T c(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            b2.h(httpUriRequest.getURI().toString()).i(httpUriRequest.getMethod());
            Long a = g.a(httpUriRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            return (T) httpClient.execute(httpUriRequest, new e(responseHandler, y0Var, b2));
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    private static <T> T d(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            b2.h(httpUriRequest.getURI().toString()).i(httpUriRequest.getMethod());
            Long a = g.a(httpUriRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            return (T) httpClient.execute(httpUriRequest, new e(responseHandler, y0Var, b2), httpContext);
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    private static HttpResponse e(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            b2.h(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).i(httpRequest.getRequestLine().getMethod());
            Long a = g.a(httpRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            b2.o(y0Var.a());
            b2.c(execute.getStatusLine().getStatusCode());
            Long a2 = g.a(execute);
            if (a2 != null) {
                b2.p(a2.longValue());
            }
            String b3 = g.b(execute);
            if (b3 != null) {
                b2.j(b3);
            }
            b2.g();
            return execute;
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return g(httpClient, httpUriRequest, new y0(), com.google.firebase.perf.internal.d.k());
    }

    private static HttpResponse f(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            b2.h(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).i(httpRequest.getRequestLine().getMethod());
            Long a = g.a(httpRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            b2.o(y0Var.a());
            b2.c(execute.getStatusLine().getStatusCode());
            Long a2 = g.a(execute);
            if (a2 != null) {
                b2.p(a2.longValue());
            }
            String b3 = g.b(execute);
            if (b3 != null) {
                b2.j(b3);
            }
            b2.g();
            return execute;
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    private static HttpResponse g(HttpClient httpClient, HttpUriRequest httpUriRequest, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            b2.h(httpUriRequest.getURI().toString()).i(httpUriRequest.getMethod());
            Long a = g.a(httpUriRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            HttpResponse execute = httpClient.execute(httpUriRequest);
            b2.o(y0Var.a());
            b2.c(execute.getStatusLine().getStatusCode());
            Long a2 = g.a(execute);
            if (a2 != null) {
                b2.p(a2.longValue());
            }
            String b3 = g.b(execute);
            if (b3 != null) {
                b2.j(b3);
            }
            b2.g();
            return execute;
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    private static HttpResponse h(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, y0 y0Var, com.google.firebase.perf.internal.d dVar) throws IOException {
        i0 b2 = i0.b(dVar);
        try {
            b2.h(httpUriRequest.getURI().toString()).i(httpUriRequest.getMethod());
            Long a = g.a(httpUriRequest);
            if (a != null) {
                b2.k(a.longValue());
            }
            y0Var.b();
            b2.l(y0Var.c());
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            b2.o(y0Var.a());
            b2.c(execute.getStatusLine().getStatusCode());
            Long a2 = g.a(execute);
            if (a2 != null) {
                b2.p(a2.longValue());
            }
            String b3 = g.b(execute);
            if (b3 != null) {
                b2.j(b3);
            }
            b2.g();
            return execute;
        } catch (IOException e2) {
            b2.o(y0Var.a());
            g.c(b2);
            throw e2;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return h(httpClient, httpUriRequest, httpContext, new y0(), com.google.firebase.perf.internal.d.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return (T) c(httpClient, httpUriRequest, responseHandler, new y0(), com.google.firebase.perf.internal.d.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) d(httpClient, httpUriRequest, responseHandler, httpContext, new y0(), com.google.firebase.perf.internal.d.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return e(httpClient, httpHost, httpRequest, new y0(), com.google.firebase.perf.internal.d.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return f(httpClient, httpHost, httpRequest, httpContext, new y0(), com.google.firebase.perf.internal.d.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) a(httpClient, httpHost, httpRequest, responseHandler, new y0(), com.google.firebase.perf.internal.d.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) b(httpClient, httpHost, httpRequest, responseHandler, httpContext, new y0(), com.google.firebase.perf.internal.d.k());
    }
}