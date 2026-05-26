class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s.length()).append("#").append(s);
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        int i = 0;
        while(i < str.length()) {
          int previous = i;  
          System.out.println("i="+i+",charAt(i)="+str.charAt(i));  
          while (str.charAt(i) != '#') {
            i++;
          }
          System.out.println("new i1="+i);
          int length = Integer.valueOf(str.substring(previous, i));
          System.out.println("length="+length);
          System.out.println("from="+(i+1) + ",to="+(i+1+length)+",sub="+str.substring(i+1, i+1+length));
          result.add(str.substring(i+1, i+1+length));
          i = i + 1 + length;
          System.out.println("new i="+i);
        }
        return result;
    }
}
