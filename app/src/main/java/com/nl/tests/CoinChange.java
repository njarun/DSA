package com.nl.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = new int[]{1,2,5};
        int amount = 100;

        System.out.println("min count = " + coinChangeBruteForce(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int max = amount+1;
        int[] dp = new int[max];

        dp[0] = 0;

        for(int i=1; i<dp.length; i++) {
            dp[i] = amount+1;
        }

        for(int i=1; i<max; i++) {

            for (int coin : coins) {

                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] != max ? dp[amount] : -1;
    }

    /***************************************************************************/

    public static int coinChangeAmmu(int[] coins, int amount) {

        int minCoins;

        if(amount == 0 || coins.length == 0) {

            minCoins = 0;
        }
        else {

            Arrays.sort(coins);

            List<Integer> coinList = new ArrayList<>();
            findMinCoins(coins, amount, coinList);

            if(coinList.isEmpty()) {

                minCoins = -1;
            }
            else {

                int sum = 0;
                for(int i=0; i<coinList.size(); i++) {
                    sum += coinList.get(i);
                }

                minCoins = (sum != amount) ? -1 : coinList.size();
            }
        }

        return minCoins;
    }

    public static void findMinCoins(int[] coins, int amount, List<Integer> coinList) {

        int nextCoin = -1;

        for(int i=0; i<coins.length; i++) {

            int coin = coins[i];
            if(coin <= amount) {

                nextCoin = coin;

                if(coin == amount)
                    break;
            }
        }

        int minCoins = 0;

        if(nextCoin > 0) {

            minCoins = amount / nextCoin;

            for(int i=0; i<minCoins; i++) {
                coinList.add(nextCoin);
            }

            System.out.println("Coins in round - " + amount + " = " + coinList.size());

            int reminder = amount % nextCoin;

            if(reminder > 0) {

                findMinCoins(coins, reminder, coinList);
            }
        }
    }

    /***************************************************************************/

    private static Integer minCoins = null;
    //private static Map<Integer, Map<Integer, List<Integer>>> routeMap = new HashMap<>();

    public static int coinChangeBruteForce(int[] coins, int amount) {

        minCoins = null;
        //routeMap = null;

        if(amount > 0) {

            searchDepth(amount, coins, new ArrayList<>());

            if(minCoins == null)
                minCoins = -1;

            return minCoins;
        }
        else return 0;
    }

    public static void searchDepth(int amount, int[] coins, List<Integer> coinRoute) {

        List<Integer> originalRoute = new ArrayList<>(coinRoute);

        for (int i = 0; i < coins.length; i++) {

            int coin = coins[i];
            int balance = amount - coin;

            if(balance == 0) {

                coinRoute.add(coin);
                System.out.println("Coins = " + coinRoute);
                minCoins = minCoins == null ? coinRoute.size() : Math.min(minCoins, coinRoute.size());
                coinRoute.remove(coinRoute.size() - 1);
            }
            else if(balance > 0) {

                coinRoute.add(coin);

                if(minCoins == null || coinRoute.size() < minCoins) {

                    /*Map<Integer, List<Integer>> subRouteMap = routeMap.get(amount);
                    List<Integer> subRouteList = null;
                    if(subRouteMap != null && subRouteMap.containsKey(coin)) {
                        subRouteList = subRouteMap.get(coin);
                    }

                    if(subRouteList != null) {
                        coinRoute.addAll(subRouteList);
                    }
                    else {

                        int startSize = coinRoute.size();*/

                        searchDepth(balance, coins, coinRoute);

                        /*int endSize = coinRoute.size();

                        if (endSize >= startSize) {

                            subRouteMap = new HashMap<>();
                            subRouteMap.put(coin, coinRoute.subList(startSize - 1, endSize - 1));
                            routeMap.put(amount, subRouteMap);
                        }
                    }*/
                }

                coinRoute.remove(coinRoute.size() - 1);
            }
            else {

                coinRoute = originalRoute;
            }
        }
    }
}