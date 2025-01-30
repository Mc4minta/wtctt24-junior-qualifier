package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.logging.a;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

/* loaded from: classes3.dex */
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private final a headerlog;
    private final a log;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String str, a aVar, a aVar2, a aVar3, int i2, int i3, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(str, i2, i3, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.log = aVar;
        this.headerlog = aVar2;
        this.wire = new Wire(aVar3, str);
    }

    @Override // org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (super.isOpen()) {
            if (this.log.d()) {
                a aVar = this.log;
                aVar.a(getId() + ": Close connection");
            }
            super.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.BHttpConnectionBase
    public InputStream getSocketInputStream(Socket socket) throws IOException {
        InputStream socketInputStream = super.getSocketInputStream(socket);
        return this.wire.enabled() ? new LoggingInputStream(socketInputStream, this.wire) : socketInputStream;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.BHttpConnectionBase
    public OutputStream getSocketOutputStream(Socket socket) throws IOException {
        OutputStream socketOutputStream = super.getSocketOutputStream(socket);
        return this.wire.enabled() ? new LoggingOutputStream(socketOutputStream, this.wire) : socketOutputStream;
    }

    @Override // org.apache.http.impl.DefaultBHttpClientConnection
    protected void onRequestSubmitted(HttpRequest httpRequest) {
        Header[] allHeaders;
        if (httpRequest == null || !this.headerlog.d()) {
            return;
        }
        this.headerlog.a(getId() + " >> " + httpRequest.getRequestLine().toString());
        for (Header header : httpRequest.getAllHeaders()) {
            this.headerlog.a(getId() + " >> " + header.toString());
        }
    }

    @Override // org.apache.http.impl.DefaultBHttpClientConnection
    protected void onResponseReceived(HttpResponse httpResponse) {
        Header[] allHeaders;
        if (httpResponse == null || !this.headerlog.d()) {
            return;
        }
        this.headerlog.a(getId() + " << " + httpResponse.getStatusLine().toString());
        for (Header header : httpResponse.getAllHeaders()) {
            this.headerlog.a(getId() + " << " + header.toString());
        }
    }

    @Override // org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection
    public void setSocketTimeout(int i2) {
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a(getId() + ": set socket timeout to " + i2);
        }
        super.setSocketTimeout(i2);
    }

    @Override // org.apache.http.impl.conn.DefaultManagedHttpClientConnection, org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a(getId() + ": Shutdown connection");
        }
        super.shutdown();
    }
}