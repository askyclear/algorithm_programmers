package com.programmers.algorigm;


import com.programmers.algorigm.year2022.month02.*;
import com.programmers.algorigm.year2022.month02.FindPrimeNumber;
import com.programmers.algorigm.year2022.month03.*;
import com.programmers.algorigm.year2022.month04.*;
import com.programmers.algorigm.year2022.month05.*;

public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
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

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        Spicy spicy = new Spicy();
        spicy.solution(scoville, K);

        DiskController diskController = new DiskController();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        diskController.solution(jobs);

        DualPriortyQueue dualPriortyQueue = new DualPriortyQueue();
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};

        dualPriortyQueue.solution(operations);
        KthNumber kthNumber = new KthNumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        kthNumber.solution(array, commands);

        BigNumber bigNumber = new BigNumber();
        bigNumber.solution(new int[]{0, 0, 0, 0, 0, 0});
        HIndex hIndex = new HIndex();
        hIndex.solution(new int[]{5, 5, 5, 5});
        MockExam mockExam = new MockExam();
        mockExam.solution(new int[]{1, 2, 3, 4, 5});
        mockExam.solution(new int[]{1, 3, 2, 4, 2});

        FindPrimeNumber findDecimals = new FindPrimeNumber();
        findDecimals.solution("17");
        Carpet carpet = new Carpet();
        carpet.solution(10, 2);
        carpet.solution(8, 1);
        carpet.solution(24, 24);

        MakeBigNumber makeBigNumber = new MakeBigNumber();
        System.out.println(makeBigNumber.solution("4177252841", 4));

        WayToSchool wayToSchool = new WayToSchool();
        wayToSchool.solution(4, 3, new int[][]{{2, 2}});
        Thievery thievery = new Thievery();
        thievery.solution(new int[]{8, 1, 1, 8});
        TargetNumber targetNumber = new TargetNumber();
        targetNumber.solution(new int[]{4, 1, 2, 1}, 4);

        Immigration immigration = new Immigration();
        System.out.println(immigration.solution(3, new int[]{1, 2, 3}));

        SteppingStone steppingStone = new SteppingStone();
        steppingStone.solution(25, new int[]{2, 14, 11, 21, 17}, 2);

        KakaoBlindRecruitment1 kakaoBlindRecruitment1 = new KakaoBlindRecruitment1();
        kakaoBlindRecruitment1.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);

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

        Kakao2020Keypad kakao2020Keypad = new Kakao2020Keypad();
        kakao2020Keypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        kakao2020Keypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        kakao2020Keypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
        Kakao2019Crain crain = new Kakao2019Crain();
        crain.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        crain.solution2(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        KakoBlindRecruitmentStringCompression compression = new KakoBlindRecruitmentStringCompression();
        compression.solution("aabbaccc");
        compression.solution("ababcdcdababcdcd");
        compression.solution("abcabcdede");
        compression.solution("abcabcabcabcdededededede");
        compression.solution("xababcdcdababcdcd");

        MenuRenewal renewal = new MenuRenewal();
        renewal.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        renewal.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5});
        renewal.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});

        FailRate failRate = new FailRate();
        failRate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        failRate.solution(4, new int[]{1,1,1,1,1});

        BracketConversion bracketConversion = new BracketConversion();
        System.out.println(bracketConversion.solution("()))((()"));
        System.out.println(bracketConversion.solution("(()())()"));
        System.out.println(bracketConversion.solution("()"));
        System.out.println(bracketConversion.solution(")("));
        System.out.println(bracketConversion.solution("((((()))))"));
        System.out.println(bracketConversion.solution(")))))((((("));

        NewsClustering newsClustering = new NewsClustering();
        newsClustering.solution("ab", "cd");
        KakaoSpecialConverter kakaoSpecialConverter = new KakaoSpecialConverter();
        kakaoSpecialConverter.solution("AAaAA");
        MaximizeFormulas maximizeFormulas = new MaximizeFormulas();
        System.out.println(maximizeFormulas.solution("100-200*300-500+20"));
        System.out.println(maximizeFormulas.solution("50*6-3*2"));
        PrimeNumberCreator primeNumberCreator = new PrimeNumberCreator();
        System.out.println(primeNumberCreator.solution(new int[]{1,2,3,4}));
        System.out.println(primeNumberCreator.solution(new int[]{1,2,7,6,4}));
        System.out.println(primeNumberCreator.solution(new int[]{1,2,3}));
        System.out.println(primeNumberCreator.solution(new int[]{1,2,4}));

        DescendingOrderString descendingOrderString = new DescendingOrderString();
        descendingOrderString.solution("Zbcdefg"	);
        SiderPassword aa    = new SiderPassword();
        aa.solution("a B z", 1);

        ColoringBook coloringBook = new ColoringBook();
        coloringBook.solution(4,4, new int[][]{{1, 1, 0, 0},{0, 1, 1, 0},{0, 0, 1, 1},{0, 0, 0, 1}});
        MatrixRotate matrixRotate = new MatrixRotate();
        matrixRotate.solution(6,6, new int[][]{{2,2,5,4},{3,3,6,6}, {5,1,6,3}});

        RankSearch rankSearch = new RankSearch();
        rankSearch.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});

        Shiritori shiritori = new Shiritori();
        shiritori.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }

}
