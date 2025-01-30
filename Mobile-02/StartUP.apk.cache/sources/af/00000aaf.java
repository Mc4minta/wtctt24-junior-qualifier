package com.coinbase.android.apiv3;

import android.util.Base64;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import j.f;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import retrofit2.h;

/* compiled from: ApiV3QueryEncoderConverterFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/android/apiv3/WireQueryEncoderConverter;", "Lcom/squareup/wire/g;", "T", "Lretrofit2/h;", "", "value", "convert", "(Lcom/squareup/wire/g;)Ljava/lang/String;", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "(Lcom/squareup/wire/ProtoAdapter;)V", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class WireQueryEncoderConverter<T extends g<?, ?>> implements h<T, String> {
    private final ProtoAdapter<T> adapter;

    public WireQueryEncoderConverter(ProtoAdapter<T> adapter) {
        m.h(adapter, "adapter");
        this.adapter = adapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.h
    public /* bridge */ /* synthetic */ String convert(Object obj) {
        return convert((WireQueryEncoderConverter<T>) ((g) obj));
    }

    public String convert(T value) throws IOException {
        m.h(value, "value");
        f fVar = new f();
        this.adapter.encode((j.g) fVar, (f) value);
        String encodeToString = Base64.encodeToString(fVar.J(), 11);
        m.d(encodeToString, "Base64.encodeToString(bu…_WRAP or Base64.URL_SAFE)");
        return encodeToString;
    }
}