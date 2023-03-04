# lab3
Input.java, Output.java defining single inputs and outputs to a transaction. Input
has an extra field for the signature of a transaction.

InputUnsigned.java is as Input.java, but omitting the signature. It is used in order
to create the message to be signed and compute using a wallet the signature, and with
this signature we obtain a Input.

InputList.java, OutputList.java, defining the list of inputs and outputs of a trans-
action.

PublicKeyMap.java maintains a map between usernames (given as strings) and public
keys. It has both a map from names to public keys, and one from public keys to names.
This map is mainly used for convenience, since is difficult to deal manually with public
keys.

Wallet.java is a wallet containing for keynames public and private keys. Only the
originator of those keys should have access to it.

SampleWallet.java allows to define a Wallet from a given list of keynames by creating
random public and private key pairs.

SigData.java provides function to organise the creation of message to be signed. For
a transaction, the message to be signed will consist of the input given by a user (public
key) and the amount, and then the list of outputs given by public keys and amounts.

This message is returned by the method getMessageToSign of InputUnsigned.java

The class Transaction.java defines transactions, UserAmount.java a map from pub-
lic keys to amounts, and Ledger.java, which extends UserAmount defines the account
balance of a ledger at a given time.

Crypto.java provides convenience methods for verifying signatures and singing mes-
sages.

KeyUtils.java provides some helper functions for dealing with private keys, signa-
tures, and messages.

In LabUtils two more classes are defined for dealing with public private keys.
The tasks are as follows (the methods mentioned are set in case of return value Boolean
to always true, so that the code compiles – those return values need to be replaced by the
correct values):

Task 1: Define in Input.java the method checkSignature(outList). You can
used the checkSignature method of InputUnsigned.java and the constructor of
InputUnsigned.java which uses as argument an element of Input.
(3 marks + 1 mark for sign off)

Task 2: Define in InputList.java the method checkSignature(outList). You can
refer to your solution of Task 1.
(3 marks + 1 mark for sign off)

2
Task 3: Define in Transaction.java the method checkSignaturesValid() which
checks whether the signatures in the transaction are correct. It should check for each
input whether the signature is correct w.r.t. the outputs of that transaction.
(3 marks + 1 mark for sign off)

Task 4: Define in UserAmount.java the method checkDeductableFromLedger. This
is similar to your solution for lab 2.
(2 marks + 1 mark for sign off)

Task 5: Define in InputList.java the method checkDeductableFromLedger. This
is similar to your solution for lab 2, and done by converting the inputs into an element
of UserAmount.
(2 marks + 1 mark for sign off)

Task 6: Define in InputList.java the method subtractFromLedger. This is similar
to your solution for lab 2, and only deduct if it is deductible.
(1 mark + 0.5 mark for sign off)

Task 7: Define in OutputList.java the method addToLedger. This is similar to your
solution for lab 2.

(1 mark + 0.5 marks for sign off)
Task 8: Define in Ledger.java the method checkTransactionValid.
This is similar to your solution for lab 2, but should check as well whether the signatures
are valid.

(2 marks + 1 mark for sign off)
Task 9: Define in Ledger.java the method processTransaction.

This is similar to your solution for lab 2.
(2 marks + 1 mark for sign off)

Task 10: Your last task is to create a test case in Ledger.java, where you can test
the following scenario.
(6 marks + 2 marks for sign off)


For each step you should print a header explaining what step has been taken, print
the results of any checks done, and the result of the resulting ledger (if it has changed):
– Create a sample wallet for Alice containing keys with names A1, A2; a (separate)
sample wallet for Bob containing keynames B1, B2; one for Carol containing
keynames C1, C2, C3; and one for David containing keyname D1 by using the
method generate of SampleWallet.


Note that the keys in those wallets need to be separate, otherwise one user could
use the keys of others.



– Print out the wallet for Alice (you don’t need to print out the ones from Bob,
Carol, David, otherwise the output would become a bit too long).
3

– Compute the PublicKeyMap containing the public keys of all these wallets. The
PublicKeyMap is for convenience, since comparing public keys is cumbersome, it
makes it easier to create transaction outputs.
– Print out the resulting PublicKeyMap.
– Create an empty Ledger and add to it the public keys for the keynames of the
wallets created before initialised with the amount 0 for each key.
– Set the balance for A1 to 40.
– Add 15 to the balance for B1.
– Add 5 to the balance for A2
– Subtract 15 from the balance for B1.
– Set the balance for C1 to 10.
– Check whether the InputList inList1 giving A1 40 units, and C1 10 units (with
sample signatures used) can be deducted.
– Check whether the InputList inList2 giving A1 25 units, and giving A1 again
25 units (with sample signatures used) can be deducted.
– Deduct inList1 from the Ledger.
– Create a OutputList corresponding to inList2 which gives A1 twice 25 Units,
and add it to the Ledger.
– Create a correctly signed input, where A1 is spending 50, referring to an output
list giving B2 20 and C3 30. The output list is needed in order to create the
message to be signed (consisting of A1 spending 50, B2 receiving 20 and C3
receiving 30). Check whether the signature is valid for this signed input. Use the
wallet for Alice to create the signatures.
– Create a wrongly signed input, which gives A1 50, and uses instead of the correctly
created signature an example signature (example signatures are provided in the
code). Check whether the signature is valid for this signed input, and the same
output as before.
– Create a transaction tx1 which takes as input for A1 50 units and gives B1 20,
B2 20, and C2 10.
– Check whether the signature is approved for the transaction input.
– Now check whether the complete transaction is valid (which will check again the
validity of the signature). Then update the Ledger using that transaction.
– Create a transaction tx2 which takes as inputs from B2 20, C2 10, and as outputs
given C3 10 and D1 20.
– Check whether the signature is approved for the transaction input, and then
whether the transaction is valid (which includes a check for the signature). Then
update the Ledger using that transaction.
