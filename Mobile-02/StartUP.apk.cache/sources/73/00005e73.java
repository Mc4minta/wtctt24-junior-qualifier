package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpStatus;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes3.dex */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    /* loaded from: classes3.dex */
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        @Override // org.apache.http.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return ((httpRequest != null && HttpHead.METHOD_NAME.equalsIgnoreCase(httpRequest.getRequestLine().getMethod())) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    protected void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler lookup = this.handlerMapper != null ? this.handlerMapper.lookup(httpRequest) : null;
        if (lookup != null) {
            lookup.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        }
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    protected void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleRequest(org.apache.http.HttpServerConnection r9, org.apache.http.protocol.HttpContext r10) throws java.io.IOException, org.apache.http.HttpException {
        /*
            r8 = this;
            java.lang.String r0 = "http.connection"
            r10.setAttribute(r0, r9)
            r0 = 500(0x1f4, float:7.0E-43)
            r1 = 0
            org.apache.http.HttpRequest r2 = r9.receiveRequestHeader()     // Catch: org.apache.http.HttpException -> L83
            boolean r3 = r2 instanceof org.apache.http.HttpEntityEnclosingRequest     // Catch: org.apache.http.HttpException -> L81
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == 0) goto L5b
            r3 = r2
            org.apache.http.HttpEntityEnclosingRequest r3 = (org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: org.apache.http.HttpException -> L81
            boolean r3 = r3.expectContinue()     // Catch: org.apache.http.HttpException -> L81
            if (r3 == 0) goto L55
            org.apache.http.HttpResponseFactory r3 = r8.responseFactory     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.HttpVersion r5 = org.apache.http.HttpVersion.HTTP_1_1     // Catch: org.apache.http.HttpException -> L81
            r6 = 100
            org.apache.http.HttpResponse r3 = r3.newHttpResponse(r5, r6, r10)     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.protocol.HttpExpectationVerifier r5 = r8.expectationVerifier     // Catch: org.apache.http.HttpException -> L81
            if (r5 == 0) goto L3c
            org.apache.http.protocol.HttpExpectationVerifier r5 = r8.expectationVerifier     // Catch: org.apache.http.HttpException -> L2f
            r5.verify(r2, r3, r10)     // Catch: org.apache.http.HttpException -> L2f
            goto L3c
        L2f:
            r3 = move-exception
            org.apache.http.HttpResponseFactory r5 = r8.responseFactory     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.HttpVersion r6 = org.apache.http.HttpVersion.HTTP_1_0     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.HttpResponse r5 = r5.newHttpResponse(r6, r0, r10)     // Catch: org.apache.http.HttpException -> L81
            r8.handleException(r3, r5)     // Catch: org.apache.http.HttpException -> L81
            r3 = r5
        L3c:
            org.apache.http.StatusLine r5 = r3.getStatusLine()     // Catch: org.apache.http.HttpException -> L81
            int r5 = r5.getStatusCode()     // Catch: org.apache.http.HttpException -> L81
            if (r5 >= r4) goto L53
            r9.sendResponseHeader(r3)     // Catch: org.apache.http.HttpException -> L81
            r9.flush()     // Catch: org.apache.http.HttpException -> L81
            r3 = r2
            org.apache.http.HttpEntityEnclosingRequest r3 = (org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: org.apache.http.HttpException -> L81
            r9.receiveRequestEntity(r3)     // Catch: org.apache.http.HttpException -> L81
            goto L5b
        L53:
            r1 = r3
            goto L5b
        L55:
            r3 = r2
            org.apache.http.HttpEntityEnclosingRequest r3 = (org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: org.apache.http.HttpException -> L81
            r9.receiveRequestEntity(r3)     // Catch: org.apache.http.HttpException -> L81
        L5b:
            java.lang.String r3 = "http.request"
            r10.setAttribute(r3, r2)     // Catch: org.apache.http.HttpException -> L81
            if (r1 != 0) goto L72
            org.apache.http.HttpResponseFactory r1 = r8.responseFactory     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.HttpVersion r3 = org.apache.http.HttpVersion.HTTP_1_1     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.HttpResponse r1 = r1.newHttpResponse(r3, r4, r10)     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.protocol.HttpProcessor r3 = r8.processor     // Catch: org.apache.http.HttpException -> L81
            r3.process(r2, r10)     // Catch: org.apache.http.HttpException -> L81
            r8.doService(r2, r1, r10)     // Catch: org.apache.http.HttpException -> L81
        L72:
            boolean r3 = r2 instanceof org.apache.http.HttpEntityEnclosingRequest     // Catch: org.apache.http.HttpException -> L81
            if (r3 == 0) goto L93
            r3 = r2
            org.apache.http.HttpEntityEnclosingRequest r3 = (org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.HttpEntity r3 = r3.getEntity()     // Catch: org.apache.http.HttpException -> L81
            org.apache.http.util.EntityUtils.consume(r3)     // Catch: org.apache.http.HttpException -> L81
            goto L93
        L81:
            r1 = move-exception
            goto L87
        L83:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L87:
            org.apache.http.HttpResponseFactory r3 = r8.responseFactory
            org.apache.http.HttpVersion r4 = org.apache.http.HttpVersion.HTTP_1_0
            org.apache.http.HttpResponse r0 = r3.newHttpResponse(r4, r0, r10)
            r8.handleException(r1, r0)
            r1 = r0
        L93:
            java.lang.String r0 = "http.response"
            r10.setAttribute(r0, r1)
            org.apache.http.protocol.HttpProcessor r0 = r8.processor
            r0.process(r1, r10)
            r9.sendResponseHeader(r1)
            boolean r0 = r8.canResponseHaveBody(r2, r1)
            if (r0 == 0) goto La9
            r9.sendResponseEntity(r1)
        La9:
            r9.flush()
            org.apache.http.ConnectionReuseStrategy r0 = r8.connStrategy
            boolean r10 = r0.keepAlive(r1, r10)
            if (r10 != 0) goto Lb7
            r9.close()
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.protocol.HttpService.handleRequest(org.apache.http.HttpServerConnection, org.apache.http.protocol.HttpContext):void");
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }
}