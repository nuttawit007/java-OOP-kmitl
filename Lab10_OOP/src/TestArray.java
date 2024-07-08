public class TestArray {
    public static void main(String[] args) {
        int num[];
        String str[];
        num = new int[4];
        str = new String[4];
        str[0] = "Hello";
        System.out.println(num[0]);
        System.out.println(str[0]);
        System.out.println(str[1]);
        
        int num2[][];
        num2 = new int[3][4];
        num2[1][2] = 5;
        System.out.println(num2[1][2]);
        
    }
}
