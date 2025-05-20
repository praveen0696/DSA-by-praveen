
class Move_All_Zeros_to_End{
    static void pushZerosToEnd(int[] arr) {
        // code here
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }
        
        while(count < arr.length){
            arr[count++] = 0;
        }
    }
}