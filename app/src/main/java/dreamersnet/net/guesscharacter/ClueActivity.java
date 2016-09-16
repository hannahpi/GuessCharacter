package dreamersnet.net.guesscharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ClueActivity extends AppCompatActivity {
    private TextView mHintsLeftTextView;
    private TextView mHintTextView;
    private Button mGuessButton;
    private Button mNextButton;
    private int curCharacter=0;
    private int curHint=1;
    Random rand = new Random();
    private Target[] mTargetBank = new Target[] {
            new Target(R.string.target_bowser),
            new Target(R.string.target_daisy),
            new Target(R.string.target_iggy_koopa),
            new Target(R.string.target_king_boo),
            new Target(R.string.target_king_k_rool),
            new Target(R.string.target_lemmy_koopa),
            new Target(R.string.target_luigi),
            new Target(R.string.target_mario),
            new Target(R.string.target_peach),
            new Target(R.string.target_samus),
            new Target(R.string.target_tatanga),
            new Target(R.string.target_toad),
            new Target(R.string.target_waluigi),
            new Target(R.string.target_wario),
            new Target(R.string.target_zelda),
    };

    private Character[] mCharacterBank = new Character[] {
            new Character(R.string.target_daisy ),
            new Character(R.string.target_peach),
            new Character(R.string.target_mario),
            new Character(R.string.target_luigi),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);

        mHintsLeftTextView = (TextView) findViewById(R.id.hints_left_text_view);
        mHintTextView = (TextView) findViewById(R.id.hint_text_view);
        mGuessButton = (Button) findViewById(R.id.guess_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curHint < mCharacterBank[curCharacter].getNumHints()) {
                    curHint = curHint +1;
                }
                updateUI();
            }
        });
        mGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start Guess Button
                //Intent i = Activity.newIntent(ClueActivity.this ??);
            }
        });

        mCharacterBank[0].addHint(R.string.hint_daisy_1);
        mCharacterBank[0].addHint(R.string.hint_daisy_2);
        mCharacterBank[0].addHint(R.string.hint_daisy_3);
        mCharacterBank[0].addHint(R.string.hint_daisy_4);
        mCharacterBank[0].addHint(R.string.hint_daisy_5);
        mCharacterBank[1].addHint(R.string.hint_peach_1);
        mCharacterBank[1].addHint(R.string.hint_peach_2);
        mCharacterBank[1].addHint(R.string.hint_peach_3);
        mCharacterBank[1].addHint(R.string.hint_peach_4);
        mCharacterBank[1].addHint(R.string.hint_peach_5);
        mCharacterBank[2].addHint(R.string.hint_mario_1);
        mCharacterBank[2].addHint(R.string.hint_mario_2);
        mCharacterBank[2].addHint(R.string.hint_mario_3);
        mCharacterBank[2].addHint(R.string.hint_mario_4);
        mCharacterBank[2].addHint(R.string.hint_mario_5);
        mCharacterBank[3].addHint(R.string.hint_luigi_1);
        mCharacterBank[3].addHint(R.string.hint_luigi_2);
        mCharacterBank[3].addHint(R.string.hint_luigi_3);
        mCharacterBank[3].addHint(R.string.hint_luigi_4);
        mCharacterBank[3].addHint(R.string.hint_luigi_5);
        //populate the targets randomly...
        for (int chbank = 0; chbank < mCharacterBank.length; chbank++) {
            for (int t=0; t<3; t++) {
                mCharacterBank[chbank].addTarget(mTargetBank[rand.nextInt(mTargetBank.length)]);
            }
        }
        updateUI();
    }

    private void updateUI() {
        int hintRes = mCharacterBank[curCharacter].getHintRes(curHint-1);
        int hintsLeft = mCharacterBank[curCharacter].getNumHints() - curHint;
        mHintTextView.setText(hintRes);
        mHintsLeftTextView.setText(Integer.toString(hintsLeft));
    }
}
