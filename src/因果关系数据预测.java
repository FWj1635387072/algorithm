public class 因果关系数据预测 {

    public static void main(String[] args) {
        double[][] x = {{1, 2, 3, 4, 5}, {9.6, 9.0, 8.3, 7.7, 7.3}};
        //x = new double[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {59.1, 55.0, 50.2, 46.9, 46.7, 46.1, 46.5, 47.2, 49.5, 58.1, 64.4, 66.2}};
        x = new double[][]{{1, 2, 3}, { 1132.9, 1059.1, 1010.8}};
        System.out.println(getVal(x, 4));
        System.out.println(getVal(x, 5));
        System.out.println(getVal(x, 6));

    }


    public static double getVal(double[][] x, int prep_x) {
        double xsum = 0, xxsum = 0;
        double ysum = 0, xysum = 0;
        double n = x[0].length;
        for (int i = 0; i < x[0].length; i++) {
            xsum += x[0][i];
            ysum += x[1][i];
            xysum += x[0][i] * x[1][i];
            xxsum += x[0][i] * x[0][i];
        }
        double b = (n * xysum - xsum * ysum) / (n * xxsum - xsum * xsum);
        double a = 1 / n * ysum - b * 1 / n * xsum;
        return a + b * prep_x;
    }
}
