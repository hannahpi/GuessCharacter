package dreamersnet.net.guesscharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Ben on 9/14/2016.
 */
public class Character {
    private int mTextResId;
    private ArrayList<Integer> mHints;
    private ArrayList<Integer> mTargets;
    private int mNumHints;
    Random rand = new Random();

    public Character(int textResId) {
        mHints = new ArrayList<Integer>();
        mTargets = new ArrayList<Integer>();
        mTargets.add(textResId);
        mTextResId = textResId;
        mNumHints = rand.nextInt(3)+2;
    }

    public boolean addHint(int textResId) {
        if (mHints.size() < mNumHints) {
            mHints.add(new Integer(textResId));
            return true;
        } else {
            return false;
        }
    }
    public int getHintRes(int index) {
        return mHints.get(index);
    }

    public int getNumHints() {
        return mNumHints;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public boolean guessTarget(int resId) {
        Collections.shuffle(mTargets);
        return mTextResId == resId;
    }

    public void addTarget(int textResId) {
        mTargets.add(new Integer(textResId));
    }
    public void addTarget(Target t) { mTargets.add(new Integer(t.getTextResId())); }
    public ArrayList<Integer> getTargets() {
        return mTargets;
    }

}
