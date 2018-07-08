package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.util.AttributeSet;
import android.widget.TextView;

public class bq extends TextView implements bp {
    private aq f1498a;
    private am f1499b;
    private bo f1500c;

    public bq(Context context) {
        this(context, null);
    }

    public bq(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public bq(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1498a = aq.m4079a();
        this.f1499b = new am(this, this.f1498a);
        this.f1499b.m4062a(attributeSet, i);
        this.f1500c = bo.m4174a((TextView) this);
        this.f1500c.mo709a(attributeSet, i);
        this.f1500c.mo708a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1499b != null) {
            this.f1499b.m4065c();
        }
        if (this.f1500c != null) {
            this.f1500c.mo708a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1499b != null ? this.f1499b.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1499b != null ? this.f1499b.m4063b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1499b != null) {
            this.f1499b.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1499b != null) {
            this.f1499b.m4058a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1499b != null) {
            this.f1499b.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1499b != null) {
            this.f1499b.m4060a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1500c != null) {
            this.f1500c.m4177a(context, i);
        }
    }
}
