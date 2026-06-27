class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 2, 5, 1 };
        int k = 10;
        Solution sol = new Solution();
        int count = sol.checkSubsequenceSum(arr, k);
        System.out.println(count);
    }
}

class Solution {
    public int checkSubsequenceSum(int[] arr, int k) {
        return check(arr, 0, k, arr.length);
    }

    public int check(int[] arr, int index, int num, int n) {
        if (num <= 0) {
            return (num == 0) ? 1 : 0;
        }
        if (index == n)
            return 0;
        return (check(arr, index + 1, num, n) + check(arr,
                index + 1, num - arr[index], n));
    }
}
