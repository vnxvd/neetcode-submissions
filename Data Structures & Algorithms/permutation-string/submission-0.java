class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Đếm tần suất ký tự trong s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int window = s1.length();

        // Duyệt qua s2
        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++; // thêm ký tự mới vào cửa sổ

            // Khi cửa sổ dài hơn s1 → loại bỏ ký tự cũ
            if (i >= window) {
                count2[s2.charAt(i - window) - 'a']--;
            }

            // So sánh hai mảng
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
