package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: BuiltInsLoaderImpl.kt */
/* loaded from: classes3.dex */
/* synthetic */ class BuiltInsLoaderImpl$createPackageFragmentProvider$1 extends j implements l<String, InputStream> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BuiltInsLoaderImpl$createPackageFragmentProvider$1(BuiltInsResourceLoader builtInsResourceLoader) {
        super(1, builtInsResourceLoader);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "loadResource";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(BuiltInsResourceLoader.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
    }

    @Override // kotlin.e0.c.l
    public final InputStream invoke(String p0) {
        m.g(p0, "p0");
        return ((BuiltInsResourceLoader) this.receiver).loadResource(p0);
    }
}