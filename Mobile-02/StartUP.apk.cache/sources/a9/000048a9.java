package e.g.b.a.b.f.e;

import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.l;
import com.google.api.client.http.r;
import java.io.IOException;

/* compiled from: AbstractGoogleJsonClientRequest.java */
/* loaded from: classes2.dex */
public abstract class b<T> extends e.g.b.a.b.f.b<T> {
    private final Object jsonContent;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(e.g.b.a.b.f.e.a r8, java.lang.String r9, java.lang.String r10, java.lang.Object r11, java.lang.Class<T> r12) {
        /*
            r7 = this;
            r0 = 0
            if (r11 != 0) goto L5
        L3:
            r5 = r0
            goto L24
        L5:
            com.google.api.client.http.f0.a r1 = new com.google.api.client.http.f0.a
            e.g.b.a.c.c r2 = r8.getJsonFactory()
            r1.<init>(r2, r11)
            e.g.b.a.c.e r2 = r8.getObjectParser()
            java.util.Set r2 = r2.c()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L1d
            goto L1f
        L1d:
            java.lang.String r0 = "data"
        L1f:
            com.google.api.client.http.f0.a r0 = r1.f(r0)
            goto L3
        L24:
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r7.jsonContent = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.a.b.f.e.b.<init>(e.g.b.a.b.f.e.a, java.lang.String, java.lang.String, java.lang.Object, java.lang.Class):void");
    }

    public Object getJsonContent() {
        return this.jsonContent;
    }

    public final void queue(e.g.b.a.b.c.b bVar, e.g.b.a.b.c.c.a<T> aVar) throws IOException {
        super.queue(bVar, GoogleJsonErrorContainer.class, aVar);
    }

    @Override // e.g.b.a.b.f.b
    public a getAbstractGoogleClient() {
        return (a) super.getAbstractGoogleClient();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.g.b.a.b.f.b
    public GoogleJsonResponseException newExceptionOnError(r rVar) {
        return GoogleJsonResponseException.b(getAbstractGoogleClient().getJsonFactory(), rVar);
    }

    @Override // e.g.b.a.b.f.b
    public b<T> setDisableGZipContent(boolean z) {
        return (b) super.setDisableGZipContent(z);
    }

    @Override // e.g.b.a.b.f.b
    public b<T> setRequestHeaders(l lVar) {
        return (b) super.setRequestHeaders(lVar);
    }

    @Override // e.g.b.a.b.f.b, e.g.b.a.d.n
    public b<T> set(String str, Object obj) {
        return (b) super.set(str, obj);
    }
}