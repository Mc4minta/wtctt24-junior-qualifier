package org.spongycastle.crypto.tls;

import java.io.IOException;
import okhttp3.internal.http2.Settings;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public final class ProtocolVersion {
    private String name;
    private int version;
    public static final ProtocolVersion SSLv3 = new ProtocolVersion(768, "SSL 3.0");
    public static final ProtocolVersion TLSv10 = new ProtocolVersion(769, "TLS 1.0");
    public static final ProtocolVersion TLSv11 = new ProtocolVersion(770, "TLS 1.1");
    public static final ProtocolVersion TLSv12 = new ProtocolVersion(771, "TLS 1.2");
    public static final ProtocolVersion DTLSv10 = new ProtocolVersion(65279, "DTLS 1.0");
    public static final ProtocolVersion DTLSv12 = new ProtocolVersion(65277, "DTLS 1.2");

    private ProtocolVersion(int i2, String str) {
        this.version = i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.name = str;
    }

    public static ProtocolVersion get(int i2, int i3) throws IOException {
        if (i2 != 3) {
            if (i2 == 254) {
                switch (i3) {
                    case 253:
                        return DTLSv12;
                    case 254:
                        throw new TlsFatalAlert((short) 47);
                    case 255:
                        return DTLSv10;
                    default:
                        return getUnknownVersion(i2, i3, "DTLS");
                }
            }
            throw new TlsFatalAlert((short) 47);
        } else if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return getUnknownVersion(i2, i3, "TLS");
                    }
                    return TLSv12;
                }
                return TLSv11;
            }
            return TLSv10;
        } else {
            return SSLv3;
        }
    }

    private static ProtocolVersion getUnknownVersion(int i2, int i3, String str) throws IOException {
        TlsUtils.checkUint8(i2);
        TlsUtils.checkUint8(i3);
        int i4 = (i2 << 8) | i3;
        String upperCase = Strings.toUpperCase(Integer.toHexString(65536 | i4).substring(1));
        return new ProtocolVersion(i4, str + " 0x" + upperCase);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ProtocolVersion) && equals((ProtocolVersion) obj));
    }

    public ProtocolVersion getEquivalentTLSVersion() {
        if (isDTLS()) {
            if (this == DTLSv10) {
                return TLSv11;
            }
            return TLSv12;
        }
        return this;
    }

    public int getFullVersion() {
        return this.version;
    }

    public int getMajorVersion() {
        return this.version >> 8;
    }

    public int getMinorVersion() {
        return this.version & 255;
    }

    public int hashCode() {
        return this.version;
    }

    public boolean isDTLS() {
        return getMajorVersion() == 254;
    }

    public boolean isEqualOrEarlierVersionOf(ProtocolVersion protocolVersion) {
        if (getMajorVersion() != protocolVersion.getMajorVersion()) {
            return false;
        }
        int minorVersion = protocolVersion.getMinorVersion() - getMinorVersion();
        if (isDTLS()) {
            if (minorVersion > 0) {
                return false;
            }
        } else if (minorVersion < 0) {
            return false;
        }
        return true;
    }

    public boolean isLaterVersionOf(ProtocolVersion protocolVersion) {
        if (getMajorVersion() != protocolVersion.getMajorVersion()) {
            return false;
        }
        int minorVersion = protocolVersion.getMinorVersion() - getMinorVersion();
        if (isDTLS()) {
            if (minorVersion <= 0) {
                return false;
            }
        } else if (minorVersion >= 0) {
            return false;
        }
        return true;
    }

    public boolean isSSL() {
        return this == SSLv3;
    }

    public boolean isTLS() {
        return getMajorVersion() == 3;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(ProtocolVersion protocolVersion) {
        return protocolVersion != null && this.version == protocolVersion.version;
    }
}