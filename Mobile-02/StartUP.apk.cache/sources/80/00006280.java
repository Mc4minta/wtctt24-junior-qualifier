package org.spongycastle.crypto.params;

/* loaded from: classes3.dex */
public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    private CramerShoupParameters params;

    /* JADX INFO: Access modifiers changed from: protected */
    public CramerShoupKeyParameters(boolean z, CramerShoupParameters cramerShoupParameters) {
        super(z);
        this.params = cramerShoupParameters;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CramerShoupKeyParameters) {
            CramerShoupKeyParameters cramerShoupKeyParameters = (CramerShoupKeyParameters) obj;
            CramerShoupParameters cramerShoupParameters = this.params;
            if (cramerShoupParameters == null) {
                return cramerShoupKeyParameters.getParameters() == null;
            }
            return cramerShoupParameters.equals(cramerShoupKeyParameters.getParameters());
        }
        return false;
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        int i2 = !isPrivate();
        CramerShoupParameters cramerShoupParameters = this.params;
        return cramerShoupParameters != null ? i2 ^ cramerShoupParameters.hashCode() : i2;
    }
}