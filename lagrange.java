import java.util.Scanner;
public class lagrange {
   int n;
   double year[]=new double[15];
    double rate[]=new double[15];
    double d[]=new double[15];
    double a[][]=new double[15][15];
    double search_value,u,s;
    void getData(){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of the data");
        n=sc.nextInt();
        System.out.println("Enter the population year");
        for(int i=0; i<n; i++){
            year[i]=sc.nextDouble();
        }
        System.out.println("Enter the population as per the respective year in terms of millions");
        for(int i=0; i<n; i++){
            rate[i]=sc.nextDouble();
        }
        System.out.println("Enter the value of interpolation");
        search_value=sc.nextDouble();
    }

    void interpolation(){
        u=1.0;
        s=0.0;

        //lagrange interpolation
        for(int i=1; i<n; i++){
            d[i]=1.0;
            for(int j=1; j<n; j++){
                if(j==i){
                    a[i][j]=search_value-year[j];
                }
                else{
                    a[i][j]=year[i]-year[j];
                }
                d[i]=d[i]*a[i][j];
            }
            s=s+rate[i]/d[i];
            u=u*a[i][i];

        }
        System.out.println("Population in millions at year("+search_value+")="+u*s);
    }

    public static void main(String[] args){
        lagrange obj=new lagrange();
        obj.getData();
        obj.interpolation();
    }
}
