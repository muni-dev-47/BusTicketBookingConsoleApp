
import view.TicketBookingApplication;

import java.sql.SQLException;

public final class Main {
    public static void main(String[] args) throws SQLException {
        TicketBookingApplication.main();
    }
}

//        {
//            int[] arr = {0, 2, 2, 2, 0, 6, 6, 0, 8};
//            int j = 0;
//            for (int i = 1; i < arr.length; i++) {
//                if (arr[j] == arr[i]) {
//                    arr[j] = arr[j] + arr[i];
//                    arr[i] = 0;
//                    j++;
//                } else {
//                    j++;
//                }
//            }
//
//            for (int i = 0, k = 0; i < arr.length; i++) {
//                if (arr[i] != 0) {
//                    int temp = arr[i];
//                    arr[i] = arr[k];
//                    arr[k++] = temp;
//                }
//            }
//        }
//
//        {
//            String str = "muniyaraj";
//            for (int i = 0; i < str.length(); i++) {
//                for (int j = 0; j < str.length(); j++) {
//                    if (i == j || i + j == str.length() - 1) {
//                        System.out.print(str.charAt(j));
//                    } else {
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println();
//            }
//        }
//
//        {
//            int[] arr1 = {1, 3, 3, 3, 3, 5, 7, 9};
//            int[] arr2 = {3, 6, 9, 12, 15};
//            int i = 0;
//            int j = 0;
//            List<Integer> list = new ArrayList<>();
//            while (i < arr1.length && j < arr2.length) {
//                if (arr1[i] < arr2[j]) {
//                    list.add(arr1[i++]);
//                } else if (arr1[i] > arr2[j]) {
//                    list.add(arr2[j++]);
//                } else {
//                    list.add(arr1[i]);
//                    i++;
//                    j++;
//                }
//            }
//            while (i < arr1.length) {
//                list.add(arr1[i++]);
//            }
//            while (j < arr2.length) {
//                list.add(arr2[j++]);
//            }
//            System.out.println(list);
//        }
//        {
//            int[] arr = {1, 2, 45, 67, 1, 88};
//            Map<Integer, Integer> values = new HashMap<>();
//            for (int i : arr) {
//                values.put(i, values.getOrDefault(i, 0) + 1);
//            }
//        }
//        {
//            class Palin {
//                public static boolean isPalin(String s) {
//                    int left = 0;
//                    int right = s.length() - 1;
//                    while (left < right) {
//                        if (s.charAt(left++) != s.charAt(right--)) return false;
//                    }
//                    return true;
//                }
//            }
//
//            String str = "he knows malayalam";
//            StringBuilder sb = new StringBuilder();
//            String[] strs = str.split(" ");
//            for (int i = 0; i < strs.length; i++) {
//                if (!Palin.isPalin(strs[i])) {
//                    sb.append(strs[i]).append(" ");
//                }
//            }
//            System.out.println(sb);
//        }
//        {
//            String str1 = "expErlence";
//            String str2 = "En";
//            boolean[] seen = new boolean[128];
//            for (int i = 0; i < str2.length(); i++) {
//                seen[str2.charAt(i)] = true;
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < str1.length(); i++) {
//                if (!seen[str1.charAt(i)]) {
//                    sb.append(str1.charAt(i));
//                }
//            }
//            System.out.println(sb);
//        }