package com.amlane.javaorders.services;

import com.amlane.javaorders.models.Customer;
import com.amlane.javaorders.models.Order;
import com.amlane.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepository custrepos;

    @Autowired
    private AgentService agentService;


    // get all customers
    @Override
    public List<Customer> findAll()
    {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }


    // get customer by ID
    @Override
    public Customer findById(long id) throws EntityNotFoundException
    {
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }


    // post new customer
    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        newCustomer.setAgent(agentService.findById(customer.getAgent().getAgentcode()));

        for(Order o : customer.getOrders())
        {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrddescription()));
        }
        return custrepos.save(newCustomer);

    }

    @Override
    public Customer update(Customer customer, long id)
    {
        Customer currentCust = custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if(customer.getCustname() != null)
        {
            currentCust.setCustname(customer.getCustname());
        }

        if(customer.getCustcity() != null)
        {
            currentCust.setCustcity(customer.getCustcity());
        }

        if(customer.getWorkingarea() != null)
        {
            currentCust.setWorkingarea(customer.getWorkingarea());
        }

        if(customer.getCustcountry() != null)
        {
            currentCust.setCustcountry(customer.getCustcountry());
        }

        if(customer.getGrade() != null)
        {
            currentCust.setGrade(customer.getGrade());
        }

        // double cannot be compared to null

        if(customer.getOpeningamt() != 0)
        {
            currentCust.setOpeningamt(customer.getOpeningamt());
        }

        if(customer.getReceiveamt() != 0)
        {
            currentCust.setReceiveamt(customer.getReceiveamt());
        }

        if(customer.getPaymentamt() != 0)
        {
            currentCust.setPaymentamt(customer.getPaymentamt());
        }

        if(customer.getOutstandingamt() != 0)
        {
            currentCust.setOutstandingamt(customer.getOutstandingamt());
        }

        if(customer.getPhone() != null)
        {
            currentCust.setPhone(customer.getPhone());
        }

        if(customer.getAgent() != null)
        {
            currentCust.setAgent(customer.getAgent());
        }

        if(customer.getOrders().size() > 0)
        {
            for(Order o : customer.getOrders())
            {
                currentCust.getOrders().add(new Order(o.getOrdamount(),
                        o.getAdvanceamount(), currentCust, o.getOrddescription()));
            }
        }

        return custrepos.save(currentCust);
    }

    @Override
    public void delete(long id)
    {

    }
}
