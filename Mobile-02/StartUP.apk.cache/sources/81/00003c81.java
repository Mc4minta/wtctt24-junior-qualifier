package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes2.dex */
public class CodedOutputStream$OutOfSpaceException extends IOException {
    CodedOutputStream$OutOfSpaceException() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }
}