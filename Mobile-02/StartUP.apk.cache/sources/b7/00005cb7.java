package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes3.dex */
class SocketFactoryAdaptor implements SocketFactory {
    private final SchemeSocketFactory factory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketFactoryAdaptor(SchemeSocketFactory schemeSocketFactory) {
        this.factory = schemeSocketFactory;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i2, InetAddress inetAddress, int i3, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
        InetSocketAddress inetSocketAddress;
        if (inetAddress != null || i3 > 0) {
            if (i3 <= 0) {
                i3 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i3);
        } else {
            inetSocketAddress = null;
        }
        return this.factory.connectSocket(socket, new InetSocketAddress(InetAddress.getByName(str), i2), inetSocketAddress, httpParams);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.factory.createSocket(new BasicHttpParams());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SocketFactoryAdaptor) {
            return this.factory.equals(((SocketFactoryAdaptor) obj).factory);
        }
        return this.factory.equals(obj);
    }

    public SchemeSocketFactory getFactory() {
        return this.factory;
    }

    public int hashCode() {
        return this.factory.hashCode();
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return this.factory.isSecure(socket);
    }
}