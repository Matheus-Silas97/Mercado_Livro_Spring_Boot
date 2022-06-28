package com.matheussilas.mercadolivro.controller.request

import com.matheussilas.mercadolivro.model.CustomerModel

data class PostCustomerRequest(

    var name: String,

    var email: String

)