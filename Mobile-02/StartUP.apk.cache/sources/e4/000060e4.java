package org.spongycastle.asn1.x509;

/* loaded from: classes3.dex */
public interface NameConstraintValidator {
    void addExcludedSubtree(GeneralSubtree generalSubtree);

    void checkExcluded(GeneralName generalName) throws NameConstraintValidatorException;

    void checkPermitted(GeneralName generalName) throws NameConstraintValidatorException;

    void intersectEmptyPermittedSubtree(int i2);

    void intersectPermittedSubtree(GeneralSubtree generalSubtree);

    void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr);
}