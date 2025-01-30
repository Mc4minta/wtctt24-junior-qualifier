package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final void record(LookupTracker lookupTracker, LookupLocation from, ClassDescriptor scopeOwner, Name name) {
        LocationInfo location;
        m.g(lookupTracker, "<this>");
        m.g(from, "from");
        m.g(scopeOwner, "scopeOwner");
        m.g(name, "name");
        if (lookupTracker == LookupTracker.DO_NOTHING.INSTANCE || (location = from.getLocation()) == null) {
            return;
        }
        Position position = lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION();
        String filePath = location.getFilePath();
        String asString = DescriptorUtils.getFqName(scopeOwner).asString();
        m.f(asString, "getFqName(scopeOwner).asString()");
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        String asString2 = name.asString();
        m.f(asString2, "name.asString()");
        lookupTracker.record(filePath, position, asString, scopeKind, asString2);
    }

    public static final void recordPackageLookup(LookupTracker lookupTracker, LookupLocation from, String packageFqName, String name) {
        LocationInfo location;
        m.g(lookupTracker, "<this>");
        m.g(from, "from");
        m.g(packageFqName, "packageFqName");
        m.g(name, "name");
        if (lookupTracker == LookupTracker.DO_NOTHING.INSTANCE || (location = from.getLocation()) == null) {
            return;
        }
        lookupTracker.record(location.getFilePath(), lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION(), packageFqName, ScopeKind.PACKAGE, name);
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation from, PackageFragmentDescriptor scopeOwner, Name name) {
        m.g(lookupTracker, "<this>");
        m.g(from, "from");
        m.g(scopeOwner, "scopeOwner");
        m.g(name, "name");
        String asString = scopeOwner.getFqName().asString();
        m.f(asString, "scopeOwner.fqName.asString()");
        String asString2 = name.asString();
        m.f(asString2, "name.asString()");
        recordPackageLookup(lookupTracker, from, asString, asString2);
    }
}