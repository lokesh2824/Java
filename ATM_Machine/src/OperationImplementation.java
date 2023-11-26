import java.util.HashMap;
import java.util.Map;

public class OperationImplementation implements OperationsInterface {

    ATM atm = new ATM();
    Map<Double,String> ministmt = new HashMap<>();
    @Override
    public void viewBalance(){
        System.out.println("Balance Avaliable : "+atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount){
        //withdraw amount mustbe in multiples of 500
        if(withdrawAmount%500 == 0){
            if(withdrawAmount <= atm.getBalance()){
                ministmt.put(withdrawAmount,"DBT");
                System.out.println("collect cash: "+withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            }else{
                System.out.println("Insuffient Balance");
            }
        }else{
            System.out.println("Amount must be in multiples of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount ){
        ministmt.put(depositAmount,"CRE");
        System.out.println("Amount Deposited : "+depositAmount);
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement(){
        for (Map.Entry<Double,String> entry : ministmt.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }


}
