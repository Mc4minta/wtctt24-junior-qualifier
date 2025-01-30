package org.apache.http.impl.conn;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.params.ConnConnectionPNames;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes3.dex */
public class DefaultResponseParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf;
    private final a log;
    private final int maxGarbageLines;
    private final HttpResponseFactory responseFactory;

    public DefaultResponseParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        this.log = h.n(getClass());
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
        this.lineBuf = new CharArrayBuffer(128);
        this.maxGarbageLines = getMaxGarbageLines(httpParams);
    }

    protected int getMaxGarbageLines(HttpParams httpParams) {
        return httpParams.getIntParameter(ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
        throw new org.apache.http.ProtocolException("The server failed to respond with a valid HTTP response");
     */
    @Override // org.apache.http.impl.io.AbstractMessageParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected org.apache.http.HttpMessage parseHead(org.apache.http.io.SessionInputBuffer r8) throws java.io.IOException, org.apache.http.HttpException {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L2:
            org.apache.http.util.CharArrayBuffer r2 = r7.lineBuf
            r2.clear()
            org.apache.http.util.CharArrayBuffer r2 = r7.lineBuf
            int r2 = r8.readLine(r2)
            r3 = -1
            if (r2 != r3) goto L1b
            if (r1 == 0) goto L13
            goto L1b
        L13:
            org.apache.http.NoHttpResponseException r8 = new org.apache.http.NoHttpResponseException
            java.lang.String r0 = "The target server failed to respond"
            r8.<init>(r0)
            throw r8
        L1b:
            org.apache.http.message.ParserCursor r4 = new org.apache.http.message.ParserCursor
            org.apache.http.util.CharArrayBuffer r5 = r7.lineBuf
            int r5 = r5.length()
            r4.<init>(r0, r5)
            org.apache.http.message.LineParser r5 = r7.lineParser
            org.apache.http.util.CharArrayBuffer r6 = r7.lineBuf
            boolean r5 = r5.hasProtocolVersion(r6, r4)
            if (r5 == 0) goto L40
            org.apache.http.message.LineParser r8 = r7.lineParser
            org.apache.http.util.CharArrayBuffer r0 = r7.lineBuf
            org.apache.http.StatusLine r8 = r8.parseStatusLine(r0, r4)
            org.apache.http.HttpResponseFactory r0 = r7.responseFactory
            r1 = 0
            org.apache.http.HttpResponse r8 = r0.newHttpResponse(r8, r1)
            return r8
        L40:
            if (r2 == r3) goto L6d
            int r2 = r7.maxGarbageLines
            if (r1 >= r2) goto L6d
            org.apache.commons.logging.a r2 = r7.log
            boolean r2 = r2.d()
            if (r2 == 0) goto L6a
            org.apache.commons.logging.a r2 = r7.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Garbage in response: "
            r3.append(r4)
            org.apache.http.util.CharArrayBuffer r4 = r7.lineBuf
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.a(r3)
        L6a:
            int r1 = r1 + 1
            goto L2
        L6d:
            org.apache.http.ProtocolException r8 = new org.apache.http.ProtocolException
            java.lang.String r0 = "The server failed to respond with a valid HTTP response"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.DefaultResponseParser.parseHead(org.apache.http.io.SessionInputBuffer):org.apache.http.HttpMessage");
    }
}