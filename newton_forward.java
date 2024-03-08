import java.util.Scanner;

public class newton_forward {

        int n;
         double[] year=new double[15];
        double[][] rate=new double[15][15];
        Double sum,search_value,u;

    public void getData(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of the data");
        n=sc.nextInt();
        System.out.println("Enter the  year");
        for(int i=0; i<n; i++){
            year[i]=sc.nextDouble();
        }
        System.out.println("Enter the  population as per the respective year in terms of millions");
        for(int i=0; i<n; i++){
            rate[i][0]=sc.nextDouble();
        }
        System.out.println("Enter the value of interpolation");
        search_value=sc.nextDouble();
    }

    public double calculate(double u,int n){
        double tmp=u;
        for(int i=1; i<n; i++){
            tmp=tmp*(u-i);
        }
        return tmp;
    }

    int factorial(int n){
        int fact=1;
        for(int i=2;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    public   void calculateDifference(){  
        for(int i=1;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                rate[j][i] =rate[j+1][i-1]-rate[j][i-1];
        } 
    }

    //Calculating the sum
    sum=rate[0][0];
    u=(search_value-year[0])/(year[1]-year[0]);

    for(int i=1;i<n;i++){
        sum=sum+(calculate(u,i)*rate[0][i])/factorial(i);
    }

    System.out.println("Population in millions at year"+search_value+" is"+sum);
}

    public static void main(String[] args) {
        
        newton_forward obj=new newton_forward();
        obj.getData();
        obj.calculateDifference();
        
    }
}
