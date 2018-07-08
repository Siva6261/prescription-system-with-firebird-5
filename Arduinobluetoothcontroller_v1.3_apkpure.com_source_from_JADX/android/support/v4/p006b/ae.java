package android.support.v4.p006b;

import android.os.Handler;
import android.os.Message;

class ae extends Handler {
    final /* synthetic */ ad f603a;

    ae(ad adVar) {
        this.f603a = adVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f603a.f595e) {
                    this.f603a.m975a(false);
                    return;
                }
                return;
            case 2:
                this.f603a.m977b();
                this.f603a.f592b.m1047o();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
