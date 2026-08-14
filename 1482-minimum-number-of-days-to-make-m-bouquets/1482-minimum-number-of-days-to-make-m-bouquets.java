class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length - 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i <= n; i++) {
            start = Math.min(start, bloomDay[i]);
            end = Math.max(end, bloomDay[i]);
        }

        if (n + 1 < (long)m * k) {
            return -1;
        }

        int mid = 0;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (canMakeBouquets(mid, bloomDay, m, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean canMakeBouquets(int mid, int[] bloomDay, int m, int k) {

        int consecutiveFlowers = 0;
        int totalBouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= mid) {
                consecutiveFlowers++;
            } else {
                totalBouquets += consecutiveFlowers / k;
                consecutiveFlowers = 0;
            }
        }

        totalBouquets += consecutiveFlowers / k;

        return totalBouquets >= m;
    }
}