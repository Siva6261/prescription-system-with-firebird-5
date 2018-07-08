package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

class bg extends bd {
    private static final int[] f1991b = new int[]{16843074};
    private final SeekBar f1992c;

    bg(SeekBar seekBar, aq aqVar) {
        super(seekBar, aqVar);
        this.f1992c = seekBar;
    }

    void mo703a(AttributeSet attributeSet, int i) {
        super.mo703a(attributeSet, i);
        gf a = gf.m4787a(this.f1992c.getContext(), attributeSet, f1991b, i, 0);
        Drawable b = a.m4794b(0);
        if (b != null) {
            this.f1992c.setThumb(b);
        }
        a.m4791a();
    }
}
