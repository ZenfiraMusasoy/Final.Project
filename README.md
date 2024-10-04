## Author: Zenfira Musasoy

# Project  [iTickets.az](https://iticket.az/ru/) - e-commerce application about tickets selling and audio products

# Used libraries
Project was developed using libraries like Selenium, TestNG & REST Assured

# Project structure:
## UI tests:
UI tests based on Selenium & TestNG
* SearchTests - I have written UI test for testing search functionality.
  * search method opens the search input field
  * enters a search query
  * verifies the presence of the search input field 
* CartTests - I have written UI test for testing cart functionalities like: 
  * add product to the cart
  * check whether the products was successfully added to the cart & etc.
* SignInTests - I have written UI test for testing sign in functionality.
  * automates the login process to ensure that users can sign in correctly with their credentials
* SignUpTests - I have written UI test for testing sign up functionality.
  * automates the user registration process
  * ensuring that all required fields are filled in correctly and the form is successfully submitted

## API tests
API tests based on REST Assured
For this purpose I have learned the applications internal REST API structure using browser console.
* SignInTests - used to test the authentication API of iticket.az
* SignUpTests - validate the registration API of iticket.az