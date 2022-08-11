package com.programmers.algorigm.year2022.month08;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MultiLevelToothbrushSell {
    private static final int price = 100;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int sellerCount = enroll.length;
        int[] answer = new int[sellerCount];
        Map<String, Seller> sellerInfoMap = new HashMap<>();

        for (int i = 0; i < sellerCount; i++) {
            String parentName = referral[i];
            String name = enroll[i];
            Seller sellerInfo = new Seller(parentName, name);
            sellerInfoMap.put(name, sellerInfo);
        }

        for (int i = 0; i < seller.length; i++) {
            calcProfit(seller[i], price * amount[i], sellerInfoMap);
        }

        for (int i = 0; i < sellerCount; i++) {
            answer[i] = sellerInfoMap.get(enroll[i]).profit;
        }

        return answer;
    }

    private void calcProfit(String name, int sendProfit, Map<String, Seller> sellerInfoMap) {
        Seller sellerInfo = sellerInfoMap.get(name);
        if (Objects.isNull(sellerInfo)) {
            return;
        }
        int parentProfit = sendProfit / 10;
        sellerInfo.profit += sendProfit - parentProfit;

        if (parentProfit >= 1) {
            calcProfit(sellerInfo.parentName, parentProfit, sellerInfoMap);
        }
    }

    class Seller {
        private String parentName;
        private String name;
        private int profit;

        Seller(String parentName, String name) {
            this.parentName = parentName;
            this.name = name;
        }
    }
}
