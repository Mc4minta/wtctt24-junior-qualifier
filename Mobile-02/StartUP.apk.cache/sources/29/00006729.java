package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.spec.SkeinParameterSpec;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

/* loaded from: classes3.dex */
public class BaseMac extends MacSpi implements PBE {
    private int keySize;
    private Mac macEngine;
    private int pbeHash;
    private int scheme;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMac(Mac mac) {
        this.scheme = 2;
        this.pbeHash = 1;
        this.keySize = CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
        this.macEngine = mac;
    }

    private static Hashtable copyMap(Map map) {
        Hashtable hashtable = new Hashtable();
        for (Object obj : map.keySet()) {
            hashtable.put(obj, map.get(obj));
        }
        return hashtable;
    }

    @Override // javax.crypto.MacSpi
    protected byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.macEngine.doFinal(bArr, 0);
        return bArr;
    }

    @Override // javax.crypto.MacSpi
    protected int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    @Override // javax.crypto.MacSpi
    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters makePBEMacParameters;
        if (key != null) {
            if (key instanceof PKCS12Key) {
                try {
                    SecretKey secretKey = (SecretKey) key;
                    try {
                        PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                        if ((secretKey instanceof PBEKey) && pBEParameterSpec == null) {
                            PBEKey pBEKey = (PBEKey) secretKey;
                            pBEParameterSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                        }
                        int i2 = 1;
                        int i3 = CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
                        if (this.macEngine.getAlgorithmName().startsWith("GOST")) {
                            i2 = 6;
                        } else {
                            i2 = this.macEngine.getAlgorithmName().startsWith(McElieceCCA2ParameterSpec.DEFAULT_MD) ? 4 : 4;
                            makePBEMacParameters = PBE.Util.makePBEMacParameters(secretKey, 2, i2, i3, pBEParameterSpec);
                        }
                        i3 = 256;
                        makePBEMacParameters = PBE.Util.makePBEMacParameters(secretKey, 2, i2, i3, pBEParameterSpec);
                    } catch (Exception unused) {
                        throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
                    }
                } catch (Exception unused2) {
                    throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
                }
            } else if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                if (bCPBEKey.getParam() != null) {
                    makePBEMacParameters = bCPBEKey.getParam();
                } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                    makePBEMacParameters = PBE.Util.makePBEMacParameters(bCPBEKey, algorithmParameterSpec);
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                makePBEMacParameters = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else if (algorithmParameterSpec instanceof SkeinParameterSpec) {
                makePBEMacParameters = new SkeinParameters.Builder(copyMap(((SkeinParameterSpec) algorithmParameterSpec).getParameters())).setKey(key.getEncoded()).build();
            } else if (algorithmParameterSpec == null) {
                makePBEMacParameters = new KeyParameter(key.getEncoded());
            } else {
                throw new InvalidAlgorithmParameterException("unknown parameter type.");
            }
            this.macEngine.init(makePBEMacParameters);
            return;
        }
        throw new InvalidKeyException("key is null");
    }

    @Override // javax.crypto.MacSpi
    protected void engineReset() {
        this.macEngine.reset();
    }

    @Override // javax.crypto.MacSpi
    protected void engineUpdate(byte b2) {
        this.macEngine.update(b2);
    }

    @Override // javax.crypto.MacSpi
    protected void engineUpdate(byte[] bArr, int i2, int i3) {
        this.macEngine.update(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMac(Mac mac, int i2, int i3, int i4) {
        this.scheme = 2;
        this.pbeHash = 1;
        this.keySize = CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
        this.macEngine = mac;
        this.scheme = i2;
        this.pbeHash = i3;
        this.keySize = i4;
    }
}