public class BowlingGame {

    public int getBowlingScore(String s) {
        int[] a=new int[30],b=new int[30];
        int p=0,ball=0,frame=0,res=0;
        b[frame++]=0;
        while(p<s.length())
        {
            char c=s.charAt(p);
            if(c=='X')
            {
                a[ball++]=10;
            }
            else if(c=='/')
            {
                a[ball++]=res;
            }
            else if(c<='9'&&c>='0')
            {
                res=10-(c-'0');
                a[ball++]=c-'0';
            }
            else if(c=='-')
            {
                res=10;
                a[ball++]=0;
            }
            else if(c=='|')
            {
                b[frame++]=ball;
            }
            p++;
        }
        int ans=0;
        for(int i=0;i<10;i++)
        {
            int sum=0,cnt=0;
            int p1=b[i],p2=b[i+1];
            while(p1<p2)
            {
                sum+=a[p1++];
                cnt++;
            }
            if(sum==10&&cnt==1)
                sum+=a[p2]+a[p2+1];
            if(sum==10&&cnt==2)
                sum+=a[p2];
            ans+=sum;
        }
        return ans;
    }
}