package com.agb1986.lnd.unittesting.business;

public class SomeBusinessImpl {
    private SomeDataSerive someDataSerive;

    public void setSomeDataSerive(SomeDataSerive someDataSerive) {
        this.someDataSerive = someDataSerive;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int [] data = someDataSerive.retrieveAllData();
        for (int i : data) {
            sum += i;
        }
        return sum;
    }
}
