package e.g.b.a.b.f.e;

import com.google.api.client.http.q;
import com.google.api.client.http.u;
import e.g.b.a.b.f.a;
import e.g.b.a.b.f.d;
import e.g.b.a.c.e;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: AbstractGoogleJsonClient.java */
/* loaded from: classes2.dex */
public abstract class a extends e.g.b.a.b.f.a {

    /* compiled from: AbstractGoogleJsonClient.java */
    /* renamed from: e.g.b.a.b.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0310a extends a.AbstractC0308a {
        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC0310a(u uVar, e.g.b.a.c.c cVar, String str, String str2, q qVar, boolean z) {
            super(uVar, str, str2, new e.a(cVar).b(z ? Arrays.asList("data", "error") : Collections.emptySet()).a(), qVar);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public abstract a build();

        public final e.g.b.a.c.c getJsonFactory() {
            return getObjectParser().b();
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public final e getObjectParser() {
            return (e) super.getObjectParser();
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setApplicationName(String str) {
            return (AbstractC0310a) super.setApplicationName(str);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setGoogleClientRequestInitializer(d dVar) {
            return (AbstractC0310a) super.setGoogleClientRequestInitializer(dVar);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setHttpRequestInitializer(q qVar) {
            return (AbstractC0310a) super.setHttpRequestInitializer(qVar);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setRootUrl(String str) {
            return (AbstractC0310a) super.setRootUrl(str);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setServicePath(String str) {
            return (AbstractC0310a) super.setServicePath(str);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setSuppressAllChecks(boolean z) {
            return (AbstractC0310a) super.setSuppressAllChecks(z);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setSuppressPatternChecks(boolean z) {
            return (AbstractC0310a) super.setSuppressPatternChecks(z);
        }

        @Override // e.g.b.a.b.f.a.AbstractC0308a
        public AbstractC0310a setSuppressRequiredParameterChecks(boolean z) {
            return (AbstractC0310a) super.setSuppressRequiredParameterChecks(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0310a abstractC0310a) {
        super(abstractC0310a);
    }

    public final e.g.b.a.c.c getJsonFactory() {
        return getObjectParser().b();
    }

    @Override // e.g.b.a.b.f.a
    public e getObjectParser() {
        return (e) super.getObjectParser();
    }
}