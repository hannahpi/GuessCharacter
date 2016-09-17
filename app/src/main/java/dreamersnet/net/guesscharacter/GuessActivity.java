package dreamersnet.net.guesscharacter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuessActivity extends AppCompatActivity {
    private static final String EXTRA_CHAR_INFO = "net.dreamersnet.guesscharacter.char_info";
    private static final String EXTRA_ANSWER_CORRECT = "net.dreamersnet.guesscharacter.answer_correct";
    private Button mTarget1Button;
    private Button mTarget2Button;
    private Button mTarget3Button;
    private Button mTarget4Button;
    private int mButtonSelect;
    private Button mContinueButton;
    private ColorStateList restoreColors;
    private Character mCharacter;
    private int[] charInfo = new int[4];

    public static Intent newIntent(Context packageContext, int[] characterInfo){
        Intent i = new Intent(packageContext, GuessActivity.class);
        i.putExtra(EXTRA_CHAR_INFO, characterInfo);
        return i;
    }

    public static boolean wasAnswerCorrect(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_CORRECT, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        charInfo = getIntent().getIntArrayExtra(EXTRA_CHAR_INFO);
        mCharacter = new Character(charInfo);

        mTarget1Button = (Button) findViewById(R.id.target_1_button);
        mTarget2Button = (Button) findViewById(R.id.target_2_button);
        mTarget3Button = (Button) findViewById(R.id.target_3_button);
        mTarget4Button = (Button) findViewById(R.id.target_4_button);
        mContinueButton = (Button) findViewById(R.id.continue_button);
        restoreColors = mTarget1Button.getTextColors();

        mCharacter.shuffleTargets();
        mTarget1Button.setText(mCharacter.getTargetRes(0));
        mTarget2Button.setText(mCharacter.getTargetRes(1));
        mTarget3Button.setText(mCharacter.getTargetRes(2));
        mTarget4Button.setText(mCharacter.getTargetRes(3));

        mTarget1Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchColor((Button) v,mCharacter.getTargetRes(0));
            }
        });

        mTarget2Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchColor((Button) v,mCharacter.getTargetRes(1));
            }
        });

        mTarget3Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchColor((Button) v,mCharacter.getTargetRes(2));
            }
        });

        mTarget4Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchColor((Button) v,mCharacter.getTargetRes(3));
            }
        });

        mContinueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean isAnswerCorrect = mCharacter.isTargetRight(mButtonSelect);
                setAnswerCorrect(isAnswerCorrect);
            }
        });
    }

    private void setAnswerCorrect(boolean isAnswerCorrect) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_CORRECT, isAnswerCorrect);
        setResult(RESULT_OK, data);
    }

    private void switchColor(Button b, int textResId) {
        mTarget1Button.setTextColor(restoreColors);
        mTarget2Button.setTextColor(restoreColors);
        mTarget3Button.setTextColor(restoreColors);
        mTarget4Button.setTextColor(restoreColors);
        b.setTextColor(Color.BLUE);
        b.setBackgroundColor(Color.WHITE);
        mButtonSelect = textResId;
        mContinueButton.setEnabled(true);
    }
}
