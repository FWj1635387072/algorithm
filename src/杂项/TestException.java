package 杂项;

public class TestException {
    public static void main(String[] args) {
        try {
            sum(10000,1);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
    static int sum(int a, int b) throws MyException{
        if (a > 1000)
            throw new MyException("参数越界");
        return a + b;
    }
}
