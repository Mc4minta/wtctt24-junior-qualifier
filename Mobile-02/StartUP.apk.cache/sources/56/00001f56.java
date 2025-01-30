package com.coinbase.wallet.features.pushnotifications.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.j;
import com.coinbase.wallet.application.MainActivity;
import com.coinbase.wallet.features.pushnotifications.viewmodels.PushNotificationViewModel;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: PushNotificationDisplayService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isBackgrounded", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class PushNotificationDisplayService$displayNotification$1 extends o implements l<Boolean, x> {
    final /* synthetic */ PushNotificationViewModel $viewModel;
    final /* synthetic */ PushNotificationDisplayService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushNotificationDisplayService$displayNotification$1(PushNotificationDisplayService pushNotificationDisplayService, PushNotificationViewModel pushNotificationViewModel) {
        super(1);
        this.this$0 = pushNotificationDisplayService;
        this.$viewModel = pushNotificationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        if (bool.booleanValue()) {
            Intent intent = new Intent(this.this$0.getContext(), MainActivity.class);
            Map<String, String> data = this.$viewModel.getData();
            if (data != null) {
                for (Map.Entry<String, String> entry : data.entrySet()) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
            j.e k2 = new j.e(this.this$0.getContext(), this.$viewModel.getChannelId()).B(R.drawable.ic_monochrome_white_circular_logo).m(this.$viewModel.getTitle()).l(this.$viewModel.getText()).y(1).n(-1).g(true).k(PendingIntent.getActivity(this.this$0.getContext(), this.$viewModel.getId(), intent, 0));
            m.f(k2, "Builder(context, viewModel.channelId)\n                    .setSmallIcon(R.drawable.ic_monochrome_white_circular_logo)\n                    .setContentTitle(viewModel.title)\n                    .setContentText(viewModel.text)\n                    .setPriority(NotificationCompat.PRIORITY_HIGH)\n                    .setDefaults(NotificationCompat.DEFAULT_ALL)\n                    .setAutoCancel(true)\n                    .setContentIntent(pendingIntent)");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(this.$viewModel.getChannelId(), this.this$0.getContext().getString(R.string.notification_channel_name), 3);
                Object systemService = this.this$0.getContext().getSystemService("notification");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
            }
            androidx.core.app.m.b(this.this$0.getContext()).d(this.$viewModel.getId(), k2.c());
        }
    }
}