package bankaccount;

	public class Account2 {
	    int accountBalance;
	    
	    public Account2(int amout){
	        if (amout >= 0){
	            accountBalance = amout;
	            System.out.println("Initial account balance : " + accountBalance);
	         }
	        else{   
	            accountBalance = 0;
	            System.err.println("Invalid account balance");
	            System.out.println("Initial account balance : " + accountBalance);
	        }       
	    }

	    public void creditAmount(int amount){
	        if (amount <0){ 
	            System.err.println("Invalid");
	         }
	        else{
	            accountBalance += amount;
	        }
	    }

	    public void debitAmount(int amount){
	        if (amount > accountBalance){
	            System.err.println("Debit amount exceed account balance");
	        }
	        else{
	            accountBalance -= amount;
	        }
	    }

	    public int getBalance(){
	        return accountBalance;
	    }

	    public static void main(String[] args) {
	        System.out.println("Account obj 1 \n");
	        Account bk = new Account(50000);
	        bk.creditAmount(2500);
	        bk.debitAmount(900);
	        System.out.println("Account balance :" + bk.getBalance());
	        
	        System.out.println("\nAccount obj 2\n");
	        
	        Account bk2 = new Account(3000);
	        bk2.creditAmount(2700);
	        bk2.debitAmount(5700);
	        System.out.println("Account balance :" + bk2.getBalance());
	        
	        
	        System.out.println("\nAccount obj 3\n");
	        
	        Account bk3 = new Account(3000);
	        bk3.creditAmount(2700);
	        bk3.debitAmount(5788);
	        System.out.println("Account balance : " + bk3.getBalance());
	      	
	    }
	    
	}


