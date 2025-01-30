package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.crypto.gmss.GMSSParameters;

/* loaded from: classes3.dex */
public class GMSSKeySpec implements KeySpec {
    private GMSSParameters gmssParameterSet;

    /* JADX INFO: Access modifiers changed from: protected */
    public GMSSKeySpec(GMSSParameters gMSSParameters) {
        this.gmssParameterSet = gMSSParameters;
    }

    public GMSSParameters getParameters() {
        return this.gmssParameterSet;
    }
}