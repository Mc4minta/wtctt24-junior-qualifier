package e.g.b.a.b.f;

import com.caverock.androidsvg.SVGParser;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.a0;
import com.google.api.client.http.e;
import com.google.api.client.http.f;
import com.google.api.client.http.g;
import com.google.api.client.http.h;
import com.google.api.client.http.l;
import com.google.api.client.http.o;
import com.google.api.client.http.p;
import com.google.api.client.http.r;
import com.google.api.client.http.s;
import e.g.b.a.d.n;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* compiled from: AbstractGoogleClientRequest.java */
/* loaded from: classes2.dex */
public abstract class b<T> extends n {
    private static final String API_VERSION_HEADER = "X-Goog-Api-Client";
    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
    private final e.g.b.a.b.f.a abstractGoogleClient;
    private boolean disableGZipContent;
    private e.g.b.a.b.e.a downloader;
    private final h httpContent;
    private l lastResponseHeaders;
    private String lastStatusMessage;
    private final String requestMethod;
    private Class<T> responseClass;
    private e.g.b.a.b.e.c uploader;
    private final String uriTemplate;
    private l requestHeaders = new l();
    private int lastStatusCode = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractGoogleClientRequest.java */
    /* loaded from: classes2.dex */
    public class a implements s {
        final /* synthetic */ s a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f13377b;

        a(s sVar, o oVar) {
            this.a = sVar;
            this.f13377b = oVar;
        }

        @Override // com.google.api.client.http.s
        public void a(r rVar) throws IOException {
            s sVar = this.a;
            if (sVar != null) {
                sVar.a(rVar);
            }
            if (!rVar.l() && this.f13377b.l()) {
                throw b.this.newExceptionOnError(rVar);
            }
        }
    }

    /* compiled from: AbstractGoogleClientRequest.java */
    /* renamed from: e.g.b.a.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0309b {
        private static final String a = e();

        /* renamed from: b  reason: collision with root package name */
        private static final String f13379b = c(System.getProperty("os.name"));

        /* renamed from: c  reason: collision with root package name */
        private static final String f13380c = d(System.getProperty("os.version"));

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(e.g.b.a.b.f.a aVar) {
            return String.format("java/%s http-google-%s/%s %s/%s", a, c(aVar.getClass().getSimpleName()), d(e.g.b.a.b.a.f13340d), f13379b, f13380c);
        }

        private static String c(String str) {
            return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
        }

        private static String d(String str) {
            Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
            return matcher.find() ? matcher.group(1) : str;
        }

        private static String e() {
            String property = System.getProperty("java.version");
            return property.startsWith("9") ? "9.0.0" : d(property);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(e.g.b.a.b.f.a aVar, String str, String str2, h hVar, Class<T> cls) {
        this.responseClass = (Class) y.d(cls);
        this.abstractGoogleClient = (e.g.b.a.b.f.a) y.d(aVar);
        this.requestMethod = (String) y.d(str);
        this.uriTemplate = (String) y.d(str2);
        this.httpContent = hVar;
        String applicationName = aVar.getApplicationName();
        if (applicationName != null) {
            l lVar = this.requestHeaders;
            lVar.J(applicationName + " " + USER_AGENT_SUFFIX);
        } else {
            this.requestHeaders.J(USER_AGENT_SUFFIX);
        }
        this.requestHeaders.set(API_VERSION_HEADER, C0309b.b(aVar));
    }

    public o buildHttpRequest() throws IOException {
        return buildHttpRequest(false);
    }

    public g buildHttpRequestUrl() {
        return new g(a0.b(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, this, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o buildHttpRequestUsingHead() throws IOException {
        return buildHttpRequest(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkRequiredParameter(Object obj, String str) {
        y.c(this.abstractGoogleClient.getSuppressRequiredParameterChecks() || obj != null, "Required parameter %s must be specified", str);
    }

    public T execute() throws IOException {
        return (T) executeUnparsed().m(this.responseClass);
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().b(outputStream);
    }

    public InputStream executeAsInputStream() throws IOException {
        return executeUnparsed().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r executeMedia() throws IOException {
        set("alt", (Object) SVGParser.XML_STYLESHEET_ATTR_MEDIA);
        return executeUnparsed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
        e.g.b.a.b.e.a aVar = this.downloader;
        if (aVar == null) {
            executeMedia().b(outputStream);
        } else {
            aVar.a(buildHttpRequestUrl(), this.requestHeaders, outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream executeMediaAsInputStream() throws IOException {
        return executeMedia().c();
    }

    public r executeUnparsed() throws IOException {
        return executeUnparsed(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r executeUsingHead() throws IOException {
        y.a(this.uploader == null);
        r executeUnparsed = executeUnparsed(true);
        executeUnparsed.k();
        return executeUnparsed;
    }

    public e.g.b.a.b.f.a getAbstractGoogleClient() {
        return this.abstractGoogleClient;
    }

    public final boolean getDisableGZipContent() {
        return this.disableGZipContent;
    }

    public final h getHttpContent() {
        return this.httpContent;
    }

    public final l getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public final int getLastStatusCode() {
        return this.lastStatusCode;
    }

    public final String getLastStatusMessage() {
        return this.lastStatusMessage;
    }

    public final e.g.b.a.b.e.a getMediaHttpDownloader() {
        return this.downloader;
    }

    public final e.g.b.a.b.e.c getMediaHttpUploader() {
        return this.uploader;
    }

    public final l getRequestHeaders() {
        return this.requestHeaders;
    }

    public final String getRequestMethod() {
        return this.requestMethod;
    }

    public final Class<T> getResponseClass() {
        return this.responseClass;
    }

    public final String getUriTemplate() {
        return this.uriTemplate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initializeMediaDownload() {
        p requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.downloader = new e.g.b.a.b.e.a(requestFactory.f(), requestFactory.e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initializeMediaUpload(com.google.api.client.http.b bVar) {
        p requestFactory = this.abstractGoogleClient.getRequestFactory();
        e.g.b.a.b.e.c cVar = new e.g.b.a.b.e.c(bVar, requestFactory.f(), requestFactory.e());
        this.uploader = cVar;
        cVar.m(this.requestMethod);
        h hVar = this.httpContent;
        if (hVar != null) {
            this.uploader.n(hVar);
        }
    }

    protected IOException newExceptionOnError(r rVar) {
        return new HttpResponseException(rVar);
    }

    public final <E> void queue(e.g.b.a.b.c.b bVar, Class<E> cls, e.g.b.a.b.c.a<T, E> aVar) throws IOException {
        y.b(this.uploader == null, "Batching media requests is not supported");
        bVar.a(buildHttpRequest(), getResponseClass(), cls, aVar);
    }

    public b<T> setDisableGZipContent(boolean z) {
        this.disableGZipContent = z;
        return this;
    }

    public b<T> setRequestHeaders(l lVar) {
        this.requestHeaders = lVar;
        return this;
    }

    private o buildHttpRequest(boolean z) throws IOException {
        boolean z2 = true;
        y.a(this.uploader == null);
        if (z && !this.requestMethod.equals(HttpGet.METHOD_NAME)) {
            z2 = false;
        }
        y.a(z2);
        o d2 = getAbstractGoogleClient().getRequestFactory().d(z ? HttpHead.METHOD_NAME : this.requestMethod, buildHttpRequestUrl(), this.httpContent);
        new e.g.b.a.b.b().a(d2);
        d2.v(getAbstractGoogleClient().getObjectParser());
        if (this.httpContent == null && (this.requestMethod.equals(HttpPost.METHOD_NAME) || this.requestMethod.equals(HttpPut.METHOD_NAME) || this.requestMethod.equals(HttpPatch.METHOD_NAME))) {
            d2.r(new e());
        }
        d2.e().putAll(this.requestHeaders);
        if (!this.disableGZipContent) {
            d2.s(new f());
        }
        d2.x(new a(d2.k(), d2));
        return d2;
    }

    private r executeUnparsed(boolean z) throws IOException {
        r p;
        if (this.uploader == null) {
            p = buildHttpRequest(z).a();
        } else {
            g buildHttpRequestUrl = buildHttpRequestUrl();
            boolean l2 = getAbstractGoogleClient().getRequestFactory().d(this.requestMethod, buildHttpRequestUrl, this.httpContent).l();
            p = this.uploader.l(this.requestHeaders).k(this.disableGZipContent).p(buildHttpRequestUrl);
            p.g().v(getAbstractGoogleClient().getObjectParser());
            if (l2 && !p.l()) {
                throw newExceptionOnError(p);
            }
        }
        this.lastResponseHeaders = p.f();
        this.lastStatusCode = p.h();
        this.lastStatusMessage = p.i();
        return p;
    }

    @Override // e.g.b.a.d.n
    public b<T> set(String str, Object obj) {
        return (b) super.set(str, obj);
    }
}