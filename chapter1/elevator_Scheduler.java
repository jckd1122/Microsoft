//#1.8

public class elevator_Scheduler{
    private int nTargetFloor; //initialize to -1
    private int minSumFloor;
    //private int[] nPerson;

    public void schedule1(int[] nPerson,int N){
        for(int i = 1; i <= N;++i){
            int sum = 0;
            for(int j = 1; j < i;++j){
                sum += nPerson[j]*(i-j);
            }
            for(int j = i+1; j <= N;++j){
                sum += nPerson[j]*(j-i);
            }
            if(nTargetFloor == -1 || sum < minSumFloor){
                minSumFloor = sum;
                nTargetFloor = i;
            }
        }
    }

    public void schedule2(int[] nPerson,int N){
        int sum = 0;
        int lPPL = nPerson[1];  //not including the current ppl
        int hPPL = 0;           //current ppl to the end
        nTargetFloor = 1;
        for(int i = 2; i <= N;++i){
            minSumFloor += nPerson[i]*(i-1);
            hPPL += nPerson[i];
        }
        int lSum = 0;
        int hSum = minSumFloor;
        
        for(int i = 2; i <= N;++i){
            lSum += lPPL;
            lPPL += nPerson[i];
            hSum -= hPPL;
            hPPL -= nPerson[i];
            sum = lSum+hSum;

            if(sum < minSumFloor){
                minSumFloor = sum;
                nTargetFloor = i;
            }
            else
                break;
        }

    }

    public static void main(String[] args){
        elevator_Scheduler test = new elevator_Scheduler();
        test.nTargetFloor = -1;
        test.minSumFloor = 0;

        int[] nPerson = {-1,1,2,3,4,5,6,7,8,9};
        test.schedule1(nPerson,9);
        System.out.println(test.nTargetFloor);
        System.out.println(test.minSumFloor);

    }

}
