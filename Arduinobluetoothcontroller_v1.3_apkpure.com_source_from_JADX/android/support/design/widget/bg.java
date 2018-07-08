package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.C0023d;
import android.support.v7.p003c.p004a.C0034a;

class bg extends C0034a {
    static final double f371a = Math.cos(Math.toRadians(45.0d));
    final Paint f372b;
    final Paint f373c;
    final RectF f374d;
    float f375e;
    Path f376f;
    float f377g;
    float f378h;
    float f379i;
    float f380j;
    private boolean f381k = true;
    private final int f382l;
    private final int f383m;
    private final int f384n;
    private boolean f385o = true;
    private float f386p;
    private boolean f387q = false;

    public bg(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f382l = resources.getColor(C0023d.design_fab_shadow_start_color);
        this.f383m = resources.getColor(C0023d.design_fab_shadow_mid_color);
        this.f384n = resources.getColor(C0023d.design_fab_shadow_end_color);
        this.f372b = new Paint(5);
        this.f372b.setStyle(Style.FILL);
        this.f375e = (float) Math.round(f);
        this.f374d = new RectF();
        this.f373c = new Paint(this.f372b);
        this.f373c.setAntiAlias(false);
        m620a(f2, f3);
    }

    public static float m612a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f371a) * ((double) f2))) : 1.5f * f;
    }

    private void m613a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f386p, this.f374d.centerX(), this.f374d.centerY());
        float f = (-this.f375e) - this.f379i;
        float f2 = this.f375e;
        Object obj = this.f374d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f374d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f380j - (this.f380j * 0.5f)) + f2);
        float f4 = f2 / ((this.f380j - (this.f380j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f380j - (this.f380j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f374d.left + f2, this.f374d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f376f, this.f372b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f374d.width() - (2.0f * f2), -this.f375e, this.f373c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f374d.right - f2, this.f374d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f376f, this.f372b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f374d.width() - (2.0f * f2), this.f379i + (-this.f375e), this.f373c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f374d.left + f2, this.f374d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f376f, this.f372b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f374d.height() - (2.0f * f2), -this.f375e, this.f373c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f374d.right - f2, this.f374d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f376f, this.f372b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f374d.height() - (2.0f * f2), -this.f375e, this.f373c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m614a(Rect rect) {
        float f = this.f378h * 1.5f;
        this.f374d.set(((float) rect.left) + this.f378h, ((float) rect.top) + f, ((float) rect.right) - this.f378h, ((float) rect.bottom) - f);
        m611b().setBounds((int) this.f374d.left, (int) this.f374d.top, (int) this.f374d.right, (int) this.f374d.bottom);
        m616c();
    }

    public static float m615b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f371a) * ((double) f2))) : f;
    }

    private void m616c() {
        RectF rectF = new RectF(-this.f375e, -this.f375e, this.f375e, this.f375e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f379i, -this.f379i);
        if (this.f376f == null) {
            this.f376f = new Path();
        } else {
            this.f376f.reset();
        }
        this.f376f.setFillType(FillType.EVEN_ODD);
        this.f376f.moveTo(-this.f375e, 0.0f);
        this.f376f.rLineTo(-this.f379i, 0.0f);
        this.f376f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f376f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f376f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f375e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f372b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f382l, this.f383m, this.f384n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f373c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f382l, this.f383m, this.f384n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f373c.setAntiAlias(false);
    }

    private static int m617d(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public float m618a() {
        return this.f380j;
    }

    final void m619a(float f) {
        if (this.f386p != f) {
            this.f386p = f;
            invalidateSelf();
        }
    }

    void m620a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float d = (float) m617d(f);
        float d2 = (float) m617d(f2);
        if (d > d2) {
            if (!this.f387q) {
                this.f387q = true;
            }
            d = d2;
        }
        if (this.f380j != d || this.f378h != d2) {
            this.f380j = d;
            this.f378h = d2;
            this.f379i = (float) Math.round(d * 1.5f);
            this.f377g = d2;
            this.f381k = true;
            invalidateSelf();
        }
    }

    public void m621a(boolean z) {
        this.f385o = z;
        invalidateSelf();
    }

    public void m622b(float f) {
        m620a(f, this.f378h);
    }

    public void m623c(float f) {
        m620a(this.f380j, f);
    }

    public void draw(Canvas canvas) {
        if (this.f381k) {
            m614a(getBounds());
            this.f381k = false;
        }
        m613a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m612a(this.f378h, this.f375e, this.f385o));
        int ceil2 = (int) Math.ceil((double) m615b(this.f378h, this.f375e, this.f385o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f381k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f372b.setAlpha(i);
        this.f373c.setAlpha(i);
    }
}
