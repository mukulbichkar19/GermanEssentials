package com.example.android.germanessentials;

/**
 * Created by mukul on 7/26/2016.
 */
public class Word {

    // A Variable for Default word i.e. english in this case.
    private String mdefaultWord;
    // A Variable for Translated word i.e. german in this case.
    private String mtranslatedWord;

    public Word(String mdefaultWord,String mtranslatedWord){
        this.mdefaultWord = mdefaultWord;
        this.mtranslatedWord = mtranslatedWord;
    }

    public String getMdefaultWord(){
        return this.mdefaultWord;
    }
    public String getMtranslatedWord(){
        return this.mtranslatedWord;
    }
}
