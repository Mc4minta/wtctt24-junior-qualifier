package e.j.n;

import android.content.res.Resources;
import com.toshi.model.local.Library;
import java.util.List;
import org.toshi.R;

/* compiled from: LicenseListViewModel.kt */
/* loaded from: classes2.dex */
public final class n2 extends androidx.lifecycle.b0 {
    private final e.j.l.k<Library> a = new e.j.l.k<>();

    public final List<Library> a(Resources resources) {
        List<Library> j2;
        kotlin.jvm.internal.m.g(resources, "resources");
        j2 = kotlin.a0.r.j(new Library("Ethereumj", resources.getString(R.string.mit_license)), new Library("Spongycastle", resources.getString(R.string.mit_license)), new Library("Glide", resources.getString(R.string.glide_license)), new Library("Android Support Library RecyclerView", resources.getString(R.string.apache_v2_license)), new Library("Android Support Library GridLayout", resources.getString(R.string.apache_v2_license)), new Library("Android Support Library Appcompat", resources.getString(R.string.apache_v2_license)), new Library("Android Support Library Design", resources.getString(R.string.apache_v2_license)), new Library("Android Support Library CardView", resources.getString(R.string.apache_v2_license)), new Library("Android Support Library Multidex", resources.getString(R.string.apache_v2_license)), new Library("Rxjava Proguard Rules", resources.getString(R.string.apache_v2_license)), new Library("RxAndroid", resources.getString(R.string.apache_v2_license)), new Library("RxBinding", resources.getString(R.string.apache_v2_license)), new Library("CircleImageView", resources.getString(R.string.apache_v2_license)), new Library("ZxingAndroidEmbedded", resources.getString(R.string.apache_v2_license)), new Library("Bitcoinj-core", resources.getString(R.string.apache_v2_license)), new Library("WhisperSystems Libsignal-service", resources.getString(R.string.apache_v2_license)), new Library("Google Cloud Messaging Play Services", resources.getString(R.string.apache_v2_license)), new Library("Retrofit", resources.getString(R.string.apache_v2_license)), new Library("Retrofit Converter Moshi", resources.getString(R.string.apache_v2_license)), new Library("Retrofit Adapter Rxjava", resources.getString(R.string.apache_v2_license)), new Library("Retrofit Converter Scalars", resources.getString(R.string.apache_v2_license)), new Library("OkHttp 3", resources.getString(R.string.apache_v2_license)), new Library("OkHttp 3 Logging Interceptor", resources.getString(R.string.apache_v2_license)), new Library("Cropiwa", resources.getString(R.string.apache_v2_license)), new Library("FlexboxLayout", resources.getString(R.string.apache_v2_license)), new Library("emoji-java", resources.getString(R.string.mit_license)), new Library("RoundedImageView", resources.getString(R.string.apache_v2_license)), new Library("Babel", resources.getString(R.string.mit_license)), new Library("eth-json-rpc-filters", resources.getString(R.string.mm_isc_license)), new Library("eth-block-tracker", resources.getString(R.string.mm_mit_license)), new Library("safe-event-emitter", resources.getString(R.string.mm_isc_license)), new Library("json-rpc-engine", resources.getString(R.string.mm_isc_license)), new Library("eth-rpc-errors", resources.getString(R.string.mm_mit_license)));
        return j2;
    }

    public final e.j.l.k<Library> b() {
        return this.a;
    }

    public final void c(Library library) {
        kotlin.jvm.internal.m.g(library, "library");
        this.a.l(library);
    }
}