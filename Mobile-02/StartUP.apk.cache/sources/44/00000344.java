package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = versionedParcel.p(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.f1824b = versionedParcel.p(audioAttributesImplBase.f1824b, 2);
        audioAttributesImplBase.f1825c = versionedParcel.p(audioAttributesImplBase.f1825c, 3);
        audioAttributesImplBase.f1826d = versionedParcel.p(audioAttributesImplBase.f1826d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.a, 1);
        versionedParcel.F(audioAttributesImplBase.f1824b, 2);
        versionedParcel.F(audioAttributesImplBase.f1825c, 3);
        versionedParcel.F(audioAttributesImplBase.f1826d, 4);
    }
}