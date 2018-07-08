package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008c.C0066a;
import android.support.v4.view.bp;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.C0315e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class bh extends Spinner implements bp {
    private static final boolean f1993a = (VERSION.SDK_INT >= 23);
    private static final boolean f1994b = (VERSION.SDK_INT >= 16);
    private static final int[] f1995c = new int[]{16843505};
    private aq f1996d;
    private am f1997e;
    private Context f1998f;
    private dc f1999g;
    private SpinnerAdapter f2000h;
    private boolean f2001i;
    private bk f2002j;
    private int f2003k;
    private final Rect f2004l;

    public bh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.spinnerStyle);
    }

    public bh(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public bh(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public bh(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f2004l = new Rect();
        gf a = gf.m4787a(context, attributeSet, C0308l.Spinner, i, 0);
        this.f1996d = aq.m4079a();
        this.f1997e = new am(this, this.f1996d);
        if (theme != null) {
            this.f1998f = new C0315e(context, theme);
        } else {
            int g = a.m4803g(C0308l.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f1998f = new C0315e(context, g);
            } else {
                this.f1998f = !f1993a ? context : null;
            }
        }
        if (this.f1998f != null) {
            bk bkVar;
            gf a2;
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes;
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1995c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    bkVar = new bk(this, this.f1998f, attributeSet, i);
                                    a2 = gf.m4787a(this.f1998f, attributeSet, C0308l.Spinner, i, 0);
                                    this.f2003k = a2.m4801f(C0308l.Spinner_android_dropDownWidth, -2);
                                    bkVar.m4141a(a2.m4790a(C0308l.Spinner_android_popupBackground));
                                    bkVar.m4171a(a.m4798d(C0308l.Spinner_android_prompt));
                                    a2.m4791a();
                                    this.f2002j = bkVar;
                                    this.f1999g = new bi(this, this, bkVar);
                                }
                                e2 = a.m4800e(C0308l.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, C0305i.support_simple_spinner_dropdown_item, e2);
                                    arrayAdapter.setDropDownViewResource(C0305i.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a.m4791a();
                                this.f2001i = true;
                                if (this.f2000h != null) {
                                    setAdapter(this.f2000h);
                                    this.f2000h = null;
                                }
                                this.f1997e.m4062a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bkVar = new bk(this, this.f1998f, attributeSet, i);
                            a2 = gf.m4787a(this.f1998f, attributeSet, C0308l.Spinner, i, 0);
                            this.f2003k = a2.m4801f(C0308l.Spinner_android_dropDownWidth, -2);
                            bkVar.m4141a(a2.m4790a(C0308l.Spinner_android_popupBackground));
                            bkVar.m4171a(a.m4798d(C0308l.Spinner_android_prompt));
                            a2.m4791a();
                            this.f2002j = bkVar;
                            this.f1999g = new bi(this, this, bkVar);
                        }
                        e2 = a.m4800e(C0308l.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, C0305i.support_simple_spinner_dropdown_item, e2);
                            arrayAdapter.setDropDownViewResource(C0305i.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a.m4791a();
                        this.f2001i = true;
                        if (this.f2000h != null) {
                            setAdapter(this.f2000h);
                            this.f2000h = null;
                        }
                        this.f1997e.m4062a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                bkVar = new bk(this, this.f1998f, attributeSet, i);
                a2 = gf.m4787a(this.f1998f, attributeSet, C0308l.Spinner, i, 0);
                this.f2003k = a2.m4801f(C0308l.Spinner_android_dropDownWidth, -2);
                bkVar.m4141a(a2.m4790a(C0308l.Spinner_android_popupBackground));
                bkVar.m4171a(a.m4798d(C0308l.Spinner_android_prompt));
                a2.m4791a();
                this.f2002j = bkVar;
                this.f1999g = new bi(this, this, bkVar);
            }
        }
        e2 = a.m4800e(C0308l.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, C0305i.support_simple_spinner_dropdown_item, e2);
            arrayAdapter.setDropDownViewResource(C0305i.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a.m4791a();
        this.f2001i = true;
        if (this.f2000h != null) {
            setAdapter(this.f2000h);
            this.f2000h = null;
        }
        this.f1997e.m4062a(attributeSet, i);
    }

    private int m4125a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2004l);
        return (this.f2004l.left + this.f2004l.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1997e != null) {
            this.f1997e.m4065c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.f2002j != null ? this.f2002j.m4154f() : f1994b ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.f2002j != null ? this.f2002j.m4156g() : f1994b ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.f2002j != null ? this.f2003k : f1994b ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.f2002j != null ? this.f2002j.m4150d() : f1994b ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.f2002j != null ? this.f1998f : f1993a ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.f2002j != null ? this.f2002j.mo704a() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1997e != null ? this.f1997e.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1997e != null ? this.f1997e.m4063b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2002j != null && this.f2002j.m4162k()) {
            this.f2002j.m4160i();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2002j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m4125a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1999g == null || !this.f1999g.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.f2002j == null || this.f2002j.m4162k()) {
            return super.performClick();
        }
        this.f2002j.mo707c();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f2001i) {
            super.setAdapter(spinnerAdapter);
            if (this.f2002j != null) {
                this.f2002j.mo705a(new bj(spinnerAdapter, (this.f1998f == null ? getContext() : this.f1998f).getTheme()));
                return;
            }
            return;
        }
        this.f2000h = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1997e != null) {
            this.f1997e.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1997e != null) {
            this.f1997e.m4058a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2002j != null) {
            this.f2002j.m4147b(i);
        } else if (f1994b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2002j != null) {
            this.f2002j.m4149c(i);
        } else if (f1994b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f2002j != null) {
            this.f2003k = i;
        } else if (f1994b) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2002j != null) {
            this.f2002j.m4141a(drawable);
        } else if (f1994b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0066a.m958a(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2002j != null) {
            this.f2002j.m4171a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1997e != null) {
            this.f1997e.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1997e != null) {
            this.f1997e.m4060a(mode);
        }
    }
}
