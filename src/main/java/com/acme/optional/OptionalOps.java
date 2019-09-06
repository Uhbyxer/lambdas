package com.acme.optional;

import com.acme.common.Customer;


import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class OptionalOps {
    public static void main(String[] args) {
        Supplier<Customer> customerSupplier = () -> new Customer("Zed", "Kiutza", 35, "Dr", asList("EUR", "UAH"));
        Optional<Customer> customerOptional = Optional.ofNullable(customerSupplier.get());

        Optional<String> optional = customerOptional
                                    .filter(customer -> customer.getAge() > 17)
                                    .flatMap(OptionalOps::getMainCurrency);
        System.out.println(optional);

        Optional<List<String>> currencies = customerOptional.map(Customer::getCurrencies);
        System.out.println(currencies);
    }

    static Optional<String> getMainCurrency(Customer customer) {
        if (customer.getCurrencies() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(customer.getCurrencies().get(0));
    }
}
