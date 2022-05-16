package com.example.major.ewallet;


/**
 *
 *
 *
 * Ewallet
 *
 *
 *      -----> Entities / Actor
 *
 *      USER --- userMicroservice independently
 *      (user to List<user> friends)
 *
 *      Transaction (Ledger) -
 *      WALLET
 *      NOTIFICATION
 *      PROMOTION (VOUCHERS)
 *
 *
 *
 *      INVOICE - scheduled things like monthly transaction history
 *
 *
 *
 *      WALLET SUPERSET= SAVING ACCOUNT [{  SAVING ACCOUNT , LOAN ACCOUNT , CREDIT CARD etc }]
 *      NOTIFICATION - EMAIL, sms - AWS service (feel free to add whatssapp, sms , or other things)
 *
 *     use case  ewallet:
 *          ---> user account creation
 *          --> history (payemnt transactions)
 *          --> make a payment - notification (Credit)
 *          --> send money from wallet a to wallet b
 *
 *
 *
 *
 *    --> use case :
 *      Whenever user is created
 *              ---> send a notification (User Account Creation success)
 *              --> topup the user wallet with 10 amount
 *
 *
 *              > for wallet topup / spent --> there should be a transaction
 *
 *              --> a transaction would be created in a pending state
 *                          --> then you wallet would be toppped up
 *                                  --> pending transaction would be marked success
 *
 *
 *      ----> PRODUCER (USER SERVICE) -----> instaclustr <-------- NOTIFICIATION SERVICE (CONSUMER)
 *
 *
 *      ---> USER CREATED --(USER_CREATION) (DONE)
 *                 (USER_CREATION) ----> SEND NOTIFICATION  (DONE)
 *                 (USER_CREATION) --->CREATE WALLET (DONE)
 *                                                      --------------> WALLET_CREATED
 *
 *
 *             When wallet has been successfully created
 *                               --> CREATE ACCOUNTING / LEDGER/ TRANSACTION () IN PENDING (DONE)   ----> TRANSACTION_CREATION
 *                                          ---> UPDATE WALLET BALANCE
 *                                 ---> MAKE TRANSACTION SUCCESS --------------> TRANSACTION_CLOSURE
 *                                              ---> SEND NOTIFICATION THAT WALLET HAS BEEN UPDATED
 *
 *
 *
 *
 *
 *          When you would transfer money ---> the below block would always happen
                     --> CREATE ACCOUNTING / LEDGER/ TRANSACTION () IN PENDING (DONE)
 *                                          ---> UPDATE WALLET BALANCE-----_> WALLET_UPDATED
 *                                 ---> MAKE TRANSACTION SUCCESS
 *                                              ---> SEND NOTIFICATION THAT WALLET HAS BEEN UPDATED
 * *
 *
 *
 * System transfer / System topup.
 *
 *
 *
 *          ----- SEND MONEY FROM ONE PERSON TO ANOTHER
 *
 *
 *
 */