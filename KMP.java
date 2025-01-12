package genericsImplementation;

import java.util.ArrayList;

public class KMP {

    static int[] make_LPS(String pattern){

        int n = pattern.length();
        int lps[] = new int[n];
        lps[0] = 0;
        int len = 0;

        for(int i = 1; i < n; ){

            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len > 0){
                    len--;
                }else{
                    lps[i] = len;
                    i++;
                }

            }
        }

        return lps;
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // your code here

        int lps[] = make_LPS(pat);


        int i = 0, j = 0;
        int n = txt.length(), m = pat.length();

        ArrayList<Integer> ans = new ArrayList<>();

        while(i < n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }


            if(j == m){
                ans.add(i - j);
                j = lps[j-1];

            }else if(i < n && txt.charAt(i) != pat.charAt(j)){
                if(j > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String text = "abesdu";
        String pat = "edu";

        ArrayList<Integer> ans = search(pat, text);
        System.out.println(ans);
    }
}
