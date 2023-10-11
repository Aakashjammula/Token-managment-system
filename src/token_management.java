import java.util.Scanner;
class token_managment  
{ 
   private int arr[];  
   private int front;  
   private int rear;  
   private int size;  
      
    public token_managment(int size)  
    {   
        arr = new int[size];  
        front = -1;  
        rear = -1;  
        this.size = size;  
    }  
   public boolean isFull()  
    {  
        return ((front == 0)&&(rear == size-1)&&(front == rear+1));  
    }  
   public boolean isEmpty ()  
    {  
        return (front == -1);  
    }   
    public void insertfront(int key)  
    {  
        if (isFull())  
        {  
            System.out.println("Overflow");  
            return;  
        }  
        if (front == -1)  
        {  
            front = 0;  
            rear = 0;  
        }  
        else if (front == 0 && rear==0){ 
            front = size - 1 ;  
            arr[front] = key ;  
        }
        else{
            front = front - 1;  
            arr[front] = key;  
        }
    }  

   public void insertrear(int key)  
    {  
        if (isFull())  
        {  
            System.out.println(" Overflow ");  
            return;  
        }  

        if (front == -1)  
        {  
            front = 0;  
            rear = 0;
            arr[rear] = key;  
        }  
 
        else if (rear == size-1)  {
            rear = 0;  
     }
         else{  
            rear = rear+1;   
        arr[rear] = key ;  
    }
    }  
   public void deletefront()  
    {  
  
        if (isEmpty())  
        {  
            System.out.println("Queue Underflow\n");   
        }  

        if (front == rear)  
        {  
            front = -1;  
            rear = -1;  
        }  
        else{ 
  
            if (front == size -1)  
                front = 0;  
  
            else   
                front = front+1;  
    }  
}
 
   public void deleterear()  
    {  
        if (isEmpty())  
        {  
            System.out.println(" Underflow");  
        } 
  
        if (front == rear)  
        {  
            front = -1;  
            rear = -1;  
        }  
        else if (rear == 0)  
            rear = size-1;  
        else  
            rear = rear-1; 
            
    }    
    public int getFront()  
    {  

        if (isEmpty())  
        {  
            System.out.println(" Underflow");  
            return -1 ;  
        }  
        return arr[front];  
    }  
  
    public int getRear()  
    {  
   
        if(isEmpty() || rear < 0)  
        {  
            System.out.println(" Underflow\n");  
            return -1 ;  
        }  
        return arr[rear];  
    }  
  
   public void printDeque(){  
        for (int o :arr){  
            if (o != 0)  
                System.out.print(o + " ");  
        }  
        System.out.println();  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the deque");
        int size = sc.nextInt();
        token_managment token = new token_managment(size);
        token_managment pending= new token_managment(size);
        System.out.println("Enter the token no's. ");
        for(int i=0;i<size;i++){
            int temp=sc.nextInt();
            token.insertrear(temp);
        }
        for(int i=0;i<token.rear+1;i++){
            System.out.println(token.arr[i]);
        }
        for(int i=0;i<pending.rear+1;i++){
            System.out.println(pending.arr[i]);
        }
        int c=1;
        while(c==1){
        System.out.println("Select any of the following options");
        System.out.println("1.assign a token");
        System.out.println("2.freeup a token");
        int opt = sc.nextInt();
        if(opt==1){
            int current=token.getRear();
            token.deleterear();
            pending.insertrear(current);
            }
        if(opt==2){
            System.out.println("Enter the token of the customer whose order was delivered");
            int left = sc.nextInt();
            int tep[];
            for(int i=pending.front;i<pending.rear+1;i++){
                if(pending.arr[i]==left){
                    if(i==pending.front){
                        pending.deletefront();
                        token.insertrear(left);
                    }else{
                    tep = new int[pending.rear];
                    for(int j=pending.front;j<pending.rear+1;j++){
                        if(j<i){
                        int transfer=pending.getFront();
                        pending.deletefront();
                        tep[j] = transfer;
                       }else if(j==i){
                            pending.deletefront();
                            token.insertrear(left);
                       }else{
                            int transfer=pending.getFront();
                            pending.deletefront();
                            tep[j-1] = transfer;
                       }
                    }
                    for(int k=0;k<tep.length;k++){
                        pending.insertrear(tep[k]);
                    }
                    }
                }
    
                }
            }
        if(!(token.front==-1)){
        System.out.println("The token no's available are");
        for(int i=token.front;i<token.rear+1;i++){
            System.out.println(token.arr[i]);
        }
        }
        if(!(pending.front==-1)){
        System.out.println("The token no's pending are");
        for(int i=pending.front;i<pending.rear+1;i++){
            System.out.println(pending.arr[i]);
        }
    }
        System.out.println("Do you want to continue?(1/0)");
        c=sc.nextInt();
        
    }
    }
}
