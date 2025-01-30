package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import j.f;
import j.h;
import j.i;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class JsonUtf8Reader extends JsonReader {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final f buffer;
    private int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final h source;
    private JsonValueSource valueSource;
    private static final i SINGLE_QUOTE_OR_SLASH = i.z("'\\");
    private static final i DOUBLE_QUOTE_OR_SLASH = i.z(BasicHeaderValueFormatter.UNSAFE_CHARS);
    private static final i UNQUOTED_STRING_TERMINALS = i.z("{}[]:, \n\t\r\f/\\;#=");
    private static final i LINEFEED_OR_CARRIAGE_RETURN = i.z("\n\r");
    private static final i CLOSING_BLOCK_COMMENT = i.z("*/");

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Reader(h hVar) {
        this.peeked = 0;
        Objects.requireNonNull(hVar, "source == null");
        this.source = hVar;
        this.buffer = hVar.getBuffer();
        pushScope(6);
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() throws IOException {
        int[] iArr = this.scopes;
        int i2 = this.stackSize;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            this.buffer.m0();
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace != 59) {
                    if (nextNonWhitespace == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    throw syntaxError("Unterminated array");
                }
                checkLenient();
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5) {
                int nextNonWhitespace2 = nextNonWhitespace(true);
                this.buffer.m0();
                if (nextNonWhitespace2 != 44) {
                    if (nextNonWhitespace2 != 59) {
                        if (nextNonWhitespace2 == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        throw syntaxError("Unterminated object");
                    }
                    checkLenient();
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.buffer.m0();
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                this.buffer.m0();
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i3 != 5) {
                this.buffer.m0();
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            this.buffer.m0();
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.source.request(1L) && this.buffer.A(0L) == 62) {
                        this.buffer.m0();
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            iArr[i2 - 1] = 7;
        } else if (i3 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 18;
                return 18;
            }
            checkLenient();
        } else if (i3 == 9) {
            this.valueSource.discard();
            this.valueSource = null;
            this.stackSize--;
            return doPeek();
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.buffer.m0();
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 == 39) {
            checkLenient();
            this.buffer.m0();
            this.peeked = 8;
            return 8;
        } else {
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.buffer.m0();
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer.A(0L))) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.buffer.m0();
                    this.peeked = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.buffer.m0();
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw syntaxError("Unexpected value");
            }
            checkLenient();
            this.peeked = 7;
            return 7;
        }
    }

    private int findName(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.strings[i2])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private int findString(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.strings[i2])) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
        }
        return -1;
    }

    private boolean isLiteral(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.buffer.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.source.request(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        checkLenient();
        r3 = r6.buffer.A(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.buffer.m0();
        r6.buffer.m0();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.buffer.m0();
        r6.buffer.m0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (skipToEndOfBlockComment() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int nextNonWhitespace(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            j.h r2 = r6.source
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            j.f r2 = r6.buffer
            long r4 = (long) r1
            byte r1 = r2.A(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            j.f r2 = r6.buffer
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            j.h r3 = r6.source
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.checkLenient()
            j.f r3 = r6.buffer
            r4 = 1
            byte r3 = r3.A(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            j.f r1 = r6.buffer
            r1.m0()
            j.f r1 = r6.buffer
            r1.m0()
            r6.skipToEndOfLine()
            goto L1
        L5c:
            j.f r1 = r6.buffer
            r1.m0()
            j.f r1 = r6.buffer
            r1.m0()
            boolean r1 = r6.skipToEndOfBlockComment()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.squareup.moshi.JsonEncodingException r7 = r6.syntaxError(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.checkLenient()
            r6.skipToEndOfLine()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(i iVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long W = this.source.W(iVar);
            if (W != -1) {
                if (this.buffer.A(W) != 92) {
                    if (sb == null) {
                        String p = this.buffer.p(W);
                        this.buffer.m0();
                        return p;
                    }
                    sb.append(this.buffer.p(W));
                    this.buffer.m0();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.buffer.p(W));
                this.buffer.m0();
                sb.append(readEscapeCharacter());
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    private String nextUnquotedValue() throws IOException {
        long W = this.source.W(UNQUOTED_STRING_TERMINALS);
        return W != -1 ? this.buffer.p(W) : this.buffer.G0();
    }

    private int peekKeyword() throws IOException {
        int i2;
        String str;
        String str2;
        byte A = this.buffer.A(0L);
        if (A == 116 || A == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (A == 102 || A == 70) {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (A != 110 && A != 78) {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.source.request(i4)) {
                return 0;
            }
            byte A2 = this.buffer.A(i3);
            if (A2 != str.charAt(i3) && A2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.source.request(length + 1) && isLiteral(this.buffer.A(length))) {
            return 0;
        }
        this.buffer.skip(length);
        this.peeked = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
        if (isLiteral(r11) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0084, code lost:
        if (r6 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
        if (r8 != Long.MIN_VALUE) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0092, code lost:
        if (r8 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
        if (r10 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0096, code lost:
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009a, code lost:
        r16.peekedLong = r8;
        r16.buffer.skip(r5);
        r16.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
        if (r6 == 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
        if (r6 == 4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
        if (r6 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b2, code lost:
        r16.peekedNumberLength = r5;
        r16.peeked = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b8, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b9, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int peekNumber() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.peekNumber():int");
    }

    private char readEscapeCharacter() throws IOException {
        int i2;
        int i3;
        if (this.source.request(1L)) {
            byte m0 = this.buffer.m0();
            if (m0 == 10 || m0 == 34 || m0 == 39 || m0 == 47 || m0 == 92) {
                return (char) m0;
            }
            if (m0 != 98) {
                if (m0 != 102) {
                    if (m0 != 110) {
                        if (m0 != 114) {
                            if (m0 != 116) {
                                if (m0 != 117) {
                                    if (this.lenient) {
                                        return (char) m0;
                                    }
                                    throw syntaxError("Invalid escape sequence: \\" + ((char) m0));
                                } else if (this.source.request(4L)) {
                                    char c2 = 0;
                                    for (int i4 = 0; i4 < 4; i4++) {
                                        byte A = this.buffer.A(i4);
                                        char c3 = (char) (c2 << 4);
                                        if (A < 48 || A > 57) {
                                            if (A >= 97 && A <= 102) {
                                                i2 = A - 97;
                                            } else if (A < 65 || A > 70) {
                                                throw syntaxError("\\u" + this.buffer.p(4L));
                                            } else {
                                                i2 = A - 65;
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = A - 48;
                                        }
                                        c2 = (char) (c3 + i3);
                                    }
                                    this.buffer.skip(4L);
                                    return c2;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
                            }
                            return '\t';
                        }
                        return TokenParser.CR;
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(i iVar) throws IOException {
        while (true) {
            long W = this.source.W(iVar);
            if (W != -1) {
                if (this.buffer.A(W) == 92) {
                    this.buffer.skip(W + 1);
                    readEscapeCharacter();
                } else {
                    this.buffer.skip(W + 1);
                    return;
                }
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        h hVar = this.source;
        i iVar = CLOSING_BLOCK_COMMENT;
        long M = hVar.M(iVar);
        boolean z = M != -1;
        f fVar = this.buffer;
        fVar.skip(z ? M + iVar.Q() : fVar.O0());
        return z;
    }

    private void skipToEndOfLine() throws IOException {
        long W = this.source.W(LINEFEED_OR_CARRIAGE_RETURN);
        f fVar = this.buffer;
        fVar.skip(W != -1 ? W + 1 : fVar.O0());
    }

    private void skipUnquotedValue() throws IOException {
        long W = this.source.W(UNQUOTED_STRING_TERMINALS);
        f fVar = this.buffer;
        if (W == -1) {
            W = fVar.O0();
        }
        fVar.skip(W);
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginArray() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginObject() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 1) {
            pushScope(3);
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.b();
        this.source.close();
    }

    @Override // com.squareup.moshi.JsonReader
    public void endArray() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 4) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public void endObject() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 2) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            this.pathNames[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean hasNext() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public double nextDouble() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.peekedLong;
        }
        if (i2 == 17) {
            this.peekedString = this.buffer.p(this.peekedNumberLength);
        } else if (i2 == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i2 == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i2 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 16) {
            long j2 = this.peekedLong;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
        }
        if (i2 == 17) {
            this.peekedString = this.buffer.p(this.peekedNumberLength);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                nextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                nextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(nextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i5 = this.stackSize - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr3 = this.pathIndices;
                int i7 = this.stackSize - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public long nextLong() throws IOException {
        String nextQuotedValue;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.peekedLong;
        }
        if (i2 == 17) {
            this.peekedString = this.buffer.p(this.peekedNumberLength);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                nextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                nextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(nextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a long but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            long longValueExact = new BigDecimal(this.peekedString).longValueExact();
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return longValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextName() throws IOException {
        String str;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 14) {
            str = nextUnquotedValue();
        } else if (i2 == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i2 == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i2 == 15) {
            str = this.peekedString;
            this.peekedString = null;
        } else {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    @Override // com.squareup.moshi.JsonReader
    public <T> T nextNull() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + peek() + " at path " + getPath());
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    @Override // com.squareup.moshi.JsonReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j.h nextSource() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextSource():j.h");
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextString() throws IOException {
        String p;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 10) {
            p = nextUnquotedValue();
        } else if (i2 == 9) {
            p = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i2 == 8) {
            p = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i2 == 11) {
            p = this.peekedString;
            this.peekedString = null;
        } else if (i2 == 16) {
            p = Long.toString(this.peekedLong);
        } else if (i2 == 17) {
            p = this.buffer.p(this.peekedNumberLength);
        } else {
            throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr[i3] = iArr[i3] + 1;
        return p;
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        switch (i2) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader peekJson() {
        return new JsonUtf8Reader(this);
    }

    @Override // com.squareup.moshi.JsonReader
    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            this.peekedString = nextName();
            this.peeked = 11;
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return findName(this.peekedString, options);
        }
        int h1 = this.source.h1(options.doubleQuoteSuffix);
        if (h1 != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[h1];
            return h1;
        }
        String str = this.pathNames[this.stackSize - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return findName;
    }

    @Override // com.squareup.moshi.JsonReader
    public int selectString(JsonReader.Options options) throws IOException {
        int[] iArr;
        int i2;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 < 8 || i3 > 11) {
            return -1;
        }
        if (i3 == 11) {
            return findString(this.peekedString, options);
        }
        int h1 = this.source.h1(options.doubleQuoteSuffix);
        if (h1 != -1) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return h1;
        }
        String nextString = nextString();
        int findString = findString(nextString, options);
        if (findString == -1) {
            this.peeked = 11;
            this.peekedString = nextString;
            this.pathIndices[this.stackSize - 1] = iArr[i2] - 1;
        }
        return findString;
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 14) {
                skipUnquotedValue();
            } else if (i2 == 13) {
                skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (i2 == 12) {
                skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (i2 != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = "null";
            return;
        }
        JsonReader.Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            int i2 = 0;
            do {
                int i3 = this.peeked;
                if (i3 == 0) {
                    i3 = doPeek();
                }
                if (i3 == 3) {
                    pushScope(1);
                } else if (i3 == 1) {
                    pushScope(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.stackSize--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.stackSize--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        skipUnquotedValue();
                    } else if (i3 == 9 || i3 == 13) {
                        skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                    } else if (i3 == 8 || i3 == 12) {
                        skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                    } else if (i3 == 17) {
                        this.buffer.skip(this.peekedNumberLength);
                    } else if (i3 == 18) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.peeked = 0;
                }
                i2++;
                this.peeked = 0;
            } while (i2 != 0);
            int[] iArr = this.pathIndices;
            int i4 = this.stackSize;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.pathNames[i4 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.source + ")";
    }

    JsonUtf8Reader(JsonUtf8Reader jsonUtf8Reader) {
        super(jsonUtf8Reader);
        this.peeked = 0;
        h peek = jsonUtf8Reader.source.peek();
        this.source = peek;
        this.buffer = peek.getBuffer();
        this.peeked = jsonUtf8Reader.peeked;
        this.peekedLong = jsonUtf8Reader.peekedLong;
        this.peekedNumberLength = jsonUtf8Reader.peekedNumberLength;
        this.peekedString = jsonUtf8Reader.peekedString;
        try {
            peek.Z0(jsonUtf8Reader.buffer.O0());
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }
}