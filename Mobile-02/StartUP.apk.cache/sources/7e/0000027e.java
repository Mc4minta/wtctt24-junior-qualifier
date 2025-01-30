package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.jvm.internal.m;
import kotlin.o;
import org.apache.http.message.TokenParser;

/* compiled from: Bundle.kt */
/* loaded from: classes.dex */
public final class b {
    public static final Bundle a(o<String, ? extends Object>... pairs) {
        m.g(pairs, "pairs");
        Bundle bundle = new Bundle(pairs.length);
        for (o<String, ? extends Object> oVar : pairs) {
            String a = oVar.a();
            Object b2 = oVar.b();
            if (b2 == null) {
                bundle.putString(a, null);
            } else if (b2 instanceof Boolean) {
                bundle.putBoolean(a, ((Boolean) b2).booleanValue());
            } else if (b2 instanceof Byte) {
                bundle.putByte(a, ((Number) b2).byteValue());
            } else if (b2 instanceof Character) {
                bundle.putChar(a, ((Character) b2).charValue());
            } else if (b2 instanceof Double) {
                bundle.putDouble(a, ((Number) b2).doubleValue());
            } else if (b2 instanceof Float) {
                bundle.putFloat(a, ((Number) b2).floatValue());
            } else if (b2 instanceof Integer) {
                bundle.putInt(a, ((Number) b2).intValue());
            } else if (b2 instanceof Long) {
                bundle.putLong(a, ((Number) b2).longValue());
            } else if (b2 instanceof Short) {
                bundle.putShort(a, ((Number) b2).shortValue());
            } else if (b2 instanceof Bundle) {
                bundle.putBundle(a, (Bundle) b2);
            } else if (b2 instanceof CharSequence) {
                bundle.putCharSequence(a, (CharSequence) b2);
            } else if (b2 instanceof Parcelable) {
                bundle.putParcelable(a, (Parcelable) b2);
            } else if (b2 instanceof boolean[]) {
                bundle.putBooleanArray(a, (boolean[]) b2);
            } else if (b2 instanceof byte[]) {
                bundle.putByteArray(a, (byte[]) b2);
            } else if (b2 instanceof char[]) {
                bundle.putCharArray(a, (char[]) b2);
            } else if (b2 instanceof double[]) {
                bundle.putDoubleArray(a, (double[]) b2);
            } else if (b2 instanceof float[]) {
                bundle.putFloatArray(a, (float[]) b2);
            } else if (b2 instanceof int[]) {
                bundle.putIntArray(a, (int[]) b2);
            } else if (b2 instanceof long[]) {
                bundle.putLongArray(a, (long[]) b2);
            } else if (b2 instanceof short[]) {
                bundle.putShortArray(a, (short[]) b2);
            } else if (b2 instanceof Object[]) {
                Class<?> componentType = b2.getClass().getComponentType();
                m.e(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(a, (Parcelable[]) b2);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(a, (String[]) b2);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(a, (CharSequence[]) b2);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(a, (Serializable) b2);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + a + TokenParser.DQUOTE);
                }
            } else if (b2 instanceof Serializable) {
                bundle.putSerializable(a, (Serializable) b2);
            } else {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 18 && (b2 instanceof IBinder)) {
                    bundle.putBinder(a, (IBinder) b2);
                } else if (i2 >= 21 && (b2 instanceof Size)) {
                    bundle.putSize(a, (Size) b2);
                } else if (i2 >= 21 && (b2 instanceof SizeF)) {
                    bundle.putSizeF(a, (SizeF) b2);
                } else {
                    throw new IllegalArgumentException("Illegal value type " + b2.getClass().getCanonicalName() + " for key \"" + a + TokenParser.DQUOTE);
                }
            }
        }
        return bundle;
    }
}