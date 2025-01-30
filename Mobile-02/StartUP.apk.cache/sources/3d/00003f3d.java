package com.squareup.moshi;

import j.e0;
import j.f;
import j.f0;
import j.h;
import j.i;
import java.io.IOException;
import org.apache.http.message.BasicHeaderValueFormatter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class JsonValueSource implements e0 {
    private final f buffer;
    private boolean closed;
    private long limit;
    private final f prefix;
    private final h source;
    private int stackSize;
    private i state;
    static final i STATE_JSON = i.z("[]{}\"'/#");
    static final i STATE_SINGLE_QUOTED = i.z("'\\");
    static final i STATE_DOUBLE_QUOTED = i.z(BasicHeaderValueFormatter.UNSAFE_CHARS);
    static final i STATE_END_OF_LINE_COMMENT = i.z("\r\n");
    static final i STATE_C_STYLE_COMMENT = i.z("*");
    static final i STATE_END_OF_JSON = i.a;

    JsonValueSource(h hVar) {
        this(hVar, new f(), STATE_JSON, 0);
    }

    private void advanceLimit(long j2) throws IOException {
        while (true) {
            long j3 = this.limit;
            if (j3 >= j2) {
                return;
            }
            i iVar = this.state;
            i iVar2 = STATE_END_OF_JSON;
            if (iVar == iVar2) {
                return;
            }
            if (j3 == this.buffer.O0()) {
                if (this.limit > 0) {
                    return;
                }
                this.source.Z0(1L);
            }
            long N = this.buffer.N(this.state, this.limit);
            if (N == -1) {
                this.limit = this.buffer.O0();
            } else {
                byte A = this.buffer.A(N);
                i iVar3 = this.state;
                i iVar4 = STATE_JSON;
                if (iVar3 == iVar4) {
                    if (A == 34) {
                        this.state = STATE_DOUBLE_QUOTED;
                        this.limit = N + 1;
                    } else if (A == 35) {
                        this.state = STATE_END_OF_LINE_COMMENT;
                        this.limit = N + 1;
                    } else if (A == 39) {
                        this.state = STATE_SINGLE_QUOTED;
                        this.limit = N + 1;
                    } else if (A != 47) {
                        if (A != 91) {
                            if (A != 93) {
                                if (A != 123) {
                                    if (A != 125) {
                                    }
                                }
                            }
                            int i2 = this.stackSize - 1;
                            this.stackSize = i2;
                            if (i2 == 0) {
                                this.state = iVar2;
                            }
                            this.limit = N + 1;
                        }
                        this.stackSize++;
                        this.limit = N + 1;
                    } else {
                        long j4 = 2 + N;
                        this.source.Z0(j4);
                        long j5 = N + 1;
                        byte A2 = this.buffer.A(j5);
                        if (A2 == 47) {
                            this.state = STATE_END_OF_LINE_COMMENT;
                            this.limit = j4;
                        } else if (A2 == 42) {
                            this.state = STATE_C_STYLE_COMMENT;
                            this.limit = j4;
                        } else {
                            this.limit = j5;
                        }
                    }
                } else if (iVar3 == STATE_SINGLE_QUOTED || iVar3 == STATE_DOUBLE_QUOTED) {
                    if (A == 92) {
                        long j6 = N + 2;
                        this.source.Z0(j6);
                        this.limit = j6;
                    } else {
                        if (this.stackSize > 0) {
                            iVar2 = iVar4;
                        }
                        this.state = iVar2;
                        this.limit = N + 1;
                    }
                } else if (iVar3 == STATE_C_STYLE_COMMENT) {
                    long j7 = 2 + N;
                    this.source.Z0(j7);
                    long j8 = N + 1;
                    if (this.buffer.A(j8) == 47) {
                        this.limit = j7;
                        this.state = iVar4;
                    } else {
                        this.limit = j8;
                    }
                } else if (iVar3 == STATE_END_OF_LINE_COMMENT) {
                    this.limit = N + 1;
                    this.state = iVar4;
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    public void discard() throws IOException {
        this.closed = true;
        while (this.state != STATE_END_OF_JSON) {
            advanceLimit(8192L);
            this.source.skip(this.limit);
        }
    }

    @Override // j.e0
    public long read(f fVar, long j2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j2 == 0) {
            return 0L;
        }
        if (!this.prefix.Q()) {
            long read = this.prefix.read(fVar, j2);
            long j3 = j2 - read;
            if (this.buffer.Q()) {
                return read;
            }
            long read2 = read(fVar, j3);
            return read2 != -1 ? read + read2 : read;
        }
        advanceLimit(j2);
        long j4 = this.limit;
        if (j4 == 0) {
            if (this.state == STATE_END_OF_JSON) {
                return -1L;
            }
            throw new AssertionError();
        }
        long min = Math.min(j2, j4);
        fVar.write(this.buffer, min);
        this.limit -= min;
        return min;
    }

    @Override // j.e0
    public f0 timeout() {
        return this.source.timeout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueSource(h hVar, f fVar, i iVar, int i2) {
        this.limit = 0L;
        this.closed = false;
        this.source = hVar;
        this.buffer = hVar.getBuffer();
        this.prefix = fVar;
        this.state = iVar;
        this.stackSize = i2;
    }
}