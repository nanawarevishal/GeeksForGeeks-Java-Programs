
/*


 Next Greater Element
        MediumAccuracy: 32.95%Submissions: 325K+Points: 4
        Join the most popular course on DSA. Master Skills & Become Employable by enrolling today! 
        Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
        Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
        If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

        Example 1:
        Input: 
        N = 4, arr[] = [1 3 2 4]
        Output:
        3 4 4 -1
        Explanation:
        In the array, the next larger element 
        to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
        since it doesn't exist, it is -1.


        Example 2:
        Input: 
        N = 5, arr[] [6 8 0 1 3]
        Output:
        8 -1 1 3 -1
        Explanation:
        In the array, the next larger element to 
        6 is 8, for 8 there is no larger elements 
        hence it is -1, for 0 it is 1 , for 1 it 
        is 3 and then for 3 there is no larger 
        element on right and hence -1.


 */



package Array.Medium;

import java.util.Stack;

public class nextGreaterElement {

    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] ans = new long[arr.length];
        
        Stack<Long>st = new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--){
            
            if(st.isEmpty()){
                ans[i] = -1;
                st.push(arr[i]);
            }
            
            else if(st.peek() <= arr[i]){
                
                while(st.peek() <= arr[i]){
                    st.pop();
                    
                    if(st.isEmpty()){
                        break;
                    }
                }
                
                if(st.isEmpty()){
                    ans[i] = -1;
                    st.push(arr[i]);
                }
                else{
                    ans[i] = st.peek();
                    st.push(arr[i]);
                }
            }
            else{
                ans[i] = st.peek();
                st.push(arr[i]);
            }
        }
        
        return ans;
    } 


 
    public static void main(String[] args) {
        long[] arr = {6 ,8 ,0, 1, 3};

        long[] res = nextLargerElement(arr, 0);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
