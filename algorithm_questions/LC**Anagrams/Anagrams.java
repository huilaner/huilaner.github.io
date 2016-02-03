/**
  * difficulty: medium
  * url: https://leetcode.com/problems/anagrams/
  * tag: hashtable, string
*/
//another method not using sort: Assign a prime number for a to z, and then multiply all prime numbers together to form a hash value.
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<List<String>>();
        if(strs.length == 0) return list;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            String key = generateKey(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                ArrayList<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        for(String key: map.keySet()){
            ArrayList<String> ary = map.get(key);
            Collections.sort(ary);
            list.add(ary);
        }
        return list;
    }
    
    private String generateKey(String s){
        if(s.isEmpty()) return s;
        char[] ary = s.toCharArray();
        Arrays.sort(ary);
        String r = new String(ary);
        return r;
    }
}

//seems slower than above
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        if(strs.length == 0) return list;
        Arrays.sort(strs);//so that the inner list is sorted
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            String key = generateKey(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                ArrayList<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    private String generateKey(String s){
        if(s.isEmpty()) return s;
        char[] ary = s.toCharArray();
        Arrays.sort(ary);
        String r = new String(ary);
        return r;
    }
}