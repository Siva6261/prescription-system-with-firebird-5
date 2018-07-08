package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p010d.C0132a;

class C0054s extends Drawable {
    final Paint f525a = new Paint(1);
    final Rect f526b = new Rect();
    final RectF f527c = new RectF();
    float f528d;
    private int f529e;
    private int f530f;
    private int f531g;
    private int f532h;
    private ColorStateList f533i;
    private int f534j;
    private boolean f535k = true;
    private float f536l;

    public C0054s() {
        this.f525a.setStyle(Style.STROKE);
    }

    private Shader m908a() {
        Rect rect = this.f526b;
        copyBounds(rect);
        float height = this.f528d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0132a.m1450a(this.f529e, this.f534j), C0132a.m1450a(this.f530f, this.f534j), C0132a.m1450a(C0132a.m1452b(this.f530f, 0), this.f534j), C0132a.m1450a(C0132a.m1452b(this.f532h, 0), this.f534j), C0132a.m1450a(this.f532h, this.f534j), C0132a.m1450a(this.f531g, this.f534j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    void m909a(float f) {
        if (this.f528d != f) {
            this.f528d = f;
            this.f525a.setStrokeWidth(1.3333f * f);
            this.f535k = true;
            invalidateSelf();
        }
    }

    void m910a(int i, int i2, int i3, int i4) {
        this.f529e = i;
        this.f530f = i2;
        this.f531g = i3;
        this.f532h = i4;
    }

    void m911a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f534j = colorStateList.getColorForState(getState(), this.f534j);
        }
        this.f533i = colorStateList;
        this.f535k = true;
        invalidateSelf();
    }

    final void m912b(float f) {
        if (f != this.f536l) {
            this.f536l = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f535k) {
            this.f525a.setShader(m908a());
            this.f535k = false;
        }
        float strokeWidth = this.f525a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f527c;
        copyBounds(this.f526b);
        rectF.set(this.f526b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f536l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f525a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.f528d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f528d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.f533i != null && this.f533i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.f535k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f533i != null) {
            int colorForState = this.f533i.getColorForState(iArr, this.f534j);
            if (colorForState != this.f534j) {
                this.f535k = true;
                this.f534j = colorForState;
            }
        }
        if (this.f535k) {
            invalidateSelf();
        }
        return this.f535k;
    }

    public void setAlpha(int i) {
        this.f525a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f525a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
