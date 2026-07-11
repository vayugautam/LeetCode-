class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int onedelete = Integer.MIN_VALUE;
        int nodelete = arr[0];
        int result = arr[0];
        for(int i=1;i<n;i++){
            int prevnodelete=nodelete;
            int prevonedelete=onedelete;
            nodelete=Math.max(nodelete+arr[i],arr[i]);
            int v2=0;
            if(prevonedelete==Integer.MIN_VALUE){
                v2=arr[i];
            }else{
                v2=prevonedelete+arr[i];
            }
            // prevnodelete matlab abhi waala delete kar rahe hai
            // v2 = pehle kabhi delete hua hai to abhi to delete nahi karna hai to current element ko bhi add kar rahe hai
            onedelete=Math.max(prevnodelete,v2);
            result=Math.max(result,Math.max(onedelete,nodelete));
        }
        return result;
    }
}