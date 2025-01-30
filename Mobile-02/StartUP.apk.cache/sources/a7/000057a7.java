package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.a0.p;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: overridingUtils.kt */
/* loaded from: classes3.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, l<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        m.g(collection, "<this>");
        m.g(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            Object Y = p.Y(linkedList);
            SmartSet create2 = SmartSet.Companion.create();
            Collection<? super H> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(Y, linkedList, descriptorByHandle, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(create2));
            m.f(extractMembersOverridableInBothWays, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                Object w0 = p.w0(extractMembersOverridableInBothWays);
                m.f(w0, "overridableGroup.single()");
                create.add(w0);
            } else {
                Object obj = (Object) OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, descriptorByHandle);
                m.f(obj, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                CallableDescriptor invoke = descriptorByHandle.invoke(obj);
                for (Object it : extractMembersOverridableInBothWays) {
                    m.f(it, "it");
                    if (!OverridingUtil.isMoreSpecific(invoke, descriptorByHandle.invoke(it))) {
                        create2.add(it);
                    }
                }
                if (!create2.isEmpty()) {
                    create.addAll(create2);
                }
                create.add(obj);
            }
        }
        return create;
    }
}