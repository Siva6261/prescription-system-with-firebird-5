package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

class C0049p implements OnClickListener {
    final /* synthetic */ C0048o f470a;

    C0049p(C0048o c0048o) {
        this.f470a = c0048o;
    }

    public void onClick(View view) {
        if (this.f470a.isShowing()) {
            this.f470a.cancel();
        }
    }
}
