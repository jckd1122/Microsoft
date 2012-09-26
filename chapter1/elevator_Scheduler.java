//#1.8

public class elevator_Scheduler{
    private int nTargetFloor; //initialize to -1
    private int minSumFloor;
    //private int[] nPerson;

    public void schedule(int[] nPerson,int N){
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
                nTargerFloor = i;
            }
        }
    }

}
