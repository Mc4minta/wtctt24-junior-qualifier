package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ocsp.ResponderID;
import org.spongycastle.asn1.x509.Extensions;

/* loaded from: classes3.dex */
public class OCSPStatusRequest {
    protected Extensions requestExtensions;
    protected Vector responderIDList;

    public OCSPStatusRequest(Vector vector, Extensions extensions) {
        this.responderIDList = vector;
        this.requestExtensions = extensions;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.spongycastle.crypto.tls.OCSPStatusRequest parse(java.io.InputStream r3) throws java.io.IOException {
        /*
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            int r1 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r3)
            if (r1 <= 0) goto L29
            byte[] r1 = org.spongycastle.crypto.tls.TlsUtils.readFully(r1, r3)
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r1)
        L14:
            byte[] r1 = org.spongycastle.crypto.tls.TlsUtils.readOpaque16(r2)
            org.spongycastle.asn1.ASN1Primitive r1 = org.spongycastle.crypto.tls.TlsUtils.readDERObject(r1)
            org.spongycastle.asn1.ocsp.ResponderID r1 = org.spongycastle.asn1.ocsp.ResponderID.getInstance(r1)
            r0.addElement(r1)
            int r1 = r2.available()
            if (r1 > 0) goto L14
        L29:
            r1 = 0
            int r2 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r3)
            if (r2 <= 0) goto L3c
            byte[] r3 = org.spongycastle.crypto.tls.TlsUtils.readFully(r2, r3)
            org.spongycastle.asn1.ASN1Primitive r3 = org.spongycastle.crypto.tls.TlsUtils.readDERObject(r3)
            org.spongycastle.asn1.x509.Extensions r1 = org.spongycastle.asn1.x509.Extensions.getInstance(r3)
        L3c:
            org.spongycastle.crypto.tls.OCSPStatusRequest r3 = new org.spongycastle.crypto.tls.OCSPStatusRequest
            r3.<init>(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.OCSPStatusRequest.parse(java.io.InputStream):org.spongycastle.crypto.tls.OCSPStatusRequest");
    }

    public void encode(OutputStream outputStream) throws IOException {
        Vector vector = this.responderIDList;
        if (vector != null && !vector.isEmpty()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < this.responderIDList.size(); i2++) {
                TlsUtils.writeOpaque16(((ResponderID) this.responderIDList.elementAt(i2)).getEncoded(ASN1Encoding.DER), byteArrayOutputStream);
            }
            TlsUtils.checkUint16(byteArrayOutputStream.size());
            TlsUtils.writeUint16(byteArrayOutputStream.size(), outputStream);
            byteArrayOutputStream.writeTo(outputStream);
        } else {
            TlsUtils.writeUint16(0, outputStream);
        }
        Extensions extensions = this.requestExtensions;
        if (extensions == null) {
            TlsUtils.writeUint16(0, outputStream);
            return;
        }
        byte[] encoded = extensions.getEncoded(ASN1Encoding.DER);
        TlsUtils.checkUint16(encoded.length);
        TlsUtils.writeUint16(encoded.length, outputStream);
        outputStream.write(encoded);
    }

    public Extensions getRequestExtensions() {
        return this.requestExtensions;
    }

    public Vector getResponderIDList() {
        return this.responderIDList;
    }
}