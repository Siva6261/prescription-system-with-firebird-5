package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

class by implements Callback {
    final /* synthetic */ bx f408a;

    by(bx bxVar) {
        this.f408a = bxVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f408a.m658b((ca) message.obj);
                return true;
            default:
                return false;
        }
    }
}
