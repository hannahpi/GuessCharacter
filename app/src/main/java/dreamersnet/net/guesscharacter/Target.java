package dreamersnet.net.guesscharacter;

/**
 * Created by Ben on 9/14/2016.
 */
public class Target {
    private int mTextResId;

    public Target(int textResId){
        mTextResId=textResId;
    }

    public void setTextResId(int textResId){
        mTextResId = textResId;
    }

    public int getTextResId(){
        return mTextResId;
    }

}
