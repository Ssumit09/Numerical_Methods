import java.util.Scanner;

public class divideddifference {
    
    int n,c1=0,c2=0,j=1;
    double search_value,p=1,s=0;
    double year[]=new double[15];
    double rate[]=new double[15];
    double d[]=new double[15];


    void getData(){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of the data");
        n=sc.nextInt();
        System.out.println("Enter the  year");
        for(int i=0; i<n; i++){
            year[i]=sc.nextDouble();
        }
        System.out.println("Enter  the population as per the respective year in terms of millions");
        for(int i=0; i<n; i++){
            rate[i]=sc.nextDouble();
        }
        System.out.println("Enter the value of interpolation to find");
        search_value=sc.nextDouble();
    }

    void divideDiff(){
        s=rate[0];

        do{
            for(int i=0; i<n-1; i++){
                d[i]=((rate[i+1]-rate[i])/(year[i+j]-year[i]));
                rate[i]=d[i];
            }
            c1=1;
            for(int i=0;i<j;i++){
                c1*=(search_value-year[i]);
            }
            c2+=(rate[0]*c1);
            n--;
            j++;
        }while(n!=1);
        s+=c2;

        System.out.println(" Population at year("+search_value+")="+s);
    }


    public static void main(String[] args){
        divideddifference obj=new divideddifference();
        obj.getData();
        obj.divideDiff();
    }
}
