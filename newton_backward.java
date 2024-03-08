import java.util.Scanner;

public class newton_backward {

        int n;
         double[] year=new double[15];
        double[][] rate=new double[15][15];
        Double sum,search_value,u;

    public void getData(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of the data");
        n=sc.nextInt();
        System.out.println("Enter the year");
        for(int i=0; i<n; i++){
            year[i]=sc.nextDouble();
        }
        System.out.println("Enter the population as per the respective year in terms of millions");
        for(int i=0; i<n; i++){
            rate[i][0]=sc.nextDouble();
        }
        System.out.println("Enter the value of interpolation");
        search_value=sc.nextDouble();
    }

    public double calculate(double u,int n){
        double tmp=u;
        for(int i=1; i<n; i++){
            tmp=tmp*(u+i);
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
            for(int j=n-1;j>=i;j--){
                rate[j][i] =rate[j][i-1]-rate[j-1][i-1];
        } 
    }
    //printing the forward difference table
    // System.out.println("The forward difference table");
    //  for(int i=1;i<n;i++){
    //         System.out.println(x[i]+"  ");
    //         for(int j=0;j<n-i;j++){
    //            System.out.println(y[i][j]+"    ");                   
    //     } 
    //     System.out.println();
    // }

    //Calculating the sum
    sum=rate[n-1][0];
    u=(search_value-year[n-1])/(year[1]-year[0]);

    for(int i=1;i<n;i++){
        sum=sum+(calculate(u,i)*rate[n-1][i])/factorial(i);
    }

    System.out.println("Population in millions at year"+search_value+" is"+sum);
}

    public static void main(String[] args) {
        
        newton_backward obj=new newton_backward();
        obj.getData();
        obj.calculateDifference();
        
    }
}
