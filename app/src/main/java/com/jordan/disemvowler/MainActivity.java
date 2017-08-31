package com.jordan.disemvowler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textValue;
    TextView outputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValue = (EditText) findViewById(R.id.editText);
        outputText = (TextView) findViewById(R.id.textView3);

        textValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    outputText.setText(translate(textValue.getText().toString()));
                }
                return false;
            }
        });

    }


    public String translate(String word) {

        StringBuilder pigLatin = new StringBuilder();
        char letter = word.charAt(0);

        for (int x = 0; x < word.length(); x++) {
            if ((!(word.charAt(x) == ' ')) && ((x > 0))) {
                if (!(word.charAt(x - 1) == ' ')) {
                    pigLatin.append(word.charAt(x));
                }

            }

            if (word.charAt(x) == ' ') {

                pigLatin.append(letter + "ay ");
                letter = word.charAt(x + 1);
            }

            if (x == word.length() - 1) {
                pigLatin.append(letter + "ay ");

            }
        }

        return pigLatin.toString();
    }

    public String backwards(String word) {

        StringBuilder backward = new StringBuilder();

        for (int x = (word.length() - 1); x >= 0; x--) {
            backward.append(word.charAt(x));
        }
        return backward.toString();
    }
}
