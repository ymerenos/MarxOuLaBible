package com.example.marxoulabible;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.content.Context;
import android.content.res.Resources;


public class StringManagement {
    private static Context mContext;
    public StringManagement(Context context) {
        mContext = context;
    }

    //Function to get a random string from either bible_quotes or marx_quotes in strings.xml adds a 0 or 1 in front of the string to indicate which quote it is
    public static String getRandomQuote(int type){
        Random rand = new Random();
        String quote;
        int quote_from_marx = rand.nextInt(2);
        Resources res = mContext.getResources();

        if(quote_from_marx==0){
            //We get a random quote from the marx quotes and we add a 0 in front of it to indicate that it is a marx quote
            quote = res.getStringArray(R.array.marx_quotes)[res.getStringArray(R.array.marx_quotes).length];
            return ("0"+quote);
        }
        else{
            //We get a random quote from the bible quotes and we add a 1 in front of it to indicate that it is a bible quote
            quote = res.getStringArray(R.array.bible_quotes)[res.getStringArray(R.array.bible_quotes).length];
            return ("1"+quote);
        }
    }
    //Function to get a random list of quotes from marx_quotes or bible_quotes in strings.xml the number of quotes is a parameter
    public static List<String> getRandomQuotes(int nbQuotes){
        Random rand = new Random();
        List<String> quotes = new ArrayList<>();
        Resources res = mContext.getResources();
        int quote_from_marx;
        for(int i=0; i<nbQuotes; i++){
            quote_from_marx = rand.nextInt(2);
            if(quote_from_marx==0){
                //We get a random quote from the marx quotes and
                quotes.add(res.getStringArray(R.array.marx_quotes)[res.getStringArray(R.array.marx_quotes).length-1]);
            }
            else{
                //We get a random quote from the bible quotes
                quotes.add(res.getStringArray(R.array.bible_quotes)[res.getStringArray(R.array.bible_quotes).length-1]);
            }
        }
        return quotes;
    }

    //Function to get a list of random ints from 0 to 1. Parameter is the number of ints we want
    public static int[] getRandomInts(int nbInts){
        Random rand = new Random();
        int[] ints = new int[nbInts];
        for(int i=0; i<nbInts; i++){
            ints[i] = rand.nextInt(2);
        }
        return ints;
    }



}
