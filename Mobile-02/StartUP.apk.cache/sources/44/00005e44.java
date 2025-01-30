package org.apache.http.message;

/* loaded from: classes3.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i2 <= i3) {
            this.lowerBound = i2;
            this.upperBound = i3;
            this.pos = i2;
            return;
        }
        throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return '[' + Integer.toString(this.lowerBound) + '>' + Integer.toString(this.pos) + '>' + Integer.toString(this.upperBound) + ']';
    }

    public void updatePos(int i2) {
        if (i2 >= this.lowerBound) {
            if (i2 <= this.upperBound) {
                this.pos = i2;
                return;
            }
            throw new IndexOutOfBoundsException("pos: " + i2 + " > upperBound: " + this.upperBound);
        }
        throw new IndexOutOfBoundsException("pos: " + i2 + " < lowerBound: " + this.lowerBound);
    }
}