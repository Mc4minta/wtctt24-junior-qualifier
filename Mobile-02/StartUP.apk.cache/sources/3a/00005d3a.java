package org.apache.http.impl.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthCache;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList("Negotiate", "Kerberos", "NTLM", AuthSchemes.CREDSSP, "Digest", "Basic"));
    private final int challengeCode;
    private final String headerName;
    private final a log = h.n(getClass());

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthenticationStrategyImpl(int i2, String str) {
        this.challengeCode = i2;
        this.headerName = str;
    }

    @Override // org.apache.http.client.AuthenticationStrategy
    public void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(httpContext, "HTTP context");
        AuthCache authCache = HttpClientContext.adapt(httpContext).getAuthCache();
        if (authCache != null) {
            if (this.log.d()) {
                a aVar = this.log;
                aVar.a("Clearing cached auth scheme for " + httpHost);
            }
            authCache.remove(httpHost);
        }
    }

    @Override // org.apache.http.client.AuthenticationStrategy
    public void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        if (isCachable(authScheme)) {
            AuthCache authCache = adapt.getAuthCache();
            if (authCache == null) {
                authCache = new BasicAuthCache();
                adapt.setAuthCache(authCache);
            }
            if (this.log.d()) {
                a aVar = this.log;
                aVar.a("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            authCache.put(httpHost, authScheme);
        }
    }

    @Override // org.apache.http.client.AuthenticationStrategy
    public Map<String, Header> getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        CharArrayBuffer charArrayBuffer;
        int i2;
        Args.notNull(httpResponse, "HTTP response");
        Header[] headers = httpResponse.getHeaders(this.headerName);
        HashMap hashMap = new HashMap(headers.length);
        for (Header header : headers) {
            if (header instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) header;
                charArrayBuffer = formattedHeader.getBuffer();
                i2 = formattedHeader.getValuePos();
            } else {
                String value = header.getValue();
                if (value != null) {
                    charArrayBuffer = new CharArrayBuffer(value.length());
                    charArrayBuffer.append(value);
                    i2 = 0;
                } else {
                    throw new MalformedChallengeException("Header value is null");
                }
            }
            while (i2 < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
                i2++;
            }
            int i3 = i2;
            while (i3 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i3))) {
                i3++;
            }
            hashMap.put(charArrayBuffer.substring(i2, i3).toLowerCase(Locale.ROOT), header);
        }
        return hashMap;
    }

    abstract Collection<String> getPreferredAuthSchemes(RequestConfig requestConfig);

    @Override // org.apache.http.client.AuthenticationStrategy
    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == this.challengeCode;
    }

    protected boolean isCachable(AuthScheme authScheme) {
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        return authScheme.getSchemeName().equalsIgnoreCase("Basic");
    }

    @Override // org.apache.http.client.AuthenticationStrategy
    public Queue<AuthOption> select(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(map, "Map of auth challenges");
        Args.notNull(httpHost, "Host");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        LinkedList linkedList = new LinkedList();
        Lookup<AuthSchemeProvider> authSchemeRegistry = adapt.getAuthSchemeRegistry();
        if (authSchemeRegistry == null) {
            this.log.a("Auth scheme registry not set in the context");
            return linkedList;
        }
        CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
        if (credentialsProvider == null) {
            this.log.a("Credentials provider not set in the context");
            return linkedList;
        }
        Collection<String> preferredAuthSchemes = getPreferredAuthSchemes(adapt.getRequestConfig());
        if (preferredAuthSchemes == null) {
            preferredAuthSchemes = DEFAULT_SCHEME_PRIORITY;
        }
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Authentication schemes in the order of preference: " + preferredAuthSchemes);
        }
        for (String str : preferredAuthSchemes) {
            Header header = map.get(str.toLowerCase(Locale.ROOT));
            if (header != null) {
                AuthSchemeProvider lookup = authSchemeRegistry.lookup(str);
                if (lookup == null) {
                    if (this.log.c()) {
                        a aVar2 = this.log;
                        aVar2.j("Authentication scheme " + str + " not supported");
                    }
                } else {
                    AuthScheme create = lookup.create(httpContext);
                    create.processChallenge(header);
                    Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost, create.getRealm(), create.getSchemeName()));
                    if (credentials != null) {
                        linkedList.add(new AuthOption(create, credentials));
                    }
                }
            } else if (this.log.d()) {
                a aVar3 = this.log;
                aVar3.a("Challenge for " + str + " authentication scheme not available");
            }
        }
        return linkedList;
    }
}