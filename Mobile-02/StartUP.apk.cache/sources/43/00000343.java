package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f1824b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f1825c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f1826d = -1;

    public int a() {
        return this.f1824b;
    }

    public int b() {
        int i2 = this.f1825c;
        int c2 = c();
        if (c2 == 6) {
            i2 |= 4;
        } else if (c2 == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f1826d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f1825c, this.a);
    }

    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplBase) {
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            return this.f1824b == audioAttributesImplBase.a() && this.f1825c == audioAttributesImplBase.b() && this.a == audioAttributesImplBase.d() && this.f1826d == audioAttributesImplBase.f1826d;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1824b), Integer.valueOf(this.f1825c), Integer.valueOf(this.a), Integer.valueOf(this.f1826d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1826d != -1) {
            sb.append(" stream=");
            sb.append(this.f1826d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.a));
        sb.append(" content=");
        sb.append(this.f1824b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1825c).toUpperCase());
        return sb.toString();
    }
}