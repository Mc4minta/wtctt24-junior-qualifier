package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Signer;

/* loaded from: classes3.dex */
class SignerInputBuffer extends ByteArrayOutputStream {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateSigner(Signer signer) {
        signer.update(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}