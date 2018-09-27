import java.util.ArrayList;
import java.util.List;

/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
*/
public class Solution309 {

    public static void main(String[] args) {
        int[] prices = new int[]{2,6,8,7,8,7,9,4,1,2,4,5,8};
        Solution309 solution = new Solution309();
        System.out.print(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int profitSum = 0;
        List<Section>  sections = new ArrayList<>();
        boolean isUp = false;
        int start = 0,end = 0;
        int index = 1;
        while (index < prices.length) {
            if (prices[index] >= prices[index-1]) {
                isUp = true;
            }else {
                if (isUp) {
                    isUp = false;
                    end = index-1;
                    sections.add(new Section(start, end));
                }
                start = index;
            }
            index++;
        }
        if (isUp) {
            end = index-1;
            sections.add(new Section(start, end));
        }

        if (sections.size() == 0) {
            return 0;
        }

        Section lastSection = sections.get(0);
        for (int i = 1; i < sections.size(); i++) {
            Section s = sections.get(i);

            if (s.start == lastSection.end + 1) {
                int firstDiff = prices[lastSection.end] - prices[lastSection.end - 1];
                int secondDiff = prices[s.start + 1] - prices[s.start];

                if (prices[s.start + 1] - prices[lastSection.end - 1] > firstDiff && prices[s.start + 1] - prices[lastSection.end - 1] > secondDiff) {
                    lastSection.end = lastSection.start;
                    s.start = lastSection.start;
                } else if (firstDiff > secondDiff) {
                    s.start += 1;
                } else {
                    lastSection.end -= 1;
                }
            }
            if (s.start != s.end) {
                lastSection = s;
            }
        }

        for (Section s : sections) {
            profitSum += prices[s.end] - prices[s.start];
        }

        return profitSum;
    }

    class Section {
        int start;
        int end;
        Section(int s, int e) {
            start = s;
            end = e;
        }
    }
}
