package org.spongycastle.crypto.tls;

/* loaded from: classes3.dex */
public class ByteQueue {
    private static final int DEFAULT_CAPACITY = 1024;
    private int available;
    private byte[] databuf;
    private int skipped;

    public ByteQueue() {
        this(1024);
    }

    public static int nextTwoPow(int i2) {
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public void addData(byte[] bArr, int i2, int i3) {
        int i4 = this.skipped;
        int i5 = this.available;
        if (i4 + i5 + i3 > this.databuf.length) {
            int nextTwoPow = nextTwoPow(i5 + i3);
            byte[] bArr2 = this.databuf;
            if (nextTwoPow > bArr2.length) {
                byte[] bArr3 = new byte[nextTwoPow];
                System.arraycopy(bArr2, this.skipped, bArr3, 0, this.available);
                this.databuf = bArr3;
            } else {
                System.arraycopy(bArr2, this.skipped, bArr2, 0, this.available);
            }
            this.skipped = 0;
        }
        System.arraycopy(bArr, i2, this.databuf, this.skipped + this.available, i3);
        this.available += i3;
    }

    public int available() {
        return this.available;
    }

    public void read(byte[] bArr, int i2, int i3, int i4) {
        if (bArr.length - i2 >= i3) {
            if (this.available - i4 >= i3) {
                System.arraycopy(this.databuf, this.skipped + i4, bArr, i2, i3);
                return;
            }
            throw new IllegalStateException("Not enough data to read");
        }
        throw new IllegalArgumentException("Buffer size of " + bArr.length + " is too small for a read of " + i3 + " bytes");
    }

    public void removeData(int i2) {
        int i3 = this.available;
        if (i2 <= i3) {
            this.available = i3 - i2;
            this.skipped += i2;
            return;
        }
        throw new IllegalStateException("Cannot remove " + i2 + " bytes, only got " + this.available);
    }

    public int size() {
        return this.available;
    }

    public ByteQueue(int i2) {
        this.skipped = 0;
        this.available = 0;
        this.databuf = new byte[i2];
    }

    public void removeData(byte[] bArr, int i2, int i3, int i4) {
        read(bArr, i2, i3, i4);
        removeData(i4 + i3);
    }

    public byte[] removeData(int i2, int i3) {
        byte[] bArr = new byte[i2];
        removeData(bArr, 0, i2, i3);
        return bArr;
    }
}