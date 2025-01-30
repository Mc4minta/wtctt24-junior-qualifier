package kotlin.reflect.jvm.internal.impl.protobuf;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* loaded from: classes3.dex */
public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream inputStream) {
        this.enableAliasing = false;
        this.currentLimit = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    public static int decodeZigZag32(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long decodeZigZag64(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void ensureAvailable(int i2) throws IOException {
        if (this.bufferSize - this.bufferPos < i2) {
            refillBuffer(i2);
        }
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    private byte[] readRawBytesSlowPath(int i2) throws IOException {
        if (i2 <= 0) {
            if (i2 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i3 = this.totalBytesRetired;
        int i4 = this.bufferPos;
        int i5 = i3 + i4 + i2;
        int i6 = this.currentLimit;
        if (i5 > i6) {
            skipRawBytes((i6 - i3) - i4);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i2 < 4096) {
            byte[] bArr = new byte[i2];
            int i7 = this.bufferSize - i4;
            System.arraycopy(this.buffer, i4, bArr, 0, i7);
            this.bufferPos = this.bufferSize;
            int i8 = i2 - i7;
            ensureAvailable(i8);
            System.arraycopy(this.buffer, 0, bArr, i7, i8);
            this.bufferPos = i8;
            return bArr;
        } else {
            int i9 = this.bufferSize;
            this.totalBytesRetired = i3 + i9;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i10 = i9 - i4;
            int i11 = i2 - i10;
            ArrayList<byte[]> arrayList = new ArrayList();
            while (i11 > 0) {
                int min = Math.min(i11, 4096);
                byte[] bArr2 = new byte[min];
                int i12 = 0;
                while (i12 < min) {
                    InputStream inputStream = this.input;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i12, min - i12);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i12 += read;
                }
                i11 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(this.buffer, i4, bArr3, 0, i10);
            for (byte[] bArr4 : arrayList) {
                System.arraycopy(bArr4, 0, bArr3, i10, bArr4.length);
                i10 += bArr4.length;
            }
            return bArr3;
        }
    }

    private void recomputeBufferSizeAfterLimit() {
        int i2 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i2;
        int i3 = this.totalBytesRetired + i2;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.bufferSizeAfterLimit = i5;
            this.bufferSize = i2 - i5;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    private void refillBuffer(int i2) throws IOException {
        if (!tryRefillBuffer(i2)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void skipRawBytesSlowPath(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.totalBytesRetired;
            int i4 = this.bufferPos;
            int i5 = i3 + i4 + i2;
            int i6 = this.currentLimit;
            if (i5 <= i6) {
                int i7 = this.bufferSize;
                int i8 = i7 - i4;
                this.bufferPos = i7;
                refillBuffer(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.bufferSize;
                    if (i9 > i10) {
                        i8 += i10;
                        this.bufferPos = i10;
                        refillBuffer(1);
                    } else {
                        this.bufferPos = i9;
                        return;
                    }
                }
            } else {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean tryRefillBuffer(int i2) throws IOException {
        int i3 = this.bufferPos;
        if (i3 + i2 > this.bufferSize) {
            if (this.totalBytesRetired + i3 + i2 > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            if (this.input != null) {
                int i4 = this.bufferPos;
                if (i4 > 0) {
                    int i5 = this.bufferSize;
                    if (i5 > i4) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.totalBytesRetired += i4;
                    this.bufferSize -= i4;
                    this.bufferPos = 0;
                }
                InputStream inputStream = this.input;
                byte[] bArr2 = this.buffer;
                int i6 = this.bufferSize;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    StringBuilder sb = new StringBuilder(102);
                    sb.append("InputStream#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read > 0) {
                    this.bufferSize += read;
                    if ((this.totalBytesRetired + i2) - this.sizeLimit <= 0) {
                        recomputeBufferSizeAfterLimit();
                        if (this.bufferSize >= i2) {
                            return true;
                        }
                        return tryRefillBuffer(i2);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i2);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    public void checkLastTagWas(int i2) throws InvalidProtocolBufferException {
        if (this.lastTag != i2) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i2 = this.currentLimit;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    public void popLimit(int i2) {
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.totalBytesRetired + this.bufferPos;
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.currentLimit = i3;
                recomputeBufferSizeAfterLimit();
                return i4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public ByteString readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i2 = this.bufferSize;
        int i3 = this.bufferPos;
        if (readRawVarint32 > i2 - i3 || readRawVarint32 <= 0) {
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return new LiteralByteString(readRawBytesSlowPath(readRawVarint32));
        }
        ByteString boundedByteString = (this.bufferIsImmutable && this.enableAliasing) ? new BoundedByteString(this.buffer, this.bufferPos, readRawVarint32) : ByteString.copyFrom(this.buffer, i3, readRawVarint32);
        this.bufferPos += readRawVarint32;
        return boundedByteString;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i3 = this.recursionDepth;
        if (i3 < this.recursionLimit) {
            this.recursionDepth = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i2, 4));
            this.recursionDepth--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.bufferPos;
        this.bufferPos = i2 + 1;
        return bArr[i2];
    }

    public int readRawLittleEndian32() throws IOException {
        int i2 = this.bufferPos;
        if (this.bufferSize - i2 < 4) {
            refillBuffer(4);
            i2 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i2 = this.bufferPos;
        if (this.bufferSize - i2 < 8) {
            refillBuffer(8);
            i2 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i2 + 8;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readRawVarint32() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.bufferPos
            int r1 = r9.bufferSize
            if (r1 != r0) goto L8
            goto L7c
        L8:
            byte[] r2 = r9.buffer
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L13
            r9.bufferPos = r3
            return r0
        L13:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L19
            goto L7c
        L19:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L29:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L82
        L2d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L3f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L3d:
            r1 = r3
            goto L82
        L3f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L4f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L29
        L4f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L82
        L7c:
            long r0 = r9.readRawVarint64SlowPath()
            int r0 = (int) r0
            return r0
        L82:
            r9.bufferPos = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint32():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r2[r0] < 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readRawVarint64() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint64():long");
    }

    long readRawVarint64SlowPath() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte readRawByte = readRawByte();
            j2 |= (readRawByte & Byte.MAX_VALUE) << i2;
            if ((readRawByte & 128) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 > this.bufferSize - this.bufferPos || readRawVarint32 <= 0) {
            return readRawVarint32 == 0 ? "" : new String(readRawBytesSlowPath(readRawVarint32), "UTF-8");
        }
        String str = new String(this.buffer, this.bufferPos, readRawVarint32, "UTF-8");
        this.bufferPos += readRawVarint32;
        return str;
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] readRawBytesSlowPath;
        int readRawVarint32 = readRawVarint32();
        int i2 = this.bufferPos;
        if (readRawVarint32 <= this.bufferSize - i2 && readRawVarint32 > 0) {
            readRawBytesSlowPath = this.buffer;
            this.bufferPos = i2 + readRawVarint32;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32);
            i2 = 0;
        }
        if (Utf8.isValidUtf8(readRawBytesSlowPath, i2, i2 + readRawVarint32)) {
            return new String(readRawBytesSlowPath, i2, readRawVarint32, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public boolean skipField(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        } else if (tagWireType == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        } else if (tagWireType == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        } else if (tagWireType == 3) {
            codedOutputStream.writeRawVarint32(i2);
            skipMessage(codedOutputStream);
            int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i2), 4);
            checkLastTagWas(makeTag);
            codedOutputStream.writeRawVarint32(makeTag);
            return true;
        } else if (tagWireType != 4) {
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i2);
                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag, codedOutputStream));
    }

    public void skipRawBytes(int i2) throws IOException {
        int i3 = this.bufferSize;
        int i4 = this.bufferPos;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.bufferPos = i4 + i2;
        } else {
            skipRawBytesSlowPath(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = literalByteString.bytes;
        int offsetIntoBytes = literalByteString.getOffsetIntoBytes();
        this.bufferPos = offsetIntoBytes;
        this.bufferSize = offsetIntoBytes + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public static int readRawVarint32(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i3 |= (read & 127) << i4;
            if ((read & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
}