package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p008c.C0066a;
import android.support.v4.widget.bj;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class be extends RadioButton implements bj {
    private aq f1987a;
    private ap f1988b;

    public be(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.radioButtonStyle);
    }

    public be(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1987a = aq.m4079a();
        this.f1988b = new ap(this, this.f1987a);
        this.f1988b.m4070a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1988b != null ? this.f1988b.m4066a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f1988b != null ? this.f1988b.m4067a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f1988b != null ? this.f1988b.m4071b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1987a != null ? this.f1987a.m4100a(getContext(), i) : C0066a.m958a(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1988b != null) {
            this.f1988b.m4072c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1988b != null) {
            this.f1988b.m4068a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f1988b != null) {
            this.f1988b.m4069a(mode);
        }
    }
}
