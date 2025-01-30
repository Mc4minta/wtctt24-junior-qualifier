package org.spongycastle.crypto.tls;

import java.util.Vector;

/* loaded from: classes3.dex */
class DTLSReassembler {
    private final byte[] body;
    private Vector missing;
    private final short msg_type;

    /* loaded from: classes3.dex */
    private static class Range {
        private int end;
        private int start;

        Range(int i2, int i3) {
            this.start = i2;
            this.end = i3;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public void setEnd(int i2) {
            this.end = i2;
        }

        public void setStart(int i2) {
            this.start = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DTLSReassembler(short s, int i2) {
        Vector vector = new Vector();
        this.missing = vector;
        this.msg_type = s;
        this.body = new byte[i2];
        vector.addElement(new Range(0, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void contributeFragment(short s, int i2, byte[] bArr, int i3, int i4, int i5) {
        int i6 = i4 + i5;
        if (this.msg_type == s && this.body.length == i2 && i6 <= i2) {
            int i7 = 0;
            if (i5 == 0) {
                if (i4 == 0 && !this.missing.isEmpty() && ((Range) this.missing.firstElement()).getEnd() == 0) {
                    this.missing.removeElementAt(0);
                    return;
                }
                return;
            }
            while (i7 < this.missing.size()) {
                Range range = (Range) this.missing.elementAt(i7);
                if (range.getStart() >= i6) {
                    return;
                }
                if (range.getEnd() > i4) {
                    int max = Math.max(range.getStart(), i4);
                    int min = Math.min(range.getEnd(), i6);
                    System.arraycopy(bArr, (i3 + max) - i4, this.body, max, min - max);
                    if (max == range.getStart()) {
                        if (min == range.getEnd()) {
                            this.missing.removeElementAt(i7);
                            i7--;
                        } else {
                            range.setStart(min);
                        }
                    } else {
                        if (min != range.getEnd()) {
                            i7++;
                            this.missing.insertElementAt(new Range(min, range.getEnd()), i7);
                        }
                        range.setEnd(max);
                    }
                }
                i7++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBodyIfComplete() {
        if (this.missing.isEmpty()) {
            return this.body;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short getMsgType() {
        return this.msg_type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.missing.removeAllElements();
        this.missing.addElement(new Range(0, this.body.length));
    }
}