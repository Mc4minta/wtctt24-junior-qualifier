package org.apache.http.impl.execchain;

import java.io.IOException;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes3.dex */
public class RetryExec implements ClientExecChain {
    private final a log = h.n(getClass());
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientExecChain, HttpRequestRetryHandler httpRequestRetryHandler) {
        Args.notNull(clientExecChain, "HTTP request executor");
        Args.notNull(httpRequestRetryHandler, "HTTP request retry handler");
        this.requestExecutor = clientExecChain;
        this.retryHandler = httpRequestRetryHandler;
    }

    @Override // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        Header[] allHeaders = httpRequestWrapper.getAllHeaders();
        int i2 = 1;
        while (true) {
            try {
                return this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            } catch (IOException e2) {
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    this.log.a("Request has been aborted");
                    throw e2;
                } else if (this.retryHandler.retryRequest(e2, i2, httpClientContext)) {
                    if (this.log.f()) {
                        a aVar = this.log;
                        aVar.g("I/O exception (" + e2.getClass().getName() + ") caught when processing request to " + httpRoute + ": " + e2.getMessage());
                    }
                    if (this.log.d()) {
                        this.log.b(e2.getMessage(), e2);
                    }
                    if (RequestEntityProxy.isRepeatable(httpRequestWrapper)) {
                        httpRequestWrapper.setHeaders(allHeaders);
                        if (this.log.f()) {
                            a aVar2 = this.log;
                            aVar2.g("Retrying request to " + httpRoute);
                        }
                        i2++;
                    } else {
                        this.log.a("Cannot retry non-repeatable request");
                        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", e2);
                    }
                } else if (e2 instanceof NoHttpResponseException) {
                    NoHttpResponseException noHttpResponseException = new NoHttpResponseException(httpRoute.getTargetHost().toHostString() + " failed to respond");
                    noHttpResponseException.setStackTrace(e2.getStackTrace());
                    throw noHttpResponseException;
                } else {
                    throw e2;
                }
            }
        }
    }
}