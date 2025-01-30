package org.apache.http.impl.auth;

import java.io.IOException;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

@Deprecated
/* loaded from: classes3.dex */
public class NegotiateScheme extends GGSSchemeBase {
    private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
    private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
    private final a log;
    private final SpnegoTokenGenerator spengoGenerator;

    public NegotiateScheme(SpnegoTokenGenerator spnegoTokenGenerator, boolean z) {
        super(z);
        this.log = h.n(getClass());
        this.spengoGenerator = spnegoTokenGenerator;
    }

    @Override // org.apache.http.impl.auth.GGSSchemeBase, org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.auth.GGSSchemeBase
    public byte[] generateToken(byte[] bArr, String str) throws GSSException {
        return super.generateToken(bArr, str);
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getParameter(String str) {
        Args.notNull(str, "Parameter name");
        return null;
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getRealm() {
        return null;
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "Negotiate";
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return true;
    }

    @Override // org.apache.http.impl.auth.GGSSchemeBase, org.apache.http.impl.auth.AuthSchemeBase, org.apache.http.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return super.authenticate(credentials, httpRequest, httpContext);
    }

    @Override // org.apache.http.impl.auth.GGSSchemeBase
    protected byte[] generateToken(byte[] bArr, String str, Credentials credentials) throws GSSException {
        boolean z;
        SpnegoTokenGenerator spnegoTokenGenerator;
        try {
            bArr = generateGSSToken(bArr, new Oid(SPNEGO_OID), str, credentials);
            z = false;
        } catch (GSSException e2) {
            if (e2.getMajor() == 2) {
                this.log.a("GSSException BAD_MECH, retry with Kerberos MECH");
                z = true;
            } else {
                throw e2;
            }
        }
        if (z) {
            this.log.a("Using Kerberos MECH 1.2.840.113554.1.2.2");
            byte[] generateGSSToken = generateGSSToken(bArr, new Oid(KERBEROS_OID), str, credentials);
            if (generateGSSToken == null || (spnegoTokenGenerator = this.spengoGenerator) == null) {
                return generateGSSToken;
            }
            try {
                return spnegoTokenGenerator.generateSpnegoDERObject(generateGSSToken);
            } catch (IOException e3) {
                this.log.i(e3.getMessage(), e3);
                return generateGSSToken;
            }
        }
        return bArr;
    }

    public NegotiateScheme(SpnegoTokenGenerator spnegoTokenGenerator) {
        this(spnegoTokenGenerator, false);
    }

    public NegotiateScheme() {
        this(null, false);
    }
}