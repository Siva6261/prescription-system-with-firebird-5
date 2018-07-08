package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

class C0255o extends ContentObserver {
    final /* synthetic */ C0242m f1146a;

    public C0255o(C0242m c0242m) {
        this.f1146a = c0242m;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f1146a.m2634b();
    }
}
