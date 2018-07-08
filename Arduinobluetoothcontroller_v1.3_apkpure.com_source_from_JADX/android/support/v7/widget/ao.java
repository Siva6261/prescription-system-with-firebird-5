package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class ao extends CheckedTextView {
    private static final int[] f1937a = new int[]{16843016};
    private aq f1938b;
    private bo f1939c;

    public ao(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public ao(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1939c = bo.m4174a((TextView) this);
        this.f1939c.mo709a(attributeSet, i);
        this.f1939c.mo708a();
        this.f1938b = aq.m4079a();
        gf a = gf.m4787a(getContext(), attributeSet, f1937a, i, 0);
        setCheckMarkDrawable(a.m4790a(0));
        a.m4791a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1939c != null) {
            this.f1939c.mo708a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f1938b != null) {
            setCheckMarkDrawable(this.f1938b.m4100a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1939c != null) {
            this.f1939c.m4177a(context, i);
        }
    }
}
