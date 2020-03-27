package com.example.petsocial.util.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.petsocial.R;

public class EditCommentDialog extends Dialog {
    private Context mContext;
    private OnButtonListener onButtonListener;

    public EditCommentDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_edit_comment);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.horizontalMargin = 0f;
        window.setAttributes(layoutParams);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(Gravity.BOTTOM);

        EditText editComment = findViewById(R.id.editCommentDialog);
        TextView tvSend = findViewById(R.id.tvSendCommentDialog);
        tvSend.setOnClickListener(v ->
                {
                    if (onButtonListener != null) {
                        onButtonListener.onSendDialog(editComment.getText().toString());
                    }
                }
        );
        editComment.requestFocus();
        editComment.setOnEditorActionListener((t, i, k) -> {
            showSoftInput();
            return false;
        });
    }

    public void setListener(OnButtonListener onButtonListener) {
        this.onButtonListener = onButtonListener;
    }


    public interface OnButtonListener {

        void onSendDialog(String s);

    }


    public void showSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
