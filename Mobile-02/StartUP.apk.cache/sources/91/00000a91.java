package com.coinbase;

import android.util.Base64;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes.dex */
public class CallbackVerifierImpl implements CallbackVerifier {
    private static PublicKey publicKey;

    private static synchronized PublicKey getPublicKey() {
        PublicKey publicKey2;
        synchronized (CallbackVerifierImpl.class) {
            if (publicKey == null) {
                try {
                    publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(org.apache.commons.io.a.e(CallbackVerifierImpl.class.getResourceAsStream("/com/coinbase/api/coinbase-callback.pub.der"))));
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(e3);
                } catch (InvalidKeySpecException e4) {
                    throw new RuntimeException(e4);
                }
            }
            publicKey2 = publicKey;
        }
        return publicKey2;
    }

    @Override // com.coinbase.CallbackVerifier
    public boolean verifyCallback(String str, String str2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(getPublicKey());
            signature.update(str.getBytes());
            return signature.verify(Base64.decode(str2, 0));
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException(e3);
        } catch (SignatureException unused) {
            return false;
        }
    }
}