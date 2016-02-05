/**
  * difficulty: medium
  * url: https://leetcode.com/problems/integer-to-english-words/
  * tag: math, string
*/
//omg edge cases really pissed me off...
public class Solution {

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        HashMap<Integer, String> map = new HashMap<>();
        generateMap(map);
        boolean ifPositive = num > 0;
        boolean ifMin = false;
        if(!ifPositive && num != Integer.MIN_VALUE) num = -num;
        else if(!ifPositive){
            ifMin = true;
            num = -(num+8);
        }
        String res = ifPositive ? "" : "Negative ";
        if(num < 1000) return res+(getHundred(num, map)).trim();
        if(num >= 1000 && num < 1000000) return res+(getThousands(num, map) + getHundred(num%1000, map)).trim();
        if(num >= 1000000000) res += map.get(num/1000000000) + " Billion ";
        num = num - num/1000000000*1000000000;//get rid of billion
        if(num/1000000 > 0) res += getHundred(num/1000000, map) + " Million ";
        //num = num - num/1000000*1000000;//get rid of million
        if(num >= 1000) res += getThousands(num,map);
        num %= 1000;
        res += getHundred(num,map);
        if(ifMin) res += " Eight";
        return res.trim();
    }
    
    private void generateMap(HashMap<Integer, String> map){
        map.put(0,""); map.put(1,"One"); map.put(2,"Two"); map.put(3,"Three"); map.put(4,"Four"); map.put(5,"Five"); 
        map.put(6,"Six"); map.put(7,"Seven"); map.put(8,"Eight"); map.put(9,"Nine"); map.put(10,"Ten");
        map.put(11,"Eleven"); map.put(12,"Twelve"); map.put(13,"Thirteen"); map.put(14,"Fourteen"); map.put(15,"Fifteen");
        map.put(16,"Sixteen"); map.put(17,"Seventeen"); map.put(18,"Eighteen"); map.put(19,"Nineteen"); 
        map.put(20,"Twenty"); map.put(30,"Thirty");map.put(40,"Forty");map.put(50,"Fifty");map.put(60,"Sixty");
        map.put(70,"Seventy");map.put(80,"Eighty");map.put(90,"Ninety");
        map.put(100, "Hundred"); map.put(1000, "Thousand"); map.put(1000000, "Million"); map.put(1000000000,"Billion");
    }
    
    private String getHundred(int num, HashMap<Integer, String> map){
        if(num == 0) return "";
        if(num < 21) return map.get(num);
        String res = "";
        if(num > 20 && num < 100) res = map.get(num-num%10) +" "+ map.get(num%10);
        else if(num < 1000) res = map.get(num/100) +" Hundred "+ getHundred(num%100,map);
        return res.trim();
    }
    
    private String getThousands(int num, HashMap<Integer, String> map){
        if(num == 0) return "";
        String res = "";
        int numT = (num%1000000)/1000;
        if(numT == 0) return "";
        return getHundred(numT,map)+" Thousand ";
    }
}
