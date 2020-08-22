import sys

#account balance 
account_balance = float(500.25)


#<--------functions go here-------------------->
#printbalance function
def balance():
    print('Your current balance:\n{}'.format(account_balance))

#deposit function
def deposit():
    global account_balance
    deposit_amount = float(input('How much would you like to deposit today?\n'))
    account_balance += deposit_amount
    print('Deposit was ${0:.02f}, current balance is ${1:.02f}'.format(deposit_amount, account_balance))
#withdraw function
def withdraw():
    global account_balance
    withdrawal_amount = float(input('How much would you like to withdraw today?\n'))
    if withdrawal_amount > account_balance:
        print('${0:.02f} is greater that your account balance of ${1:.02f}'.format(withdrawal_amount, account_balance))
    else:
        account_balance -= withdrawal_amount
        print('Withdrawal amount was ${0:.02f}, current balance is ${1:.02f}'.format(withdrawal_amount, account_balance))

#User Input goes here, use if/else conditional statement to call function based on user input

userchoice = input ("What would you like to do?\n")

if (userchoice == 'D'):
    deposit ()
elif (userchoice == 'W'):
    withdraw()
elif (userchoice == 'B'):
    balance()
elif (userchoice == 'Q'):
    print('Thank you for banking with us.')
