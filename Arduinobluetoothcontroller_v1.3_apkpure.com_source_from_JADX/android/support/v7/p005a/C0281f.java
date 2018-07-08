package android.support.v7.p005a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class C0281f implements OnClickListener {
    final /* synthetic */ C0280e f1364a;

    C0281f(C0280e c0280e) {
        this.f1364a = c0280e;
    }

    public void onClick(View view) {
        Message obtain = (view != this.f1364a.f1351n || this.f1364a.f1353p == null) ? (view != this.f1364a.f1354q || this.f1364a.f1356s == null) ? (view != this.f1364a.f1357t || this.f1364a.f1359v == null) ? null : Message.obtain(this.f1364a.f1359v) : Message.obtain(this.f1364a.f1356s) : Message.obtain(this.f1364a.f1353p);
        if (obtain != null) {
            obtain.sendToTarget();
        }
        this.f1364a.f1336M.obtainMessage(1, this.f1364a.f1339b).sendToTarget();
    }
}
