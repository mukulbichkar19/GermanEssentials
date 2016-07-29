package com.example.android.germanessentials;

/**
 * Created by mukul on 7/26/2016.
 */
public class Word {

    // A Variable for Default word i.e. english in this case.
    private String mdefaultWord;
    // A Variable for Translated word i.e. german in this case.
    private String mtranslatedWord;
    // A Variable for Storing the associated image if image present.
    private int mImageID;
    // a boolean to indicate whether the Word has Image Associated with it
    boolean hasImageAssocciated = false;
    // A private int as Audio Resource Id
    private int mAudioResourceID;

    public Word(String mdefaultWord,String mtranslatedWord,int mAudioResourceID){
        this.mdefaultWord = mdefaultWord;
        this.mtranslatedWord = mtranslatedWord;
        this.mAudioResourceID = mAudioResourceID;
    }

   /* public Word(String mdefaultWord,String mtranslatedWord,int mImageID){
        this.mdefaultWord = mdefaultWord;
        this.mtranslatedWord = mtranslatedWord;
        this.mImageID = mImageID;
        this.hasImageAssocciated = true;

    }*/

    public Word(String mdefaultWord,String mtranslatedWord,int mImageID,int mAudioResourceID){
        this.mdefaultWord = mdefaultWord;
        this.mtranslatedWord = mtranslatedWord;
        this.mImageID = mImageID;
        this.mAudioResourceID = mAudioResourceID;
        this.hasImageAssocciated = true;

    }

    public String getMdefaultWord(){
        return this.mdefaultWord;
    }
    public String getMtranslatedWord(){
        return this.mtranslatedWord;
    }
    public int getMImageID(){
        return this.mImageID;
    }
    public boolean getIfImageAssociated(){
        return this.hasImageAssocciated;
    }
    public int getmAudioResourceID(){
        return this.mAudioResourceID;
    }
}
