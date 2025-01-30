package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.m0;
import java.util.Map;

/* compiled from: PropsNode.java */
/* loaded from: classes2.dex */
public class q extends m implements j {
    private final Map<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    private final m0 f10991b;

    /* renamed from: c  reason: collision with root package name */
    private int f10992c;

    /* renamed from: d  reason: collision with root package name */
    private final JavaOnlyMap f10993d;

    /* renamed from: e  reason: collision with root package name */
    private final a0 f10994e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PropsNode.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            a = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public q(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar, m0 m0Var) {
        super(i2, readableMap, bVar);
        this.f10992c = -1;
        this.a = com.swmansion.reanimated.e.b(readableMap.getMap("props"));
        this.f10991b = m0Var;
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        this.f10993d = javaOnlyMap;
        this.f10994e = new a0(javaOnlyMap);
    }

    private static void c(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof WritableArray) {
            writableMap.putArray(str, (WritableArray) obj);
        } else if (obj instanceof WritableMap) {
            writableMap.putMap(str, (WritableMap) obj);
        } else {
            throw new IllegalStateException("Unknown type of animated value");
        }
    }

    @Override // com.swmansion.reanimated.nodes.j
    public void a() {
        if (this.f10992c == -1) {
            return;
        }
        value();
    }

    public void d(int i2) {
        this.f10992c = i2;
        dangerouslyRescheduleEvaluate();
    }

    public void e(int i2) {
        this.f10992c = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    public Double evaluate() {
        boolean z;
        boolean z2;
        boolean z3;
        WritableMap writableMap;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (Map.Entry<String, Integer> entry : this.a.entrySet()) {
            m o = this.mNodesManager.o(entry.getValue().intValue(), m.class);
            if (o instanceof s) {
                WritableMap writableMap2 = (WritableMap) o.value();
                ReadableMapKeySetIterator keySetIterator = writableMap2.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    if (this.mNodesManager.r.contains(nextKey)) {
                        writableMap = this.f10993d;
                        z2 = z6;
                        z = z5;
                        z3 = true;
                    } else if (this.mNodesManager.s.contains(nextKey)) {
                        z3 = z4;
                        z2 = z6;
                        z = true;
                        writableMap = createMap2;
                    } else {
                        z = z5;
                        z2 = true;
                        z3 = z4;
                        writableMap = createMap;
                    }
                    ReadableType type = writableMap2.getType(nextKey);
                    int i2 = a.a[type.ordinal()];
                    if (i2 == 1) {
                        writableMap.putDouble(nextKey, writableMap2.getDouble(nextKey));
                    } else if (i2 == 2) {
                        writableMap.putString(nextKey, writableMap2.getString(nextKey));
                    } else if (i2 == 3) {
                        writableMap.putArray(nextKey, (WritableArray) writableMap2.getArray(nextKey));
                    } else {
                        throw new IllegalArgumentException("Unexpected type " + type);
                    }
                    z4 = z3;
                    z5 = z;
                    z6 = z2;
                }
                continue;
            } else {
                String key = entry.getKey();
                Object value = o.value();
                if (this.mNodesManager.r.contains(key)) {
                    c(this.f10993d, key, value);
                    z4 = true;
                } else {
                    c(createMap2, key, value);
                    z5 = true;
                }
            }
        }
        int i3 = this.f10992c;
        if (i3 != -1) {
            if (z4) {
                this.f10991b.Z(i3, this.f10994e);
            }
            if (z5) {
                this.mNodesManager.n(this.f10992c, createMap2);
            }
            if (z6) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putInt("viewTag", this.f10992c);
                createMap3.putMap("props", createMap);
                this.mNodesManager.x("onReanimatedPropsChange", createMap3);
            }
        }
        return m.ZERO;
    }
}