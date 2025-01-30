package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

/* loaded from: classes3.dex */
public class ASN1InputStream extends FilterInputStream implements BERTags {
    private final boolean lazyEvaluate;
    private final int limit;
    private final byte[][] tmpBuffers;

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1Primitive createPrimitiveDERObject(int i2, DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        if (i2 != 10) {
            if (i2 != 12) {
                if (i2 != 30) {
                    switch (i2) {
                        case 1:
                            return ASN1Boolean.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
                        case 2:
                            return new ASN1Integer(definiteLengthInputStream.toByteArray(), false);
                        case 3:
                            return ASN1BitString.fromInputStream(definiteLengthInputStream.getRemaining(), definiteLengthInputStream);
                        case 4:
                            return new DEROctetString(definiteLengthInputStream.toByteArray());
                        case 5:
                            return DERNull.INSTANCE;
                        case 6:
                            return ASN1ObjectIdentifier.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
                        default:
                            switch (i2) {
                                case 18:
                                    return new DERNumericString(definiteLengthInputStream.toByteArray());
                                case 19:
                                    return new DERPrintableString(definiteLengthInputStream.toByteArray());
                                case 20:
                                    return new DERT61String(definiteLengthInputStream.toByteArray());
                                case 21:
                                    return new DERVideotexString(definiteLengthInputStream.toByteArray());
                                case 22:
                                    return new DERIA5String(definiteLengthInputStream.toByteArray());
                                case 23:
                                    return new ASN1UTCTime(definiteLengthInputStream.toByteArray());
                                case 24:
                                    return new ASN1GeneralizedTime(definiteLengthInputStream.toByteArray());
                                case 25:
                                    return new DERGraphicString(definiteLengthInputStream.toByteArray());
                                case 26:
                                    return new DERVisibleString(definiteLengthInputStream.toByteArray());
                                case 27:
                                    return new DERGeneralString(definiteLengthInputStream.toByteArray());
                                case 28:
                                    return new DERUniversalString(definiteLengthInputStream.toByteArray());
                                default:
                                    throw new IOException("unknown tag " + i2 + " encountered");
                            }
                    }
                }
                return new DERBMPString(getBMPCharBuffer(definiteLengthInputStream));
            }
            return new DERUTF8String(definiteLengthInputStream.toByteArray());
        }
        return ASN1Enumerated.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
    }

    private static char[] getBMPCharBuffer(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        int read;
        int remaining = definiteLengthInputStream.getRemaining() / 2;
        char[] cArr = new char[remaining];
        for (int i2 = 0; i2 < remaining; i2++) {
            int read2 = definiteLengthInputStream.read();
            if (read2 < 0 || (read = definiteLengthInputStream.read()) < 0) {
                break;
            }
            cArr[i2] = (char) ((read2 << 8) | (read & 255));
        }
        return cArr;
    }

    private static byte[] getBuffer(DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int remaining = definiteLengthInputStream.getRemaining();
        if (definiteLengthInputStream.getRemaining() < bArr.length) {
            byte[] bArr2 = bArr[remaining];
            if (bArr2 == null) {
                bArr2 = new byte[remaining];
                bArr[remaining] = bArr2;
            }
            Streams.readFully(definiteLengthInputStream, bArr2);
            return bArr2;
        }
        return definiteLengthInputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int readTagNumber(InputStream inputStream, int i2) throws IOException {
        int i3 = i2 & 31;
        if (i3 == 31) {
            int i4 = 0;
            int read = inputStream.read();
            if ((read & 127) != 0) {
                while (read >= 0 && (read & 128) != 0) {
                    i4 = (i4 | (read & 127)) << 7;
                    read = inputStream.read();
                }
                if (read >= 0) {
                    return i4 | (read & 127);
                }
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        return i3;
    }

    ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        return new ASN1InputStream(definiteLengthInputStream).buildEncodableVector();
    }

    ASN1EncodableVector buildEncodableVector() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Primitive readObject = readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.add(readObject);
        }
    }

    protected ASN1Primitive buildObject(int i2, int i3, int i4) throws IOException {
        boolean z = (i2 & 32) != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i4);
        if ((i2 & 64) != 0) {
            return new DERApplicationSpecific(z, i3, definiteLengthInputStream.toByteArray());
        }
        if ((i2 & 128) != 0) {
            return new ASN1StreamParser(definiteLengthInputStream).readTaggedObject(z, i3);
        }
        if (z) {
            if (i3 == 4) {
                ASN1EncodableVector buildDEREncodableVector = buildDEREncodableVector(definiteLengthInputStream);
                int size = buildDEREncodableVector.size();
                ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
                for (int i5 = 0; i5 != size; i5++) {
                    aSN1OctetStringArr[i5] = (ASN1OctetString) buildDEREncodableVector.get(i5);
                }
                return new BEROctetString(aSN1OctetStringArr);
            } else if (i3 != 8) {
                if (i3 == 16) {
                    if (this.lazyEvaluate) {
                        return new LazyEncodedSequence(definiteLengthInputStream.toByteArray());
                    }
                    return DERFactory.createSequence(buildDEREncodableVector(definiteLengthInputStream));
                } else if (i3 == 17) {
                    return DERFactory.createSet(buildDEREncodableVector(definiteLengthInputStream));
                } else {
                    throw new IOException("unknown tag " + i3 + " encountered");
                }
            } else {
                return new DERExternal(buildDEREncodableVector(definiteLengthInputStream));
            }
        }
        return createPrimitiveDERObject(i3, definiteLengthInputStream, this.tmpBuffers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLimit() {
        return this.limit;
    }

    protected void readFully(byte[] bArr) throws IOException {
        if (Streams.readFully(this, bArr) != bArr.length) {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    protected int readLength() throws IOException {
        return readLength(this, this.limit);
    }

    public ASN1Primitive readObject() throws IOException {
        int read = read();
        if (read <= 0) {
            if (read != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int readTagNumber = readTagNumber(this, read);
        boolean z = (read & 32) != 0;
        int readLength = readLength();
        if (readLength >= 0) {
            try {
                return buildObject(read, readTagNumber, readLength);
            } catch (IllegalArgumentException e2) {
                throw new ASN1Exception("corrupted stream detected", e2);
            }
        } else if (z) {
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
            if ((read & 64) != 0) {
                return new BERApplicationSpecificParser(readTagNumber, aSN1StreamParser).getLoadedObject();
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(true, readTagNumber, aSN1StreamParser).getLoadedObject();
            }
            if (readTagNumber != 4) {
                if (readTagNumber != 8) {
                    if (readTagNumber != 16) {
                        if (readTagNumber == 17) {
                            return new BERSetParser(aSN1StreamParser).getLoadedObject();
                        }
                        throw new IOException("unknown BER object encountered");
                    }
                    return new BERSequenceParser(aSN1StreamParser).getLoadedObject();
                }
                return new DERExternalParser(aSN1StreamParser).getLoadedObject();
            }
            return new BEROctetStringParser(aSN1StreamParser).getLoadedObject();
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int readLength(InputStream inputStream, int i2) throws IOException {
        int read = inputStream.read();
        if (read >= 0) {
            if (read == 128) {
                return -1;
            }
            if (read > 127) {
                int i3 = read & 127;
                if (i3 > 4) {
                    throw new IOException("DER length more than 4 bytes: " + i3);
                }
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    int read2 = inputStream.read();
                    if (read2 < 0) {
                        throw new EOFException("EOF found reading length");
                    }
                    i4 = (i4 << 8) + read2;
                }
                if (i4 >= 0) {
                    if (i4 < i2) {
                        return i4;
                    }
                    throw new IOException("corrupted stream - out of bounds length found");
                }
                throw new IOException("corrupted stream - negative length found");
            }
            return read;
        }
        throw new EOFException("EOF found when length expected");
    }

    public ASN1InputStream(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    public ASN1InputStream(InputStream inputStream, int i2) {
        this(inputStream, i2, false);
    }

    public ASN1InputStream(InputStream inputStream, boolean z) {
        this(inputStream, StreamUtil.findLimit(inputStream), z);
    }

    public ASN1InputStream(InputStream inputStream, int i2, boolean z) {
        super(inputStream);
        this.limit = i2;
        this.lazyEvaluate = z;
        this.tmpBuffers = new byte[11];
    }
}