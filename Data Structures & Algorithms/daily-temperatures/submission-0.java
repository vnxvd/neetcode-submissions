class Element {
  int temperature;
  int index;
  
  public Element(int temperature, int index) {
    this.temperature = temperature;
    this.index = index;
  }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Element> stack = new Stack();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
           int currentTemperature = temperatures[i];
           while (!stack.isEmpty() && currentTemperature > stack.peek().temperature) {
              Element e = stack.pop();
              result[e.index] = i - e.index;
           } 
           stack.push(new Element(currentTemperature, i));
        }

        return result;
    }
}
