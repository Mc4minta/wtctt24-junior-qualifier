package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.params.HttpParams;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes3.dex */
public class SchemeLayeredSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor implements SchemeLayeredSocketFactory {
    private final LayeredSocketFactory factory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory layeredSocketFactory) {
        super(layeredSocketFactory);
        this.factory = layeredSocketFactory;
    }

    @Override // org.apache.http.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket socket, String str, int i2, HttpParams httpParams) throws IOException, UnknownHostException {
        return this.factory.createSocket(socket, str, i2, true);
    }
}