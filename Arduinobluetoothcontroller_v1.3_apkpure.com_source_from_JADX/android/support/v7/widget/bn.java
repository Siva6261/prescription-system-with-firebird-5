package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

class bn implements OnDismissListener {
    final /* synthetic */ OnGlobalLayoutListener f2048a;
    final /* synthetic */ bk f2049b;

    bn(bk bkVar, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f2049b = bkVar;
        this.f2048a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f2049b.f2041a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2048a);
        }
    }
}
