package dreamersnet.net.guesscharacter;

/**
 * Created by water on 9/14/2016.
 */
public class Target {
    private int mTextResId;
    private boolean mAnswerCorrect;

    public Target(int textResId, boolean answerCorrect){
        mTextResId=textResId;
        mAnswerCorrect = answerCorrect;
    }

    public void setTextResId(int textResId){
        mTextResId = textResId;
    }

    public void setAnswerCorrect(boolean answerCorrect){
        mAnswerCorrect = answerCorrect;
    }

    public int getTextResId(){
        return mTextResId;
    }

    public boolean isAnswerCorrect(){
        return mAnswerCorrect;
    }

}
