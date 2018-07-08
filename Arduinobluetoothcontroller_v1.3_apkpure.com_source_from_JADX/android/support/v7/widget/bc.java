package android.support.v7.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class bc implements OnScrollChangedListener {
    final /* synthetic */ Field f1980a;
    final /* synthetic */ PopupWindow f1981b;
    final /* synthetic */ OnScrollChangedListener f1982c;

    bc(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
        this.f1980a = field;
        this.f1981b = popupWindow;
        this.f1982c = onScrollChangedListener;
    }

    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.f1980a.get(this.f1981b);
            if (weakReference != null && weakReference.get() != null) {
                this.f1982c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
