package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: classes3.dex */
public class BrowserCompatSpec extends CookieSpecBase {
    private static final String[] DEFAULT_DATE_PATTERNS = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BrowserCompatSpec(java.lang.String[] r4, org.apache.http.impl.cookie.BrowserCompatSpecFactory.SecurityLevel r5) {
        /*
            r3 = this;
            r0 = 7
            org.apache.http.cookie.CommonCookieAttributeHandler[] r0 = new org.apache.http.cookie.CommonCookieAttributeHandler[r0]
            org.apache.http.impl.cookie.BrowserCompatVersionAttributeHandler r1 = new org.apache.http.impl.cookie.BrowserCompatVersionAttributeHandler
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            org.apache.http.impl.cookie.BasicDomainHandler r1 = new org.apache.http.impl.cookie.BasicDomainHandler
            r1.<init>()
            r2 = 1
            r0[r2] = r1
            org.apache.http.impl.cookie.BrowserCompatSpecFactory$SecurityLevel r1 = org.apache.http.impl.cookie.BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_IE_MEDIUM
            if (r5 != r1) goto L1d
            org.apache.http.impl.cookie.BrowserCompatSpec$1 r5 = new org.apache.http.impl.cookie.BrowserCompatSpec$1
            r5.<init>()
            goto L22
        L1d:
            org.apache.http.impl.cookie.BasicPathHandler r5 = new org.apache.http.impl.cookie.BasicPathHandler
            r5.<init>()
        L22:
            r1 = 2
            r0[r1] = r5
            r5 = 3
            org.apache.http.impl.cookie.BasicMaxAgeHandler r1 = new org.apache.http.impl.cookie.BasicMaxAgeHandler
            r1.<init>()
            r0[r5] = r1
            r5 = 4
            org.apache.http.impl.cookie.BasicSecureHandler r1 = new org.apache.http.impl.cookie.BasicSecureHandler
            r1.<init>()
            r0[r5] = r1
            r5 = 5
            org.apache.http.impl.cookie.BasicCommentHandler r1 = new org.apache.http.impl.cookie.BasicCommentHandler
            r1.<init>()
            r0[r5] = r1
            r5 = 6
            org.apache.http.impl.cookie.BasicExpiresHandler r1 = new org.apache.http.impl.cookie.BasicExpiresHandler
            if (r4 == 0) goto L49
            java.lang.Object r4 = r4.clone()
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L4b
        L49:
            java.lang.String[] r4 = org.apache.http.impl.cookie.BrowserCompatSpec.DEFAULT_DATE_PATTERNS
        L4b:
            r1.<init>(r4)
            r0[r5] = r1
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.cookie.BrowserCompatSpec.<init>(java.lang.String[], org.apache.http.impl.cookie.BrowserCompatSpecFactory$SecurityLevel):void");
    }

    private static boolean isQuoteEnclosed(String str) {
        return str != null && str.startsWith("\"") && str.endsWith("\"");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> list) {
        Args.notEmpty(list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
        charArrayBuffer.append(SM.COOKIE);
        charArrayBuffer.append(": ");
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cookie cookie = list.get(i2);
            if (i2 > 0) {
                charArrayBuffer.append("; ");
            }
            String name = cookie.getName();
            String value = cookie.getValue();
            if (cookie.getVersion() > 0 && !isQuoteEnclosed(value)) {
                BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(charArrayBuffer, (HeaderElement) new BasicHeaderElement(name, value), false);
            } else {
                charArrayBuffer.append(name);
                charArrayBuffer.append("=");
                if (value != null) {
                    charArrayBuffer.append(value);
                }
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return 0;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        CharArrayBuffer charArrayBuffer;
        ParserCursor parserCursor;
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (header.getName().equalsIgnoreCase(SM.SET_COOKIE)) {
            HeaderElement[] elements = header.getElements();
            boolean z = false;
            boolean z2 = false;
            for (HeaderElement headerElement : elements) {
                if (headerElement.getParameterByName(ClientCookie.VERSION_ATTR) != null) {
                    z2 = true;
                }
                if (headerElement.getParameterByName(ClientCookie.EXPIRES_ATTR) != null) {
                    z = true;
                }
            }
            if (!z && z2) {
                return parse(elements, cookieOrigin);
            }
            NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
            if (header instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) header;
                charArrayBuffer = formattedHeader.getBuffer();
                parserCursor = new ParserCursor(formattedHeader.getValuePos(), charArrayBuffer.length());
            } else {
                String value = header.getValue();
                if (value != null) {
                    charArrayBuffer = new CharArrayBuffer(value.length());
                    charArrayBuffer.append(value);
                    parserCursor = new ParserCursor(0, charArrayBuffer.length());
                } else {
                    throw new MalformedCookieException("Header value is null");
                }
            }
            HeaderElement parseHeader = netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor);
            String name = parseHeader.getName();
            String value2 = parseHeader.getValue();
            if (name != null && !name.isEmpty()) {
                BasicClientCookie basicClientCookie = new BasicClientCookie(name, value2);
                basicClientCookie.setPath(CookieSpecBase.getDefaultPath(cookieOrigin));
                basicClientCookie.setDomain(CookieSpecBase.getDefaultDomain(cookieOrigin));
                NameValuePair[] parameters = parseHeader.getParameters();
                for (int length = parameters.length - 1; length >= 0; length--) {
                    NameValuePair nameValuePair = parameters[length];
                    String lowerCase = nameValuePair.getName().toLowerCase(Locale.ROOT);
                    basicClientCookie.setAttribute(lowerCase, nameValuePair.getValue());
                    CookieAttributeHandler findAttribHandler = findAttribHandler(lowerCase);
                    if (findAttribHandler != null) {
                        findAttribHandler.parse(basicClientCookie, nameValuePair.getValue());
                    }
                }
                if (z) {
                    basicClientCookie.setVersion(0);
                }
                return Collections.singletonList(basicClientCookie);
            }
            throw new MalformedCookieException("Cookie name may not be empty");
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
    }

    public String toString() {
        return "compatibility";
    }

    public BrowserCompatSpec(String[] strArr) {
        this(strArr, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec() {
        this(null, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }
}