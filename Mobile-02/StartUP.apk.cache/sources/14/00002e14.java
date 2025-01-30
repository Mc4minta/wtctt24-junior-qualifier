package com.facebook.react.fabric.mounting.mountitems;

/* compiled from: RemoveDeleteMultiMountItem.java */
/* loaded from: classes2.dex */
public class i implements g {
    private int[] a;

    public i(int[] iArr) {
        this.a = iArr;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.a;
                    if (i3 >= iArr2.length) {
                        return;
                    }
                    if ((iArr2[i3 + 3] & 2) != 0) {
                        int i4 = iArr2[i3 + 0];
                        throw null;
                    }
                    i3 += 4;
                }
            } else if ((iArr[i2 + 3] & 1) != 0) {
                int i5 = iArr[i2 + 1];
                int i6 = iArr[i2 + 2];
                throw null;
            } else {
                i2 += 4;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.a.length; i2 += 4) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("RemoveDeleteMultiMountItem (");
            sb.append((i2 / 4) + 1);
            sb.append("/");
            sb.append(this.a.length / 4);
            sb.append("): [");
            sb.append(this.a[i2 + 0]);
            sb.append("] parent [");
            sb.append(this.a[i2 + 1]);
            sb.append("] idx ");
            sb.append(this.a[i2 + 2]);
            sb.append(" ");
            sb.append(this.a[i2 + 3]);
        }
        return sb.toString();
    }
}