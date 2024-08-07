import java.util.Scanner;

public class CRCcode
{
	public static boolean[] rem = new boolean[100];
	public static void xorOper(boolean[] temp, boolean[] g, int fs, int gs)
	{
		int j;
		int k;
		int i;
		for (i = 0;i < fs;i++)
		{
			j = 0;
			k = i;
			//check whether it is divisible or not
			if ((temp[k]==true&&g[k]==false)||(temp[k]==true&&g[k]==true))
			{
				for (j = 0,k = i;j < gs;j++,k++)
				{
					if ((temp[k] == true && g[j] == true) || (temp[k] == false && g[j] == false))
						temp[k] = false;
					else
						temp[k] = true;
				}
			}
		}
	}
	public static void main(String[] args)
	{
		 int i;
		 int j;
		//Get Frame
		int fs;
		System.out.print("\n Enter Frame size: ");
		Scanner sc= new Scanner(System.in);
		fs=sc.nextInt();
		boolean[] f = new boolean[100];
		System.out.print("\n Enter Frame:");
		for (i = 0;i < fs;i++)
		{
			int temp=sc.nextInt();
			if(temp==1)
				f[i]=true;
			else
				f[i]=false;
		}
		//Get Generator
		System.out.print("\n Enter Generator size: ");
		Scanner s= new Scanner(System.in);
		int gs=s.nextInt();
		boolean[] g = new boolean[100];
		System.out.print("\n Enter Generator:");
		for (i = 0;i < gs;i++)
		{
			int temp=sc.nextInt();
			if(temp==1)
				g[i]=true;
			else
				g[i]=false;
		}
		System.out.print("\n Sender Side:");
		System.out.print("\n Frame: ");
		Scanner sca= new Scanner(System.in);
		for (i = 0;i < fs;i++)
		{
			if(f[i]==true)
				System.out.print(1);
			else
			   System.out.print(0);
		}
		System.out.print("\n Generator :");
		for (i = 0;i < gs;i++)
		{
			if(g[i]==true)
				System.out.print(1);
			else
			   System.out.print(0);
		}
		//Append 0's
		int rs = gs - 1;
		System.out.print("\n Number of 0's to be appended: ");
		System.out.print(rs);
		for (i = fs;i < fs + rs;i++)
			f[i] = false;
		boolean[] temp = new boolean[100];
		for (i = 0;i < 100;i++)
			temp[i] = f[i];
		System.out.print("\n Message after appending 0's :");
		for (i = 0; i < fs + rs;i++)
		{
			if(temp[i]==true)
			System.out.print(1);
			else
				System.out.print(0);
		}
		//xor operation on two bool arrays
		xorOper(temp, g, fs, gs);
			//remainder
		for (i = 0,j = fs;i < rs;i++,j++)
			rem[i] = temp[j];
	System.out.print("The CRC is= ");
	   for ( i = 0;i < rs;i++)
	   {	if(rem[i]==true)
		       System.out.print(1);
	   		else
	   			System.out.print(0);

	   }
		System.out.print("\n");
		System.out.print("\n Transmitted Frame: ");
		boolean[] tf = new boolean[150];
		for (i = 0;i < fs;i++)
			tf[i] = f[i];
		for (i = fs,j = 0;i < fs + rs;i++,j++)
			tf[i] = rem[j];
		for (i = 0;i < fs + rs;i++)
		{
			if(tf[i]==true)
				System.out.print(1);
			else
				System.out.print(0);
		}
		System.out.print("\n Receiver side : ");
		System.out.print("\n Enter the Frame size : ");
		Scanner scat=new Scanner(System.in);
		int fr =scat.nextInt();
		boolean[] a = new boolean[fr];
		if (fs + rs != fr)
		{
			System.out.print("Error in Transmission ");
			System.exit(1);
		}
		System.out.print("Enter the Receiver frame: ");
		for (i = 0;i < fs + rs;i++)
		{
			int tem=scat.nextInt();
			if(tem==1)
				a[i]=true;
			else
				a[i]=false;
		}
		for (i = 0;i < fs + rs;i++)
			temp[i] = a[i];
			xorOper(temp, g, fs, gs);
			System.out.print("Remainder: ");
		boolean[] rrem = new boolean[100];
		for (i = fs,j = 0;i < fs + rs;i++,j++)
			rrem[j] = temp[i];
		for (i = 0;i < rs;i++)
		{	if(rrem[i]==true)
				System.out.print(1);
		    else
		    	System.out.print(0);
		}
		int flag = 0;
		for (i = 0; i<rs ;i++)
		{
			if (rrem[i] != false)
			{
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.print("\n Since Remainder Is 0 Hence Message Transmitted From Sender To Receiver Is Correct");
		else
			System.out.print("\n Since Remainder Is Not 0 Hence Message Transmitted From Sender To Receiver Contains Error");
	}
}