package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: RequestBuilder.java */
/* loaded from: classes3.dex */
final class q {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f17959b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: c  reason: collision with root package name */
    private final String f17960c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpUrl f17961d;

    /* renamed from: e  reason: collision with root package name */
    private String f17962e;

    /* renamed from: f  reason: collision with root package name */
    private HttpUrl.Builder f17963f;

    /* renamed from: g  reason: collision with root package name */
    private final Request.Builder f17964g = new Request.Builder();

    /* renamed from: h  reason: collision with root package name */
    private final Headers.Builder f17965h;

    /* renamed from: i  reason: collision with root package name */
    private MediaType f17966i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f17967j;

    /* renamed from: k  reason: collision with root package name */
    private MultipartBody.Builder f17968k;

    /* renamed from: l  reason: collision with root package name */
    private FormBody.Builder f17969l;
    private RequestBody m;

    /* compiled from: RequestBuilder.java */
    /* loaded from: classes3.dex */
    private static class a extends RequestBody {
        private final RequestBody a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaType f17970b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.a = requestBody;
            this.f17970b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f17970b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(j.g gVar) throws IOException {
            this.a.writeTo(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f17960c = str;
        this.f17961d = httpUrl;
        this.f17962e = str2;
        this.f17966i = mediaType;
        this.f17967j = z;
        if (headers != null) {
            this.f17965h = headers.newBuilder();
        } else {
            this.f17965h = new Headers.Builder();
        }
        if (z2) {
            this.f17969l = new FormBody.Builder();
        } else if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f17968k = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String i(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i2 += Character.charCount(codePointAt);
            } else {
                j.f fVar = new j.f();
                fVar.q0(str, 0, i2);
                j(fVar, str, i2, length, z);
                return fVar.G0();
            }
        }
        return str;
    }

    private static void j(j.f fVar, String str, int i2, int i3, boolean z) {
        j.f fVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                    fVar.u1(codePointAt);
                } else {
                    if (fVar2 == null) {
                        fVar2 = new j.f();
                    }
                    fVar2.u1(codePointAt);
                    while (!fVar2.Q()) {
                        int m0 = fVar2.m0() & 255;
                        fVar.R(37);
                        char[] cArr = a;
                        fVar.R(cArr[(m0 >> 4) & 15]);
                        fVar.R(cArr[m0 & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) {
        if (z) {
            this.f17969l.addEncoded(str, str2);
        } else {
            this.f17969l.add(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.f17966i = MediaType.get(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        }
        this.f17965h.add(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Headers headers) {
        this.f17965h.addAll(headers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Headers headers, RequestBody requestBody) {
        this.f17968k.addPart(headers, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MultipartBody.Part part) {
        this.f17968k.addPart(part);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, boolean z) {
        if (this.f17962e != null) {
            String i2 = i(str2, z);
            String str3 = this.f17962e;
            String replace = str3.replace("{" + str + "}", i2);
            if (!f17959b.matcher(replace).matches()) {
                this.f17962e = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, boolean z) {
        String str3 = this.f17962e;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.f17961d.newBuilder(str3);
            this.f17963f = newBuilder;
            if (newBuilder != null) {
                this.f17962e = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f17961d + ", Relative: " + this.f17962e);
            }
        }
        if (z) {
            this.f17963f.addEncodedQueryParameter(str, str2);
        } else {
            this.f17963f.addQueryParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void h(Class<T> cls, T t) {
        this.f17964g.tag(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f17963f;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.f17961d.resolve(this.f17962e);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f17961d + ", Relative: " + this.f17962e);
            }
        }
        a aVar = this.m;
        if (aVar == null) {
            FormBody.Builder builder2 = this.f17969l;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f17968k;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f17967j) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f17966i;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f17965h.add("Content-Type", mediaType.toString());
            }
        }
        return this.f17964g.url(resolve).headers(this.f17965h.build()).method(this.f17960c, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(RequestBody requestBody) {
        this.m = requestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Object obj) {
        this.f17962e = obj.toString();
    }
}