package org.apache.http.impl.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.AuthCache;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes3.dex */
public class BasicAuthCache implements AuthCache {
    private final a log;
    private final Map<HttpHost, byte[]> map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache(SchemePortResolver schemePortResolver) {
        this.log = h.n(getClass());
        this.map = new ConcurrentHashMap();
        this.schemePortResolver = schemePortResolver == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver;
    }

    @Override // org.apache.http.client.AuthCache
    public void clear() {
        this.map.clear();
    }

    @Override // org.apache.http.client.AuthCache
    public AuthScheme get(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        byte[] bArr = this.map.get(getKey(httpHost));
        if (bArr != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                AuthScheme authScheme = (AuthScheme) objectInputStream.readObject();
                objectInputStream.close();
                return authScheme;
            } catch (IOException e2) {
                if (this.log.c()) {
                    this.log.h("Unexpected I/O error while de-serializing auth scheme", e2);
                }
            } catch (ClassNotFoundException e3) {
                if (this.log.c()) {
                    this.log.h("Unexpected error while de-serializing auth scheme", e3);
                }
                return null;
            }
        }
        return null;
    }

    protected HttpHost getKey(HttpHost httpHost) {
        if (httpHost.getPort() <= 0) {
            try {
                return new HttpHost(httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpHost.getSchemeName());
            } catch (UnsupportedSchemeException unused) {
            }
        }
        return httpHost;
    }

    @Override // org.apache.http.client.AuthCache
    public void put(HttpHost httpHost, AuthScheme authScheme) {
        Args.notNull(httpHost, "HTTP host");
        if (authScheme == null) {
            return;
        }
        if (authScheme instanceof Serializable) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(authScheme);
                objectOutputStream.close();
                this.map.put(getKey(httpHost), byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                if (this.log.c()) {
                    this.log.h("Unexpected I/O error while serializing auth scheme", e2);
                }
            }
        } else if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Auth scheme " + authScheme.getClass() + " is not serializable");
        }
    }

    @Override // org.apache.http.client.AuthCache
    public void remove(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.map.remove(getKey(httpHost));
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicAuthCache() {
        this(null);
    }
}