String ans="";int answer=0;boolean flag=false,num=false;
    if(x!=0){
    if(x<0){ flag=true;x*=-1;}
    while(x>0){
      if(x%10!=0) num=true;
      if(num){
        ans+=Integer.toString(x%10);
      }
       x=x/10; 
    }
    answer=Integer.parseInt(ans);
    if(flag) answer*=-1;
  }
    return answer;