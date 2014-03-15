This project is being used to demonstrate a problem I am seeing with the
multi-tenant-single-db plugin.

See https://github.com/multi-tenant/grails-multi-tenant-single-db/issues/37

Steps to reproduce:
1 Run this project
2 Click on the "CustomerTagController"
3 create a new Customer Tag - perhaps "VIP" or whatever, and save it.
4 Now, create another customer tag with exactly the same name, and TRY to save it. I get a 500 error.

Repeat the steps above with the "TagController"  - the validation error is correctly reported.

Putting a break point in the save method of CusomterController, you will see that

if (customerTagTypeInstance.hasErrors()) {

Always returns false.

Does anyone know what I can do to get hasErrors() report the correct validation errors?

