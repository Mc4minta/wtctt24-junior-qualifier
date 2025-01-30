package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpResponseException;

/* loaded from: classes2.dex */
public class TokenResponseException extends HttpResponseException {

    /* renamed from: e  reason: collision with root package name */
    private final transient TokenErrorResponse f8305e;

    TokenResponseException(HttpResponseException.a aVar, TokenErrorResponse tokenErrorResponse) {
        super(aVar);
        this.f8305e = tokenErrorResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.api.client.auth.oauth2.TokenErrorResponse] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.google.api.client.auth.oauth2.TokenErrorResponse, e.g.b.a.c.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.auth.oauth2.TokenResponseException b(e.g.b.a.c.c r6, com.google.api.client.http.r r7) {
        /*
            com.google.api.client.http.HttpResponseException$a r0 = new com.google.api.client.http.HttpResponseException$a
            int r1 = r7.h()
            java.lang.String r2 = r7.i()
            com.google.api.client.http.l r3 = r7.f()
            r0.<init>(r1, r2, r3)
            e.g.b.a.d.y.d(r6)
            java.lang.String r1 = r7.e()
            r2 = 0
            boolean r3 = r7.l()     // Catch: java.io.IOException -> L55
            if (r3 != 0) goto L4d
            if (r1 == 0) goto L4d
            java.io.InputStream r3 = r7.c()     // Catch: java.io.IOException -> L55
            if (r3 == 0) goto L4d
            java.lang.String r3 = "application/json; charset=UTF-8"
            boolean r1 = com.google.api.client.http.n.c(r3, r1)     // Catch: java.io.IOException -> L55
            if (r1 == 0) goto L4d
            e.g.b.a.c.e r1 = new e.g.b.a.c.e     // Catch: java.io.IOException -> L55
            r1.<init>(r6)     // Catch: java.io.IOException -> L55
            java.io.InputStream r6 = r7.c()     // Catch: java.io.IOException -> L55
            java.nio.charset.Charset r3 = r7.d()     // Catch: java.io.IOException -> L55
            java.lang.Class<com.google.api.client.auth.oauth2.TokenErrorResponse> r4 = com.google.api.client.auth.oauth2.TokenErrorResponse.class
            java.lang.Object r6 = r1.a(r6, r3, r4)     // Catch: java.io.IOException -> L55
            com.google.api.client.auth.oauth2.TokenErrorResponse r6 = (com.google.api.client.auth.oauth2.TokenErrorResponse) r6     // Catch: java.io.IOException -> L55
            java.lang.String r1 = r6.toPrettyString()     // Catch: java.io.IOException -> L4b
            r2 = r6
            r6 = r1
            goto L51
        L4b:
            r1 = move-exception
            goto L57
        L4d:
            java.lang.String r6 = r7.n()     // Catch: java.io.IOException -> L55
        L51:
            r5 = r2
            r2 = r6
            r6 = r5
            goto L5a
        L55:
            r1 = move-exception
            r6 = r2
        L57:
            r1.printStackTrace()
        L5a:
            java.lang.StringBuilder r7 = com.google.api.client.http.HttpResponseException.a(r7)
            boolean r1 = e.g.b.a.d.d0.a(r2)
            if (r1 != 0) goto L6f
            java.lang.String r1 = e.g.b.a.d.c0.a
            r7.append(r1)
            r7.append(r2)
            r0.a(r2)
        L6f:
            java.lang.String r7 = r7.toString()
            r0.c(r7)
            com.google.api.client.auth.oauth2.TokenResponseException r7 = new com.google.api.client.auth.oauth2.TokenResponseException
            r7.<init>(r0, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.auth.oauth2.TokenResponseException.b(e.g.b.a.c.c, com.google.api.client.http.r):com.google.api.client.auth.oauth2.TokenResponseException");
    }
}