package org.spongycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface TlsCipherFactory {
    TlsCipher createCipher(TlsContext tlsContext, int i2, int i3) throws IOException;
}