package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.message.BasicTokenIterator;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return ((httpRequest != null && httpRequest.getRequestLine().getMethod().equalsIgnoreCase(HttpHead.METHOD_NAME)) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        if (java.lang.Integer.parseInt(r8[0].getValue()) < 0) goto L46;
     */
    @Override // org.apache.http.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean keepAlive(org.apache.http.HttpResponse r7, org.apache.http.protocol.HttpContext r8) {
        /*
            r6 = this;
            java.lang.String r0 = "HTTP response"
            org.apache.http.util.Args.notNull(r7, r0)
            java.lang.String r0 = "HTTP context"
            org.apache.http.util.Args.notNull(r8, r0)
            java.lang.String r0 = "http.request"
            java.lang.Object r8 = r8.getAttribute(r0)
            org.apache.http.HttpRequest r8 = (org.apache.http.HttpRequest) r8
            java.lang.String r0 = "Close"
            java.lang.String r1 = "Connection"
            r2 = 0
            if (r8 == 0) goto L33
            org.apache.http.message.BasicTokenIterator r3 = new org.apache.http.message.BasicTokenIterator     // Catch: org.apache.http.ParseException -> L32
            org.apache.http.HeaderIterator r4 = r8.headerIterator(r1)     // Catch: org.apache.http.ParseException -> L32
            r3.<init>(r4)     // Catch: org.apache.http.ParseException -> L32
        L22:
            boolean r4 = r3.hasNext()     // Catch: org.apache.http.ParseException -> L32
            if (r4 == 0) goto L33
            java.lang.String r4 = r3.nextToken()     // Catch: org.apache.http.ParseException -> L32
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch: org.apache.http.ParseException -> L32
            if (r4 == 0) goto L22
        L32:
            return r2
        L33:
            org.apache.http.StatusLine r3 = r7.getStatusLine()
            org.apache.http.ProtocolVersion r3 = r3.getProtocolVersion()
            java.lang.String r4 = "Transfer-Encoding"
            org.apache.http.Header r4 = r7.getFirstHeader(r4)
            r5 = 1
            if (r4 == 0) goto L51
            java.lang.String r8 = r4.getValue()
            java.lang.String r4 = "chunked"
            boolean r8 = r4.equalsIgnoreCase(r8)
            if (r8 != 0) goto L6d
            return r2
        L51:
            boolean r8 = r6.canResponseHaveBody(r8, r7)
            if (r8 == 0) goto L6d
            java.lang.String r8 = "Content-Length"
            org.apache.http.Header[] r8 = r7.getHeaders(r8)
            int r4 = r8.length
            if (r4 != r5) goto L6c
            r8 = r8[r2]
            java.lang.String r8 = r8.getValue()     // Catch: java.lang.NumberFormatException -> L6c
            int r8 = java.lang.Integer.parseInt(r8)     // Catch: java.lang.NumberFormatException -> L6c
            if (r8 >= 0) goto L6d
        L6c:
            return r2
        L6d:
            org.apache.http.HeaderIterator r8 = r7.headerIterator(r1)
            boolean r1 = r8.hasNext()
            if (r1 != 0) goto L7d
            java.lang.String r8 = "Proxy-Connection"
            org.apache.http.HeaderIterator r8 = r7.headerIterator(r8)
        L7d:
            boolean r7 = r8.hasNext()
            if (r7 == 0) goto La8
            org.apache.http.message.BasicTokenIterator r7 = new org.apache.http.message.BasicTokenIterator     // Catch: org.apache.http.ParseException -> La7
            r7.<init>(r8)     // Catch: org.apache.http.ParseException -> La7
            r8 = r2
        L89:
            boolean r1 = r7.hasNext()     // Catch: org.apache.http.ParseException -> La7
            if (r1 == 0) goto La4
            java.lang.String r1 = r7.nextToken()     // Catch: org.apache.http.ParseException -> La7
            boolean r4 = r0.equalsIgnoreCase(r1)     // Catch: org.apache.http.ParseException -> La7
            if (r4 == 0) goto L9a
            return r2
        L9a:
            java.lang.String r4 = "Keep-Alive"
            boolean r1 = r4.equalsIgnoreCase(r1)     // Catch: org.apache.http.ParseException -> La7
            if (r1 == 0) goto L89
            r8 = r5
            goto L89
        La4:
            if (r8 == 0) goto La8
            return r5
        La7:
            return r2
        La8:
            org.apache.http.HttpVersion r7 = org.apache.http.HttpVersion.HTTP_1_0
            boolean r7 = r3.lessEquals(r7)
            r7 = r7 ^ r5
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.DefaultConnectionReuseStrategy.keepAlive(org.apache.http.HttpResponse, org.apache.http.protocol.HttpContext):boolean");
    }
}