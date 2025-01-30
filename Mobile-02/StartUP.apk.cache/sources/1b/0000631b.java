package org.spongycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes3.dex */
interface DTLSHandshakeRetransmit {
    void receivedHandshakeRecord(int i2, byte[] bArr, int i3, int i4) throws IOException;
}