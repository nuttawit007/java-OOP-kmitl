package Fraction5;// สร้าง Method เพิ่มเติมจากข้อ 4
public class Fraction {
    public int topN;
    public int btmN;
    
    public String toFraction(){
        return topN+"/"+btmN;
    }
// ใส่ double เพราะการหารเป็น ทศนิยม
    public String toFloat(){
        return "" + ((double)topN / (double)btmN);
    }
// this >> อ้างอิงถึงตัวเอง
    public void addfraction(Fraction4.Fraction f){
        if (this.btmN == f.btmN){
            this.topN = this.topN + f.topN;
        }else{
            this.topN = this.topN * f.btmN + f.topN * this.btmN;
            this.btmN = this.btmN * f.btmN;
        }
    }
    
    public boolean myEquals(Fraction f){
        double val1 = (double)topN / (double)btmN;
        double val2 = (double)f.topN / (double)f.btmN;
        if (val1 == val2) {
            return false;
        }else {
            return true;
        }
    }
    
    public void LowestTermFrac(){
        int divde = findGCD(this.topN, this.btmN);
        this.topN = this.topN / divde;
        this.btmN = this.btmN / divde;
    }
    
    private int findGCD(int num1, int num2){
        if (num2 == 0){
            return num1;
        }else {
            return findGCD(num2, num1%num2);
        }
    }
    
}
