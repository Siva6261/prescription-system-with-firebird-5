package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

final class bi implements Callback {
    bi() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                ((Snackbar) message.obj).m474c();
                return true;
            case 1:
                ((Snackbar) message.obj).m475c(message.arg1);
                return true;
            default:
                return false;
        }
    }
}
