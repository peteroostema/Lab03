package edu.calvin.pno2.lab03;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/* LoginActivity implements a password field that displays an android
 *   if the password "safepassword" was entered and otherwise displays
 *   text saying the password is invalid
 *
 * @author Peter Oostema, pno2
 * @version 9/23/16
 * Calvin College CS 262
 */
public class LoginActivity extends Activity {

    private EditText passwordEditText;
    private TextView invalidTextView;
    private ImageView androidImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // initialize all fields with invisibility
        invalidTextView = (TextView) findViewById(R.id.invalidTextView);
        invalidTextView.setVisibility(View.GONE);
        androidImageView = (ImageView) findViewById(R.id.androidImageView);
        androidImageView.setVisibility(View.GONE);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String password = passwordEditText.getText().toString();
                // When the correct password is entered set image to visible and text to gone
                if (password.equals("safepassword")) {
                    invalidTextView.setVisibility(View.GONE);
                    androidImageView.setVisibility(View.VISIBLE);
                } else {
                    invalidTextView.setVisibility(View.VISIBLE);
                    androidImageView.setVisibility(View.GONE);
                }
                return false;
            }
        });
    }
}
