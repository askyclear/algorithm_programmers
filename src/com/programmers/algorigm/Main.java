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

    }

}
