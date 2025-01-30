package com.google.zxing;

import java.util.Map;

/* compiled from: Reader.java */
/* loaded from: classes2.dex */
public interface j {
    k a(c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, FormatException;

    k b(c cVar) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}