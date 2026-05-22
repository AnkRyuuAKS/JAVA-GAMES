import java.util.ArrayList;

public class ArraysList{
        //swap function;
        public static void swap(ArrayList<Integer> list,int idx1,int idx2){
            int temp = list.get(idx1);
            list.set(idx1,list.get(idx2));
            list.set(idx2,temp);

        }

//Finding max Water stored btw two lines by BEUTE METHOD:
        public static int storeWater(ArrayList<Integer> height){
            int maxWater = 0;//global variable

            for(int i=0 ; i<height.size();i++){
                for(int j=i+1;j<height.size();j++){
                    int ht = Math.min(height.get(i),height.get(j));
                    int wt = j - i;
                    int currWater = ht * wt;
                    maxWater = Math.max(maxWater,currWater);   
                }
            }
            return maxWater;
        }      

//Finding max Water by 2 pointer method:
    public static int storeWaterTwo(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while(lp<rp){
            int ht = Math.min(height.get(lp),height.get(rp));
            int wt = rp - lp;
            //calculate water area;
            int currWater = ht * wt;
            maxWater = Math.max(maxWater,currWater);
            //update;
            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxWater;
    }      

//Pair - sum :-
    public static boolean pairSum(ArrayList<Integer> list4 , int target) {
        int lp = 0;
        int rp = list4.size() - 1;
         while( lp != rp){
            //case -1;
            if(list4.get(lp) + list4.get(rp) == target){
                return true;
            }

            //case - 2;
            if(list4.get(lp) + list4.get(rp) < target){
                lp++;//left most pointer = lp
            }
            //case-3;
            else{
                rp--;
            }
         }
         return false;
    }    

//Pair sum -2:
    public static boolean pairSumTwo(ArrayList<Integer> list7 ,int target){
        int bp = -1;//breaking point
        int n = list7.size();
        for(int i = 0;i<list7.size();i++){
            if(list7.get(i) > list7.get(i+1)){
                bp = i;
                break;
            }
        }

        int lp = bp +1;//smallest
        int rp = bp;//largest

        while(lp != rp){
            //case-1;
            if(list7.get(lp) + list7.get(rp) == target){
                return true;
            }

            if(list7.get(lp) + list7.get(rp) < target){
                //case -2;
                lp = (lp + 1)%n;
            }
            else{
                //case - 3;
                rp = (n+rp-1) % n;
            }
        }
        return false;
    } 
    public static void main(String args[]){
        //java collectin framework
        //ClassName objectName = new ClassName();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
        ArrayList<Float> list3 = new ArrayList<>();

        /* list.size:tells the len of arrlst
           list.add();
           list.add(2,10):-will add 10 at indx 2
           list.remove(indx):remove the val at indx 
           list.set(indx,val):set the val at indx
           list.contains(val):check whether the val is in the list or not
           list.get(indx): will get the elmnts in the arrlst 
           */

        list.add(2);  
        list.add(5);  
        list.add(9);  
        list.add(3);  
        list.add(6);  
        //Finding the max vlaue in the ArrayList:
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<list.size();i++){//TC = O(n);
            if(list.get(i)>max){
                max = list.get(i);
            }
        }
        System.out.println("max elements = "+max);


        int idx1 =1,idx2 =3;
        System.out.println(list);
        swap(list,idx1,idx2);
        System.out.println(list);

        //2-D-Arraylist;
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        ArrayList<Integer> list6 = new ArrayList<>();
        
        for(int i =1;i<=5;i++){
            list4.add(i);
            list5.add(i*2);
            list6.add(i*3);
        }
        mainList.add(list4);mainList.add(list5);
        mainList.add(list6);
        System.out.println(mainList);

        // neated loops for printing 2d ArrayList
        for(int i = 0;i<mainList.size();i++){
            //to get the lists present inside the mainList:=
            ArrayList<Integer> currenList = mainList.get(i);
            //to get the element inside each individual list:=
            for(int j =0 ;j<currenList.size();j++){
                System.out.print(currenList.get(j) +" ");
            }
            System.out.println();
        }


        //Most water problem;
        ArrayList<Integer> height =  new ArrayList<>();
        height.add(1);//[1,8,6,2,5,4,8,3,7]
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println("Max water is "+storeWater(height));
        System.out.println("Max water(by 2pointetr approch) is "+storeWaterTwo(height));

        list4.add(6);
        System.out.println("Is equal to tar:"+pairSum(list4,50));

        ArrayList<Integer> list7 = new ArrayList<>();
        //11,15,6,8,9,10
        list7.add(11);
        list7.add(15);
        list7.add(6);
        list7.add(8);
        list7.add(9);
        list7.add(10);
        System.out.println("Is equal to tar(by 2 pointer):"+ pairSumTwo(list7,16));

    }
}
