package e.g.a.c;

import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* loaded from: classes2.dex */
final class a<T> extends c<T> {
    private final Integer a;

    /* renamed from: b  reason: collision with root package name */
    private final T f12969b;

    /* renamed from: c  reason: collision with root package name */
    private final d f12970c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Integer num, T t, d dVar) {
        this.a = num;
        Objects.requireNonNull(t, "Null payload");
        this.f12969b = t;
        Objects.requireNonNull(dVar, "Null priority");
        this.f12970c = dVar;
    }

    @Override // e.g.a.c.c
    public Integer a() {
        return this.a;
    }

    @Override // e.g.a.c.c
    public T b() {
        return this.f12969b;
    }

    @Override // e.g.a.c.c
    public d c() {
        return this.f12970c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            Integer num = this.a;
            if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
                if (this.f12969b.equals(cVar.b()) && this.f12970c.equals(cVar.c())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f12969b.hashCode()) * 1000003) ^ this.f12970c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.f12969b + ", priority=" + this.f12970c + "}";
    }
}