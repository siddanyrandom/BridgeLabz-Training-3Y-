class ProfitAndLoss {
    public static void main(String[] args) {
        double cost = 129, selling = 191;
        double profit = selling - cost;
        double profitPercent = (profit / cost) * 100;
        System.out.println("The Cost Price is INR " + cost + " and Selling Price is INR " + selling + 
        "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercent);
    }
}
