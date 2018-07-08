package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class fi {
    private Method f2304a;
    private Method f2305b;
    private Method f2306c;
    private Method f2307d;

    fi() {
        try {
            this.f2304a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.f2304a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.f2305b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.f2305b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.f2306c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.f2306c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.f2307d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.f2307d.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    void m4699a(AutoCompleteTextView autoCompleteTextView) {
        if (this.f2304a != null) {
            try {
                this.f2304a.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void m4700a(AutoCompleteTextView autoCompleteTextView, boolean z) {
        if (this.f2306c != null) {
            try {
                this.f2306c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
            }
        }
    }

    void m4701b(AutoCompleteTextView autoCompleteTextView) {
        if (this.f2305b != null) {
            try {
                this.f2305b.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }
}
