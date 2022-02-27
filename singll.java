
    import java.util.Scanner;

public  class singll
{
     static class node
    {

        int data;
        node next;
        node(int data)
        {
            this.data=data;
        }
    }
   static node head=null;
     static node tail=null;
    public static void add(int x)
    {

        node n = new node(x);
        if(head==null)
            head=tail=n;
        else
        {
            tail.next=n;
            tail=n;
        }


    }
    public void display() {
      node temp = head;
      System.out.println("node are");
      while(temp!=null)
      {
          System.out.println(temp.data);
          temp=temp.next;
      }
    }
    public void atbeg(int x)
    {
        node n = new node(x);
        n.next=head;
        head=n;
    }
    public void atend(int x)
    {
        node n = new node(x);
        node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=n;
    }
    public void atpos(int pos,int x)
    {
        node n = new node(x);
        if(head==null) {
            if (pos > 1)
                System.out.println("invalid");

            else
                head = n;
        }
        else if(pos>count()+1)
        {
            System.out.println("invalid");
        }
        else
        {
            node temp =head;
            int c=1;
            while(temp!=null)
            {
                if(c==pos-1)
                {
                    break;
                }
                c++;
                temp=temp.next;
            }
            n.next=temp.next;
            temp.next=n;
        }
    }
    public int count()
    {
        int c=0;
        node temp =head;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }
    public void atbegdel()
    {
        if(head==null)
            return;
        else
            head=head.next;
    }
    public void atenddel()
    {
        if(head==null)
            return;
        else
        {
            node temp= head;
            if(temp.next==null)
            {
                head=null;
            }
            else
            {
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }


    }
    public void atposdel(int pos)
    {
        if(head==null) {
            return;
        }
        else
        {
            if(head.next==null) {
                if (pos != 1) {
                    System.out.println("invalid");
                } else {
                    head = null;
                }
            }
            else
                {
                    int c=1;
                    if(pos>count()+1)
                    {
                        System.out.println("invalid");
                    }
                    else
                    {
                        node temp=head;
                        while(temp!=null)
                        {
                            if(c==pos-1)
                            {
                                break;
                            }
                            c++;
                            temp=temp.next;
                        }
                        assert temp != null;
                    }
                }
            }
        }

    public static void main(String[] args)
    {
        singll obj = new singll();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total no. of elements");
        int m = sc.nextInt();
        System.out.println("Enter the data");
        for (int i = 0; i < m; i++)
            add(sc.nextInt());
        obj.display();
        int ans1;
        do {


            System.out.println("Enter your choice\n1-insertion\n2-deletion");
            int q = sc.nextInt();
            if (q == 1) {
                int ans;
                do {


                    System.out.println("enter the data for insertion");
                    int n1 = sc.nextInt();
                    System.out.println("enter your choice\n1-at beg\n2-at end\n3- at position");
                    int n2 = sc.nextInt();
                    switch (n2) {
                        case 1:
                            obj.atbeg(n1);
                            break;
                        case 2:
                            obj.atend(n1);
                            break;
                        case 3:
                            System.out.println("enter the node position");
                            int pos = sc.nextInt();
                            obj.atpos(pos, n1);
                            break;
                        default:
                            System.out.println("enter correct choice");
                    }
                    System.out.println("do you want to continue\nenter 1 for yes\n enter 0 for no");
                    ans = sc.nextInt();
                } while (ans == 1);
                obj.display();
            } else if (q == 2) {
                int ans;
                do {


                    System.out.println("enter your choice\n1-at beg\n2-at end\n3- at position");
                    int n4 = sc.nextInt();
                    switch (n4) {
                        case 1:
                            obj.atbegdel();
                            break;
                        case 2:
                            obj.atenddel();
                            break;
                        case 3:
                            System.out.println("enter the node position");
                            int pos = sc.nextInt();
                            obj.atposdel(pos);
                            break;
                        default:
                            System.out.println("enter correct choice");
                    }
                    System.out.println("do you want to continue\n 1 for yes \n0 for no");
                    ans = sc.nextInt();
                } while (ans == 1);
                obj.display();
            } else {
                System.out.println("invalid choice");
            }
            System.out.println("do you want to continue \n1-yes\n0-no");
            ans1=sc.nextInt();
        }while(ans1==1);
        obj.display();
    }
}


    

