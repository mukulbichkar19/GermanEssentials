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

    public Word(String mdefaultWord,String mtranslatedWord){
        this.mdefaultWord = mdefaultWord;
        this.mtranslatedWord = mtranslatedWord;
    }

    public Word(String mdefaultWord,String mtranslatedWord,int mImageID){
        this.mdefaultWord = mdefaultWord;
        this.mtranslatedWord = mtranslatedWord;
        this.mImageID = mImageID;
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
}
