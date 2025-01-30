package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.io.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.apache.http.cookie.ClientCookie;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
/* loaded from: classes3.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = new Companion(null);
    private final boolean isFallback;

    /* compiled from: BuiltInsPackageFragmentImpl.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BuiltInsPackageFragmentImpl create(FqName fqName, StorageManager storageManager, ModuleDescriptor module, InputStream inputStream, boolean z) {
            m.g(fqName, "fqName");
            m.g(storageManager, "storageManager");
            m.g(module, "module");
            m.g(inputStream, "inputStream");
            try {
                BuiltInsBinaryVersion readFrom = BuiltInsBinaryVersion.Companion.readFrom(inputStream);
                if (readFrom != null) {
                    if (readFrom.isCompatible()) {
                        ProtoBuf.PackageFragment proto = ProtoBuf.PackageFragment.parseFrom(inputStream, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry());
                        a.a(inputStream, null);
                        m.f(proto, "proto");
                        return new BuiltInsPackageFragmentImpl(fqName, storageManager, module, proto, readFrom, z, null);
                    }
                    throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + readFrom + ". Please update Kotlin");
                }
                m.w(ClientCookie.VERSION_ATTR);
                throw null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    a.a(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    private BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z) {
        super(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, null);
        this.isFallback = z;
    }

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, z);
    }
}