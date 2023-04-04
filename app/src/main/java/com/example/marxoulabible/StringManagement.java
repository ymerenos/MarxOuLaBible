package com.example.marxoulabible;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.content.Context;
import android.content.res.Resources;


public class StringManagement {
    private static Context mContext;
    private static List<Integer> reponses;
    private static List<Integer> reponses_user;
    public StringManagement(Context context) {
        reponses = new ArrayList<Integer>();
        reponses_user = new ArrayList<Integer>();
        mContext = context;
    }

    //Function to get a random string from either bible_quotes or marx_quotes in strings.xml adds a 0 or 1 in front of the string to indicate which quote it is
    public static String getRandomQuote(int type){
        Random rand = new Random();
        String quote;
        int quote_from_marx = rand.nextInt(2);
        Resources res = mContext.getResources();

        if(quote_from_marx==0){
            //We get a random quote from the marx quotes
            quote = res.getStringArray(R.array.marx_quotes)[res.getStringArray(R.array.marx_quotes).length];
            return (quote);
        }
        else{
            //We get a random quote from the bible quotes
            quote = res.getStringArray(R.array.bible_quotes)[res.getStringArray(R.array.bible_quotes).length];
            return (quote);
        }
    }
    //Function to get a random list of quotes from marx_quotes or bible_quotes in strings.xml the number of quotes is a parameter
    public static List<String> getRandomQuotes(int nbQuotes){

        Random rand = new Random();
        List<String> quotes = new ArrayList<>();
        Resources res = mContext.getResources();
        int is_quote_from_marx;
        for(int i=0; i<nbQuotes; i++){
            is_quote_from_marx = rand.nextInt(2);
            if(is_quote_from_marx==0){
                //We get a random quote from the marx quotes and
                int quote_number = rand.nextInt(res.getStringArray(R.array.marx_quotes).length);
                quotes.add(res.getStringArray(R.array.marx_quotes)[quote_number]);

            }
            else{
                //We get a random quote from the bible quotes
                int quote_number = rand.nextInt(res.getStringArray(R.array.bible_quotes).length);
                quotes.add(res.getStringArray(R.array.bible_quotes)[quote_number]);
            }
            reponses.add(is_quote_from_marx);
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

    public void addReponseUser(int reponseUser){
        reponses_user.add(reponseUser);
    }

    //Function to get the array of ints that indicates which quote is from marx and which one is from the bible
    public static List getReponses(){
        return reponses;
    }

    public static List getReponsesUser(){
        return reponses_user;
    }

    public static boolean isOver(){
        return reponses.size() == reponses_user.size();
    }

    public static int bonneReponse(){
        int nbBonneReponse = 0;
        for(int i=0; i<reponses.size(); i++){
            if(reponses.get(i) == reponses_user.get(i)){
                nbBonneReponse++;
            }
        }
        return nbBonneReponse;
    }



}
