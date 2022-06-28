package com.matheussilas.mercadolivro.controller

import com.matheussilas.mercadolivro.controller.request.PostCustomerRequest
import com.matheussilas.mercadolivro.controller.request.PutCustomerRequest
import com.matheussilas.mercadolivro.extension.toCustomerModel
import com.matheussilas.mercadolivro.model.CustomerModel
import com.matheussilas.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService) {


    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customerService.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id)
    }

}