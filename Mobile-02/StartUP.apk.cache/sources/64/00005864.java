package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Map;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends o implements l<Name, ClassDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;
    final /* synthetic */ DeserializedClassDescriptor this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
        this.this$1 = deserializedClassDescriptor;
    }

    @Override // kotlin.e0.c.l
    public final ClassDescriptor invoke(Name name) {
        Map map;
        NotNullLazyValue notNullLazyValue;
        m.g(name, "name");
        map = this.this$0.enumEntryProtos;
        ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) map.get(name);
        if (enumEntry == null) {
            return null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$1;
        DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = this.this$0;
        StorageManager storageManager = deserializedClassDescriptor.getC().getStorageManager();
        notNullLazyValue = enumEntryClassDescriptors.enumMemberNames;
        return EnumEntrySyntheticClassDescriptor.create(storageManager, deserializedClassDescriptor, name, notNullLazyValue, new DeserializedAnnotations(deserializedClassDescriptor.getC().getStorageManager(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(deserializedClassDescriptor, enumEntry)), SourceElement.NO_SOURCE);
    }
}