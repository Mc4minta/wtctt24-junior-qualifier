package org.spongycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes3.dex */
public class AbstractTlsCipherFactory implements TlsCipherFactory {
    @Override // org.spongycastle.crypto.tls.TlsCipherFactory
    public TlsCipher createCipher(TlsContext tlsContext, int i2, int i3) throws IOException {
        throw new TlsFatalAlert((short) 80);
    }
}