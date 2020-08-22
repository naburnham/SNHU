# Assigns string to variable rentalCode
# Only example in this code that assigns a string to a variable
rentalCode = input("(B)udget, (D)aily, or (W)eekly rental?\n")

# Using data-operator 'or' to check if variable rentalCode is \
# equal to either 'b' or 'd' to use correct prompt in setting \
# the rentalPeriod variable.
if (rentalCode.lower() == 'b') or (rentalCode.lower() == 'd'):
  rentalPeriod = int(input("Number of Days Rented:\n"))
else:
  rentalPeriod = int(input("Number of Weeks Rented:\n"))

budget_charge = 40.00
daily_charge = 60.00
weekly_charge = 190.00	

if rentalCode.lower() == 'b':
  baseCharge = rentalPeriod * budget_charge
elif rentalCode.lower() == 'd':
  baseCharge = rentalPeriod * daily_charge
else:
  baseCharge = rentalPeriod * weekly_charge

# Retrieves string inputs of the Odometer Start and End values \
# and converts them in intergers
odoStart = int(input('Starting Odometer Reading:\n'))
odoEnd = int(input('Ending Odometer Reading:\n'))

totalMiles = odoEnd - odoStart

# using if/elif/else block to determine mileCharge for each \
# rental type. If budget rental, then each mile driven cost $0.25 \
# Daily and Weekly rentals have additional nested if/else statements \ 
# to check for a mileage use limit before computing the total \
# mileCharge.
if rentalCode.lower() == 'b':
  mileCharge == totalMiles * 0.25
elif rentalCode.lower() == 'd':
  averageDayMiles = totalMiles / rentalPeriod
  if averageDayMiles <= 100:
    extraMiles = 0
  else:
    extraMiles = averageDayMiles - 100
  mileCharge = extraMiles * 0.25 * rentalPeriod
else:
  averageWeekMiles = totalMiles / rentalPeriod
  if averageWeekMiles <= 900:
    mileCharge = 0.00
  else:
    mileCharge = 100.00 * rentalPeriod

print('Rental Summary')
print('{0:20}{1}'.format('Rental Code:', rentalCode))
print('{0:20}  {1}'.format('Rental Period:', rentalPeriod))
print('{0:20}{1}'.format('Starting Odometer:', odoStart))
print('{0:20}{1}'.format('Ending Odometer:', odoEnd))
print('{0:20}{1}'.format('Miles Driven:', totalMiles))
print('{0:20}${1:.2f}'.format('Amount Due:', baseCharge + mileCharge))
