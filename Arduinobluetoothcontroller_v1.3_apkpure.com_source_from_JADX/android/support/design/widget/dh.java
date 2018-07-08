package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class dh extends ImageButton {
    private int f267a;

    public dh(Context context) {
        this(context, null);
    }

    public dh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public dh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f267a = getVisibility();
    }

    final void m436a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f267a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f267a;
    }

    public void setVisibility(int i) {
        m436a(i, true);
    }
}
