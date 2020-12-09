import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseInt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list=new ArrayList<String>();//ÓÃÓÚ´æ·ÅËùÓÐµÄÏûÏ¢
		int countmessage=0;//ÓÃÓÚ³ÌÐòÍË³öÕªÒªÊ±Í³¼ÆËÑË÷´ÎÊý
		int countword=0;//ÓÃÓÚ³ÌÐòÍË³öÕªÒªÊ±Í³¼ÆÆ¥ÅäµÄµ¥´ÊÊý
		 File fileall=new File("D:/test");//»ñÈ¡Õû¸öÎÄ¼þ¼Ð
		  File[] tempList = fileall.listFiles();//½«Õû¸öÎÄ¼þ¼ÐµÄÎÄ¼þ·Åµ½Êý×éÖÐ
		  for (int i = 0; i < tempList.length; i++) //±éÀúÎÄ¼þ¼ÐµÄËùÓÐÎÄ¼þ
		  {
			   if (tempList[i].isFile()) {//ÅÐ¶ÏÎªÎÄ¼þ ¶ø²»ÊÇÎÄ¼þ¼Ð
					
					 try{
				            BufferedReader br = new BufferedReader(new FileReader(tempList[i]));//¹¹ÔìÒ»¸öBufferedReaderÀàÀ´¶ÁÈ¡ÎÄ¼þ
				            String s = null;
				            while((s = br.readLine())!=null){//Ê¹ÓÃreadLine·½·¨£¬Ò»´Î¶ÁÒ»ÐÐ
				            	list.add(s);//Ìí¼Óµ½list¼¯ºÏÀïÃæ
				            }
				            br.close();    //¹Ø±ÕBufferedReader
				        }catch(Exception e){
				            e.printStackTrace();
				        }
			
				   
			   }
		  }

		 System.out.println("Read the completed data,,.");//
		 for(;;)
		 {int flag=0;//ÅÐ¶ÏÊÇ·ñÕÒµ½µ¥´Ê
			 System.out.println(" please enter the word you want to search or enter -1 to exit the program");
		 Scanner x=new Scanner(System.in);//¼üÅÌ½ÓÊÜÊäÈë
		 String input=x.nextLine();
		 if(input.equals("-1"))//Èç¹ûÊäÈëÎª-1 ÔòÍË³ö³ÌÐò
		 {
			 
			 System.out.println("countmessage:"+countmessage);
			 System.out.println("countword:"+countword);
			 System.out.println("Exit successfully");
			 break;
		 }
		 else//Èç¹ûÊäÈëÎªµ¥´Ê
		 {
		  int i=0;
		 for(i=0;i<list.size();i++)//±éÀú¼¯ºÏ
		 {
			 countmessage++;//ËÑË÷´ÎÊý++
			 if(list.get(i).contains(input))
			 {    flag=1;
				 System.out.println("message£º"+list.get(i).toUpperCase());//×ª»»´óÐ¡Ð´
				countword++;//Æ¥Åäµ¥´ÊÊý++
			 }
			 
			 
		 }
		 if(flag==0)
		 {
			 System.out.println("not found");
		 }
		
		 	}
		 }
		
		
	}
}
