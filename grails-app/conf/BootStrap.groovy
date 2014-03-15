import com.yourapp.Customer

class BootStrap {

    def init = { servletContext ->

        Customer.get(1)?: new Customer(name: "Customer 1").save(failOnError: true)
    }

    def destroy = {
    }
}
