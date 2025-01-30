package kotlin.a0;

import java.util.Iterator;
import java.util.List;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes3.dex */
public final class u0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @kotlin.c0.i.a.e(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class a<T> extends kotlin.c0.i.a.j implements kotlin.e0.c.p<kotlin.k0.j<? super List<? extends T>>, kotlin.c0.d<? super kotlin.x>, Object> {

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f17224c;

        /* renamed from: d  reason: collision with root package name */
        Object f17225d;

        /* renamed from: e  reason: collision with root package name */
        Object f17226e;

        /* renamed from: f  reason: collision with root package name */
        int f17227f;

        /* renamed from: g  reason: collision with root package name */
        int f17228g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f17229h;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ int f17230j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Iterator f17231k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ boolean f17232l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, int i3, Iterator it, boolean z, boolean z2, kotlin.c0.d dVar) {
            super(2, dVar);
            this.f17229h = i2;
            this.f17230j = i3;
            this.f17231k = it;
            this.f17232l = z;
            this.m = z2;
        }

        @Override // kotlin.c0.i.a.a
        public final kotlin.c0.d<kotlin.x> f(Object obj, kotlin.c0.d<?> completion) {
            kotlin.jvm.internal.m.g(completion, "completion");
            a aVar = new a(this.f17229h, this.f17230j, this.f17231k, this.f17232l, this.m, completion);
            aVar.f17224c = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please submit an issue!!! */
        @Override // kotlin.c0.i.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object h(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.a0.u0.a.h(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.e0.c.p
        public final Object invoke(Object obj, kotlin.c0.d<? super kotlin.x> dVar) {
            return ((a) f(obj, dVar)).h(kotlin.x.a);
        }
    }

    public static final void a(int i2, int i3) {
        String str;
        if (i2 > 0 && i3 > 0) {
            return;
        }
        if (i2 != i3) {
            str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
        } else {
            str = "size " + i2 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> iterator, int i2, int i3, boolean z, boolean z2) {
        Iterator<List<T>> a2;
        kotlin.jvm.internal.m.g(iterator, "iterator");
        if (iterator.hasNext()) {
            a2 = kotlin.k0.l.a(new a(i2, i3, iterator, z2, z, null));
            return a2;
        }
        return a0.a;
    }
}