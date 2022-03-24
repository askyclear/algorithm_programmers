package com.programmers.algorigm;


public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3,2,3};
        int[] discounts = {30, 20};
        int[] priorties = {1, 1, 9, 1, 1, 1};
        int location = 0;
        OrderStatus.valueOf("COMPLETED");
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        TruckCrossingTheBridge truckSolution = new TruckCrossingTheBridge();

        truckSolution.solution(100, 100, truck_weights);
        StockPrice stockPrice = new StockPrice();
        stockPrice.solution(prices);

        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        Spicy spicy = new Spicy();
        spicy.solution(scoville, K);

        DiskController diskController = new DiskController();
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        diskController.solution(jobs);

        DualPriortyQueue dualPriortyQueue = new DualPriortyQueue();
        String[] operations = {"I 7","I 5","I -5","D -1"};

        dualPriortyQueue.solution(operations);
        KthNumber kthNumber = new KthNumber();
        int[] array = {1,5,2,6,3,7,4};
        int[][]commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        kthNumber.solution(array, commands);

        BigNumber bigNumber = new BigNumber();
        bigNumber.solution(new int[]{0,0,0,0,0,0});
        HIndex hIndex = new HIndex();
        hIndex.solution(new int[]{5,5,5,5});
        MockExam mockExam = new MockExam();
        mockExam.solution(new int[]{1,2,3,4,5});
        mockExam.solution(new int[]{1,3,2,4,2});

        FindPrimeNumber findDecimals = new FindPrimeNumber();
        findDecimals.solution("17");
        Carpet carpet = new Carpet();
        carpet.solution(10,2);
        carpet.solution(8,1);
        carpet.solution(24,24);

        MakeBigNumber makeBigNumber = new MakeBigNumber();
        System.out.println(makeBigNumber.solution("4177252841", 4));

        WayToSchool wayToSchool = new WayToSchool();
        wayToSchool.solution(4,3,new int[][]{{2,2}});
        Thievery thievery = new Thievery();
        thievery.solution(new int[]{8,1,1,8});
        TargetNumber targetNumber = new TargetNumber();
        targetNumber.solution(new int[]{4,1,2,1}, 4);

        Immigration immigration = new Immigration();
        System.out.println(immigration.solution(3, new int[] {1,2,3}));

        SteppingStone steppingStone = new SteppingStone();
        steppingStone.solution(25, new int[]{2,14,11,21,17}, 2);

        KakaoBlindRecruitment1 kakaoBlindRecruitment1 = new KakaoBlindRecruitment1();
        kakaoBlindRecruitment1.solution(new String[]{"muzi","frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);

        LottoMaxMinRank lottoMaxMinRank = new LottoMaxMinRank();
        lottoMaxMinRank.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        lottoMaxMinRank.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        lottoMaxMinRank.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
        KakaoBlindRecruitment2021NewId newId = new KakaoBlindRecruitment2021NewId();
        newId.solution("...!@BaT#*..y.abcdefghijklm");
        newId.solution("z-+.^.");
        newId.solution("=.=");
        newId.solution("123_.def");
        newId.solution("abcdefghijklmn.p");
        KakaoBlindRecruitment2021NumbereStr numbereStr = new KakaoBlindRecruitment2021NumbereStr();
        numbereStr.solution("one4seveneight");
    }

}
