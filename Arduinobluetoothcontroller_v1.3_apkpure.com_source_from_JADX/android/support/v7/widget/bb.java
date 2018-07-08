package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.ah;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class bb extends PopupWindow {
    private static final boolean f1978a = (VERSION.SDK_INT < 21);
    private boolean f1979b;

    public bb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        gf a = gf.m4787a(context, attributeSet, C0308l.PopupWindow, i, 0);
        if (a.m4802f(C0308l.PopupWindow_overlapAnchor)) {
            m4117a(a.m4792a(C0308l.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m4790a(C0308l.PopupWindow_android_popupBackground));
        a.m4791a();
        if (VERSION.SDK_INT < 14) {
            m4116a((PopupWindow) this);
        }
    }

    private static void m4116a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new bc(declaredField, popupWindow, (OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m4117a(boolean z) {
        if (f1978a) {
            this.f1979b = z;
        } else {
            ah.m2605a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1978a && this.f1979b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1978a && this.f1979b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (f1978a && this.f1979b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
