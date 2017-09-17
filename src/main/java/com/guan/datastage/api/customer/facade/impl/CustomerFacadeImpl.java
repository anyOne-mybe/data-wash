
package com.guan.datastage.api.customer.facade.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.guan.datastage.api.customer.client.IDimensionClient;
import com.guan.datastage.api.customer.domain.Customer;
import com.guan.datastage.api.customer.facade.ICustomerFacade;
import com.guan.datastage.api.customer.service.ICustomerService;
import com.guan.datastage.api.customer.vo.AddResponse;
import com.guan.datastage.commom.util.ExceptionHandler;
import com.guan.datastage.domain.common.ServiceResponse;

@Named
public class CustomerFacadeImpl implements ICustomerFacade
{

    @Inject
    private ICustomerService customerService;

    @Inject
    private IDimensionClient dimensionClient;

    @Override
    public ServiceResponse<AddResponse> addCustomer( Customer customer )
    {
        ServiceResponse<AddResponse> response = new ServiceResponse<>();
        Map<String, String> pa = new HashMap<>();
        pa.put( "name", "xiaolou" );
        pa.put( "namess", "xiaoloudd" );

        String res = dimensionClient.test123( pa );
        System.out.println( res );

        try
        {
            AddResponse data = customerService.addCustomer( customer );
            response.setData( data );
        } catch ( Exception e )
        {
            ExceptionHandler.handleException( response, e );
        }
        return response;
    }

}
