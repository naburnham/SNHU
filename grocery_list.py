# Initializes a dictionary set to grocery_item variable
grocery_item = {}

# Initializes a list to hold dictionary values
grocery_history = []

choice = 'c'

# While user does not enter 'q', loops through to retrieve inputs of groceries
while choice != 'q':

    # Each of these adds a key/value pair to the grocery_item for each input as it loops through in the initial while loop
    # On each successive iteration of the loop, this section modifies the originally set values inputted by the user
    # .strip() removes any unneeded whitespace entered around item's name
    grocery_item['name'] = input('Item name:\n').strip()
    grocery_item['number'] = int(input('Quantity purchased:\n'))
    grocery_item['price'] = float(input('Price per item:\n'))

    # .copy() makes a shallow copy of the dictionary to the list
    # Using .copy() prevents the reference pointer of the list and dictionary from being the same,
    # and prevents the list from updating every time the dictionary is modified
    
    # Adds grocery_item dictionary to the grocery_history list
    grocery_history.append(grocery_item.copy())
    
    choice = input('Would you like to enter another item?\nType \'c\' for continue or \'q\' to quit:\n').strip().lower()

grand_total = 0

# for each item in grocery_history list, sums item_total, then adds item_total to grand_total, 
# then prints item_history
for item in grocery_history:
    # As I loop through, I access each item within the list
    # To set item_total, use keys of each dictionary item in the list to access the quantity 
    # and price to determine the total individual item price
    item_total = item['number'] * item['price']
    grand_total += item_total

    print('{0} {1} @ ${2} ea ${3}'.format(item['number'], item['name'], item['price'], item_total))

# {0:.02f} ensures a 2 digit float is printed for the grand total
print('Grand total: ${0:.02f}'.format(grand_total))

# In this code I do not modify a value directly in a list, nor do I use an index-based for loop.