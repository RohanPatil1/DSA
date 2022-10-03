import java.util.Stack;

public class MinimumTimetoMakeRopeColorful {
    class Pair{
        char c;
        int time;

        public Pair(char c, int time){
            this.c = c;
            this.time = time;
        }
    }

    public int minCost(String colors, int[] neededTime) {

        int minTime = 0;

        int n = colors.length();
        Pair[] ballons = new Pair[n];
        for(int i=0;i<n;i++){
            ballons[i] = new Pair(colors.charAt(i), neededTime[i]);
        }


        Stack<Pair> stack = new Stack<>();
        stack.push(ballons[0]);
        for(int i=1;i<n;i++){

            Pair currP = ballons[i];

            if(stack.isEmpty()){
                stack.push(currP);
            }else{

                if(stack.peek().c == currP.c){
                    if(stack.peek().time < currP.time){

                        minTime += stack.peek().time;
                        stack.pop();
                        stack.push(currP);

                    }else{

                        minTime += currP.time;

                    }
                }else
                    stack.push(currP);

            }

        }

        return minTime;

    }
}
