package org.spongycastle.crypto.tls;

/* loaded from: classes3.dex */
class DTLSReplayWindow {
    private static final long VALID_SEQ_MASK = 281474976710655L;
    private static final long WINDOW_SIZE = 64;
    private long latestConfirmedSeq = -1;
    private long bitmap = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportAuthenticated(long j2) {
        if ((VALID_SEQ_MASK & j2) == j2) {
            long j3 = this.latestConfirmedSeq;
            if (j2 <= j3) {
                long j4 = j3 - j2;
                if (j4 < WINDOW_SIZE) {
                    this.bitmap |= 1 << ((int) j4);
                    return;
                }
                return;
            }
            long j5 = j2 - j3;
            if (j5 >= WINDOW_SIZE) {
                this.bitmap = 1L;
            } else {
                long j6 = this.bitmap << ((int) j5);
                this.bitmap = j6;
                this.bitmap = j6 | 1;
            }
            this.latestConfirmedSeq = j2;
            return;
        }
        throw new IllegalArgumentException("'seq' out of range");
    }

    void reset() {
        this.latestConfirmedSeq = -1L;
        this.bitmap = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldDiscard(long j2) {
        if ((VALID_SEQ_MASK & j2) != j2) {
            return true;
        }
        long j3 = this.latestConfirmedSeq;
        if (j2 <= j3) {
            long j4 = j3 - j2;
            return j4 >= WINDOW_SIZE || (this.bitmap & (1 << ((int) j4))) != 0;
        }
        return false;
    }
}