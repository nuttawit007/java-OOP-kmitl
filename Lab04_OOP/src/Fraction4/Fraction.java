package Fraction4;
public class Fraction {
    public int topN;
    public int btmN;
    
    public String toFraction(){
        return topN+"/"+btmN;
    }
// ใส่ double เพราะการหารเป็น ทศนิยม
    public String toFloat(){
        return "" + ((double)topN / (double)btmN);
//        return String.valueOf((double) topN / (double) btmN);
    }
// this >> อ้างอิงถึงตัวเอง
    public void addFraction(Fraction f){
        if (this.btmN == f.btmN){
            this.topN = this.topN + f.topN;
        }else{
            this.topN = this.topN * f.btmN + f.topN * this.btmN;
            this.btmN = this.btmN * f.btmN;
        }
    }
}
