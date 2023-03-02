package lab3;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.InvalidKeyException;


/** 
 *   Ledger defines an ledger in the ledger model of bitcoins
 *     it extends UserAmount
 */

public class Ledger extends UserAmount {




   
    /** 
     *
     *  Task 8 Check a transaction is valid.
     *
     *  this means that 
     *    the sum of outputs is less than or equal the sum of inputs
     *    all signatures are valid
     *    and the inputs can be deducted from the ledger.

     *    This method has been set to true so that the code compiles - that should
     *    be changed
     */    

    public boolean checkTransactionValid(Transaction tx){
	// to be replaced by the correct code	
	return true;		
    };


    /** 
     * Task 9 Fill in the method processTransaction
     *
     * Process a transaction
     *    by first deducting all the inputs
     *    and then adding all the outputs.
     * Requires that the transaction is valid
     */    
    
    public void processTransaction(Transaction tx){

    };

    
    /** 
     * Prints the current state of the ledger. 
     */

    public void print(PublicKeyMap pubKeyMap) {
	for (PublicKey publicKey : publicKeyList ) {
	    Integer value = getBalance(publicKey);
	    System.out.println("The balance for " +
			       pubKeyMap.getUser(publicKey) + " is " + value); 
	}

    }



    /** 
     * Testcase
     */

    public static void test()
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

	Wallet exampleWallet = SampleWallet.generate(new String[]{ "Alice"});
	byte[] exampleMessage = KeyUtils.integer2ByteArray(1);
	byte[] exampleSignature = exampleWallet.signMessage(exampleMessage,"Alice");


	/***   Task 10
               add  to the test case the test as described in the lab sheet
                
               you can use the above exampleSignature, when a sample signature is needed
	       which cannot be computed from the data.

	**/

               
	
    }

    /** 
     * main function running test cases
     */            

    public static void main(String[] args)
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	Ledger.test();
    }
}
