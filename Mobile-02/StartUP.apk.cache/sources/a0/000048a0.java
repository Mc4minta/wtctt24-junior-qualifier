package e.g.b.a.b.f;

import com.google.api.client.http.g;
import com.google.api.client.http.p;
import com.google.api.client.http.q;
import com.google.api.client.http.u;
import e.g.b.a.d.d0;
import e.g.b.a.d.w;
import e.g.b.a.d.y;
import java.io.IOException;
import java.util.logging.Logger;

/* compiled from: AbstractGoogleClient.java */
/* loaded from: classes2.dex */
public abstract class a {
    private static final Logger logger = Logger.getLogger(a.class.getName());
    private final String applicationName;
    private final String batchPath;
    private final d googleClientRequestInitializer;
    private final w objectParser;
    private final p requestFactory;
    private final String rootUrl;
    private final String servicePath;
    private final boolean suppressPatternChecks;
    private final boolean suppressRequiredParameterChecks;

    /* compiled from: AbstractGoogleClient.java */
    /* renamed from: e.g.b.a.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0308a {
        String applicationName;
        String batchPath;
        d googleClientRequestInitializer;
        q httpRequestInitializer;
        final w objectParser;
        String rootUrl;
        String servicePath;
        boolean suppressPatternChecks;
        boolean suppressRequiredParameterChecks;
        final u transport;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC0308a(u uVar, String str, String str2, w wVar, q qVar) {
            this.transport = (u) y.d(uVar);
            this.objectParser = wVar;
            setRootUrl(str);
            setServicePath(str2);
            this.httpRequestInitializer = qVar;
        }

        public abstract a build();

        public final String getApplicationName() {
            return this.applicationName;
        }

        public final d getGoogleClientRequestInitializer() {
            return this.googleClientRequestInitializer;
        }

        public final q getHttpRequestInitializer() {
            return this.httpRequestInitializer;
        }

        public w getObjectParser() {
            return this.objectParser;
        }

        public final String getRootUrl() {
            return this.rootUrl;
        }

        public final String getServicePath() {
            return this.servicePath;
        }

        public final boolean getSuppressPatternChecks() {
            return this.suppressPatternChecks;
        }

        public final boolean getSuppressRequiredParameterChecks() {
            return this.suppressRequiredParameterChecks;
        }

        public final u getTransport() {
            return this.transport;
        }

        public AbstractC0308a setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        public AbstractC0308a setBatchPath(String str) {
            this.batchPath = str;
            return this;
        }

        public AbstractC0308a setGoogleClientRequestInitializer(d dVar) {
            this.googleClientRequestInitializer = dVar;
            return this;
        }

        public AbstractC0308a setHttpRequestInitializer(q qVar) {
            this.httpRequestInitializer = qVar;
            return this;
        }

        public AbstractC0308a setRootUrl(String str) {
            this.rootUrl = a.normalizeRootUrl(str);
            return this;
        }

        public AbstractC0308a setServicePath(String str) {
            this.servicePath = a.normalizeServicePath(str);
            return this;
        }

        public AbstractC0308a setSuppressAllChecks(boolean z) {
            return setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
        }

        public AbstractC0308a setSuppressPatternChecks(boolean z) {
            this.suppressPatternChecks = z;
            return this;
        }

        public AbstractC0308a setSuppressRequiredParameterChecks(boolean z) {
            this.suppressRequiredParameterChecks = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0308a abstractC0308a) {
        p d2;
        this.googleClientRequestInitializer = abstractC0308a.googleClientRequestInitializer;
        this.rootUrl = normalizeRootUrl(abstractC0308a.rootUrl);
        this.servicePath = normalizeServicePath(abstractC0308a.servicePath);
        this.batchPath = abstractC0308a.batchPath;
        if (d0.a(abstractC0308a.applicationName)) {
            logger.warning("Application name is not set. Call Builder#setApplicationName.");
        }
        this.applicationName = abstractC0308a.applicationName;
        q qVar = abstractC0308a.httpRequestInitializer;
        if (qVar == null) {
            d2 = abstractC0308a.transport.c();
        } else {
            d2 = abstractC0308a.transport.d(qVar);
        }
        this.requestFactory = d2;
        this.objectParser = abstractC0308a.objectParser;
        this.suppressPatternChecks = abstractC0308a.suppressPatternChecks;
        this.suppressRequiredParameterChecks = abstractC0308a.suppressRequiredParameterChecks;
    }

    static String normalizeRootUrl(String str) {
        y.e(str, "root URL cannot be null.");
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    static String normalizeServicePath(String str) {
        y.e(str, "service path cannot be null");
        if (str.length() == 1) {
            y.b("/".equals(str), "service path must equal \"/\" if it is of length 1.");
            return "";
        } else if (str.length() > 0) {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            return str.startsWith("/") ? str.substring(1) : str;
        } else {
            return str;
        }
    }

    public final e.g.b.a.b.c.b batch() {
        return batch(null);
    }

    public final String getApplicationName() {
        return this.applicationName;
    }

    public final String getBaseUrl() {
        return this.rootUrl + this.servicePath;
    }

    public final d getGoogleClientRequestInitializer() {
        return this.googleClientRequestInitializer;
    }

    public w getObjectParser() {
        return this.objectParser;
    }

    public final p getRequestFactory() {
        return this.requestFactory;
    }

    public final String getRootUrl() {
        return this.rootUrl;
    }

    public final String getServicePath() {
        return this.servicePath;
    }

    public final boolean getSuppressPatternChecks() {
        return this.suppressPatternChecks;
    }

    public final boolean getSuppressRequiredParameterChecks() {
        return this.suppressRequiredParameterChecks;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize(b<?> bVar) throws IOException {
        if (getGoogleClientRequestInitializer() != null) {
            getGoogleClientRequestInitializer().initialize(bVar);
        }
    }

    public final e.g.b.a.b.c.b batch(q qVar) {
        e.g.b.a.b.c.b bVar = new e.g.b.a.b.c.b(getRequestFactory().f(), qVar);
        if (d0.a(this.batchPath)) {
            bVar.b(new g(getRootUrl() + "batch"));
        } else {
            bVar.b(new g(getRootUrl() + this.batchPath));
        }
        return bVar;
    }
}