package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.x500.X500Name;

/* loaded from: classes3.dex */
public class CertificateRequest {
    protected Vector certificateAuthorities;
    protected short[] certificateTypes;
    protected Vector supportedSignatureAlgorithms;

    public CertificateRequest(short[] sArr, Vector vector, Vector vector2) {
        this.certificateTypes = sArr;
        this.supportedSignatureAlgorithms = vector;
        this.certificateAuthorities = vector2;
    }

    public static CertificateRequest parse(TlsContext tlsContext, InputStream inputStream) throws IOException {
        int readUint8 = TlsUtils.readUint8(inputStream);
        short[] sArr = new short[readUint8];
        for (int i2 = 0; i2 < readUint8; i2++) {
            sArr[i2] = TlsUtils.readUint8(inputStream);
        }
        Vector parseSupportedSignatureAlgorithms = TlsUtils.isTLSv12(tlsContext) ? TlsUtils.parseSupportedSignatureAlgorithms(false, inputStream) : null;
        Vector vector = new Vector();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(TlsUtils.readOpaque16(inputStream));
        while (byteArrayInputStream.available() > 0) {
            vector.addElement(X500Name.getInstance(TlsUtils.readDERObject(TlsUtils.readOpaque16(byteArrayInputStream))));
        }
        return new CertificateRequest(sArr, parseSupportedSignatureAlgorithms, vector);
    }

    public void encode(OutputStream outputStream) throws IOException {
        short[] sArr = this.certificateTypes;
        if (sArr != null && sArr.length != 0) {
            TlsUtils.writeUint8ArrayWithUint8Length(sArr, outputStream);
        } else {
            TlsUtils.writeUint8(0, outputStream);
        }
        Vector vector = this.supportedSignatureAlgorithms;
        if (vector != null) {
            TlsUtils.encodeSupportedSignatureAlgorithms(vector, false, outputStream);
        }
        Vector vector2 = this.certificateAuthorities;
        if (vector2 != null && !vector2.isEmpty()) {
            Vector vector3 = new Vector(this.certificateAuthorities.size());
            int i2 = 0;
            for (int i3 = 0; i3 < this.certificateAuthorities.size(); i3++) {
                byte[] encoded = ((X500Name) this.certificateAuthorities.elementAt(i3)).getEncoded(ASN1Encoding.DER);
                vector3.addElement(encoded);
                i2 += encoded.length + 2;
            }
            TlsUtils.checkUint16(i2);
            TlsUtils.writeUint16(i2, outputStream);
            for (int i4 = 0; i4 < vector3.size(); i4++) {
                TlsUtils.writeOpaque16((byte[]) vector3.elementAt(i4), outputStream);
            }
            return;
        }
        TlsUtils.writeUint16(0, outputStream);
    }

    public Vector getCertificateAuthorities() {
        return this.certificateAuthorities;
    }

    public short[] getCertificateTypes() {
        return this.certificateTypes;
    }

    public Vector getSupportedSignatureAlgorithms() {
        return this.supportedSignatureAlgorithms;
    }
}